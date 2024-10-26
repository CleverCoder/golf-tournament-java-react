/* tslint:disable */
/* eslint-disable */
/**
 * Golf Tournament API
 * API for managing golf tournament scoring and leaderboard
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


import type { Configuration } from './configuration';
import type { AxiosPromise, AxiosInstance, RawAxiosRequestConfig } from 'axios';
import globalAxios from 'axios';
// Some imports not used depending on template conditions
// @ts-ignore
import { DUMMY_BASE_URL, assertParamExists, setApiKeyToObject, setBasicAuthToObject, setBearerAuthToObject, setOAuthToObject, setSearchParams, serializeDataIfNeeded, toPathString, createRequestFunction } from './common';
import type { RequestArgs } from './base';
// @ts-ignore
import { BASE_PATH, COLLECTION_FORMATS, BaseAPI, RequiredError, operationServerMap } from './base';

/**
 * 
 * @export
 * @interface Leaderboard
 */
export interface Leaderboard {
    /**
     * 
     * @type {string}
     * @memberof Leaderboard
     */
    'lastUpdated'?: string;
    /**
     * 
     * @type {Array<LeaderboardEntry>}
     * @memberof Leaderboard
     */
    'players'?: Array<LeaderboardEntry>;
}
/**
 * 
 * @export
 * @interface LeaderboardEntry
 */
export interface LeaderboardEntry {
    /**
     * 
     * @type {number}
     * @memberof LeaderboardEntry
     */
    'position'?: number;
    /**
     * 
     * @type {string}
     * @memberof LeaderboardEntry
     */
    'playerId'?: string;
    /**
     * 
     * @type {string}
     * @memberof LeaderboardEntry
     */
    'playerName'?: string;
    /**
     * 
     * @type {number}
     * @memberof LeaderboardEntry
     */
    'holesCompleted'?: number;
    /**
     * Score relative to par (\'E\' for even, or +/- number)
     * @type {string}
     * @memberof LeaderboardEntry
     */
    'relativeToPar'?: string;
    /**
     * The total par value of played holes
     * @type {number}
     * @memberof LeaderboardEntry
     */
    'parOfPlayedHoles'?: number;
    /**
     * The current running score for played holes
     * @type {number}
     * @memberof LeaderboardEntry
     */
    'currentScore'?: number;
}
/**
 * 
 * @export
 * @interface Player
 */
export interface Player {
    /**
     * 
     * @type {string}
     * @memberof Player
     */
    'id'?: string;
    /**
     * 
     * @type {string}
     * @memberof Player
     */
    'name'?: string;
    /**
     * 
     * @type {number}
     * @memberof Player
     */
    'holesCompleted'?: number;
    /**
     * Current score relative to par (negative is under par)
     * @type {number}
     * @memberof Player
     */
    'relativeToPar'?: number;
}
/**
 * 
 * @export
 * @interface PlayerCreate
 */
export interface PlayerCreate {
    /**
     * 
     * @type {string}
     * @memberof PlayerCreate
     */
    'name': string;
}
/**
 * 
 * @export
 * @interface Score
 */
export interface Score {
    /**
     * 
     * @type {string}
     * @memberof Score
     */
    'playerId'?: string;
    /**
     * 
     * @type {number}
     * @memberof Score
     */
    'holeNumber'?: number;
    /**
     * 
     * @type {number}
     * @memberof Score
     */
    'strokes'?: number;
    /**
     * Score relative to par for this hole (negative is under par)
     * @type {number}
     * @memberof Score
     */
    'relativeToPar'?: number;
}
/**
 * 
 * @export
 * @interface ScoreSubmission
 */
export interface ScoreSubmission {
    /**
     * 
     * @type {string}
     * @memberof ScoreSubmission
     */
    'playerId': string;
    /**
     * 
     * @type {number}
     * @memberof ScoreSubmission
     */
    'holeNumber': number;
    /**
     * 
     * @type {number}
     * @memberof ScoreSubmission
     */
    'strokes': number;
}
/**
 * 
 * @export
 * @interface Tournament
 */
export interface Tournament {
    /**
     * 
     * @type {string}
     * @memberof Tournament
     */
    'id'?: string;
    /**
     * Array of par values for each hole (must be 18 holes)
     * @type {Array<number>}
     * @memberof Tournament
     */
    'coursePars'?: Array<number>;
    /**
     * 
     * @type {number}
     * @memberof Tournament
     */
    'totalPar'?: number;
}
/**
 * 
 * @export
 * @interface TournamentCreate
 */
