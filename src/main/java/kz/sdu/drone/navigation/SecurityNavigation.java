package kz.sdu.drone.navigation;
import kz.sdu.drone.product.DroneFamily;
public class SecurityNavigation implements Navigation {
    public DroneFamily family() { return DroneFamily.SECURITY; }
    public String navigate(String value) { return "Security: restricted-zone patrol route -> " + value; }
}
