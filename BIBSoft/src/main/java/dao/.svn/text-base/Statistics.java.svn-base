package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;





public class Statistics {
	
	private static Connection conn = DatabaseConnection.getConnection();
	
	public static int RentsPerMonth(String monthYear)
	{
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		int x =0;
		//ophalen van de data uit de db. deze statement geeft alle transacties terug die "mm/jjjj" formaat hebben. Dus enkel de maand en het jaar met het "/" teken inbegrepen.
		try {
			PreparedStatement stmnt = conn.prepareStatement("SELECT COUNT(*) AS total FROM RentTransactions WHERE  RIGHT(date_out, 7) = ? ");
			stmnt.setString(1, monthYear );
			ResultSet res;
			res = stmnt.executeQuery();
			while(res.next()){
				x = res.getInt("total");
			}
		}
			catch(SQLException e){
				e.printStackTrace();
				
				
			}
		
		return x;
		
		
		
	}
	
	public static float AvgRentsPerMonth(int month, int year, int endMonth, int endYear)
	{
		//Bij deze kon ik het niet allemaal in de statement steken daarmee heb ik het gedeeltelijk in code gedaan
		ArrayList<Integer> avg = new ArrayList<Integer>();
		float x=0;
	
		
		//deze lus loopt de maanden en jaren af. Bij een maand zoals bv 02 zal dit omgevormd worden naar 2 dus daarom een onderscheid 
		//in de for loop tussen de 2 cijferige getallen en de 1 cijfigere Ik maak ook gebruik van de functie rentPermonth.
		for(int y = year; y <= endYear; y++)
		{
			
			for (int m = month; m <= 12; m++) {
				


				if(m == 0)
				{
					m++;
				}
				
			
				if(m <= 9 )
				{
					avg.add(RentsPerMonth("0" + String.valueOf(m) + "/" + String.valueOf(y)));
					
				}
				else
					{
						avg.add(RentsPerMonth(String.valueOf(m) + "/" + String.valueOf(y)));
					}
				
				if(m == endMonth && y == endYear)
					break;
				
				if(m ==12)
				{ 
									
						month=1;
						break;
					
				}
				
				
			}
		
			
		}
			//just incase er geen uitleningen waren die maand
			if(avg.isEmpty())
			{
				System.out.println("There are no rentouts in this period.");;
			}
			else
			{	
				//tellen van de hoeveelheid uitleningen in de periode
				for (int i = 0; i < avg.size(); i++) {
					
					x += avg.get(i);
				}
			}
			
		return x/(avg.size());
	}
		
	public static ArrayList<String> top10BooksRented()
	{
		
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		ArrayList<String> bookList = new ArrayList<String>();
		ArrayList<Top10Hulp> t10 = new ArrayList<Top10Hulp>();
		ArrayList<String> bookListTop10 = new ArrayList<String>();
		
		//init met default waarden
				for(int i =0; i<10; i++)
				{
					t10.add(new Top10Hulp());
				}
				
			//hier haal ik de titel op van de boeken die voorkomen in de rentals tabel.
		try {
			Statement stmnt = conn.createStatement();
			String sql = "SELECT title FROM Books b , BookCopies c , Rentals r WHERE r.product_id = c.copy_id AND r.type= 'boek' AND b.book_id = c.book_id";
			ResultSet res = stmnt.executeQuery(sql);

			while(res.next()) {
			
				bookList.add(res.getString("title"));
				
			}

		}
		catch(SQLException e) {
			System.out.println(e);
		}

		int counter =0;//counter om te tellen hoeveel keer een boek voorkomt, hulpvariabele
		boolean checkT10= false;
		
		
		for(int i=0; i<bookList.size(); i++)
		{
			//in deze loop kijken we hoeveel keer eenzelfde product voorkomt in de lijst
			for(int j=0; j<bookList.size(); j++)
			{
				if(bookList.get(j).equals(bookList.get(i)))
				{
					System.out.println(bookList.get(j));
					counter++;
					System.out.println(counter);
					
				}
				
				
			}
			
			for(int k = 0; k < t10.size(); k++)
				{
					if(t10.get(k).getAmount() == -5)
						checkT10 = true;
				}
			if(checkT10 == true)
				System.out.println(checkT10);
			{
				//berekening met default waarden in de tabel
				for (Top10Hulp t : t10) {
					
					if(t.getTitle().equals(bookList.get(i)))
						break;
					
					if(t.getAmount() == -5)
					{
						t.setAmount(counter);
						t.setTitle(bookList.get(i));
						break;
					}
				}
				
			}
			
			if(checkT10 == false)
			{
				//berekening zonder default waarden in de tabel
				for (Top10Hulp t : t10) {
					
					if(t.getTitle().equals(bookList.get(i)))
						break;
					
					if(t.getAmount() < counter)
					{
						t.setAmount(counter);
						t.setTitle(bookList.get(i));
						break;
					}
					
				}
			}
			
			counter=0;
			checkT10=false;
			System.out.println(counter);
		}
		
		Collections.sort(t10);
		
		for (Top10Hulp x : t10) {
			
			bookListTop10.add(x.getTitle());
		
		}
		
		return bookListTop10;
	}
		
