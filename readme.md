jOOQ, testcontainers

## Postgres setup
```
docker pull postgres:12.2
docker run --rm --name pg-docker -e POSTGRES_PASSWORD=docker -d -p 5432:5432 postgres:12.2
```

## Install schema
```
mvn liquibase:update -P run-liquibase
```

## Generate jOOQ files
```
mvn generate-sources -P run-jooq
```
