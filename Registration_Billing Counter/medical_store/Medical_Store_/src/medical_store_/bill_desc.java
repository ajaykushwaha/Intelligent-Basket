package medical_store_;
import java.sql.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.*;
import java.util.Date;
import java.time.*;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;


public class bill_desc extends javax.swing.JFrame {

     public Statement stmt;
    public ResultSet rs,rs2,rs3;
    public Connection con;
    public String user_id;
    DefaultTableModel bill_model;
    String total_price;
    
    public bill_desc() 
    {
           try{  
            Class.forName("com.mysql.jdbc.Driver");    
            }
        catch(Exception e){ System.out.println(e);}  
        initComponents();
        
        bill_model=(DefaultTableModel)tblbill.getModel();
        AutoCompleteDecorator.decorate(c_name_combo);
        AutoCompleteDecorator.decorate(bill_med_name);
        total_price = bill_total_price.getText();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        st_first_name = new javax.swing.JLabel();
        st_first_name1 = new javax.swing.JLabel();
        st_first_name2 = new javax.swing.JLabel();
        bill_dis_label = new javax.swing.JLabel();
        bill_dis = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        st_first_name4 = new javax.swing.JLabel();
        bill_med_name = new javax.swing.JComboBox<>();
        st_first_name5 = new javax.swing.JLabel();
        bill_total_price = new javax.swing.JLabel();
        bill_quantity = new javax.swing.JTextField();
        bill_type_combo = new javax.swing.JComboBox<>();
        st_first_name7 = new javax.swing.JLabel();
        bill_expd_combo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblbill = new javax.swing.JTable();
        bill_add = new javax.swing.JButton();
        bill_delete = new javax.swing.JButton();
        bill_make = new javax.swing.JButton();
        bill_cancel = new javax.swing.JButton();
        bill_date = new javax.swing.JFormattedTextField();
        bill_doc_name = new javax.swing.JTextField();
        c_name_combo = new javax.swing.JComboBox<>();
        bill_med_valid = new javax.swing.JLabel();
        st_first_name8 = new javax.swing.JLabel();
        st_first_name9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Make A bill");
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        st_first_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        st_first_name.setText("Customer Name :");
        st_first_name.setToolTipText("");

        st_first_name1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        st_first_name1.setText("Medicine Name :");
        st_first_name1.setToolTipText("");

        st_first_name2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        st_first_name2.setText("Doctor Name :");
        st_first_name2.setToolTipText("");

        bill_dis_label.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bill_dis_label.setText("Discount(%) :");
        bill_dis_label.setToolTipText("");

        bill_dis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bill_dis.setToolTipText("");
        bill_dis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bill_disActionPerformed(evt);
            }
        });

        st_first_name4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        st_first_name4.setText("Bill Date :");
        st_first_name4.setToolTipText("");

        bill_med_name.setEditable(true);
        bill_med_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bill_med_name.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                bill_med_nameItemStateChanged(evt);
            }
        });
        bill_med_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bill_med_nameActionPerformed(evt);
            }
        });

        st_first_name5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        st_first_name5.setText("Type :");
        st_first_name5.setToolTipText("");

        bill_total_price.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        bill_total_price.setText("0");
        bill_total_price.setToolTipText("");

        bill_quantity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bill_quantity.setToolTipText("");
        bill_quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bill_quantityActionPerformed(evt);
            }
        });

        bill_type_combo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bill_type_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bill_type_comboActionPerformed(evt);
            }
        });

        st_first_name7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        st_first_name7.setText("Expiry Date :");
        st_first_name7.setToolTipText("");

        bill_expd_combo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bill_expd_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bill_expd_comboActionPerformed(evt);
            }
        });

        tblbill.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblbill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medcine Name", "Quantity", "Expiry Date", "Type", "Max. retail Price", "Discounted Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblbill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblbillMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblbill);

        bill_add.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bill_add.setText("Add");
        bill_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bill_addActionPerformed(evt);
            }
        });

        bill_delete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bill_delete.setText("Delete");
        bill_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bill_deleteActionPerformed(evt);
            }
        });

        bill_make.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bill_make.setText("Make A Bill");
        bill_make.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bill_makeActionPerformed(evt);
            }
        });

        bill_cancel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bill_cancel.setText("Cancel");
        bill_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bill_cancelActionPerformed(evt);
            }
        });

        bill_date.setEditable(false);
        try {
            bill_date.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        bill_date.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bill_date.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bill_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bill_dateActionPerformed(evt);
            }
        });

        bill_doc_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bill_doc_name.setToolTipText("");
        bill_doc_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bill_doc_nameActionPerformed(evt);
            }
        });

        c_name_combo.setEditable(true);
        c_name_combo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        c_name_combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                c_name_comboItemStateChanged(evt);
            }
        });
        c_name_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_name_comboActionPerformed(evt);
            }
        });

        bill_med_valid.setForeground(new java.awt.Color(255, 51, 0));

        st_first_name8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        st_first_name8.setText("Quantity :");
        st_first_name8.setToolTipText("");

        st_first_name9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        st_first_name9.setText("Total Price :");
        st_first_name9.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1362, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(697, 697, 697)
                        .addComponent(st_first_name9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bill_total_price, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bill_make, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(bill_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(st_first_name4)
                                .addGap(4, 4, 4)
                                .addComponent(bill_date, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(st_first_name2)
                                .addGap(18, 18, 18)
                                .addComponent(bill_doc_name, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bill_dis_label)
                                .addGap(4, 4, 4)
                                .addComponent(bill_dis, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(st_first_name)
                                .addGap(4, 4, 4)
                                .addComponent(c_name_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(st_first_name1)
                                        .addGap(18, 18, 18)
                                        .addComponent(bill_med_name, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(st_first_name8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bill_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(bill_add)
                                        .addGap(18, 18, 18)
                                        .addComponent(bill_delete)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(st_first_name7)
                                        .addGap(4, 4, 4)
                                        .addComponent(bill_expd_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(st_first_name5))
                                    .addComponent(bill_med_valid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bill_type_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1342, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(st_first_name4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(st_first_name2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bill_dis_label, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bill_date, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bill_doc_name, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bill_dis, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(st_first_name, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(c_name_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(st_first_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(st_first_name7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(st_first_name5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bill_med_name, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(bill_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(st_first_name8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(bill_expd_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bill_type_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bill_add)
                        .addComponent(bill_delete))
                    .addComponent(bill_med_valid, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bill_total_price, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(st_first_name9, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bill_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bill_make, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2))
        );

        bill_med_valid.setVisible(false);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bill_disActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bill_disActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bill_disActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
              try{
            con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/medical_store","root","root");  
            stmt=con.createStatement();
            rs = stmt.executeQuery("select Name from Customer;");  
            while(rs.next())  
                c_name_combo.addItem(rs.getString(1));
            con.close();
        }catch(Exception e){ System.out.println(e);}  

           
    }//GEN-LAST:event_formWindowGainedFocus

    private void bill_med_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bill_med_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bill_med_nameActionPerformed

    private void bill_quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bill_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bill_quantityActionPerformed

    private void bill_type_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bill_type_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bill_type_comboActionPerformed

    private void bill_expd_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bill_expd_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bill_expd_comboActionPerformed

    private int bill_product_add_validation()
    {
        bill_med_valid.setVisible(false);
        try{
            con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/medical_store","root","root");  
            stmt=con.createStatement();
            String med_selected = bill_med_name.getSelectedItem().toString();
            rs = stmt.executeQuery("select count(distinct drug_name) as present from medicine_list where drug_name ='"+med_selected+"';");  
            int present=0;
            while(rs.next())  
            {present = Integer.parseInt(rs.getString(1));}
            con.close();
            if(present<1)
            {   bill_med_valid.setVisible(true);
                bill_med_valid.setText("This medicine is not available in inventory.");
                return 0;
            }
        }catch(Exception e){ System.out.println(e);}  
         
        String quantity =  bill_quantity.getText();
        if(quantity == null || quantity.isEmpty()) {
        bill_med_valid.setVisible(true);
        bill_med_valid.setText("Quantity cannot be blank.");
        return 0;
        }
        
        try  
       {  
         int quantity_dummy = Integer.parseInt(quantity); 
         if(quantity_dummy<=0)
         {
             bill_med_valid.setVisible(true);
             bill_med_valid.setText("Quantity cannot be less than Zero or Equal to Zero.");
             return 0;
         }
       }  
       catch(NumberFormatException nfe)  
       {  
         bill_med_valid.setVisible(true);
         bill_med_valid.setText("Enter a valid Quantity.");
         return 0;
       }
        
        if(bill_dis.isEnabled())
        {
            String discount =  bill_dis.getText();
            if(discount == null || discount.isEmpty()) {
            bill_med_valid.setVisible(true);
            bill_med_valid.setText("Discount cannot be blank.");
            return 0;
            }
        }
        return 1;
    }
    
    private void bill_add()
    {
        if(bill_product_add_validation()==1)
        {
        String med_selected = bill_med_name.getSelectedItem().toString();
        String quantity =  bill_quantity.getText();
        String expd_selected = bill_expd_combo.getSelectedItem().toString();
        String type_selected = bill_type_combo.getSelectedItem().toString();
        String Price="";
        try{
            con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/medical_store","root","root");  
            stmt=con.createStatement();
            rs = stmt.executeQuery("select Price,Quantity from medicine_list where Drug_name = '"+med_selected+"' and expd ='"+expd_selected+"' and Medicine_form='"+type_selected+"';");  
            while(rs.next())  
            {
                Price = rs.getString(1);
                if(Integer.parseInt(rs.getString(2))<1)
                {
                    bill_med_valid.setVisible(true);
                    bill_med_valid.setText("The Given Medicine is out of stock.");
                    return;
                }
                else if(Integer.parseInt(rs.getString(2))<Integer.parseInt(quantity))
                {
                    bill_med_valid.setVisible(true);
                    bill_med_valid.setText("The Maximum Availability for this item is : "+rs.getString(2));
                    return;
                }
            }
            con.close();
            
        }catch(Exception e){ System.out.println(e);}  
        
        float discounted_price=0;
        float price_int = Integer.parseInt(Price);
        if(bill_dis.isEnabled())
        {
            
            float discount = Integer.parseInt(bill_dis.getText());
            discounted_price = price_int-price_int*(discount/100);
        }
        else
        {
            discounted_price=price_int;
        }
        
        bill_model.insertRow(bill_model.getRowCount(), new Object[]{med_selected,quantity,expd_selected,type_selected,(int)price_int,(int)discounted_price});
        
        bill_med_name.removeItem(med_selected);
        
        total_price = String.valueOf(Integer.parseInt(total_price)+(int)discounted_price*Integer.parseInt(quantity));
        bill_total_price.setText(total_price);
        }
    }
    
    private void bill_delete()
    {
    if(tblbill.getSelectedRow()!=-1){
            String drug_name = String.valueOf(bill_model.getValueAt(tblbill.getSelectedRow(), 0));
            String selling_price = String.valueOf(bill_model.getValueAt(tblbill.getSelectedRow(), 5));
            String quantity = String.valueOf(bill_model.getValueAt(tblbill.getSelectedRow(), 1));
            
                bill_model.removeRow(tblbill.getSelectedRow());
            bill_med_name.addItem(drug_name);
            
            total_price = String.valueOf(Integer.parseInt(total_price)-Integer.parseInt(selling_price)*Integer.parseInt(quantity));
            bill_total_price.setText(total_price);
        }
    }
    
    private int bill_make_validation()
    {
        bill_med_valid.setVisible(false);
        String c_name =  c_name_combo.getSelectedItem().toString();
        if(c_name == null || c_name.isEmpty()) {
        bill_med_valid.setVisible(true);
        bill_med_valid.setText("Customer Name cannot be blank.");
        return 0;
        }
        
        if(bill_model.getRowCount()==0)
        {
            bill_med_valid.setVisible(true);
            bill_med_valid.setText("Please enter medicine/s.");
        }
        return 1;
    }
    
    private void bill_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bill_addActionPerformed
       bill_add();
    }//GEN-LAST:event_bill_addActionPerformed

    private void bill_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bill_deleteActionPerformed
         bill_delete();
    }//GEN-LAST:event_bill_deleteActionPerformed

    private void c_name_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_name_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_name_comboActionPerformed

    private void bill_doc_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bill_doc_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bill_doc_nameActionPerformed

    private void bill_med_nameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_bill_med_nameItemStateChanged
        try{
            con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/medical_store","root","root");  
            stmt=con.createStatement();
           
            String med_selected = bill_med_name.getSelectedItem().toString();
            rs3 = stmt.executeQuery("select Distinct Expd from Active_medicine where Drug_name = '"+med_selected+"';"); 
            bill_expd_combo.removeAllItems();
            while(rs3.next())  
                bill_expd_combo.addItem(rs3.getString(1));
            
            rs3 = stmt.executeQuery("select Distinct Medicine_form from Active_medicine where Drug_name = '"+med_selected+"';"); 
            bill_type_combo.removeAllItems();
            while(rs3.next())  
                bill_type_combo.addItem(rs3.getString(1));

              con.close();
        }catch(Exception e){ System.out.println(e);}
    }//GEN-LAST:event_bill_med_nameItemStateChanged

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

            try{
            con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/medical_store","root","root");  
            stmt=con.createStatement();
             rs2 = stmt.executeQuery("select Distinct Drug_name from Active_medicine order by Drug_name;");  
            while(rs2.next())  
                bill_med_name.addItem(rs2.getString(1));
            con.close();
        }catch(Exception e){ System.out.println(e);}  
            
            
           Date today = new Date();
           SimpleDateFormat dmyFormat = new SimpleDateFormat("dd/MM/yyyy");
           bill_date.setText(dmyFormat.format(today));
    }//GEN-LAST:event_formWindowOpened

    private void c_name_comboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_c_name_comboItemStateChanged
        bill_dis.setEnabled(true);
        bill_dis_label.setEnabled(true);
        try{
            con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/medical_store","root","root");  
            stmt=con.createStatement();
            String c_name_selected = c_name_combo.getSelectedItem().toString();
            rs2 = stmt.executeQuery("select count(distinct name) as present from customer where name ='"+c_name_selected+"';");  
            int present=0;
            while(rs2.next())  
                present = Integer.parseInt(rs2.getString(1));
            con.close();
            if(present<1)
            {
                bill_dis.setEnabled(false);
                bill_dis_label.setEnabled(false);
            }
                
                
        }catch(Exception e){ System.out.println(e);}
    }//GEN-LAST:event_c_name_comboItemStateChanged

    private void tblbillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblbillMouseClicked
        
    }//GEN-LAST:event_tblbillMouseClicked

    private void bill_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bill_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bill_dateActionPerformed

    private void bill_makeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bill_makeActionPerformed
       
        String b_id="";
        String date = bill_date.getText();
        
        if(bill_make_validation()==1)
        {
         try{
            con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/medical_store","root","root"); 
            stmt=con.createStatement();
            rs = stmt.executeQuery("select max(b_id)+1 as bill_id from bill;");  
            while(rs.next())  
                    b_id=rs.getString(1);
            con.close();
            }catch(Exception e){ System.out.println(e);}  
         
         
         
         try{
         Date date_java=new SimpleDateFormat("dd/MM/yyyy").parse(date);
         SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd");
         date = dmyFormat.format(date_java);
         }
         catch(Exception e){System.out.println(e);}
         
         
         String c_id ="";
         if(bill_dis.isEnabled())
         {
             try{
            con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/medical_store","root","root"); 
            stmt=con.createStatement();
            String customer_name =c_name_combo.getSelectedItem().toString();
            rs = stmt.executeQuery("select Customer_id from customer where name ='"+customer_name+"';");  
            while(rs.next())  
                    c_id=rs.getString(1);
            con.close();
            }catch(Exception e){ System.out.println(e);} 
         }
         
         String c_name =c_name_combo.getSelectedItem().toString();
      
        while(bill_model.getRowCount()!=0)
        {   String product_id="",quantity,price_p_piece,s_price,doc_name;
            try{
            con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/medical_store","root","root"); 
            stmt=con.createStatement();
            String drug_name = String.valueOf(bill_model.getValueAt(0, 0));
            String expd = String.valueOf(bill_model.getValueAt(0, 2));
            String type = String.valueOf(bill_model.getValueAt(0, 3));
            
            rs = stmt.executeQuery("select product_id from medicine_list where Drug_name ='"+drug_name+"' And Expd ='"+expd+"' And Medicine_form='"+type+"';");  
            while(rs.next())  
                    product_id=rs.getString(1);
            
            quantity = bill_quantity.getText();
            price_p_piece = String.valueOf(bill_model.getValueAt(0, 4));
            s_price = String.valueOf(bill_model.getValueAt(0, 5));
            doc_name=bill_doc_name.getText();
            stmt.executeUpdate("INSERT INTO Bill VALUES("+b_id+",'"+date+"','"+c_id+"','"+c_name+"',"+product_id+","+quantity+","+price_p_piece+",'"+doc_name+"',"+s_price+");");
            bill_model.removeRow(0);
            con.close();
            }catch(Exception e){ System.out.println(e);}
        } 
        }
        setVisible(false); 
                    Bill dashboard = new Bill(b_id,date);
                    dashboard.setVisible(true);
        
    }//GEN-LAST:event_bill_makeActionPerformed

    private void bill_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bill_cancelActionPerformed
       dispose();
    }//GEN-LAST:event_bill_cancelActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bill_desc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bill_add;
    private javax.swing.JButton bill_cancel;
    private javax.swing.JFormattedTextField bill_date;
    private javax.swing.JButton bill_delete;
    private javax.swing.JTextField bill_dis;
    private javax.swing.JLabel bill_dis_label;
    private javax.swing.JTextField bill_doc_name;
    private javax.swing.JComboBox<String> bill_expd_combo;
    private javax.swing.JButton bill_make;
    private javax.swing.JComboBox<String> bill_med_name;
    private javax.swing.JLabel bill_med_valid;
    private javax.swing.JTextField bill_quantity;
    private javax.swing.JLabel bill_total_price;
    private javax.swing.JComboBox<String> bill_type_combo;
    private javax.swing.JComboBox<String> c_name_combo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel st_first_name;
    private javax.swing.JLabel st_first_name1;
    private javax.swing.JLabel st_first_name2;
    private javax.swing.JLabel st_first_name4;
    private javax.swing.JLabel st_first_name5;
    private javax.swing.JLabel st_first_name7;
    private javax.swing.JLabel st_first_name8;
    private javax.swing.JLabel st_first_name9;
    private javax.swing.JTable tblbill;
    // End of variables declaration//GEN-END:variables
}
