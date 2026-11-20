# garage-app

The running example of our team teachback: a small garage application.
One code base, three parts.

| Part | Presenter | Topic | Branch |
|------|-----------|-------|--------|
| 1 | John | Spring Core | `part1-john` |
| 2 | Ivan | Spring Boot IoC | `part2-ivan` |
| 3 | Cynthia | Spring JDBC | `part3-cynthia` |

Java 17, Spring Boot 3.5.6, Maven. Base package: `com.teachback.garage`.

## Shared names (same as in the slides)

| Role | Name |
|------|------|
| Data class | `Car` (id, brand, model, ownerName) |
| Data access contract | `CarRepository` (`findById`, `findAll`, `save`) |
| In-memory implementation | `InMemoryCarRepository` (Part 1) |
| JDBC implementation | `JdbcCarRepository` (Part 3) |
| Service | `RepairService` |
| Main class | `GarageApplication` |

`CarRepository` is the link between the parts. Do not change it without
telling the team.

## Run

    mvn spring-boot:run        (or run GarageApplication from your IDE)
    mvn test

## Git workflow

- `main` is the shared starting point (tag `part1-start`). Nobody commits
  directly on `main` once the work has started.
- Each presenter works on their own branch, created from `part1-start`.
  The three parts are independent: each demo starts from the shared base,
  not from another person's work.
- Each presenter tags the steps of their demo (see `docs/`), so that a failed
  step can be replaced by `git checkout <tag>` and the demo can restart from
  a state that works.

## Where to look

- `docs/part1-john.md`, `docs/part2-ivan.md`, `docs/part3-cynthia.md`:
  what each person has to build and demo.
- `docs/demo-day.md`: order, hand-offs on Google Meet and fallback plan.
- `infra/docker-compose.yml`: PostgreSQL for Part 3 only.
