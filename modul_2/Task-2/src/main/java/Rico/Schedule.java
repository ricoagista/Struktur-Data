package Rico;

public class Schedule {
    private int scheduleId;
    private String trainCode, trainName, origin, destination, departureTime;
    private double baseFare;
    private static int idCounter = 101; // Auto-increment

    public Schedule(String code, String name, String org, String dest, String time, double fare) {
        this.scheduleId = idCounter++;
        this.trainCode = code;
        this.trainName = name;
        this.origin = org;
        this.destination = dest;
        this.departureTime = time;
        this.baseFare = fare;
    }

    public String getOrigin() { return origin; }
    public String getDestination() { return destination; }

    public void displayInfo() {
        System.out.printf("ID: %d | %s (%s) | %s -> %s | Jam: %s | Harga: %.2f\n",
                scheduleId, trainName, trainCode, origin, destination, departureTime, baseFare);
    }
}