package view;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Record;

public class RecordsTableModel extends AbstractTableModel {

	private static final long serialVersionUID = -2677658636846257452L;

	private String[] columns = new String[] { "ID", "Software", "Icon",
			"Producer", "License", "Price($)" };

	private List<Record> record;

	public RecordsTableModel(List<Record> record) {
		this.record = record;
	}

	public void addLicence(Record record) {
		this.record.add(record);
		fireTableRowsInserted(0, this.record.size());
	}

	public Record getRowLicence(int rowIndex) {
		return record.get(rowIndex);
	}

	public void removeRow(int rowIndex) {
		record.remove(rowIndex);
		fireTableRowsDeleted(rowIndex, rowIndex);
	}

	public void refreshUpdatedTable() {
		fireTableRowsUpdated(0, record.size());
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Record r = record.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return r.getRef().getRefId();
		case 1:
			return "  "+r.getSoftware().getSoftwareId()+"# "+r.getSoftware().getName();
		case 2:
			return r.getSoftware().getImage();
		case 3:
			return "  "+r.getProducer().getProducerId()+"# "+r.getProducer().getName();
		case 4:
			return  "  "+r.getLicence().getLicenceId()+"# "+r.getLicence().getName();
		case 5:
			return  r.getLicence().getPrice();
		}
		return "";
	}

	public int getRowCount() {
		return record.size();
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

