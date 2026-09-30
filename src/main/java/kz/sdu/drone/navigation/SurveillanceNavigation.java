package kz.sdu.drone.navigation;
import kz.sdu.drone.product.DroneFamily;
public class SurveillanceNavigation implements Navigation {
    public DroneFamily family() { return DroneFamily.SURVEILLANCE; }
    public String navigate(String value) { return "Surveillance: quiet patrol route -> " + value; }
}
