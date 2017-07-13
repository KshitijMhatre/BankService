package com.client;


import java.util.Scanner;

import com.exceptions.InsufficientBalanceException;
import com.exceptions.InvalidAccountNoException;
import com.exceptions.ServiceNotAvailableException;
import com.provider.BankProvider;
import com.services.Services;

/**
 * @author Kshitij Mhatre
 *
 */
public class ClientCode {

	public static void main(String[] args) {
		
		
		try {
			Services bank=BankProvider.getBank();

			
			boolean run=true;
			do
			{
				System.out.println("\n\nWelcome to unknown bank"
						+"\n 1)Open account"
						+"\n 2)Close account"
						+"\n 3)Deposit"
						+"\n 4)Withdraw"
						+"\n 5)Fund transfer"
						+"\n 6)Balance enquiry"
						+"\n 7)Mini statement"
						+"\n 8)Exit"
						+"\n please enter your choice"
						);
				
				Scanner sc =new Scanner(System.in);
				int option=sc.nextInt();
				
				switch (option){
				case 1: 
					System.out.println("choose account type \n1.Current 2.Saving");
					int ch=sc.nextInt();
					System.out.println("Enter balance");
					float bal=sc.nextFloat();
						if (ch==1 && bal>0)
							bank.openAcc("current", bal);
						else if(ch==2 && bal>0)
							bank.openAcc("saving", bal);
						else
							System.out.println("Invalid inputs");
					break;
				case 2: 
					System.out.println("Enter account no");
					int accNo=sc.nextInt();
					bank.deleteAccount(accNo);
					break;
				case 3:	
					System.out.println("Enter account no");
					accNo=sc.nextInt();
					System.out.println("Enter amount to deposit");
					float amt=sc.nextFloat();
					if (amt<0)
					{
						System.out.println("Invalid amt");
						break;
					}
					bank.deposit(accNo, amt);
					break;
				case 4:
					System.out.println("Enter account no");
					accNo=sc.nextInt();
					System.out.println("Enter amount to withdraw");
					amt=sc.nextFloat();
					if (amt<0)
					{
						System.out.println("Invalid amt");
						break;
					}
					bank.withdraw(accNo, amt);;
					break;					
				case 5:
					System.out.println("Enter account no1");
					int accNo1=sc.nextInt();
					System.out.println("Enter account no2");
					int accNo2=sc.nextInt();
					System.out.println("Enter amount to transfer");
					amt=sc.nextFloat();
					if (amt<0)
					{
						System.out.println("Invalid amt");
						break;
					}
					bank.fundTransfer(accNo1, accNo2, amt);
					break;					
				case 6:
					System.out.println("Enter account no");
					accNo=sc.nextInt();
					bank.balEnquiry(accNo);
					break;
				case 7:
					System.out.println("Enter account no");
					accNo=sc.nextInt();
					bank.miniStat(accNo);
					break;
				case 8:
					System.out.println("Thank you for visiting come again");
					run=false;
					break;
				default:
					System.out.println("Enter valid choice");
				
				}
				
			}while(run);
			
			
		} catch (InvalidAccountNoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InsufficientBalanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceNotAvailableException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
