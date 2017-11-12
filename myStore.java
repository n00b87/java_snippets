import java.util.Scanner;
import java.util.ArrayList;

class RAItem
{
	public String name;
	public double price;
}

class RAElectronics
{
	public static ArrayList<RAItem> items;
	public static double tax = 9.5;
	public RAElectronics()
	{
		items = new ArrayList<RAItem>();
	}
	
	public static void addItem(String item_name, double price)
	{
		RAItem item_add = new RAItem();
		item_add.name = item_name;
		item_add.price = price;
		
		items.add(item_add);
	}
	
	public static void removeItem(String item_name)
	{
		for(int i = 0; i < items.size(); i++)
		{
			if(items.get(i).name.equals(item_name))
			{
				items.remove(i);
				return;
			}
		}
	}
	
	public static void displayItemPurchaseList()
	{
		RAItem it;
		System.out.println("#\tItem Description\t\tPrice\n----------------------------------------------");
		for(int i = 0; i < items.size(); i++)
		{
			it = items.get(i);
			System.out.printf((i+1) + ". " + it.name + "\t\t\t$%.2f\n", it.price);
		}
		System.out.println();
	}
	
	public static RAItem getItem(int i)
	{
		RAItem null_item = new RAItem();
		
		if(i <= 0)
			return null_item;
			
		if( (i-1) < items.size())
			return items.get(i-1);
		
		return null_item;
	}
}

class Customer
{
	private static ArrayList<RAItem> cart;
	private static double total = 0;
	private static double tax = 0;
	public Customer()
	{
		cart = new ArrayList<RAItem>();
	}
	
	public static void addItemToCart(RAItem item)
	{
		cart.add(item);
		total += item.price;
		tax= total * .095;
	}
	
	public static void removeItemFromCart(RAItem item)
	{
		cart.remove(item);
		total -= item.price;
		tax = total * .095;
	}
	
	public static double getTotal()
	{
		return total;
	}
	
	public static double getTotalTax()
	{
		return tax;
	}
	
	public static double getTotalAfterTax()
	{
		return total + tax;
	}
	
	public static int itemCount()
	{
		return cart.size();
	}
}

public class myStore
{
	public static RAElectronics store;
	
	public static void initStore()
	{
		store = new RAElectronics();
		
		store.addItem("Lenovo Thinkpad", 10);
		store.addItem("Samsung Galaxy J3", 50.23);
		store.addItem("JLab Headphones", 99.99);
		store.addItem("Shitty Macbook", 5000);
		store.addItem("Shitty Iphone", 5000);
	}
	
	public static void runCashRegister()
	{
		Customer shopper = new Customer();
		
		Scanner s = new Scanner(System.in);
		
		
		Boolean quit = false;
		
		String user_input = "";
		int user_int = -1;
		
		RAItem user_item;
		
		System.out.println("Welcome to RA Electronics\n");
		while(!quit)
		{
			if(shopper.itemCount() == 0)
				System.out.println("Please select the items you would like to purchase today.\n");
			else
				System.out.println("Select another item\n");
				
			store.displayItemPurchaseList();
			System.out.print("\nSelect an item or 0 to checkout:");
			
			user_input = s.nextLine();
			
			try
			{
				user_int = Integer.parseInt(user_input);
			}
			catch(Exception e)
			{
				System.out.println("Not a valid input");
				continue;
			}
			
			if(user_input.equals("0"))
				quit = true;
			else if(user_int < store.items.size())
				shopper.addItemToCart(store.getItem(user_int));
			
		}
		
		System.out.printf("\nAmount: $%.2f", shopper.getTotal());
		System.out.printf("Tax: $%.2f", shopper.getTotalTax());
		System.out.printf("\nTotal Due: $%.2f", shopper.getTotalAfterTax());
		System.out.println("\n\n");
	}
	
	public static void main(String [] args)
	{
		initStore();
		
		Boolean quit = false;
		
		Scanner s = new Scanner(System.in);
		String user_input = "";
		
		while(!quit)
		{
			System.out.println("Select a Register Function\n------------------------------------");
			System.out.print("1. Run Register\n2. Quit\n\nSelect an option:");
			user_input = s.nextLine();
			if(user_input.equals("1"))
				runCashRegister();
			else
				quit = true;
		}
	}
}
