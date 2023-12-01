package chap10;

public class ExceptionExe {
	public static void main(String[] args) {
		test();
		System.out.println("end of prog");
	}

	public static void test() {
		// 일반예외 : 반드시 예외를 처리해야 컴파일이 됨.
		try {
			Class.forName("java.lang.String");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
