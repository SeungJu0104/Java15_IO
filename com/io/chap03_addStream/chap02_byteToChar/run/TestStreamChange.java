package com.io.chap03_addStream.chap02_byteToChar.run;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;

public class TestStreamChange {
	
	public static void main(String[] args) {
		TestStreamChange tsc = new TestStreamChange();
		//tsc.input();
		tsc.output();
		
	}
	
	//보조스트림명 레퍼런스 변수 = new 보조스트림(new 기반스트림("외부자원"));
	public void input() {
		//InputStreamReader
		//System.in은 InputStream의 일종. 콘솔 창에 친 걸 입력 받는 Stream 객체.
		//InputStreamReader를 이용해 바이트 단위(System.in)를 문자단위(BufferedReader)로 변환해서 문제가 생기지 않도록 한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		try {
			System.out.print("문자열 입력 : ");
			String val = br.readLine();//버퍼에 있는 문장을 한 문장씩 읽어 val에 저장.
			System.out.println("val : " + val);//한 문장씩 출력
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//보조스트림명 레퍼런스 변수 = new 보조스트림(new 보조스트림(new 기반스트림("외부자원"))); 
	public  void output() {
		//OutputStreamWriter
		//System.out은 OutputStream의 일종. 콘솔 창에 입력 값을 내보낸다.
		//
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			bw.write("내일은 날씨가 좋습니다.");
			bw.flush(); //버퍼에 담긴 내용을 내보내는 작업 필요.
			//close()를 제대로하면 따로 flush를 쓸 필요는 없다.
		} catch(IOException e) {
			e.printStackTrace();
		}
	}


}
