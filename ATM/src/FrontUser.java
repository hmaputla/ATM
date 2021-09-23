import java.util.*;
import java.util.ArrayList;
import com.user.User;

public class FrontUser
{
	
	
	public static void main(String[] args)
	{
		//Declare List of Objects
		ArrayList<User>listOfUsers=new ArrayList<User>();
		
		System.out.println("\n"+listOfUsers.size()+" added in the List ");
		
		RegisterUser(listOfUsers);
		
		System.out.println("\n"+listOfUsers.size()+" Added on the List");
		
		
		
	}//End of Main Class
	
	
	public static void RegisterUser(ArrayList<User> listOfUsers)
	{
		Scanner inputString=new Scanner(System.in);
		Scanner inputLong=new Scanner(System.in);
		Scanner inputInt=new Scanner(System.in);
		
		//String prompt;
		char terminal;
		//
		do
		{
			
			User userObject=new User();
			String message="Please Enter Username";
			System.out.println(message);
			
			
			String username=inputString.nextLine();
			userObject.setUserName(username);
			
			//last Name
			
			 message="Please Enter Lastname:";
			System.out.println(message);
			
			
			String lastname=inputString.nextLine();
			userObject.setUserName(lastname);
			
			//password
			
			 message="Enter a 4 Pin Number";
			System.out.println(message);
			
			 String password=inputInt.nextLine();
			userObject.setPassword(password);
			
			//accountNum
			 message="Please Enter Account Number";
			System.out.println(message);
			
			 String account=inputLong.nextLine();
			userObject.setAccountNum(account);

			
			userObject.setAmount(0);
			
			listOfUsers.add(userObject);
			
			boolean checkEmpty=username.isEmpty() || lastname.isEmpty() || password.isEmpty() || account.isEmpty();
			boolean pinLength=password.length()==4;
			boolean accountLength=account.length()==10;
			
			
			if(checkEmpty)
			{
				message="User info Empty,Please fill all the required info";
				listOfUsers.clear();
				terminal='Y';
				continue;
			}
			if(!pinLength)
			{
				message="Pin number must be 4 numerical values";
				System.out.println(message);
				terminal='Y';
				continue;
			}
			
			if(!accountLength)
			{
				message="Account number must be 10 numerical values";
				System.out.println(message);
				terminal='Y';
				
				message="\nRe-Enter User Details\n\n";
				System.out.println(message);
				continue;
			}
			if(!checkEmpty && pinLength && accountLength)
			{
				if( validatePin(password) && validateAccount(account))
				{
					message="Successfully Registered with ATM";
					System.out.println(message);
					terminal='N';
					continue;
				}
				else
				{
					message="Please Enter a valid pin/account";
					System.out.println(message);
					message="\nRe-Enter User Details\n\n";
					System.out.println(message);
					terminal='Y';
					continue;
				}
			}
		

			//message="Would you like to Add another user(Y/N)";
			//System.out.println(message);
			//prompt=inputString.nextLine();
			terminal='N';
			
		}while(terminal!='N');
		
	}

	
	public static boolean validatePin(String _password)
	{
		boolean results=false;
		
		char []pinNum=_password.toCharArray();
		int count=0;
		
		for(int outer=0;outer<_password.length();outer++)
		{
			if(Character.isDigit(pinNum[outer]))
			{
				count++;
			}
		
		}
		
		if(count==4)
		{
			results=true;
		}
		else
		{
			results=false;
		}
		
		return results;
		
	}
	
	
	public static boolean validateAccount(String Account)
	{
		boolean results=false;
		
		char []pinNum=Account.toCharArray();
		int count=0;
		
		for(int outer=0;outer<Account.length();outer++)
		{
			if(Character.isDigit(pinNum[outer]))
			{
				count++;
			}
		
		}
		
		if(count==10)
		{
			results=true;
		}
		else
		{
			results=false;
		}
		return results;
		
	}
	
	
	public static boolean Login(ArrayList<User>listOfUsers,String _username,String _pin)
	{
		boolean results=false;
		
		for(User each:listOfUsers)
		{
			if(each.getUserName().equalsIgnoreCase(_username) && each.getPassword().equals(_pin))
			{
				results=true;
				break;
			}
			else
			{
				results=false;
				break;
			}
		}
		
		return results;
	}
	
	public static void Menu(User userObj)
	{
		Scanner inputInt=new Scanner(System.in);
		Scanner inputDouble=new Scanner(System.in);
		
		String message="Welcome To ATM";
		System.out.println(message);
		message+="1.Deposit\n2.Withdraw";
		
		message+="\nPlease select an action above\\n\\n";
		int option=inputInt.nextInt();
		System.out.print(message);
		
		
		switch(option)
		{
		
			case 1:
			{
				message="How much would you like to deposit";
				System.out.println(message);
				double amount=inputDouble.nextDouble();
				userObj.deposit(amount);
				
			}
			break;

		}
		
		
	}

}



