package kz.sdu.drone.factory;
import kz.sdu.drone.camera.*; import kz.sdu.drone.navigation.*; import kz.sdu.drone.communication.*; import kz.sdu.drone.product.DroneFamily;
public class AgricultureDroneFactory implements DroneSystemFactory {
 public Camera createCamera(){ return new AgricultureCamera(); }
 public Navigation createNavigation(){ return new AgricultureNavigation(); }
 public Communication createCommunication(){ return new AgricultureCommunication(); }
 public DroneFamily family(){ return DroneFamily.AGRICULTURE; }
}
