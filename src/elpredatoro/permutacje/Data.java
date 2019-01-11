package elpredatoro.permutacje;

public class Data {
	private String version;
	private Integer majorVersion = 0;
	private Integer minorVersion = 4;
	
	public Data() {
		version = majorVersion.toString() + "." + minorVersion.toString();
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getMajorVersion() {
		return majorVersion;
	}

	public void setMajorVersion(Integer majorVersion) {
		this.majorVersion = majorVersion;
	}

	public int getMinorVersion() {
		return minorVersion;
	}

	public void setMinorVersion(Integer minorVersion) {
		this.minorVersion = minorVersion;
	}
}
