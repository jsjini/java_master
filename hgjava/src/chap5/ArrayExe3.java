package chap5;

public class ArrayExe3 {

	public static void main(String[] args) {
		String[] nameAry = {"È«±æµ¿","±è±æµ¿","È«±æµ¿","¹Ú±æµ¿","È«±æµ¿","È²±æµ¿"};
		
		String search = "È«±æµ¿";
		int count = 0;
		for(int i = 0; i < nameAry.length; i++) { // String name : nameAry
			if(nameAry[i].equals(search)) { // if(name.equals(search))
				count++;
			}
		}
		System.out.println(search + "Àº ÃÑ " + count + "¸í ÀÔ´Ï´Ù.");
		
		
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
