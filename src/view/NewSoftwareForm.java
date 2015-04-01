package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Software;



public class NewSoftwareForm extends JDialog {
	
	private static final long serialVersionUID = -7265530307974489903L;

	private Software software;

	private JTextField nameText;
	private JTextField iconPathText;
	private JTextField versionText;
	private JTextField osWindows;
	private JTextField osUnix;
	private JTextField osMac;
	private JTextField releaseDate;
	private JTextField producerNameText;
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
		setSize(400, 320);
		setModal(true);
		setResizable(false);

		final JButton cmdSave = new JButton("Save");
		final JButton cmdCancel = new JButton("Cancel");

		nameText = new JTextField(15);
		iconPathText = new JTextField(15);
		versionText = new JTextField(15);
		osWindows = new JTextField(15);
		osUnix = new JTextField(15);
		osMac = new JTextField(15);
		releaseDate = new JTextField(15);
		producerNameText = new JTextField(15);
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
		fieldsPanel.add(producerNameText);
		

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
		osWindows.setText(Boolean.toString(software.isOsWindows()));
		osUnix.setText(Boolean.toString(software.isOsUnix()));
		osMac.setText(Boolean.toString(software.isOsMac()));
		releaseDate.setText(software.getReleaseDate());
		producerNameText.setText("ProducerName");
	}

	private void saveSoftware() {
		try {
			software.setName(nameText.getText());
			software.setIconPath(iconPathText.getText());
			software.setVersion(versionText.getText());
			software.setOsWindows(Boolean.parseBoolean(osWindows.getText()));
			software.setOsUnix(Boolean.parseBoolean(osUnix.getText()));
			software.setOsMac(Boolean.parseBoolean(osMac.getText()));
			software.setReleaseDate(releaseDate.getText());
		
			
			if (software.getProducerId() == null) {
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

}

