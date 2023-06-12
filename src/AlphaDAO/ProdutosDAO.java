package AlphaDAO;

import beansAlphaDB.Produtos;
import conection.ConexaoAlphaDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutosDAO {

    private ConexaoAlphaDB conexao;
    private Connection conn;

    public ProdutosDAO() {
        this.conexao = new ConexaoAlphaDB();
        this.conn = this.conexao.getConexao();
    }

    public void adicionar(Produtos produtos) {
        String sql = "INSERT INTO alphaprodutos(produto, preco, quantidade, tipo) VALUES " + "(?, ?, ?, ?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, produtos.getProduto());
            stmt.setDouble(2, produtos.getPreco());
            stmt.setInt(3, produtos.getQuantidade());
            stmt.setString(4, produtos.getTipo());
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao adicionar produto: " + e.getMessage());
        }
    }

    public void editar(Produtos produtos) {
        String sql = "UPDATE alphaprodutos SET produto=?, preco=?, quantidade=?, tipo=? WHERE codigo=?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, produtos.getProduto());
            stmt.setDouble(2, produtos.getPreco());
            stmt.setInt(3, produtos.getQuantidade());
            stmt.setString(4, produtos.getTipo());
            stmt.setInt(5, produtos.getId());
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao editar produto: " + e.getMessage());
        }
    }

    public void remover(int id) {
        String sql = "DELETE FROM alphaprodutos WHERE codigo = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao excluir produto: " + e.getMessage());
        }
    }

    public Produtos getProdutos(int id) {
        String sql = "SELECT * FROM alphaprodutos WHERE codigo = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Produtos produtos = new Produtos();

            while (rs.next()) {
                produtos.setId(id);
                produtos.setProduto(rs.getString("produto"));
                produtos.setPreco(rs.getDouble("preco"));
                produtos.setQuantidade(rs.getInt("Quantidade"));
                produtos.setTipo(rs.getString("tipo"));
                return produtos;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Produtos> getProdutos(String produto) {
        String sql = "SELECT * FROM alphaprodutos WHERE produto LIKE ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, "%" + produto + "%");
            ResultSet rs = stmt.executeQuery();
            List<Produtos> listaProdutos = new ArrayList<>();
            //pecorre o "rs" e salva as informações dentro de uma var "Curso"
            //e depois salva essa var dentro da lista
            while (rs.next()) {
                Produtos produtos = new Produtos();
                produtos.setId(rs.getInt("codigo"));
                produtos.setProduto(rs.getString("produto"));
                produtos.setPreco(rs.getDouble("preco"));
                produtos.setQuantidade(rs.getInt("quantidade"));
                produtos.setTipo(rs.getString("tipo"));
                listaProdutos.add(produtos);
            }
            return listaProdutos;
        } catch (Exception e) {
            return null;
        }   
    }
//    public List<Produtos> getPreco(double preco) {
//        String sql = "SELECT * FROM alphaprodutos WHERE preco LIKE ?";
//        try {
//            PreparedStatement stmt = this.conn.prepareStatement(sql);
//            stmt.setString(1, "%" + preco + "%");
//            ResultSet rs = stmt.executeQuery();
//            List<Produtos> listaPreco = new ArrayList<>();
//            //pecorre o "rs" e salva as informações dentro de uma var "Curso"
//            //e depois salva essa var dentro da lista
//            while (rs.next()) {
//                Produtos produtos = new Produtos();
//                produtos.setId(rs.getInt("codigo"));
//                produtos.setPreco(rs.getDouble("preco"));
//                listaPreco.
//            }
//            return listaProdutos;
//        } catch (Exception e) {
//            return null;
//        }   
//    }
}
