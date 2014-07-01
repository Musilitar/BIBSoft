package logic;




public class Staff extends Person{


	private String function;
	private Login login;
	
	
	public Staff(String name, String surname, String function, Login login) {
		super(name, surname);
		this.function = function;
		this.login = login;
		
		
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	
}
