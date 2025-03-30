package taskPkg;
import java.util.Scanner; 
public class Validation {
static Scanner scanner = new Scanner(System.in);
	public  static int inputInt(){
	   do{
		   try{
			   int input = scanner.nextInt();
			   scanner.nextLine();
			   if(input <0){
				   throw new Exception();
			   }
			   return input;
		   }catch(Exception e){
			   System.out.println("Enter valid +ve integer");
			   scanner.nextLine(); 
		   }  
	   }while(true);
	   
	}
   
	 static boolean checkIfAlpha(String s){
		for(char c:s.toCharArray()){
			if(!(Character.isLetter(c)))
				return false;
		}
		return true;
	}
	
	//Take input string, the string contain no numbers
	public  static String inputString(){
	   do{
		   try{
			   String input = scanner.nextLine();
			   if(!checkIfAlpha(input)){
				   throw new Exception();
			   }
			   return input;
		   }catch(Exception e){
			   System.out.println("Enter valid Input");
		   }
	   }while(true);
	   
	}
	
	 static boolean checkIfFirstAlpha(String s){
		
		if(!(Character.isLetter(s.charAt(0))))
			return false;
		
		return true;
	}
	
	//Take input string, the string first character is not number
	public  static String inputStringFirstAlpha(){
	   do{
		   try{
			   String input = scanner.nextLine();
			   if(!checkIfFirstAlpha(input)){
				   throw new Exception();
			   }
			   return input;
		   }catch(Exception e){
			   System.out.println("Enter valid Input");
		   }
	   }while(true);
	   
	}
	

	

}