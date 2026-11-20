# Part 2: Spring Boot IoC (Ivan)

Slides: 9 to 16 of the team deck (backup slides 28 to 31). Branch:
`part2-ivan` (from `part1-start`).

Four demo steps, one tag each. A tag is always a WORKING state. Two extra tags
(`-broken`) hold the failing state, as a fallback if you do not want to edit
live.

| Step | Tag | What it shows |
|------|-----|---------------|
| 1 | `part2-step1` | Start the app: beans created and wired, lifecycle logs, `getBean` |
| 2 | `part2-step2-broken`, `part2-step2` | A `@Service` outside the scan: failure, then the fix |
| 3 | `part2-step3-broken`, `part2-step3` | Two `NotificationService` beans: ambiguity, then `@Primary` |
| 4 | `part2-step4` | Custom auto-configuration that backs off |

Each demo starts from the previous tag. To restart a step:
`git checkout part2-step1` (for example).

## Step 1: start the application (slide 12)

- Run `GarageApplication`. Console: `Tomcat initialized...`,
  `[lifecycle] EmailNotificationService ready`, `Started GarageApplication...`,
  `Bean retrieved: RepairService`.
- Open http://localhost:8080/cars then http://localhost:8080/cars/42/repair
  (the console prints `[email] ...`).
- Stop the app: `[lifecycle] EmailNotificationService closing`.

## Step 2: the scan pitfall (slide 14)

- From `part2-step1`: move `EmailNotificationService` to the package
  `com.teachback.external` and add `import com.teachback.garage.NotificationService;`.
  This is the tag `part2-step2-broken`.
- Run: the application fails, `RepairService` required a bean of type
  `NotificationService` that could not be found.
- Fix: `@SpringBootApplication(scanBasePackages = {"com.teachback.garage",
  "com.teachback.external"})`. This is the tag `part2-step2`.

## Step 3: ambiguity (backup slide 29)

- From `part2-step2`: add `SmsNotificationService` (a second `@Service`).
  Tag `part2-step3-broken`. Run: `required a single bean, but 2 were found`.
- Fix: `@Primary` on `EmailNotificationService`. Tag `part2-step3`.
- Optional: `@Qualifier("smsNotificationService")` on the parameter of
  `RepairService`.

## Step 4: auto-configuration that backs off (backup slide 31)

- Tag `part2-step4`: both services are removed, and
  `NotificationAutoConfiguration` (package `com.teachback.autoconfig`, outside
  the scan) provides a default bean with `@ConditionalOnMissingBean`. It is
  registered in
  `META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports`.
- Run with `--debug`: find `NotificationAutoConfiguration` under positive
  matches. `/cars/42/repair` prints the plain default message.
- Make it back off: restore your own bean with
  `git checkout part2-step3 -- src/main/java/com/teachback/external/EmailNotificationService.java`
  and run again with `--debug`: it is now under negative matches.

## Before the presentation

- [ ] The full demo ran twice without error on the same machine.
- [ ] Every message on the slides matches what the IDE prints.
- [ ] Each tag was checked out and run once.
- [ ] A 60-second screen recording of the demo is ready as a last resort.
