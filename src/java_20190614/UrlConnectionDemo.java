package java_20190614;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnectionDemo {
	public static void main(String[] args) throws IOException {
		URL url = new URL(
				"https://m.sports.naver.com/kfootball/index.nhn");
		URLConnection urlCon = url.openConnection();
		
		
		String server = urlCon.getHeaderField("Server");
		String cacheControl = urlCon.getHeaderField("Cache-Control");
		String expires = urlCon.getHeaderField("Expires");
		String contentType = urlCon.getHeaderField("Content-Type");
		String location = urlCon.getHeaderField("Location");
		String connection = urlCon.getHeaderField("Connection");
		String setCookie = urlCon.getHeaderField("Set-Cookie");
		int len = urlCon.getContentLength();
		
		System.out.println("Server : "+server);
		System.out.println("Cache-Control : "+cacheControl);
		System.out.println("Expires : "+expires);
		System.out.println("Content-Type : "+contentType);
		System.out.println("Location : "+location);
		System.out.println("Connection : "+connection);
		System.out.println("Set-Cookie : "+setCookie);
		System.out.println("len : "+len);
		
		InputStream in = urlCon.getInputStream();
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(in,"utf-8"));
		String readLine = null;
		while((readLine = br.readLine()) != null){
			System.out.println(readLine);
		}
		
		
		
		
		
		
		
		
	}
}



