# UML Class Diagram

```mermaid
classDiagram
    class Camera { <<interface>> +family() +capture(target) }
    class Navigation { <<interface>> +family() +navigate(destination) }
    class Communication { <<interface>> +family() +transmit(message) }
    class DroneSystemFactory { <<Abstract Factory>> +createCamera() +createNavigation() +createCommunication() +family() }
    class AgricultureDroneFactory
    class RescueDroneFactory
    class SurveillanceDroneFactory
    class SecurityDroneFactory
    DroneSystemFactory <|.. AgricultureDroneFactory
    DroneSystemFactory <|.. RescueDroneFactory
    DroneSystemFactory <|.. SurveillanceDroneFactory
    DroneSystemFactory <|.. SecurityDroneFactory
    DroneSystemFactory --> Camera
    DroneSystemFactory --> Navigation
    DroneSystemFactory --> Communication

    class Mission { <<Product>> +name() +execute() }
    class ObservationMission
    class RescueMission
    class InspectionMission
    Mission <|.. ObservationMission
    Mission <|.. RescueMission
    Mission <|.. InspectionMission

    class MissionCreator { <<Creator / Factory Method>> #createMission() +runMission() }
    class ObservationMissionCreator
    class RescueMissionCreator
    class InspectionMissionCreator
    MissionCreator <|-- ObservationMissionCreator
    MissionCreator <|-- RescueMissionCreator
    MissionCreator <|-- InspectionMissionCreator
    MissionCreator --> Mission : factory method

    class DroneSystem { <<Client>> +surveyArea() +emergencySearch() +inspectAsset() }
    DroneSystem --> DroneSystemFactory
    DroneSystem --> Camera
    DroneSystem --> Navigation
    DroneSystem --> Communication
    DroneSystem --> MissionCreator
```

**Factory Method part:** `MissionCreator#createMission()` is overridden by three concrete creators. The base creator owns the meaningful `runMission()` business workflow.

**Abstract Factory part:** `DroneSystemFactory` creates a compatible camera, navigation module and communication module for one drone family.
