package SEAssignment2;

public class StandardComputerPartsFactory extends ComputerPartsFactory {

	@Override
	public CPU createCPU(String CPUType) {
		if (CPUType == null){
			return null;
		}
		
		if(CPUType.equalsIgnoreCase("Standard")){
			return new StandardCPU();
		}
		return null;
	}

	@Override
	public Monitor createMonitor(String MonitorType) {
		if (MonitorType == null){
			return null;
		}
		
		if(MonitorType.equalsIgnoreCase("Standard")){
			return new StandardMonitor();
		}
		return null;
	}

	@Override
	public Keyboard createKeyboard(String KeyboardType) {
		if (KeyboardType == null){
			return null;
		}
		
		if(KeyboardType.equalsIgnoreCase("Standard")){
			return new StandardKeyboard();
		}
		return null;
	}

}
