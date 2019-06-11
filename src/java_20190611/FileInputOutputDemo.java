package java_20190611;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputDemo {
	public static void main(String[] args) {
		try {
			//FileInputStream의 c:\\down\\jdk.exe 경로에 파일이 없으면 
			//FileNotFoundException 예외를 발생시킨다.
			FileInputStream fin = new FileInputStream(
					"c:\\down\\jdk.exe");
			
			//FileOutputStream은 C:\\down\\2019\\06\\11\\jdk.exe 
			//위의 경로와 디렉토리가 없으면 디렉토리 및 파일을 생성해준다.
			FileOutputStream fos = new FileOutputStream(
					"C:\\down\\2019\\06\\11\\jdk.exe");
			
			int readByte =0;
			//fin.read() 메서드는 한 바이트씩 읽는다. 
			//만약 더이상 읽을 바이트가 없으면 -1를 반환한다.
			while((readByte = fin.read()) != -1){
				//fos.writer(readByte) 메서드는 한 바이트씩 씀
				fos.write(readByte);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}





