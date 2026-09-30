package kz.sdu.drone.mission;
import kz.sdu.drone.camera.Camera;
import kz.sdu.drone.navigation.Navigation;
import kz.sdu.drone.communication.Communication;
public abstract class MissionCreator {
    protected abstract Mission createMission();
    public String runMission(Camera camera, Navigation navigation, Communication communication, String target) {
        Mission mission = createMission();
        String route = navigation.navigate(target);
        String result = mission.execute(camera, navigation, communication, target);
        return mission.name() + " | planned=" + route + " | " + result;
    }
}
