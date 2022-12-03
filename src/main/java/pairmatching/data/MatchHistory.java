package pairmatching.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchHistory {

	private Map<String, List<List<String>>> history;

	public MatchHistory() {
		history = new HashMap<>();
	}

	public boolean checkHistory(List<String> courseLevelMission, List<List<String>> newPair) {
		if (history.get(courseLevelMission.subList(0, 2).toString()) == null) {
			return false;
		}
		return checkHistoryData(courseLevelMission, newPair);
	}

	private boolean checkHistoryData(List<String> courseLevelMission, List<List<String>> newPair) {
		List<List<String>> historyData = history.get(courseLevelMission.subList(0, 2).toString());
		return checkData(historyData, newPair);
	}

	private boolean checkData(List<List<String>> historyData, List<List<String>> newPair) {
		for (List<String> newMatch : newPair) {
			if (ifHistoryHasNewMatchSize2(historyData, newMatch)) {
				return true;
			}
		}
		return false;
	}

	private boolean ifHistoryHasNewMatchSize2(List<List<String>> historyData, List<String> newMatch) {
		if (newMatch.size() == 2) {
			if (historyData.contains(newMatch)) {
				return true;
			}
			return false;
		}
		return ifHistoryHasNewMatchSize3(historyData, newMatch);
	}

	private boolean ifHistoryHasNewMatchSize3(List<List<String>> historyData, List<String> newMatch) {
		for (int index = 0; index < newMatch.size(); index++) {
			String removedName = newMatch.get(index);
			newMatch.remove(removedName);
			if (historyData.contains(newMatch)) {
				return true;
			}
			newMatch.add(removedName);
		}
		return false;
	}

	public void saveHistory(List<String> courseLevelMission, List<List<String>> pair) {
		List<List<String>> pairData = getPairData(courseLevelMission);
		for (List<String> match : pair) {
			pairData.addAll(ifMatchSize2(match));
		}
		history.put(courseLevelMission.subList(0, 2).toString(), pairData);
	}

	private List<List<String>> getPairData(List<String> courseLevelMission) {
		if (history.get(courseLevelMission.subList(0, 2).toString()) == null) {
			return new ArrayList<>();
		}
		return history.get(courseLevelMission.subList(0, 2).toString());
	}

	private List<List<String>> ifMatchSize2(List<String> match) {
		List<List<String>> matches = new ArrayList<>();
		if (match.size() == 2) {
			matches.add(match);
			matches.add(reverseMatch(match));
			return matches;
		}
		return ifMatchSize3(new ArrayList<>(), match);
	}

	private List<String> reverseMatch(List<String> newMatch) {
		List<String> reversedMatch = new ArrayList<>();
		reversedMatch.add(newMatch.get(1));
		reversedMatch.add(newMatch.get(0));
		return reversedMatch;
	}

	private List<List<String>> ifMatchSize3(List<List<String>> matches, List<String> match) {
		for (int index = 0; index < match.size(); index++) {
			String removedName = match.get(0);
			match.remove(0);
			matches.add(match);
			matches.add(reverseMatch(match));
			match.add(removedName);
		}
		return matches;
	}
}
