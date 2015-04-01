package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Producer;
import model.Software;



public class NewSoftwareForm extends JDialog {
	
	private static final long serialVersionUID = -7265530307974489903L;

	private Software software;
	private Vector<String> producerList = loadProducersList();
	private JTextField nameText;
	private JTextField iconPathText;
	private JTextField versionText;
	private JCheckBox osWindows;
	private JCheckBox osUnix;
	private JCheckBox osMac;
	private JTextField releaseDate;
	private JComboBox producerId;
	private JLabel JLabel_1 = new JLabel();
	private JLabel JLabel_2 = new JLabel();
	private JLabel JLabel_3 = new JLabel();
	private JLabel JLabel_4 = new JLabel();
	private JLabel JLabel_5 = new JLabel();
	private JLabel JLabel_6 = new JLabel();
	private JLabel JLabel_7 = new JLabel();
	private JLabel JLabel_8 = new JLabel();

	public NewSoftwareForm() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		setTitle("New producer");
		setSize(400, 350);
		setModal(true);
		setResizable(false);

		final JButton cmdSave = new JButton("Save");
		final JButton cmdCancel = new JButton("Cancel");

		nameText = new JTextField(15);
		iconPathText = new JTextField(15);
		versionText = new JTextField(15);
		osWindows = new JCheckBox();
		osUnix = new JCheckBox();
		osMac = new JCheckBox();
		releaseDate = new JTextField(15);
		producerId = new JComboBox(producerList);
		final JPanel fieldsPanel = new JPanel(new GridLayout(8, 2, 10, 10));
		final JPanel fieldsPanelBorder = new JPanel(new FlowLayout(
				FlowLayout.CENTER, 10, 10));
		fieldsPanel.setOpaque(false);
		fieldsPanelBorder.setOpaque(false);
		fieldsPanelBorder.add(fieldsPanel);
		JLabel_1.setText("Name");
		JLabel_2.setText("Icon");
		JLabel_3.setText("Version");
		JLabel_4.setText("Windows");
		JLabel_5.setText("Unix");
		JLabel_6.setText("Mac");
		JLabel_7.setText("Release date");
		JLabel_8.setText("Producer");
		JLabel_8.setForeground(Color.ORANGE);
		JLabel_7.setForeground(Color.ORANGE);
		JLabel_6.setForeground(Color.ORANGE);
		JLabel_5.setForeground(Color.ORANGE);
		JLabel_4.setForeground(Color.ORANGE);
		JLabel_3.setForeground(Color.ORANGE);
		JLabel_2.setForeground(Color.ORANGE);
		JLabel_1.setForeground(Color.ORANGE);
		fieldsPanel.add(JLabel_1);
		fieldsPanel.add(nameText);
		fieldsPanel.add(JLabel_2);
		fieldsPanel.add(iconPathText);
		fieldsPanel.add(JLabel_3);
		fieldsPanel.add(versionText);
		fieldsPanel.add(JLabel_4);
		fieldsPanel.add(osWindows);
		fieldsPanel.add(JLabel_5);
		fieldsPanel.add(osUnix);
		fieldsPanel.add(JLabel_6);
		fieldsPanel.add(osMac);
		fieldsPanel.add(JLabel_7);
		fieldsPanel.add(releaseDate);
		fieldsPanel.add(JLabel_8);
		fieldsPanel.add(producerId);
		

		final JPanel commandsPanel = new JPanel(new FlowLayout());
		final JPanel commandsPanelBorder = new JPanel(new FlowLayout(
				FlowLayout.CENTER, 0, 0));
		commandsPanelBorder.add(commandsPanel);
		commandsPanel.setOpaque(false);
		commandsPanel.add(cmdCancel);
		commandsPanel.add(cmdSave);
		commandsPanelBorder.setOpaque(false);
		
		getContentPane().add(fieldsPanelBorder, BorderLayout.NORTH);
		getContentPane().add(commandsPanelBorder, BorderLayout.SOUTH);
		
		cmdSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveSoftware();
			}
		});

		cmdCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelSave();
			}
		});
	}

	public Software getSoftware() {
		return software;
	}

	public void setSoftware(Software software) {
		this.software = software;
		nameText.setText(software.getName());
		iconPathText.setText(software.getIconPath());
		versionText.setText(software.getVersion());
		osWindows.setSelected(software.isOsWindows());
		osUnix.setSelected(software.isOsUnix());
		osMac.setSelected(software.isOsMac());
		releaseDate.setText(software.getReleaseDate());
		if(software.getProducerId() != null)
			producerId.setSelectedItem(findProducerById(software.getProducerId()));
	}

	private void saveSoftware() {
		try {
			software.setName(nameText.getText());
			software.setIconPath(iconPathText.getText());
			software.setVersion(versionText.getText());
			software.setOsWindows(osWindows.isSelected());
			software.setOsUnix(osUnix.isSelected());
			software.setOsMac(osMac.isSelected());
			software.setReleaseDate(releaseDate.getText());
			//вит€гуЇмо id з назви
			String[] arr = ((String) producerId.getSelectedItem()).split("\\|");
			software.setProducerId(Integer.parseInt(arr[0]));
			
			if (software.getSoftwareId() == null) {
				software.save();
			} else {
				software.update();
			}
			this.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this,
					"Error saving producer: " + e.getMessage());
		}
	}

	private void cancelSave() {
		this.setVisible(false);
	}
	
	private Vector<String> loadProducersList(){
		Vector<String> producersList = new Vector<String>();
		for (Producer p : Producer.all()) {
			producersList.add(p.getProducerId()+"| "+p.getName());
		}
		
		return producersList;
	}
	
	private String findProducerById(int id){
		String producer = null;
		for (String p : producerList) {
			String[] arr = p.split("\\|");
			if(Integer.parseInt(arr[0])==id)producer = p;
		}
		return producer;
	}

}

