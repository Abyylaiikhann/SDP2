package kz.sdu.drone.factory;
import kz.sdu.drone.camera.Camera;
import kz.sdu.drone.navigation.Navigation;
import kz.sdu.drone.communication.Communication;
import kz.sdu.drone.product.DroneFamily;
public interface DroneSystemFactory {
    Camera createCamera();
    Navigation createNavigation();
    Communication createCommunication();
    DroneFamily family();
}
