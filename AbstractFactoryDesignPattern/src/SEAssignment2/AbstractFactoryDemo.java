package SEAssignment2;

public class AbstractFactoryDemo {

	public static void main(String[] args) {
		
		//call standard parts factory
		ComputerPartsFactory standardComputerPartsFactory = Computer.callFactory("Standard");
		
		//create an object of standard CPU part
		CPU cpu1 = standardComputerPartsFactory.createCPU("Standard");
		
		//call attach method of Standard CPU
		cpu1.attach();
		
		//create an object of standard Monitor part
		Monitor monitor1 = standardComputerPartsFactory.createMonitor("Standard");
		
		//call attach method of Standard Monitor part
		monitor1.attach();
		
		//create an object of standard Keyboard part
		Keyboard keyboard1 = standardComputerPartsFactory.createKeyboard("Standard");
		//call attach method of standard Keyboard part
		keyboard1.attach();
		
		//call advanced parts factory
		ComputerPartsFactory advancedComputerPartsFactory = Computer.callFactory("Advanced");
		
		//create an object of advanced CPU
		CPU cpu2 = advancedComputerPartsFactory.createCPU("Advanced");
		
		//call attach method of advanced CPU
		cpu2.attach();
		
		//create an object of advanced monitor
		Monitor monitor2 = advancedComputerPartsFactory.createMonitor("Advanced");
		
		//call attach method of advanced Monitor
		monitor2.attach();
		
		//create an object of advanced keyboard
		Keyboard keyboard2 = advancedComputerPartsFactory.createKeyboard("Advanced");
		
		//call attach method of advanced keyboard
		keyboard2.attach();
	}

}
