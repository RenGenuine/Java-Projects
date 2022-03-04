package WeatherAlertNotification;
import java.util.ArrayList;
import java.util.List;

public class Notifier{
	
	private List<Service> services = new ArrayList<Service>();
	private String state;
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
		notifyAllServices();
	}
	
	public void attach(Service service){
		services.add(service);
	}
	
	public void notifyAllServices(){
		for (Service service : services){
			service.update();
		}
	}
}