	public static ArrayList<String> top10BooksReserved()
	{
		
			try {
				   if(conn == null || conn.isClosed()){
				    conn = DatabaseConnection.getConnection();
				   }
				  } catch (SQLException e1) {
				   // TODO Auto-generated catch block
				   e1.printStackTrace();
				  }
			
			ArrayList<String> bookList = new ArrayList<String>();
			ArrayList<Top10Hulp> t10 = new ArrayList<Top10Hulp>();
			ArrayList<String> bookListTop10 = new ArrayList<String>();
			
			//init met default waarden
					for(int i =0; i<10; i++)
					{
						t10.add(new Top10Hulp());
					}
					
				
			try {
				Statement stmnt = conn.createStatement();
				String sql = "SELECT title FROM Books b , Reservations r WHERE r.product_id = b.book_id AND r.type= 'boek'";
				ResultSet res = stmnt.executeQuery(sql);

				while(res.next()) {
				
					bookList.add(res.getString("title"));
					
				}

			}
			catch(SQLException e) {
				System.out.println(e);
			}

			int counter =0;//counter om te tellen hoeveel keer een boek voorkomt, hulpvariabele
			boolean checkT10= false;
			
			
			for(int i=0; i<bookList.size(); i++)
			{
				//in deze loop kijken we hoeveel keer eenzelfde product voorkomt in de lijst
				for(int j=0; j<bookList.size(); j++)
				{
					if(bookList.get(j).equals(bookList.get(i)))
					{
						System.out.println(bookList.get(j));
						counter++;
						System.out.println(counter);
						
					}
					
					
				}
				
				for(int k = 0; k < t10.size(); k++)
					{
						if(t10.get(k).getAmount() == -5)
							checkT10 = true;
					}
				if(checkT10 == true)
					System.out.println(checkT10);
				{
					//berekening met default waarden in de tabel
					for (Top10Hulp t : t10) {
						
						if(t.getTitle().equals(bookList.get(i)))
							break;
						
						if(t.getAmount() == -5)
						{
							t.setAmount(counter);
							t.setTitle(bookList.get(i));
							break;
						}
					}
					
				}
				
				if(checkT10 == false)
				{
					//berekening zonder default waarden in de tabel
					for (Top10Hulp t : t10) {
						
						if(t.getTitle().equals(bookList.get(i)))
							break;
						
						if(t.getAmount() < counter)
						{
							t.setAmount(counter);
							t.setTitle(bookList.get(i));
							break;
						}
						
					}
				}
				
				counter=0;
				checkT10=false;
				System.out.println(counter);
			}
			
			Collections.sort(t10);
			
			for (Top10Hulp x : t10) {
				
				bookListTop10.add(x.getTitle());
			
			}
			
			return bookListTop10;
	}
	
