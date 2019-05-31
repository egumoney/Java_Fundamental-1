package java_20190531;

public class Calendar {
	public static final int SUNDAY = 0;
	public static final int MONDAY = 1;
	public static final int TUESDAY = 2;
	public static final int WEDNESDAY = 3;
	public static final int THURSDAY = 4;
	public static final int FRIDAY = 5;
	public static final int SATURDAY = 6;
	
	public boolean isLeafYear(int year){
		boolean isLeafYear = false;
		if((year%4==0 && year%100 != 0 || year%400==0 )){
			isLeafYear = true;
		}
		return isLeafYear;
	}
	
	public int getCount(int year, int month, int day){
		int preYear = year - 1;
		int preMonth = month - 1;
		int totalCnt = 0;
		
		//2018년도 일 수 구하기
		totalCnt = preYear * 365 + 
				(preYear/4 - preYear/100 + preYear/400);
		
		//2019년 1월 1일 부터 4월 30일 까지 일수 구하기
		//월 배열을 생성한다.
		int[] monthArray = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		for (int i = 0; i < preMonth; i++) {
			
			totalCnt += monthArray[i];
		}
		
		//해당 년도가 윤년인지 판단하고 윤년인 경우 3월 이상이면 1을 추가해준다.
		if (month >=3 && isLeafYear(year)) {
			totalCnt++;
		}
		
		totalCnt += day;
		return totalCnt;
	}
	
	public int getLastDay(int year, int month){
		int[] monthArray = {31,28,31,30,31,30,31,31,30,31,30,31};
		if(isLeafYear(year)){
			monthArray[1] = 29;
		}	
		return monthArray[month-1];
	}
	
	
	
	public void print(int year) {
		// TODO Auto-generated method stub
		
	}

	public void print(int year, int month) {
		// TODO Auto-generated method stub
		
	}

	public void print(int year, int month, int day) {
		
		int totalCnt = getCount(year,month,day);
		
		int rest = totalCnt % 7;
		String dayOfWeek = "";
		switch(rest){
			case Calendar.MONDAY : dayOfWeek = "월요일"; break;
			case Calendar.TUESDAY : dayOfWeek = "화요일"; break;
			case Calendar.WEDNESDAY : dayOfWeek = "수요일"; break;
			case Calendar.THURSDAY : dayOfWeek = "목요일"; break;
			case Calendar.FRIDAY : dayOfWeek = "금요일"; break;
			case Calendar.SATURDAY : dayOfWeek = "토요일"; break;
			case Calendar.SUNDAY : dayOfWeek = "일요일"; break;
		}
		
		System.out.println(year + "년 " + month +"월 " + 
		day +" 일 "+ dayOfWeek + " 입니다.");
	}

}
