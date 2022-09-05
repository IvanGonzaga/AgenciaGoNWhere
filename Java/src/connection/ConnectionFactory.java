package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
		
		private static final String USERNAME = "root";
		private static final String PASSWORD = "";
		private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/ivan_gonwhere";
		
		public static Connection createConnectionToMySQL() throws
	Exception{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
				return connection;
	}


		public static void main(String[] args) throws Exception {
				
			Connection con = createConnectionToMySQL();
			
			if(con != null){
			
				System.out.println("Conexao obtida com sucesso! " );
				
				con.close();
			}
		}
	}