	public static ArrayList<String> top10DvdRented()
	{
		
		
				try {
					   if(conn == null || conn.isClosed()){
					    conn = DatabaseConnection.getConnection();
					   }
					  } catch (SQLException e1) {
					   // TODO Auto-generated catch block
					   e1.printStackTrace();
					  }
				
				ArrayList<String> dvdList = new ArrayList<String>();
				ArrayList<Top10Hulp> t10 = new ArrayList<Top10Hulp>();
				ArrayList<String> dvdListTop10 = new ArrayList<String>();
				
				//init met default waarden
						for(int i =0; i<10; i++)
						{
							t10.add(new Top10Hulp());
						}
						
				
				try {
					Statement stmnt = conn.createStatement();
					String sql = "SELECT title FROM Media m , MediaCopies c , Rentals r WHERE r.product_id = c.copy_id AND r.type= 'DVD' AND m.media_id = c.media_id";
					ResultSet res = stmnt.executeQuery(sql);

					while(res.next()) {
					
						dvdList.add(res.getString("title"));
						
					}

				}
				catch(SQLException e) {
					System.out.println(e);
				}

				int counter =0;//counter om te tellen hoeveel keer een boek voorkomt, hulpvariabele
				boolean checkT10= false;
				
				
				for(int i=0; i<dvdList.size(); i++)
				{
					//in deze loop kijken we hoeveel keer eenzelfde product voorkomt in de lijst
					for(int j=0; j<dvdList.size(); j++)
					{
						if(dvdList.get(j).equals(dvdList.get(i)))
						{
							System.out.println(dvdList.get(j));
							counter++;
							System.out.println(counter);
							
						}
						
						
					}
					
					for(int k = 0; k < t10.size(); k++)
						{
							if(t10.get(k).getAmount() == -5)
								checkT10 = true;
						}
					if(checkT10 == true)
						System.out.println(checkT10);
					{
						//berekening met default waarden in de tabel
						for (Top10Hulp t : t10) {
							
							if(t.getTitle().equals(dvdList.get(i)))
								break;
							
							if(t.getAmount() == -5)
							{
								t.setAmount(counter);
								t.setTitle(dvdList.get(i));
								break;
							}
						}
						
					}
					
					if(checkT10 == false)
					{
						//berekening zonder default waarden in de tabel
						for (Top10Hulp t : t10) {
							
							if(t.getTitle().equals(dvdList.get(i)))
								break;
							
							if(t.getAmount() < counter)
							{
								t.setAmount(counter);
								t.setTitle(dvdList.get(i));
								break;
							}
							
						}
					}
					
					counter=0;
					checkT10=false;
					System.out.println(counter);
				}
				
				Collections.sort(t10);
				
				for (Top10Hulp x : t10) {
					
					dvdListTop10.add(x.getTitle());
				
				}
				
				return dvdListTop10;
	}
	
	public static ArrayList<String> top10DvdReserved()
	{
		
		
				try {
					   if(conn == null || conn.isClosed()){
					    conn = DatabaseConnection.getConnection();
					   }
					  } catch (SQLException e1) {
					   // TODO Auto-generated catch block
					   e1.printStackTrace();
					  }
				
				ArrayList<String> dvdList = new ArrayList<String>();
				ArrayList<Top10Hulp> t10 = new ArrayList<Top10Hulp>();
				ArrayList<String> dvdListTop10 = new ArrayList<String>();
				
				//init met default waarden
						for(int i =0; i<10; i++)
						{
							t10.add(new Top10Hulp());
						}
						
					
				try {
					Statement stmnt = conn.createStatement();
					String sql = "SELECT title FROM Media b , Reservations r WHERE r.product_id = b.media_id AND r.type= 'DVD'";
					ResultSet res = stmnt.executeQuery(sql);

					while(res.next()) {
					
						dvdList.add(res.getString("title"));
						
					}

				}
				catch(SQLException e) {
					System.out.println(e);
				}

				int counter =0;//counter om te tellen hoeveel keer een prodcut voorkomt, hulpvariabele
				boolean checkT10= false;
				
				
				for(int i=0; i<dvdList.size(); i++)
				{
					//in deze loop kijken we hoeveel keer eenzelfde product voorkomt in de lijst
					for(int j=0; j<dvdList.size(); j++)
					{
						if(dvdList.get(j).equals(dvdList.get(i)))
						{
							System.out.println(dvdList.get(j));
							counter++;
							System.out.println(counter);
							
						}
						
						
					}
					
					for(int k = 0; k < t10.size(); k++)
						{
							if(t10.get(k).getAmount() == -5)
								checkT10 = true;
						}
					if(checkT10 == true)
						System.out.println(checkT10);
					{
						//berekening met default waarden in de tabel
						for (Top10Hulp t : t10) {
							
							if(t.getTitle().equals(dvdList.get(i)))
								break;
							
							if(t.getAmount() == -5)
							{
								t.setAmount(counter);
								t.setTitle(dvdList.get(i));
								break;
							}
						}
						
					}
					
					if(checkT10 == false)
					{
						//berekening zonder default waarden in de tabel
						for (Top10Hulp t : t10) {
							
							if(t.getTitle().equals(dvdList.get(i)))
								break;
							
							if(t.getAmount() < counter)
							{
								t.setAmount(counter);
								t.setTitle(dvdList.get(i));
								break;
							}
							
						}
					}
					
					counter=0;
					checkT10=false;
					System.out.println(counter);
				}
				
				Collections.sort(t10);
				
				for (Top10Hulp x : t10) {
					
					dvdListTop10.add(x.getTitle());
				
				}
				
				return dvdListTop10;
	}
	
