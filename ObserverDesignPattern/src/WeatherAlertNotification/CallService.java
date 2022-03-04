package WeatherAlertNotification;

public class CallService extends Service{
	
	public CallService(Notifier notifier){
		this.notifier = notifier;
		this.notifier.attach(this);
	}
	
	@Override
	public void update(){
		System.out.println("Call Update: Classes today will be " + notifier.getState());
	}
}
