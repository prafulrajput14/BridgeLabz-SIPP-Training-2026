public class SpaceTourist {
    private String touristName;
    private int seatNumber;
    private static int totalReservations = 0;
    private static String missionName = "Galaxy-1";

    public SpaceTourist(String touristName, int seatNumber) {
        this.touristName = touristName;
        this.seatNumber = seatNumber;
        totalReservations++;
    }

    public SpaceTourist updateSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
        return this;
    }

    public void displayDetails() {
        System.out.println("Tourist: " + touristName + " | Seat: " + seatNumber +
                " | Mission: " + missionName);
    }

    public static int getTotalReservations() {
        return totalReservations;
    }

    public static void main(String[] args) {
        SpaceTourist tourist = new SpaceTourist("Alice", 5);

        tourist.updateSeatNumber(10)
                .updateSeatNumber(15);

        tourist.displayDetails();
        System.out.println("Total reservations: " + SpaceTourist.getTotalReservations());
    }
}
