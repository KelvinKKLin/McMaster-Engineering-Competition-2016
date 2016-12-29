package competition;

import java.util.concurrent.TimeUnit;

/**
 * This is the entry point to the program. It builds the GUI and initializes all of the sensor
 * simulations.
 *
 * @author Kelvin Lin, Weilin Hu
 */
public class Run extends javax.swing.JFrame {

    public static int counter; // create a counter to see how many time broadcasted
    public static Radio r; // Radio object
    public static Buoy b; //Buoy object
    public static InternalCommunicationNetwork icn; //  InternalCommunicationNetwork object
    public static Rain_Gauge rain; // Rain_Gauge object
    public static Laser laser; // Laser object
    public static Thermometer thermo; // Thermometer object
    public static Wind_Gauge windy;  // Wind_Gauge obejct

    /**
     * Constructor of the default mode Initialize the window of GUI
     */
    public Run() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * Generate labels and text fields WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        broadcasting_label = new javax.swing.JLabel();
        broadcasting_content = new javax.swing.JTextField();
        danger_level_label = new javax.swing.JLabel();
        danger_level_content = new javax.swing.JTextField();
        number_of_broadcasting_label = new javax.swing.JLabel();
        number_of_broadcasting_content = new javax.swing.JTextField();
        precipitation_label = new javax.swing.JLabel();
        wind_speed_label = new javax.swing.JLabel();
        wind_direction_label = new javax.swing.JLabel();
        visibility_label = new javax.swing.JLabel();
        temperature_label = new javax.swing.JLabel();
        precipitation_value = new javax.swing.JTextField();
        wind_speed_value = new javax.swing.JTextField();
        wind_direction_value = new javax.swing.JTextField();
        visibility_value = new javax.swing.JTextField();
        temperature_value = new javax.swing.JTextField();
        precipitation_unit = new javax.swing.JLabel();
        wind_speed_unit = new javax.swing.JLabel();
        visibility_percentage_unit = new javax.swing.JLabel();
        temperature_unit = new javax.swing.JLabel();
        start_button = new javax.swing.JButton();
        swtich_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        broadcasting_label.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        broadcasting_label.setText("BroadCasting");
        broadcasting_label.setName("broadcast_label"); // NOI18N

