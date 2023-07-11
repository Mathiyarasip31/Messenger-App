import java.util.Scanner;

interface MessagingService {
    void sendMessage();

}
class SMSMessagingService implements MessagingService
{
    @Override
    public void sendMessage() {
        Scanner scanner=new Scanner(System.in);
        long number=scanner.nextLong();
        String message=scanner.next();
        String str=String.valueOf(number);
        if(str.matches("[6-9]\\d{9}"))
        {
            System.out.println("To: "+message);
            System.out.println("Message: "+number);
        }
        else
        {
            System.out.println("Invalid Phone Number!!");
        }
    }
}
class EmailMessagingService implements MessagingService
{
    @Override
    public void sendMessage() {
        Scanner scanner=new Scanner(System.in);
        String email=scanner.next();
        System.out.println("Enter subject: ");
        String subject=scanner.next();
        System.out.println("Enter message: ");
        String message=scanner.next();
        if(email.matches("^[A-Za-z0-9+_.-]+@(.+)$"))
        {
            System.out.println("To: "+email);
            System.out.println("Subject: "+subject);
            System.out.println("Message: "+message);
        }
        else
        {
            System.out.println("Invalid email id");
        }
    }
}
class WhatsAppMessagingService implements MessagingService
{

    @Override
    public void sendMessage() {
        Scanner scanner=new Scanner(System.in);

        long number=scanner.nextLong();
        System.out.println("Enter your message: ");
        String message=scanner.next();
        System.out.println("Whatsapp user? YES/ NO ");
        String whatsapp=scanner.next();
        String str=String.valueOf(number);
        if(str.matches("[6-9]\\d{9}") && whatsapp.equals("YES"))
        {
            System.out.println("Message: "+number);
            System.out.println("Message sent to: "+message);

        }
        else if(!str.matches("[6-9]\\d{9}"))
        {
            System.out.println("Invalid number");
        }
        else if(whatsapp.equals("NO"))
        {
            System.out.println("doesn't exist in Whatsapp");
        }

    }

}
public class MessengerApp {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Do you want to a) SMS or b) WHATSAPP or c) EMAIL?");
        String ch=scanner.next();
        MessagingService smsMessagingService = new SMSMessagingService();
        MessagingService emailMessagingService = new EmailMessagingService();
        MessagingService whatsappMessagingService = new WhatsAppMessagingService();
        if(ch.equals("a"))
        {
            smsMessagingService.sendMessage();
        }
        else if(ch.equals("b"))
        {
            whatsappMessagingService.sendMessage();
        }
        else if(ch.equals("c"))
        {
            emailMessagingService.sendMessage();
        }
    }
}