/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ComponentPerceptionPanel.java
 *
 * Created on 28-oct-2009, 13:08:37
 */
package jmanager.components;

import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import jmanager.*;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;
import jmanager.GrDebug.*;
import jmanager.components.lps.*;
import bica.*;
import java.awt.event.WindowListener;

/**
 *
 * @author paco
 * @author caguero
 */
public class LpsViewer extends javax.swing.JPanel implements WindowListener {

	private LPSTableGUI jScrollPane1;
	private ImageGUI jPanel1;
	private LPS kalmanLps = null;
	private LPO ballLPO;
	private LPO p0NetLPO;
	private LPO p1NetLPO;
	private LPO p0LeftPostLPO;
	private LPO p0RightPostLPO;
	private LPO p1LeftPostLPO;
	private LPO p1RightPostLPO;
	private LpsThread lpsThread;
	private GrPrimitivesRel grPrimitivesRel;
	private JFrame parent;
	/** Creates new form ComponentGTLocalization */
	public LpsViewer() {

		ballLPO = new LPO(0, 0.0, 0.0, 0.0, 0.0, 0.0, "Unknow", 0.0);
		p0NetLPO = new LPO(1, 0.0, 0.0, 0.0, 0.0, 0.0, "Unknow", 0.0);
		p0LeftPostLPO = new LPO(2, 0.0, 0.0, 0.0, 0.0, 0.0, "Unknow", 0.0);
		p0RightPostLPO = new LPO(3, 0.0, 0.0, 0.0, 0.0, 0.0, "Unknow", 0.0);
		p1NetLPO = new LPO(4, 0.0, 0.0, 0.0, 0.0, 0.0, "Unknow", 0.0);
		p1LeftPostLPO = new LPO(5, 0.0, 0.0, 0.0, 0.0, 0.0, "Unknow", 0.0);
		p1RightPostLPO = new LPO(6, 0.0, 0.0, 0.0, 0.0, 0.0, "Unknow", 0.0);

		
		kalmanLps = new LPS();
		jScrollPane1 = new LPSTableGUI(kalmanLps);
		grPrimitivesRel = new GrPrimitivesRel();

		kalmanLps.addObserver(jScrollPane1);	

		jPanel1 = new ImageGUI(grPrimitivesRel);
		//kalmanLps.addObserver(jPanel1);
		grPrimitivesRel.addObserver(jPanel1);

		initComponents();
	}

	public void refresh() {

	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(1000, 250));
        setName("Form"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1000, 250));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jScrollPane1.setMinimumSize(new java.awt.Dimension(1000, 200));
        jScrollPane1.setName("jScrollPane1"); // NOI18N
        jScrollPane1.setPreferredSize(new java.awt.Dimension(1000, 200));

        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(LpsViewer.class);
        jButton1.setText(resourceMap.getString("jButtonPrediction.text")); // NOI18N
        jButton1.setName("jButtonPrediction"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText(resourceMap.getString("jButtonMeasurement.text")); // NOI18N
        jButton2.setName("jButtonMeasurement"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jButton1)
                        .addGap(31, 31, 31)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

	public void updateTable()
	{
		bica.VisualMemoryObj obj = JmanagerView.root.getConnection().ballDetectorPrx.getVisualMemoryObject();
		ballLPO.fill(obj);		
		kalmanLps.setLPO(ballLPO);
		
		obj = JmanagerView.root.getConnection().goalDetectorPrx.getVisualMemoryObject("p0LeftPost");
		p0LeftPostLPO.fill(obj);		
		kalmanLps.setLPO(p0LeftPostLPO);
		
		obj = JmanagerView.root.getConnection().goalDetectorPrx.getVisualMemoryObject("p0RightPost");
		p0RightPostLPO.fill(obj);		
		kalmanLps.setLPO(p0RightPostLPO);
		
		obj = JmanagerView.root.getConnection().goalDetectorPrx.getVisualMemoryObject("p1LeftPost");
		p1LeftPostLPO.fill(obj);		
		kalmanLps.setLPO(p1LeftPostLPO);
		
		obj = JmanagerView.root.getConnection().goalDetectorPrx.getVisualMemoryObject("p1RightPost");
		p1RightPostLPO.fill(obj);		
		kalmanLps.setLPO(p1RightPostLPO);
		
		obj = JmanagerView.root.getConnection().goalDetectorPrx.getVisualMemoryObject("p0Net");
		p0NetLPO.fill(obj);		
		kalmanLps.setLPO(p0NetLPO);
		
		obj = JmanagerView.root.getConnection().goalDetectorPrx.getVisualMemoryObject("p1Net");
		p1NetLPO.fill(obj);		
		kalmanLps.setLPO(p1NetLPO);
	}

	public void refreshLps()
	{
		if(JmanagerView.root.getConnection()!=null){
			bica.Shape[] shapeList = JmanagerView.root.getConnection().debugPrx.getGrDebugRel();

			grPrimitivesRel.setGrPrimitives(shapeList);

			updateTable();
		}
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
		JmanagerView.root.getConnection().goalDetectorPrx.predictionUpdate();

		//JmanagerView.root.getConnection().debugPrx.debugOn("BallDetector");
		bica.Shape[] shapeList = JmanagerView.root.getConnection().debugPrx.getGrDebugRel();

		grPrimitivesRel.setGrPrimitives(shapeList);

		bica.VisualMemoryObj ball = JmanagerView.root.getConnection().ballDetectorPrx.getVisualMemoryObject();
		ballLPO.fill(ball);		
		kalmanLps.setLPO(ballLPO);
	}//GEN-LAST:event_jButton1ActionPerformed

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
		JmanagerView.root.getConnection().goalDetectorPrx.measurementUpdate();

		//JmanagerView.root.getConnection().debugPrx.debugOn("BallDetector");
		bica.Shape[] shapeList = JmanagerView.root.getConnection().debugPrx.getGrDebugRel();

		grPrimitivesRel.setGrPrimitives(shapeList);

		bica.VisualMemoryObj ball = JmanagerView.root.getConnection().ballDetectorPrx.getVisualMemoryObject();
		ballLPO.fill(ball);
		kalmanLps.setLPO(ballLPO);
	}//GEN-LAST:event_jButton2ActionPerformed

	private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
		/*System.out.println("LPS Thread run");
            lpsThread = new LpsThread(this);
            lpsThread.start();*/
	}//GEN-LAST:event_formComponentShown

	private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
		/*System.out.println("LPS Thread stop");
            lpsThread = new LpsThread(this);
            lpsThread.start();*/
	}//GEN-LAST:event_formComponentHidden
	/**/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables

	public void windowOpened(WindowEvent we) {
		System.out.println("LPS Thread run");
		lpsThread = new LpsThread(this);
		lpsThread.start();
	}

	public void windowClosing(WindowEvent we) {
		System.out.println("LPS Thread stop");

		lpsThread.stop();
		parent.removeWindowListener(this);
		parent.remove(this);
	}

	public void windowClosed(WindowEvent we) {
		//throw new UnsupportedOperationException("Not supported yet.");
	}

	public void windowIconified(WindowEvent we) {
		//throw new UnsupportedOperationException("Not supported yet.");
	}

	public void windowDeiconified(WindowEvent we) {
		//throw new UnsupportedOperationException("Not supported yet.");
	}

	public void windowActivated(WindowEvent we) {
		//throw new UnsupportedOperationException("Not supported yet.");
	}

	public void windowDeactivated(WindowEvent we) {
		//throw new UnsupportedOperationException("Not supported yet.");
	}

	public void setFrame(JFrame compFrame) {
		parent = compFrame;
	}
}
