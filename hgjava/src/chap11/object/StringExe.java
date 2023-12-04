package chap11.object;

public class StringExe {
	public static void main(String[] args) {
		String[] fileNames = { "c:/images/prod/sample.jpg", "d:/test/sample/americano.png",
				"d:/goods/test/2023/moka.jpg" };
		for (String file : fileNames) {
			System.out.println(findFileName(file));
		}

		//
		String[] numbers = { "980304-1234567", "980304-2234567", "020101-3456789", "020104-4456789", "0301053545678" };
		for (String no : numbers) {
			System.out.println(findGender(no));
		}

//		byte[] b1 = "Hello".getBytes();
//		for (byte b : b1) {
//			System.out.println(b);
//		}
//
//		String name = new String(new byte[] { 65, 66, 67, 68, 69 });
//		name = new String(b1);
//		System.out.println(name);
//
//		char c1 = name.charAt(0);
//		System.out.println(c1);
	}

	// 성별을 반환
	static String findGender(String ssn) {
		// 생년월일 - 1, 2, 3, 4
//		char a = ssn.charAt(7);
//		char b = ssn.charAt(6);
//		String c = "";
//		if (ssn.indexOf("-") != -1) {
//			switch (a) {
//			case '1':
//			case '3':
//				c = "남자입니다.";
//				break;
//			case '2':
//			case '4':
//				c = "여자입니다.";
//				break;
//			}
//		} else {
//			switch (b) {
//			case '1':
//			case '3':
//				c = "남자입니다.";
//				break;
//			case '2':
//			case '4':
//				c = "여자입니다.";
//				break;
//			}
//		}
//		return c;

		int pos = ssn.length() - 7;
		switch (ssn.charAt(pos)) {
		case '1':
		case '3':
			return "남";
		case '2':
		case '4':
			return "여";
		}
		return "오류";
	}

	// 파일명 가져오기
	static String findFileName(String file) {
//		String[] zz = file.split("/");
//		return zz[zz.length - 1];
		int index2 = file.lastIndexOf("/");
		int index3 = file.indexOf(".");
		return file.substring(index2 + 1, index3);
	}
}
