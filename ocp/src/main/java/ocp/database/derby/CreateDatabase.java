/**
 * 
 */
package ocp.database.derby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author edinjos
 *
 */
public class CreateDatabase {

	private final static String CREATE_SPECIES = "CREATE TABLE species( "
			+ "id INTEGER PRIMARY KEY," + " name VARCHAR(255) , "
			+ "num_acres DECIMAL)";
	
	private final static String CREATE_ANIMAL = "CREATE TABLE animal(id INTEGER PRIMARY KEY, species_id integer , name VARCHAR(255), date_born TIMESTAMP)";

	private final static String CREATE_EMPLOYEE = "create table EMPLOYEE ( id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1,INCREMENT BY 1) , first_name VARCHAR(20) default NULL, last_name VARCHAR(20) default NULL, salary INT default NULL, PRIMARY KEY (id) )";

	/**
	 * 
	 */
	public CreateDatabase() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) {

		//String url = "jdbc:derby:zoo;create=true";
		//String url = "jdbc:derby:application;create=true";
		String url = "jdbc:derby:testDB;user=dinesh;password=joshi;create=true";
		try (Connection conn = DriverManager.getConnection(url);
				Statement stmt = conn.createStatement()) {
			createTables(stmt);
			//insertData(stmt);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void createTables(Statement stmt) throws SQLException {
		System.out.println("Creating DB");
		//stmt.executeUpdate(CREATE_SPECIES);
		//stmt.executeUpdate(CREATE_ANIMAL);
		stmt.executeUpdate(CREATE_EMPLOYEE);
	}

	public static void insertData(Statement stmt) throws SQLException {
		System.out.println("Inserting Data");
		stmt.execute("INSERT into species values(1,'African Elephant',7.5)");
		stmt.execute("INSERT into species values(2,'Zebra',1.2)");

		stmt.execute("INSERT into animal values(1,1,'Elsa','2001-05-06 02:15:00')");
		stmt.execute("INSERT into animal values(2,2,'Zelda','2002-08-15 09:15:00')");
		stmt.execute("INSERT into animal values(3,1,'Ester','2002-05-06 03:15:00')");
		stmt.execute("INSERT into animal values(4,1,'Eddie','2010-05-06 07:15:00')");
		stmt.execute("INSERT into animal values(5,2,'Zoe','2005-05-06 08:15:00')");
	}
}
