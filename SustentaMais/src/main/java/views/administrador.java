package views;
import ConexaoBanco.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class administrador extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(administrador.class.getName());

    /**
     * Creates new form administrador
     */
    public administrador() {
        initComponents();
        carregarTabela();
        carregarBairrosCombo();
    }
    
    private void carregarBairrosCombo() {
    Connection con = Conexao.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
        String sql = "SELECT nome_bairro FROM bairros ORDER BY nome_bairro";
        stmt = con.prepareStatement(sql);
        rs = stmt.executeQuery();

        jcboxSelecionarBairros.removeAllItems(); // Limpa
        while (rs.next()) {
            jcboxSelecionarBairros.addItem(rs.getString("nome_bairro"));
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro ao carregar bairros: " + ex.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (con != null) con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

    
    private void carregarTabela() {
    DefaultTableModel model = (DefaultTableModel) tblBairros.getModel();
    model.setRowCount(0);

    Connection con = Conexao.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
        String sql = "SELECT b.id_bairro, b.nome_bairro, COALESCE(r.quantidade_kg, 0) AS quantidade " +
                     "FROM bairros b LEFT JOIN residuos_reciclados r " +
                     "ON b.id_bairro = r.id_bairro ORDER BY nome_bairro";

        stmt = con.prepareStatement(sql);
        rs = stmt.executeQuery();

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("id_bairro"),
                rs.getString("nome_bairro"),
                rs.getInt("quantidade")
            });
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro ao carregar dados: " + ex.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (con != null) con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}




    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        btnDenuncias = new javax.swing.JButton();
        btnReciclagem = new javax.swing.JButton();
        btnClassificacao = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBairros = new javax.swing.JTable();
        quantidade = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        btnAplicarAlteracao = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jcboxSelecionarBairros = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        CriarBairro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        SelecionarServico = new javax.swing.JComboBox<>();
        jcboxDiasSemana = new javax.swing.JComboBox<>();
        jcboxPeriodo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btnAdicionarBairros = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(76, 175, 80));

        btnHome.setText("Home");
        btnHome.setBorderPainted(false);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnDenuncias.setText("Denuncias");
        btnDenuncias.setBorderPainted(false);
        btnDenuncias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDenunciasActionPerformed(evt);
            }
        });

        btnReciclagem.setText("Reciclagem");
        btnReciclagem.setBorderPainted(false);

        btnClassificacao.setText("Classificação");
        btnClassificacao.setBorderPainted(false);
        btnClassificacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClassificacaoActionPerformed(evt);
            }
        });

        jButton1.setText("administrador");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jButton1)
                .addGap(30, 30, 30)
                .addComponent(btnHome)
                .addGap(35, 35, 35)
                .addComponent(btnDenuncias)
                .addGap(35, 35, 35)
                .addComponent(btnReciclagem)
                .addGap(35, 35, 35)
                .addComponent(btnClassificacao)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHome)
                    .addComponent(btnDenuncias)
                    .addComponent(btnReciclagem)
                    .addComponent(btnClassificacao)
                    .addComponent(jButton1))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Inserir dados de reciclagem");

        tblBairros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Bairros", "Quantidade"
            }
        ));
        jScrollPane1.setViewportView(tblBairros);

        jLabel4.setText("Quantidade atual:");

        btnAplicarAlteracao.setText("Aplicar");
        btnAplicarAlteracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarAlteracaoActionPerformed(evt);
            }
        });

        jLabel8.setText("Bairros:");

        jcboxSelecionarBairros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcboxSelecionarBairros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcboxSelecionarBairrosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addComponent(btnAplicarAlteracao, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 99, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 182, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcboxSelecionarBairros, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(39, 39, 39))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcboxSelecionarBairros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(btnAplicarAlteracao)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Dados de coleta");

        jLabel5.setText("Adiconar bairros");

        CriarBairro.setText("Bairro");

        jLabel6.setText("Adicionar dias de coleta:");

        jLabel7.setText("Tipo de Serviço");

        SelecionarServico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Reciclagem", "Lixo", "Óleo", " " }));
        SelecionarServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelecionarServicoActionPerformed(evt);
            }
        });

        jcboxDiasSemana.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jcboxPeriodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "manhã ", "tarde", "noite" }));
        jcboxPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcboxPeriodoActionPerformed(evt);
            }
        });

        jLabel3.setText("jLabel3");

        btnAdicionarBairros.setText("Adicionar");
        btnAdicionarBairros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarBairrosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jcboxDiasSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(SelecionarServico, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(CriarBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jcboxPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(89, 89, 89)
                                    .addComponent(btnAdicionarBairros))))))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CriarBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SelecionarServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jcboxDiasSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcboxPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdicionarBairros)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
      new Home().setVisible(true);
      dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnDenunciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDenunciasActionPerformed
        new Denuncia().setVisible(true); // abre a tela Denuncias
        dispose(); // fecha a tela atual (Home)
    }//GEN-LAST:event_btnDenunciasActionPerformed

    private void btnClassificacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClassificacaoActionPerformed
        new Classificacao().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnClassificacaoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        login login = new login();
        login.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAplicarAlteracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarAlteracaoActionPerformed
       String bairroSelecionado = (String) jcboxSelecionarBairros.getSelectedItem();
    int quantidadeNova = (int) quantidade.getValue();

    if (bairroSelecionado == null) {
        JOptionPane.showMessageDialog(null, "Selecione um bairro!");
        return;
    }

    try (Connection con = Conexao.getConnection()) {

        // 1 - buscar ID do bairro
        String sqlID = "SELECT id_bairro FROM bairros WHERE nome_bairro = ?";
        PreparedStatement psID = con.prepareStatement(sqlID);
        psID.setString(1, bairroSelecionado);
        ResultSet rs = psID.executeQuery();

        if (!rs.next()) {
            JOptionPane.showMessageDialog(null, "Erro: Bairro não encontrado!");
            return;
        }

        int id = rs.getInt("id_bairro");

        // 2 - Atualizar ou inserir
        String sqlUpsert = "INSERT INTO residuos_reciclados (id_bairro, quantidade_kg) VALUES (?, ?) " +
                            "ON DUPLICATE KEY UPDATE quantidade_kg = ?";
        PreparedStatement ps = con.prepareStatement(sqlUpsert);
        ps.setInt(1, id);
        ps.setInt(2, quantidadeNova);
        ps.setInt(3, quantidadeNova);
        ps.executeUpdate();

        JOptionPane.showMessageDialog(null, "Quantidade registrada com sucesso!");
        carregarTabela();

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Erro ao atualizar: " + e.getMessage());
    }
    }//GEN-LAST:event_btnAplicarAlteracaoActionPerformed

    private void jcboxSelecionarBairrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcboxSelecionarBairrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcboxSelecionarBairrosActionPerformed

    private void SelecionarServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelecionarServicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SelecionarServicoActionPerformed

    private void btnAdicionarBairrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarBairrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdicionarBairrosActionPerformed

    private void jcboxPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcboxPeriodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcboxPeriodoActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new administrador().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CriarBairro;
    private javax.swing.JComboBox<String> SelecionarServico;
    private javax.swing.JButton btnAdicionarBairros;
    private javax.swing.JButton btnAplicarAlteracao;
    private javax.swing.JButton btnClassificacao;
    private javax.swing.JButton btnDenuncias;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnReciclagem;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcboxDiasSemana;
    private javax.swing.JComboBox<String> jcboxPeriodo;
    private javax.swing.JComboBox<String> jcboxSelecionarBairros;
    private javax.swing.JSpinner quantidade;
    private javax.swing.JTable tblBairros;
    // End of variables declaration//GEN-END:variables
}
