package logic;


public class Fine {
	
	private Transaction transaction;

	private int fineId;
	private int transactionId;
	private int memberId;
	private float fineAmount;
	private Boolean paid;
	
	
	
	public Fine(int fineId, int transactionId, int memberId, float fineAmount,
			Boolean paid) {
		super();
		this.fineId = fineId;
		this.transactionId = transactionId;
		this.memberId = memberId;
		this.fineAmount = fineAmount;
		this.paid = paid;
	}
	
	//new fine record creating
	public Fine(int transactionId, int memberId, float fineAmount, Boolean paid){
		super();
		this.transactionId = transactionId;
		this.memberId = memberId;
		this.fineAmount = fineAmount;
		this.paid = paid;
	}

	public Fine(Transaction transaction) {
		super();
		this.transaction = transaction;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public int getFineId() {
		return fineId;
	}

	public void setFineId(int fineId) {
		this.fineId = fineId;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public float getFineAmount() {
		return fineAmount;
	}

	public void setFineAmount(float fineAmount) {
		this.fineAmount = fineAmount;
	}

	public Boolean getPaid() {
		return paid;
	}

	public void setPaid(Boolean paid) {
		this.paid = paid;
	}
	
	

}
