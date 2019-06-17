package java_20190617.echoclient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient1 {
	private String ip;
	private int port;
	private Socket socket;
	public EchoClient1(String ip, int port){
		this.ip = ip;
		this.port = port;
		
		
		try {
			//3.4 Ŭ���̾�Ʈ Socket ��ü�� �����Ѵ�
			socket = new Socket(ip,port);
			
			//4.5 ������ TCP ���ؼ��� ��������鼭 ������ ����� �� �ִ� 
			//Socket ��ü�� �����ȴ�. 
			
			//6. �������� �޼����� ������.
			OutputStream out = socket.getOutputStream();
			
			//9. ������ ���� �޼����� �޴´�.
			InputStream in = socket.getInputStream();
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new EchoClient1("127.0.0.1", 3001);
	}
}






