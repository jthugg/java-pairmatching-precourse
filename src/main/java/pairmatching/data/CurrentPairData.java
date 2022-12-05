package pairmatching.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurrentPairData {

	private Map<String, List<List<String>>> currentPairData;

	public CurrentPairData() {
		currentPairData = new HashMap<>();
	}

	public boolean checkIsNull(List<String> courseLevelMission) {
		return currentPairData.get(courseLevelMission.toString()) == null;
	}

	public void savePair(List<String> courseLevelMission, List<List<String>> pair) {
		currentPairData.put(courseLevelMission.toString(), pair);
	}

	public void printMatchResult(List<String> courseLevelMission) {
		for(List<String> matches : currentPairData.get(courseLevelMission.toString())) {
			System.out.println(matches.toString().replaceAll(", ", " : ")
					.replace("[", "").replace("]", ""));
		}
	}
}
