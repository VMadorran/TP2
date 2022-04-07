package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import objetos.RegistroDePedido;

public class EnBaseRegistroDePedido implements RegistroDePedido {

	private static String DRIVER = "com.mysql.jdbc.Driver";
	private static String URL_DB = "jdbc:mysql://localhost:3306/";
	protected static String DB = "registro_pedido";
	protected static String user = "root";
	protected static String pass = "";
	protected static Connection conn = null;

	private void connect() {
		try {
			conn = DriverManager.getConnection(URL_DB + DB + "?useSSL=false", user, pass);
		} catch (SQLException sqlEx) {
			System.out.println("No se ha podido conectar a " + URL_DB + DB + ". " + sqlEx.getMessage());
			System.out.println("Error al cargar el driver");
		}
	}

	private void disconnect() {
		if (conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void registrarPedido(String registro) {

		//String consulta = "INSERT INTO registro(registro) VALUES (?)";
		
		
		this.connect();
		
		
		
		try {
			PreparedStatement statement = conn.prepareStatement(
					"INSERT INTO registro(registro) "
			+ "VALUES (?)");
			statement.setString(1, registro);
			System.out.println("Se conecto");
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.disconnect();
			System.out.println("Se desconecto");
		}

	
		
	}

	@Override
	public String contenido() {
		// TODO Auto-generated method stub
		return null;
	}


}
