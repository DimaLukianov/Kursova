package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Licence;
import model.Record;
import model.Software;



public class NewRecordForm extends JDialog {
	
	private static final long serialVersionUID = -7265530307974489903L;
	
	private Record record;

	private Vector<String> softwareList = loadSoftwareList();
	
	private Vector<String> licenceList = loadLicenceeList();

	private JComboBox softwareId;
	private JComboBox licenceId;


	private JLabel JLabel_1 = new JLabel();
	private JLabel JLabel_2 = new JLabel();



	public NewRecordForm(){
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		setTitle("Record");
		setSize(400, 200);
		setModal(true);
		setResizable(false);		
		
		final JButton cmdSave = new JButton("Save");
		final JButton cmdCancel = new JButton("Cancel");

		softwareId = new JComboBox(softwareList);
		licenceId = new JComboBox(licenceList);

		final JPanel fieldsPanel = new JPanel(new GridLayout(2, 2, 10, 10));
		final JPanel fieldsPanelBorder = new JPanel(new FlowLayout(
				FlowLayout.CENTER, 10, 10));
		fieldsPanel.setOpaque(false);
		fieldsPanelBorder.setOpaque(false);
		fieldsPanelBorder.add(fieldsPanel);
		JLabel_1.setText("Software");
		JLabel_2.setText("Licence");
		JLabel_2.setForeground(Color.ORANGE);
		JLabel_1.setForeground(Color.ORANGE);
		fieldsPanel.add(JLabel_1);
		fieldsPanel.add(JLabel_2);
		fieldsPanel.add(softwareId);
		fieldsPanel.add(licenceId);


		final JPanel commandsPanel = new JPanel(new FlowLayout());
		final JPanel commandsPanelBorder = new JPanel(new FlowLayout(
				FlowLayout.CENTER, 0, 0));
		commandsPanelBorder.add(commandsPanel);
		commandsPanel.setOpaque(false);
		commandsPanel.add(cmdSave);
		commandsPanel.add(cmdCancel);
		commandsPanelBorder.setOpaque(false);
		
		getContentPane().add(fieldsPanelBorder, BorderLayout.NORTH);
		getContentPane().add(commandsPanelBorder, BorderLayout.SOUTH);
		
		cmdSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveRecord();
			}
		});

		cmdCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelSave();
			}
		});
	}

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
		if(record.getRef().getSoftwareId() != null){
			Software s = (Software) record.getSoftware().findById(record.getRef().getSoftwareId());
			softwareId.setSelectedItem(s.getSoftwareId()+"# "+s.getName());
		}
			
		if(record.getRef().getLicenceId() != null){
			Licence l = (Licence) record.getLicence().findById(record.getRef().getLicenceId());
			licenceId.setSelectedItem(l.getLicenceId()+"# "+l.getName());
		}
	}

	private void saveRecord() {
		try {
			String[] arr = ((String) softwareId.getSelectedItem()).split("#");
			record.getRef().setSoftwareId(Integer.parseInt(arr[0]));
			
			arr =  ((String) licenceId.getSelectedItem()).split("#");
			record.getRef().setLicenceId(Integer.parseInt(arr[0]));
			
			if (record.getRef().getRefId() == null) {
				record.getRef().save();
			} else {
				record.getRef().update();
			}
			this.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this,
					"Error saving record: " + e.getMessage());
		}
	}

	private void cancelSave() {
		this.setVisible(false);
	}
	
	private Vector<String> loadSoftwareList() {
		Vector<String> softwareList = new Vector<String>();
		for (Software s : Software.all()) {
			softwareList.add(s.getSoftwareId()+"# "+s.getName());
		}
		
		return softwareList;
	}

	private Vector<String> loadLicenceeList() {
		Vector<String> licenceList = new Vector<String>();
		for (Licence l : Licence.all()) {
			licenceList.add(l.getLicenceId()+"# "+l.getName());
		}
		
		return licenceList;
	}

}
