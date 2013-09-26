/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SwitchViewer.java
 *
 * Created on 31-may-2011, 13:08:37
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
import jmanager.components.Switch.*;
import bica.*;
import java.awt.event.WindowListener;

/**
 *
 * @author caguero
 */
public class SwitchViewer extends javax.swing.JPanel implements WindowListener {

	private SwitchTableGUI jScrollPane1;	
	private SharedTeamInfo teamInfo = null;
	private JFrame parent;
	private SwitchThread switchThread;

	public SwitchViewer() {

		teamInfo = new SharedTeamInfo();
		jScrollPane1 = new SwitchTableGUI(teamInfo);
		teamInfo.addObserver(jScrollPane1);	

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

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(213, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
	}// </editor-fold>//GEN-END:initComponents

	public void refreshSwitchViewer()
	{
		if(JmanagerView.root.getConnection() != null){
			/*try {
				if (JmanagerView.root.getConnection().teamInfo0Prx != null) {
					bica.SwitchOpinion[] opinionsList = JmanagerView.root.getConnection().teamInfo0Prx.getOpinionsList();
					teamInfo.setRobotOpinionsList(opinionsList);
				} else {
					JmanagerView.root.getConnection().base = JmanagerView.root.getConnection().ic.stringToProxy(
							"TeamInfoProvider:default -h " + JmanagerView.root.getConnection().currentHost + " -p " + 10000);
					JmanagerView.root.getConnection().teamInfo0Prx = bica.TeamInfoProviderPrxHelper.checkedCast(
							JmanagerView.root.getConnection().base);
				}
			}catch(Ice.ConnectFailedException e) {
				JmanagerView.root.getConnection().teamInfo0Prx = null;
			};
			try {
				if (JmanagerView.root.getConnection().teamInfo1Prx != null) {
					bica.SwitchOpinion[] opinionsList = JmanagerView.root.getConnection().teamInfo1Prx.getOpinionsList();
					teamInfo.setRobotOpinionsList(opinionsList);
				} else {
					JmanagerView.root.getConnection().base = JmanagerView.root.getConnection().ic.stringToProxy(
							"TeamInfoProvider:default -h " + JmanagerView.root.getConnection().currentHost + " -p " + 10001);
					JmanagerView.root.getConnection().teamInfo1Prx = bica.TeamInfoProviderPrxHelper.checkedCast(
							JmanagerView.root.getConnection().base);
				}
			}catch(Ice.ConnectFailedException e) {
				JmanagerView.root.getConnection().teamInfo1Prx = null;
			};*/
			try {
				if (JmanagerView.root.getConnection().teamInfo2Prx != null) {
					bica.SwitchOpinion[] opinionsList = JmanagerView.root.getConnection().teamInfo2Prx.getOpinionsList();
					teamInfo.setRobotOpinionsList(opinionsList);
				}/* else {
					JmanagerView.root.getConnection().base = JmanagerView.root.getConnection().ic.stringToProxy(
							"TeamInfoProvider:default -h " + JmanagerView.root.getConnectionPanel().robots[1].getConnection().currentHost + " -p " + 10002);
					JmanagerView.root.getConnection().teamInfo2Prx = bica.TeamInfoProviderPrxHelper.checkedCast(
							JmanagerView.root.getConnection().base);
				}	*/		
			}catch(Ice.LocalException ex)
			{
				JmanagerView.root.getConnection().teamInfo2Prx = null;
				System.out.println("Excepción conectando al Robot 2");
				ex.printStackTrace();  
			};
							
			try{
				if (JmanagerView.root.getConnection().teamInfo3Prx != null) {
					bica.SwitchOpinion[] opinionsList = JmanagerView.root.getConnection().teamInfo3Prx.getOpinionsList();
					teamInfo.setRobotOpinionsList(opinionsList);
				} /*else {
					JmanagerView.root.getConnection().base = JmanagerView.root.getConnection().ic.stringToProxy(
							"TeamInfoProvider:default -h " + JmanagerView.root.getConnectionPanel().robots[2].getConnection().currentHost + " -p " + 10003);
					JmanagerView.root.getConnection().teamInfo3Prx = bica.TeamInfoProviderPrxHelper.checkedCast(
							JmanagerView.root.getConnection().base);
				}*/
			}catch(Ice.LocalException ex)
			{
				JmanagerView.root.getConnection().teamInfo3Prx = null;
				System.out.println("Excepción conectando al Robot 3");
				ex.printStackTrace();  
			};
			
			try{
				if (JmanagerView.root.getConnection().teamInfo4Prx != null) {
					bica.SwitchOpinion[] opinionsList = JmanagerView.root.getConnection().teamInfo4Prx.getOpinionsList();
					teamInfo.setRobotOpinionsList(opinionsList);
				}/* else {
					JmanagerView.root.getConnection().base = JmanagerView.root.getConnection().ic.stringToProxy(
							"TeamInfoProvider:default -h " + JmanagerView.root.getConnectionPanel().robots[3].getConnection().currentHost + " -p " + 10004);
					JmanagerView.root.getConnection().teamInfo4Prx = bica.TeamInfoProviderPrxHelper.checkedCast(
							JmanagerView.root.getConnection().base);
				}*/
			}catch(Ice.LocalException ex)
			{
				JmanagerView.root.getConnection().teamInfo4Prx = null;
				System.out.println("Excepción conectando al Robot 4");
				ex.printStackTrace();  
			};
		}
	}

	private void formComponentShown(java.awt.event.ComponentEvent evt) {                                      
	}                                   

	private void formComponentHidden(java.awt.event.ComponentEvent evt) {                                       
	}                                    
	/**/
	// Variables declaration - do not modify//GEN-BEGIN:variables
	// End of variables declaration//GEN-END:variables

	public void windowOpened(WindowEvent we) {
		System.out.println("Switch Thread run");
		switchThread = new SwitchThread(this);
		switchThread.start();
	}

	public void windowClosing(WindowEvent we) {
		System.out.println("Switch Thread stop");
		switchThread.stop();
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