export interface TournamentCreate {
    /**
     * Array of par values for each hole
     * @type {Array<number>}
     * @memberof TournamentCreate
     */
    'coursePars': Array<number>;
}

/**
 * LeaderboardApi - axios parameter creator
 * @export
 */
export const LeaderboardApiAxiosParamCreator = function (configuration?: Configuration) {
    return {
        /**
         * 
         * @summary Get current leaderboard
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        getLeaderboard: async (options: RawAxiosRequestConfig = {}): Promise<RequestArgs> => {
            const localVarPath = `/api/leaderboard`;
            // use dummy base URL string because the URL constructor only accepts absolute URLs.
            const localVarUrlObj = new URL(localVarPath, DUMMY_BASE_URL);
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }

            const localVarRequestOptions = { method: 'GET', ...baseOptions, ...options};
            const localVarHeaderParameter = {} as any;
            const localVarQueryParameter = {} as any;


    
            setSearchParams(localVarUrlObj, localVarQueryParameter);
            let headersFromBaseOptions = baseOptions && baseOptions.headers ? baseOptions.headers : {};
            localVarRequestOptions.headers = {...localVarHeaderParameter, ...headersFromBaseOptions, ...options.headers};

            return {
                url: toPathString(localVarUrlObj),
                options: localVarRequestOptions,
            };
        },
    }
};

/**
 * LeaderboardApi - functional programming interface
 * @export
 */
export const LeaderboardApiFp = function(configuration?: Configuration) {
    const localVarAxiosParamCreator = LeaderboardApiAxiosParamCreator(configuration)
    return {
        /**
         * 
         * @summary Get current leaderboard
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async getLeaderboard(options?: RawAxiosRequestConfig): Promise<(axios?: AxiosInstance, basePath?: string) => AxiosPromise<Leaderboard>> {
            const localVarAxiosArgs = await localVarAxiosParamCreator.getLeaderboard(options);
            const index = configuration?.serverIndex ?? 0;
            const operationBasePath = operationServerMap['LeaderboardApi.getLeaderboard']?.[index]?.url;
            return (axios, basePath) => createRequestFunction(localVarAxiosArgs, globalAxios, BASE_PATH, configuration)(axios, operationBasePath || basePath);
        },
    }
};

/**
 * LeaderboardApi - factory interface
 * @export
 */
export const LeaderboardApiFactory = function (configuration?: Configuration, basePath?: string, axios?: AxiosInstance) {
    const localVarFp = LeaderboardApiFp(configuration)
    return {
        /**
         * 
         * @summary Get current leaderboard
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        getLeaderboard(options?: any): AxiosPromise<Leaderboard> {
            return localVarFp.getLeaderboard(options).then((request) => request(axios, basePath));
        },
    };
};

/**
 * LeaderboardApi - object-oriented interface
 * @export
 * @class LeaderboardApi
 * @extends {BaseAPI}
 */
export class LeaderboardApi extends BaseAPI {
    /**
     * 
     * @summary Get current leaderboard
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof LeaderboardApi
     */
    public getLeaderboard(options?: RawAxiosRequestConfig) {
        return LeaderboardApiFp(this.configuration).getLeaderboard(options).then((request) => request(this.axios, this.basePath));
    }
}



/**
 * PlayersApi - axios parameter creator
 * @export
 */
export const PlayersApiAxiosParamCreator = function (configuration?: Configuration) {
    return {
        /**
         * 
         * @summary Register a new player
         * @param {PlayerCreate} playerCreate 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        createPlayer: async (playerCreate: PlayerCreate, options: RawAxiosRequestConfig = {}): Promise<RequestArgs> => {
            // verify required parameter 'playerCreate' is not null or undefined
            assertParamExists('createPlayer', 'playerCreate', playerCreate)
            const localVarPath = `/api/players`;
            // use dummy base URL string because the URL constructor only accepts absolute URLs.
            const localVarUrlObj = new URL(localVarPath, DUMMY_BASE_URL);
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }

            const localVarRequestOptions = { method: 'POST', ...baseOptions, ...options};
            const localVarHeaderParameter = {} as any;
            const localVarQueryParameter = {} as any;


    
            localVarHeaderParameter['Content-Type'] = 'application/json';

            setSearchParams(localVarUrlObj, localVarQueryParameter);
            let headersFromBaseOptions = baseOptions && baseOptions.headers ? baseOptions.headers : {};
            localVarRequestOptions.headers = {...localVarHeaderParameter, ...headersFromBaseOptions, ...options.headers};
            localVarRequestOptions.data = serializeDataIfNeeded(playerCreate, localVarRequestOptions, configuration)

            return {
                url: toPathString(localVarUrlObj),
                options: localVarRequestOptions,
            };
        },
        /**
         * 
         * @summary List all players
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        listPlayers: async (options: RawAxiosRequestConfig = {}): Promise<RequestArgs> => {
            const localVarPath = `/api/players`;
            // use dummy base URL string because the URL constructor only accepts absolute URLs.
            const localVarUrlObj = new URL(localVarPath, DUMMY_BASE_URL);
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }

            const localVarRequestOptions = { method: 'GET', ...baseOptions, ...options};
            const localVarHeaderParameter = {} as any;
            const localVarQueryParameter = {} as any;


    
            setSearchParams(localVarUrlObj, localVarQueryParameter);
            let headersFromBaseOptions = baseOptions && baseOptions.headers ? baseOptions.headers : {};
            localVarRequestOptions.headers = {...localVarHeaderParameter, ...headersFromBaseOptions, ...options.headers};

            return {
                url: toPathString(localVarUrlObj),
                options: localVarRequestOptions,
            };
        },
    }
};

/**
 * PlayersApi - functional programming interface
 * @export
 */
export const PlayersApiFp = function(configuration?: Configuration) {
    const localVarAxiosParamCreator = PlayersApiAxiosParamCreator(configuration)
    return {
        /**
         * 
         * @summary Register a new player
         * @param {PlayerCreate} playerCreate 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async createPlayer(playerCreate: PlayerCreate, options?: RawAxiosRequestConfig): Promise<(axios?: AxiosInstance, basePath?: string) => AxiosPromise<Player>> {
            const localVarAxiosArgs = await localVarAxiosParamCreator.createPlayer(playerCreate, options);
            const index = configuration?.serverIndex ?? 0;
            const operationBasePath = operationServerMap['PlayersApi.createPlayer']?.[index]?.url;
            return (axios, basePath) => createRequestFunction(localVarAxiosArgs, globalAxios, BASE_PATH, configuration)(axios, operationBasePath || basePath);
        },
        /**
         * 
         * @summary List all players
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async listPlayers(options?: RawAxiosRequestConfig): Promise<(axios?: AxiosInstance, basePath?: string) => AxiosPromise<Array<Player>>> {
            const localVarAxiosArgs = await localVarAxiosParamCreator.listPlayers(options);
            const index = configuration?.serverIndex ?? 0;
            const operationBasePath = operationServerMap['PlayersApi.listPlayers']?.[index]?.url;
            return (axios, basePath) => createRequestFunction(localVarAxiosArgs, globalAxios, BASE_PATH, configuration)(axios, operationBasePath || basePath);
        },
    }
};

/**
 * PlayersApi - factory interface
 * @export
 */
export const PlayersApiFactory = function (configuration?: Configuration, basePath?: string, axios?: AxiosInstance) {
    const localVarFp = PlayersApiFp(configuration)
    return {
        /**
         * 
         * @summary Register a new player
         * @param {PlayerCreate} playerCreate 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        createPlayer(playerCreate: PlayerCreate, options?: any): AxiosPromise<Player> {
            return localVarFp.createPlayer(playerCreate, options).then((request) => request(axios, basePath));
        },
        /**
         * 
         * @summary List all players
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        listPlayers(options?: any): AxiosPromise<Array<Player>> {
            return localVarFp.listPlayers(options).then((request) => request(axios, basePath));
        },
    };
};

/**
 * PlayersApi - object-oriented interface
 * @export
 * @class PlayersApi
 * @extends {BaseAPI}
 */
export class PlayersApi extends BaseAPI {
    /**
     * 
     * @summary Register a new player
     * @param {PlayerCreate} playerCreate 
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof PlayersApi
     */
    public createPlayer(playerCreate: PlayerCreate, options?: RawAxiosRequestConfig) {
        return PlayersApiFp(this.configuration).createPlayer(playerCreate, options).then((request) => request(this.axios, this.basePath));
    }

    /**
     * 
     * @summary List all players
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof PlayersApi
     */
    public listPlayers(options?: RawAxiosRequestConfig) {
        return PlayersApiFp(this.configuration).listPlayers(options).then((request) => request(this.axios, this.basePath));
    }
}



/**
 * ScoresApi - axios parameter creator
 * @export
 */
export const ScoresApiAxiosParamCreator = function (configuration?: Configuration) {
    return {
        /**
         * 
         * @summary Submit score for a hole
         * @param {ScoreSubmission} scoreSubmission 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        submitScore: async (scoreSubmission: ScoreSubmission, options: RawAxiosRequestConfig = {}): Promise<RequestArgs> => {
            // verify required parameter 'scoreSubmission' is not null or undefined
            assertParamExists('submitScore', 'scoreSubmission', scoreSubmission)
            const localVarPath = `/api/scores`;
            // use dummy base URL string because the URL constructor only accepts absolute URLs.
            const localVarUrlObj = new URL(localVarPath, DUMMY_BASE_URL);
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }

            const localVarRequestOptions = { method: 'POST', ...baseOptions, ...options};
            const localVarHeaderParameter = {} as any;
            const localVarQueryParameter = {} as any;


    
            localVarHeaderParameter['Content-Type'] = 'application/json';

            setSearchParams(localVarUrlObj, localVarQueryParameter);
            let headersFromBaseOptions = baseOptions && baseOptions.headers ? baseOptions.headers : {};
            localVarRequestOptions.headers = {...localVarHeaderParameter, ...headersFromBaseOptions, ...options.headers};
            localVarRequestOptions.data = serializeDataIfNeeded(scoreSubmission, localVarRequestOptions, configuration)

            return {
                url: toPathString(localVarUrlObj),
                options: localVarRequestOptions,
            };
        },
    }
};

/**
 * ScoresApi - functional programming interface
 * @export
 */
export const ScoresApiFp = function(configuration?: Configuration) {
    const localVarAxiosParamCreator = ScoresApiAxiosParamCreator(configuration)
    return {
        /**
         * 
         * @summary Submit score for a hole
         * @param {ScoreSubmission} scoreSubmission 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async submitScore(scoreSubmission: ScoreSubmission, options?: RawAxiosRequestConfig): Promise<(axios?: AxiosInstance, basePath?: string) => AxiosPromise<Score>> {
            const localVarAxiosArgs = await localVarAxiosParamCreator.submitScore(scoreSubmission, options);
            const index = configuration?.serverIndex ?? 0;
            const operationBasePath = operationServerMap['ScoresApi.submitScore']?.[index]?.url;
            return (axios, basePath) => createRequestFunction(localVarAxiosArgs, globalAxios, BASE_PATH, configuration)(axios, operationBasePath || basePath);
        },
    }
};

/**
 * ScoresApi - factory interface
 * @export
 */
export const ScoresApiFactory = function (configuration?: Configuration, basePath?: string, axios?: AxiosInstance) {
    const localVarFp = ScoresApiFp(configuration)
    return {
        /**
         * 
         * @summary Submit score for a hole
         * @param {ScoreSubmission} scoreSubmission 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        submitScore(scoreSubmission: ScoreSubmission, options?: any): AxiosPromise<Score> {
            return localVarFp.submitScore(scoreSubmission, options).then((request) => request(axios, basePath));
        },
    };
};

/**
 * ScoresApi - object-oriented interface
 * @export
 * @class ScoresApi
 * @extends {BaseAPI}
 */
export class ScoresApi extends BaseAPI {
    /**
     * 
     * @summary Submit score for a hole
     * @param {ScoreSubmission} scoreSubmission 
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof ScoresApi
     */
    public submitScore(scoreSubmission: ScoreSubmission, options?: RawAxiosRequestConfig) {
        return ScoresApiFp(this.configuration).submitScore(scoreSubmission, options).then((request) => request(this.axios, this.basePath));
    }
}



/**
 * TournamentApi - axios parameter creator
 * @export
 */
export const TournamentApiAxiosParamCreator = function (configuration?: Configuration) {
    return {
        /**
         * 
         * @summary Create new tournament (only one can exist at a time)
         * @param {TournamentCreate} tournamentCreate 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        createTournament: async (tournamentCreate: TournamentCreate, options: RawAxiosRequestConfig = {}): Promise<RequestArgs> => {
            // verify required parameter 'tournamentCreate' is not null or undefined
            assertParamExists('createTournament', 'tournamentCreate', tournamentCreate)
            const localVarPath = `/api/tournament`;
            // use dummy base URL string because the URL constructor only accepts absolute URLs.
            const localVarUrlObj = new URL(localVarPath, DUMMY_BASE_URL);
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }

            const localVarRequestOptions = { method: 'POST', ...baseOptions, ...options};
            const localVarHeaderParameter = {} as any;
            const localVarQueryParameter = {} as any;


    
            localVarHeaderParameter['Content-Type'] = 'application/json';

            setSearchParams(localVarUrlObj, localVarQueryParameter);
            let headersFromBaseOptions = baseOptions && baseOptions.headers ? baseOptions.headers : {};
            localVarRequestOptions.headers = {...localVarHeaderParameter, ...headersFromBaseOptions, ...options.headers};
            localVarRequestOptions.data = serializeDataIfNeeded(tournamentCreate, localVarRequestOptions, configuration)

            return {
                url: toPathString(localVarUrlObj),
                options: localVarRequestOptions,
            };
        },
        /**
         * 
         * @summary Get current tournament details
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        getTournament: async (options: RawAxiosRequestConfig = {}): Promise<RequestArgs> => {
            const localVarPath = `/api/tournament`;
            // use dummy base URL string because the URL constructor only accepts absolute URLs.
            const localVarUrlObj = new URL(localVarPath, DUMMY_BASE_URL);
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }

            const localVarRequestOptions = { method: 'GET', ...baseOptions, ...options};
            const localVarHeaderParameter = {} as any;
            const localVarQueryParameter = {} as any;


    
            setSearchParams(localVarUrlObj, localVarQueryParameter);
            let headersFromBaseOptions = baseOptions && baseOptions.headers ? baseOptions.headers : {};
            localVarRequestOptions.headers = {...localVarHeaderParameter, ...headersFromBaseOptions, ...options.headers};

            return {
                url: toPathString(localVarUrlObj),
                options: localVarRequestOptions,
            };
        },
    }
};

/**
 * TournamentApi - functional programming interface
 * @export
 */
export const TournamentApiFp = function(configuration?: Configuration) {
    const localVarAxiosParamCreator = TournamentApiAxiosParamCreator(configuration)
    return {
        /**
         * 
         * @summary Create new tournament (only one can exist at a time)
         * @param {TournamentCreate} tournamentCreate 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async createTournament(tournamentCreate: TournamentCreate, options?: RawAxiosRequestConfig): Promise<(axios?: AxiosInstance, basePath?: string) => AxiosPromise<Tournament>> {
            const localVarAxiosArgs = await localVarAxiosParamCreator.createTournament(tournamentCreate, options);
            const index = configuration?.serverIndex ?? 0;
            const operationBasePath = operationServerMap['TournamentApi.createTournament']?.[index]?.url;
            return (axios, basePath) => createRequestFunction(localVarAxiosArgs, globalAxios, BASE_PATH, configuration)(axios, operationBasePath || basePath);
        },
        /**
         * 
         * @summary Get current tournament details
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async getTournament(options?: RawAxiosRequestConfig): Promise<(axios?: AxiosInstance, basePath?: string) => AxiosPromise<Tournament>> {
            const localVarAxiosArgs = await localVarAxiosParamCreator.getTournament(options);
            const index = configuration?.serverIndex ?? 0;
            const operationBasePath = operationServerMap['TournamentApi.getTournament']?.[index]?.url;
            return (axios, basePath) => createRequestFunction(localVarAxiosArgs, globalAxios, BASE_PATH, configuration)(axios, operationBasePath || basePath);
        },
    }
};

/**
 * TournamentApi - factory interface
 * @export
 */
export const TournamentApiFactory = function (configuration?: Configuration, basePath?: string, axios?: AxiosInstance) {
    const localVarFp = TournamentApiFp(configuration)
    return {
        /**
         * 
         * @summary Create new tournament (only one can exist at a time)
         * @param {TournamentCreate} tournamentCreate 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        createTournament(tournamentCreate: TournamentCreate, options?: any): AxiosPromise<Tournament> {
            return localVarFp.createTournament(tournamentCreate, options).then((request) => request(axios, basePath));
        },
        /**
         * 
         * @summary Get current tournament details
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        getTournament(options?: any): AxiosPromise<Tournament> {
            return localVarFp.getTournament(options).then((request) => request(axios, basePath));
        },
    };
};

/**
 * TournamentApi - object-oriented interface
 * @export
 * @class TournamentApi
 * @extends {BaseAPI}
 */
export class TournamentApi extends BaseAPI {
    /**
     * 
     * @summary Create new tournament (only one can exist at a time)
     * @param {TournamentCreate} tournamentCreate 
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof TournamentApi
     */
    public createTournament(tournamentCreate: TournamentCreate, options?: RawAxiosRequestConfig) {
        return TournamentApiFp(this.configuration).createTournament(tournamentCreate, options).then((request) => request(this.axios, this.basePath));
    }

    /**
     * 
     * @summary Get current tournament details
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof TournamentApi
     */
    public getTournament(options?: RawAxiosRequestConfig) {
        return TournamentApiFp(this.configuration).getTournament(options).then((request) => request(this.axios, this.basePath));
    }
}



