package pairmatching.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileScanner {

	private static final String FRONT_END_PATH =
			"/Users/jt/wootecho-pre/mogakco/java-pairmatching-precourse/src/main/resources/frontend-crew.md";
	private static final String BACK_END_PATH =
			"/Users/jt/wootecho-pre/mogakco/java-pairmatching-precourse/src/main/resources/backend-crew.md";
	private static final File FRONT_END_CREW_MD = new File(FRONT_END_PATH);
	private static final File BACK_END_CREW_MD = new File(BACK_END_PATH);

	public static List<String> getFrontendData() throws FileNotFoundException {
		return getScanData(FRONT_END_CREW_MD);
	}

	public static List<String> getBackendData() throws FileNotFoundException {
		return getScanData(BACK_END_CREW_MD);
	}

	public static List<String> getScanData(File CREW_MD) throws FileNotFoundException {
		Scanner scanner = new Scanner(CREW_MD);
		List<String> names = new ArrayList<>();
		while (scanner.hasNext()) {
			names.add(scanner.nextLine());
		}
		return names;
	}
}
