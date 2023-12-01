package chap7.casting;

public class MainExe {
	public static void main(String[] args) {
		
		double d1 = 100;
		int n1 = (int)100.0;
		
		// promotion (자동형변환) : 자식 -> 부모
		Parent p1 = new Child();
		
		// casting (강제형변환) : 부모 -> 자식
//		Child c1 = (Child) new Parent();
		
		// 강제형변환: 부모클래스의 변수에 있는 값을 자식클래스의 변수에 넣어줄때
		// 자식 인스턴스는 강제형변환 OK
		// 부모 인스턴스는 강제형변환 NG
		// 에러: 컴파일에러/ 실행에러
		Parent p2 = new Parent();
		Child c2 = new Child();
		
		p2 = c2;
		// 형변환전에 인스턴스 유형 체크
		if (p2 instanceof Child) {
			Child c3 = (Child) p2;
		}
		
		System.out.println("end of prog");
	}
}
