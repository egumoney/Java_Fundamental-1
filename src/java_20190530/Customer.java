package java_20190530;

import java.io.Serializable;

public class Customer implements Serializable{
	//instance variable
	String name;
	String cphone;
	//static variable
	static double interestRate ;
	static final String BANKNAME = "��������";
	public void register(){
		//DB insert
		System.out.println("���� ��� �Ǿ����ϴ�.");
		System.out.println("�̸� : "+ name + ", �ڵ��� ��ȣ : "+cphone
				+", ������: "+interestRate+", ����� : "+BANKNAME);
	}	
}
