## example PDF Generator

This service uses chrome in a headless mode to convert given html content to PDF.

### Steps to run locally -

```sh 
$ docker pull browserless/chrome:release-puppeteer-1.9.0
$ docker run -d -p 3000:3000 --name browserless  --restart always  -e "DEBUG=browserless/chrome"  browserless/chrome:release-puppeteer-1.9.0
$ CHROME_WS_URL=ws://localhost:3000 node app.js
```

### Command to run Smoke test locally -

```
MONOLITH_URL=https://cdsmoke.byexample.com MICROSERVICE_URL=https://example-pdf-generator.usmgmt.example.com AD_Tenant=CDSMOKE client_id={xxxxxxxxxx} client_secret={xxxxxxxxxxxxxxx} channel_admin_username={username} channel_admin_password={xxxxxxxxxx} AUTHZ_URL=https://authz.usmgmt.example.com npm run test:smoke
```

### Command to run contract-provider test locally - 

```
CHROME_WS_URL='ws://localhost:3000' PACTBROKER='https://pactbroker.example.tools' PACT_TAG=‘xxx’ npm run test:provider
```


## Docker Commands

### `docker-compose build`

Builds docker images for example-pdf-generator and the smoke test

### `docker-compose up -d example-pdf-generator`

Runs example-pdf-generator locally, in the background

### `docker-compose ps`

Will tell you the health and ports for the application

### `docker-compose logs -f example-pdf-generator`

Tail the logs for example-pdf-generator

### `docker-compose run example-pdf-generator-smoke`

Runs the smoke test against example-pdf-generator

### `docker-compose run example-pdf-generator-development`

Runs the unit tests on the development environment

### ` docker-compose run example-pdf-generator-development run test:provider`

Runs pact on the development environment
