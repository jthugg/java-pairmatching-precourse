package pairmatching.data;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import pairmatching.utils.FileScanner;

public class CrewData {

	private Map<String, List<String>> crewData; // course - a, b, c...

	public CrewData() {
		crewData = new HashMap<>();
		readFrontendFile();
		readBackendFile();
	}

	private void readFrontendFile() {
		FileScanner fileScanner = new FileScanner();
		Scanner scanner = fileScanner.getFrontendFile();
		List<String> names = new ArrayList<>();
		while(scanner.hasNext()) {
			names.add(scanner.nextLine());
		}
		crewData.put("프론트엔드", names);
	}

	private void readBackendFile() {
		FileScanner fileScanner = new FileScanner();
		Scanner scanner = fileScanner.getBackendFile();
		List<String> names = new ArrayList<>();
		while(scanner.hasNext()) {
			names.add(scanner.nextLine());
		}
		crewData.put("백엔드", names);
	}

	public List<String> getCrewByCourse(String course) {
		return crewData.get(course);
	}
}
