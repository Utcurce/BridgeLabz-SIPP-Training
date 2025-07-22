import java.util.LinkedList;
import java.util.Queue;

interface Notification {
    void send();  // Abstract method to send notification
}

public class Email_Notification_System  implements Notification{
    private  String email;
    private  String  message;

    public Email_Notification_System(String email,String message){
        this.email=email;
        this.message=message;
    }
    @Override
    public void send() {
        System.out.println("Sending Email to " + email + ": " + message);
    }

}

 class SMS_Notification_System  implements Notification{
    private  String phone;
    private  String  message;

    public SMS_Notification_System(String phone,String message){
        this.phone=phone;
        this.message=message;
    }
    @Override
    public void send() {
        System.out.println("Sending phone  to " + phone + ": " + message);
    }

}

 class push_Notification_System  implements Notification{
    private  String diviceId;
    private  String  message;

    public push_Notification_System(String diviceId,String message){
        this.diviceId=diviceId;
        this.message=message;
    }
    @Override
    public void send() {
        System.out.println("Sending  push_Notification to " + diviceId + ": " + message);
    }

}

 class NotificationQueue {
    private Queue<Notification> queue;

    public NotificationQueue() {
        queue = new LinkedList<>();
    }

    public void add(Notification notification) {
        queue.offer(notification);
    }

    public void sendAll() {
        while (!queue.isEmpty()) {
            Notification notification = queue.poll();
            notification.send();
        }
    }
}
class Cain{
    public static void main(String[] args) {
        NotificationQueue queue=new NotificationQueue();
        queue.add (new Email_Notification_System ("abhishekcs22@gmail.com","hi welcome to notification system"));
        queue.add(new SMS_Notification_System("+916387705166","hi welcome massage"));
        queue.add(new push_Notification_System("alpha12","hi push notification"));
        queue.sendAll();


    }
}