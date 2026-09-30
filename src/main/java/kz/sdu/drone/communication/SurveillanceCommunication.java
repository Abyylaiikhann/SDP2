package kz.sdu.drone.communication;
import kz.sdu.drone.product.DroneFamily;
public class SurveillanceCommunication implements Communication {
    public DroneFamily family() { return DroneFamily.SURVEILLANCE; }
    public String transmit(String value) { return "Surveillance: encrypted observation report -> " + value; }
}
