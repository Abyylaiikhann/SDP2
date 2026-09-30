package kz.sdu.drone.camera;
import kz.sdu.drone.product.DroneFamily;
public class AgricultureCamera implements Camera {
    public DroneFamily family() { return DroneFamily.AGRICULTURE; }
    public String capture(String value) { return "Agriculture: crop detail image -> " + value; }
}
