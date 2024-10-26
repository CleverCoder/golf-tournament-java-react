import { useState, useCallback, useMemo } from 'react';
import { leaderboardApi, playersApi, tournamentApi, scoresApi } from '@/api/client';
import { Tournament, Player, Leaderboard, ScoreSubmission } from '@/api/generated';
import {AxiosError, type RawAxiosRequestConfig} from 'axios';

export function useGolfTournament() {
  const [state, setState] = useState<{
    tournament?: Tournament;
    players: Player[];
    leaderboard?: Leaderboard;
    isLoading: boolean;
    error?: string;
  }>({
    players: [],
    isLoading: false
  });

  // Generic API call wrapper with error handling
  const apiCall = useCallback(
    async <T>(
      operation: (options?: RawAxiosRequestConfig) => Promise<{ data: T }>,
      errorMessage: string,
      treat404AsEmpty = false
    ): Promise<T | undefined> => {
      setState((prev) => ({ ...prev, isLoading: true, error: undefined }));

      try {
        const response = await operation();
        setState((prev) => ({ ...prev, isLoading: false }));
        return response.data;
      } catch (error) {
        const axiosError = error as AxiosError;
        let returnedError: string | undefined;

        if (axiosError.response?.status !== 404 || !treat404AsEmpty) {
          returnedError = errorMessage;
        }

        setState((prev) => ({
          ...prev,
          isLoading: false,
          error: returnedError
        }));

        return undefined;
      }
    },
    []
  );

  // Tournament API operations
  const tournament = useMemo(
    () => ({
      getTournament: () =>
        apiCall(() => tournamentApi.getTournament(), 'Failed to fetch tournament', true),

      createTournament: (coursePars: number[]) =>
        apiCall(() => tournamentApi.createTournament({ coursePars }), 'Failed to create tournament')
    }),
    [apiCall]
  );

  // Players API operations
  const players = useMemo(
    () => ({
      getPlayers: async () => {
        const result = await apiCall(() => playersApi.listPlayers(), 'Failed to fetch players', true);
        if (result) {
          setState((prev) => ({ ...prev, players: result }));
        }
        return result;
      },

      createPlayer: async (name: string) => {
        const result = await apiCall(() => playersApi.createPlayer({ name }), 'Failed to create player');
        if (result) {
          await players.getPlayers(); // Refresh player list after creation
        }
        return result;
      }
    }),
    [apiCall]
  );

  // Leaderboard API operations
  const leaderboard = useMemo(
    () => ({
      getLeaderboard: () =>
        apiCall(() => leaderboardApi.getLeaderboard(), 'Failed to fetch leaderboard', true)
    }),
    [apiCall]
  );

  // Scores API operations
  const scores = useMemo(
    () => ({
      submitScore: async (score: ScoreSubmission) => {
        const result = await apiCall(() => scoresApi.submitScore(score), 'Failed to submit score');
        if (result) {
          await refreshAllData(); // Refresh data after submitting score
        }
        return result;
      }
    }),
    [apiCall]
  );

  // Refresh all data
  const refreshAllData = useCallback(async () => {
    setState((prev) => ({ ...prev, isLoading: true, error: undefined }));

    try {
      const [tournamentData, playersData, leaderboardData] = await Promise.all([
        tournament.getTournament(),
        players.getPlayers(),
        leaderboard.getLeaderboard()
      ]);

      setState((prev) => ({
        ...prev,
        tournament: tournamentData,
        players: playersData ?? [],
        leaderboard: leaderboardData,
        isLoading: false
      }));

      return { tournament: tournamentData, players: playersData, leaderboard: leaderboardData };
    } catch {
      setState((prev) => ({
        ...prev,
        isLoading: false,
        error: 'Failed to refresh tournament data'
      }));
      return undefined;
    }
  }, [tournament, players, leaderboard]);

  // Initialize a new tournament with players
  const initializeTournament = useCallback(
    async (coursePars: number[], initialPlayers: string[]) => {
      const tournamentResult = await tournament.createTournament(coursePars);
      if (tournamentResult) {
        await Promise.all(initialPlayers.map(players.createPlayer));
        await refreshAllData();
      }
      return tournamentResult;
    },
    [tournament, players, refreshAllData]
  );

  return {
    // API methods
    api: {
      tournament: {
        getTournament: tournament.getTournament,
        createTournament: tournament.createTournament
      },
      players: {
        getPlayers: players.getPlayers,
        createPlayer: players.createPlayer
      },
      leaderboard: {
        getLeaderboard: leaderboard.getLeaderboard
      },
      scores
    },
    // State
    tournament: state.tournament,
    players: state.players,
    leaderboard: state.leaderboard,
    isLoading: state.isLoading,
    error: state.error,
    // Actions
    initializeTournament,
    refreshAllData
  };
}
