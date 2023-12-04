package todo.p20231201;

import java.util.Calendar;

public class CalendarExe {
	public static void main(String[] args) {
		int year = 2020;
		int month = 2;

		System.out.println("\t" + year + "년 " + month + "월 달력");

		Calendar today = Calendar.getInstance();
		// 2023년 10월 달력 작성
		today.set(Calendar.YEAR, year);
		today.set(Calendar.MONTH, (month - 1));
		today.set(Calendar.DATE, 1);
		String[] days = { "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat" };

//		System.out.println("요일: " + cal.get(Calendar.DAY_OF_WEEK));
//		System.out.println("막날: " + cal.getActualMaximum(Calendar.DATE));

		for (String day : days) {
			System.out.printf("%4s", day);
		}
		System.out.println();

		for (int i = 0; i < today.get(Calendar.DAY_OF_WEEK) - 1; i++) {
			System.out.printf("%4s", "");
		}

		for (int i = 1; i <= today.getActualMaximum(Calendar.DATE); i++) {
			System.out.printf("%4d", i);
			if ((i + today.get(Calendar.DAY_OF_WEEK) - 1) % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println("\n== the end ==");
	}
}
