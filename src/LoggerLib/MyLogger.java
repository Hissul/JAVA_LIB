package LoggerLib;

import java.io.*;

public class MyLogger implements Loggerable  {

	public String message ;
	

	@Override
	public void DeleteMessage() {
		
		message = "";
	}

	@Override
	public void ShowMessage() {
		System.out.println(message);		
	}



	@Override
	public String AddMessage(float average, String student) {	
				
		if(average < 2) {
			message = student + " -> Bad";
		}
		else if(average >= 2 && average <= 4) {
			message = student + " -> Norm";
		}
		else {
			message = student + " -> Good";
		}
		
		SaveMessage();
		ShowMessage();
		
		return message;
	}

	@Override
	public void SaveMessage() {
		
		try(FileWriter writeFile = new FileWriter("Log.txt", true)){
			
			writeFile.write(message + "\n");
		}
		catch(IOException ex){
			System.out.println(ex);
		}			
	}
	
}
