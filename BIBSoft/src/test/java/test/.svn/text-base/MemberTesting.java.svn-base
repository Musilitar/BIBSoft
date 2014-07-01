package test;

import logic.Adress;
import logic.Member;

import org.junit.Test;

public class MemberTesting {

	
		@Test
		public void test1() {
			Adress a1 = new Adress("17","Kingstreet","Anderlecht","16",1070,17);
			Member m1 = new Member("Thomas", "De smeth", "047947299", a1, 17);
		}
		@Test
		public void test2() {
			Adress a1 = new Adress("17","Kingstreet","Anderlecht","16",1070,17);
			Member m1 = new Member("Jean-jaques", "Van d'en archi-log", "+3447947299", a1,17);
		}
		@Test
		public void testerror1() {
			Adress a1 = new Adress("17","Kingstreet","Anderlecht","16",1070,17);
			Member m1 = new Member("Jean Jaques", "van d'en archi-log", "+344 79472 99", a1,17);
		}
		
		
	

}
