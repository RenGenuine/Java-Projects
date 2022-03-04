package SEAssignment2;

public class Computer {
	public static ComputerPartsFactory callFactory(String choice){
		if(choice.equalsIgnoreCase("Standard")){
			return new StandardComputerPartsFactory();
		}
		
		else if (choice.equalsIgnoreCase("Advanced")){
			return new AdvancedComputerPartsFactory();
		}
		
		return null;
	}
}
