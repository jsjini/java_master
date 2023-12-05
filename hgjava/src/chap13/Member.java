package chap13;

import lombok.Data;

@Data
public class Member {
	private String memberNo;
	private String memberName;
	private int point;

	public Member(String memberNo, String memberName, int point) {
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.point = point;
	}
	
	// hashCode, equals 가 어떻게 정의되는냐에 따라서 동일하다아니다를 정해줌.
//	@Override
//	public int hashCode() {
//		return super.hashCode();
//	}
	
}
