 class Device {
    String deviceId;
    String status;

    Device(String deviceId,String status){
        this.deviceId=deviceId;
        this.status=status;
    }
    void  showInfo(){
        System.out.println("DeviceID: "+deviceId+" Status: "+status);
    }
}
class Thermostat extends Device{
    String  temperatureSetting;
    Thermostat(String deviceId,String status,String temperatureSetting){
        super(deviceId,status);
        this.temperatureSetting=temperatureSetting;
    }

    @Override
    void showInfo(){
        super.showInfo();
        System.out.println("Temp Setting: "+temperatureSetting);
    }
}

class SmartHome{
    public static void main(String[] args) {
        Device s1=new Thermostat("SWQ314","Cold","Medium");
        Device s2=new Thermostat("SWQ213","Hot","fast");

        s1.showInfo();
        System.out.println();
        s2.showInfo();
    }
}
