package WeatherAlertNotification;

public class SmsService extends Service{
	
	public SmsService(Notifier notifier){
		this.notifier = notifier;
		this.notifier.attach(this);
	}
	
	@Override
	public void update(){
		System.out.println("SMS Update: Classes today will be " + notifier.getState());
	}
}
