package pairmatching.data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pairmatching.utils.ErrorMessages;

public class MissionData {

	private Map<String, List<String>> missionData;

	public MissionData() {
		missionData = new HashMap<>();
		initData();
	}

	private void initData() {
		missionData.put(Arrays.asList("프론트엔드", "레벨1").toString(), Arrays.asList("자동차경주", "로또", "숫자야구게임"));
		missionData.put(Arrays.asList("백엔드", "레벨1").toString(), Arrays.asList("자동차경주", "로또", "숫자야구게임"));
		missionData.put(Arrays.asList("프론트엔드", "레벨2").toString(), Arrays.asList("장바구니", "결제", "지하철노선도"));
		missionData.put(Arrays.asList("백엔드", "레벨2").toString(), Arrays.asList("장바구니", "결제", "지하철노선도"));
		missionData.put(Arrays.asList("프론트엔드", "레벨4").toString(), Arrays.asList("성능개선", "배포"));
		missionData.put(Arrays.asList("백엔드", "레벨4").toString(), Arrays.asList("성능개선", "배포"));
	}

	public void checkCourseLevelMission(List<String> courseLevelMission) {
		String missionKey = courseLevelMission.subList(0, 2).toString();
		List<String> missions = missionData.get(missionKey);
		if(!missions.contains(courseLevelMission.get(2))) {
			throw new IllegalArgumentException(ErrorMessages.INVALID_INPUT_ERROR);
		}
	}
}