	public static ArrayList<String> top10CdRented()

	{
		
		
				try {
					   if(conn == null || conn.isClosed()){
					    conn = DatabaseConnection.getConnection();
					   }
					  } catch (SQLException e1) {
					   // TODO Auto-generated catch block
					   e1.printStackTrace();
					  }
				
				ArrayList<String> cdList = new ArrayList<String>();
				ArrayList<Top10Hulp> t10 = new ArrayList<Top10Hulp>();
				ArrayList<String> cdListTop10 = new ArrayList<String>();
				
				//init met default waarden
						for(int i =0; i<10; i++)
						{
							t10.add(new Top10Hulp());
						}
						
				
				try {
					Statement stmnt = conn.createStatement();
					String sql = "SELECT title FROM Media m , MediaCopies c , Rentals r WHERE r.product_id = c.copy_id AND r.type= 'CD' AND m.media_id = c.media_id";
					ResultSet res = stmnt.executeQuery(sql);

					while(res.next()) {
					
						cdList.add(res.getString("title"));
						
					}

				}
				catch(SQLException e) {
					System.out.println(e);
				}

				int counter =0;//counter om te tellen hoeveel keer een product voorkomt, hulpvariabele
				boolean checkT10= false;
				
				
				for(int i=0; i<cdList.size(); i++)
				{
					//in deze loop kijken we hoeveel keer eenzelfde product voorkomt in de lijst
					for(int j=0; j<cdList.size(); j++)
					{
						if(cdList.get(j).equals(cdList.get(i)))
						{
							System.out.println(cdList.get(j));
							counter++;
							System.out.println(counter);
							
						}
						
						
					}
					
					for(int k = 0; k < t10.size(); k++)
						{
							if(t10.get(k).getAmount() == -5)
								checkT10 = true;
						}
					if(checkT10 == true)
						System.out.println(checkT10);
					{
						//berekening met default waarden in de tabel
						for (Top10Hulp t : t10) {
							
							if(t.getTitle().equals(cdList.get(i)))
								break;
							
							if(t.getAmount() == -5)
							{
								t.setAmount(counter);
								t.setTitle(cdList.get(i));
								break;
							}
						}
						
					}
					
					if(checkT10 == false)
					{
						//berekening zonder default waarden in de tabel
						for (Top10Hulp t : t10) {
							
							if(t.getTitle().equals(cdList.get(i)))
								break;
							
							if(t.getAmount() < counter)
							{
								t.setAmount(counter);
								t.setTitle(cdList.get(i));
								break;
							}
							
						}
					}
					
					counter=0;
					checkT10=false;
					System.out.println(counter);
				}
				
				Collections.sort(t10);
				
				for (Top10Hulp x : t10) {
					
					cdListTop10.add(x.getTitle());
				
				}
				
				return cdListTop10;
	}
		
