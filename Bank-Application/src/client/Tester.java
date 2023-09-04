package client;
import java.sql.Connection;
import java.sql.SQLException;

import Data.*;



public class Tester {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

	       Connection con = null;
        con = ConnectionDB.getConnection();
        if(con != null)
        {
         System.out.println("\n\n\t Connection has been established! \n\n");
        }
        else
        {
            System.out.println("\n\n\t Connection could not be established =( \n\n");
        }
        System.out.println("\n\n----------------\n\n");
        
        
	}

}
