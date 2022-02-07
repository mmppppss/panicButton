package com.mmppppss.panicButton;

import java.io.*;

public class files
{
	
	
public static String readFile(String path) {
		StringBuilder sb = new StringBuilder();
		FileReader fr = null;
		try {
			fr = new FileReader(new File(path));
			char[] buff = new char[1024];
			int length = 0;
			while ((length = fr.read(buff)) > 0) {
				sb.append(new String(buff, 0, length));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
		}
		
public static void crear(String path, String type){
	if(type=="dir"){
		File dir= new File(path);
		dir.mkdir();
	}
	if(type=="file"){
		File file = new File(path);
		try
		{
			file.createNewFile();
		}
		catch (IOException e)
		{
			//toast("Error 002");
		}
	}
}
public static void write(String file, String text){
	try
	{
		FileWriter writer = new FileWriter(file, true);
		writer.write(text);
		writer.flush();
		writer.close();
	}
	catch (IOException e)
	{
		//toast("Error 003");
	}
}
public static void delete(String file){
	File a= new File(file);
	a.delete();
}
}
		
