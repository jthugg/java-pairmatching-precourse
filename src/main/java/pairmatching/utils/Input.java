package pairmatching.utils;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Input {

	public static String requestMenuSelection() {
		String selection = Console.readLine();
		if (!Pattern.matches("^[1-3]|Q$", selection)) {
			throw new IllegalArgumentException("[ERROR] ");
		}
		return selection;
	}

	public static List<String> requestCourseLevelMission() {
		String selection = Console.readLine();
		List<String> selections = Arrays.asList(selection.split(", "));
		validateSelections(selections);
		return selections;
	}

	private static void validateSelections(List<String> selections) {
		checkLength(selections);
		checkCourse(selections);
	}

	private static void checkLength(List<String> selections) {
		if (selections.size() != 3) {
			throw new IllegalArgumentException("[ERROR] ");
		}
	}

	private static void checkCourse(List<String> selections) {
		if (!Pattern.matches("^프론트엔드|백엔드$", selections.get(0))) {
			throw new IllegalArgumentException("[ERROR]");
		}
		checkLevel(selections);
	}

	private static void checkLevel(List<String> selections) {
		if (!Pattern.matches("^레벨1|레벨2|레벨4$", selections.get(1))) {
			throw new IllegalArgumentException("[ERROR] ");
		}
		checkMission(selections);
	}

	private static void checkMission(List<String> selections) {
		ifLevel1Selected(selections);
		ifLevel2Selected(selections);
		ifLevel3Selected(selections);
		ifLevel4Selected(selections);
		ifLevel5Selected(selections);
	}

	private static void ifLevel1Selected(List<String> selections) {
		if (selections.get(1).equals("레벨1")) {
			checkMissionLevel1(selections.get(2));
		}
	}

	private static void checkMissionLevel1(String mission) {
		if (!Pattern.matches("^자동차경주|로또|숫자야구게임$", mission)) {
			throw new IllegalArgumentException("[ERROR] ");
		}
	}

	private static void ifLevel2Selected(List<String> selections) {
		if (selections.get(1).equals("레벨2")) {
			checkMissionLevel2(selections.get(2));
		}
	}

	private static void checkMissionLevel2(String mission) {
		if (!Pattern.matches("^장바구니|결제|지하철노선도$", mission)) {
			throw new IllegalArgumentException("[ERROR] ");
		}
	}

	private static void ifLevel3Selected(List<String> selections) {
		if (selections.get(1).equals("레벨3")) {
			throw new IllegalArgumentException("[ERROR] ");
		}
	}

	private static void ifLevel4Selected(List<String> selections) {
		if (selections.get(1).equals("레벨4")) {
			checkMissionLevel4(selections.get(2));
		}
	}

	private static void checkMissionLevel4(String mission) {
		if (!Pattern.matches("^성능개선|배포$", mission)) {
			throw new IllegalArgumentException("[ERROR] ");
		}
	}

	private static void ifLevel5Selected(List<String> selections) {
		if (selections.get(1).equals("레벨5")) {
			throw new IllegalArgumentException("[ERROR] ");
		}
	}

	public static String requestYesOrNo() {
		String answer = Console.readLine();
		if (!Pattern.matches("^네|아니오$", answer)) {
			throw new IllegalArgumentException("[ERROR] ");
		}
		return answer;
	}
}
