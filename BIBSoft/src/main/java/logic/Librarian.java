package logic;



import java.util.ArrayList;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Days;

import dao.AdressDAO;
import dao.BookCopyDAO;
import dao.BookDAO;
import dao.FineDAO;
import dao.MediaCopyDAO;
import dao.MediaDAO;
import dao.MemberDAO;
import dao.RentTransactionDAO;
import dao.RateDAO;
import dao.RentalDAO;
import dao.StringDateSwitcher;

public class Librarian extends Staff {
	
	public static ArrayList<Member> librarianDAOMember = new ArrayList<Member>();
	public static ArrayList<BookCopy> bookCopyList = new ArrayList<BookCopy>();
	public static ArrayList<Book> bookList = new ArrayList<Book>();
	public static ArrayList<Media> mediaList = new ArrayList<Media>();
	public static ArrayList<MediaCopy> mediaCopyList = new ArrayList<MediaCopy>();
	public static ArrayList<Rate> rateList = new ArrayList<Rate>();
	public static ArrayList<Fine> fineList = new ArrayList<Fine>();
	
	public Librarian(String name, String surname, String function, Login login) {
		super(name, surname, function, login);
		
	}
	
	//Member functies
	public ArrayList<Member> getAllMembers()
	{
		return MemberDAO.getAll();
	}
	public Member getMemberById(int id)
	{
		return MemberDAO.getMemberByID(id);
	}
	
	public void searchMemberName(String name){
		for(Member m : MemberDAO.getAll()) {
			if(m.getName() != null && m.getName().equals(name)) 
			{
				System.out.println("All names must be insert");
			}
		}
	}
	
	public void searchMemberSurname(String surname){
		for(Member m : MemberDAO.getAll()) {
			if(m.getSurname() != null && m.getSurname().equals(surname)) 
			{
				System.out.println("All surnames must be insert");
			}}}
	
	public void searchMemberAdress(String city){
		for(Adress a : AdressDAO.getAll()) {
			if(a.getCity() != null && a.getCity().equals(city)) 
			{
				System.out.println("All names of this adress must be return");
			}}}
	
	public void addMember(Member m)
	{
		if(m.checkMember()){
			System.out.println("member bestaat (gepaste afhandeling nog schrijven");
		}else{
			MemberDAO.insertMember(m);
		}
	}
	
	public void deleteMember(int memberID)
	{
		MemberDAO.removeMember(memberID);
	}
	
	public void editMember(Member m){
		MemberDAO.editMember(m);
	}
	
	public void editMemberName(Member member, String name)
	{
		//MemberDAO.changeMemberName(name, member.getLidID()); //TODO memberdao bij wijzigen van data is foutief
	}
	
	public void editMemberSurname(Member member, String surname)
	{
		//MemberDAO.changeMemberSurname(surname, member.getLidID());
	}
	
	public void editMemberTelnr(Member member, String telNR)
	{
		//MemberDAO.changeMemberTelNR(telNR, member.getLidID());
	}
	
	public void editMemberAantalBoeken(Member member, int aantalBoeken)
	{
		member.setAantalBoeken(aantalBoeken);
	}
	
	public void editMemberActief(Member member, boolean actief)
	{
		member.setActief(actief);
	}

	public void editMemberAdress(Member member,Adress adress)
	{
		member.setAdress(adress);
	}
	
	//Book functies
	public Book checkBook(String isbn){
		if(bookList.size() == 0){
			bookList = BookDAO.getAllBooks();
		}
		for(Book b: bookList){
			if(b.getISBN().equals(isbn)){
				return b;
			}
		}
		return null;
	}
	
	public ArrayList<Book> getAllBooks()
	{
		return BookDAO.getAllBooks();
	}
	
	public void addBook(BookCopy bc){
		Book b = this.checkBook(bc.getISBN());
		if(b == null){
			BookDAO.insertBook(bc);
			bookList = BookDAO.getAllBooks();
		}
		for(Book bb: bookList){
			if(bb.getISBN().equals(bc.getISBN())){
				bc.setBookID(bb.getBookID());
			}
		}
		System.out.println(bc.getBookID());
		BookCopyDAO.saveCopy(bc);
	}
	
	public void editBook(Book b){
		BookDAO.editBook(b);
	}
	
