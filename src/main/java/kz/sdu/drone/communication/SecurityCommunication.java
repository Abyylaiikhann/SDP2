package kz.sdu.drone.communication;
import kz.sdu.drone.product.DroneFamily;
public class SecurityCommunication implements Communication {
    public DroneFamily family() { return DroneFamily.SECURITY; }
    public String transmit(String value) { return "Security: secure alert channel -> " + value; }
}
