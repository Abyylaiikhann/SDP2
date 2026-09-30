package kz.sdu.drone.communication;
import kz.sdu.drone.product.DroneFamily;
public class AgricultureCommunication implements Communication {
    public DroneFamily family() { return DroneFamily.AGRICULTURE; }
    public String transmit(String value) { return "Agriculture: farm telemetry over long-range link -> " + value; }
}
