package WeatherAlertNotification;

public class DecisionEngine extends Notifier{
	public static void main(String[] args) {
		
		Notifier notifier = new Notifier();
		
		new EmailService(notifier);
		new CallService(notifier);
		new SmsService(notifier);
		
		System.out.println("//When classes are cancelled:");
		notifier.setState("cancelled");
		
		System.out.println("//When classes are not cancelled:");
		notifier.setState("not cancelled");
	}
}
