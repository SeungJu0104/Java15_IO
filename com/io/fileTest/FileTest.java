package com.io.fileTest;

import java.io.File;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) {
		//File 클래스
		//파일 정보 확인, 파일 생성, 파일 삭제 기능 제공하는 클래스
		File file = new File("person.txt");//File 클래스의 객체 생성, 레퍼런스 변수 file 선언
		//()안에 경로 또는 파일명을 적어야한다. 비운 상태로는 객체 생성이 불가능하다.
		//단순히 파일명만 적으면 자바 워크 스페이스 위치의 해당 프로젝트 폴더 내에 파일이 생성된다.
		System.out.println("파일명 : " + file.getName());
		System.out.println("저장경로 : " + file.getAbsolutePath());
		System.out.println("파일용량 : " + file.length());
		//File 클래스 메소드 실행 시 예외처리가 반드시 필요한 경우도 있다. ex)createNewFile 메소드
		try {
			//파일이 없는 경우 파일 생성(true 리턴). 기존 파일이 있으면 false 리턴
			boolean b = file.createNewFile();//메소드까지 실행해야 실제 파일 생성
			System.out.println(b);
			
			boolean b2 = file.delete();//파일 삭제
			System.out.println(b2);
		}
		catch(IOException e) {
			e.printStackTrace();
		}

	}

}
