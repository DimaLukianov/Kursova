package model;

import java.util.List;

import dao.ProducerDao;

public class Producer implements Item {
	
	private Integer producerId;
	private String name;
	private String country;
	private String city;
	private String street;
	private String email;
	private String webSite;
	private String telephone;
	private static ProducerDao dao = new ProducerDao();
	
	public Integer getProducerId() {
		return producerId;
	}
	public void setProducerId(int producerId) {
		this.producerId = producerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWebSite() {
		return webSite;
	}
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public int create(String name, String country, String city, String street, String email, String webSite, String telephone){
		this.name = name;
		this.country = country;
		this.city = city;
		this.street = street;
		this.email = email;
		this.telephone = telephone;
		return this.save();
	}
	@Override
	public int save(){
		try {
			this.producerId = dao.insertProducer(this);
			return this.producerId;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	@Override
	public boolean update(){
		try {
			dao.updateProducer(this);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean delete(){
		try {
			dao.deleteProducer(this.producerId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}	
	}
	public static Item findById(int id) {
		try {
			return dao.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<Producer> all(){
		List<Producer> all = null;
		try {
			all = dao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return all;
	}

}