	public static ArrayList<String> top10CdReserved()
	{
		
		
				try {
					   if(conn == null || conn.isClosed()){
					    conn = DatabaseConnection.getConnection();
					   }
					  } catch (SQLException e1) {
					   
					   e1.printStackTrace();
					  }
				
				ArrayList<String> dvdList = new ArrayList<String>();
				ArrayList<Top10Hulp> t10 = new ArrayList<Top10Hulp>();
				ArrayList<String> dvdListTop10 = new ArrayList<String>();
				
				//init met default waarden
						for(int i =0; i<10; i++)
						{
							t10.add(new Top10Hulp());
						}
						
					
				try {
					Statement stmnt = conn.createStatement();
					String sql = "SELECT title FROM Media b , Reservations r WHERE r.product_id = b.media_id AND r.type= 'CD'";
					ResultSet res = stmnt.executeQuery(sql);

					while(res.next()) {
					
						dvdList.add(res.getString("title"));
						
					}

				}
				catch(SQLException e) {
					System.out.println(e);
				}

				int counter =0;//counter om te tellen hoeveel keer een prodcut voorkomt, hulpvariabele
				boolean checkT10= false;
				
				
				for(int i=0; i<dvdList.size(); i++)
				{
					//in deze loop kijken we hoeveel keer eenzelfde product voorkomt in de lijst
					for(int j=0; j<dvdList.size(); j++)
					{
						if(dvdList.get(j).equals(dvdList.get(i)))
						{
							System.out.println(dvdList.get(j));
							counter++;
							System.out.println(counter);
							
						}
						
						
					}
					
					for(int k = 0; k < t10.size(); k++)
						{
							if(t10.get(k).getAmount() == -5)
								checkT10 = true;
						}
					if(checkT10 == true)
						System.out.println(checkT10);
					{
						//berekening met default waarden in de tabel
						for (Top10Hulp t : t10) {
							
							if(t.getTitle().equals(dvdList.get(i)))
								break;
							
							if(t.getAmount() == -5)
							{
								t.setAmount(counter);
								t.setTitle(dvdList.get(i));
								break;
							}
						}
						
					}
					
					if(checkT10 == false)
					{
						//berekening zonder default waarden in de tabel
						for (Top10Hulp t : t10) {
							
							if(t.getTitle().equals(dvdList.get(i)))
								break;
							
							if(t.getAmount() < counter)
							{
								t.setAmount(counter);
								t.setTitle(dvdList.get(i));
								break;
							}
							
						}
					}
					
					counter=0;
					checkT10=false;
					System.out.println(counter);
				}
				
				Collections.sort(t10);
				
				for (Top10Hulp x : t10) {
					
					dvdListTop10.add(x.getTitle());
				
				}
				
				return dvdListTop10;
	}
		
	public static ArrayList<Integer> top10loyalLocalMemberAllTimes(int pCode)
	{
		// deze functie returns member Id's, gebruik deze id's om tot volledige member details te komen gebruik getMemeberById van MemeberDAO
		// deze functie returnt een lijst van 10 id's die standaard de waarde -5 hebben. als het -5 is moet je die niet afprinten.
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		ArrayList<Top10Hulp>memberIdList2 = new ArrayList<Top10Hulp>();
		ArrayList<Integer>memberIdList = new ArrayList<Integer>();
		boolean check = false;
		
		int counter=0;
		
		//init met default waarden
		for(int i =0; i<10; i++)
		{
			memberIdList2.add(new Top10Hulp(0,-5));
		}
		
		try {
			PreparedStatement stmnt = conn.prepareStatement("SELECT r.member_id FROM RentTransactions r , Members m, Addresses a WHERE r.member_id = m.member_id AND a.postal_code = ? AND m.address_id = a.address_id");
			stmnt.setInt(1, pCode );
			ResultSet res;
			res = stmnt.executeQuery();
		
			
				while(res.next()){
				
					memberIdList.add(res.getInt("member_id"));
				}
			}
			catch(SQLException e){
				e.printStackTrace();
				
				
			}
		
		for(int i=0; i<memberIdList.size(); i++)
		{
			//in deze loop kijken we hoeveel keer eenzelfde product voorkomt in de lijst
			for(int j=0; j<memberIdList.size(); j++)
			{
				if(memberIdList.get(j) == memberIdList.get(i))
				{
					
					counter++;
	
				}
				
				
			}
			
			for(int k = 0; k < memberIdList2.size(); k++)
			{
				if(memberIdList2.get(k).getId() == -5)
					check = true;
			}
			
		if(check == true)
			
		{
			//berekening met default waarden in de tabel
			for (Top10Hulp m : memberIdList2) {
				
				if(m.getId() == memberIdList.get(i))
					break;
				
				if(m.getId() == -5)
				{
					m.setAmount(counter);
					m.setId(memberIdList.get(i));
					break;
				}
			}
			
		}
		
		if(check == false)
		{
			//berekening zonder default waarden in de tabel
			for (Top10Hulp m : memberIdList2) {
				
				if(m.getId() == memberIdList.get(i))
					break;
				
				if(m.getAmount() < counter)
				{
					m.setAmount(counter);
					m.setId(memberIdList.get(i));
					break;
				}
				
			}
		}
		
		counter=0;
		check=false;
		
		}
		
		Collections.sort(memberIdList2);
		memberIdList.clear();
		
		for (Top10Hulp m : memberIdList2) {
			
			if(!(m.getId()==-5))
			{
			memberIdList.add(m.getId());
			}
			
		}
		
		System.out.println(memberIdList);
		return memberIdList ;
		
	}
	
