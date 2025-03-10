/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package oop;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import oop.datas.DataEventListener;
import oop.datas.DataManager;
import oop.entities.Tax;
import oop.exceptions.ErrorException;
import oop.types.DataManagerType;
import oop.types.PropertyType;

/**
 *
 * @author kucik
 */
class TaxProductsDialog extends javax.swing.JDialog {

    private ModelsManager model;
    private final DataManager<Tax> manager;
    private List<Tax> taxes;
    private JTableHeader header;
    private final Map<Integer, Function<List<Tax>, List<Tax>>> sorter;

    /**
     * Creates new form TaxProductsDialog
     */
    public TaxProductsDialog(DataManager<Tax> manager) {
        initComponents();
        this.model = new ModelsManager((DefaultTableModel) taxesTable.getModel());
        this.manager = manager;
        taxes = manager.getList();
        fillTable(taxes);
        sorter = fillSorter();
        createHeaderListener();
        manager.addListener(new DataEventListener() {
            @Override
            public void update() {
                manager.refreshData();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        taxesTable = new javax.swing.JTable();
        reloadBt = new javax.swing.JButton();
        addProductBt = new javax.swing.JButton();
        deleteProductBt = new javax.swing.JButton();
        searchProductBt = new javax.swing.JButton();
        closeBt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        taxesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tax Key", "Description", "Multiplier"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(taxesTable);

        reloadBt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        reloadBt.setText("Reload");
        reloadBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadBtActionPerformed(evt);
            }
        });

        addProductBt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addProductBt.setText("Add");
        addProductBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductBtActionPerformed(evt);
            }
        });

        deleteProductBt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        deleteProductBt.setText("Delete");
        deleteProductBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProductBtActionPerformed(evt);
            }
        });

        searchProductBt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchProductBt.setText("Search");
        searchProductBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchProductBtActionPerformed(evt);
            }
        });

        closeBt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        closeBt.setText("Close");
        closeBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addProductBt)
                        .addGap(18, 18, 18)
                        .addComponent(deleteProductBt)
                        .addGap(77, 77, 77)
                        .addComponent(searchProductBt)
                        .addGap(37, 37, 37)
                        .addComponent(reloadBt)
                        .addGap(26, 26, 26)
                        .addComponent(closeBt)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addProductBt)
                    .addComponent(deleteProductBt)
                    .addComponent(searchProductBt)
                    .addComponent(reloadBt)
                    .addComponent(closeBt))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reloadBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadBtActionPerformed
        taxes = manager.getList();
        fillTable(taxes);
    }//GEN-LAST:event_reloadBtActionPerformed

    private void addProductBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductBtActionPerformed
        try {
            String taxKey = JOptionPane.showInputDialog(null, "Add tax", "Tax Key: ", JOptionPane.QUESTION_MESSAGE);
            String regex = "[0-9]+";
            int key;
            Tax tax;
            if (taxKey != null && taxKey.matches(regex)) {
                key = Integer.parseInt(taxKey);
                tax = new Tax(key, taxKey + "%");
                manager.addEntity(tax);
                taxes.add(tax);
                fillTable(taxes);
            }
        } catch (ErrorException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_addProductBtActionPerformed

    private void deleteProductBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProductBtActionPerformed
        try {
            int selectedRow = taxesTable.getSelectedRow();
            if (selectedRow >= 0) {
                Tax tax = taxes.get(selectedRow);
                int dialogResult = JOptionPane.showConfirmDialog(null, tax.getId() + " Want to delete?");
                if (dialogResult == JOptionPane.YES_OPTION) {
                    manager.deleteEntity(tax);
                    taxes.remove(tax);
                }
                fillTable(taxes);
            } else {
                JOptionPane.showMessageDialog(null, "Product was not chosen");
            }
        } catch (ErrorException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//GEN-LAST:event_deleteProductBtActionPerformed

    private void searchProductBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchProductBtActionPerformed
        SearchDialog searchDialog = new SearchDialog(manager, DataManagerType.TAX_MANAGER, taxes);
        searchDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        searchDialog.setModal(true);
        searchDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                fillTable(taxes);
            }
        });
        searchDialog.setVisible(true);
    }//GEN-LAST:event_searchProductBtActionPerformed

    private void closeBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtActionPerformed
        this.dispose();
    }//GEN-LAST:event_closeBtActionPerformed

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
            java.util.logging.Logger.getLogger(TaxProductsDialog.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TaxProductsDialog.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TaxProductsDialog.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TaxProductsDialog.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TaxProductsDialog dialog = new TaxProductsDialog(null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addProductBt;
    private javax.swing.JButton closeBt;
    private javax.swing.JButton deleteProductBt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton reloadBt;
    private javax.swing.JButton searchProductBt;
    private javax.swing.JTable taxesTable;
    // End of variables declaration//GEN-END:variables

    private void fillTable(List<Tax> taxes) {
        DefaultTableModel m = model.getModel();
        removeTableRows(m);

        String[] utilArray;
        for (Tax tax : taxes) {
            utilArray = taxToStringArray(tax);
            m.addRow(utilArray);
        }
    }

    private String[] taxToStringArray(Tax product) {
        String[] result = new String[3];
        String id = product.getId();
        String description = product.getDescription();
        String multiplier = String.valueOf(product.getMultiplier());

        result[0] = id;
        result[1] = description;
        result[2] = multiplier;

        return result;
    }

    private void createHeaderListener() {
        header = taxesTable.getTableHeader();
        header.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point point = e.getPoint();
                int column = taxesTable.columnAtPoint(point);
                int clickCount = e.getClickCount();
                boolean doubleClick = false;
                if (clickCount >= 2) {
                    doubleClick = true;
                }
                sortListWithColumn(column, doubleClick);
            }

            private void sortListWithColumn(int column, boolean reverse) {

                taxes = sorter.getOrDefault(column, (list)
                        -> Collections.emptyList()).apply(taxes);
                if (taxes.isEmpty()) {
                    taxes = manager.getList();
                } else if (reverse) {
                    taxes = manager.reverseList(taxes);
                }
                fillTable(taxes);
            }
        });
    }

    private Map<Integer, Function<List<Tax>, List<Tax>>> fillSorter() {
        Map<Integer, Function<List<Tax>, List<Tax>>> result = new HashMap<>();

        result.put(0, (list) -> manager.sortByProperty(PropertyType.TAX_KEY, list));

        return result;
    }

    private void removeTableRows(DefaultTableModel m) {
        for (int i = m.getRowCount(); i > 0; i--) {
            m.removeRow(i - 1);
        }
    }

}
