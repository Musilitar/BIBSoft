package dao;

public class Top10Hulp implements Comparable<Object> {

	String title;
	 int amount;
	 int Id;
	 
	public Top10Hulp(String title, int amount) {
		super();
		setTitle(title);
		setAmount(amount);
		setId(0);
	}
	
	public Top10Hulp(int counter, int id)
	{
		super();
		setTitle("consturctor voor top10 members");
		setAmount(counter);
		setId(id);
	}
	
	public Top10Hulp()
	{
		super();
		setTitle("helaas, niet genoeg informatie om een top 10 te vormen");
		setAmount(-5);
		setId(0);
	}
	
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public int compareTo(Object compareTop10) {
		 
		int compareAmount = ((Top10Hulp) compareTop10).getAmount();
		
		return compareAmount - this.amount;
 
	}	
}
