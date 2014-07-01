package test;

import logic.Adress;

import org.junit.Test;

public class AdressTesting {
	//reactive in logic constructor the if else for test if correct regex

	// http://docs.oracle.com/javase/1.4.2/docs/api/java/util/regex/Pattern.html
	@Test
	public void test1() {
		Adress a1 = new Adress("17","Kingstreet","Anderlecht","16",1070,17);
	}
	
	@Test
	public void test2() {
		Adress a1 = new Adress("17","King-Bergenstreet","Sint-Pieters-Leeuw","1",1070,17);
	}
	
	@Test
	public void test3() {
		Adress a1 = new Adress("17","King street","New York","1600",1070,17);
	}
	
	
	@Test
	public void testerror1() {
		Adress a1 = new Adress("17","kingstreet","anderlecht","-16",1070,17);
	}
	
	@Test
	public void testerror2() {
		Adress a1 = new Adress("17","ki...","Ant444","100006",1070,17);
	}

	@Test
	public void testerror3() {
		Adress a1 = new Adress("17","","An*loet","0",1070,17);
	}
	
	
}
