package comparePDF;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.annotations.Test;

public class ComparePDFcontent {
	@Test
	public void ReadPDF() throws IOException {
		
		// Retrieve the First PDF text content
		FileInputStream file1 = new FileInputStream(
				"C:/Users/User/eclipse-workspace/CucumberProject8/sample-pdf.pdf");
		PDDocument file1Doc = PDDocument.load(file1);
		PDFTextStripper file1PDFStrp = new PDFTextStripper();
		String Str1 = file1PDFStrp.getText(file1Doc);
		// Write PDF text to .txt file
		try (PrintWriter out1 = new PrintWriter("file1.txt")) {
			out1.println(Str1);
		}
		
		// Retrieve the Second PDF text content
		FileInputStream file2 = new FileInputStream(
				"C:/Users/User/eclipse-workspace/CucumberProject8/sample-pdf-modified.pdf");
		PDDocument file2Doc = PDDocument.load(file2);
		PDFTextStripper file2PDFStrp = new PDFTextStripper();
		String Str2 = file2PDFStrp.getText(file2Doc);
		// Write PDF text to .txt file
		try (PrintWriter out2 = new PrintWriter("file2.txt")) {
			out2.println(Str2);
		}
		
		// Output file to capture the differences in the text content of the given PDFs
		PrintWriter out3 = new PrintWriter("Outfile.txt");
		out3.println("*************PDF text Comparision results**********");

		//Read the generated text files
		BufferedReader reader1 = new BufferedReader(new FileReader("file1.txt"));
		BufferedReader reader2 = new BufferedReader(new FileReader("file2.txt"));

		String line1 = reader1.readLine();
		String line2 = reader2.readLine();
		int lineNum = 1;
        
		//Compare the text files line-wise
		while (line1 != null || line2 != null) {
			boolean areEqual = true;
			if (line1 == null || line2 == null) {
				areEqual = false;
			} else if (!line1.equalsIgnoreCase(line2)) {
				areEqual = false;
				// break;
			}
			if (areEqual) {
				System.out.println("Line Number:" + lineNum + " Two PDF files have same content.");
			} else {
				System.out.println("Line Number:" + lineNum + " Two PDF files have different content at this line ");
				System.out.println("File1 has: " + line1);
				System.out.println("File2 has: " + line2);
        //Write the differences in text to 'Outfile.txt' after comparing each line
				out3.println("Line Number:" + lineNum + " Two PDF files have different content at this line ");
				out3.println("File1 has: " + line1);
				out3.println("File2 has: " + line2);
			}
			line1 = reader1.readLine();
			line2 = reader2.readLine();
			lineNum++;
		}
		//Close the I/O files
		reader1.close();
		reader2.close();
		out3.close();
	}
}
