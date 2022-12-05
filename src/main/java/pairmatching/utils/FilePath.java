package pairmatching.utils;

public enum FilePath {

	FRONTEND("/src/main/resources/frontend-crew.md"),
	BACKEND("/src/main/resources/backend-crew.md");

	private String value;

	FilePath(String value) {
		String directory = System.getProperty("user.dir");
		this.value = directory + value;
	}

	public String getFrontendPath() {
		return FRONTEND.value;
	}

	public String getBackendPath() {
		return BACKEND.value;
	}
}
