

package medical_store_;
import java.sql.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class login_ extends javax.swing.JFrame {
    
    public Statement stmt;
    public ResultSet rs;
    public Connection con;
    public login_() {
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/medical_store","root","root");  
            stmt=con.createStatement();  
            }
        catch(Exception e){ System.out.println(e);}  
           
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        result_valid = new javax.swing.JLabel();
        Login = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Password = new javax.swing.JPasswordField();
        pass_valid = new javax.swing.JLabel();
        id_valid = new javax.swing.JLabel();
        result_valid1 = new javax.swing.JLabel();

        result_valid.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        result_valid.setForeground(new java.awt.Color(0, 204, 0));
        result_valid.setText("Customer added!!!");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);

        Login.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Login.setText("Login");
        Login.setToolTipText("");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Id");

        id.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Password");

        Password.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Password.setToolTipText("");
        Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordActionPerformed(evt);
            }
        });

        pass_valid.setForeground(new java.awt.Color(255, 0, 0));
        pass_valid.setText("Password cannot be blank.");

        id_valid.setForeground(new java.awt.Color(255, 0, 0));
        id_valid.setText("Id cannot be blank.");

        result_valid1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        result_valid1.setForeground(new java.awt.Color(255, 0, 0));
        result_valid1.setText("Wrong Credentials !!!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Password)
                    .addComponent(id, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(result_valid1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(pass_valid, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id_valid, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(id_valid)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pass_valid, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(result_valid1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        pass_valid.setVisible(false);
        id_valid.setVisible(false);
        result_valid1.setVisible(false);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private int TextValidation(){
        
        id_valid.setVisible(false);
        pass_valid.setVisible(false);
        result_valid1.setVisible(false);
        
        String id_var =  id.getText();
        if(id_var == null || id_var.isEmpty()) {
        id_valid.setVisible(true);
        return 0;
        }
        
        String pass_var= new String(Password.getPassword());
        if(pass_var == null || pass_var.isEmpty()) {
        pass_valid.setVisible(true);
        return 0;
        }
        
        return 1;
    }
    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
     if(TextValidation()==1)
       {
            String id_var =  id.getText();
            String pass_var= new String(Password.getPassword());
            int logged = 0;
            
            id.setText("");
            Password.setText("");   
        
            try{
                rs = stmt.executeQuery("Select count(Name) From staff Where Staff_id ='"+id_var+"' AND Password = '"+pass_var+"';");  
                while(rs.next())  
                    logged = Integer.parseInt(rs.getString("count(Name)"));
                
                if(logged<1)
                {
                    result_valid1.setVisible(true);
                }
                else
                {
                    setVisible(false); 
                    dispose();
                    Main_frame dashboard = new Main_frame(id_var);
                    dashboard.setVisible(true);
                }
                
                 
            }catch(Exception e){ System.out.println(e);}  
            
            
        }        // TODO add your handling code here:
    }//GEN-LAST:event_LoginActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login_().setVisible(true);
            }
        });
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Login;
    private javax.swing.JPasswordField Password;
    private javax.swing.JTextField id;
    private javax.swing.JLabel id_valid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel pass_valid;
    private javax.swing.JLabel result_valid;
    private javax.swing.JLabel result_valid1;
    // End of variables declaration//GEN-END:variables
}
