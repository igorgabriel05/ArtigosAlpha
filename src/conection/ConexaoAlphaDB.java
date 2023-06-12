package conection;


import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoAlphaDB {
    public Connection getConexao() {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/projetoalpha?serverTimezone=UTC",
                    "root", //User
                    "" //Senha
            );
            return conn;
        } catch (Exception e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            return null;
        }
    }
}
