package model;

import java.util.List;

import dao.AllInfoDao;

public class Record {
	
	private Software software = new Software();
	
	private Producer producer = new Producer();
	
	private Licence licence = new Licence();
	
	private Ref ref = new Ref();
	
	private static AllInfoDao dao = new AllInfoDao();

	public Software getSoftware() {
		return software;
	}

	public void setSoftware(Software software) {
		this.software = software;
	}

	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}

	public Licence getLicence() {
		return licence;
	}

	public void setLicence(Licence licence) {
		this.licence = licence;
	}
	

	public Ref getRef() {
		return ref;
	}

	public void setRef(Ref ref) {
		this.ref = ref;
	}
	
	public int addRef(Integer softwareId, Integer licenceId){
		return this.ref.create(softwareId, licenceId);
	}
	
	public boolean delete(){
		return this.ref.delete();
	}
	
	public static Record findById(int id) {
		try {
			return dao.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<Record> all(){
		List<Record> all = null;
		try {
			all = dao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return all;
	}

}
