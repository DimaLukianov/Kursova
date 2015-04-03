package model;

import dao.RefDao;

public class Ref implements Item {
	
	private Integer refId;
	private Integer softwareId;
	private Integer licenceId;
	private RefDao dao = new RefDao();
	
	public Integer getRefId() {
		return refId;
	}
	public void setRefId(Integer refId) {
		this.refId = refId;
	}
	public Integer getSoftwareId() {
		return softwareId;
	}
	public void setSoftwareId(Integer softwareId) {
		this.softwareId = softwareId;
	}
	public Integer getLicenceId() {
		return licenceId;
	}
	public void setLicenceId(Integer licenceId) {
		this.licenceId = licenceId;
	}
	
	public int create(Integer softwareId, Integer licenceId){
		
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
