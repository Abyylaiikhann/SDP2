# Assignment 2 — Factory Method & Abstract Factory
## Domain: Multi-family drone mission system

This project uses a drone platform because the client needs several **related components** (camera, navigation and communication) whose behavior changes together depending on the operating family.

## Requirements checklist
- 3 product types: `Camera`, `Navigation`, `Communication`.
- Original 3 families: Agriculture, Rescue, Surveillance = 9 concrete products.
- Added 4th family: Security = 3 more concrete products.
- Factory Method: `MissionCreator` + 3 concrete creators. `runMission()` contains real workflow logic and calls the factory method.
- Abstract Factory: `DroneSystemFactory` + 4 concrete family factories.
- Compatibility: `DroneSystem` receives only one `DroneSystemFactory` and obtains all three components from it, so normal client code never chooses components independently.
- Runtime selection: `FactorySelector.from(...)`; `Main` accepts command-line argument or `DRONE_FAMILY` environment variable.
- Business operations: `surveyArea`, `emergencySearch`, `inspectAsset`, `sendOperationalUpdate`.
- New-family extension: `SecurityCamera`, `SecurityNavigation`, `SecurityCommunication`, `SecurityDroneFactory`; existing `DroneSystem` business logic was not changed for family-specific behavior.
- UML: `docs/UML.md`.
- Automated tests: 19 JUnit 5 tests covering all requested categories, including 2 negative scenarios.

## Part A — problems before factories
Direct creation creates at least three design problems:
1. Client is coupled to concrete classes.
2. Selection becomes a growing `if/else` or `switch`.
3. A developer can accidentally combine components from different families, and creation logic can be duplicated.
`legacy/DirectDroneSetup.java` documents the initial direct-creation stage, and Git history keeps the assignment evolution.

## Why Factory Method is not a static factory
`MissionCreator` is an abstract creator. Subclasses override `createMission()` polymorphically, while the base class owns `runMission()`, which performs the common workflow. A static factory would choose/construct objects in one static method and would not use creator inheritance + an overridable factory method.

## Compatibility rule
The client constructs `DroneSystem` with exactly one `DroneSystemFactory`. The system then asks that same factory for camera, navigation and communication. Therefore the architecture's normal construction path creates only one family bundle instead of asking client code to mix products manually.

## Runtime examples
```bash
mvn test
mvn -q -DskipTests package
java -cp target/classes kz.sdu.drone.app.Main rescue
```
Or:
```bash
DRONE_FAMILY=security java -cp target/classes kz.sdu.drone.app.Main
```

Accepted values: `agriculture`, `rescue`, `surveillance`, `security` (plus a few aliases in `FactorySelector`).

## Files changed to add the fourth family
Only family-specific extension points were added/updated:
- `SecurityCamera.java`
- `SecurityNavigation.java`
- `SecurityCommunication.java`
- `SecurityDroneFactory.java`
- one new selector case in `FactorySelector`
- tests for Security

The core business class `DroneSystem` and product interfaces did not need family-specific modification.
