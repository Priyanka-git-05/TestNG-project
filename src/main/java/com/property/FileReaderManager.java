package com.property;

public class FileReaderManager {
	
	private FileReaderManager(){//Constructor to restrict of this class from another class
		
	}
	public static FileReaderManager getInstanseFileReaderManager() {
		//that returns the instance of that class,global point access to get the access of SDP.
		FileReaderManager frm = new FileReaderManager();
		return frm;
		
	}
	
	public ConfigReader getInstanceConfig() {
		ConfigReader cr = new ConfigReader();
		return cr;
		
	}

}
