package chap5;

public class ArrayExe3 {

	public static void main(String[] args) {
		String[] nameAry = {"ȫ�浿","��浿","ȫ�浿","�ڱ浿","ȫ�浿","Ȳ�浿"};
		
		String search = "ȫ�浿";
		int count = 0;
		for(int i = 0; i < nameAry.length; i++) { // String name : nameAry
			if(nameAry[i].equals(search)) { // if(name.equals(search))
				count++;
			}
		}
		System.out.println(search + "�� �� " + count + "�� �Դϴ�.");
		
		
		int[] scores = {88, 68, 72, 89, 92, 70};
		int maxScores = 0;
		for(int i : scores) {
			if(maxScores < i) {
				maxScores = i; 
			}
		}
		System.out.println(maxScores);
		
	}//end main

}//end class
