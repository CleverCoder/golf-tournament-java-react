import React, {useEffect, useState, useCallback} from 'react';
import {Card, CardContent, CardHeader, CardTitle} from '@/components/ui/card';
import {Button} from '@/components/ui/button';
import {Input} from '@/components/ui/input';
import {AlertCircle, Circle, Trophy, Users} from 'lucide-react';
import {Alert, AlertDescription} from '@/components/ui/alert';
import {useGolfTournament} from "@/hooks/useApi";

type TabType = 'tournament' | 'players' | 'scores' | 'leaderboard';

interface ScoreInput {
  playerId: string;
  holeNumber: number;
  strokes: number;
}

const TournamentDashboard = () => {
  const {
    api,  // All API methods
    tournament,  // Tournament state
    players,     // Players state
    leaderboard, // Leaderboard state
    isLoading,
    error,
    initializeTournament,
    refreshAllData
  } = useGolfTournament();

  // UI State
  const [activeTab, setActiveTab] = useState<TabType>('tournament');

  // Form State
  // Initial par values are random between 3 and 5
  const [coursePars, setCoursePars] = useState<number[]>(Array.from({ length: 18}, () => Math.round(((5-3) * Math.random())) + 3));
  const [playerName, setPlayerName] = useState('');
  const [scoreInput, setScoreInput] = useState<ScoreInput>({
    playerId: '',
    holeNumber: 1,
    strokes: 1
  });

  // Initial data load
  useEffect(() => {
    refreshAllData();
  }, []);

  // Handler functions
  const handleCreateTournament = async () => {
    const result = await initializeTournament(coursePars, []);
    if (!result) {
      //
    }
  };

  const handleAddPlayer = async () => {
    const trimmedName = playerName.trim();
    if (!trimmedName) return;

    const result = await api.players.createPlayer(trimmedName);
    if (result) {
      setPlayerName('');
    }
  };

  const handleSubmitScore = async () => {
    if (!scoreInput.playerId) return;

    await api.scores.submitScore(scoreInput);
    setScoreInput(prev => ({...prev, strokes: 1})); // Reset strokes after submission
  };

  const handleParChange = (index: number, value: string) => {
    const newPars = [...coursePars];
    newPars[index] = parseInt(value) || 4;
    setCoursePars(newPars);
  };

  // Tab configuration
  const tabs: Array<{ id: TabType; label: string; icon: React.ReactNode }> = [
    {id: 'tournament', label: 'Tournament', icon: <Circle className="mr-2 h-4 w-4"/>},
    {id: 'players', label: 'Players', icon: <Users className="mr-2 h-4 w-4"/>},
    {id: 'scores', label: 'Submit Scores', icon: <Circle className="mr-2 h-4 w-4"/>},
    {id: 'leaderboard', label: 'Leaderboard', icon: <Trophy className="mr-2 h-4 w-4"/>}
  ];

  return (
    <div className="max-w-4xl mx-auto p-6">
      <h1 className="text-3xl font-bold mb-8">Golf Tournament Manager</h1>

      {error && (
        <Alert variant="destructive" className="mb-4">
          <AlertCircle className="h-4 w-4"/>
          <AlertDescription>{error}</AlertDescription>
        </Alert>
      )}

      <div className="flex gap-2 mb-6">
        {tabs.map(tab => (
          <Button
            key={tab.id}
            variant={activeTab === tab.id ? 'default' : 'outline'}
            onClick={() => setActiveTab(tab.id)}
          >
            {tab.icon}
            {tab.label}
          </Button>
        ))}
      </div>

      <Card>
        <CardHeader>
          <CardTitle>
            {tabs.find(tab => tab.id === activeTab)?.label}
          </CardTitle>
        </CardHeader>
        <CardContent>
          {activeTab === 'tournament' &&
              <div className="space-y-4">
                {!tournament ? (
                  <div className="space-y-4">
                    <div className="grid grid-cols-6 gap-2">
                      {coursePars.map((par, index) => (
                        <div key={index} className="space-y-1">
                          <label className="text-xs">Hole {index + 1}</label>
                          <Input
                            type="number"
                            min="3"
                            max="5"
                            value={par}
                            onChange={(e) => handleParChange(index, e.target.value)}
                            className="w-full"
                          />
                        </div>
                      ))}
                    </div>
                    <Button
                      className="w-full"
                      onClick={handleCreateTournament}
                      disabled={isLoading}
                    >
                      Create Tournament
                    </Button>
                  </div>
                ) : (
                  <div className="space-y-4">
                    <h3 className="text-lg font-semibold">Current Tournament</h3>
                    <div className="grid grid-cols-6 gap-2">
                      {tournament.coursePars?.map((par, index) => (
                        <div key={index} className="p-2 border rounded">
                          <div className="text-xs">Hole {index + 1}</div>
                          <div className="font-semibold">Par {par}</div>
                        </div>
                      ))}
                    </div>
                  </div>
                )}
              </div>
          }
          {activeTab === 'players' &&
              <div className="space-y-4">
                  <div className="flex gap-2">
                      <Input
                          placeholder="Player Name"
                          value={playerName}
                          onChange={(e) => setPlayerName(e.target.value)}
                          onKeyUp={(e) => e.key === 'Enter' && handleAddPlayer()}
                      />
                      <Button
                          onClick={handleAddPlayer}
                          disabled={isLoading || !playerName.trim()}
                      >
                          Add Player
                      </Button>
                  </div>

                  <div className="space-y-2">
                    {players.map((player) => (
                      <div key={player.id} className="p-3 border rounded flex justify-between items-center">
                        <div>
                          <div className="font-semibold">{player.name}</div>
                          <div className="text-sm text-gray-500">
                            Holes completed: {player.holesCompleted}
                          </div>
                        </div>
                        <div className="text-lg font-mono">
                          {player.relativeToPar || 0 > 0 ? '+' : ''}{player.relativeToPar}
                        </div>
                      </div>
                    ))}
                  </div>
              </div>
          }
          {activeTab === 'scores' &&
              <div className="space-y-4">
                  <div className="grid grid-cols-3 gap-2">
                      <div>
                          <label className="text-sm mb-1 block">Player</label>
                          <select
                              className="w-full p-2 border rounded"
                              value={scoreInput.playerId}
                              onChange={(e) => setScoreInput(prev => ({...prev, playerId: e.target.value}))}
                          >
                              <option value="">Select Player</option>
                            {players.map(player => (
                              <option key={player.id} value={player.id}>{player.name}</option>
                            ))}
                          </select>
                      </div>
                      <div>
                          <label className="text-sm mb-1 block">Hole</label>
                          <Input
                              type="number"
                              min="1"
                              max="18"
                              value={scoreInput.holeNumber}
                              onChange={(e) => setScoreInput(prev => ({
                                ...prev,
                                holeNumber: Math.min(18, Math.max(1, parseInt(e.target.value) || 1))
                              }))}
                          />
                      </div>
                      <div>
                          <label className="text-sm mb-1 block">Strokes</label>
                          <Input
                              type="number"
                              min="1"
                              value={scoreInput.strokes}
                              onChange={(e) => setScoreInput(prev => ({
                                ...prev,
                                strokes: Math.max(1, parseInt(e.target.value) || 1)
                              }))}
                          />
                      </div>
                  </div>
                  <Button
                      className="w-full"
                      onClick={handleSubmitScore}
                      disabled={isLoading || !scoreInput.playerId}
                  >
                      Submit Score
                  </Button>
              </div>
          }
          {activeTab === 'leaderboard' &&
              <div className="space-y-4">
                {leaderboard?.players?.length ? (
                  <div>
                    {leaderboard.players.map((entry) => (
                      <div key={entry.playerId} className="p-3 border rounded flex justify-between items-center mb-2">
                        <div className="flex items-center gap-4">
                          <div className="text-lg font-semibold w-8">{entry.position}</div>
                          <div>
                            <div className="font-semibold">{entry.playerName}</div>
                            <div className="text-sm text-gray-500">
                              {entry.holesCompleted} holes completed
                            </div>
                          </div>
                        </div>
                        <div className="text-lg font-mono font-semibold">
                          {entry.relativeToPar || 0 > 0 ? '+' : ''}{entry.relativeToPar}
                        </div>
                      </div>
                    ))}
                  </div>
                ) : (
                  <div className="text-center py-8 text-gray-500">
                    No leaderboard data available
                  </div>
                )
                }
              </div>
          }
        </CardContent>
      </Card>
    </div>
  );
};

export default TournamentDashboard;
