package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import java.io.IOException;

public class Connector {
	
	private static Connection conn;
	Statement stmt = null;
	ResultSet rs = null;

    private Db db;
	public void Connector() {}
	public ResultSet exec(String query){

		this.connect();
		try {
		stmt = Connector.conn.createStatement();
		rs = stmt.executeQuery(query);

		} catch (SQLException ex){
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
		}
		return rs;
	}

	public void connect(){

		if (conn == null) {
			try {
				conn = DriverManager.getConnection(
                    "jdbc:mysql://"
                    + db.host + ":" + db.port
                    + "/" +  db.database, db.user, db.pass);

			} catch(SQLException ex){
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			}
		}
	}
	public static boolean tryConnect(Db db){
        Connection tmp = null;
			try {
				tmp = DriverManager.getConnection(
                    "jdbc:mysql://"
                    + db.host + ":" + db.port
                    + "/" +  db.database, db.user, db.pass);

			} catch(SQLException ex){
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
                return false;
			} finally {
                return !(tmp == null);
            }
	}
}
