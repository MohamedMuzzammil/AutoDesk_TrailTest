package projectFiles;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class AutoDeskApiTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		URL url=new URL("https://www.autodesk.com/");
		HttpURLConnection  connection=(HttpURLConnection) url.openConnection();
		int responsecode=connection.getResponseCode();
		String responsemessage=connection.getResponseMessage();
		
		System.out.println("The response code is "+responsecode); 
		System.out.println("Te response message is "+responsemessage);

	}

}
