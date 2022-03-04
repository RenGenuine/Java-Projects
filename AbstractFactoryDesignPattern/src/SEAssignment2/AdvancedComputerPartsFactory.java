package SEAssignment2;

public class AdvancedComputerPartsFactory extends ComputerPartsFactory{
	
	@Override
	public CPU createCPU(String CPUType){
		
		if(CPUType == null){
			return null;
		}
		if(CPUType.equalsIgnoreCase("Advanced")){
			return new AdvancedCPU();
		}
		
			return null;
	}

	@Override
	public Monitor createMonitor(String MonitorType) {
		
		if (MonitorType == null){
			return null;
		}
		if (MonitorType.equalsIgnoreCase("Advanced")){
			return new AdvancedMonitor();
		}
		
		return null;
	}

	@Override
	public Keyboard createKeyboard(String KeyboardType) {
		
		if (KeyboardType == null){
			return null;
		}
		if (KeyboardType.equalsIgnoreCase("Advanced")){
			return new AdvancedKeyboard();
		}
		
		return null;
	}
}
