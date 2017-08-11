package com.hrms.recruitement.bean;

import java.io.FileInputStream;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

public class ReadDocFile {

	
	public static void main (String []args)
	{
		try 
		{
			//File file = new File("D:\\Self employed documents.doc");
			//System.out.println("sachin");
			FileInputStream fis = new FileInputStream("Self employed documents.doc");
			System.out.println("fileinputstream"+fis);
			HWPFDocument doc = new HWPFDocument(fis);

			WordExtractor we = new WordExtractor(doc);

			String[] paragraphs = we.getParagraphText();

			System.out.println("Total no of paragraph " + paragraphs.length);

			String text = we.getText();
			System.out.println(text);
			
			  for (String para : paragraphs) 
			  { 
				  System.out.println(para); 
			  }
			  fis.close();
			 
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
}
