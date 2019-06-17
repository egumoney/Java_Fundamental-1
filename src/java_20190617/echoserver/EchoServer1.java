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
			//1. ServerSocket 객체를 생성한다.
			serverSocket = new ServerSocket(port);
			
			
			//2 ServerSocket의 accept() 메서드로 클라이언트 접속을 대기한다.
			Socket socket = serverSocket.accept();
			
			//4.5 클라이언트와 TCP 컨넥션이 만들어지면서 클라이언트와 통신할 수 있는 
			//Socket 객체가 생성된다. 
			
			//7. 클라이언트로 부터 메세지를 받는다.
			InputStream in = socket.getInputStream();
			
			//8. 받은 메세지를 클라이언트에게 다시 보낸다.
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



