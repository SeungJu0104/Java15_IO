package com.io.chap01_byteStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestByteStream2 {
	
	public void output () {
		
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("sample3.txt");
			
			fos.write(98);
			fos.write('A');
			fos.write('B');
			//byte [] barr = {3,4,5};
			//fos.write(barr);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				fos.close();
			}
			catch (IOException e){
				e.printStackTrace();
			}
		}
	}
	
	public void input() {	
		
		File f = new File("sample4.txt");
		
		FileInputStream fis = null;
		
		char ch;
		
		try {
			f.createNewFile();
			f.delete();
			
			fis = new FileInputStream("sample.txt");
			
			//System.out.println((int)(ch = (char)fis.read()));
			
			while((int)(ch = (char)fis.read()) != -1) {
				System.out.print((char)ch + " ");
			}
			
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				fis.close();
			}
			catch (IOException e){
				e.printStackTrace();
			}
		}
		
	}
	
	

}
