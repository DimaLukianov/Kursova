package model;

public interface Item {
	public int save();
	public boolean update();
	public boolean delete();
	public Item findById(int id);

}
