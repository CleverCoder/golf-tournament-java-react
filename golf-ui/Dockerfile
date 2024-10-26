# Use an official Node image as the base
FROM node:18-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy package.json and package-lock.json (if available)
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the rest of the application code
COPY . .

# Expose the Vite dev server's default port
EXPOSE 5173

# Start Vite in development mode
CMD ["npx", "vite", "dev", "--host"]

