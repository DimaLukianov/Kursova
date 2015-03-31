package view;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Licence;

public class LicenceTableModel extends AbstractTableModel {

	private static final long serialVersionUID = -2677658636846257452L;

	private String[] columns = new String[] { "ID", "Name",
			"Type", "Period", "Price" };

	private List<Licence> licence;

	public LicenceTableModel(List<Licence> licence) {
		this.licence = licence;
	}

	public void addLicence(Licence licence) {
		this.licence.add(licence);
		fireTableRowsInserted(0, this.licence.size());
	}

	public Licence getRowLicence(int rowIndex) {
		return licence.get(rowIndex);
	}

	public void removeRow(int rowIndex) {
		licence.remove(rowIndex);
		fireTableRowsDeleted(rowIndex, rowIndex);
	}

	public void refreshUpdatedTable() {
		fireTableRowsUpdated(0, licence.size());
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Licence l = licence.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return Integer.toString(l.getLicenceId());
		case 1:
			return l.getName();
		case 2:
			return l.getType();
		case 3:
			return l.getPeriod();
		case 4:
			return l.getPrice();
		}
		return "";
	}

	public int getRowCount() {
		return licence.size();
	}

	public String getColumnName(int columnIndex) {
		return columns[columnIndex];
	}

	public int getColumnCount() {
		return columns.length;
	}

	public Class<?> getColumnClass(int columnIndex) {
		return getValueAt(0, columnIndex).getClass();
	}
}
