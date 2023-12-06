package todo.p20231206;

import lombok.Data;

@Data
public class Product {
	private String proNo;
	private String proName;
	private int price;

	public Product(String proNo, String proName, int price) {
		this.proNo = proNo;
		this.proName = proName;
		this.price = price;
	}

	void showInfo() {
		System.out.printf("%6s %8s %9d\n", proNo, proName, price);
	}
}
