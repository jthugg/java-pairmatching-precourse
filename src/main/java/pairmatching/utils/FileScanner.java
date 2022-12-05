package pairmatching.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileScanner {

	public Scanner getFrontendFile() {
		File file = new File(FilePath.FRONTEND.getFrontendPath());
		try {
			return new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println(ErrorMessages.FILE_NOT_FOUND_ERROR);
			throw new RuntimeException(e);
		}
	}

	public Scanner getBackendFile() {
		File file = new File(FilePath.BACKEND.getBackendPath());
		try {
			return new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println(ErrorMessages.FILE_NOT_FOUND_ERROR);
			throw new RuntimeException(e);
		}
	}
}
