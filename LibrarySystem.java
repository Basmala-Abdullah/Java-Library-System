import taskPkg.Book;
import taskPkg.Client;
import taskPkg.Library;
import taskPkg.LibraryItem;
import taskPkg.Magazine;
import taskPkg.Validation;
import taskPkg.myExceptions.ItemNotExistException;
import java.util.Scanner;  

public class LibrarySystem {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int client_id;
		Library library = new Library();
		boolean loop =true;
		while(loop){
			System.out.println("-----     Library Management System     -----");
			System.out.println("1) Display All Items");
			System.out.println("2) Add Item");
			System.out.println("3) Retrieve Item Data");
			System.out.println("4) Add Client");
			System.out.println("5) Display All Clients");
			System.out.println("6) Retrieve Client Data");
			System.out.println("7) Remove Client Data");
			System.out.println("8) Remove Item Data");
			System.out.println("9) Update Item Data");
			System.out.println("10) Update Client Data");
			System.out.println("11) Borrow Item");
			System.out.println("12) Return Item");
			System.out.println("13) Show Borrowed Items");
			System.out.println("14) Exit");
			System.out.println("Enter option number:");
			int option = Validation.inputInt();
			switch(option){
				case 1:
				System.out.println("\nAll Items Display:\n");
				library.displayAllItems();
				break;
				
				case 2:
				System.out.println("\nEnter option number: (Book or Magazine)");
				System.out.println("1) Book");
				System.out.println("2) Magazine");
				int item_option = scanner.nextInt();
				switch(item_option){
					case 1:
					System.out.println("\nEnter Book Details:");
					System.out.println("Enter Book ID:");
					int book_id = Validation.inputInt();
					scanner.nextLine();
					System.out.println("Enter Book Title:");
					String book_title = scanner.nextLine(); 
					System.out.println("Enter Book Author:");
					String book_author = Validation.inputString();
					if(library.addItem(new Book(book_id, book_title, book_author))){
						System.out.println("Book Added Successfully!");
					}else{
						System.out.println("Repeated ID: Item Not Added");
					}
					break;
					
					case 2:
					System.out.println("\nEnter Magazine Details:");
					System.out.println("Enter Magazine ID:");
					int magazine_id = Validation.inputInt();
					scanner.nextLine();
					System.out.println("Enter Magazine Title:");
					String magazine_title = scanner.nextLine(); 
					System.out.println("Enter Magazine Release No:");
					int magazine_releaseNo = Validation.inputInt();
					
					if(library.addItem(new Magazine(magazine_id, magazine_title, magazine_releaseNo))){
						System.out.println("Magazine Added Successfully!");
					}else{
						System.out.println("Repeated ID: Item Not Added");
					}
					break;
					default:
					System.out.println("Not Available Option!");
				}
				break;

				case 3:
				System.out.println("Enter Item ID you want to retrieve:");
				int item_id = Validation.inputInt();
				try{
					LibraryItem item = library.retrieveItemByID(item_id);
					System.out.println(item.displayItemDetails());
				}
				catch(Exception e){
					System.out.println("Caught Exception: " + e.getMessage());
				}
				break;

				case 4:
				System.out.println("Adding New Client");
				System.out.println("\nEnter Client Details:");
				System.out.println("Enter Client ID:");
				client_id = Validation.inputInt();
				//scanner.nextLine();
				System.out.println("Enter Client Name:");
				String client_name = Validation.inputString();
				System.out.println("Enter Client Email:");
				String client_email = scanner.nextLine();
			
				
				if(library.addClient(new Client(client_id, client_name, client_email))){
					System.out.println("Client Added Successfully!");
				}else{
					System.out.println("Repeated ID: Client Not Added");
				}
				break;

				case 5:
				System.out.println("\nAll Clients Display");
				library.displayAllClients();
				break;

				case 6:
				System.out.println("Enter Client ID you want to retrieve:");
				client_id = Validation.inputInt();
				try{
					library.displayClientByID(client_id);
				}
				catch(Exception e){
					System.out.println("Caught Exception: " + e.getMessage());
				}
				break;
				
				case 7:
				System.out.println("Enter Client ID you want to remove:");
				client_id = Validation.inputInt();
				try{
					library.removeClientById(client_id);
				}
				catch(Exception e){
					System.out.println("Caught Exception: " + e.getMessage());
				}
				break;
				
				case 8:
				System.out.println("Enter Item ID you want to remove:");
				item_id = Validation.inputInt();
				try{
					library.removeItemById(item_id);
				}
				catch(Exception e){
					System.out.println("Caught Exception: " + e.getMessage());
				}
				break;
				
				case 9: //Update Item Data
				System.out.println("Enter Item ID you want to update:");
				item_id = Validation.inputInt();
				
				try{
					library.editItemByID(item_id);
				}	
				catch(Exception e){
					System.out.println("Caught Exception: " + e.getMessage());
				}				
				break;
				
				case 10: //Update Client Data
				System.out.println("Enter Client ID you want to update:");
				client_id = Validation.inputInt();
				try{
					library.editClientByID(client_id);
				}	
				catch(Exception e){
					System.out.println("Caught Exception: " + e.getMessage());
				}
				break;
				
				case 11:
				System.out.println("Enter Item ID you want to borrow:");
				item_id = Validation.inputInt();
				if(library.ItemIDExists(item_id)){
					if(!library.keyExists(item_id)){
						System.out.println("Enter your ID:");
						client_id = Validation.inputInt();
						if(library.ClientIDExists(client_id)){
							library.addBorrowedItem(item_id,client_id);
						}else{
							System.out.println("No client of that ID");
						}
					}else{
						System.out.println("Item already borrowed");
					}
				}else{
					System.out.println("No Item of that ID");
				}
				
				break;
				
				case 12:
				System.out.println("Enter Item ID you want to return:");
				item_id = Validation.inputInt();
				if(library.ItemIDExists(item_id)){
					if(library.keyExists(item_id)){
						System.out.println("Enter your ID:");
						client_id = Validation.inputInt();
						if(library.ClientIDExists(client_id)){
							library.removeBorrowedItem(item_id,client_id);
						}else{
							System.out.println("No client of that ID");
						}
					}else{
						System.out.println("Item not yet borrowed");
					}
				}else{
					System.out.println("No Item of that ID");
				}
				break;
				
				case 13:
				library.displayBorrowedItems();
				break;
				
				case 14:
				return;
		

				default:
				System.out.println("Not Available Option!");
				
				
			}
		}
		
		
	}
	
	
}