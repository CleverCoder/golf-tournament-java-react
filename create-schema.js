// scripts/create-schema.js
const { Client } = require('pg');
const fs = require('fs');
const path = require('path');

async function createSchema() {
  const client = new Client({
    host: 'localhost',
    port: 5432,
    user: 'golfuser',
    password: 'golfpass',
    database: 'golfdb'
  });

  try {
    await client.connect();
    
    const schemaFile = path.join(__dirname, 'golf-db-schema.sql');
    const schema = fs.readFileSync(schemaFile, 'utf8');
    
    await client.query(schema);
    console.log('Schema created successfully');
  } catch (err) {
    console.error('Error creating schema:', err);
    process.exit(1);
  } finally {
    await client.end();
  }
}

createSchema();