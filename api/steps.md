# Spinning Up a TypeScript based Node Express REST API

## Boiler Plate Code

We will begin with some boiler plate provided by the [Typesript Quickstart Project](https://github.com/joeythelantern/Typescript-Quickstart-Projects). Within the Typescript Quickstart Project is a
folder for typescript-mysql-quickstart which contains a Typescript based Node project including configuration, routing, controllers, and interfaces. Database connection is initialized at start up.
Unfortunately, the SQL queries are written directly within the controllers in the boiler plate will want to move them into a model file.

- Create a new folder and git initialize a project
- Download the [Typesript Quickstart Project](https://github.com/joeythelantern/Typescript-Quickstart-Projects) project.
- Copy the typescript-mysql-quickstart folder contents into your new project folder
- Open the tsconfig.json file and add the option `"noEmitOnError": true`.

The boiler plate is set up to read environment variables out of a `.env` file. The environment variables are then used to populate values in the `source/config/config.ts` file. If a value is not set
in an environment variable then the system will use a default string provided in the config. For example:

```
const MYSQL_HOST = process.env.MYSQL_HOST || 'localhost';
```

In the above case, MYSQL_HOST will be set to 'localhost' if no environment variable is present.

### Folders

As a standard practice, you may wish to rename the `source` folder to `src` and create an output folder for compiled builds called either `build` or `dist`.

Add a `src/models` folder and create a file for each db table. In the model file create CRUD opperations for that particular table. We should have a super class which defines all basic RDBMS operation
and override when neccessary.

### NPM Package Scripts

Assuming we have chosen `build` for our output, add the following 2 scripts to the package.json

```
    "build": "rm -rf build && prettier --write src/ && tsc",
    "start": "cd build && node server.js",
    "start-dev": "nodemon src/server.ts"
```
