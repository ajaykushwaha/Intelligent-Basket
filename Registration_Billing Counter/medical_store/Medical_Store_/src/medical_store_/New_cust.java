
package medical_store_;
import java.sql.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class New_cust extends javax.swing.JFrame {

   public Statement stmt;
   public ResultSet rs;
   public Connection con;
   
    public New_cust() {
           try{  
            Class.forName("com.mysql.jdbc.Driver");    
            }
        catch(Exception e){ System.out.println(e);}  
           
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cust_name = new javax.swing.JTextField();
        cust_submit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cust_phn_no = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cust_address = new javax.swing.JTextPane();
        jLabel4 = new javax.swing.JLabel();
        cust_name1 = new javax.swing.JTextField();
        first_name_valid = new javax.swing.JLabel();
        last_name_valid = new javax.swing.JLabel();
        phn_no_valid = new javax.swing.JLabel();
        result_valid = new javax.swing.JLabel();
        add_valid = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Register Customer");
        setResizable(false);

        cust_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cust_name.setToolTipText("");
        cust_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cust_nameActionPerformed(evt);
            }
        });

        cust_submit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cust_submit.setText("Submit");
        cust_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cust_submitActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("First Name");
        jLabel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Mobile No.");
        jLabel2.setToolTipText("");

        cust_phn_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cust_phn_no.setToolTipText("");
        cust_phn_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cust_phn_noActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Address");
        jLabel3.setToolTipText("");

        cust_address.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(cust_address);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Last Name");
        jLabel4.setToolTipText("");

        cust_name1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cust_name1.setToolTipText("");
        cust_name1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cust_name1ActionPerformed(evt);
            }
        });

        first_name_valid.setForeground(new java.awt.Color(255, 0, 0));
        first_name_valid.setText("First name cannot be blank.");

        last_name_valid.setForeground(new java.awt.Color(255, 0, 0));
        last_name_valid.setText("Last name cannot be blank.");

        phn_no_valid.setForeground(new java.awt.Color(255, 0, 0));
        phn_no_valid.setText("Phone no. cannot be blank.");

        result_valid.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        result_valid.setForeground(new java.awt.Color(0, 204, 0));
        result_valid.setText("Customer added!!!");

        add_valid.setForeground(new java.awt.Color(255, 0, 0));
        add_valid.setText("Address cannot be blank");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(46, 46, 46))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(first_name_valid, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cust_name)
                                .addComponent(cust_phn_no)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                                .addComponent(cust_name1))
                            .addComponent(last_name_valid, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(add_valid, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phn_no_valid, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(result_valid, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cust_submit, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cust_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(first_name_valid, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cust_name, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(last_name_valid, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cust_phn_no, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phn_no_valid, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(add_valid, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cust_submit, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(result_valid, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        first_name_valid.setVisible(false);
        last_name_valid.setVisible(false);
        phn_no_valid.setVisible(false);
        result_valid.setVisible(false);
        add_valid.setVisible(false);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cust_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cust_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cust_nameActionPerformed

    private void cust_phn_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cust_phn_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cust_phn_noActionPerformed
    
    private int TextValidation(){
        
        first_name_valid.setVisible(false);
        last_name_valid.setVisible(false);
        phn_no_valid.setVisible(false);
        add_valid.setVisible(false);
        result_valid.setVisible(false);
        
        String name1 =  cust_name1.getText();
        if(name1 == null || name1.isEmpty()) {
        first_name_valid.setVisible(true);
        return 0;
        }
        
        String name =  cust_name.getText();
        if(name == null || name.isEmpty()) {
        last_name_valid.setVisible(true);
        return 0;
        }
        
        String phn =  cust_phn_no.getText();
        if(phn == null || phn.isEmpty()) {
        phn_no_valid.setVisible(true);
        phn_no_valid.setText("Phone no. cannot be blank.");
        return 0;
        }
        else if(phn.length()!=10)
        {
            phn_no_valid.setVisible(true);
            phn_no_valid.setText("Enter a valid No.");
            return 0;
        }
       
        try  
       {  
         long phn_no = Long.parseLong(phn);  
       }  
       catch(NumberFormatException nfe)  
       {  
         phn_no_valid.setVisible(true);
         phn_no_valid.setText("Enter a valid No.");
         return 0;
       }
        
       String add =  cust_address.getText();
        if(add == null || add.isEmpty()) {
        add_valid.setVisible(true);
        return 0;
        }
        
        return 1;
    }

    private void cust_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cust_submitActionPerformed
        if(TextValidation()==1)
        {
            String name1 =  cust_name1.getText();
            String name =  cust_name.getText();
            long phn_no = Long.parseLong(cust_phn_no.getText());
            String address = cust_address.getText().replace('\n', ',');
            int id = 0;
            
            result_valid.setVisible(true);
            result_valid.setText("Customer "+name1+" added!!!");
            
            cust_name1.setText("");
            cust_phn_no.setText("");
            cust_name.setText("");
            cust_address .setText("");    
        
            try{
                con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/medical_store","root","root");  
                stmt=con.createStatement();
                rs = stmt.executeQuery("select count(Customer_id)+1 as id From customer;");  
                while(rs.next())  
                id = Integer.parseInt(rs.getString("id")); 

                stmt.executeUpdate("INSERT INTO Customer VALUES('"+name1.substring(0,1).toUpperCase()+ name.substring(0,1).toUpperCase()+id+"','"+name1+ " "+name+"',"+phn_no+",'"+address+"');");  
                con.close();
            }catch(Exception e){ System.out.println(e);}  
            
            
        }
    }//GEN-LAST:event_cust_submitActionPerformed

    private void cust_name1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cust_name1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cust_name1ActionPerformed

    public static void main(String args[]) {
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new New_cust().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel add_valid;
    private javax.swing.JTextPane cust_address;
    private javax.swing.JTextField cust_name;
    private javax.swing.JTextField cust_name1;
    private javax.swing.JTextField cust_phn_no;
    private javax.swing.JButton cust_submit;
    private javax.swing.JLabel first_name_valid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel last_name_valid;
    private javax.swing.JLabel phn_no_valid;
    private javax.swing.JLabel result_valid;
    // End of variables declaration//GEN-END:variables
}
