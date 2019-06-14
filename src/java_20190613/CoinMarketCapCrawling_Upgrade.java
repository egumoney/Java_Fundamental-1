package java_20190613;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CoinMarketCapCrawling_Upgrade {
	private String getKoreanDate(String date){
		String koreanDate = null;
		SimpleDateFormat from = new SimpleDateFormat("MMM dd, yyyy",Locale.US);
		SimpleDateFormat to = new SimpleDateFormat("yyyy년 MM월 dd일",Locale.KOREAN);
		try {
			Date d = from.parse(date);
			koreanDate = to.format(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return koreanDate;
	}
	public void execute(String sheetName,String coinName, String startDate, String endDate){
		HSSFWorkbook workbook = new HSSFWorkbook(); 
		HSSFSheet sheet = workbook.createSheet(sheetName); 
		String url = "https://coinmarketcap.com/currencies/"+coinName+"/historical-data/?start="+startDate+"&end="+endDate;
		Document doc = null;

		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Elements headElements = doc.select(".table-responsive .table thead tr");
		Elements bodyElements = doc.select(".table-responsive .table tbody tr");
		
		int rowIndex = 0;
		HSSFRow row = null;
		HSSFCell cell = null;
		for (int i = 0; i < headElements.size(); i++) {
			
			row = sheet.createRow(rowIndex++);
			Element e = (Element) headElements.get(i);
			String date = e.child(0).text();
			cell = row.createCell(0);
			cell.setCellValue(date);

			String open = e.child(1).text();
			cell = row.createCell(1);
			cell.setCellValue(open);

			String high = e.child(2).text();
			cell = row.createCell(2);
			cell.setCellValue(high);

			String low = e.child(3).text();
			cell = row.createCell(3);
			cell.setCellValue(low);

			String close = e.child(4).text();
			cell = row.createCell(4);
			cell.setCellValue(close);

			String volume = e.child(5).text();
			cell = row.createCell(5);
			cell.setCellValue(volume);

			String marketCap = e.child(6).text();
			cell = row.createCell(6);
			cell.setCellValue(marketCap);

			System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s%n", date, open, high, low, close, volume, marketCap);

		}

		for (int i = 0; i < bodyElements.size(); i++) {
			
			row = sheet.createRow(rowIndex++);
			Element e = (Element) bodyElements.get(i);
			String date = e.child(0).text();
			cell = row.createCell(0);
			cell.setCellValue(getKoreanDate(date));

			String open = e.child(1).text();
			cell = row.createCell(1);
			cell.setCellValue(Double.parseDouble(open));

			String high = e.child(2).text();
			cell = row.createCell(2);
			cell.setCellValue(Double.parseDouble(high));

			String low = e.child(3).text();
			cell = row.createCell(3);
			cell.setCellValue(Double.parseDouble(low));

			String close = e.child(4).text();
			cell = row.createCell(4);
			cell.setCellValue(Double.parseDouble(close));

			String volume = e.child(5).text();
			volume = volume.replaceAll(",", "");
			cell = row.createCell(5);
			cell.setCellValue(Long.parseLong(volume));

			String marketCap = e.child(6).text();
			marketCap = marketCap.replaceAll(",", "");
			cell = row.createCell(6);
			cell.setCellValue(Long.parseLong(marketCap));

			System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s%n", date, open, high, low, close, volume, marketCap);
		}

		FileOutputStream fos = null;
		try {
			
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONDAY)+1;
			int date = c.get(Calendar.DATE);
			
			File path = new File("c:\\down\\"+year+"\\"+month+"\\"+date);
			if(!path.exists()){
				path.mkdirs();
			}
			path = new File(path,coinName+"-"+year+month+date+".xls");
			fos = new FileOutputStream(path);
			workbook.write(fos);
			fos.close();

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			try {
				if (fos != null)
					fos.close();
			} catch (IOException e2) {
				// TODO: handle exception
			}
		}
	}
	public static void main(String[] args) {

		CoinMarketCapCrawling_Upgrade c = new CoinMarketCapCrawling_Upgrade();
		c.execute("비트코인", "bitcoin", "20180613", "20190613");
		c.execute("이더리움", "ethereum", "20180613", "20190613");
		c.execute("리플", "ripple", "20180613", "20190613");
	}
}
