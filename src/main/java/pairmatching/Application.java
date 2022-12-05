package pairmatching;

import pairmatching.controllers.ProgramController;

public class Application {

	public static void main(String[] args) {
		ProgramController program = new ProgramController();
		try {
			program.runProgramSequence();
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			program.runProgramSequence();
		}
	}
}
