package kz.sdu.drone.business;
import kz.sdu.drone.camera.Camera;
import kz.sdu.drone.communication.Communication;
import kz.sdu.drone.factory.DroneSystemFactory;
import kz.sdu.drone.mission.*;
import kz.sdu.drone.navigation.Navigation;
import kz.sdu.drone.product.DroneFamily;
public class DroneSystem {
    private final DroneSystemFactory factory;
    private final Camera camera;
    private final Navigation navigation;
    private final Communication communication;
    public DroneSystem(DroneSystemFactory factory) {
        this.factory = factory;
        this.camera = factory.createCamera();
        this.navigation = factory.createNavigation();
        this.communication = factory.createCommunication();
    }
    public DroneFamily family(){ return factory.family(); }
    public boolean componentsAreCompatible(){
        return camera.family()==factory.family() && navigation.family()==factory.family() && communication.family()==factory.family();
    }
    public String surveyArea(String area){
        return new ObservationMissionCreator().runMission(camera,navigation,communication,area);
    }
    public String emergencySearch(String area){
        return new RescueMissionCreator().runMission(camera,navigation,communication,area);
    }
    public String inspectAsset(String asset){
        return new InspectionMissionCreator().runMission(camera,navigation,communication,asset);
    }
    public String sendOperationalUpdate(String location){
        String route=navigation.navigate(location);
        String image=camera.capture(location);
        return route + " | " + image + " | " + communication.transmit("status update from " + location);
    }
}
