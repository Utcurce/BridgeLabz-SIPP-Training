class Vehicle {
    int maxSpeed;
    String fuleType;

    Vehicle(int maxSpeed,String fuleType){
        this.maxSpeed=maxSpeed;
        this.fuleType=fuleType;
    }
    void displayInfo(){
        System.out.println("Max Speed: "+maxSpeed+"km/h| Fule Type: "+fuleType);
    }
}
class Car extends Vehicle{
    int seatCapacity;

    Car(int maxSpeed,String fuleType,int seatCapacity){
        super(maxSpeed,fuleType);
        this.seatCapacity=seatCapacity;
    }
    @Override
    void displayInfo(){
        System.out.println("Vehicle Type: Car | Seat Capacity: " + seatCapacity );
        super.displayInfo();
    }
}

class Truck extends Vehicle{

     double loadCapacity;

     Truck(int maxSpeed,String fuleType,double loadCapacity){
         super(maxSpeed,fuleType);
         this.loadCapacity=loadCapacity;
     }


    @Override
    void displayInfo(){

        System.out.println("Vehicle Type: Truck | Load Capacity: " + loadCapacity + " tons");
        super.displayInfo();
    }
}

class MoterCycle extends Vehicle{

    boolean hasCarrier;
    MoterCycle(int maxSpeed,String fuleType,boolean hasCarrier){
        super(maxSpeed,fuleType);
        this.hasCarrier=hasCarrier;
    }

    @Override
    void displayInfo(){

        System.out.println("Vehicle Type: MoterCycle | Has a Carrier: " + hasCarrier);
        super.displayInfo();
    }
}

class Transportion{
    public static void main(String[] args) {
        Vehicle[] vehicles=new Vehicle[3];

        vehicles[0]=new Car(120,"Petrol",4);
        vehicles[1]=new Truck(60,"Diesel",200);
        vehicles[2]=new MoterCycle(100,"Petrol",true);


        for(Vehicle v:vehicles){
            v.displayInfo();
            System.out.println();

        }
    }

}