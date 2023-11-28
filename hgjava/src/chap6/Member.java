package chap6;
// 회원관리 앱
// 회원번호, 회원이름, 연락처, 성별
// public <-> private

public class Member {
	// 속성(필드)
	private int memberNo; // 자바에서는 두단어이상의 조합: CamelCase(낙타표기법)
	private String memberName;
	private String phone; // 010-1234-5678 -> '-'가 문자라 String 사용
	private String gender; // Men or Women 
	
	// 생성자 : 필드의 초기값을 지정.
	// 따로 정의안하면 기본생성자를 컴파일러가 알아서 생성해줌.
	Member(){
		
	}
	Member(int memberNo, String memberName){
		this.memberNo = memberNo;
		this.memberName = memberName;
	}
	
	
	// 오른쪽 버튼 눌러서 소스메뉴 -> using fields
	public Member(int memberNo, String memberName, String phone, String gender) {
		super();
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.phone = phone;
		this.gender = gender;
	}
	
	//기능(메소드)
	void showInfo() {
		System.out.println("이름은 " + memberName + "이고 연락처는 " + phone + "입니다.");
	}
	
	String showAllInfo() {
		String result = "이름은 " + memberName + "이고 번호는 " + memberNo + "이고 연락처는 " + phone + "이고 성별은 " + gender + "입니다.";
		return result;
	}
	
	// memberNO의 값을 지정하는 메소드
	void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	void setPhone(String phone) {
		this.phone = phone;
	}
	void setGender(String gender) {
		this.gender = gender;
	}
	
	// getter
	int getMemberNo() {
		return memberNo;
	}
	String getMemberName() {
		return memberName;
	}
	String getPhone() {
		return phone;
	}
	String getGender() {
		return gender;
	}
	
	
}//end of class
