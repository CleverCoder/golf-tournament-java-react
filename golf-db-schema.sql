-- Enable UUID extension
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Enum for Tournament status
CREATE TYPE tournament_status AS ENUM ('PENDING', 'IN_PROGRESS', 'COMPLETED');

-- Tournaments table
CREATE TABLE tournaments (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR(255) NOT NULL,
    status tournament_status NOT NULL DEFAULT 'PENDING',
    course_pars INTEGER[] NOT NULL CHECK (array_length(course_pars, 1) = 18),
    total_par INTEGER NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);


-- Players table
CREATE TABLE players (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR(255) NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- Tournament Players junction table
CREATE TABLE tournament_players (
    tournament_id UUID REFERENCES tournaments(id) ON DELETE CASCADE,
    player_id UUID REFERENCES players(id) ON DELETE CASCADE,
    holes_completed INTEGER DEFAULT 0 CHECK (holes_completed BETWEEN 0 AND 18),
    current_score INTEGER DEFAULT 0,
    relative_to_par INTEGER DEFAULT 0,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (tournament_id, player_id)
);


-- Scores table
CREATE TABLE scores (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    tournament_id UUID NOT NULL,
    player_id UUID NOT NULL,
    hole_number INTEGER NOT NULL CHECK (hole_number BETWEEN 1 AND 18),
    strokes INTEGER NOT NULL CHECK (strokes > 0),
    relative_to_par INTEGER NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (tournament_id, player_id) REFERENCES tournament_players(tournament_id, player_id) ON DELETE CASCADE,
    UNIQUE (tournament_id, player_id, hole_number)
);


-- Indexes
CREATE INDEX idx_tournaments_status ON tournaments(status);
CREATE INDEX idx_scores_tournament ON scores(tournament_id);
CREATE INDEX idx_scores_player ON scores(player_id);
CREATE INDEX idx_scores_hole ON scores(hole_number);
