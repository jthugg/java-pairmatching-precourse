package pairmatching.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import pairmatching.data.CrewData;

public class PairMatcher {

	private static CrewData crew = new CrewData();

	public static List<List<String>> match(List<String> courseLevelMission) {
		List<String> crewNames = Randoms.shuffle(crew.getCrewByCourse(courseLevelMission.get(0)));
		return checkEvenOdd(crewNames);
	}

	private static List<List<String>> checkEvenOdd(List<String> crewNames) {
		if(crewNames.size() % 2 == 0) {
			return matchEvenPair(crewNames);
		}
		return matchOddPair(crewNames);
	}

	private static List<List<String>> matchEvenPair(List<String> crewNames) {
		List<List<String>> pair = new ArrayList<>();
		for(int i = 0; i < crewNames.size(); i += 2) {
			pair.add(crewNames.subList(i, i + 2));
		}
		return pair;
	}

	private static List<List<String>> matchOddPair(List<String> crewNames) {
		List<List<String>> pair = new ArrayList<>();
		for(int i = 0; i < crewNames.size() - 3; i += 2) {
			pair.add(crewNames.subList(i, i + 2));
		}
		pair.add(crewNames.subList(crewNames.size() - 3, crewNames.size()));
		return pair;
	}
}
