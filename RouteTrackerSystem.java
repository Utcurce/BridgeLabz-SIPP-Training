abstract class Checkpoint {
    protected String checkpointId;
    protected String locationName;
    protected double distanceFromLast;
    protected int expectedDuration;
    protected int actualDuration;
    public Checkpoint(String checkpointId, String locationName, double distanceFromLast, int expectedDuration, int actualDuration) {
        this.checkpointId = checkpointId;
        this.locationName = locationName;
        this.distanceFromLast = distanceFromLast;
        this.expectedDuration = expectedDuration;
        this.actualDuration = actualDuration;
    }
    public boolean isDelayed() {
        return actualDuration > expectedDuration;
    }
    public abstract boolean isCritical();
    public abstract String getType();
    public abstract double calculatePenalty();
    @Override
    public String toString() {
        return getType() + " – " + locationName + " – " + (isDelayed() ? "Delayed" : "On Time") + " – Penalty: " + calculatePenalty();
    }
    public String getCheckpointId() {
        return checkpointId;
    }
    public double getDistance() {
        return distanceFromLast;
    }
}
class DeliveryCheckpoint extends Checkpoint {
    public DeliveryCheckpoint(String checkpointId, String locationName, double distanceFromLast, int expectedDuration, int actualDuration) {
        super(checkpointId, locationName, distanceFromLast, expectedDuration, actualDuration);
    }
    public boolean isCritical() {
        return true;
    }
    public String getType() {
        return "DeliveryCheckpoint";
    }
    public double calculatePenalty() {
        return isDelayed() ? (actualDuration - expectedDuration) * 2 : 0;
    }
}
class FuelCheckpoint extends Checkpoint {
    public FuelCheckpoint(String checkpointId, String locationName, double distanceFromLast, int expectedDuration, int actualDuration) {
        super(checkpointId, locationName, distanceFromLast, expectedDuration, actualDuration);
    }

    public boolean isCritical() {
        return true;
    }

    public String getType() {
        return "FuelCheckpoint";
    }

    public double calculatePenalty() {
        return isDelayed() ? 10 : 0;
    }
}
class RestCheckpoint extends Checkpoint {
    public RestCheckpoint(String checkpointId, String locationName, double distanceFromLast, int expectedDuration, int actualDuration) {
        super(checkpointId, locationName, distanceFromLast, expectedDuration, actualDuration);
    }
    public boolean isCritical() {
        return false;
    }
    public String getType() {
        return "RestCheckpoint";
    }
    public double calculatePenalty() {
        int delay = actualDuration - expectedDuration;
        return (delay > 30) ? delay * 0.5 : 0;
    }
}
class RouteLinkedList<T extends Checkpoint> {
    private class Node {
        T data;
        Node next;
        Node(T data) {
            this.data = data;
        }
    }
    private Node head;
    public void addCheckpoint(T checkpoint) {
        Node newNode = new Node(checkpoint);
        if (head == null) head = newNode;
        else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
        }
    }
    public boolean removeCheckpoint(String checkpointId) {
        if (head == null) return false;

        if (head.data.getCheckpointId().equals(checkpointId)) {
            head = head.next;
            return true;
        }
        Node prev = head;
        Node curr = head.next;
        while (curr != null) {
            if (curr.data.getCheckpointId().equals(checkpointId)) {
                prev.next = curr.next;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }
        return false;
    }
    public T findCheckpoint(String checkpointId) {
        Node temp = head;
        while (temp != null) {
            if (temp.data.getCheckpointId().equals(checkpointId))
                return temp.data;
            temp = temp.next;
        }
        return null;
    }
    public double computeTotalDistance() {
        double total = 0;
        Node temp = head;
        while (temp != null) {
            total += temp.data.getDistance();
            temp = temp.next;
        }
        return total;
    }
    public double computeTotalPenalty() {
        double total = 0;
        Node temp = head;
        while (temp != null) {
            total += temp.data.calculatePenalty();
            temp = temp.next;
        }
        return total;
    }
    public boolean checkCriticalPointsPresent() {
        boolean hasDelivery = false;
        boolean hasFuel = false;
        Node temp = head;
        while (temp != null) {
            if (temp.data instanceof DeliveryCheckpoint) hasDelivery = true;
            if (temp.data instanceof FuelCheckpoint) hasFuel = true;
            temp = temp.next;
        }
        return hasDelivery && hasFuel;
    }
    public void printRoute() {
        Node temp = head;
        int index = 1;
        while (temp != null) {
            System.out.println(index++ + ". " + temp.data);
            temp = temp.next;
        }
    }
}
class Driver {
    private String driverId;
    private String name;
    private RouteLinkedList<Checkpoint> routeHistory;
    public Driver(String driverId, String name) {
        this.driverId = driverId;
        this.name = name;
        this.routeHistory = new RouteLinkedList<>();
    }
    public void addCheckpoint(Checkpoint cp) {
        routeHistory.addCheckpoint(cp);
    }
    public void printSummary() {
        System.out.println("Driver: " + driverId + " – " + name);
        System.out.println("Route Summary:");
        routeHistory.printRoute();
        double totalDistance = routeHistory.computeTotalDistance();
        double totalPenalty = routeHistory.computeTotalPenalty();
        double routeScore = totalDistance - totalPenalty;
        boolean criticalOk = routeHistory.checkCriticalPointsPresent();
        System.out.println("Total Distance: " + totalDistance + " km");
        System.out.println("Total Penalty: " + totalPenalty);
        System.out.println("Route Score: " + routeScore);
        System.out.println("Critical Route Check: " + (criticalOk ? "All required checkpoints present" : "Missing critical checkpoint(s)"));
    }
}
public class RouteTrackerSystem {
    public static void main(String[] args) {
        Driver driver = new Driver("D1204", "Kavita Nair");
        driver.addCheckpoint(new DeliveryCheckpoint("C1", "Warehouse A", 30, 60, 70));
        driver.addCheckpoint(new FuelCheckpoint("C2", "Pump 12", 20, 15, 15));
        driver.addCheckpoint(new RestCheckpoint("C3", "Motel X", 25, 60, 65));
        driver.addCheckpoint(new DeliveryCheckpoint("C4", "Client Hub", 45, 50, 65));
        driver.printSummary();
    }
}
