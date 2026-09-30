package kz.sdu.drone.navigation;
import kz.sdu.drone.product.DroneFamily;
public class AgricultureNavigation implements Navigation {
    public DroneFamily family() { return DroneFamily.AGRICULTURE; }
    public String navigate(String value) { return "Agriculture: field route with crop-row optimization -> " + value; }
}
