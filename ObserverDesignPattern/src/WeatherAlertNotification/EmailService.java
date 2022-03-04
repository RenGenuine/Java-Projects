package WeatherAlertNotification;

public class EmailService extends Service{
	
	public EmailService(Notifier notifier){
		this.notifier = notifier;
		this.notifier.attach(this);
	}
	
	@Override
	public void update(){
		System.out.println("Email Update: Classes today will be " + notifier.getState());
	}
}
