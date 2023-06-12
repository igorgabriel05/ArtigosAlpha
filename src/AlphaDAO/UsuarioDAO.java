package AlphaDAO;

import beansAlphaDB.Usuario;
import conection.ConexaoAlphaDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UsuarioDAO {

    private ConexaoAlphaDB conexao;
    private Connection conn;

    public UsuarioDAO() {
        this.conexao = new ConexaoAlphaDB();
        this.conn = this.conexao.getConexao();
    }

    public void cadastrar(Usuario usuario) {
        String sql = "INSERT INTO usuarios(usuario, senha) VALUES " + "(?, ?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getSenha());
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao adicionar usuario: " + e.getMessage());
        }
    }

    public Usuario getUsuario(String user, String senha) {
        String sql = "SELECT * FROM usuarios WHERE usuario = ? and senha = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, user);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            Usuario usuario = new Usuario();

            while (rs.next()) {
                usuario.setId(rs.getInt("id"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setSenha(rs.getString("senha"));
                return usuario;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
