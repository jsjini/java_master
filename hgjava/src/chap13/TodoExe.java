package chap13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

public class TodoExe {
	public static void main(String[] args) {
		// 순번, 할일(Todo) DueDate 추가
		Map<Integer, Todo> todoList = new HashMap<>();
		Scanner scn = new Scanner(System.in);

		while (true) {
			System.out.println("번호 할일 기한>> ");
			String input = scn.nextLine(); // 20 장보기 23-12-08(엔터)
			String[] inpAry = input.split(" ");

			// 걸러낼 조건
			if (inpAry.length != 2 && inpAry.length != 3) {
				System.out.println("입력값을 확인하세요.");
				continue;
			}
			String order = inpAry[0]; // 순번
			String title = inpAry[1]; // 할일제목

			Todo todo = null;
			if (inpAry.length == 2) {
				todo = new Todo(title);
			} else if (inpAry.length == 3) {
				String dueDate = inpAry[2]; // null 인지 체크
				// Date -> String or String -> Date
				// 2023-10-23 => format
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				try {
					todo = new Todo(title, sdf.parse(dueDate));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}

			todoList.put(Integer.parseInt(order), todo);

			if (todoList.size() == 3) {
				break;
			}
		}
			// 순번, 할일, 기한 출력
			System.out.println("번호\t할일\t기한");
			System.out.println("=========================");
			Set<Entry<Integer, Todo>> entry = todoList.entrySet();
			for (Entry<Integer, Todo> ent : entry) {
				System.out.println(ent.getKey() + "\t" + ent.getValue().toString());
			}
		System.out.println("end of prog");
	}
}
