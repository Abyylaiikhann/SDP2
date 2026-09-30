package kz.sdu.drone.camera;
import kz.sdu.drone.product.DroneFamily;
public class SurveillanceCamera implements Camera {
    public DroneFamily family() { return DroneFamily.SURVEILLANCE; }
    public String capture(String value) { return "Surveillance: stabilized zoom image -> " + value; }
}
