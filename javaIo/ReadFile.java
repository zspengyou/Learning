package javaIo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

public class ReadFile {

	public static void main(String[] args) throws IOException {
		System.out.println(" begin read file" );
//		Files.readAllLines(path)
		File file = new File("C:\\share\\export.log");
		BufferedReader br = new BufferedReader(new FileReader(file));
//		OutputStream os = new FileOutputStream(file);
//		BufferedOutputStream bs = new BufferedOutputStream(os);
		int line = 10099;
		for(int i=0; i< line; i++){
			System.out.println(br.readLine());
		}
		

	}

}
