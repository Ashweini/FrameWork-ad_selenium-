package TestNGPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx1 {
	
	@Test(dataProvider = "dataProviderData")
	public void bookTickets(String src, String dest, int NumOfppl) {
		System.out.println("Book Ticket from "+src+" to "+dest+" "+NumOfppl);
	}
	
	@DataProvider
	public Object[][] dataProviderData(){
		Object[][] onjArr = new Object[2][3];
		onjArr[0][0]="Bangalore";
		onjArr[0][1]="Goa";
		onjArr[0][2]=3;
		
		onjArr[1][0]="Bangalore";
		onjArr[1][1]="Mysore";
		onjArr[1][2]=3;
		
		return onjArr;
	}
	
	

}
