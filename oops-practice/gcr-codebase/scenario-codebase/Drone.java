public class Drone {
    private String droneId;
    private int batteryPercentage;
    private static String companyName = "SkyLogistics";

    public Drone(String droneId, int batteryPercentage) {
        this.droneId = droneId;
        this.batteryPercentage = batteryPercentage;
    }

    public void startDelivery() {
        if (batteryPercentage >= 20) {
            System.out.println("Drone " + droneId + " start delivery. Battery: " + batteryPercentage + "%");
            batteryPercentage -= 10;
        } else {
            System.out.println("Drone " + droneId + " low battery. Cannot start delivery.");
        }
    }

    public void displayStatus() {
        System.out.println("Drone: " + droneId + " | Battery: " + batteryPercentage + "% | Company: " + companyName);
    }

    public static void main(String[] args) {
        Drone d1 = new Drone("DRN-001", 85);
        Drone d2 = new Drone("DRN-002", 15);
        Drone d3 = new Drone("DRN-003", 60);

        d1.displayStatus();
        d2.displayStatus();
        d3.displayStatus();

        d1.startDelivery();
        d2.startDelivery();
        d3.startDelivery();

        System.out.println("All drones share company: " + Drone.companyName);
    }
}
