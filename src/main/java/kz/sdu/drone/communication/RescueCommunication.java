package kz.sdu.drone.communication;
import kz.sdu.drone.product.DroneFamily;
public class RescueCommunication implements Communication {
    public DroneFamily family() { return DroneFamily.RESCUE; }
    public String transmit(String value) { return "Rescue: priority rescue signal -> " + value; }
}
