package pairmatching.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import pairmatching.data.CrewData;

public class PairMatcher {

	private static CrewData crew = new CrewData();

	public static List<List<String>> match(String course) {
		List<String> crew = Randoms.shuffle(getCrewByCourse(course));
		return makePair(crew);
	}

	private static List<String> getCrewByCourse(String course) {
		return crew.getCrew(course);
	}

	private static List<List<String>> makePair(List<String> crew) {
		return checkNumberOfCrew(crew);
	}

	private static List<List<String>> checkNumberOfCrew(List<String> crew) {
		if (crew.size() % 2 == 0) {
			return makeEvenPair(crew);
		}
		return makeOddPair(crew);
	}

	public static List<List<String>> makeEvenPair(List<String> names) {
		List<List<String>> pairs = new ArrayList<>();
		for (int index = 0; index < names.size() - 1; index += 2) {
			pairs.add(names.subList(index, index + 2));
		}
		return pairs;
	}

	public static List<List<String>> makeOddPair(List<String> names) {
		List<List<String>> pairs = new ArrayList<>();
		for (int index = 0; index < names.size() - 1; index += 2) {
			pairs.add(matchOdd(names, pairs, index));
		}
		return pairs;
	}

	public static List<String> matchOdd(List<String> names, List<List<String>> pairs, int index) {
		if (pairs.size() == names.size() / 2 - 1) {
			return names.subList(index, index + 3);
		}
		return names.subList(index, index + 2);
	}
}