	public static ArrayList<Integer> top10loyalLocalMemberPerMonth(int pCode, String date)
	{
		
		// datum is in mm/yyyy formaat als string. met het "/" inbegrepen
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		ArrayList<Top10Hulp>memberIdList2 = new ArrayList<Top10Hulp>();
		ArrayList<Integer>memberIdList = new ArrayList<Integer>();
		boolean check = false;
		
		int counter=0;
		
		//init met default waarden
		for(int i =0; i<10; i++)
		{
			memberIdList2.add(new Top10Hulp(0,-5));
		}
		
		try {
			PreparedStatement stmnt = conn.prepareStatement("SELECT r.member_id FROM RentTransactions r , Members m, Addresses a WHERE r.member_id = m.member_id AND a.postal_code = ? AND m.address_id = a.address_id  AND RIGHT(r.date_out, 7) = ?");
			stmnt.setInt(1, pCode );
			stmnt.setString(2, date);
			ResultSet res;
			res = stmnt.executeQuery();
		
			
				while(res.next()){
				
					memberIdList.add(res.getInt("member_id"));
				}
			}
			catch(SQLException e){
				e.printStackTrace();
				
				
			}
		
		for(int i=0; i<memberIdList.size(); i++)
		{
			//in deze loop kijken we hoeveel keer eenzelfde product voorkomt in de lijst
			for(int j=0; j<memberIdList.size(); j++)
			{
				if(memberIdList.get(j) == memberIdList.get(i))
				{
					
					counter++;
	
				}
				
				
			}
			
			for(int k = 0; k < memberIdList2.size(); k++)
			{
				if(memberIdList2.get(k).getId() == -5)
					check = true;
			}
			
		if(check == true)
			
		{
			//berekening met default waarden in de tabel
			for (Top10Hulp m : memberIdList2) {
				
				if(m.getId() == memberIdList.get(i))
					break;
				
				if(m.getId() == -5)
				{
					m.setAmount(counter);
					m.setId(memberIdList.get(i));
					break;
				}
			}
			
		}
		
		if(check == false)
		{
			//berekening zonder default waarden in de tabel
			for (Top10Hulp m : memberIdList2) {
				
				if(m.getId() == memberIdList.get(i))
					break;
				
				if(m.getAmount() < counter)
				{
					m.setAmount(counter);
					m.setId(memberIdList.get(i));
					break;
				}
				
			}
		}
		
		counter=0;
		check=false;
		
		}
		
		Collections.sort(memberIdList2);
		memberIdList.clear();
		
		for (Top10Hulp m : memberIdList2) {
			
			if(!(m.getId()==-5))
			{
			memberIdList.add(m.getId());
			}
		}
		
		return memberIdList ;
		
	}
	
