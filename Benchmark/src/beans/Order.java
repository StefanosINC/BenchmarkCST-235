package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Order") 

public class Order implements Serializable {

	
	String orderNO = "";
	String productName = "";
	float price = 0;
	int quanity = 0;
	
	
	
	public Order(String orderNO, String productName, float price, int quanity) {
		super();
		this.orderNO = orderNO;
		this.productName = productName;
		this.price = price;
		this.quanity = quanity;
	}
	public Order() {
		
	}


	

	public String getOrderNO() {
		return orderNO;
	}



	public void setOrderNO(String orderNO) {
		this.orderNO = orderNO;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public float getPrice() {
		return price;
	}



	public void setPrice(float price) {
		this.price = price;
	}



	public int getQuanity() {
		return quanity;
	}



	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}
	@Override
    public String toString() {
        return String.format("ordernumber: " + orderNO + " , productname: " + productName + " , price : " 
                            + price + " , quantity : " + quanity);
    }
	
	
}

