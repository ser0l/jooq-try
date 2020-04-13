trying out jooq

## Postgres setup
```
docker pull postgres
docker run --rm  --name pg-docker -e POSTGRES_PASSWORD=docker -d -p 5432:5432  postgres
```

## Install schema
```
mvn liquibase:update -P liquibase
```

## Generate jOOQ files
```
mvn generate-sources -P jooq
```

### TODO
Integration test with TestContainers?
