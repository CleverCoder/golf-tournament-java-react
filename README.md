# Golf Tournament System

A real-time golf tournament scoring and leaderboard system built with Java, Go, and Next.js.

## Project Structure

```
golf-tournament/
├── api-go/           # Go API service
├── api-java/         # Java API service
├── golf-ui/          # Next.js frontend
├── docker-compose.yml         # Main solution compose file
├── docker-compose-apicurio.yml # API design environment
├── golf-api-schema.yml        # OpenAPI specification
├── package.json               # Project management
└── README.md
```

## Prerequisites

- Node.js (v16 or later)
- Docker
- Java JDK (for API generation)
- Go (for API generation)

## Quick Start

1. **Setup Project**
```bash
npm run setup
```

2. **Start Development Environment**
```bash
npm run dev
```

## Available Scripts

### Development Environment

- `npm run dev` - Start all services in attached mode
- `npm run dev:detach` - Start all services in detached mode
- `npm run dev:down` - Stop and remove development containers
- `npm run dev:logs` - View development logs

### API Design

- `npm run apicurio` - Start Apicurio Studio for API design
- `npm run apicurio:detach` - Start Apicurio in detached mode
- `npm run apicurio:down` - Stop Apicurio

### API Generation

- `npm run api:gen:all` - Generate all API clients
- `npm run api:gen:java` - Generate Java client
- `npm run api:gen:go` - Generate Go client
- `npm run api:gen:react` - Generate React TypeScript client
- `npm run api:clean` - Clean generated code

### Solution Management

- `npm run start` - Build and start all services
- `npm run stop` - Stop all services
- `npm run restart` - Restart all services
- `npm run logs` - View all service logs

## Development Workflow

1. **Design APIs**
   ```bash
   npm run apicurio
   ```
   Visit http://localhost:8888 to use Apicurio Studio

2. **Generate API Clients**
   ```bash
   npm run api:gen:all
   ```

3. **Start Development Environment**
   ```bash
   npm run dev
   ```
   - Frontend: http://localhost:3000
   - Java API: http://localhost:8080
   - Go API: http://localhost:8081

## Services

### Frontend (golf-ui)
- Next.js application
- Real-time updates via WebSocket
- TypeScript/React

### Java API (api-java)
- Spring Boot service
- PostgreSQL database
- Redis for real-time updates

### Go API (api-go)
- Go service
- PostgreSQL database
- Redis for real-time updates

## Docker Management

### Volumes
Persistent data is stored in Docker volumes:
- PostgreSQL data
- Redis data

### Networks
Services communicate through the `golf-network` Docker network.

## Common Issues

### Data Persistence
- Use `npm run dev:down` carefully as it removes volumes
- Use `docker compose stop` to preserve data between restarts

### API Generation
- Ensure JDK is installed for Java generation
- Ensure Go is installed for Go generation
- Check generated code paths exist and are writable

## Contributing

1. Update API schema in `golf-api-schema.yml`
2. Generate new clients with `npm run api:gen:all`
3. Implement changes in respective services
4. Test with `npm run dev`