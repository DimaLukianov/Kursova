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

import model.Licence;



public class NewLicenceForm extends JDialog {
	
	private static final long serialVersionUID = -7265530307974489903L;

	private Licence licence;

	private JTextField nameText;
	private JTextField typeText;
	//private MaskFormatter formatter;
	//private JFormattedTextField priceText;
	private JTextField periodText;
	private JTextField priceText;

	private JLabel JLabel_1 = new JLabel();
	private JLabel JLabel_2 = new JLabel();
	private JLabel JLabel_3 = new JLabel();
	private JLabel JLabel_4 = new JLabel();


	public NewLicenceForm(){
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		setTitle("Licence");
		setSize(400, 300);
		setModal(true);
		setResizable(false);
//		try {
//			formatter = new MaskFormatter("###-####");
//		} catch (ParseException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		formatter.setPlaceholderCharacter('_');
		
		
		final JButton cmdSave = new JButton("Save");
		final JButton cmdCancel = new JButton("Cancel");

		nameText = new JTextField(15);
		typeText = new JTextField(15);
		periodText = new JTextField(15);
		priceText = new JTextField(15);//new JFormattedTextField(formatter);

		final JPanel fieldsPanel = new JPanel(new GridLayout(4, 2, 10, 10));
		final JPanel fieldsPanelBorder = new JPanel(new FlowLayout(
				FlowLayout.CENTER, 10, 10));
		fieldsPanel.setOpaque(false);
		fieldsPanelBorder.setOpaque(false);
		fieldsPanelBorder.add(fieldsPanel);
		JLabel_1.setText("Name");
		JLabel_2.setText("Type");
		JLabel_3.setText("Period");
		JLabel_4.setText("Price");
		JLabel_4.setForeground(Color.ORANGE);
		JLabel_3.setForeground(Color.ORANGE);
		JLabel_2.setForeground(Color.ORANGE);
		JLabel_1.setForeground(Color.ORANGE);
		fieldsPanel.add(JLabel_1);
		fieldsPanel.add(nameText);
		fieldsPanel.add(JLabel_2);
		fieldsPanel.add(typeText);
		fieldsPanel.add(JLabel_3);
		fieldsPanel.add(periodText);
		fieldsPanel.add(JLabel_4);
		fieldsPanel.add(priceText);


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

	public Licence getLicence() {
		return licence;
	}

	public void setLicence(Licence licence) {
		this.licence = licence;
		nameText.setText(licence.getName());
		typeText.setText(licence.getType());
		periodText.setText(Integer.toString(licence.getPeriod()));
		priceText.setText(Double.toString(licence.getPrice()));
	}

	private void saveProducer() {
		try {
			licence.setName(nameText.getText());
			licence.setType(typeText.getText());
			licence.setPeriod(Integer.parseInt(periodText.getText()));
			licence.setPrice(Double.parseDouble(priceText.getText()));


			if (licence.getLicenceId() == null) {
				licence.save();
			} else {
				licence.update();
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
