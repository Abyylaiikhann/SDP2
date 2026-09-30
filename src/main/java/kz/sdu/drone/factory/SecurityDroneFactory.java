package kz.sdu.drone.factory;
import kz.sdu.drone.camera.*; import kz.sdu.drone.navigation.*; import kz.sdu.drone.communication.*; import kz.sdu.drone.product.DroneFamily;
public class SecurityDroneFactory implements DroneSystemFactory {
 public Camera createCamera(){ return new SecurityCamera(); }
 public Navigation createNavigation(){ return new SecurityNavigation(); }
 public Communication createCommunication(){ return new SecurityCommunication(); }
 public DroneFamily family(){ return DroneFamily.SECURITY; }
}
