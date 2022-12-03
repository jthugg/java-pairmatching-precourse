package pairmatching.controllers;

import java.util.List;
import pairmatching.data.MatchData;
import pairmatching.data.MatchHistory;
import pairmatching.utils.PairMatcher;

public class ProgramController {

	private MatchData matches = new MatchData();
	private MatchHistory history = new MatchHistory();

	public ProgramController() {
		runProgram();
	}

	private void runProgram() {
		selectMenu();
	}

	private void selectMenu() {
		String selection = IOController.requestMenuSelection();
		if (selection.equals("Q")) {
			return;
		}
		runSelectedMenu(selection);
		selectMenu();
	}

	private void runSelectedMenu(String selection) {
		ifMenu1(selection);
		ifMenu2(selection);
		ifMenu3(selection);
	}

	private void ifMenu1(String selection) {
		if (selection.equals("1")) {
			runMatchPairSequence();
		}
	}

	private void runMatchPairSequence() {
		IOController.printTable();
		IOController.printRequestCourseLevelMission();
		checkLegacyMatches(IOController.requestCourseLevelMission());
	}

	private void checkLegacyMatches(List<String> courseLevelMission) {
		if (!matches.checkIsNull(courseLevelMission.toString())) {
			if (IOController.requestYesOrNo().equals("아니오")) {
				return;
			}
		}
		checkCount(courseLevelMission, 0);
	}

	private void checkCount(List<String> courseLevelMission, int count) {
		if (count >= 3) {
			IOController.printMatchUnable();
			return;
		}
		matchPair(courseLevelMission, count);
	}

	private void matchPair(List<String> courseLevelMission, int count) {
		List<List<String>> pair = PairMatcher.match(courseLevelMission.get(0));
		if (history.checkHistory(courseLevelMission, pair)) {
			checkCount(courseLevelMission, ++count);
		}
		matches.savePair(courseLevelMission, pair);
		history.saveHistory(courseLevelMission, pair);
		IOController.printMatchResult(pair);
	}

	private void ifMenu2(String selection) {
		if (selection.equals("2")) {
			runPrintPairSequence();
		}
	}

	private void runPrintPairSequence() {
		IOController.printTable();
		IOController.printRequestCourseLevelMission();
		printPair(IOController.requestCourseLevelMission());
	}

	private void printPair(List<String> courseLevelMission) {
		try {
			matches.printPair(courseLevelMission);
		} catch (NullPointerException exception) {
			System.out.println("[ERROR] 매칭 이력이 없습니다.");
		}
	}

	private void ifMenu3(String selection) {
		if (selection.equals("3")) {
			runClearPairSequence();
		}
	}

	private void runClearPairSequence() {
		matches = new MatchData();
		history = new MatchHistory();
		IOController.printClearResult();
	}
}
