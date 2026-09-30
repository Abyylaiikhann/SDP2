package kz.sdu.drone.app;
import kz.sdu.drone.business.DroneSystem;
import kz.sdu.drone.factory.FactorySelector;
public class Main {
    public static void main(String[] args) {
        String family = args.length > 0 ? args[0] : System.getenv().getOrDefault("DRONE_FAMILY", "agriculture");
        DroneSystem system = new DroneSystem(FactorySelector.from(family));
        System.out.println("Selected family: " + system.family());
        System.out.println("Compatible: " + system.componentsAreCompatible());
        System.out.println(system.surveyArea("Sector A"));
        System.out.println(system.emergencySearch("Sector B"));
        System.out.println(system.inspectAsset("Power Line 12"));
    }
}
