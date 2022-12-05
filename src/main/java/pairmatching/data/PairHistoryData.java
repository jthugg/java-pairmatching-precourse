package pairmatching.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PairHistoryData {

	private Map<String, List<String>> history; // level+name / name, name, name

	public PairHistoryData() {
		history = new HashMap<>();
	}

	public boolean checkHistory(List<String> courseLevelMission, List<List<String>> pair) {
		for(List<String> match : pair) {
			if(history.get(courseLevelMission.get(1) + match.get(0)) != null &&
					(history.get(courseLevelMission.get(1) + match.get(0)).contains(match.get(1)) ||
					ifHasAnotherPair(courseLevelMission, match))) {
				return true;
			}
		}
		return false;
	}

	private boolean ifHasAnotherPair(List<String> courseLevelMission, List<String> match) {
		if(match.size() == 3) {
			return history.get(courseLevelMission.get(1) + match.get(0)).contains(match.get(2));
		}
		return false;
	}

	public void savePair(List<String> courseLevelMission, List<List<String>> pair) {
		for(List<String> match : pair) {
			for(String name : match) {
				List<String> historyData = checkLegacyIsNull(history.get(courseLevelMission.get(1)));
				historyData.addAll(getPairsName(match, name));
				history.put(courseLevelMission.get(1) + name, historyData);
			}
		}
	}

	private List<String> checkLegacyIsNull(List<String> names) {
		if(names == null) {
			return new ArrayList<>();
		}
		return names;
	}

	private List<String> getPairsName(List<String> match, String name) {
		return match.stream().filter(myName -> !myName.equals(name)).collect(Collectors.toList());
	}
}
