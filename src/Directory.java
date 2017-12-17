import java.util.ArrayList;
import java.util.HashSet;


public class Directory extends SystemEntry {
	ArrayList<SystemEntry> sysObj;




	public Directory(String name) {
		super(name);
		FileSystem sysNames=FileSystem.getInstance();
		this.sysObj = new ArrayList<SystemEntry>();
		sysNames.allSys.put(name,this);
	}






	public void remove(){//Directory
		FileSystem sysNames=FileSystem.getInstance();
		String parDir=this.getParentDirName();
		if(parDir!=null){
			Directory parentDir=((Directory)sysNames.allSys.get(parDir));
			parentDir.removeObj(this);
		}
		for (SystemEntry se : sysObj) {
			sysNames.allSys.remove(se.getName());
		}
		sysObj=null;
		
	}


	@Override
	public HashSet<SystemEntry> print(HashSet<SystemEntry> s) {
		if(!s.contains(this)){
		System.out.print("Directory name=" + super.getName() + " Date=" + super.getDate() +" dirs and file: ");
		for(SystemEntry se: sysObj){
			if(!s.contains(se)){
				s=se.print(s);
			}
		}
		
		System.out.println();
		s.add(this);
		}
		return s;
	}




	public void removeObj(SystemEntry e){
		this.sysObj.remove(e);
	}

	public ArrayList<SystemEntry> getSysObj() {
		return sysObj;
	}

	public void addSysObj(SystemEntry sysObj) {
		this.sysObj.add(sysObj);

	}








}
