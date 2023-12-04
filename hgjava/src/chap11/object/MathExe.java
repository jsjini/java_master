package chap11.object;

public class MathExe {
	public static void main(String[] args) {
		long result = Math.round(-1.3);
		double result2 = Math.rint(-1.3);
		System.out.println("round: " + result);
		System.out.println("round: " + result2);

		// 61 ~ 100 점
//		for (int i = 1; i <= 10; i++) {
//			int r = (int) (Math.random() * 40 + 61); // 0 <= x < 10
//			System.out.println(r);
//		}

		// 1 ~ 6 까지의 수
		int[] numbers = new int[5];
		// 중복되지 않은 값을 배열에 저장.
		// 1. 1~6 숫자생성
		// 2. 생성된 값이 배열에 있는지 체크
		// 3. 없으면 추가 4. 배열에 값이 다 저장되면 종료
		for (int i = 0; i < numbers.length; i++) {
			boolean exist = false;
			int r = (int) (Math.random() * 6 + 1);
			for (int j = 1; j < i; j++) {
				if (numbers[i] != r) {
					numbers[i] = r;
				} else {
					continue;
				}
			}
			System.out.println(i);
		}
	}
}
