package kz.sdu.drone.factory;
public final class FactorySelector {
    private FactorySelector() {}
    public static DroneSystemFactory from(String value) {
        if (value == null) throw new IllegalArgumentException("Family is required");
        return switch (value.trim().toLowerCase()) {
            case "agriculture", "farm" -> new AgricultureDroneFactory();
            case "rescue", "emergency" -> new RescueDroneFactory();
            case "surveillance", "observe" -> new SurveillanceDroneFactory();
            default -> throw new IllegalArgumentException("Unknown family: " + value);
        };
    }
}
