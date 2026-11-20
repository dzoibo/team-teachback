# Part 1: Spring Core (John)

Slides: 2 to 8 of the team deck. Branch: `part1-john` (from `part1-start`).

## What the skeleton gives you

- `Car`, `CarRepository`, `InMemoryCarRepository` (two cars: ids 41 and 42).
- `RepairService` with constructor injection (the "after" of your slide 4).
- A Boot application (`GarageApplication`) that you do not need to touch.

## Constraint for your demo

Your slide 8 uses `AnnotationConfigApplicationContext(AppConfig.class)`, which
is plain Spring. To keep it from clashing with Ivan's Boot scan:

- Put your demo code in the package `com.teachback.core`, which is NOT under
  `com.teachback.garage`. Otherwise Boot would also scan your `AppConfig` and
  create the repository twice.
- Give it its own `main` method (for example `CoreDemo`). Do not use
  `@SpringBootApplication` there.
- Declare the beans with `@Bean` in `AppConfig`, as on your slide 7
  (`CarRepository` and `RepairService`).
- Do not call `@ComponentScan` on the whole `com.teachback.garage` package: it
  would also pick up `GarageApplication`.

## What to demo (suggestion, adjust as you like)

1. The "before": a class that creates its dependency with `new` (your slide 2).
2. The "after": the container builds the beans and injects the repository.
3. `context.getBean(RepairService.class)`, then `service.repair(42L)`.

## Tags

`part1-step1`, `part1-step2`, `part1-step3` on your branch, one per step.
Final state: `part1-end`.
