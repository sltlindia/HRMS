package com.hrms.recruitement.bean;

import java.io.File;
import java.io.IOException;

public class PDFTest {

	public static void main(String[] args) throws IOException {

		
		File f = new File("D:\\backup\\all pdfs");
		int count = 0;
		String match = "absent";
		for (File file : f.listFiles()) {
			//pdfManager.setFilePath("D:\\backup\\all pdfs");
			if (file.isFile()) {
				String word = null;
				count++;
				
				System.out.println("file Name:" + file.toString());
				
				PDFManager pdfManager = new PDFManager();
				pdfManager.setFilePath(file.toString());
				
				word = pdfManager.ToText();

				 //System.out.println(word); 

				if (word.toLowerCase().contains(match.toLowerCase())) {
					System.out.println("match with string : "+file.toString());
				}

			}
		}
		
		System.out.println(count);
	}

	
	

}
