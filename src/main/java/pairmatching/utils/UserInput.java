package pairmatching.utils;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import pairmatching.data.MissionData;

public class UserInput {

	public static String requestSelectMenu() {
		try {
			Ui.printSelectMenu();
			return validateMenuSelection(Console.readLine());
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return requestSelectMenu();
		}
	}

	private static String validateMenuSelection(String userInput) {
		if(!Pattern.matches("^[1-3]|Q$", userInput)) {
			throw new IllegalArgumentException(ErrorMessages.INVALID_INPUT_ERROR);
		}
		return userInput;
	}

	public static List<String> requestCourseLevelMission() {
		try {
			Ui.printRequestCourseLevelMission();
			return validateSplit(Console.readLine());
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return requestCourseLevelMission();
		}
	}

	private static List<String> validateSplit(String userInput) {
		List<String> courseLevelMission = Arrays.asList(userInput.split(", "));
		if(courseLevelMission.size() != 3) {
			throw new IllegalArgumentException(ErrorMessages.INVALID_INPUT_ERROR);
		}
		return checkMissionData(courseLevelMission);
	}

	private static List<String> checkMissionData(List<String> courseLevelMission) {
		MissionData missionData = new MissionData();
		missionData.checkCourseLevelMission(courseLevelMission);
		return courseLevelMission;
	}

	public static String requestYesOrNo() {
		Ui.printRematch();
		return validateYesOrNo(Console.readLine());
	}

	private static String validateYesOrNo(String answer) {
		if(!Pattern.matches("^네|아니오$", answer)) {
			throw new IllegalArgumentException(ErrorMessages.INVALID_INPUT_ERROR);
		}
		return answer;
	}
}
