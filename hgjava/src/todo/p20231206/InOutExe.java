package todo.p20231206;

import java.util.ArrayList;
import java.util.List;

public class InOutExe {
	List<InOut> inout;

	InOutExe() {
		inout = new ArrayList<InOut>();
		inout.add(new InOut("P001", "2023-12-06", 10, "구매"));
		inout.add(new InOut("P001", "2023-12-06", 2, "판매"));
		inout.add(new InOut("P001", "2023-12-06", 3, "판매"));
	}

	boolean prodSellAdd(InOut inouts) {
		return inout.add(inouts);
	}

	boolean prodBuyAdd(InOut inouts) {
		return inout.add(inouts);
	}

	boolean prodStock(int prodBuy, int prodSell) {
		for (int i = 0; i < inout.size(); i++) {
			if (inout.get(i).getBuySell().equals("구매")) {
				prodBuy = inout.get(i).getProdQuan();
			} else if (inout.get(i).getBuySell().equals("판매")) {
				prodSell = inout.get(i).getProdQuan();
				return true;
			}
		}
		return false;
	}

}
