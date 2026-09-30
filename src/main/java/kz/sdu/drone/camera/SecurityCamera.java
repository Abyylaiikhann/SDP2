package kz.sdu.drone.camera;
import kz.sdu.drone.product.DroneFamily;
public class SecurityCamera implements Camera {
    public DroneFamily family() { return DroneFamily.SECURITY; }
    public String capture(String value) { return "Security: low-light perimeter image -> " + value; }
}
