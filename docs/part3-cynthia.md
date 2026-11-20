# Part 3: Spring JDBC (Cynthia)

Slides: 17 to 26 of the team deck (backup slides 32 and 33). Branch:
`part3-cynthia` (from `part1-start`).

## What the skeleton gives you

- `CarRepository`: the DAO contract (`findById`, `findAll`, `save`). Your
  `JdbcCarRepository` implements it. Do not change the interface without
  telling the team. If you need `update` or `deleteById`, agree on it first.
- `RepairService`, which already depends on `CarRepository` by constructor.
- `infra/docker-compose.yml`: PostgreSQL 16, database `garage`, user
  `postgres`, password `postgres`.
  `docker compose -f infra/docker-compose.yml up -d`

## What you add on your branch only

- In `pom.xml`: `spring-boot-starter-jdbc` and `org.postgresql:postgresql`.
  Keep them on your branch only: without a database, they would stop the
  other two demos from starting.
- `application.yml` (or `.properties`) with the datasource URL
  `jdbc:postgresql://localhost:5432/garage`, user and password.
- `schema.sql` with the `car` table, and `JdbcCarRepository` with
  `@Repository`, `JdbcTemplate`, `update()`, `queryForObject()` and a
  `RowMapper`.
- `InMemoryCarRepository` and `JdbcCarRepository` must not both be beans. Two
  options: remove `@Repository` from `InMemoryCarRepository` on your branch,
  or mark `JdbcCarRepository` as `@Primary`.
- The transaction demo: your own classes (for example `Repair` and `Invoice`)
  and `@Transactional` on a `RepairService` method.

## Tags

One per step of your demo (`part3-step1`, ...). Final state: `part3-end`.
Each demo must be able to start from a clean database: start the container
fresh, or truncate the `car` table before you present.

## Before the presentation

- [ ] The container starts, and the demo runs twice in a row on an empty table.
- [ ] Every message on the slides matches what the IDE prints.
- [ ] A 60-second screen recording is ready as a last resort.
