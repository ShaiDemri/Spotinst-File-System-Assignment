import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) {

		Directory root=new Directory("root");
		addFile("root","first",10 );
		addDir("root", "dirInRoot");
		addFile("dirInRoot","second",20 );
		addDir("root","dInR");
		addFile("dInR","third",30 );
		addFile("dInR","forth",40 );
		addFile("dInR","fifth",50 );


		showFileSystem();

	}


	public static String delete(String name) {
		FileSystem sysNames=FileSystem.getInstance();
		if(sysNames.allSys.containsKey(name)){
			sysNames.allSys.get(name).remove();
		}
		sysNames.allSys.remove(name);
		return name + " deleted successfully from the system." ;
	}






	public static String showFileSystem(){
		FileSystem sysNames=FileSystem.getInstance();
		HashSet<SystemEntry> s = new HashSet<SystemEntry>();
		Map<String, SystemEntry> sysMap = sysNames.allSys;
		Iterator<Entry<String, SystemEntry>> it = sysMap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String,SystemEntry> pair = (Map.Entry)it.next();
			if(!s.contains(pair.getValue())){
			s=pair.getValue().print(s);
			}
			it.remove(); 
		}
		return null;
	} 


	public static String addFile (String parentDirName, String fileName, Integer fileSize){
		FileSystem sysNames=FileSystem.getInstance();
		if((!sysNames.allSys.containsKey(fileName))){


			if(sysNames.allSys.containsKey(parentDirName)){
				File file= new File(fileName,fileSize);
				Directory parDir = (Directory) sysNames.allSys.get(parentDirName);
				parDir.addSysObj(file);
				file.setParentDirName(parentDirName);

			}else{
				return "ERROR "+ parentDirName + " does not exist!";
			}


			return "File " + fileName + " added successfully to " + parentDirName ;
		}
		return "Error File "+ fileName+ " already exists.";
	}


	public static String addDir(String parentDirName, String dirName){
		FileSystem sysNames=FileSystem.getInstance();
		if((!sysNames.allSys.containsKey(dirName))){

			if(sysNames.allSys.containsKey(parentDirName)){
				Directory parDir = (Directory) sysNames.allSys.get(parentDirName);
				Directory dir = new Directory(dirName);
				parDir.getSysObj().add(dir);
				dir.setParentDirName(parentDirName);

			}else{
				return "ERROR "+ parentDirName + " does not exist!";
			}

			return "Directory " + dirName + " added successfully to " + parentDirName ;
		}
		return "Error File "+ dirName+ " already exists.";
	}

}
