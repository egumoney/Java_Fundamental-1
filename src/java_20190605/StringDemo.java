package java_20190605;

public class StringDemo {
	public static void main(String[] args) {
		
		String str1 = new String("test");
		String str2 = new String("test");
		
		String str3 = "java";
		String str4 = "java";
		
		System.out.println(str1==str2);
		System.out.println(str1.equals(str2));
		
		System.out.println(str3 == str4);
		System.out.println(str3.equals(str4));
		
		String ssn = "234567-8923456";
		//charAt(int index) 메서드는 문자열중에서 특정 index에 있는 문자를 반환한다.
		char c = ssn.charAt(6);
		System.out.println(c);
		//concat(String msg) 메서드는 문자열 연결
		String temp = ssn.concat("안녕하세요");
		System.out.println(temp);
		
		//endsWith(String temp) 메서드는 temp 문자열로 끝나면 true, 그렇지 않으면 false
		String fileName = "test.doc";
		if(fileName.endsWith("zip")){
			System.out.println("압축파일 입니다.");
		}else if(fileName.endsWith("doc")){
			System.out.println("Office 문서 입니다.");
		}else {
			System.out.println("파일 입니다.");
		}
		
		//startsWith(String temp) 메서드는 temp 문자열로 시작하면 true, 그렇지 않으면 false
		String url = "http://www.naver.com/";
		String uri = "sports/";
		if(uri.startsWith("sports")){
			System.out.println("스포츠 메뉴 입니다.");
		}else if(uri.startsWith("news")){
			System.out.println("뉴스 메뉴입니다.");
		}else {
			System.out.println("404 페이지 입니다.");
		}
		
		String s1 = "Java";
		String s2 = "JAVA";
		System.out.println(s1.equals(s2));
		System.out.println(s1.equalsIgnoreCase(s2));
		
		s2 = s2.toLowerCase();
		System.out.println(s2);
		
		s1 = s1.toUpperCase();
		System.out.println(s1);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		String str = String.format("%1$,20.2f%2$,20.2f%3$,20.2f", 111111.111111,222222.222222,33333.33333);
		
		System.out.println(str);
	}
}
