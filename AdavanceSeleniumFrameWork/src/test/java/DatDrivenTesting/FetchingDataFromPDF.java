package DatDrivenTesting;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class FetchingDataFromPDF {

	public static void main(String[] args) throws Throwable {

		File file = new File("./src/test/resources/Object.pdf");
		PDDocument pdDoc = PDDocument.load(file);
		
		//number of pages in pdf
		int pages = pdDoc.getNumberOfPages();
		System.out.println(pages);
		
		//read entire pdf
		PDFTextStripper data = new PDFTextStripper();
//		String read = data.getText(pdDoc);
//		System.out.println(read);
		
		//one perticular page data from 3rd page
//		data.setStartPage(3);
//		System.out.println(data.getText(pdDoc));
		
		//to read that perticular file given start and end page number
		data.setStartPage(3);
		data.setEndPage(3);
		System.out.println(data.getText(pdDoc));
	}

}
