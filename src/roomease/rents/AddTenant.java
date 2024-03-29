package roomease.rents;

import database.EmployeeLogs;
import database.RentalDAO;
import database.TenantDAO;
import javax.swing.JOptionPane;
import util.Session;
import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import roomease.homepage.EmployeeHome;
import util.EmployeeActionLog;
import util.Rental;
import util.Room;
import util.Tenant;
import util.WindowCloseHandler;

/**
 * The AddTenant class represent a JFrame that displays field and buttons for
 * adding a tenant
 */
public class AddTenant extends javax.swing.JFrame {

    /**
     * Creates new form AddTenant
     */
    public AddTenant() {
        System.out.println("AddTenant");
        initComponents();
        WindowCloseHandler.addWindowClosingListener(this);
    }

    Room room;
    LocalDate startDate;
    LocalDate endDate;

    public AddTenant(Room Room, LocalDate startDate, LocalDate endDate) {
        initComponents();
        this.room = Room;
        this.startDate = startDate;
        this.endDate = endDate;
        WindowCloseHandler.addWindowClosingListener(this);
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
        userTypeLabel1 = new javax.swing.JLabel();
        LastName = new javax.swing.JTextField();
        PhoneNumber = new javax.swing.JTextField();
        userTypeLabel2 = new javax.swing.JLabel();
        userTypeLabel3 = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        Email = new javax.swing.JTextField();
        CancelButton = new javax.swing.JButton();
        userTypeLabel4 = new javax.swing.JLabel();
        FirstName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Add Tenant");

        jPanel1.setBackground(new java.awt.Color(8, 99, 117));
        jPanel1.setForeground(new java.awt.Color(247, 236, 89));

        userTypeLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        userTypeLabel1.setForeground(new java.awt.Color(247, 236, 89));
        userTypeLabel1.setText("First Name");

        LastName.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N

        PhoneNumber.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N

        userTypeLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        userTypeLabel2.setForeground(new java.awt.Color(247, 236, 89));
        userTypeLabel2.setText("Last Name");

        userTypeLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        userTypeLabel3.setForeground(new java.awt.Color(247, 236, 89));
        userTypeLabel3.setText("Email");

        submit.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Submit(evt);
            }
        });

        Email.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N

        CancelButton.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButton(evt);
            }
        });

        userTypeLabel4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        userTypeLabel4.setForeground(new java.awt.Color(247, 236, 89));
        userTypeLabel4.setText("Phone Number");

        FirstName.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 476, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(60, 60, 60)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(userTypeLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(userTypeLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(PhoneNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(userTypeLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(userTypeLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(LastName)
                                        .addComponent(FirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(CancelButton))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(186, 186, 186)
                            .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(27, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 305, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(CancelButton)
                    .addGap(43, 43, 43)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(userTypeLabel1)
                        .addComponent(FirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(userTypeLabel2)
                        .addComponent(LastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(userTypeLabel3)
                        .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(PhoneNumber)
                        .addComponent(userTypeLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(32, 32, 32)
                    .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(27, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /**Represents the submit button and when clicked will asses the fields and then insert into the database*/
    private void Submit(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Submit
        // TODO add your handling code here:
        //Get the values from the text fields
        String firstName = FirstName.getText();
        String lastName = LastName.getText();
        String email = Email.getText();
        String phoneNumber = PhoneNumber.getText();

        //Check if the fields are empty
        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || phoneNumber.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all the fields");
        } else {
            //Create a new tenant object
            Tenant tenant = new Tenant(0,firstName, lastName, email, phoneNumber);
            int tenantID = 0;
            try {
                //Add the tenant to the database
                 tenantID = TenantDAO.addTenant(tenant);
            } catch (SQLException ex) {
                Logger.getLogger(AddTenant.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Confirm to add Rental?", "Warning", dialogButton);
            if (dialogResult == JOptionPane.YES_OPTION) {
                
                

                try {
                    //calculate the days of the rental
                    long days = ChronoUnit.DAYS.between(startDate, endDate);
                    int daysInt = Math.toIntExact(days);

                    System.out.println("Number of days: " + daysInt);
                    
                    //calculate the total price of the rental
                    double totalPrice = (days+1) * room.getPrice();
                    
                    //Create a new rental object
                    int userID = Session.getCurrentUserId();
                    Rental rental = new Rental(tenantID, userID, room.getId(), startDate, endDate, totalPrice);

                    //Add Action to the log
                    String action = "Added a new rental";
                    EmployeeActionLog employeeActionLog = new EmployeeActionLog(userID, action);

                    //Add the action to the database
                    EmployeeLogs.createEmployeeActionLog(employeeActionLog);


                    //Add the rental to the database
                    RentalDAO.addRental(rental);
                    JOptionPane.showMessageDialog(null, "Rental added successfully");
                } catch (SQLException ex) {
                    Logger.getLogger(AddTenant.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Rental not added");
            }

            dispose();
            new EmployeeHome().setVisible(true);
        }
        
    }//GEN-LAST:event_Submit
    /**Diposes the frame*/
    private void CancelButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButton
        // TODO add your handling code here:
        dispose();
        
    }//GEN-LAST:event_CancelButton

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddTenant().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField FirstName;
    private javax.swing.JTextField LastName;
    private javax.swing.JTextField PhoneNumber;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton submit;
    private javax.swing.JLabel userTypeLabel1;
    private javax.swing.JLabel userTypeLabel2;
    private javax.swing.JLabel userTypeLabel3;
    private javax.swing.JLabel userTypeLabel4;
    // End of variables declaration//GEN-END:variables
}
