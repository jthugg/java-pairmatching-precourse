package pairmatching.controllers;

import java.util.List;
import pairmatching.utils.Input;
import pairmatching.utils.Ui;

public class IOController {

	public static String requestMenuSelection() {
		try {
			Ui.printMenu();
			return Input.requestMenuSelection();
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return requestMenuSelection();
		}
	}

	public static void printTable() {
		Ui.printTable();
	}

	public static void printRequestCourseLevelMission() {
		Ui.printRequestCourseLevelMission();
	}

	public static List<String> requestCourseLevelMission() {
		try {
			return Input.requestCourseLevelMission();
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return requestCourseLevelMission();
		}
	}

	public static String requestYesOrNo() {
		try {
			Ui.printRequestYesOrNo();
			return Input.requestYesOrNo();
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return requestYesOrNo();
		}
	}

	public static void printMatchUnable() {
		Ui.printMatchUnable();
	}

	public static void printClearResult() {
		Ui.printClearResult();
	}

	public static void printMatchResult(List<List<String>> pair) {
		Ui.printMatchResult(pair);
	}
}
