package kz.sdu.drone.mission;
import kz.sdu.drone.camera.Camera; import kz.sdu.drone.navigation.Navigation; import kz.sdu.drone.communication.Communication;
public class ObservationMission implements Mission {
    public String name(){ return "Observation Mission"; }
    public String execute(Camera c, Navigation n, Communication m, String target){
        String image=c.capture(target); return image + " | " + m.transmit("observation complete at " + target);
    }
}
