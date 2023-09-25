package DBConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConfig {
	protected Connection conn;
    protected PreparedStatement stmt;
    protected ResultSet rs;
    
    public DBConfig()
    {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/notetakingapp","root","");
    	
    	}
    	catch(Exception e)
    	{
    		System.out.println("Error is "+e);
    	}
    	
    }
}
