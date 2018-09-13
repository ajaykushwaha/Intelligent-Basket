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


public class order_desc extends javax.swing.JFrame {

     public Statement stmt;
    public ResultSet rs,rs2,rs3;
    public Connection con;
    public String user_id;
    DefaultTableModel order_model;
    String total_price;
    
    public order_desc() 
    {
           try{  
            Class.forName("com.mysql.jdbc.Driver");    
            }
        catch(Exception e){ System.out.println(e);}  
        initComponents();
        
        order_model=(DefaultTableModel)tblorder.getModel();
        AutoCompleteDecorator.decorate(s_name_combo);
        AutoCompleteDecorator.decorate(order_med_name);
        total_price = order_total_price.getText();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        st_first_name = new javax.swing.JLabel();
        st_first_name1 = new javax.swing.JLabel();
        st_first_name2 = new javax.swing.JLabel();
        bill_dis_label = new javax.swing.JLabel();
        orderl_dis = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        st_first_name4 = new javax.swing.JLabel();
        order_med_name = new javax.swing.JComboBox<>();
        st_first_name5 = new javax.swing.JLabel();
        order_total_price = new javax.swing.JLabel();
        order_type_combo = new javax.swing.JComboBox<>();
        st_first_name7 = new javax.swing.JLabel();
        order_expd_combo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblorder = new javax.swing.JTable();
        bill_add = new javax.swing.JButton();
        bill_delete = new javax.swing.JButton();
        register_order = new javax.swing.JButton();
        order_cancel = new javax.swing.JButton();
        order_date = new javax.swing.JFormattedTextField();
        order_agent_name = new javax.swing.JTextField();
        s_name_combo = new javax.swing.JComboBox<>();
        order_med_valid = new javax.swing.JLabel();
        st_first_name9 = new javax.swing.JLabel();
        st_first_name10 = new javax.swing.JLabel();
        orders_quantity = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Recieve an Order");
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
        st_first_name.setText("Staff Name :");
        st_first_name.setToolTipText("");

        st_first_name1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        st_first_name1.setText("Medicine Name :");
        st_first_name1.setToolTipText("");

        st_first_name2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        st_first_name2.setText("Agent Name :");
        st_first_name2.setToolTipText("");

        bill_dis_label.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bill_dis_label.setText("Discount(%) :");
        bill_dis_label.setToolTipText("");

        orderl_dis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        orderl_dis.setToolTipText("");
        orderl_dis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderl_disActionPerformed(evt);
            }
        });

        st_first_name4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        st_first_name4.setText("Order Date :");
        st_first_name4.setToolTipText("");

        order_med_name.setEditable(true);
        order_med_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        order_med_name.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                order_med_nameItemStateChanged(evt);
            }
        });
        order_med_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                order_med_nameActionPerformed(evt);
            }
        });

        st_first_name5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        st_first_name5.setText("Type :");
        st_first_name5.setToolTipText("");

        order_total_price.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        order_total_price.setText("0");
        order_total_price.setToolTipText("");

        order_type_combo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        order_type_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                order_type_comboActionPerformed(evt);
            }
        });

        st_first_name7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        st_first_name7.setText("Expiry Date :");
        st_first_name7.setToolTipText("");

        order_expd_combo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        order_expd_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                order_expd_comboActionPerformed(evt);
            }
        });

        tblorder.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblorder.setModel(new javax.swing.table.DefaultTableModel(
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
        tblorder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblorderMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblorder);

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

        register_order.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        register_order.setText("Register Order");
        register_order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                register_orderActionPerformed(evt);
            }
        });

        order_cancel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        order_cancel.setText("Cancel");
        order_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                order_cancelActionPerformed(evt);
            }
        });

        order_date.setEditable(false);
        try {
            order_date.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        order_date.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        order_date.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        order_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                order_dateActionPerformed(evt);
            }
        });

        order_agent_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        order_agent_name.setToolTipText("");
        order_agent_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                order_agent_nameActionPerformed(evt);
            }
        });

        s_name_combo.setEditable(true);
        s_name_combo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        s_name_combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                s_name_comboItemStateChanged(evt);
            }
        });
        s_name_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s_name_comboActionPerformed(evt);
            }
        });

        order_med_valid.setForeground(new java.awt.Color(255, 51, 0));

        st_first_name9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        st_first_name9.setText("Total Price :");
        st_first_name9.setToolTipText("");

        st_first_name10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        st_first_name10.setText("Quantity :");
        st_first_name10.setToolTipText("");

        orders_quantity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        orders_quantity.setToolTipText("");
        orders_quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orders_quantityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addGroup(layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(st_first_name4)
                            .addGap(4, 4, 4)
                            .addComponent(order_date, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(32, 32, 32)
                            .addComponent(st_first_name2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(order_agent_name, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(bill_dis_label)
                            .addGap(4, 4, 4)
                            .addComponent(orderl_dis, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(st_first_name)
                            .addGap(4, 4, 4)
                            .addComponent(s_name_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(bill_add)
                                    .addGap(18, 18, 18)
                                    .addComponent(bill_delete))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(st_first_name1)
                                    .addGap(18, 18, 18)
                                    .addComponent(order_med_name, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(st_first_name10)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(orders_quantity, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                    .addGap(18, 18, 18)
                                    .addComponent(st_first_name7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(order_expd_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(st_first_name5))
                                .addComponent(order_med_valid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(order_type_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18))))
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1342, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1362, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(697, 697, 697)
                        .addComponent(st_first_name9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(order_total_price, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(register_order, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(order_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(st_first_name4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bill_dis_label, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(order_agent_name, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(st_first_name2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(order_date, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(orderl_dis, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(st_first_name, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(s_name_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(order_med_name, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(st_first_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(st_first_name10, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orders_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(st_first_name7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(order_expd_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(st_first_name5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(order_type_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bill_add)
                        .addComponent(bill_delete))
                    .addComponent(order_med_valid, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(order_total_price, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(st_first_name9, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(order_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(register_order, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2))
        );

        order_med_valid.setVisible(false);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void orderl_disActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderl_disActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_orderl_disActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
              try{
            con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/medical_store","root","root");  
            stmt=con.createStatement();
            rs = stmt.executeQuery("select Name from Staff;");  
            while(rs.next())  
                s_name_combo.addItem(rs.getString(1));
            con.close();
        }catch(Exception e){ System.out.println(e);}  

           
    }//GEN-LAST:event_formWindowGainedFocus

    private void order_med_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_order_med_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_order_med_nameActionPerformed

    private void order_type_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_order_type_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_order_type_comboActionPerformed

    private void order_expd_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_order_expd_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_order_expd_comboActionPerformed

    private int order_product_add_validation()
    {
        order_med_valid.setVisible(false);
        try{
            con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/medical_store","root","root");  
            stmt=con.createStatement();
            String med_selected = order_med_name.getSelectedItem().toString();
            rs = stmt.executeQuery("select count(distinct drug_name) as present from medicine_list where drug_name ='"+med_selected+"';");  
            int present=0;
            while(rs.next())  
            {present = Integer.parseInt(rs.getString(1));}
            con.close();
            if(present<1)
            {   order_med_valid.setVisible(true);
                order_med_valid.setText("This medicine is not registered in inventory.");
                return 0;
            }
        }catch(Exception e){ System.out.println(e);}  
         
        String quantity =  orders_quantity.getText();
        if(quantity == null || quantity.isEmpty()) {
        order_med_valid.setVisible(true);
        order_med_valid.setText("Quantity cannot be blank.");
        return 0;
        }
        
        try  
       {  
         int quantity_dummy = Integer.parseInt(quantity); 
         if(quantity_dummy<=0)
         {
             order_med_valid.setVisible(true);
             order_med_valid.setText("Quantity cannot be less than Zero or Equal to Zero.");
             return 0;
         }
       }  
       catch(NumberFormatException nfe)  
       {  
         order_med_valid.setVisible(true);
         order_med_valid.setText("Enter a valid Quantity.");
         return 0;
       }
        
        
        String discount =  orderl_dis.getText();
        if(discount == null || discount.isEmpty()) {
        order_med_valid.setVisible(true);
        order_med_valid.setText("Discount cannot be blank.");
        return 0;
          
        }
        return 1;
    }
    
    private void order_add()
    {
        if(order_product_add_validation()==1)
        {
        String med_selected = order_med_name.getSelectedItem().toString();
        String quantity =  orders_quantity.getText();
        String expd_selected = order_expd_combo.getSelectedItem().toString();
        String type_selected = order_type_combo.getSelectedItem().toString();
        String Price="";
        try{
            con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/medical_store","root","root");  
            stmt=con.createStatement();
            rs = stmt.executeQuery("select Price,Quantity from medicine_list where Drug_name = '"+med_selected+"' and expd ='"+expd_selected+"' and Medicine_form='"+type_selected+"';");  
            while(rs.next())  
            {
                Price = rs.getString(1);
            }
            con.close();
            
        }catch(Exception e){ System.out.println(e);}  
        
        float discounted_price=0;
        float price_int = Integer.parseInt(Price);
            
        float discount = Integer.parseInt(orderl_dis.getText());
        discounted_price = price_int-price_int*(discount/100);
        
        order_model.insertRow(order_model.getRowCount(), new Object[]{med_selected,quantity,expd_selected,type_selected,(int)price_int,(int)discounted_price});
        order_med_name.removeItem(med_selected);
        total_price = String.valueOf(Integer.parseInt(total_price)+(int)discounted_price*Integer.parseInt(quantity));
        order_total_price.setText(total_price);
        }
    }
    
    private void order_delete()
    {
    if(tblorder.getSelectedRow()!=-1){
            String drug_name = String.valueOf(order_model.getValueAt(tblorder.getSelectedRow(), 0));
            String selling_price = String.valueOf(order_model.getValueAt(tblorder.getSelectedRow(), 5));
            String quantity = String.valueOf(order_model.getValueAt(tblorder.getSelectedRow(), 1));
            
            order_model.removeRow(tblorder.getSelectedRow());
            order_med_name.addItem(drug_name);
            
            total_price = String.valueOf(Integer.parseInt(total_price)-Integer.parseInt(selling_price)*Integer.parseInt(quantity));
            order_total_price.setText(total_price);
        }
    }
    
    private int order_make_validation()
    {
        order_med_valid.setVisible(false);
        String s_name =  s_name_combo.getSelectedItem().toString();
        if(s_name == null || s_name.isEmpty()) {
        order_med_valid.setVisible(true);
        order_med_valid.setText("Staff Name cannot be blank.");
        return 0;
        }
        
        try{
            con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/medical_store","root","root");  
            stmt=con.createStatement();
            rs = stmt.executeQuery("select count(distinct Name) as present from Staff where Name ='"+s_name+"';");  
            int present=0;
            while(rs.next())  
            {present = Integer.parseInt(rs.getString(1));}
            System.out.println(present);
            con.close();
            if(present<1)
            {   order_med_valid.setVisible(true);
                order_med_valid.setText("No such staff name found in Staff list.Please Select recurited Staff Only.");
                return 0;
            }
        }catch(Exception e){ System.out.println(e);}  
        
        if(order_model.getRowCount()==0)
        {
            order_med_valid.setVisible(true);
            order_med_valid.setText("Please enter medicine/s.");
            return 0;
        }
        
        String agent_name =  order_agent_name.getText();
        if(agent_name == null || agent_name.isEmpty()) {
        order_med_valid.setVisible(true);
        order_med_valid.setText("Agent Name cannot be blank.");
        return 0;
        }
        
        return 1;
    }
    
    private void bill_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bill_addActionPerformed
       order_add();
    }//GEN-LAST:event_bill_addActionPerformed

    private void bill_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bill_deleteActionPerformed
         order_delete();
    }//GEN-LAST:event_bill_deleteActionPerformed

    private void s_name_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_name_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s_name_comboActionPerformed

    private void order_agent_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_order_agent_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_order_agent_nameActionPerformed

    private void order_med_nameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_order_med_nameItemStateChanged
        try{
            con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/medical_store","root","root");  
            stmt=con.createStatement();
           
            String med_selected = order_med_name.getSelectedItem().toString();
            rs3 = stmt.executeQuery("select Distinct Expd from Active_medicine where Drug_name = '"+med_selected+"';"); 
            order_expd_combo.removeAllItems();
            while(rs3.next())  
                order_expd_combo.addItem(rs3.getString(1));
            
            rs3 = stmt.executeQuery("select Distinct Medicine_form from Active_medicine where Drug_name = '"+med_selected+"';"); 
            order_type_combo.removeAllItems();
            while(rs3.next())  
                order_type_combo.addItem(rs3.getString(1));

              con.close();
        }catch(Exception e){ System.out.println(e);}
    }//GEN-LAST:event_order_med_nameItemStateChanged

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

            try{
            con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/medical_store","root","root");  
            stmt=con.createStatement();
             rs2 = stmt.executeQuery("select Distinct Drug_name from Active_medicine order by Drug_name;");  
            while(rs2.next())  
                order_med_name.addItem(rs2.getString(1));
            con.close();
        }catch(Exception e){ System.out.println(e);}  
            
            
           Date today = new Date();
           SimpleDateFormat dmyFormat = new SimpleDateFormat("dd/MM/yyyy");
           order_date.setText(dmyFormat.format(today));
    }//GEN-LAST:event_formWindowOpened

    private void s_name_comboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_s_name_comboItemStateChanged
 
    }//GEN-LAST:event_s_name_comboItemStateChanged

    private void tblorderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblorderMouseClicked
        
    }//GEN-LAST:event_tblorderMouseClicked

    private void order_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_order_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_order_dateActionPerformed

    private void register_orderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_register_orderActionPerformed
       
        if(order_make_validation()==1)
        {
        String order_id="";
         try{
            con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/medical_store","root","root"); 
            stmt=con.createStatement();
            rs = stmt.executeQuery("select max(Order_id)+1 as bill_id from orders;");  
            while(rs.next())  
                    order_id=rs.getString(1);
            con.close();
            }catch(Exception e){ System.out.println(e);}  
         
         String date = order_date.getText();
         
         try{
         Date date_java=new SimpleDateFormat("dd/MM/yyyy").parse(date);
         SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd");
         date = dmyFormat.format(date_java);
         }
         catch(Exception e){System.out.println(e);}
         
         
         String s_id ="";
         
        try{
        con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/medical_store","root","root"); 
        stmt=con.createStatement();
        String staff_name =s_name_combo.getSelectedItem().toString();
        rs = stmt.executeQuery("select staff_id from staff where name ='"+staff_name+"';");  
        while(rs.next())  
               s_id=rs.getString(1);
       con.close();
       }catch(Exception e){ System.out.println(e);} 
         
         
         String c_name =s_name_combo.getSelectedItem().toString();
      
        while(order_model.getRowCount()!=0)
        {   String product_id="",quantity,price_p_piece,r_price,agent_name,company_name="";
            try{
            con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/medical_store","root","root"); 
            stmt=con.createStatement();
            String drug_name = String.valueOf(order_model.getValueAt(0, 0));
            String expd = String.valueOf(order_model.getValueAt(0, 2));
            String type = String.valueOf(order_model.getValueAt(0, 3));
            
            rs = stmt.executeQuery("select product_id,Company_name from medicine_list where Drug_name ='"+drug_name+"' And Expd ='"+expd+"' And Medicine_form='"+type+"';");  
            while(rs.next())  
            {
                product_id=rs.getString(1);
                company_name=rs.getString(2);
            }
            
            quantity = orders_quantity.getText();
            price_p_piece = String.valueOf(order_model.getValueAt(0, 4));    //,
            r_price = String.valueOf(order_model.getValueAt(0, 5));
            agent_name=order_agent_name.getText();
            stmt.executeUpdate("INSERT INTO ORDERS VALUES("+order_id+",'"+date+"','"+s_id+"',"+product_id+","+quantity+","+price_p_piece+",'"+company_name+"','"+agent_name+"',"+r_price+");");
            order_model.removeRow(0);
            con.close();
            }catch(Exception e){ System.out.println(e);}
        } 
        
        //new Bill().setVisibile(true);
        dispose();
        }
    }//GEN-LAST:event_register_orderActionPerformed

    private void order_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_order_cancelActionPerformed
       dispose();
    }//GEN-LAST:event_order_cancelActionPerformed

    private void orders_quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orders_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_orders_quantityActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new order_desc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bill_add;
    private javax.swing.JButton bill_delete;
    private javax.swing.JLabel bill_dis_label;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField order_agent_name;
    private javax.swing.JButton order_cancel;
    private javax.swing.JFormattedTextField order_date;
    private javax.swing.JComboBox<String> order_expd_combo;
    private javax.swing.JComboBox<String> order_med_name;
    private javax.swing.JLabel order_med_valid;
    private javax.swing.JLabel order_total_price;
    private javax.swing.JComboBox<String> order_type_combo;
    private javax.swing.JTextField orderl_dis;
    private javax.swing.JTextField orders_quantity;
    private javax.swing.JButton register_order;
    private javax.swing.JComboBox<String> s_name_combo;
    private javax.swing.JLabel st_first_name;
    private javax.swing.JLabel st_first_name1;
    private javax.swing.JLabel st_first_name10;
    private javax.swing.JLabel st_first_name2;
    private javax.swing.JLabel st_first_name4;
    private javax.swing.JLabel st_first_name5;
    private javax.swing.JLabel st_first_name7;
    private javax.swing.JLabel st_first_name9;
    private javax.swing.JTable tblorder;
    // End of variables declaration//GEN-END:variables
}
