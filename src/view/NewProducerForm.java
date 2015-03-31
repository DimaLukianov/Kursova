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

import model.Producer;


public class NewProducerForm extends JDialog {
	
	private static final long serialVersionUID = -7265530307974489903L;

	private Producer producer;

	private JTextField nameText;
	private JTextField countryText;
	private JTextField cityText;
	private JTextField streetText;
	private JTextField emailText;
	private JTextField webSiteText;
	private JTextField telephoneText;
	private JLabel JLabel_1 = new JLabel();
	private JLabel JLabel_2 = new JLabel();
	private JLabel JLabel_3 = new JLabel();
	private JLabel JLabel_4 = new JLabel();
	private JLabel JLabel_5 = new JLabel();
	private JLabel JLabel_6 = new JLabel();
	private JLabel JLabel_7 = new JLabel();

	public NewProducerForm() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		setTitle("New producer");
		setSize(400, 300);
		setModal(true);
		setResizable(false);

		final JButton cmdSave = new JButton("Save");
		final JButton cmdCancel = new JButton("Cancel");

		nameText = new JTextField(15);
		countryText = new JTextField(15);
		cityText = new JTextField(15);
		streetText = new JTextField(15);
		emailText = new JTextField(15);
		webSiteText = new JTextField(15);
		telephoneText = new JTextField(15);
		final JPanel fieldsPanel = new JPanel(new GridLayout(7, 2, 10, 10));
		final JPanel fieldsPanelBorder = new JPanel(new FlowLayout(
				FlowLayout.CENTER, 10, 10));
		fieldsPanel.setOpaque(false);
		fieldsPanelBorder.setOpaque(false);
		fieldsPanelBorder.add(fieldsPanel);
		JLabel_1.setText("Name");
		JLabel_2.setText("Country");
		JLabel_3.setText("City");
		JLabel_4.setText("Street");
		JLabel_5.setText("Email");
		JLabel_6.setText("Web site");
		JLabel_7.setText("Telephone");
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
		fieldsPanel.add(countryText);
		fieldsPanel.add(JLabel_3);
		fieldsPanel.add(cityText);
		fieldsPanel.add(JLabel_4);
		fieldsPanel.add(streetText);
		fieldsPanel.add(JLabel_5);
		fieldsPanel.add(emailText);
		fieldsPanel.add(JLabel_6);
		fieldsPanel.add(webSiteText);
		fieldsPanel.add(JLabel_7);
		fieldsPanel.add(telephoneText);

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
				saveProducer();
			}
		});

		cmdCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelSave();
			}
		});
	}

	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
		nameText.setText(producer.getName());
		countryText.setText(producer.getCountry());
		cityText.setText(producer.getCity());
		streetText.setText(producer.getStreet());
		emailText.setText(producer.getEmail());
		webSiteText.setText(producer.getWebSite());
		telephoneText.setText(producer.getTelephone());
	}

	private void saveProducer() {
		try {
			producer.setName(nameText.getText());
			producer.setCountry(countryText.getText());
			producer.setCity(cityText.getText());
			producer.setStreet(streetText.getText());
			producer.setEmail(emailText.getText());
			producer.setWebSite(webSiteText.getText());
			producer.setTelephone(telephoneText.getText());
//			producer.update();
//			producer.create(nameText.getText(), countryText.getText(), cityText.getText(), 
//					streetText.getText(), emailText.getText(), webSiteText.getText(), telephoneText.getText());
			
			
			if (producer.getProducerId() == null) {
				producer.save();
			} else {
				producer.update();
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
