/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GroundtruthPanel.java
 *
 * Created on 21-ene-2012, 19:48:14
 */

package jmanager.groundtruth;

import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import jmanager.Robot;

/**
 *
 * @author Gonzalo Abella (abellagonzalo@gmail.com)
 */
public class GroundtruthPanel extends JPanel {

    private DefaultTableModel tableModel;
    private Vector<bica.GTRobot> robotsInTable;

    /** Creates new form BeanForm */
    public GroundtruthPanel() {
        initComponents();

        // Init tableModel
        Vector columnNames = new Vector(5);
        columnNames.add("Id");
        columnNames.add("Robot");
        columnNames.add("Team");
        columnNames.add("Ball");
        columnNames.add("Position");
        tableModel = new DefaultTableModel(columnNames, 0);
        robotsTable.setModel(tableModel);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addRobotDialog = new javax.swing.JDialog();
        buttonsPanel = new javax.swing.JPanel();
        anadirButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();
        addRobotDialogPanel = new javax.swing.JPanel();
        PatternIdLabel = new javax.swing.JLabel();
        RobotLabel = new javax.swing.JLabel();
        patternIdComboBox = new javax.swing.JComboBox();
        robotComboBox = new javax.swing.JComboBox();
        ballDetectorCheckBox = new javax.swing.JCheckBox();
        localizationCheckBox = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        robotsTable = new javax.swing.JTable();
        ButtonsPanel = new javax.swing.JPanel();
        addRobotButton = new javax.swing.JButton();
        removeRobotButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        startButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        GroundtruthPanel = new javax.swing.JPanel();
        hostLabel = new javax.swing.JLabel();
        groundtruthHostTextField = new javax.swing.JTextField();
        portLabel = new javax.swing.JLabel();
        groundtruthPortTextField = new javax.swing.JTextField();
        testButton = new javax.swing.JButton();

        addRobotDialog.setName("addRobotDialog"); // NOI18N

        buttonsPanel.setName("buttonsPanel"); // NOI18N
        buttonsPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        anadirButton.setText("Añadir");
        anadirButton.setName("anadirButton"); // NOI18N
        anadirButton.setPreferredSize(new java.awt.Dimension(80, 29));
        buttonsPanel.add(anadirButton);

        cancelarButton.setText("Cancelar");
        cancelarButton.setName("cancelarButton"); // NOI18N
        cancelarButton.setPreferredSize(new java.awt.Dimension(80, 29));
        buttonsPanel.add(cancelarButton);

        addRobotDialog.getContentPane().add(buttonsPanel, java.awt.BorderLayout.PAGE_END);

        addRobotDialogPanel.setName("addRobotDialogPanel"); // NOI18N

        PatternIdLabel.setText("Pattern Id");
        PatternIdLabel.setName("PatternIdLabel"); // NOI18N

        RobotLabel.setText("Robot");
        RobotLabel.setName("RobotLabel"); // NOI18N

        patternIdComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        patternIdComboBox.setName("patternIdComboBox"); // NOI18N

        robotComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        robotComboBox.setName("robotComboBox"); // NOI18N

        ballDetectorCheckBox.setText("BallDetector");
        ballDetectorCheckBox.setName("ballDetectorCheckBox"); // NOI18N

        localizationCheckBox.setText("Localization");
        localizationCheckBox.setName("localizationCheckBox"); // NOI18N

        javax.swing.GroupLayout addRobotDialogPanelLayout = new javax.swing.GroupLayout(addRobotDialogPanel);
        addRobotDialogPanel.setLayout(addRobotDialogPanelLayout);
        addRobotDialogPanelLayout.setHorizontalGroup(
            addRobotDialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addRobotDialogPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addRobotDialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addRobotDialogPanelLayout.createSequentialGroup()
                        .addGroup(addRobotDialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PatternIdLabel)
                            .addComponent(RobotLabel))
                        .addGap(15, 15, 15)
                        .addGroup(addRobotDialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(robotComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(patternIdComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(addRobotDialogPanelLayout.createSequentialGroup()
                        .addComponent(ballDetectorCheckBox)
                        .addGap(18, 18, 18)
                        .addComponent(localizationCheckBox)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addRobotDialogPanelLayout.setVerticalGroup(
            addRobotDialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addRobotDialogPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addRobotDialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(patternIdComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PatternIdLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addRobotDialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(robotComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RobotLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addRobotDialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(ballDetectorCheckBox)
                    .addComponent(localizationCheckBox))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLayout(new java.awt.BorderLayout());

        jScrollPane1.setName("jScrollPane1"); // NOI18N
        jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 200));

        robotsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Robot", "Team", "Ball", "Position"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        robotsTable.setMinimumSize(new java.awt.Dimension(75, 130));
        robotsTable.setName("robotsTable"); // NOI18N
        jScrollPane1.setViewportView(robotsTable);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        ButtonsPanel.setName("ButtonsPanel"); // NOI18N

        addRobotButton.setText("Add Robot");
        addRobotButton.setMaximumSize(new java.awt.Dimension(105, 29));
        addRobotButton.setMinimumSize(new java.awt.Dimension(105, 29));
        addRobotButton.setName("addRobotButton"); // NOI18N
        addRobotButton.setPreferredSize(new java.awt.Dimension(80, 29));
        ButtonsPanel.add(addRobotButton);

        removeRobotButton.setText("Remove Robot");
        removeRobotButton.setName("removeRobotButton"); // NOI18N
        removeRobotButton.setPreferredSize(new java.awt.Dimension(80, 29));
        ButtonsPanel.add(removeRobotButton);

        refreshButton.setText("Refresh");
        refreshButton.setMaximumSize(new java.awt.Dimension(105, 29));
        refreshButton.setMinimumSize(new java.awt.Dimension(105, 29));
        refreshButton.setName("refreshButton"); // NOI18N
        refreshButton.setPreferredSize(new java.awt.Dimension(80, 29));
        ButtonsPanel.add(refreshButton);

        startButton.setText("Start");
        startButton.setMaximumSize(new java.awt.Dimension(105, 29));
        startButton.setMinimumSize(new java.awt.Dimension(105, 29));
        startButton.setName("startButton"); // NOI18N
        startButton.setPreferredSize(new java.awt.Dimension(80, 29));
        ButtonsPanel.add(startButton);

        stopButton.setText("Stop");
        stopButton.setMaximumSize(new java.awt.Dimension(105, 29));
        stopButton.setMinimumSize(new java.awt.Dimension(105, 29));
        stopButton.setName("stopButton"); // NOI18N
        stopButton.setPreferredSize(new java.awt.Dimension(80, 29));
        ButtonsPanel.add(stopButton);

        add(ButtonsPanel, java.awt.BorderLayout.PAGE_END);

        GroundtruthPanel.setName("GroundtruthPanel"); // NOI18N

        hostLabel.setText("Host");
        hostLabel.setName("hostLabel"); // NOI18N
        GroundtruthPanel.add(hostLabel);

        groundtruthHostTextField.setText("groundtruth.local");
        groundtruthHostTextField.setName("groundtruthHostTextField"); // NOI18N
        groundtruthHostTextField.setPreferredSize(new java.awt.Dimension(200, 27));
        GroundtruthPanel.add(groundtruthHostTextField);

        portLabel.setText("Port");
        portLabel.setName("portLabel"); // NOI18N
        GroundtruthPanel.add(portLabel);

        groundtruthPortTextField.setText("11111");
        groundtruthPortTextField.setName("groundtruthPortTextField"); // NOI18N
        groundtruthPortTextField.setPreferredSize(new java.awt.Dimension(100, 27));
        GroundtruthPanel.add(groundtruthPortTextField);

        testButton.setText("Test");
        testButton.setName("testButton"); // NOI18N
        testButton.setPreferredSize(new java.awt.Dimension(80, 29));
        GroundtruthPanel.add(testButton);

        add(GroundtruthPanel, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ButtonsPanel;
    private javax.swing.JPanel GroundtruthPanel;
    private javax.swing.JLabel PatternIdLabel;
    private javax.swing.JLabel RobotLabel;
    private javax.swing.JButton addRobotButton;
    private javax.swing.JDialog addRobotDialog;
    private javax.swing.JPanel addRobotDialogPanel;
    private javax.swing.JButton anadirButton;
    private javax.swing.JCheckBox ballDetectorCheckBox;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JTextField groundtruthHostTextField;
    private javax.swing.JTextField groundtruthPortTextField;
    private javax.swing.JLabel hostLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox localizationCheckBox;
    private javax.swing.JComboBox patternIdComboBox;
    private javax.swing.JLabel portLabel;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton removeRobotButton;
    private javax.swing.JComboBox robotComboBox;
    private javax.swing.JTable robotsTable;
    private javax.swing.JButton startButton;
    private javax.swing.JButton stopButton;
    private javax.swing.JButton testButton;
    // End of variables declaration//GEN-END:variables

    public void updateRobotsTable(bica.GTRobot[] robots) {
        Vector<bica.GTRobot> robotsVector =
                new Vector<bica.GTRobot>(Arrays.asList(robots));
        updateRobotsTable(robotsVector);
    }

    public void updateRobotsTable(Vector<bica.GTRobot> robots) {
        // Empty table
        while (tableModel.getRowCount()>0) {
            tableModel.removeRow(0);
        }

        // Save vector of robots
        robotsInTable = robots;

        // Fill table
        Iterator<bica.GTRobot> it = robots.iterator();
        while (it.hasNext()) {
            bica.GTRobot robotInfo = it.next();
            Vector row = new Vector();
            row.add(robotInfo.patternId);
            row.add(robotInfo.robot);
            row.add(robotInfo.team);
            if (robotInfo.localization == null) { row.add(false); }
            else { row.add(true); }
            if (robotInfo.ballDetector == null) { row.add(false); }
            else { row.add(true); }
            tableModel.addRow(row);
        }
    }

    /**
     * Devuelve el robot seleccionado.
     * 
     * @return empty bica.GTRobot if no row is selected
     *         or the selected bica.GTRobot.
     */
    public bica.GTRobot getSelectedRobot() {
        int row = robotsTable.getSelectedRow();
        if (row == -1) {
            return new bica.GTRobot();
        } else {
            return robotsInTable.get(row);
        }
    }

    public String getGroundtruthHost() {
        return groundtruthHostTextField.getText();
    }

    public String getGroundtruthPort() {
        return groundtruthPortTextField.getText();
    }

    /*
     * Return empty vector if is canceled.
     */
    public Vector showAddRobotDialog(Vector<Integer> patternIdVector, Vector<Robot> robotsVector) {
        patternIdComboBox.setModel(new DefaultComboBoxModel(patternIdVector));
        robotComboBox.setModel(new DefaultComboBoxModel(robotsVector));
        int option = JOptionPane.showOptionDialog(this,
                addRobotDialogPanel,
                "Add robot",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                new Object[]{"Añadir", "Cancelar"},
                null);

        Vector out = new Vector();
        if (option==JOptionPane.YES_OPTION) {
            out.add(patternIdComboBox.getSelectedItem());
            out.add(robotComboBox.getSelectedItem());
            out.add(ballDetectorCheckBox.isSelected());
            out.add(localizationCheckBox.isSelected());
        }
        return out;
    }

    public void showMessageDialog(String message) {
        JOptionPane.showMessageDialog(this,
                message,
                "Info",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void showErrorDialog(String error) {
        JOptionPane.showMessageDialog(this,
                        error,
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
    }

    public String showStartDialog() {
        return JOptionPane.showInputDialog(this,
                            "Frecuencia de ejecución del Ground truth",
                            "Frecuencia",
                            JOptionPane.QUESTION_MESSAGE);
    }

    public void enableStartButton(boolean enable) {
        startButton.setEnabled(enable);
    }

    public void enableStopButton(boolean enable) {
        stopButton.setEnabled(enable);
    }

    public void addAddRobotListener(ActionListener listener) {
        addRobotButton.addActionListener(listener);
    }

    public void addRemoveRobotListener(ActionListener listener) {
        removeRobotButton.addActionListener(listener);
    }

    public void addRefreshListener(ActionListener listener) {
        refreshButton.addActionListener(listener);
    }

    public void addStartListener(ActionListener listener) {
        startButton.addActionListener(listener);
    }

    public void addStopListener(ActionListener listener) {
        stopButton.addActionListener(listener);
    }

    public void addTestListener(ActionListener listener) {
        testButton.addActionListener(listener);
    }
}
