package cs623project;

import java.io.IOException;
import java.sql.*;


public class JavaToMySQL {

	public static void main(String[] args)throws SQLException, IOException, 
	ClassNotFoundException {
		final String url = "jdbc:postgresql://localhost:5432/postgres";
	    final String user = "postgres";
	    final String pwd = "6363";
        Connection conn = DriverManager.getConnection(url, user, pwd);
        conn.setAutoCommit(false);
        conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
		
		Statement stmt1 = null,stmt2=null,stmt3=null,stmt4=null,stmt5=null,stmt6=null;
		try {
			// Create statement object
			//Question 5
			stmt1 = conn.createStatement();			
			stmt1.executeUpdate("insert into product values ('p100','cd','5.0')");
			stmt1.executeUpdate("insert into stock values ('p100','d2',50)");
			System.out.println("Inserted New Product Successfully");
			//Question 6
			stmt2 = conn.createStatement();
			stmt2.executeUpdate("insert into depot values ('d100','chicago',100)");
			stmt2.executeUpdate("insert into stock values ('p1','d100',100)");
			System.out.println("Inserted New Depot Successfully");
			//Question 2
			stmt3 = conn.createStatement();
			stmt3.executeUpdate("delete from stock where dep_id='d1'");
			stmt3.executeUpdate("delete from depot where dep_id='d1'");	
			System.out.println("Deleted depot d1 Successfully");
			//Question 1
			stmt4 = conn.createStatement();
			stmt4.executeUpdate("delete from stock where prod_id='p1'");
			stmt4.executeUpdate("delete from product where prod_id='p1'");	
			System.out.println("Deleted Product p1 Successfully");
			//Question 3
			stmt5 = conn.createStatement();		
			stmt5.executeUpdate("update product set prod_id='pp1' where prod_id='p1'");	
			stmt5.executeUpdate("update stock set prod_id='pp1' where prod_id='p1'");
			System.out.println("Updated Product p1 to pp1 Successfully");
			//Question 4
			stmt6 = conn.createStatement();				
			stmt6.executeUpdate("update stock set dep_id='dd1' where dep_id='d1'");
			stmt6.executeUpdate("update depot set dep_id='dd1' where dep_id='d1'");	
			System.out.println("Updated depot d1 to dd1 Successfully");
		} catch (SQLException e) {
			System.out.println("An exception was thrown");
			System.out.println(e.getMessage());
			// For atomicity
			conn.rollback();
			stmt1.close();
			stmt2.close();
			stmt3.close();
			stmt4.close();
			stmt5.close();
			stmt6.close();
			conn.close();
			return;
		}
		conn.commit();
		stmt1.close();
		stmt2.close();
		stmt3.close();
		stmt4.close();
		stmt5.close();
		stmt6.close();
		conn.close();

	}

}
