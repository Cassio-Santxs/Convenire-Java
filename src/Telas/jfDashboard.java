/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Telas;

import Models.Consulta;
import Models.Pagamento;
import Models.Usuario;
import dao.ConsultaDao;
import dao.PagamentoDao;
import dao.UsuarioDao;
import java.awt.BorderLayout;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Aluno 63
 */
public class jfDashboard extends javax.swing.JFrame {
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Consulta> listaConsultas;
    private ArrayList<Pagamento> listaPagamentos;
    
    /**
     * Creates new form jfHome
     */
    public jfDashboard() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        consltaLabel = new javax.swing.JLabel();
        usuarioLabel = new javax.swing.JLabel();
        jlTotalCadastros = new javax.swing.JPanel();
        labelQtdeCadastros = new javax.swing.JLabel();
        pagamentoLabel = new javax.swing.JLabel();
        jlTotalCadastros2 = new javax.swing.JPanel();
        labelQtdeConsultas = new javax.swing.JLabel();
        pizzaPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 207, 0));
        jLabel1.setText("Convenire - Dashboard");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(244, 244, 244));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 207, 0));

        consltaLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        consltaLabel.setForeground(new java.awt.Color(255, 255, 255));
        consltaLabel.setText("Consultas Agendadas");
        consltaLabel.setName("loginLabel"); // NOI18N

        usuarioLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        usuarioLabel.setForeground(new java.awt.Color(255, 255, 255));
        usuarioLabel.setText("Usuários Cadastrados");
        usuarioLabel.setName("loginLabel"); // NOI18N

        jlTotalCadastros.setBackground(new java.awt.Color(255, 255, 255));
        jlTotalCadastros.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelQtdeCadastros.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        labelQtdeCadastros.setText("0");

        javax.swing.GroupLayout jlTotalCadastrosLayout = new javax.swing.GroupLayout(jlTotalCadastros);
        jlTotalCadastros.setLayout(jlTotalCadastrosLayout);
        jlTotalCadastrosLayout.setHorizontalGroup(
            jlTotalCadastrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jlTotalCadastrosLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(labelQtdeCadastros)
                .addContainerGap(93, Short.MAX_VALUE))
        );
        jlTotalCadastrosLayout.setVerticalGroup(
            jlTotalCadastrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jlTotalCadastrosLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(labelQtdeCadastros)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pagamentoLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        pagamentoLabel.setForeground(new java.awt.Color(255, 255, 255));
        pagamentoLabel.setText("Pagamentos");
        pagamentoLabel.setName("loginLabel"); // NOI18N

        jlTotalCadastros2.setBackground(new java.awt.Color(255, 255, 255));
        jlTotalCadastros2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelQtdeConsultas.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        labelQtdeConsultas.setText("0");

        javax.swing.GroupLayout jlTotalCadastros2Layout = new javax.swing.GroupLayout(jlTotalCadastros2);
        jlTotalCadastros2.setLayout(jlTotalCadastros2Layout);
        jlTotalCadastros2Layout.setHorizontalGroup(
            jlTotalCadastros2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jlTotalCadastros2Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(labelQtdeConsultas)
                .addContainerGap(93, Short.MAX_VALUE))
        );
        jlTotalCadastros2Layout.setVerticalGroup(
            jlTotalCadastros2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jlTotalCadastros2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(labelQtdeConsultas)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pizzaPanelLayout = new javax.swing.GroupLayout(pizzaPanel);
        pizzaPanel.setLayout(pizzaPanelLayout);
        pizzaPanelLayout.setHorizontalGroup(
            pizzaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pizzaPanelLayout.setVerticalGroup(
            pizzaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pizzaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usuarioLabel)
                            .addComponent(jlTotalCadastros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pagamentoLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(consltaLabel)
                            .addComponent(jlTotalCadastros2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(consltaLabel)
                    .addComponent(usuarioLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlTotalCadastros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlTotalCadastros2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(pagamentoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pizzaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       atualizaInfos(new UsuarioDao(), new ConsultaDao(), new PagamentoDao());
      // atualizaInfosPagamentos(new PagamentoDao());
    }//GEN-LAST:event_formWindowOpened

    private void atualizaInfos(UsuarioDao usuarioDao, ConsultaDao consultaDao, PagamentoDao pagamentoDao) {
        new Thread() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        // Usuários
                        listaUsuarios = usuarioDao.getTodosRegistros();
                        
                        labelQtdeCadastros.setText(Integer.toString(listaUsuarios.size()));
                        
                        // Consultas
                        listaConsultas = consultaDao.getTodosRegistros();
                        
                        labelQtdeConsultas.setText(Integer.toString(listaConsultas.size()));
                        
                        // Pagamentos
                        listaPagamentos = pagamentoDao.getTodosRegistros();
                        
                        int qtdPagos = 0;
                        int qtdPendentes = 0;
                    
                        DefaultPieDataset pizzaChartData = new DefaultPieDataset();

                        for(Pagamento pagamento : listaPagamentos)
                        {
                             if("Pendente".equals(pagamento.getFlStatus()))
                                 qtdPendentes = qtdPendentes + 1;   
                             else
                                 qtdPagos = qtdPendentes + 1;   
                        }
                        
                        pizzaChartData.setValue("Pendentes", qtdPendentes);
                        pizzaChartData.setValue("Pagos", qtdPagos);
                        
                        JFreeChart pizzaChart = ChartFactory.createPieChart("", pizzaChartData);
                        PiePlot pizzachrt = (PiePlot)pizzaChart.getPlot();
                        
                        ChartPanel ChartPizza = new ChartPanel(pizzaChart);
                        
                        pizzaPanel.removeAll();
                        pizzaPanel.add(ChartPizza,BorderLayout.CENTER);
                        pizzaPanel.validate();
                        
                        try {
                            Thread.sleep(1000); 
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado:\n" + ex.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
                        Thread.currentThread().interrupt();
                        setVisible(false);
                    }
                }
            }
        }.start();
    }
   
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
            java.util.logging.Logger.getLogger(jfDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel consltaLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jlTotalCadastros;
    private javax.swing.JPanel jlTotalCadastros2;
    private javax.swing.JLabel labelQtdeCadastros;
    private javax.swing.JLabel labelQtdeConsultas;
    private javax.swing.JLabel pagamentoLabel;
    private javax.swing.JPanel pizzaPanel;
    private javax.swing.JLabel usuarioLabel;
    // End of variables declaration//GEN-END:variables
}
