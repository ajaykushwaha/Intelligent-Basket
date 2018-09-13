
package medical_store_;
import java.sql.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class New_staff extends javax.swing.JFrame {

    
        
        public Statement stmt;
        public ResultSet rs;
        public Connection con;
        public New_staff() {
        try{  
            Class.forName("com.mysql.jdbc.Driver"); 
            }
        catch(Exception e){ System.out.println(e);}  

        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        st_first_name = new javax.swing.JLabel();
        txt_first_name = new javax.swing.JTextField();
        st_last_name = new javax.swing.JLabel();
        txt_last_name = new javax.swing.JTextField();
        st_password = new javax.swing.JLabel();
        txt_adhar = new javax.swing.JTextField();
        st_mob = new javax.swing.JLabel();
        txt_mob = new javax.swing.JTextField();
        st_adhaar = new javax.swing.JLabel();
        st_con_password = new javax.swing.JLabel();
        admin_rights = new javax.swing.JCheckBox();
        st_submit = new javax.swing.JButton();
        txt_password = new javax.swing.JPasswordField();
        txt_conf_password = new javax.swing.JPasswordField();
        first_name_valid = new javax.swing.JLabel();
        mob_no_valid = new javax.swing.JLabel();
        aadhar_valid = new javax.swing.JLabel();
        last_name_valid = new javax.swing.JLabel();
        pass_conf_valid = new javax.swing.JLabel();
        pass_valid = new javax.swing.JLabel();
        staff_id_valid = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Register Staff");

        st_first_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        st_first_name.setText("First Name");
        st_first_name.setToolTipText("");

        txt_first_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_first_name.setToolTipText("");
        txt_first_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_first_nameActionPerformed(evt);
            }
        });

        st_last_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        st_last_name.setText("Last Name");
        st_last_name.setToolTipText("");

        txt_last_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_last_name.setToolTipText("");
        txt_last_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_last_nameActionPerformed(evt);
            }
        });

        st_password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        st_password.setText("Password");
        st_password.setToolTipText("");

        txt_adhar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_adhar.setToolTipText("");
        txt_adhar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_adharActionPerformed(evt);
            }
        });

        st_mob.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        st_mob.setText("Mobile No.");
        st_mob.setToolTipText("");

        txt_mob.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_mob.setToolTipText("");
        txt_mob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_mobActionPerformed(evt);
            }
        });

        st_adhaar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        st_adhaar.setText("Aadhar No.");
        st_adhaar.setToolTipText("");

        st_con_password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        st_con_password.setText("Confirm Password");
        st_con_password.setToolTipText("");

        admin_rights.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        admin_rights.setText("Admin rights");
        admin_rights.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin_rightsActionPerformed(evt);
            }
        });

        st_submit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        st_submit.setText("Submit");
        st_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                st_submitActionPerformed(evt);
            }
        });

        txt_password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_conf_password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        first_name_valid.setForeground(new java.awt.Color(255, 0, 0));
        first_name_valid.setText("First name cannot be blank.");

        mob_no_valid.setForeground(new java.awt.Color(255, 0, 0));
        mob_no_valid.setText("Mobile no. cannot be blank.");

        aadhar_valid.setForeground(new java.awt.Color(255, 0, 0));
        aadhar_valid.setText("Adhar No. cannot be blank.");

        last_name_valid.setForeground(new java.awt.Color(255, 0, 0));
        last_name_valid.setText("Last  name cannot be blank.");

        pass_conf_valid.setForeground(new java.awt.Color(255, 0, 0));
        pass_conf_valid.setText("Password do no match.");

        pass_valid.setForeground(new java.awt.Color(255, 0, 0));
        pass_valid.setText("Password cannot be blank.");

        staff_id_valid.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        staff_id_valid.setForeground(new java.awt.Color(0, 204, 0));
        staff_id_valid.setText("STAFF ID: CS50 ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(st_last_name, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(st_mob, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(st_con_password, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(st_password, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(st_adhaar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(admin_rights, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_adhar)
                            .addComponent(txt_conf_password)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pass_conf_valid, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(last_name_valid, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pass_valid, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(aadhar_valid, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mob_no_valid, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txt_password)
                            .addComponent(txt_last_name)
                            .addComponent(txt_mob)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(st_first_name, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(first_name_valid, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_first_name, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(st_submit, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(staff_id_valid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(st_first_name, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_first_name, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(first_name_valid, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_last_name, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(st_last_name, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(last_name_valid, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(st_mob, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_mob, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(mob_no_valid, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_adhar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(st_adhaar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aadhar_valid, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(st_password, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pass_valid, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(st_con_password, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_conf_password, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(pass_conf_valid, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(st_submit, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(admin_rights))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(staff_id_valid, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        first_name_valid.setVisible(false);
        mob_no_valid.setVisible(false);
        aadhar_valid.setVisible(false);
        last_name_valid.setVisible(false);
        pass_conf_valid.setVisible(false);
        pass_valid.setVisible(false);
        staff_id_valid.setVisible(false);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_first_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_first_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_first_nameActionPerformed

    private void txt_last_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_last_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_last_nameActionPerformed
    
    private int TextValidation(){
        
        first_name_valid.setVisible(false);
        last_name_valid.setVisible(false);
        mob_no_valid.setVisible(false);
        pass_conf_valid.setVisible(false);
        staff_id_valid.setVisible(false);
        pass_valid.setVisible(false);
        aadhar_valid.setVisible(false);
        
        String name1 =  txt_first_name.getText();
        if(name1 == null || name1.isEmpty()) {
        first_name_valid.setVisible(true);
        return 0;
        }

        String name2 =  txt_last_name.getText();
        if(name2 == null || name2.isEmpty()) {
        last_name_valid.setVisible(true);
        return 0;
        }
        
        String phn =  txt_mob.getText();
        if(phn == null || phn.isEmpty()) {
        mob_no_valid.setVisible(true);
        mob_no_valid.setText("Mobile no. cannot be blank.");
        return 0;
        }
        else if(phn.length()!=10)
        {
            mob_no_valid.setVisible(true);
            mob_no_valid.setText("Enter a valid Mobile No.");
            return 0;
        }
       
        try  
       {  
         long phn_no = Long.parseLong(phn);  
       }  
       catch(NumberFormatException nfe)  
       {  
         mob_no_valid.setVisible(true);
         mob_no_valid.setText("Enter a valid Mobile No.");
         return 0;
       }
       
        String aadhar =  txt_adhar.getText();
        if(aadhar == null || aadhar.isEmpty()) {
        aadhar_valid.setVisible(true);
        aadhar_valid.setText("Adhaar no. cannot be blank.");
        return 0;
        }
        else if(aadhar.length()!=12)
        {
            aadhar_valid.setVisible(true);
            aadhar_valid.setText("Enter a valid Aadhar No.");
            return 0;
        }
       
        try  
       {  
         long phn_no = Long.parseLong(aadhar);  
       }  
       catch(NumberFormatException nfe)  
       {  
         aadhar_valid.setVisible(true);
         aadhar_valid.setText("Enter a valid Aadhar No.");
         return 0;
       }
        
        
       String pass_var1= new String(txt_password.getPassword());
        if(pass_var1 == null || pass_var1.isEmpty()) {
        pass_valid.setVisible(true);
        return 0;
        }
        
        String pass_var2= new String(txt_conf_password.getPassword());
        if(pass_var2 == null || pass_var2.isEmpty()) {
        pass_conf_valid.setVisible(true);
        return 0;
        }
        else if(!pass_var1.equals(pass_var2))
        {
        pass_conf_valid.setVisible(true);
        return 0;
        }
        
        return 1;
    
        }
    
    private void txt_adharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_adharActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_adharActionPerformed

    private void txt_mobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_mobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_mobActionPerformed

    private void admin_rightsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admin_rightsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_admin_rightsActionPerformed

    private void st_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_st_submitActionPerformed
        if(TextValidation()==1)
        {
            String name1  =  txt_first_name.getText();
            String name =  txt_last_name.getText();
            String phn_no = txt_mob.getText();
            String adhar  = txt_adhar.getText();
            String pass_var1= new String(txt_password.getPassword());
            boolean check_admin = admin_rights.isSelected();
            String admin;
            String id_full;
            if(check_admin==true)
            {
                admin = "TRUE";
            }
            else
            {
                admin = "FALSE";
            }
            
            int id = 0;
            int exist=0;
            String ad_exist_name = "";
            txt_first_name.setText("");
            txt_last_name.setText("");
            txt_mob.setText("");
            txt_password .setText("");
            txt_conf_password .setText("");
            txt_adhar.setText("");;
            admin_rights.setSelected(false);
            
            
            
            try{
                con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/medical_store","root","root");
                stmt=con.createStatement();
                
                rs = stmt.executeQuery("select Staff_id from staff where Adhar_no = "+adhar+";");  
                
                while(rs.next())  
                {
                    ad_exist_name = rs.getString("Staff_id");
                    exist++;
                }
                
                staff_id_valid.setVisible(true);
                if(exist>0)
                {
                    aadhar_valid.setVisible(true);
                    aadhar_valid.setText("Aadhar No. is already registered For staff id: "+ad_exist_name);
                }
                else
                {
                rs = stmt.executeQuery("select count(staff_id)+1 as id from staff;");
                while(rs.next())
                id = Integer.parseInt(rs.getString("id"));
                id_full = name1.substring(0,1).toUpperCase()+ name.substring(0,1).toUpperCase()+id;
                staff_id_valid.setText("Staff id :"+id_full+"");
                stmt.executeUpdate("INSERT INTO Staff VALUES('"+id_full+"','"+name1+ " "+name+"',"+phn_no+",'"+pass_var1+"',"+adhar+","+admin+");");
                }
                
                con.close();
            }catch(Exception e){ System.out.println(e);}

        }
    }//GEN-LAST:event_st_submitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new New_staff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aadhar_valid;
    private javax.swing.JCheckBox admin_rights;
    private javax.swing.JLabel first_name_valid;
    private javax.swing.JLabel last_name_valid;
    private javax.swing.JLabel mob_no_valid;
    private javax.swing.JLabel pass_conf_valid;
    private javax.swing.JLabel pass_valid;
    private javax.swing.JLabel st_adhaar;
    private javax.swing.JLabel st_con_password;
    private javax.swing.JLabel st_first_name;
    private javax.swing.JLabel st_last_name;
    private javax.swing.JLabel st_mob;
    private javax.swing.JLabel st_password;
    private javax.swing.JButton st_submit;
    private javax.swing.JLabel staff_id_valid;
    private javax.swing.JTextField txt_adhar;
    private javax.swing.JPasswordField txt_conf_password;
    private javax.swing.JTextField txt_first_name;
    private javax.swing.JTextField txt_last_name;
    private javax.swing.JTextField txt_mob;
    private javax.swing.JPasswordField txt_password;
    // End of variables declaration//GEN-END:variables
}
