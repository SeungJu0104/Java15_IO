package com.io.chap02_charStream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TestCharStream {
	public void fileSave() {
		FileWriter fw = null;
		//try - catch 문 내부에 선언하면 지역변수로 간주해 close() 불가
		//그래서 외부에 선언
		
		try {
			//1. 스트림 생성(통로 연결)
			fw = new FileWriter("sample2.txt");
			//true 없이 계속 출력시키면 단순히 덮어쓰기 된다.
			
			//2. 외부로 출력
			fw.write("비가 오고 있습니다.");
			fw.write("오늘 점심은 칼국수입니다.");
			fw.write(97);//숫자로 치면 문자로 변환되어서 들어간다.
			fw.write('A');
			char [] carr = {'a','c','d','5'};
			fw.write(carr);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				//3. close()
				fw.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	public void fileOpen() {
		FileReader fr = null;
		//try - catch 문 내부에 선언하면 지역변수로 간주해 close() 불가
		//그래서 외부에 선언
		
		try {
			//1. 스트림 생성
			fr = new FileReader("sample2.txt");
			
			//2. 외부에서 데이터 입력
			int val;//문자와 숫자는 자동형변환이 가능하다.
			while((val = fr.read()) != -1) {
				System.out.print((char)val);
				//변환된 숫자를 문자로 강제형변환해 출력한다. 안하면 그냥 숫자 출력되니깐
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				fr.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
