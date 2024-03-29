package roomease.rents;

import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import database.RoomDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import javax.swing.table.DefaultTableModel;
import roomease.homepage.EmployeeHome;
import util.Room;
import util.WindowCloseHandler;

/**The RoomCheck is a JFrame that displays the GUI for checking the rooms availability*/
public class RoomCheck extends javax.swing.JFrame {
    
    List <Room> roomList;
  

    LocalDate checkinCurrent = null;
    LocalDate checkoutCurrent = null;
    public RoomCheck() throws SQLException {
        System.out.println("WTF ROOMCHECK");
        
        initComponents();
     
            LocalDate today = LocalDate.now();
             checkinCurrent = today;
             checkoutCurrent = today;
            roomList = RoomDAO.getAvailableRooms(today, today);
            DefaultTableModel tableModel = (DefaultTableModel) roomsTable.getModel();
            /**FIlls the table with data from database*/
            for (Room room : roomList) {
                Object[] rowData = { room.getRoomNumber(), room.getPrice(),room.getDescription()};
                tableModel.addRow(rowData);
            }
            roomsTable.setModel(tableModel);
        //setResizable(false);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        roomsTable = new javax.swing.JTable();
        add1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        CheckOutDate = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        add2 = new javax.swing.JButton();
        CheckInDate = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        add = new javax.swing.JButton();

        jLabel1.setText("Check In:");

        jLabel2.setText("Check In:");

        jLabel4.setText("Check Out:");

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Check Available Rooms");

        jPanel1.setBackground(new java.awt.Color(8, 99, 117));

        roomsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Room #", "Room Price", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Double.class, java.lang.String.class
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
        roomsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        roomsTable.setShowGrid(true);
        roomsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(roomsTable);
        if (roomsTable.getColumnModel().getColumnCount() > 0) {
            roomsTable.getColumnModel().getColumn(0).setPreferredWidth(70);
            roomsTable.getColumnModel().getColumn(0).setMaxWidth(70);
            roomsTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            roomsTable.getColumnModel().getColumn(1).setMaxWidth(100);
        }
        roomsTable.setAutoCreateRowSorter(true);

        add1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        add1.setText("Go Back");
        add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoBack(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(247, 236, 89));
        jLabel5.setText("Check Out:");

        CheckOutDate.setDateFormatString("yyyy-MM-dd");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(247, 236, 89));
        jLabel3.setText("Check In:");

        add2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        add2.setText("ADD");
        add2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButton(evt);
            }
        });

        CheckInDate.setDateFormatString("yyyy-MM-dd");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(247, 236, 89));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Available Rooms");

        add.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        add.setText("Find");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FindButton(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(610, 610, 610)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CheckOutDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CheckInDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(add, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(add2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(add1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                        .addGap(15, 15, 15))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE))
                    .addContainerGap(164, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CheckInDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CheckOutDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(add)
                .addGap(18, 18, 18)
                .addComponent(add2)
                .addGap(76, 76, 76)
                .addComponent(add1)
                .addGap(71, 71, 71))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    


    /**Finds available rooms based on the dates*/
    public Boolean FF(){
        LocalDate checkInDate = null;
        LocalDate checkOutDate = null;
        Boolean check = false;
        try {
            checkInDate = LocalDate.parse(((JTextField) CheckInDate.getDateEditor().getUiComponent()).getText());
            checkOutDate = LocalDate.parse(((JTextField) CheckOutDate.getDateEditor().getUiComponent()).getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid date");
            return false;
        }

        //Make a try catch if the check in date is after the check out date, check in date is before today, check out date is before today and check in date is after check out date
        if (checkInDate.isAfter(checkOutDate)) {
            JOptionPane.showMessageDialog(null, "Check in date cannot be after check out date");
            return false;
        } else if (checkInDate.isBefore(LocalDate.now())) {
            JOptionPane.showMessageDialog(null, "Check in date cannot be before today");
            return false;
        } else if (checkOutDate.isBefore(LocalDate.now())) {
            JOptionPane.showMessageDialog(null, "Check out date cannot be before today");
            return false;
        } else if (checkInDate.isAfter(checkOutDate)) {
            JOptionPane.showMessageDialog(null, "Check in date cannot be after check out date");
            return false;
        }

        System.out.println("Check in date: " + checkInDate);
        System.out.println("Check out date: " + checkOutDate);

        checkinCurrent = checkInDate;
        checkoutCurrent = checkOutDate;

        Boolean check1 = false;
        try {
            List<Room> availableRooms = RoomDAO.getAvailableRooms(checkInDate, checkOutDate);
            DefaultTableModel tableModel = (DefaultTableModel) roomsTable.getModel();
            tableModel.setRowCount(0); // Clear all rows from the table model

            for (Room room : availableRooms) {
                Object[] rowData = { room.getRoomNumber(), room.getPrice(),room.getDescription()};
                tableModel.addRow(rowData);
                check1 = true;
            }
            roomsTable.setModel(tableModel);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(RoomCheck.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (check1 == false) {
            JOptionPane.showMessageDialog(null, "No rooms available for the selected dates");
            return false;
        }

        check = true;
        return check;
    }
    /**Represents the Find button. It calls the FF method to find available rooms*/
    private void FindButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FindButton
        //TODO add your handling code here:
        System.out.println("Add expense button pressed");
        FF();
        
        
    }//GEN-LAST:event_FindButton
/**Disposes current frame and creates a new EmployeeHome*/
    private void GoBack(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GoBack
        // TODO add your handling code here:
        System.out.println("Go back button pressed");
        this.dispose();
        new EmployeeHome().setVisible(true);


    }//GEN-LAST:event_GoBack
    /**Check if the values in the fields are valid and then creates Add tenant*/
    private void AddButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButton
        // TODO add your handling code here:
        System.out.println("Add button pressed");

       
        LocalDate checkInDate = null;
        LocalDate checkOutDate = null;

        try {
            checkInDate = LocalDate.parse(((JTextField) CheckInDate.getDateEditor().getUiComponent()).getText());
            checkOutDate = LocalDate.parse(((JTextField) CheckOutDate.getDateEditor().getUiComponent()).getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid date");
            return;
        }

        if(checkinCurrent.equals(checkInDate) && checkoutCurrent.equals(checkOutDate)){
            if(checkinCurrent == null || checkoutCurrent == null){
                JOptionPane.showMessageDialog(null, "Please enter a valid date");
                return;
            }
        }else{
            if(FF() == false){
                return;
            }
        }

        int row = roomsTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Please select a room");
            return;
        }

        String roomString = roomsTable.getModel().getValueAt(row, 0).toString();

        Room room = null;
        try {
            room = RoomDAO.getRoomByNumber(roomString);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(RoomCheck.class.getName()).log(Level.SEVERE, null, ex);
        }  
        JOptionPane.showMessageDialog(null, "Room Avalable");
        //Pop up window to confirm the room is available and ask if they want to book it
        //If yes, then add the booking to the database
        //If no, then do nothing

        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to book this room?", "Warning", dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {
            // Saving code here
            System.out.println("Yes option selected");
            new AddTenant(room, checkInDate, checkOutDate).setVisible(true);
            this.dispose();      
        } else {
            System.out.println("No option selected");
        }

    }//GEN-LAST:event_AddButton

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new RoomCheck().setVisible(true);
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(RoomCheck.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser CheckInDate;
    private com.toedter.calendar.JDateChooser CheckOutDate;
    private javax.swing.JButton add;
    private javax.swing.JButton add1;
    private javax.swing.JButton add2;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable roomsTable;
    // End of variables declaration//GEN-END:variables
}