        broadcasting_content.setEditable(false);
        broadcasting_content.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                broadcasting_contentActionPerformed(evt);
            }
        });

        danger_level_label.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        danger_level_label.setText("Danger Level");

        danger_level_content.setEditable(false);

        number_of_broadcasting_label.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        number_of_broadcasting_label.setText("Number of Boradcasting");

        number_of_broadcasting_content.setEditable(false);

        precipitation_label.setText("Precipitation");

        wind_speed_label.setText("Wind Speed");

        wind_direction_label.setText("Wind Direction");

        visibility_label.setText("Visibility");

        temperature_label.setText("Temperature");

        precipitation_value.setEditable(false);

        wind_speed_value.setEditable(false);

        wind_direction_value.setEditable(false);

        visibility_value.setEditable(false);

        temperature_value.setEditable(false);

        precipitation_unit.setText("mm/h");

        wind_speed_unit.setText("km/h");

        visibility_percentage_unit.setText("%");

        temperature_unit.setText("°C");

        start_button.setText("Start");
        start_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                start_buttonActionPerformed(evt);
            }
        });

        swtich_button.setText("Switch");
        swtich_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                swtich_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(broadcasting_label)
                    .addComponent(broadcasting_content, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(danger_level_label)
                            .addComponent(danger_level_content, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(number_of_broadcasting_label)
                            .addComponent(number_of_broadcasting_content, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(172, 172, 172)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(temperature_label)
                                    .addComponent(visibility_label))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(temperature_value, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(visibility_value, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(precipitation_value, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(wind_speed_label)
                                            .addGap(26, 26, 26))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(wind_direction_label)
                                            .addGap(12, 12, 12)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(precipitation_label)
                                        .addGap(26, 26, 26)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(wind_direction_value, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                                    .addComponent(wind_speed_value))))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(precipitation_unit)
                            .addComponent(wind_speed_unit)
                            .addComponent(visibility_percentage_unit)
                            .addComponent(temperature_unit)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(start_button, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(swtich_button, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140)))
                .addContainerGap(151, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(broadcasting_label)
                .addGap(18, 18, 18)
                .addComponent(broadcasting_content, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(danger_level_label)
                    .addComponent(precipitation_label)
                    .addComponent(precipitation_value, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(precipitation_unit))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(danger_level_content, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(wind_speed_label)
                            .addComponent(wind_speed_value, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(wind_speed_unit))))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wind_direction_label)
                    .addComponent(wind_direction_value, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(number_of_broadcasting_label)
                    .addComponent(visibility_label)
                    .addComponent(visibility_value, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(visibility_percentage_unit))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(temperature_label)
                            .addComponent(temperature_value, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(temperature_unit)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(number_of_broadcasting_content, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(start_button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(swtich_button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62))
        );

        broadcasting_label.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
     * This is the start button
     *
     * @param evt The action event
     */
    private void start_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_start_buttonActionPerformed

        r = new Radio();
        b = new Buoy();
        icn = new InternalCommunicationNetwork();
        rain = new Rain_Gauge();
        laser = new Laser();
        thermo = new Thermometer();
        windy = new Wind_Gauge();
        rain.received();
        laser.received();
        thermo.received();
        windy.received();
        rain.send(icn);
        laser.send(icn);
        thermo.send(icn);
        windy.send(icn);

        b.receive(icn);
        counter++;
        broadcasting_content.setText(b.send(r));
        danger_level_content.setText(String.valueOf(Buoy.danger));
        number_of_broadcasting_content.setText(String.valueOf(counter));
        precipitation_value.setText(String.valueOf(icn.get(0)));
        wind_speed_value.setText(String.valueOf(icn.get(1)));
        wind_direction_value.setText(String.valueOf(icn.get(2)));
        visibility_value.setText(String.valueOf(icn.get(3)));
        temperature_value.setText(String.valueOf(icn.get(4)));


    }//GEN-LAST:event_start_buttonActionPerformed

    /**
     * The switch button event opens up the test screen
     *
     * @param evt The event
     */
    private void swtich_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_swtich_buttonActionPerformed
        TestMode tm = new TestMode();
        tm.setVisible(true);
    }//GEN-LAST:event_swtich_buttonActionPerformed

    /**
     * The radio output
     *
     * @param evt The event
     */
    private void broadcasting_contentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_broadcasting_contentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_broadcasting_contentActionPerformed

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
            java.util.logging.Logger.getLogger(Run.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Run.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Run.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Run.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Run().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField broadcasting_content;
    private javax.swing.JLabel broadcasting_label;
    private javax.swing.JTextField danger_level_content;
    private javax.swing.JLabel danger_level_label;
    private javax.swing.JTextField number_of_broadcasting_content;
    private javax.swing.JLabel number_of_broadcasting_label;
    private javax.swing.JLabel precipitation_label;
    private javax.swing.JLabel precipitation_unit;
    private javax.swing.JTextField precipitation_value;
    private javax.swing.JButton start_button;
    private javax.swing.JButton swtich_button;
    private javax.swing.JLabel temperature_label;
    private javax.swing.JLabel temperature_unit;
    private javax.swing.JTextField temperature_value;
    private javax.swing.JLabel visibility_label;
    private javax.swing.JLabel visibility_percentage_unit;
    private javax.swing.JTextField visibility_value;
    private javax.swing.JLabel wind_direction_label;
    private javax.swing.JTextField wind_direction_value;
    private javax.swing.JLabel wind_speed_label;
    private javax.swing.JLabel wind_speed_unit;
    private javax.swing.JTextField wind_speed_value;
    // End of variables declaration//GEN-END:variables
}