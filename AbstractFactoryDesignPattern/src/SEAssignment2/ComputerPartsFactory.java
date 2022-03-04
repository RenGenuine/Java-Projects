package SEAssignment2;

public abstract class ComputerPartsFactory {
	abstract CPU createCPU(String CPU);
	abstract Monitor createMonitor(String Monitor);
	abstract Keyboard createKeyboard(String Keyboard);
}
