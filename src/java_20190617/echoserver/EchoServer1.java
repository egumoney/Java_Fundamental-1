package java_20190617.echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer1 {
	private int port;
	private ServerSocket serverSocket;
	public EchoServer1(int port){
		this.port = port;
		
		try {
			//1. ServerSocket ��ü�� �����Ѵ�.
			serverSocket = new ServerSocket(port);
			
			
			//2 ServerSocket�� accept() �޼���� Ŭ���̾�Ʈ ������ ����Ѵ�.
			Socket socket = serverSocket.accept();
			
			//4.5 Ŭ���̾�Ʈ�� TCP ���ؼ��� ��������鼭 Ŭ���̾�Ʈ�� ����� �� �ִ� 
			//Socket ��ü�� �����ȴ�. 
			
			//7. Ŭ���̾�Ʈ�� ���� �޼����� �޴´�.
			InputStream in = socket.getInputStream();
			
			//8. ���� �޼����� Ŭ���̾�Ʈ���� �ٽ� ������.
			OutputStream out = socket.getOutputStream();
			
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		new EchoServer1(3001);
	}
}



