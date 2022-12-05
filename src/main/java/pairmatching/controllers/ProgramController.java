package pairmatching.controllers;

import java.util.List;
import pairmatching.data.CurrentPairData;
import pairmatching.data.PairHistoryData;
import pairmatching.utils.ErrorMessages;
import pairmatching.utils.PairMatcher;
import pairmatching.utils.Ui;
import pairmatching.utils.UserInput;

public class ProgramController {

	private CurrentPairData pairData = new CurrentPairData();
	private PairHistoryData historyData = new PairHistoryData();

	public void runProgramSequence() {
		String selection = requestSelectMenu();
		if(selection.equals("Q")) {
			return;
		}
		selectMenu(selection);
		runProgramSequence();
	}

	private String requestSelectMenu() {
		try {
			return UserInput.requestSelectMenu();
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return requestSelectMenu();
		}
	}

	private void selectMenu(String selection) {
		ifSelectMatchPair(selection);
		ifSelectPrintPair(selection);
		ifSelectClearPair(selection);
	}

	private void ifSelectMatchPair(String selection) {
		if(selection.equals("1")) {
			Ui.printTable();
			List<String> courseLevelMission = requestCourseLevelMission();
			checkCount(courseLevelMission, 0);
			Ui.printMatchResult();
			pairData.printMatchResult(courseLevelMission);
		}
	}

	private List<String> requestCourseLevelMission() {
		try {
			return UserInput.requestCourseLevelMission();
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return requestCourseLevelMission();
		}
	}

	private void checkCount(List<String> courseLevelMission, int count) {
		if(count >= 3) {
			throw new IllegalArgumentException(ErrorMessages.MATCH_FAILED_ERROR);
		}
		checkAlreadyMatched(courseLevelMission, count);
	}

	private void checkAlreadyMatched(List<String> courseLevelMission, int count) {
		if(!pairData.checkIsNull(courseLevelMission)) {
			if(requestYesOrNo().equals("아니오")) {
				return;
			}
		}
		matchPair(courseLevelMission, count);
	}

	private String requestYesOrNo() {
		try {
			return UserInput.requestYesOrNo();
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return requestYesOrNo();
		}
	}

	private void matchPair(List<String> courseLevelMission, int count) {
		List<List<String>> pair = PairMatcher.match(courseLevelMission);
		if(historyData.checkHistory(courseLevelMission, pair)) {
			checkCount(courseLevelMission, ++count);
		}
		savePair(courseLevelMission, pair);
	}

	private void savePair(List<String> courseLevelMission, List<List<String>> pair) {
		pairData.savePair(courseLevelMission, pair);
		historyData.savePair(courseLevelMission, pair);
	}

	private void ifSelectPrintPair(String selection) {
		if(selection.equals("2")) {
			Ui.printTable();
			List<String> courseLevelMission = UserInput.requestCourseLevelMission();
			checkIsNull(courseLevelMission);
		}
	}

	private void checkIsNull(List<String> courseLevelMission) {
		if(pairData.checkIsNull(courseLevelMission)) {
			System.out.println(ErrorMessages.CURRENT_MATCH_NOT_FOUND);
			return;
		}
		Ui.printMatchResult();
		pairData.printMatchResult(courseLevelMission);
	}

	private void ifSelectClearPair(String selection) {
		if(selection.equals("3")) {
			Ui.printClear();
			pairData = new CurrentPairData();
			historyData = new PairHistoryData();
		}
	}
}
