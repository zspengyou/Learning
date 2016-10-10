package utils;

import java.io.File;
import java.io.FilenameFilter;

public class GetAllTestFile {

	public static void main(String[] args) {
		File[] files = getAllTestFile("\\src\\percolation");
		for (File file: files){
			System.out.println(file);
			
		}

	}
	public static File[] getAllTestFile(String folder){
		String current = System.getProperty("user.dir");
		System.out.println("current dir : "  + current);
		File dir = new File(current + folder);
		File [] files = dir.listFiles(new FilenameFilter() {			
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".txt");
			}
		});
		return files;
		
	}

}
