import dotenv from 'dotenv';

dotenv.config();

const MSSQL_HOST = process.env.MSSQL_HOST || 'localhost';
const MSSQL_DATABASE = process.env.MSSQL_DATABASE || 'nodebooks';
const MSSQL_USER = process.env.MSSQL_HOST || 'root';
const MSSQL_PASS = process.env.MSSQL_HOST || '';

const MSSQL = {
  host: MSSQL_HOST,
  database: MSSQL_DATABASE,
  user: MSSQL_USER,
  pass: MSSQL_PASS
};

const SERVER_HOSTNAME = process.env.SERVER_HOSTNAME || 'localhost';
const SERVER_PORT = process.env.SERVER_PORT || 8080;

const SERVER = {
  hostname: SERVER_HOSTNAME,
  port: SERVER_PORT
};

const config = {
  mssql: MSSQL,
  server: SERVER
};

export default config;
