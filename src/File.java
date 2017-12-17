import java.util.HashSet;

public class File extends SystemEntry {

	private long size; 

	public File(String n, long s){
		super(n);
		FileSystem sysNames=FileSystem.getInstance();

		if( s>0 ){

			this.size= s;
			sysNames.allSys.put(n,this);
		}
	}


	@Override
	public HashSet<SystemEntry> print(HashSet<SystemEntry> s) {
		if(!s.contains(this))
			System.out.println("File [name=" + super.getName() + ", size=" + size + ", date=" + super.getDate() + "]");
			s.add(this);
		return s;
	}

	@Override
	public void remove(){//File
		FileSystem sysNames=FileSystem.getInstance();
		String parDir=this.getParentDirName();
		if(parDir!=null){
			((Directory)sysNames.allSys.get(parDir)).removeObj(this);
		}

		size=0;
	}










}
