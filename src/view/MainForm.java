package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
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
	
	private NewProducerForm newProducerForm = new NewProducerForm();
	
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
//				// Отримуємо список студентів
//				List<Software> software = Software.all();
//				// // Створюємо напис
//				right.add(new JLabel("Software:"), BorderLayout.NORTH);
//				// Створюємо візуальний список і вставляємо його в скролінговану
//				// панель, яку у свою чергу кладемо на панель right
//				//softList = new JList((ListModel) software);
//				
//				for (Software s : Software.all()) {
//					listModel2.addElement(s.getName()+" "+s.getReleaseDate()+" "+s.getVersion());
//				}
//				
//				softList = new JList(listModel2);
//				
//				right.add(new JScrollPane(softList), BorderLayout.CENTER);
//				// Вставляємо панелі зі списками груп і студентів в нижню панель
				
				//таблиця компаній
//				producersTableModel = getTableModel();
//				producersTable = new JTable(producersTableModel);
//				producersTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//				producersTable.setPreferredScrollableViewportSize(new Dimension(880, 180));
//				producersTable.getColumnModel().getColumn(0).setMinWidth(25);
//				producersTable.getColumnModel().getColumn(1).setMinWidth(100);
//				producersTable.getColumnModel().getColumn(2).setMinWidth(150);
//				producersTable.getColumnModel().getColumn(3).setMinWidth(100);
//				producersTable.getColumnModel().getColumn(4).setMinWidth(150);
//				producersTable.getColumnModel().getColumn(5).setMinWidth(150);
//				producersTable.getColumnModel().getColumn(6).setMinWidth(120);
//				producersTable.getColumnModel().getColumn(7).setMinWidth(100);
//				producersTable.setGridColor(Color.ORANGE);
//				producersTable.setRowHeight(20);
//				Font FontGrid = new Font(Font.MONOSPACED, Font.PLAIN, 14);
//				producersTable.setFont(FontGrid);
//
//				JScrollPane scrollPane = new JScrollPane(producersTable);
//				scrollPane.setOpaque(false);
//				scrollPane.getViewport().setOpaque(false);
				
				
				
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
						
						//JOptionPane.showMessageDialog( null, "Show all producers", "Producers", JOptionPane.DEFAULT_OPTION );
					}
				});
				bShowAllLicence.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						licencesForm.setVisible(true);
					}
				});
				bCreateSoft.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						createProducer();
						JOptionPane.showMessageDialog( null, "Create new software", "New", JOptionPane.DEFAULT_OPTION );
					}
				});
				bUpdateSoft.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog( null, "Update software", "Update", JOptionPane.DEFAULT_OPTION );
					}
				});
				bDeleteSoft.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog( null, "Delete software", "Delete", JOptionPane.DEFAULT_OPTION );
					}
				});
				bPrint.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						printSoftware();
					}
				});
	}
	
	public static void main(String[] args) {
		
		MainForm mForm = new MainForm(); 

		mForm.setVisible(true);
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		mForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
	
	private void createProducer() {
		newProducerForm.setProducer(new Producer());
		newProducerForm.setVisible(true);
		if (newProducerForm.getProducer().getProducerId() != null) {
			//groupsTableModel.addGroup(newGroup.getGroup());
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
	

}
