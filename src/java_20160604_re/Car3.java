package java_20160604_re;

public class Car3 {
	String modelNumber;
	String color;
	int year;
	public Car3(String modelNumber, String color, int year){
		this.modelNumber = modelNumber;
		this.color = color;
		this.year = year;
	}
	
	//modelNumber를 변경할 수 있는 메소드 만들기(modelNumber의 setter 메소드)
	public void setModelNumber(String modelNumber){
		this.modelNumber = modelNumber;
	}
	//modelNumber를 가져올 수 있는 메소드 만들기(modelNumber의 getter 메소드)
	public String getModelNumber(){
		return modelNumber;
	}
	
	public void setColor(String color){
		this.color = color;
	}
	
	public String getColor(){
		return color;
	}
	
	public void setYear(int year){
		this.year = year;
	}
	
	public int getYear(){
		System.out.println(year);
		return year;
	}
	
	public static void main(String[] args) {
		Car3 c1 = new Car3("010101000","white",2018);
		String mn1 = c1.getModelNumber();
		String co1 = c1.getColor();
		int y1 = c1.getYear();
		System.out.println(mn1 +"\t"+co1+"\t"+y1);
		
		 c1.setModelNumber("0101010000");
		c1.setColor("whitegray");
		c1.setYear(20181);
		
		mn1 = c1.getModelNumber();
		co1 = c1.getColor();
		y1 = c1.getYear();
		
		System.out.println(mn1 +"\t"+co1+"\t"+y1);
		
	}
	
}
























