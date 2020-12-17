package business;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;


import beans.Order;
import beans.Verse;

@Stateless
@Local(OrderBusinessInterface.class)
@Alternative


public class OrderBusinessService implements OrderBusinessInterface {
	List<Order> orders = new ArrayList<Order>();
	List<Verse> verse = new ArrayList<Verse>();
	
	@Resource(mappedName="java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;

	@Resource(mappedName="java:/jms/queue/Order")
	private Queue queue;
	
	
	@Override
	public void test() {
		System.out.println("========= Hello from the test method . Order Business Service Version #1");
		
		
		
	}

	public OrderBusinessService() {

	// manual add from the ( verse)
		verse.add(new Verse("Romans", "8:38", 39));
		verse.add(new Verse("Lamentations", "3:22", 23));
		verse.add(new Verse("Matthew", "19:26", 30));


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


	// Update orders business Service v2
	
	public void sendOrder(Verse verse) {
	// Send a Message for an Order
			try 
			{
				Connection connection = connectionFactory.createConnection();
				Session  session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
				MessageProducer messageProducer = session.createProducer(queue);
				TextMessage message1 = session.createTextMessage();
				message1.setText("This is test message");
				messageProducer.send(message1);
				connection.close();
				
				ObjectMessage message2 = session.createObjectMessage();
				message2.setObject(verse);
			} 
			catch (JMSException e) 
			{
				e.printStackTrace();
			}		
	}
		





}
