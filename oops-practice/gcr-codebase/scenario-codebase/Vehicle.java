public class Vehicle {
    private String vehicleNumber;
    private String ownerName;
    private String vehicleType;

    public Vehicle(String vehicleNumber, String ownerName, String vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public static void displayCars(Vehicle[] vehicles) {
        System.out.println("--- Cars ---");
        for (Vehicle v : vehicles) {
            if (v.vehicleType.equalsIgnoreCase("Car")) {
                System.out.println(v.vehicleNumber + " | Owner: " + v.ownerName);
            }
        }
    }

    public static void displayBikes(Vehicle[] vehicles) {
        System.out.println("--- Bikes ---");
        for (Vehicle v : vehicles) {
            if (v.vehicleType.equalsIgnoreCase("Bike")) {
                System.out.println(v.vehicleNumber + " | Owner: " + v.ownerName);
            }
        }
    }

    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[10];
        vehicles[0] = new Vehicle("KA-01-1234", "Alice", "Car");
        vehicles[1] = new Vehicle("KA-02-5678", "Bob", "Bike");
        vehicles[2] = new Vehicle("KA-03-9101", "Charlie", "Car");
        vehicles[3] = new Vehicle("KA-04-1122", "Diana", "Truck");
        vehicles[4] = new Vehicle("KA-05-3344", "Eve", "Bike");
        vehicles[5] = new Vehicle("KA-06-5566", "Frank", "Car");
        vehicles[6] = new Vehicle("KA-07-7788", "Grace", "Bike");
        vehicles[7] = new Vehicle("KA-08-9900", "Henry", "Car");
        vehicles[8] = new Vehicle("KA-09-2468", "Ivy", "Bike");
        vehicles[9] = new Vehicle("KA-10-1357", "Jack", "Car");

        displayCars(vehicles);
        displayBikes(vehicles);
    }
}
