package chap8;

// 추상클래스처럼 추상메소드만 쭉~ 정의할 수 있음
// Oracle : insert(), update() / MySQL : add(), modify()
// 
public interface DatabaseService {
	public static final String name = ""; // 상수만 사용가능. static final 생략가능.
	// 입력,수정,삭제
	public void add(); // 인터페이스는 추상메소드와 다르게 abstract 생략가능.
	public void modify();
	public void remove();
}
