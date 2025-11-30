package ConexaoBanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    // URL do banco
    private static final String URL = "jdbc:mysql://localhost:3306/sustentamais";
    private static final String USER = "root"; 
    private static final String PASS = "";
    
    // Método para pegar a conexão
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Erro na conexão: " + e.getMessage());
            return null;
        }
    }
}
