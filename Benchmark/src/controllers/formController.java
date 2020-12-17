package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.Order;

import beans.User;
import beans.Verse;
import business.OrderBusinessInterface;
import business.OrderBusinessService;

@ManagedBean
@ViewScoped
public class formController {

	@Inject
	OrderBusinessInterface services;
	
	// insert order method
	
	private void insertOrder() {
		// set connection to null
        Connection conn = null;
        // Establish Strings for the insert order
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "root";
        String sql = "INSERT INTO BenchMark.Verse(BOOK_NAME, CHAPTER_NUMBER, VERSE_NUMBER) "
                    + "VALUES('GOD', '34', '25'";
        
        // Try catch to retrieve the information
        try {
        conn = DriverManager.getConnection(url, username, password);
        
        // create a conn statement and execute the update
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
        
    
    }                // catch exception
    catch (SQLException e) {
        e.printStackTrace();
    }
    finally {
     // database connection
        if(conn != null) {
            try {
                conn.close();
            }
            // catch the SQL exception
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
	

	private void getAllOrders() {
		
		// Sett Conn to null
		Connection conn = null;
		// Establish my Postgres connection 
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "root";
		
		// sql string
		String sql = "SELECT * FROM testapp.verse";
		
		
		// establish new list of orders
		List <Verse> verse = new ArrayList<Verse>();
		
		try {
			
			// get connection
			conn = DriverManager.getConnection(url,username, password);
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				services.getVerse().add(new Verse(rs.getString("CHAPTER_NUMBER"), 
						rs.getString("CHAPTER_NUMBER"), rs.getInt("VERSE_NUMBER")));
				
			}
			// testing
			if (verse.size() > 10) {
				
                System.out.println("Success!!!");
                for (int i = 0; i < verse.size(); i++) {
                    System.out.println(verse.get(i).toString());
                }
            }
            else {
                System.out.println("FAILURE!");
            }
		
			// close
			rs.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			// if conn not equal null
			if(conn != null) {
				try {
					// try close
					conn.close();
				}
				catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		System.out.println("Sucesss!");
		
	}
	
	
	public String onSubmit() {
		// Get the user Managed Bean
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		
		
		// prints a message to console to inform which business service is used in beans.xml file
		services.test();
		
		// Call on the
		getAllOrders();
		insertOrder();
		getAllOrders();
		// Start a timer when the login is clicked
		
		
		//Forward to Test response view along with the User managed bean
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		
		return "Response.xhtml";
	}
	public String onSumbit(User user) {
	FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
	return "Response.xhtml";
}
	public OrderBusinessInterface getService() {
		return services;
		
	}
	public String onSendOrder() {

		// do i have it set to null?
		
		services.sendOrder(new Verse("Test Verse", "Verse Test",3));
		
	return "OrderResponse.xhtml";
		
	}
}