package com.hrms.recruitement.controller;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import com.hrms.recruitement.bean.PDFManager;

public class ResumeCheckServlet extends HttpServlet 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ...............fetch data from PDF file.....................

		File f = new File("D:\\backup\\all pdfs");
		int count = 0;
		String match = "absent";
		for (File file : f.listFiles()) {

			if (file.isFile()) {
				String word = null;
				count++;

				System.out.println("file Name:" + file.toString());

				try {
					PrintWriter out = response.getWriter();
					out.println("\n data we got too : ");

					PDFManager pdfManager = new PDFManager();
					pdfManager.setFilePath(file.toString());
					word = pdfManager.ToText();
					System.out.println(word);

					if (word.toLowerCase().contains(match.toLowerCase())) {
						System.out.println("match with string : " + file.toString());
						System.out.println("/n");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
		System.out.println(count);

		// ................code for fetch all docx file................

		File f1 = new File("D:\\backup\\word");
		int count1 = 0;
		for (File file1 : f1.listFiles()) {

			if (file1.isFile()) {
				count1++;
				System.out.println("file Name:" + file1.toString());
				System.out.println("\n");
				try {
					FileInputStream fis = new FileInputStream(file1.toString());
					XWPFDocument xwpfDocument = new XWPFDocument(fis);
					List<XWPFParagraph> paragraphList = xwpfDocument.getParagraphs();
					for (XWPFParagraph paragraph : paragraphList) {
						String word1 = "sachin";
						System.out.println(paragraph.getText());
						if (word1 == paragraph.toString()) {
							System.out.println("FIND the word");
						}
					}
				} 
				catch (FileNotFoundException e) 
				{
					e.printStackTrace();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
			System.out.println(count1);
		}

			// ...................code for doc file.......................

			/*try 
			{
				//File file = new File("D:\\Self employed documents.doc");
				//System.out.println("sachin");
				FileInputStream fis = new FileInputStream("D:\\Self employed documents.doc");
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
			}*/
		
	
}
	
}
