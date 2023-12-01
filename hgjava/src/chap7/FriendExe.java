package chap7;

public class FriendExe {
	Friend[] storage = new Friend[10];
	// 1:등록 2:목록 3:조회

	public boolean addFriend(Friend friend) {
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] == null) {
				storage[i] = friend;
				return true;
			}
		}
		return false;
	}

	public Friend[] friendList() {
		for (Friend fnd : storage) {
			if (fnd != null) {
				System.out.println(fnd.showInfo());
			}
		}
		return null;
	}

	// 결과값이 null 여부로 체크(X)
	public Friend[] searchFriend(String name) {
		// 반환유형이 정해져있음
		Friend[] result = new Friend[10];
		int count = 0;
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] != null && storage[i].getName().equals(name)) {
				result[count] = storage[i];
				count++;
			}
		}
		return result;
	}

	// 결과값이 null 여부로 체크
	public Friend searchPhone(String phone) {
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] != null && storage[i].getPhone().equals(phone)) {
				System.out.println(storage[i].showInfo());
				break;
			}
		}
		return null;
	}

}// end of class
