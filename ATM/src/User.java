
public class User
{
	private String userName;
	private String lastName;
	private int password;
	private long accountNum;
	private double amount;
	
	
	public User(String _userName,String _lastName,int _password,long _accountNum,double _amount)
	{
		this.userName=_userName;
		this.lastName=_lastName;
		this.password=_password;
		this.accountNum=_accountNum;
		this.amount=_amount;
	}
	
	//setters and getters
	
	public String setUserName(String _userName)
	{
		this.userName=_userName;
		return userName;
	}
	
	
	public String setLastName(String _lastName)
	{
		this.lastName=_lastName;
		return lastName;
	}
	
	public int setPassword(int _password)
	{
		this.password=_password;
		return password;
	}
	
	public long setAccountNum(long _accountNum)
	{
		this.accountNum=_accountNum;
		
		return accountNum;
	}
	public double setAmount(double _amount)
	{
		this.amount=_amount;
		return amount;
	}
	
	
	
	
	//helper Methods
	
	
	
	public boolean checkPassword(int _password)
	{
		boolean results=false;
		int countLength=0;
		
		for(int outer=0;outer<_password;outer++)
		{
			countLength++;
		}
		
		if(countLength==4)
		{
			if( _password==password)
			results=true;
		}
		else
		{
			results=false;
		}
		
		
		return results;
	}
	
	
	public String withdrawal(double _amount)
	{
		String message="";
		double left=0;
		
		if(amount>_amount)
		{
			left=amount-_amount;
			message="Amount Left R"+left;
		}
		else
		{
			message="Amount cannot be withdrawed";
		}

		return message;
	}
	
	public String deposit(double _amount)
	{
		String message="";
		amount=amount+_amount;
		message="Successfully Deposited R"+_amount+" into Savings Account";
		message+="\n"+"Total Savings R"+amount;
		return message;
	}
	
	
	
	
}
