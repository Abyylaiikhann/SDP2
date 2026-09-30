package kz.sdu.drone;
import kz.sdu.drone.business.DroneSystem;
import kz.sdu.drone.camera.*;
import kz.sdu.drone.communication.*;
import kz.sdu.drone.factory.*;
import kz.sdu.drone.navigation.*;
import kz.sdu.drone.product.DroneFamily;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class DroneFactoryAssignmentTest {
 @Test void agricultureFamilyCreatesCorrectProducts(){ DroneSystemFactory f=new AgricultureDroneFactory(); assertInstanceOf(AgricultureCamera.class,f.createCamera()); assertInstanceOf(AgricultureNavigation.class,f.createNavigation()); assertInstanceOf(AgricultureCommunication.class,f.createCommunication()); }
 @Test void rescueFamilyCreatesCorrectProducts(){ DroneSystemFactory f=new RescueDroneFactory(); assertInstanceOf(RescueCamera.class,f.createCamera()); assertInstanceOf(RescueNavigation.class,f.createNavigation()); assertInstanceOf(RescueCommunication.class,f.createCommunication()); }
 @Test void surveillanceFamilyCreatesCorrectProducts(){ DroneSystemFactory f=new SurveillanceDroneFactory(); assertInstanceOf(SurveillanceCamera.class,f.createCamera()); assertInstanceOf(SurveillanceNavigation.class,f.createNavigation()); assertInstanceOf(SurveillanceCommunication.class,f.createCommunication()); }
 @Test void agricultureProductsAreCompatible(){ assertTrue(new DroneSystem(new AgricultureDroneFactory()).componentsAreCompatible()); }
 @Test void rescueProductsAreCompatible(){ assertTrue(new DroneSystem(new RescueDroneFactory()).componentsAreCompatible()); }
 @Test void surveillanceProductsAreCompatible(){ assertTrue(new DroneSystem(new SurveillanceDroneFactory()).componentsAreCompatible()); }
 @Test void runtimeSelectsAgriculture(){ assertEquals(DroneFamily.AGRICULTURE,FactorySelector.from("agriculture").family()); }
 @Test void runtimeSelectsRescueAlias(){ assertEquals(DroneFamily.RESCUE,FactorySelector.from("emergency").family()); }
 @Test void runtimeSelectsSurveillance(){ assertEquals(DroneFamily.SURVEILLANCE,FactorySelector.from("surveillance").family()); }
 @Test void unknownFamilyIsRejected(){ assertThrows(IllegalArgumentException.class,()->FactorySelector.from("space")); }
 @Test void nullFamilyIsRejected(){ assertThrows(IllegalArgumentException.class,()->FactorySelector.from(null)); }
 @Test void surveyUsesSeveralProducts(){ String s=new DroneSystem(new AgricultureDroneFactory()).surveyArea("Field 7"); assertTrue(s.contains("route")&&s.contains("image")&&s.contains("telemetry")); }
 @Test void emergencySearchUsesSeveralProducts(){ String s=new DroneSystem(new RescueDroneFactory()).emergencySearch("Forest"); assertTrue(s.contains("thermal")&&s.contains("priority rescue signal")); }
 @Test void inspectionUsesSeveralProducts(){ String s=new DroneSystem(new SurveillanceDroneFactory()).inspectAsset("Bridge"); assertTrue(s.contains("zoom")&&s.contains("encrypted observation report")); }
 @Test void clientWorksThroughFactoryAbstraction(){ DroneSystemFactory factory=new RescueDroneFactory(); DroneSystem client=new DroneSystem(factory); assertEquals(DroneFamily.RESCUE,client.family()); }
}
