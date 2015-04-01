package view;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

import model.Software;

public class SoftwareTableModel extends AbstractTableModel {

	
	private static final long serialVersionUID = 1L;

	private String[] columns = new String[] { "ID", "Name",
			"Icon", "Version", "Windows", "Unix", "Mac", "Release Date" };

	private List<Software> software;

	public SoftwareTableModel(List<Software> software) {
		this.software = software;
	}

	public void addSoftware(Software soft) {
		software.add(soft);
		fireTableRowsInserted(0, software.size());
	}

	public Software getRowSoftware(int rowIndex) {
		return software.get(rowIndex);
	}

	public void removeRow(int rowIndex) {
		software.remove(rowIndex);
		fireTableRowsDeleted(rowIndex, rowIndex);
	}

	public void refreshUpdatedTable() {
		fireTableRowsUpdated(0, software.size());
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Software s = software.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return Integer.toString(s.getProducerId());
		case 1:
			return s.getName();
		case 2:
			return new ImageIcon(((new ImageIcon(s.getIconPath())).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
		case 3:
			return s.getVersion();
		case 4:
			return s.isOsWindows();
		case 5:
			return s.isOsUnix();
		case 6:
			return s.isOsMac();
		case 7:
			return s.getReleaseDate();
		}
		return "";
	}

	public int getRowCount() {
		return software.size();
	}

	public String getColumnName(int columnIndex) {
		return columns[columnIndex];
	}

	public int getColumnCount() {
		return columns.length;
	}

	public Class<?> getColumnClass(int columnIndex) {
		//return String.class;
		return getValueAt(0, columnIndex).getClass();
	}

}

