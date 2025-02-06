/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package viewWindows;

import controller.ProductController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.ProductModel;

/**
 *
 * @author raposo
 */
public class putProductMenu extends javax.swing.JFrame {

    /**
     * Creates new form putProductMenu
     */
    public putProductMenu() {
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
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        productIdField = new javax.swing.JTextField();
        productIdBtt = new javax.swing.JButton();
        labelName = new javax.swing.JLabel();
        productNameField = new javax.swing.JTextField();
        productNameBtt = new javax.swing.JButton();
        labelStock = new javax.swing.JLabel();
        productStockField = new javax.swing.JTextField();
        productStockBtt = new javax.swing.JButton();
        backBtt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Informe o ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 17, 0, 0);
        getContentPane().add(jLabel1, gridBagConstraints);

        productIdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productIdFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 26;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 42, 0, 0);
        getContentPane().add(productIdField, gridBagConstraints);

        productIdBtt.setText("Filtrar");
        productIdBtt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productIdBttMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 18, 0, 1);
        getContentPane().add(productIdBtt, gridBagConstraints);

        labelName.setText("Alterar nome do produto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(54, 17, 0, 0);
        getContentPane().add(labelName, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 78;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(51, 18, 0, 0);
        getContentPane().add(productNameField, gridBagConstraints);

        productNameBtt.setText("Alterar");
        productNameBtt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productNameBttMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(51, 18, 0, 1);
        getContentPane().add(productNameBtt, gridBagConstraints);

        labelStock.setText("Alterar quantidade no estoque");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(71, 17, 0, 0);
        getContentPane().add(labelStock, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(68, 18, 0, 0);
        getContentPane().add(productStockField, gridBagConstraints);

        productStockBtt.setText("Alterar");
        productStockBtt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productStockBttMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(68, 18, 0, 1);
        getContentPane().add(productStockBtt, gridBagConstraints);

        backBtt.setText("Voltar");
        backBtt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backBttMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(100, 20, 0, 0);
        getContentPane().add(backBtt, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void productIdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productIdFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productIdFieldActionPerformed

    private void productIdBttMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productIdBttMouseClicked

        try {
            ProductController productController = new ProductController();
            
            ProductModel product = productController.getById(Integer.parseInt(productIdField.getText()));
            
            labelName.setVisible(true);
            labelStock.setVisible(true);
            productNameField.setVisible(true);
            productNameBtt.setVisible(true);
            productStockField.setVisible(true);
            productStockBtt.setVisible(true);
            productNameField.setText(product.getName());
            productStockField.setText(String.valueOf(product.getProductStock()));
        } catch (SQLException ex) {
            Logger.getLogger(putProductMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_productIdBttMouseClicked

    private void productNameBttMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productNameBttMouseClicked
        ProductController productController = new ProductController();
        if(productIdField.getText()==null || productNameField.getText()==null)
            JOptionPane.showMessageDialog(this, "Os campos ID e Nome precisam estar preenchidos.");
        else{
            try {
                boolean isValid = productController.updateProductStock(Integer.parseInt(productIdField.getText()),Integer.parseInt(productStockField.getText()));
                if(isValid==false)
                    JOptionPane.showMessageDialog(this, "Não existe usuário com esse ID.");
                else{
                    
                    JOptionPane.showMessageDialog(this, "Estoque atualizado.");
                }
            } catch (SQLException ex) {
                Logger.getLogger(putProductMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
    }//GEN-LAST:event_productNameBttMouseClicked

    private void productStockBttMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productStockBttMouseClicked
        ProductController productController = new ProductController();
        if(productIdField.getText()==null||productStockField.getText()==null)
            JOptionPane.showMessageDialog(this, "Os campos ID e Stock devem estar preenchidos.");
        else{
            try {
                boolean isValid = productController.updateProductStock(Integer.parseInt(productIdField.getText()),Integer.parseInt(productStockField.getText()));
                if(isValid==false)
                    JOptionPane.showMessageDialog(this, "Não existe produto com esse ID.");
                else{
                    
                    JOptionPane.showMessageDialog(this, "Estoque atualizado.");
                }
            } catch (SQLException ex) {
                Logger.getLogger(putProductMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }
        
    }//GEN-LAST:event_productStockBttMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        labelName.setVisible(false);
        labelStock.setVisible(false);
        productNameField.setVisible(false);
        productNameBtt.setVisible(false);
        productStockField.setVisible(false);
        productStockBtt.setVisible(false);
    }//GEN-LAST:event_formWindowOpened

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentHidden

    private void backBttMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBttMouseClicked
        this.dispose();
    }//GEN-LAST:event_backBttMouseClicked

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
            java.util.logging.Logger.getLogger(putProductMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(putProductMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(putProductMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(putProductMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new putProductMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelStock;
    private javax.swing.JButton productIdBtt;
    private javax.swing.JTextField productIdField;
    private javax.swing.JButton productNameBtt;
    private javax.swing.JTextField productNameField;
    private javax.swing.JButton productStockBtt;
    private javax.swing.JTextField productStockField;
    // End of variables declaration//GEN-END:variables
}
