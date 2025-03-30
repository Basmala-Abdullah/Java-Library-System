package taskPkg;
import java.util.ArrayList;
import java.util.List;
import taskPkg.myExceptions.ItemNotExistException;

public class Client{
	private int id;
	private String name;
	private String email;
	

    public Client(int id, String name, String email) {
        this.id = id;
        this.name = name;
		this.email=email;
		
    }
	public void setName(String name){
		this.name = name;
	}
	
	public void setEmail(String email){
		this.email=email;
	}
	
	
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
	
	public String getEmail() {
        return email;
    }
	
	public String getClientDetails(){
		return "Client[ID: " + getId() + ", Name: " + getName() + ", Email: " + getEmail() + "]";
	}
	

}