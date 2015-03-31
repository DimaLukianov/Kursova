package model;

import dao.RefDao;

public class Ref implements Item {
	
	private int refId;
	private int softwareId;
	private int licenceId;
	private RefDao dao = new RefDao();
	
	public int getRefId() {
		return refId;
	}
	public void setRefId(int refId) {
		this.refId = refId;
	}
	public int getSoftwareId() {
		return softwareId;
	}
	public void setSoftwareId(int softwareId) {
		this.softwareId = softwareId;
	}
	public int getLicenceId() {
		return licenceId;
	}
	public void setLicenceId(int licenceId) {
		this.licenceId = licenceId;
	}
	
	public int create(int softwareId, int licenceId){
		
		this.softwareId = softwareId;
		this.licenceId = licenceId;
		return this.save();
	}
	@Override
	public int save(){
		try {
			this.refId = dao.insertRef(this);
			return this.refId;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	@Override
	public boolean update(){
		try {
			dao.updateRef(this);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean delete(){
		try {
			dao.deleteRef(this.refId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}	
	}
	@Override
	public Item findById(int id) {
		try {
			return dao.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
