import java.util.Date;
import java.util.HashSet;

public abstract class SystemEntry {
	private String name;
	private Date date;
	private String parentDirName;

	
	
	public SystemEntry(String name) {
		super();
		FileSystem sysNames=FileSystem.getInstance();
		if((!sysNames.allSys.containsKey(name))){
		this.name = name.substring(0, Math.min(name.length(), 32));
		this.date = new Date();
		this.parentDirName=null;
		}
	}


	public abstract void remove();
	public abstract HashSet<SystemEntry> print(HashSet<SystemEntry> s);
	
	public String getParentDirName() {
		return parentDirName;
	}

	public void setParentDirName(String parentDirName) {
		this.parentDirName = parentDirName;
	}

	public Date getDate() {
		return date;
	}

	public String getName() {
		return name;
	}


}
