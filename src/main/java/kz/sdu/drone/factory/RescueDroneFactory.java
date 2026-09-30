package kz.sdu.drone.factory;
import kz.sdu.drone.camera.*; import kz.sdu.drone.navigation.*; import kz.sdu.drone.communication.*; import kz.sdu.drone.product.DroneFamily;
public class RescueDroneFactory implements DroneSystemFactory {
 public Camera createCamera(){ return new RescueCamera(); }
 public Navigation createNavigation(){ return new RescueNavigation(); }
 public Communication createCommunication(){ return new RescueCommunication(); }
 public DroneFamily family(){ return DroneFamily.RESCUE; }
}