	public static ArrayList<Integer> top10loyalMemberAllTimes()
	{
		// deze functie returns member Id's, gebruik deze id's om tot volledige member details te komen gebruik getMemeberById van MemeberDAO
		// deze functie returnt een lijst van 10 id's die standaard de waarde -5 hebben. als het -5 is moet je die niet afprinten.
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		ArrayList<Top10Hulp>memberIdList2 = new ArrayList<Top10Hulp>();
		ArrayList<Integer>memberIdList = new ArrayList<Integer>();
		boolean check = false;
		
		int counter=0;
		
		//init met default waarden
		for(int i =0; i<10; i++)
		{
			memberIdList2.add(new Top10Hulp(0,-5));
		}
		
		try {
			PreparedStatement stmnt = conn.prepareStatement("SELECT r.member_id FROM RentTransactions r , Members m, Addresses a WHERE r.member_id = m.member_id AND m.address_id = a.address_id");
			
			ResultSet res;
			res = stmnt.executeQuery();
		
			
				while(res.next()){
				
					memberIdList.add(res.getInt("member_id"));
				}
			}
			catch(SQLException e){
				e.printStackTrace();
				
				
			}
		
		for(int i=0; i<memberIdList.size(); i++)
		{
			//in deze loop kijken we hoeveel keer eenzelfde product voorkomt in de lijst
			for(int j=0; j<memberIdList.size(); j++)
			{
				if(memberIdList.get(j) == memberIdList.get(i))
				{
					
					counter++;
	
				}
				
				
			}
			
			for(int k = 0; k < memberIdList2.size(); k++)
			{
				if(memberIdList2.get(k).getId() == -5)
					check = true;
			}
			
		if(check == true)
			
		{
			//berekening met default waarden in de tabel
			for (Top10Hulp m : memberIdList2) {
				
				if(m.getId() == memberIdList.get(i))
					break;
				
				if(m.getId() == -5)
				{
					m.setAmount(counter);
					m.setId(memberIdList.get(i));
					break;
				}
			}
			
		}
		
		if(check == false)
		{
			//berekening zonder default waarden in de tabel
			for (Top10Hulp m : memberIdList2) {
				
				if(m.getId() == memberIdList.get(i))
					break;
				
				if(m.getAmount() < counter)
				{
					m.setAmount(counter);
					m.setId(memberIdList.get(i));
					break;
				}
				
			}
		}
		
		counter=0;
		check=false;
		
		}
		
		Collections.sort(memberIdList2);
		memberIdList.clear();
		
		for (Top10Hulp m : memberIdList2) {
			
			if(!(m.getId()==-5))
			{
			memberIdList.add(m.getId());
			}
		}
		
		return memberIdList ;
}
	
	public static ArrayList<Integer> top10loyalMemberPerMonth(String date)
	{
		
		// datum is in mm/yyyy formaat als string. met het "/" inbegrepen
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		ArrayList<Top10Hulp>memberIdList2 = new ArrayList<Top10Hulp>();
		ArrayList<Integer>memberIdList = new ArrayList<Integer>();
		boolean check = false;
		
		int counter=0;
		
		//init met default waarden
		for(int i =0; i<10; i++)
		{
			memberIdList2.add(new Top10Hulp(0,-5));
		}
		
		try {
			PreparedStatement stmnt = conn.prepareStatement("SELECT r.member_id FROM RentTransactions r , Members m, Addresses a WHERE r.member_id = m.member_id AND m.address_id = a.address_id  AND RIGHT(r.date_out, 7) = ?");
			
			stmnt.setString(1, date);
			ResultSet res;
			res = stmnt.executeQuery();
		
			
				while(res.next()){
				
					memberIdList.add(res.getInt("member_id"));
				}
			}
			catch(SQLException e){
				e.printStackTrace();
				
				
			}
		
		for(int i=0; i<memberIdList.size(); i++)
		{
			//in deze loop kijken we hoeveel keer eenzelfde product voorkomt in de lijst
			for(int j=0; j<memberIdList.size(); j++)
			{
				if(memberIdList.get(j) == memberIdList.get(i))
				{
					
					counter++;
	
				}
				
				
			}
			
			for(int k = 0; k < memberIdList2.size(); k++)
			{
				if(memberIdList2.get(k).getId() == -5)
					check = true;
			}
			
		if(check == true)
			
		{
			//berekening met default waarden in de tabel
			for (Top10Hulp m : memberIdList2) {
				
				if(m.getId() == memberIdList.get(i))
					break;
				
				if(m.getId() == -5)
				{
					m.setAmount(counter);
					m.setId(memberIdList.get(i));
					break;
				}
			}
			
		}
		
		if(check == false)
		{
			//berekening zonder default waarden in de tabel
			for (Top10Hulp m : memberIdList2) {
				
				if(m.getId() == memberIdList.get(i))
					break;
				
				if(m.getAmount() < counter)
				{
					m.setAmount(counter);
					m.setId(memberIdList.get(i));
					break;
				}
				
			}
		}
		
		counter=0;
		check=false;
		
		}
		
		Collections.sort(memberIdList2);
		memberIdList.clear();
		
		for (Top10Hulp m : memberIdList2) {
			
			if(!(m.getId()==-5))
			{
			memberIdList.add(m.getId());
			}
		}
		
		return memberIdList ;
		
	}
	//tijdelijke main om statistics te testen
	public static void main(String[] args) {
		
		//int bookList = top10loyalLocalMemberAllTimes(9280);
		
	//	for (Integer title : bookList) {
			System.out.println(top10loyalLocalMemberAllTimes(9280));
		//}
		

}

}