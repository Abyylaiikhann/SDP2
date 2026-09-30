package kz.sdu.drone.mission;
import kz.sdu.drone.camera.Camera;
import kz.sdu.drone.navigation.Navigation;
import kz.sdu.drone.communication.Communication;
public interface Mission {
    String name();
    String execute(Camera camera, Navigation navigation, Communication communication, String target);
}
