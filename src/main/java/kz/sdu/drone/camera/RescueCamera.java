package kz.sdu.drone.camera;
import kz.sdu.drone.product.DroneFamily;
public class RescueCamera implements Camera {
    public DroneFamily family() { return DroneFamily.RESCUE; }
    public String capture(String value) { return "Rescue: thermal search image -> " + value; }
}
