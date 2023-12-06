package todo.p20231206;

import java.util.Scanner;

public class ProductApp {
	public static void main(String[] args) {
		// 1.상품관리 2.입출고관리 3.종료
		// 1-1)등록 1-2)수정 1-3)목록
		// 2-1)판매 2-2)구매 2-3)재고 -> 재고 P001 5(개) P002 3(개) N001 10(개) N002 12(개)
		Scanner scn = new Scanner(System.in);
//		List<Product> products = new ArrayList<>();
		ProductExe exe = new ProductExe();
		InOutExe exe2 = new InOutExe();

		boolean run = true;
		while (run) {
			
			System.out.println("1.상품관리 2.입출고관리 3.종료");
			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
			case 1:
				System.out.println("1)등록 2)수정 3)목록");
				int subMenu = Integer.parseInt(scn.nextLine());
				switch (subMenu) {
				case 1:
					System.out.println("상품코드 입력>> ");
					String proNo = scn.nextLine();
					System.out.println("상품명 입력>> ");
					String proName = scn.nextLine();
					System.out.println("상품가격 입력>> ");
					int price = Integer.parseInt(scn.nextLine());
					exe.products.add(new Product(proNo, proName, price));
					System.out.println("상품등록 완료");
					break;
				case 2:
					System.out.println("수정할 상품코드 입력>> ");
					proNo = scn.nextLine();
					System.out.println("수정할 상품가격 입력>> ");
					price = Integer.parseInt(scn.nextLine());
					if (exe.prodMod(proNo, price)) {
						System.out.println("수정 완료");
					} else {
						System.out.println("수정 실패");
					}
					break;
				case 3:
					System.out.println("  상품코드  /  상품명  /  가격  ");
					System.out.println("==========================");
					
					for (int i = 0; i < exe.products.size(); i++) {
						exe.products.get(i).showInfo();
					}
					break;
				}
				break;
			case 2:
				System.out.println("1)판매 2)구매 3)재고");
				int subMenu2 = Integer.parseInt(scn.nextLine());
				int prodBuy = 0;
				int prodSell = 0;
				switch (subMenu2) {
				case 1:
					System.out.println("판매할 상품코드 입력>> ");
					String prodCode = scn.nextLine();
					System.out.println("판매수량 입력>> ");
					int prodQuan = Integer.parseInt(scn.nextLine());
					prodSell += prodQuan;
					System.out.println("처리날짜 입력>> ");
					String date2 = scn.nextLine();
					InOut inouts = new InOut(prodCode,"판매",prodQuan,date2);
					if(exe2.prodSellAdd(inouts)) {
						System.out.println("판매완료");
					}else {
						System.out.println("판매실패");
					}
					break;
				case 2:
					System.out.println("구매할 상품코드 입력>> ");
					prodCode = scn.nextLine();
					System.out.println("구매수량 입력>> ");
					prodQuan = Integer.parseInt(scn.nextLine());
					System.out.println("처리날짜 입력>> ");
					date2 = scn.nextLine();
					inouts = new InOut(prodCode,"구매",prodQuan,date2);
					if(exe2.prodBuyAdd(inouts)) {
						System.out.println("구매완료");
					}else {
						System.out.println("구매실패");
					}
					break;
				case 3:
					System.out.println("상품코드 재고수량");
//					if(exe2.prodStock(inouts)) {
//						System.out.println(stock);
//					}else {
//						System.out.println("재고가 없습니다.");
//					}
					
					break;
				}
				break;
			case 3:
				System.out.println("종료합니다.");
				run = false;
			}
		}
		System.out.println("end of prog");
	}
}
