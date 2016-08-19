package tools.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateMsParser {
	static DateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	
	public static Date convertToDate(Long ms){
		return new Date(ms);
	}
	
	public static String convertToDateString(Long ms){
		return formatter.format(new Date(ms));
	}

	
	public static Long convertToMs(String dateInStringFormat){
		try {
			return formatter.parse(dateInStringFormat).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("convert failed");
		}
		return null;
	}
	
	public static void main(String[] args) throws ParseException{
		System.out.println(DateMsParser.convertToMs("2016-06-08 00:00:00.000"));
		//1466838561563	//1464710400000	//1464721199999
		Date test= formatter.parse("2016-06-09 00:00:00.000");
		System.out.println(test.getTime());
		System.out.println(DateMsParser.convertToDate(Long.parseLong("1464137643246")));//sec
		System.out.println(DateMsParser.convertToDate(Long.parseLong("1464137643355")));//max
		System.out.println(DateMsParser.convertToDate(Long.parseLong("1464137625000")));//min
		
		System.out.println(DateMsParser.convertToDate(Long.parseLong("1464136735851")));
		System.out.println(DateMsParser.convertToDate(Long.parseLong("1464136735888")));
		System.out.println(DateMsParser.convertToDate(Long.parseLong("1464136735000")));
		//1464136735851,1464136735888,1464136735000
		
		System.out.println(DateMsParser.convertToDate(Long.parseLong("1464179495258")));
		System.out.println(DateMsParser.convertToDate(Long.parseLong("1464179495298")));
		System.out.println(DateMsParser.convertToDate(Long.parseLong("1464153481873")));
		//1464179495258,1464179495298,1464179517000
		
	}
}
