package br.com.bd1.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	// nome user
	private static final String USERNAME = "root";
	
	// Senha banco
	private static final String PASSWORD = "root";
	
	// path banco
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/db1";
	
	//Conex�o banco
	
	public static Connection createConnectionToMySQL() throws Exception {
		// Carregar classe pela JVM
		Class.forName("com.mysql.jdbc.Driver");
		// Cria conex�o banco de dados
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}
	
	public static void main(String[] args) throws Exception{
		Connection con = createConnectionToMySQL();
		
		if(con!=null) {
			System.out.println("Conex�o Realizada!");
			con.close();
		}
		
	}
}
