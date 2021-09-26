import java.util.*;
import java.util.ArrayList;
import com.user.User;

public class FrontUser
{

	public static void main(String[] args)
	{
		//Declare List of Objects
		ArrayList<User>listOfUsers=new ArrayList<User>();
		
		System.out.println(""+listOfUsers.size()+" added in the List ");
		
		RegisterUser(listOfUsers);
		
		System.out.println("\n"+listOfUsers.size()+" Added on the List");
		
		//ValidateAndLogin(listOfUsers);
		
		//User userObj=new User();
		//System.out.println("Your username is username "+userObj.getUserName()+" Last Name "+userObj.getLastName());

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
				listOfUsers.clear();
				continue;
			}
			
			if(!accountLength)
			{
				message="Account number must be 10 numerical values";
				System.out.println(message);
				terminal='Y';
				
				message="\nRe-Enter User Details\n";
				System.out.println(message);
				listOfUsers.clear();
				continue;
			}
			if(!checkEmpty && pinLength && accountLength)
			{
				if(ValidateData(password,account))
				{
					message="Successfully Registered with ATM";
					System.out.println(message);
					terminal='N';
					continue;
				}
				if(!ValidateData(password,account))
				{
					message="Please Enter a valid pin/account";
					System.out.println(message);
					message="\nRe-Enter User Details\n";
					System.out.println(message);
					terminal='Y';
					listOfUsers.clear();
					continue;
				}
			}
		

			//message="Would you like to Add another user(Y/N)";
			//System.out.println(message);
			//prompt=inputString.nextLine();
			terminal='N';
			
		}while(terminal!='N');
		
	}

	
	public static boolean ValidateData(String _password,String _account)
	{
			boolean results=false;
				
			char []pinNum=_password.toCharArray();
			int countPin=0;
			
			char []accountNum=_account.toCharArray();
			int countAccount=0;
				
			for(int outer=0;outer<_password.length();outer++)
			{
				if(Character.isDigit(pinNum[outer]))
				{
					countPin++;
				}
				
			}
				
			
			for(int outer=0;outer<_account.length();outer++)
			{
				if(Character.isDigit(accountNum[outer]))
				{
					countAccount++;
				}
			
			}
			
			
			if(countPin==4 && countAccount==10)
			{
				results=true;
				
			}

			return results;
	}
	

	public static boolean Login(ArrayList<User>listOfUsers,String account,String _pin)
	{
		boolean results=false;
		
		for(User each:listOfUsers)
		{
			if(each.getAccountNum().equalsIgnoreCase(account) && each.getPassword().equals(_pin))
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
	
	 
	public static boolean ValidateAndLogin(ArrayList<User>listOfusers)
	{
		boolean results=false;
		String message="\n*****Login Into Your Account*****\n";
		System.out.println(message);
		
		Scanner inputString=new Scanner(System.in);
		//Scanner inputInt=new Scanner(System.in);

		int counter=0;
		
		do
		{
			counter++;
			
			message="Enter Your Acccount number ";
			System.out.println(message);
			String account=inputString.nextLine();
			
			message="Enter Your Pin ";
			System.out.println(message);
			String pin=inputString.nextLine();
			
			
			System.out.println("\nNumber of Attempts "+counter+"\n");
			if(ValidateData(pin,account))
			{
	
				 if(Login(listOfusers,account,pin))
				 {
					 results=true;
					 counter=3;
					 continue;
				 }
				 else
				 {
					 message="\nAccount/Pin do not Match,Try Again\n";
					 System.out.println(message);
				 }

			}
			else
			{
				if(counter!=3)
				{
					message="Please Enter Correct account/pin";
					System.out.println(message);
				}
				
				if(counter==3)
				{
					message="Many Attempts,You are Blocked please contact the Office.Thank You";
					System.out.print(message);
					results=false;
					continue;
				}
			}
			
			
			
		}while(counter!=3);
		
		
		return results;
	
	}
	
	
	public static void Menu(ArrayList<User>listOfUsers)
	{
		String message="";
		Scanner inputInt=new Scanner(System.in);
		if(ValidateAndLogin(listOfUsers))
		{
			message="\n1.Deposit \n2.Withdraw/3.Check Balance\n";
			message+="Welcome Please Choose an action above";
			int option=inputInt.nextInt();
			
			options(listOfUsers,option);
		}
	}


	public static void options(ArrayList<User>listOfUsers,int option) 
	{
		String message="";
		switch(option)
		{
		case 1:
		{
			message="How much would you like to deposit";
			System.out.println(message);
			
			for(User each:listOfUsers)
			{
				
			}
		}
		break;
		}
		
	}

	/*public static boolean validatePin(String _password)
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
		
	}*/
	
	/*public static boolean validateAccount(String Account)
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
		
	}*/
	
	/*public static boolean LoopMenu()
	{
		boolean results=false;
		
		while()
		
		return results;
	}*/
	
	/*public static void Menu(User userObj)
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
		
		
	}*/

}



