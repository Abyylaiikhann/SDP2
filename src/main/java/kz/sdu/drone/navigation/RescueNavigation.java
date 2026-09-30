package kz.sdu.drone.navigation;
import kz.sdu.drone.product.DroneFamily;
public class RescueNavigation implements Navigation {
    public DroneFamily family() { return DroneFamily.RESCUE; }
    public String navigate(String value) { return "Rescue: emergency route with obstacle avoidance -> " + value; }
}
