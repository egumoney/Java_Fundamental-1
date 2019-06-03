package java_20190603;

public class ExtendsDemo {
	public static void main(String[] args) {
		Customer c = new Customer();
		c.name = "성영한";
		c.cphone = "010-9090-1234";
		System.out.println("이름 : "+c.name);
		System.out.println("핸드폰 : "+c.cphone);
		
		Alba a = new Alba();
		a.name = "알바생";
		a.cphone = "010-9876-3456";
		a.address = "서울";
		System.out.println("이름 : "+a.name);
		System.out.println("핸드폰 : "+a.cphone);
		System.out.println("주소 : "+a.address);
		
		Manager m = new Manager();
		m.name = "매니저";
		m.cphone = "010-6789-4543";
		m.address = "경기도";
		m.id = "syh1011";
		m.password = "123123";
		System.out.println("이름 : "+m.name);
		System.out.println("핸드폰 : "+m.cphone);
		System.out.println("주소 : "+m.address);
		System.out.println("아이디 : "+m.id);
		System.out.println("비번 : "+m.password);
		
	}
}




