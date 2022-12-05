package pairmatching.utils;

public enum Ui {

	MENU("기능을 선택해주세요.\n1. 페어 매칭\n2. 페어 조회\n3. 페어 초기화\nQ. 종료"),
	TABLE("#############################################\n"
			+ "과정: 백엔드 | 프론트엔드\n"
			+ "미션:\n"
			+ "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
			+ "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
			+ "  - 레벨3: \n"
			+ "  - 레벨4: 성능개선 | 배포\n"
			+ "  - 레벨5: \n"
			+ "############################################"),
	REQUEST_COURSE_LEVEL_MISSION("과정, 레벨, 미션을 선택하세요.\nex) 백엔드, 레벨1, 자동차경주"),
	MATCH_RESULT("페어 매칭 결과입니다."),
	REMATCH("매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n네 | 아니오"),
	CLEAR("초기화 되었습니다.");

	private String value;

	Ui(String value) {
		this.value = value;
	}

	public static void printSelectMenu() {
		System.out.println(MENU.value);
	}

	public static void printTable() {
		System.out.println(TABLE.value);
	}

	public static void printRequestCourseLevelMission() {
		System.out.println(REQUEST_COURSE_LEVEL_MISSION.value);
	}

	public static void printMatchResult() {
		System.out.println(MATCH_RESULT.value);
	}

	public static void printRematch() {
		System.out.println(REMATCH.value);
	}

	public static void printClear() {
		System.out.println(CLEAR.value);
	}
}
