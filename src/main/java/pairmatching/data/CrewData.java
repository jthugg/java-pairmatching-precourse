package pairmatching.data;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pairmatching.utils.FileScanner;

public class CrewData {

	private Map<String, List<String>> crew;

	public CrewData() {
		crew = new HashMap<>();
		try {
			readFile();
		} catch (FileNotFoundException exception) {
			System.out.println("[ERROR] File Not Found.");
		}
	}

	private void readFile() throws FileNotFoundException {
		crew.put("프론트엔드", FileScanner.getFrontendData());
		crew.put("백엔드", FileScanner.getBackendData());
	}

	public List<String> getCrew(String course) {
		return crew.get(course);
	}
}
