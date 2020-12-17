package business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.Order;
import beans.Verse;

@Stateless
@Local(OrderBusinessInterface.class)
@Alternative

public class AnotherOrderBusinessService implements OrderBusinessInterface {

	
	List<Order> orders = new ArrayList<Order>();
	List<Verse> verse = new ArrayList<Verse>();
	@Override
	public void test() {
		System.out.println("========= Hello from the test method . Order from Another Business Service Version #2");
		
		
		
	}
	public AnotherOrderBusinessService() {

		
	//	orders.add(new Order("0000000a", "Product #1 from Alternative BS", (float)12.90, 12));
		
	//	orders.add(new Order("0000000b", "Product #2 from Alternative BS", (float)10.10, 23));
	//	orders.add(new Order("0000000c", "Product #3 from Alternative BS", (float)33.12, 34));
	//	orders.add(new Order("0000000c", "Product #4 from Alternative BS", (float)57.00, 45));
	//	orders.add(new Order("0000000D", "Product #5 from Alternative BS", (float)84.31, 15));
	//	orders.add(new Order("0000000e", "Product #6 from Alternative BS", (float)94.00, 61));
	}
	@Override
	public List<Verse> getVerse() {
		// TODO Auto-generated method stub
		return verse;
	}
	@Override
	public void setVerse(List<Verse> verse) {
		this.verse = verse;
		
		
	}
	@Override
	public void sendOrder(Verse verse) {
		// TODO Auto-generated method stub
		
	}
	}


