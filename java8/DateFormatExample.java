package java8;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class DateFormatExample {
	public static void main(String[] args) {

		Date curDate = new Date();
		System.out.println("curDate.toString()");
		System.out.println(curDate.toString());

		String DateToStr = DateFormat.getInstance().format(curDate);
		System.out.println("DateFormat.getInstance().format(curDate);");
		System.out.println(DateToStr);

		DateToStr = DateFormat.getTimeInstance().format(curDate);
		System.out.println("DateFormat.getTimeInstance().format(curDate).");
		System.out.println(DateToStr);

		DateToStr = DateFormat.getDateInstance().format(curDate);
		System.out.println("DateFormat.getDateInstance().format(curDate)");
		System.out.println(DateToStr);

		DateToStr = DateFormat.getDateTimeInstance().format(curDate);
		System.out.println("DateFormat.getDateTimeInstance().format(curDate)");
		System.out.println(DateToStr);

		DateToStr = DateFormat.getTimeInstance(DateFormat.SHORT).format(curDate);
		System.out.println("DateFormat.getTimeInstance(DateFormat.SHORT).format(curDate)");
		System.out.println(DateToStr);

		DateToStr = DateFormat.getTimeInstance(DateFormat.MEDIUM).format(curDate);
		System.out.println("DateFormat.getTimeInstance(DateFormat.MEDIUM).format(curDate)");
		System.out.println(DateToStr);

		DateToStr = DateFormat.getTimeInstance(DateFormat.LONG).format(curDate);
		System.out.println("DateFormat.getTimeInstance(DateFormat.LONG).format(curDate)");
		System.out.println(DateToStr);

		DateToStr = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.SHORT).format(curDate);
		System.out.println("DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.SHORT).format(curDate)");
		System.out.println(DateToStr);

		try {
			Date strToDate = DateFormat.getDateInstance().parse("July 17, 1989");
			System.out.println("DateFormat.getDateInstance().parse(July 17, 1989)");
			System.out.println(strToDate.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
}

