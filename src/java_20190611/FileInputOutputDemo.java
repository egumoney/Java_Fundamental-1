package java_20190611;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputDemo {
	public static void main(String[] args) {
		FileInputStream fin = null;
		FileOutputStream fos = null;
		try {
			//FileInputStream�� c:\\down\\jdk.exe ��ο� ������ ������ 
			//FileNotFoundException ���ܸ� �߻���Ų��.
			fin = new FileInputStream(
					"c:\\down\\eclipse.zip");
			
			//FileOutputStream�� C:\\down\\2019\\06\\11\\jdk.exe 
			//���� ��ο� ������ �������ְ� �ش� ��ΰ� ������ FileNotFoundException ����
			//�� �߻���Ų��.
			fos = new FileOutputStream(
					"C:\\down\\2019\\eclipse.zip");
			/*
			int readByte =0;
			//fin.read() �޼���� �� ����Ʈ�� �д´�. 
			//���� ���̻� ���� ����Ʈ�� ������ -1�� ��ȯ�Ѵ�.
			while((readByte = fin.read()) != -1){
				//fos.writer(readByte) �޼���� �� ����Ʈ�� ��
				fos.write(readByte);
			}
			*/
			long start = System.currentTimeMillis();
			
			int readByteCount = 0;
			byte[] readBytes = new byte[1024*40];
			while((readByteCount = fin.read(readBytes)) != -1){
				fos.write(readBytes,0,readByteCount);
			}
			
			long end = System.currentTimeMillis();
			
			System.out.println("����ð� : "+(end-start));
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(fin != null) fin.close();
				if(fos != null) fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			
			
			}
		}
	}
}





