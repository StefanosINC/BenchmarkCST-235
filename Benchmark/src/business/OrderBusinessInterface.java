package business;

import java.util.List;

import javax.ejb.Local;



import beans.Order;
import beans.Verse;
@Local
public interface OrderBusinessInterface {

	public void test();
	public List<Verse> getVerse();
	public void setVerse(List<Verse> verse);
	
	public void sendOrder(Verse verse);
	
	

}
