package pairmatching.utils;

import java.util.List;

public class Ui {

	public static void printMenu() {
		System.out.println("기능을 선택하세요.");
		System.out.println("1. 페어 매칭");
		System.out.println("2. 페어 조회");
		System.out.println("3. 페어 초기화");
		System.out.println("Q. 종료");
	}

	public static void printTable() {
		printHeader();
		printContent();
		printFooter();
	}

	private static void printHeader() {
		System.out.println("#############################################\n" +
				"과정: 백엔드 | 프론트엔드\n" +
				"미션:");
	}

	private static void printContent() {
		System.out.println("  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n" +
				"  - 레벨2: 장바구니 | 결제 | 지하철노선도\n" +
				"  - 레벨3:\n" +
				"  - 레벨4: 성능개선 | 배포\n" +
				"  - 레벨5:"
		);
	}

	private static void printFooter() {
		System.out.println("#############################################");
	}

	public static void printRequestCourseLevelMission() {
		System.out.println("과정, 레벨, 미션을 선택하세요.\nex) 백엔드, 레벨1, 자동차경주");
	}

	public static void printRequestYesOrNo() {
		System.out.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n네 | 아니오");
	}

	public static void printMatchUnable() {
		System.out.println("[ERROR] 매치 할 수 있는 경우의 수가 없습니다.");
	}

	public static void printClearResult() {
		System.out.println("초기화 되었습니다.");
	}

	public static void printMatchResult(List<List<String>> pair) {
		for (List<String> matches : pair) {
			System.out.println(matches.toString()
					.replaceAll(", ", " : ")
					.replace("[", "")
					.replace("]", ""));
		}
	}
}
