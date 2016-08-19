package tools.date;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor {
	static String source=null;
	static String fileEndsWith="csv";
	public FileProcessor(){}
	public FileProcessor(String source){
		this.source=source;
	}
	public static int countLines(String source){
		File f=new File(source);
		if(!f.isDirectory()){
			System.out.println(" not a directory !!");
		}else if(f.isDirectory()){
			return FileProcessor.countLines(f,fileEndsWith);
		}
		return -1;
	}
	public static int countLines(File directory,String fileEndsWith){
		if(directory.isDirectory()){
			File[] files=directory.listFiles();
			int count=0;
			for(int i=0;i<files.length;i++){
				if(files[i].getName().endsWith(fileEndsWith)){
					System.out.println(files[i].getName());
					String aLine=null;
					BufferedReader br=null;
					try {
						br = new BufferedReader(new FileReader(files[i]));
						while((aLine=br.readLine())!=null){
							if(!aLine.equals("")){
								count++;
							}
						}
						br.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
						System.out.println("file not found exception....");
					} catch (IOException e) {
						e.printStackTrace();
						System.out.println("IOException...");
					}finally{
						try {
							br.close();
						} catch (IOException e) {
							e.printStackTrace();
							System.out.println("br close failed in finally");
						}
					}
					
				}
			}
			return count;
		}
		return -1;
	}
	
	public static void main(String[] args){
		System.out.println(FileProcessor.countLines("/Users/KJ-Yen"));
		
	}
}
