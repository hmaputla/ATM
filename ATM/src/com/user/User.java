package com.user;

public class User
{
	private String userName;
	private String lastName;
	private String password;
	private String accountNum;
	private double amount;
	
	public User()
	{
	}
	
	public User(String _userName,String _lastName,String _password,String _accountNum,double _amount)
	{
		this.userName=_userName;
		this.lastName=_lastName;
		this.password=_password;
		this.accountNum=_accountNum;
		this.amount=_amount;
	}
	
	//setters and getters
	public void setUserName(String _userName)
	{
		this.userName=_userName;
	}
	public void setLastName(String _lastName)
	{
		this.lastName=_lastName;
	}
	public void setPassword(String _password)
	{
		this.password=_password;
	}
	public void setAccountNum(String _accountNum)
	{
		this.accountNum=_accountNum;
		
	}
	public void setAmount(double _amount)
	{
		this.amount=_amount;
	}
	
	public String getUserName( )
	{
		return userName;
	}
	public String getLastName( )
	{
		return lastName;
	}
	public String getPassword( )
	{
		return password;
	}
	public String getAccountNum( )
	{
		return accountNum;
	}
	public double getAmount( )
	{
		return amount;
	}
	
	
	//helper Methods
	public boolean checkPassword(String _password)
	{
		boolean results=false;
		int countLength=0;
		
		int pass=Integer.parseInt(_password);
		for(int outer=0;outer<pass;outer++)
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
