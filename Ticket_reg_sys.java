import java.io.*;
class lib_m
{
	long number;
	static int no=1001;
	static int no1=7700;
	int book_no[]=new int[10], d[]=new int[10], m[]=new int[10], y[]=new int[10],reg_no;
	String name, book_name[]=new String[10],temp;
	int f=0;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	void n_reg()throws java.lang.Exception
	{
		System.out.print("\tEnter book name :");
		book_name[f]=br.readLine();
		
		System.out.print("\tEnter date (d m y) :");
		d[f]=Integer.parseInt(br.readLine());
		m[f]=Integer.parseInt(br.readLine());
		y[f]=Integer.parseInt(br.readLine());
		book_no[f]=no1;
		no1++;
		System.out.println("\tYour book number is :"+book_no[f]);
		System.out.print("\tEnter 'C' to continue:");
		temp=br.readLine();		
		f++;		
	}
	void create()throws java.lang.Exception
	{
		System.out.print("\tEnter Name :");
		name=br.readLine();
		reg_no=no;
		no++;
		System.out.print("\tYour registration number is : "+reg_no+"\n\tEnter 'C' to continue :");
		temp=br.readLine();
	}
	void show()throws java.lang.Exception
	{
		for(int i=0;i<f;i++)
		{
			if(book_no[i]==0)
			{

			}
			else
			{
				System.out.println("----------------------------------------------------------------------");
				System.out.println("\tName : "+name);
				System.out.println("\tRegistration_no : "+reg_no);
				System.out.println("\tBook Name : "+book_name[i]);
				System.out.println("\tBook_no : "+book_no[i]);
				System.out.println("\tRegistered Date : "+d[i]+"/"+m[i]+"/"+y[i]);
				System.out.println("----------------------------------------------------------------------");
			}
		}
		System.out.print("\tEnter 'C' to continue:");
		temp=br.readLine();
	}
	public void return1()throws java.lang.Exception
	{
		int i,k;
		System.out.print("Enter Book number :");
		k=Integer.parseInt(br.readLine());
		for(i=0;i<f;i++)
		{
			if(book_no[i]==k)
			{
				book_no[i]=0;
				System.out.println("\t\t------Returned successfully!------");
				break;
			}
		}
	}
	public static void main(String args[])throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		lib_m ob[] = new lib_m[5];
		int n=-1;
		int flag=0;
		int l=0;
		int i=0,k=0;
		String name1;
		long number1;
		while(n!=4)
		{
			System.out.println("\t---------------------------------");
			System.out.println("\t1. New User");
			System.out.println("\t---------------------------------");
			System.out.println("\t2. Login into User");
			System.out.println("\t---------------------------------");
			System.out.println("\t3. Show Records");
			System.out.println("\t---------------------------------");
			System.out.println("\t4. Exit");
			System.out.println("\t---------------------------------");
			System.out.print("\tEnter Choice :");
			n=Integer.parseInt(br.readLine());
			switch(n)
			{
				case 1:
					ob[l] = new lib_m();
					ob[l].create();
					l++;
					break;
	
				case 2:
					if(l==0)
					{
						System.out.println("No users");
					}
					else
					{
						System.out.print("\n\tEnter user details: \n\tEnter name : ");
						name1=br.readLine();
						System.out.print("\tEnter Registration Number :");
						number1=Long.parseLong(br.readLine());
						n=0;
						for(i=0;i<l;i++)
						{
							if(name1.equals(ob[i].name) && number1==ob[i].reg_no)
							{
								flag=1;
								System.out.println("\t\t------------login successful!------------");
								while(n!=3)
								{
									System.out.println("\t---------------------------------");
									System.out.println("\t1. New Book Registration");
									System.out.println("\t---------------------------------");
									System.out.println("\t2. Return Book");
									System.out.println("\t---------------------------------");
									System.out.println("\t3.Exit to main menu");
									System.out.println("\t---------------------------------");
									System.out.print("\tEnter Choice :");
									n=Integer.parseInt(br.readLine());
									if(n==1)
									{
										ob[i].n_reg();
									}
									else if(n==2)
									{
										ob[i].return1();
									}
								}
							}
						}
						if(flag==0)
						{
								flag=1;
								System.out.println("\t\t------------login falied!------------");
						}
					}
					break;
				case 3:
					for(i=0;i<l;i++)
					{
						ob[i].show();
					}
					break;
				case 4:
					System.exit(0);
					break;
				default:
						System.out.println("Wrong input.");
					
			}
		}
}
}