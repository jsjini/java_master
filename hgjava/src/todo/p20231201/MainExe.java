package todo.p20231201;

public class MainExe {
	public static void main(String[] args) {
		int[][] numAry = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
//		System.out.println(numAry[0].length);
		for (int i = 3; i > -1; i--) {
			for (int j = 0; j < 4; j++) {
				System.out.printf("%3d", numAry[i][j]);
			}
			System.out.println();
		}
		System.out.println("===== end =====");
		
		int[][] numAry1 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.printf("%3d", numAry1[j][i]);
			}
			System.out.println();
		}
		System.out.println("===== end =====");
		
		int[][] numAry2 = { { 1, 2, 3, 4, 5, 6, 7 }, { 8, 9, 10, 11, 12, 13, 14 }, { 15, 16, 17, 18, 19, 20, 21 },
				{ 22, 23, 24, 25, 26, 27, 28 }, { 29, 30, 31 } };
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < numAry2[i].length; j++) {
				System.out.printf("%4d", numAry2[i][j]);
			}
			System.out.println();
		}
		System.out.println("===== end =====");
	}
}
