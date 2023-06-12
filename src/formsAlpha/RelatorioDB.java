/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formsAlpha;

import AlphaDAO.ProdutosDAO;
import beansAlphaDB.Produtos;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Java
 */
public class RelatorioDB extends javax.swing.JFrame {

    private void preencheTabela() {
        //Criar uma var "produtosDAO" 
        //pegar os dados dos alunos da lista e jogar dentro da tabela
        ProdutosDAO produtosDAO = new ProdutosDAO();
        String produto = txtNomeProd.getText();
        List<Produtos> listaProdutos = produtosDAO.getProdutos(produto);

        DefaultTableModel tabelaProd = (DefaultTableModel) tblProd.getModel();
        //limpar a tabela para preencher com os novos dados
        tabelaProd.setNumRows(0);

        for (Produtos p : listaProdutos) {
            Object[] obj = new Object[]{
                p.getId(),
                p.getProduto(),
                p.getPreco(),
                p.getTipo(),
                p.getQuantidade()
            };
            tabelaProd.addRow(obj);
        }
    }

    private void somarValor() {
// Obtém o modelo de tabela da JTable
        DefaultTableModel model = (DefaultTableModel) tblProd.getModel();

// Variável para armazenar a soma
        double soma = 0.0;

// Percorre as linhas da coluna e soma os valores
        int numRows = model.getRowCount();
        for (int row = 0; row < numRows; row++) {
            // Obtém o valor da célula na coluna desejada como um objeto
            double valor = (double) model.getValueAt(row, 2);
            int qtd = (int) model.getValueAt(row, 4);
            soma += valor * qtd;
        }

// Exibe o resultado
        txtValorTotal.setText("R$" + String.valueOf(soma));

    }

    /**
     * Creates new form RelatorioDB
     */
    public RelatorioDB() {
        initComponents();
        preencheTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNomeProd = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProd = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtValorTotal = new javax.swing.JTextField();
        btnSomar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Lista de produtos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Nome produto:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, -1, -1));

        txtNomeProd.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtNomeProd.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtNomeProdCaretUpdate(evt);
            }
        });
        getContentPane().add(txtNomeProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 386, -1));

        tblProd.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome Produto", "Valor", "Tipo", "Quantidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProd);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 720, 440));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Valor total:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 580, -1, -1));

        txtValorTotal.setEditable(false);
        txtValorTotal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtValorTotal.setForeground(new java.awt.Color(0, 255, 0));
        getContentPane().add(txtValorTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 580, 148, -1));

        btnSomar.setBackground(new java.awt.Color(255, 255, 255));
        btnSomar.setFont(new java.awt.Font("Times New Roman", 1, 26)); // NOI18N
        btnSomar.setText("Somar");
        btnSomar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSomarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSomar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 580, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Alpha Store - Copia_LI.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 630));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeProdCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtNomeProdCaretUpdate
        preencheTabela();
    }//GEN-LAST:event_txtNomeProdCaretUpdate

    private void btnSomarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSomarActionPerformed
        somarValor();
    }//GEN-LAST:event_btnSomarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RelatorioDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatorioDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatorioDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatorioDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatorioDB().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSomar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProd;
    private javax.swing.JTextField txtNomeProd;
    private javax.swing.JTextField txtValorTotal;
    // End of variables declaration//GEN-END:variables
}