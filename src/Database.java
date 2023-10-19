
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    public static void getCustomers() throws SQLException {
//        Connection c = DriverManager.getConnection("jdbc:hsqldb:file:testDB/testDB", "SA", "");
        //java -cp ../lib/hsqldb.jar org.hsqldb.server.Server --database.0 file:testDB/testDB --dbname.0 testDB
        //java -cp ../lib/hsqldb.jar org.hsqldb.server.Server --database.0 file:sampledb/sampledb --dbname.0 sampledb
        Connection conn = null;
        String db = "jdbc:hsqldb:hsql://localhost/testDB;ifexists=true";
        String user = "SA";
        String password = "";
        try {
            // Create database connection
            conn = DriverManager.getConnection(db, user, password);

            // Create and execute statement
            Statement stmt = conn.createStatement();
            stmt.executeQuery("create table ORDERS(Date DATETIME, OrderID VARCHAR(255))");
            ResultSet rs =  stmt.executeQuery("select FIRSTNAME, LASTNAME from CUSTOMER");

            // Loop through the data and print all artist names
            while(rs.next()) {
                System.out.println("Customer Name: " + rs.getString("FIRSTNAME") + " " + rs.getString("LASTNAME"));
            }

            // Clean up
            rs.close();
            stmt.close();
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        finally {
            try {
                // Close connection
                if (conn != null)
                    conn.close();
            }
            catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // Retrieve all customers
        getCustomers();
    }

}





