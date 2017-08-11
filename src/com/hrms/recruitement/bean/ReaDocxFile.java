package com.hrms.recruitement.bean;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

public class ReaDocxFile {

	public static void main(String[] args) {

		try {
			FileInputStream fis = new FileInputStream("Selfemployeddocuments.docx");

			XWPFDocument xwpfDocument = new XWPFDocument(fis);

			List<XWPFParagraph> paragraphList = xwpfDocument.getParagraphs();

			for (XWPFParagraph paragraph : paragraphList) {

				String word = "Proof";

				System.out.println(paragraph.getText());

				if (word == paragraph.toString()) {
					System.out.println("FIND the word");
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
