package model;

import java.util.List;

import dao.SoftwareDao;

public class Software implements Item {
	
	private Integer softwareId;
	private String name;
	private String iconPath;
	private String version;
	private boolean osWindows;
	private boolean osUnix;
	private boolean osMac;
	private String releaseDate;//змінити тип дати і додати гетер і сетер!!!!!
	private Integer producerId;
	private static SoftwareDao dao = new SoftwareDao();
	
	public Integer getSoftwareId() {
		return softwareId;
	}
	public void setSoftwareId(Integer softwareId) {
		this.softwareId = softwareId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIconPath() {
		return iconPath;
	}
	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public boolean isOsWindows() {
		return osWindows;
	}
	public void setOsWindows(boolean osWindows) {
		this.osWindows = osWindows;
	}
	public boolean isOsUnix() {
		return osUnix;
	}
	public void setOsUnix(boolean osUnix) {
		this.osUnix = osUnix;
	}
	public boolean isOsMac() {
		return osMac;
	}
	public void setOsMac(boolean osMac) {
		this.osMac = osMac;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Integer getProducerId() {
		return producerId;
	}
	public void setProducerId(Integer producerId) {
		this.producerId = producerId;
	}
	public int create(String name, String iconPath, String version, boolean osWindows, boolean osUnix, boolean osMac, String releaseDate, Integer producerId){
		this.name = name;
		this.iconPath = iconPath;
		this.version = version;
		this.osWindows = osWindows;
		this.osUnix = osUnix;
		this.osMac = osMac;
		this.releaseDate = releaseDate;
		this.producerId = producerId;
		return this.save();
	}
	@Override
	public int save(){
		try {
			this.softwareId = dao.insertSoftware(this);
			return this.softwareId;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	@Override
	public boolean update(){
		try {
			dao.updateSoftware(this);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean delete(){
		try {
			dao.deleteSoftware(this.softwareId);
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
	public int addLicence(Licence l){
		Ref ref = new Ref();
		return ref.create(this.softwareId, l.getLicenceId());
	}
	
	public static List<Software> all(){
		List<Software> all = null;
		try {
			all = dao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return all;
	}

}
