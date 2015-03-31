package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		/*Producer p = new Producer();
		p.setProducerId(1);
		p.setName("SoftServe");
		p.setCountry("Ukraine");
		p.setCity("IF");
		p.setStreet("Vovch 21");
		p.setEmail("dsf@dd.ua");
		p.setWebSite("job.ua");
		p.setTelephone("0995465345");
		System.out.println(p.update());*/
//		Software p = new Software();
//		//p.create("FileFinder", "\\icon\\1.png", "1.0", true, true, false, "01.03.2015", 1);
//		p.setSoftwareId(1);
//		p.setName("Program1");
//		p.setIconPath("\\icon\\1.png");
//		p.setVersion("1.0");
//		p.setOsWindows(true);
//		p.setOsUnix(true);
//		p.setOsMac(false);
//		p.setReleaseDate("2015.04.14");
//		p.setProducerId(1);
//		p.update();
//		System.out.println(p.getName());
//		Producer prod = new Producer();
//		prod.create("Eleks", "Ua", "IF", "Troleibusna", "info@eleks.ua","www.elex.com", "67 33 55");
//		List<Producer> p = ;
		long startTime = System.currentTimeMillis();
//		
//		for (Producer p : Producer.all()) {
//			System.out.println(p.getName());
//		}
		
		Producer p = new Producer();
		p.setName("Net");
		p.setCountry("Ukraine");
		p.setCity("IF");
		p.setStreet("Vovch 21");
		p.setEmail("dsf@dd.ua");
		p.setWebSite("job.ua");
		p.setTelephone("0995465345");
		System.out.println(p.save());
		//System.out.println(p.getProducerId());
		
		long timeSpent = System.currentTimeMillis()-startTime;
		
		System.out.println("программа выполнялась " + timeSpent + " миллисекунд");
		

/* Робота з датою
		Calendar c = new GregorianCalendar(2013, 11, 25);
		Date hireDay = c.getTime();
		SimpleDateFormat f = new SimpleDateFormat("dd.MM.yyyy");
		String s = f.format(hireDay);
		System.out.println(c.get(Calendar.YEAR)+"."+c.get(Calendar.MONTH)+"."+c.get(Calendar.DATE));
*/
	}

}
