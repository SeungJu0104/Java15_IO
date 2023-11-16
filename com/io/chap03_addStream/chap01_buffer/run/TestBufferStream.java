package com.io.chap03_addStream.chap01_buffer.run;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;

public class TestBufferStream {
	
	//보조 스트림 클래스 단독으로 객체 생성 불가능(단독으로 스트림 생성 불가능)
	//예외처리 반드시 주의할 것! 앞서 기반 스트림에서 했던 방식으로 하기.
	//보조와 기반 스트림의 통로 방향과 크기를 맞출 것.
	//(try - catch 내에서 기반 스트림 선언 하지말 것 등)
	
	//new 해당 보조스트림명 (new 해당 기반 스트림명 ("외부자원"));
	
	//해당 기반 스트림명 레퍼런스 변수 = null; // try - catch 문 밖에 선언하기
	//해당 보조 스트림명 레퍼런스 변수 = null; // try - catch 문 밖에 선언하기
	//기반 레퍼런스 변수 = new 해당 기반 스트림명 ("외부자원"); // try - catch 문 내에 선언하기
	//보조 레퍼런스 변수 = new 해당 보조 스트림명 (기반 스트림 레퍼런스 변수); // try - catch 문 내에 선언하기
	public void outputBufferStream() {
		
		FileWriter fw = null;//try - catch 문 내에서 선언하면 지역변수가 되므로 close() 불가능.
		BufferedWriter bw = null;
		
		try {
			fw = new FileWriter("sample3.txt"); //기반 스트림 객체 생성 
			//기존에 있던 파일이라면 덮어쓰기가 수행된다.
			bw = new BufferedWriter(fw); // 보조 스트림 객체 생성
			
			bw.write("안녕하세요\n");
			bw.write("반갑습니다\n");
			bw.write("안녕하세요\n");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	//해당 보조스트림명 레퍼런스 변수 = null; (try - catch 문 외부에 선언)(try - catch문 내에 선언하면 지역변수여서 close() 불가능)
	//new 해당 보조 스트림명(new 해당 기반 스트림명 ("외부자원")); (try - catch 문 내부에 선언)
	public void inputBufferStream() {
		
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader("sample3.txt"));
			
			String temp = null;
			while((temp = br.readLine()) != null) {//while문은 조건식의 결과 값이 false면 종료한다.
				//한 줄 씩 읽어온다. String 자료형
				//readLine 메소드는 더 이상 읽어들일 것이 없을 경우 null을 리턴 한다.
				System.out.println(temp);
			}
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
	}

}
