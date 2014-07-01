package logic;

public abstract class Person {
	
	private String name, surname;

	//validate name 
		public static boolean validateFirstName( String firstName )
		   {
		      return firstName.matches( "[a-zA-Z]{2,20}+([ -][a-zA-Z]+)*" );
		   } // end method validateFirstName

		   
		// validate last name
		public static boolean validateSurname( String surname )
		   {
		      return surname.matches( "[a-zA-z]{2,25}+([ '-][a-zA-Z]+)*" );
		   } 
		   
		
		 
		   
	public Person(String name, String surname) {
		super();
		this.name = name;
		//if(validateFirstName(name)==false)
		//	System.out.println("Voornaam is niet correct ingevuld");
		//else System.out.println("Voornaam is correct ingevuld");
		
		this.surname = surname;
		//if(validateSurname(surname)==false)
		//	System.out.println("Naam is niet correct ingevuld");
		//else System.out.println("Naam is correct ingevuld");
		
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getSurname() {
		return surname;
	}



	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	

}
