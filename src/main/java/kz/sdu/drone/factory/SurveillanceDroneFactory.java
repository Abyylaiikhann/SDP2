package kz.sdu.drone.factory;
import kz.sdu.drone.camera.*; import kz.sdu.drone.navigation.*; import kz.sdu.drone.communication.*; import kz.sdu.drone.product.DroneFamily;
public class SurveillanceDroneFactory implements DroneSystemFactory {
 public Camera createCamera(){ return new SurveillanceCamera(); }
 public Navigation createNavigation(){ return new SurveillanceNavigation(); }
 public Communication createCommunication(){ return new SurveillanceCommunication(); }
 public DroneFamily family(){ return DroneFamily.SURVEILLANCE; }
}
