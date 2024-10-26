import { Configuration, LeaderboardApi, PlayersApi, ScoresApi, TournamentApi } from './generated';

const config = new Configuration({
  basePath: 'http://localhost:8080'  // or your API base URL
});

// Create API instances
export const leaderboardApi = new LeaderboardApi(config);
export const playersApi = new PlayersApi(config);
export const scoresApi = new ScoresApi(config);
export const tournamentApi = new TournamentApi(config);
