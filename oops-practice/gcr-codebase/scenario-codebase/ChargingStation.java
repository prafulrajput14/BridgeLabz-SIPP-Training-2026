public class ChargingStation {
    private String stationId;
    private double unitsConsumed;
    private static int totalStations = 0;
    private static double electricityRate = 0.12;

    public ChargingStation(String stationId) {
        this.stationId = stationId;
        this.unitsConsumed = 0;
        totalStations++;
    }

    public void addUnits(double units) {
        this.unitsConsumed += units;
    }

    public double calculateBill() {
        return unitsConsumed * electricityRate;
    }

    public void displayStationDetails() {
        System.out.println("Station: " + stationId + " | Units: " + unitsConsumed +
                " | Rate: $" + electricityRate + "/kWh | Bill: $" + calculateBill());
    }

    public static void setElectricityRate(double rate) {
        electricityRate = rate;
    }

    public static int getTotalStations() {
        return totalStations;
    }

    public static void main(String[] args) {
        ChargingStation s1 = new ChargingStation("CS-001");
        ChargingStation s2 = new ChargingStation("CS-002");
        ChargingStation s3 = new ChargingStation("CS-003");
        ChargingStation s4 = new ChargingStation("CS-004");
        ChargingStation s5 = new ChargingStation("CS-005");

        s1.addUnits(120);
        s2.addUnits(85);
        s3.addUnits(200);
        s4.addUnits(55);
        s5.addUnits(310);

        System.out.println("--- Before rate change ---");
        s1.displayStationDetails();
        s2.displayStationDetails();
        s3.displayStationDetails();
        s4.displayStationDetails();
        s5.displayStationDetails();

        ChargingStation.setElectricityRate(0.18);

        System.out.println("--- After rate change ($0.18/kWh) ---");
        s1.displayStationDetails();
        s2.displayStationDetails();
        s3.displayStationDetails();
        s4.displayStationDetails();
        s5.displayStationDetails();

        System.out.println("Total stations: " + ChargingStation.getTotalStations());
    }
}
