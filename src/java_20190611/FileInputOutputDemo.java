package java_20190611;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputDemo {
	public static void main(String[] args) {
		try {
			//FileInputStream�� c:\\down\\jdk.exe ��ο� ������ ������ 
			//FileNotFoundException ���ܸ� �߻���Ų��.
			FileInputStream fin = new FileInputStream(
					"c:\\down\\jdk.exe");
			
			//FileOutputStream�� C:\\down\\2019\\06\\11\\jdk.exe 
			//���� ��ο� ���丮�� ������ ���丮 �� ������ �������ش�.
			FileOutputStream fos = new FileOutputStream(
					"C:\\down\\2019\\06\\11\\jdk.exe");
			
			int readByte =0;
			//fin.read() �޼���� �� ����Ʈ�� �д´�. 
			//���� ���̻� ���� ����Ʈ�� ������ -1�� ��ȯ�Ѵ�.
			while((readByte = fin.read()) != -1){
				//fos.writer(readByte) �޼���� �� ����Ʈ�� ��
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





