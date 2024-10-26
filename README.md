# Golf Tournament System

A real-time golf tournament scoring and leaderboard system built with Java and React.
Just a proof of concept, not to be taken too seriously.

## Project Structure

```
golf-tournament/
├── api-java/         # Java API service (based on Spring Boot)
├── golf-ui/          # React + Vite UI
├── docker-compose.yml          # Main solution compose file (unused services commented out)
├── docker-compose-apicurio.yml # For using Apicurio for OpenAPI authoring
├── golf-api-schema.yml         # OpenAPI specification
├── golf-db-schema.sql          # Postgres DB schema for persistence (not currently used)
├── package.json                
└── README.md
```

## Prerequisites

- Node.js (v16 or later)
- Docker
- Java JDK

## Quick Start

1. Run: `npm start`

This will use Docker compose to create the UI and API containers, configure their networking,
install dependencies, and run the corresponding UI and API processes. The API currently just uses
in-memory hash maps for data storage. Just a proof of concept to play with React+Vite and the latest Java Spring Boot.

## Notes

Apicurio Studio has a docker-compose file for convenience, setup to NOT run on port 8080. (Why did they make it so hard?)
This is a powerful OpenAPI authoring tool.

The generated OpenAPI service model interface code and UI React/Axois client code is checked
in for convenience. To regenerate, run: `npm run api:gen:all`.

## Future Enhancements

Quite a few:
- Improved UI for showing more details per-user, and so many better ways to interact with the tournament
- Websockets for real-time updates to the UI
- A streaming message service, such as Kafka, for distributing messages to connected clients when system state changes
- Finish DB persistence, rather than in-memory, to allow for multiple service instances
- Make a production UI Dockerfile for proper deployment
