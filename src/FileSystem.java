import java.util.HashMap;

public class FileSystem {
	protected HashMap<String,SystemEntry> allSys;

	private FileSystem() {
		this.allSys=new HashMap<String,SystemEntry>();
	}

	private static class systemObjectsHolder {
		private static final FileSystem INSTANCE = new FileSystem();
	}

	public static FileSystem getInstance() {
		return systemObjectsHolder.INSTANCE;
	}
}
