package com.io.chap01_byteStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;

public class TestByteStream {
	//[Byte 단위의 기반 스트림]
	//FileInputStream, FileOutputStream
	
	public void fileSave() {
		//출력
		FileOutputStream fout = null;
		//외부에서 객체 선언 안하면 try catch구문의 지역변수가 되므로
		//close() 할 수 없다.
		//그래서 외부에 선언하고, try - catch문 내에서 객체를 생성한다.
		
		//객체 생성 = 스트림 생성 = 통로 연결
		//예외처리 필수
		try {
			fout = new FileOutputStream("sample.txt");//객체 생성. sample.txt 파일이 없으면 새로 생성해 내보낸다.
			fout.write(97);//데이터 출력. 생성한 파일에 ()안의 내용을 작성한다. 문자로 자동형변환되어 적힌다.(아스키코드)
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				fout.close();//스트림 닫기.
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void fileOpen() {
		//입력
		
		//try with resource
		//반드시 close()처리를 해야 하는 객체 생성 구문을
		//자동으로 close() 시켜준다.
		try(FileInputStream fin = new FileInputStream("sample.txt")){//객체 생성. sample.txt 파일과 통로 생성.
//			int val = fin.read();//파일로부터 불러온다.(읽어들인다.)
//			System.out.println(val);
//			val = fin.read();//더이상 읽어올 데이터가 없는 상태에서 읽어들이면 -1을 출력한다.
//			//다시 읽어오는 것이 아니다.
//			System.out.println(val);
			
			int val;
//			while(fin.read() != -1) {//false 이면 반복 종료.
//				System.out.println(fin.read() + " ");
//				//파일에 a라는 문자 하나만 있다는 기준으로
//				//조건식 확인하며 read 한번하고, 프린트하면서 read 또 한번 하므로 -1만 출력된다.
//				//즉 출력할 때는 read가 이미 이전에 끝났기때문에 끝났다는 -1 출력
//			}
			
			while((val=fin.read()) != -1) {//false 이면 반복 종료.
				System.out.println(val + " ");
			}
			
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e1) {
			e1.printStackTrace();
		}
		//close()구문 생략
		
	}

}
