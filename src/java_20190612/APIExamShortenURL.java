package java_20190612;

//네이버 검색 API 예제 - 단축 URL - GET
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIExamShortenURL {
	//ctl + shift + f => 코드정렬
	public String getShortenUrl(String id, String scret, String u) {
		StringBuffer response = new StringBuffer();
		String clientId = id;// 애플리케이션 클라이언트 아이디값";

		String clientSecret = scret;// 애플리케이션 클라이언트 시크릿값";
		try {
			String text = u;
			String apiURL = "https://openapi.naver.com/v1/util/shorturl?url=" + text;
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;

			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return response.toString();
	}

	public static void main(String[] args) {
		String clientId = "0H9YIejBqfpUPxzJsLLt";// 애플리케이션 클라이언트 아이디값";
		String clientSecret = "D2cUe0MSp8";// 애플리케이션 클라이언트 시크릿값";

		APIExamShortenURL a = new APIExamShortenURL();
		String surl = a.getShortenUrl(clientId, clientSecret, "https://www.naver.com");
		System.out.println(surl);

	}
}