	public void removeBookCopy(BookCopy bc){
		BookCopyDAO.removeCopy(bc.getCopyId());
	}
	
	public static ArrayList<BookCopy> getAllBookCopys(){
		bookCopyList = BookDAO.getAllCopies();
		return bookCopyList;
	}
	
	//Media functies
	public ArrayList<MediaCopy> getAllMediaCopies(){
		mediaCopyList = MediaDAO.getAllCopies();
		return mediaCopyList;
	}

	public Media checkMedia(String title, String type){
		if(mediaList.size() == 0){
			mediaList = MediaDAO.getAllMedia();
		}
		for(Media m: mediaList){
			if(m.getTitle().equals(title) && m.getType().toUpperCase().equals(type)){
				return m;
			}
		}
		return null;
	}
	
		//Deze methode nog nakijken moet opgelost worden met volledige equals methode
	public void addMedia(MediaCopy mc){
		Media m = this.checkMedia(mc.getTitle(), mc.getType());
		if(m == null){
			MediaDAO.insertMedia(mc);
			mediaList = MediaDAO.getAllMedia();
		}
		for(Media mm: mediaList){
			System.out.println(mm.getTitle() + " - " + mm.getType());
			if(mm.getTitle().equals(mc.getTitle())){
				mc.setMediaID(mm.getMediaID());
				System.out.println(mc.getMediaID());
			}
		}
		MediaCopyDAO.saveCopy(mc);
	}
	
	public void editMedia(Media m){
		MediaDAO.editMedia(m);
	}
	
	public void removeMediaCopy(MediaCopy mc){
		MediaCopyDAO.removeCopy(mc.getMediaCopyID());
	}
	
	
	//Rent functies
	public void rentOut(boolean closed, ArrayList <BookCopy> bookList, ArrayList<Media> mediaList,Member member, String dateOut, String dateIn, Librarian lib){
		
		
		
		RentTransaction trans = new RentTransaction(closed,bookList,mediaCopyList,member.getLidID(),dateOut,dateIn,lib.getLogin().getStaffID());
		trans.setClosed(true);
		
		RentTransactionDAO.saveRentTransaction(trans);
		
		
	}
	
	public ArrayList <RentTransaction> getTransactionByMemberId(int memberId)
	{
		
		return RentTransactionDAO.getRentTransactionByMemberId(memberId);
		
	}
	
	public Fine checkFine(RentTransaction rt){
		float fine = 0;
		Date dCurrent = new Date();
		Date dOld = StringDateSwitcher.toDate(rt.getDateIn());
		float boekBoete = RateDAO.getRate(2);
		float dvdBoete = RateDAO.getRate(4);
		float cdBoete = RateDAO.getRate(3);
		if(dCurrent.after(dOld)){
			
			Days dagenTeLaat = Days.daysBetween(new DateTime(dOld.getTime()).withTimeAtStartOfDay(), new DateTime(dCurrent.getTime()).withTimeAtStartOfDay());
			
			
			ArrayList<Rental> rentalList = RentalDAO.getRentalById(rt.getRentTransId());
			for(Rental r : rentalList){
				switch (r.getType().toLowerCase()){
				case "boek":
					fine += dagenTeLaat.getDays() * boekBoete;
					break;
				case "dvd":
					fine += dagenTeLaat.getDays() * dvdBoete;
					break;
				case "cd":
					fine += dagenTeLaat.getDays() * cdBoete;
					break;
				default:
					break;
				}
				
			}
			return new Fine(rt.getRentTransId(), rt.getMemberId(), fine, false);
		}
		
		
		return null;
	}
	
	//Adress functies
	public void addAdress(Adress adress) {
		if(adress.checkAdress()){
			
		}else{
			AdressDAO.insertAdress(adress);
		}
	}
	
	//Fine functies
	public ArrayList<Fine> getAllUnpaidFines(){
		fineList = FineDAO.getAllUnpaidFines();
		return fineList;
	}
	
	public RentTransaction getRentTransaction(int rentTransactionID)
	{
		
		return RentTransactionDAO.getRentTransaction(rentTransactionID);
		
	}
	
	public void payFine(int fineID){
		FineDAO.payFine(fineID);
	}
	
	public void saveFine(Fine fine){
		FineDAO.saveFine(fine);
	}
	
	//** ongv 0,25 seconden nodig om een transactie op te slaan in de DB **//

}
