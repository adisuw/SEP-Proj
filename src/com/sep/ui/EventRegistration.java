/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sep.ui;

import com.sep.Client;
import com.sep.Event;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ema
 */
public class EventRegistration extends javax.swing.JFrame {

    /**
     * Creates new form EventRegistration
     */
    private Formatter output;
    private FileWriter write;

    public void openFile() {
        try {
            write = new FileWriter("events.txt", true); // open the file
            output = new Formatter(write);
        } // end try
        catch (SecurityException securityException) {
            JOptionPane.showMessageDialog(null, "You do not have write access to this file.");
            System.exit(1); // terminate the program
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Exception caught: " + ex);
        } catch (IOException ex) {
            Logger.getLogger(RegisterClient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<String> preference() {
        List<String> pre = new ArrayList<>();
        if (chkDecore.isSelected()) {
            pre.add(chkDecore.getText());
        }
        if (chkParties.isSelected()) {
            pre.add(chkParties.getText());
        }
        if (chkPhotos.isSelected()) {
            pre.add(chkPhotos.getText());
        }
        if (chkBreakfast.isSelected()) {
            pre.add(chkBreakfast.getText());
        }
        if (chkSoftDrink.isSelected()) {
            pre.add(chkSoftDrink.getText());
        }
        return pre;
    }

    public boolean isPreferd() {
        boolean selected;
        if (chkDecore.isSelected() || chkParties.isSelected() || chkPhotos.isSelected() 
                || chkBreakfast.isSelected() || chkSoftDrink.isSelected()) {
            selected = true;
        } else {
            selected = false;
        }
        return selected;
    }

    public void addRecords() {

        Event event = new Event();
        Client cl = new Client(txtClName.getText(), Integer.valueOf(txtRecordNum.getText()));
        try {
            event.setClient(cl);
            event.setEventType(txtEventType.getText());
            event.setFrom(txtFrom.getText());
            event.setTo(txtTo.getText());
            event.setAtendee(Integer.valueOf(txtAtendee.getText()));
            if (isPreferd()) {
                event.setPreference((ArrayList<String>) preference());
            } else {
                JOptionPane.showMessageDialog(null, "Please select a reference!");
            }
            event.setBudget(Double.valueOf(txtExpectedBudget.getText()));
            String end = "end";
            output.format("%s %d %s %s %s %d %s %s %.2f\n", cl.getFirstName(), cl.getId(), event.getEventType(),
                    event.getFrom(), event.getTo(), event.getAtendee(), event.getPreference(), end, event.getBudget());
            //JOptionPane.showMessageDialog(null, "Your start date is: " + event.getFrom());
        } catch (FormatterClosedException formatterClosedException) {
            JOptionPane.showMessageDialog(null, "Error writing to file.");
        } catch (NoSuchElementException elementException) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please try again.");
        }
    }

    public void closeFile() {
        if (output != null) {
            output.close();
        }
    }

    public EventRegistration() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtRecordNum = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtClName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEventType = new javax.swing.JTextField();
        txtFrom = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtAtendee = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        chkDecore = new javax.swing.JCheckBox();
        chkParties = new javax.swing.JCheckBox();
        chkPhotos = new javax.swing.JCheckBox();
        chkBreakfast = new javax.swing.JCheckBox();
        chkSoftDrink = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        txtExpectedBudget = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Event Registration");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("Event Request Form");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(223, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Record Number:");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Client Name:");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setText("Event Type:");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setText("From:");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setText("To:");

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setText("Expected No. of Atendee:");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Preference", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel2.setName("Preference"); // NOI18N

        chkDecore.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        chkDecore.setText("Decorations");

        chkParties.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        chkParties.setText("Parties");

        chkPhotos.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        chkPhotos.setText("Photos/Filming");

        chkBreakfast.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        chkBreakfast.setText("Food");
        chkBreakfast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkBreakfastActionPerformed(evt);
            }
        });

        chkSoftDrink.setText("Drinks");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(chkPhotos)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkDecore)
                            .addComponent(chkParties))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(chkSoftDrink, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(chkBreakfast, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(169, 169, 169))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkDecore)
                    .addComponent(chkBreakfast))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkSoftDrink)
                    .addComponent(chkParties))
                .addGap(18, 18, 18)
                .addComponent(chkPhotos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel8.setText("Expected Budget");

        txtExpectedBudget.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtExpectedBudgetFocusGained(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton1.setText("Send Request");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton2.setText("Cancel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtRecordNum)
                            .addComponent(txtEventType)
                            .addComponent(txtClName)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTo, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
                            .addComponent(txtAtendee, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(43, 43, 43)
                                .addComponent(jButton2))
                            .addComponent(txtExpectedBudget, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtRecordNum, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtClName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEventType, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAtendee, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtExpectedBudget, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jLabel8.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String fn = txtClName.getText();
        String ln = txtRecordNum.getText();
        String fm = txtFrom.getText();
        String to = txtTo.getText();
        String a = txtAtendee.getText();
        String bd = txtExpectedBudget.getText();
        String event = txtEventType.getText();

        if (fn.equals("") || ln.equals("") || fm.equals("") || a.equals("") || event.equals("")
                || to.equals("") || bd.equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill the form");
        } else {
            openFile();
            addRecords();
            closeFile();
            JOptionPane.showMessageDialog(null, "Successfully Registerd!");
            clear();
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    public void clear() {
        txtClName.setText("");
        txtRecordNum.setText("");
        txtFrom.setText("");
        txtTo.setText("");
        txtAtendee.setText("");
        txtExpectedBudget.setText("");
        txtEventType.setText("");
        chkBreakfast.setSelected(false);
        chkDecore.setSelected(false);
        chkParties.setSelected(false);
        chkPhotos.setSelected(false);
        chkSoftDrink.setSelected(false);
    }
    void setClient(String text, String text0) {
        txtClName.setText(text);
        txtClName.setEditable(false);
        txtRecordNum.setText(text0);
        txtRecordNum.setEditable(false);
    }
    private void chkBreakfastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkBreakfastActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkBreakfastActionPerformed

    private void txtExpectedBudgetFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtExpectedBudgetFocusGained

        
    }//GEN-LAST:event_txtExpectedBudgetFocusGained

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
            java.util.logging.Logger.getLogger(EventRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EventRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EventRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EventRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EventRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkBreakfast;
    private javax.swing.JCheckBox chkDecore;
    private javax.swing.JCheckBox chkParties;
    private javax.swing.JCheckBox chkPhotos;
    private javax.swing.JCheckBox chkSoftDrink;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JTextField txtAtendee;
    private javax.swing.JTextField txtClName;
    private javax.swing.JTextField txtEventType;
    private javax.swing.JTextField txtExpectedBudget;
    private javax.swing.JTextField txtFrom;
    private javax.swing.JTextField txtRecordNum;
    private javax.swing.JTextField txtTo;
    // End of variables declaration//GEN-END:variables

    
}
