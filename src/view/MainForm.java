package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;

import model.Producer;
import model.Software;

public class MainForm extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String ALL_STUDENTS = "allStudent";
	
	//private final static JFrame mainFrame = new JFrame();
	
	DefaultListModel listModel = new DefaultListModel();
	
	DefaultListModel listModel2 = new DefaultListModel();
	
	private JList prodList ;
	
	//private JList softList;
	
//	private JTable producersTable;
	
	private JTable softwareTable;
	
//	private ProducerTableModel producersTableModel;
	
	private SoftwareTableModel softwareTableModel;
	
	private JButton bShowAllProd = new JButton("Show All");
	
	private JButton bShowAllLicence = new JButton("Licence");
	
	private JButton bCreateSoft = new JButton("Create");
	
	private JButton bUpdateSoft = new JButton("Update");
	
	private JButton bDeleteSoft = new JButton("Delete");
	
	private JButton bPrint = new JButton("Print");
	
	private JButton bReport = new JButton("Repotr");
	
	private NewSoftwareForm newSoftwareForm = new NewSoftwareForm();
	
	private ProducersForm producersForm = new ProducersForm();
	
	private LicencesForm licencesForm = new LicencesForm();


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	public MainForm(){
		getContentPane().setLayout(new BorderLayout());
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		JMenuItem menuItem = new JMenuItem("New");
		menuItem.setName(ALL_STUDENTS);
		menuItem.addActionListener(this);
		// Вставляємо пункт меню у випадаюче меню
		menu.add(menuItem);
		// Вставляємо випадаюче меню в рядок меню
		menuBar.add(menu);
		
		setJMenuBar(menuBar);
		
		// Створюємо нижню панель і задаємо їй layout
		JPanel bot = new JPanel();
		bot.setLayout(new BorderLayout());

		// Створюємо ліву панель для виведення списку груп
		JPanel left = new JPanel();
		// Задаємо layout і задаємо "бордюр" навколо панелі
		left.setLayout(new BorderLayout());
		left.setBorder(new BevelBorder(BevelBorder.RAISED));

		// Отримуємо список виробників
		//List<Producer> producers = Producer.all();
		// Створюємо напис
		left.add(new JLabel("Producers:"), BorderLayout.NORTH);
		// Створюємо візуальний список і вставляємо його в скролінговану
		// панель, яку у свою чергу кладемо на панель left
		loadProducersList();
		
		left.add(new JScrollPane(prodList), BorderLayout.CENTER);
		left.add(bShowAllProd, BorderLayout.SOUTH);
				
		// Створюємо праву панель для виведення списку студентів
		JPanel right = new JPanel();
		// Задаємо layout і задаємо "бордюр" навколо панелі
		right.setLayout(new BorderLayout());
		right.setBorder(new BevelBorder(BevelBorder.RAISED));				
				
		softwareTableModel = new SoftwareTableModel(Software.all());
		softwareTable = new JTable(softwareTableModel);
		softwareTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		softwareTable.setPreferredScrollableViewportSize(new Dimension(880, 180));
		softwareTable.getColumnModel().getColumn(0).setMinWidth(25);
		softwareTable.getColumnModel().getColumn(1).setMinWidth(100);
		softwareTable.getColumnModel().getColumn(2).setMinWidth(50);
		softwareTable.getColumnModel().getColumn(3).setMinWidth(100);
		softwareTable.getColumnModel().getColumn(4).setMinWidth(60);
		softwareTable.getColumnModel().getColumn(5).setMinWidth(50);
		softwareTable.getColumnModel().getColumn(6).setMinWidth(50);
		softwareTable.getColumnModel().getColumn(7).setMinWidth(100);
		softwareTable.setGridColor(Color.ORANGE);
		softwareTable.setRowHeight(20);
		softwareTable.setRowHeight(40);
		Font FontGrid = new Font(Font.SANS_SERIF, Font.PLAIN, 14);
		softwareTable.setFont(FontGrid);
		JScrollPane scrollPane = new JScrollPane(softwareTable);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
				
		JPanel bottom = new JPanel();
		JPanel nav = new JPanel();
			
		bottom.setLayout(new BorderLayout());
		nav.setLayout(new FlowLayout());
				
		nav.add(bDeleteSoft);
		nav.add(bUpdateSoft);
		nav.add(bReport);
		nav.add(bPrint);
		nav.add(bCreateSoft);
		
		bottom.add(nav, BorderLayout.CENTER);
		bottom.add(bShowAllLicence, BorderLayout.EAST);
				
		right.add(scrollPane, BorderLayout.CENTER);
		right.add(bottom, BorderLayout.SOUTH);
				
		bot.add(left, BorderLayout.WEST);
		bot.add(right, BorderLayout.CENTER);

		// Вставляємо верхню і нижню панелі у форму
		//getContentPane().add(scrollPane2, BorderLayout.NORTH);
		getContentPane().add(bot, BorderLayout.CENTER);
		// Задаємо межі форми
		setBounds(100, 100, 1000, 400);
				
		bShowAllProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				producersForm.setVisible(true);
			}
		});
		bShowAllLicence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				licencesForm.setVisible(true);
			}
		});
		bCreateSoft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createSoftware();
			}
		});
		bUpdateSoft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateSoftware();
			}
		});
		bDeleteSoft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeSoftware();
			}
		});
		bPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printSoftware();
			}
		});
		bReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					reportSoftware();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
	
	private void printSoftware() {
		try {
			MessageFormat headerFormat = new MessageFormat("Page {0}");
			MessageFormat footerFormat = new MessageFormat("- {0} -");
			softwareTable.print(JTable.PrintMode.FIT_WIDTH, headerFormat,
					footerFormat);
		} catch (PrinterException pe) {
			System.err.println("You can not print the document because: "
					+ pe.getMessage());
		}
	}
	
	private void reportSoftware() throws IOException {
		String fileName = JOptionPane.showInputDialog ("Enter file name...");
		if(fileName != null){
			if(!fileName.equals("")){
				Date d = new Date();
		        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh:mm");
				BufferedWriter bfw = new BufferedWriter(new FileWriter(fileName+".txt"));
				for(int i = 0 ; i < softwareTable.getColumnCount() ; i++)
				{
					bfw.write(String.format("%30s",softwareTable.getColumnName(i)));
					bfw.write("|");
				}
				bfw.newLine();
				for (int i = 0 ; i < softwareTable.getRowCount(); i++)
				{
					bfw.newLine();
				    for(int j = 0 ; j < softwareTable.getColumnCount();j++)
					{
				    	bfw.write((String)(String.format("%30s",softwareTable.getValueAt(i,j))));
				    	bfw.write("|");
					}
				    System.out.println("\r\n");
				}
				bfw.newLine();
				bfw.newLine();
				bfw.write("Date: "+format.format(d));
				JOptionPane.showMessageDialog(MainForm.this, "The report was successfully generated!", "Success", JOptionPane.DEFAULT_OPTION );
				bfw.close();
			}else JOptionPane.showMessageDialog(MainForm.this, "File name can't be blank!", "Error", JOptionPane.DEFAULT_OPTION );
		}
			
	}
	
	private void createSoftware() {
		newSoftwareForm.setSoftware(new Software());
		newSoftwareForm.setVisible(true);
		if (newSoftwareForm.getSoftware().getSoftwareId() != null) {
			softwareTableModel.addSoftware(newSoftwareForm.getSoftware());
			JOptionPane.showMessageDialog(MainForm.this, "Record was successfully created!", "Success", JOptionPane.DEFAULT_OPTION );
		}
	}
	
	private void updateSoftware() {
		int index = softwareTable.getSelectedRow();
		if (index == -1){
			JOptionPane.showMessageDialog(MainForm.this, "Do not select any field, please select field!", "Error", JOptionPane.DEFAULT_OPTION );
			return;
		}
		Software software = softwareTableModel.getRowSoftware(index);
		if (software != null) {
			newSoftwareForm.setSoftware(software);
			newSoftwareForm.setVisible(true);
			softwareTableModel.refreshUpdatedTable();
//			JOptionPane.showMessageDialog(MainForm.this, "Record was successfully updated!", "Success", JOptionPane.DEFAULT_OPTION );
		}
	}
	
	private void removeSoftware() {
		int index = softwareTable.getSelectedRow();
		if (index == -1){
			JOptionPane.showMessageDialog(MainForm.this, "Do not select any field, please select field!", "Error", JOptionPane.DEFAULT_OPTION );
			return;
		}
		if (JOptionPane.showConfirmDialog(MainForm.this,
				"Are you sure you want to delete this software?",
				"Removing sowtware", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			try {
				Software s = softwareTableModel.getRowSoftware(index);
				if (s != null) {
					if(s.delete()){
						softwareTableModel.removeRow(index);
						JOptionPane.showMessageDialog(MainForm.this, "Record was successfully deleted!", "Success", JOptionPane.DEFAULT_OPTION );
					}
					else 
						JOptionPane.showMessageDialog(MainForm.this, "You can not remove record!", "Error", JOptionPane.DEFAULT_OPTION );
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(MainForm.this, e.getMessage());
			}
		}
	}
	
	private void loadProducersList(){
		listModel.clear();
		for (Producer p : Producer.all()) {
			listModel.addElement(p.getName());
		}
		
		prodList = new JList(listModel);
	}
	
//	private ProducerTableModel getTableModel() {
//		try {
//			return new ProducerTableModel(Producer.all());
//		} catch (Exception e) {
//			e.printStackTrace();
//			JOptionPane.showMessageDialog(this,
//					"Помилка при заповненні таблиці груп: " + e.getMessage());
//		}
//		return new ProducerTableModel(new ArrayList<Producer>(0));
//	}
	
	public static void main(String[] args) {
		
		MainForm mForm = new MainForm(); 

		mForm.setVisible(true);
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		mForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
