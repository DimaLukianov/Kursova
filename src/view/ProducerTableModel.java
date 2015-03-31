package view;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Producer;

public class ProducerTableModel extends AbstractTableModel {

	private static final long serialVersionUID = -2677658636846257452L;

	private String[] columns = new String[] { "ID", "Name",
			"Country", "City", "Street", "Email", "Web site", "Telephone" };

	private List<Producer> producers;

	public ProducerTableModel(List<Producer> producers) {
		this.producers = producers;
	}

	public void addProducer(Producer producer) {
		producers.add(producer);
		fireTableRowsInserted(0, producers.size());
	}

	public Producer getRowGroup(int rowIndex) {
		return producers.get(rowIndex);
	}

	public void removeRow(int rowIndex) {
		producers.remove(rowIndex);
		fireTableRowsDeleted(rowIndex, rowIndex);
	}

	public void refreshUpdatedTable() {
		fireTableRowsUpdated(0, producers.size());
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Producer p = producers.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return Integer.toString(p.getProducerId());
		case 1:
			return p.getName();
		case 2:
			return p.getCountry();
		case 3:
			return p.getCity();
		case 4:
			return p.getStreet();
		case 5:
			return p.getEmail();
		case 6:
			return p.getWebSite();
		case 7:
			return p.getTelephone();
		}
		return "";
	}

	public int getRowCount() {
		return producers.size();
	}

	public String getColumnName(int columnIndex) {
		return columns[columnIndex];
	}

	public int getColumnCount() {
		return columns.length;
	}

	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}
}
