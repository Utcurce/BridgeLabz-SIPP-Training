import java.sql.SQLOutput;

public class Vehicle {
    String  ownerName;
    String vehicleType;

    public static int registrationFee=4000;

    Vehicle(String ownerName,String vehicleType){
        this.vehicleType=vehicleType;
        this.ownerName=ownerName;
    }

    void  displayVehicleDetails(){
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType );
        System.out.println("Registration Fee: "+registrationFee);

    }
    public static void updateRegistrationFee(int NewFee){
        registrationFee=NewFee;
    }

    public static void main(String[] args) {
        Vehicle.updateRegistrationFee(4500);
        Vehicle v1=new Vehicle("anuj","Honda");
        Vehicle v2=new Vehicle("vikash","TVS");
        v1.displayVehicleDetails();
        System.out.println();
        v2.displayVehicleDetails();
        System.out.println();

    }
}
