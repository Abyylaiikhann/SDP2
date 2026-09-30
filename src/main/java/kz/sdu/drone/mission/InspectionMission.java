package kz.sdu.drone.mission;
import kz.sdu.drone.camera.Camera; import kz.sdu.drone.navigation.Navigation; import kz.sdu.drone.communication.Communication;
public class InspectionMission implements Mission {
    public String name(){ return "Inspection Mission"; }
    public String execute(Camera c, Navigation n, Communication m, String target){
        return c.capture(target) + " | " + m.transmit("inspection report for " + target);
    }
}
