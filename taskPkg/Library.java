package taskPkg;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import taskPkg.myExceptions.ItemNotExistException;
import taskPkg.myExceptions.ClientNotExistException;
import java.util.Scanner; 
import java.util.HashMap;
import taskPkg.Validation;
public class Library {
	Scanner scanner = new Scanner(System.in);
	private List<LibraryItem> items = new ArrayList<LibraryItem>();
	private  List<Client> clients = new ArrayList<Client>();
	private HashMap<Integer, Integer> borrowedItemsMap = new HashMap<Integer, Integer>();

	public <T extends LibraryItem> boolean addItem(T item){
		
		if(!ItemIDExists(item.getId())){
			items.add(item);
			return true;
		}
		return false;
	}
	public void displayBorrowedItems(){
		if (borrowedItemsMap.isEmpty()) {
			System.out.println("The map is empty.");
			return;
		}

		System.out.println("Borrowed Items:");
		for (HashMap.Entry<Integer, Integer> entry : borrowedItemsMap.entrySet()) {
			System.out.println("Item ID: " + entry.getKey() + ", Client ID: " + entry.getValue());
		}
	}
	public boolean keyExists(int itemID){
		return borrowedItemsMap.containsKey(itemID);
	}
	
	public void addBorrowedItem (int itemID, int clientID){
		borrowedItemsMap.put(itemID,clientID);
	}
	
	public void removeBorrowedItem (int itemID, int clientID){
		if(!borrowedItemsMap.remove(itemID,clientID)){
			System.out.println("Invalid: You didn't borrow this item!");
		}
	}
	
	public boolean ItemIDExists(int id) {
		for(LibraryItem i:items){
			if(i.getId() == id){
				return true;
			}
		}
		return false;
	}
	
	
	
	
	public boolean ClientIDExists(int id){
		for(Client c:clients){
			if(c.getId() == id){
				return true;
			}
		}
		return false;
	}
	
	public LibraryItem retrieveItemByID(int itemID) throws ItemNotExistException{
		/*
		for(LibraryItem item:items){
			if(item.getId() == itemID){
				return item;
			}
		}
		throw new ItemNotExistException("Item not found!");
		*/
		
		LibraryItem item = items.stream()
							.filter(i -> i.getId() == itemID)
							.findFirst() //-> .findFirst() returns the first matching object and retrieves it then .orElse(null) returns null if no object is retrieved -- .findFirst().orElse(null)
							.orElse(null);
							
		if(item != null){
			return item;
		}
		throw new ItemNotExistException("Item not found!");
	}
	
	public void editItemByID(int itemID) throws ItemNotExistException{
		for(int i = 0; i<items.size(); i++){
			if(items.get(i).getId() == itemID){
				System.out.println("Enter New Item Title:");
				String item_title = scanner.nextLine();
				items.get(i).setTitle(item_title);
				return;
			}
		}
		throw new ItemNotExistException("Item not found!");
	}


	public void editClientByID(int clientID) throws ClientNotExistException{
		for(int i = 0; i<clients.size(); i++){
			if(clients.get(i).getId() == clientID){
				System.out.println("Enter New Client Name:");
				String client_name = Validation.inputString();
				clients.get(i).setName(client_name);
				
				System.out.println("Enter New Client Email:");
				String client_email = scanner.nextLine();
				clients.get(i).setEmail(client_email);
				return;
			}
		}
		throw new ClientNotExistException("Client not found!");
	}

    public void removeItemById(int itemID) throws ItemNotExistException{
        LibraryItem item = retrieveItemByID(itemID);
        items.remove(item);
    }
	
	public void displayAllItems(){
		if(items.isEmpty()){
			System.out.println("***  No items found!  ***\n");
			return;
		}
		for(LibraryItem item:items){
			System.out.println(item.displayItemDetails());
		}
	}
	
	public Client retrieveClientByID(int clientID) throws ClientNotExistException{
		/*
		for(Client client:clients){
			if(client.getId() == clientID){
				return client;
			}
		}
		throw new ClientNotExistException("Client Not Found!");
		*/
		Client client = clients.stream()
					.filter(c -> c.getId() == clientID)
					.findFirst() //-> .findFirst() returns the first matching object and retrieves it then .orElse(null) returns null if no object is retrieved -- .findFirst().orElse(null)
					.orElse(null);
							
		if(client != null){
			return client;
		}
		throw new ClientNotExistException("Client Not Found!");
	}
	
    public void removeClientById(int clientID) throws ClientNotExistException {
        Client client = retrieveClientByID(clientID);
        clients.remove(client);
    }
	
	public void displayClientByID(int clientID) throws ClientNotExistException{
		for(Client client:clients){
			if(client.getId() == clientID){
				System.out.println(client.getClientDetails());
				return;
			}
		}
		throw new ClientNotExistException("Client Not Found!");
	}
	
	
	public void displayAllClients(){
		if(clients.isEmpty()){
			System.out.println("No Clients found!");
			return;
		}
		for(Client client:clients){
			System.out.println(client.getClientDetails());
		}
	}
	
	public boolean addClient(Client client){
		
		if(!ClientIDExists(client.getId())){
			clients.add(client);
			return true;
		}
		return false;
		
	}
}