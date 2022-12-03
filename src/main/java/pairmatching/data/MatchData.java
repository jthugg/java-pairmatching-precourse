package pairmatching.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchData {

	private Map<String, List<List<String>>> matches;

	public MatchData() {
		matches = new HashMap<>();
	}

	public boolean checkIsNull(String courseLevelMission) {
		if (matches.get(courseLevelMission) == null) {
			return true;
		}
		return false;
	}

	public void savePair(List<String> courseLevelMission, List<List<String>> pair) {
		matches.put(courseLevelMission.toString(), pair);
		printPair(courseLevelMission);
	}

	public void printPair(List<String> courseLevelMission) {
		List<List<String>> pair = matches.get(courseLevelMission.toString());
		System.out.println("페어 매칭 결과입니다.");
		for (List<String> match : pair) {
			System.out.println(match.toString().replaceAll(", ", " : ")
					.replace("[", "").replace("]", ""));
		}
	}
}
