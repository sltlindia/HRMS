package com.hrms.recruitement.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;

import com.hrms.pms.bean.EmployeeDummyBean;
import com.hrms.recruitement.bean.VacancyFormBean;
import com.hrms.recruitement.dao.AllInsertDAO;

public class ResumeUploadDemo extends HttpServlet{
	static int vacancy_id = 0;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void send(String uploadAttachment,int v_id) {
		vacancy_id = v_id;
		System.out.println("D:\\Workspace\\HRMS\\WebContent\\upload\\CriteriaAttchment\\"+uploadAttachment);
	        List<ResumeUpload> resumes = readResumeFromCSV("D:\\Workspace\\HRMS\\WebContent\\upload\\CriteriaAttchment\\"+uploadAttachment);
	        // let's print all the person read from CSV file
	        for (ResumeUpload r : resumes) {
	            System.out.println("Chirag:"+r);
	        }
	    }

	    private static List<ResumeUpload> readResumeFromCSV(String fileName) {
	        List<ResumeUpload> resumes = new ArrayList<>();
	        Path pathToFile = Paths.get(fileName);
			System.out.println("akash:"+fileName);
	        // create an instance of BufferedReader
	        // using try with resource, Java 7 feature to close resources
	        try (BufferedReader br = Files.newBufferedReader(pathToFile,
	                StandardCharsets.US_ASCII)) {
	        	System.out.println("bhoomi:"+fileName);

	            // read the first line from the text file
	            String line = br.readLine();

	            // loop until all lines are read
	            while (line != null) {

	                // use string.split to load a string array with the values from
	                // each line of
	                // the file, using a comma as the delimiter
	                String[] attributes = line.split(",");

	                ResumeUpload resumes1 = createResume(attributes);

	                // adding book into ArrayList
	                resumes.add(resumes1);
	        		
	                // read next line before looping
	                // if end of file reached, line would be null
	                line = br.readLine();
	            }

	        } catch (IOException ioe) {
	            ioe.printStackTrace();
	        }
	        System.out.println("ripal:"+fileName);
			return resumes;
			
	    }
	   
		private static ResumeUpload createResume(String[] metadata) { 
	    	
			String name = metadata[0];
	    	System.out.println("name" +name);
	        String mob_num  = metadata[1];
		    System.out.println("mob_num" +mob_num);
	        String birth_date = metadata[2];
	        System.out.println("birth_date" +birth_date);
	        String email_id  = metadata[3];
		    System.out.println("email_id" +email_id);
	        String work_experience  = metadata[4];
	        System.out.println("work_experience" +work_experience);
	        String current_location  = metadata[5];
	        System.out.println("current_location" +current_location);
	        String current_employer  = metadata[6];
	        System.out.println("current_employer" +current_employer);
	        String current_designation  = metadata[7];
	        System.out.println("current_designation" +current_designation);
	        String annual_salary  = metadata[8];
	        System.out.println("annual_salary" +annual_salary);
	        String adress = metadata[9];
	        System.out.println("adress"+adress);

	   // create and return book of this metadata
	        return new ResumeUpload(name,mob_num,birth_date,email_id,work_experience,current_location,current_employer,current_designation,annual_salary ,adress,vacancy_id);
	    }
	   
	}

	class ResumeUpload {
		
	    private String name;
	    private String mob_num;
	    private String birth_date;
	    private String email_id;
	    private String work_experience;
	    private String current_location;
	    private String current_employer;
	    private String current_designation;
	    private String annual_salary;
	    private String adress;
	    private int vacancy_id;
	    

	   public ResumeUpload(String name,String mob_num,String birth_date,String email_id,String work_experience,String current_location,String current_employer,String current_designation,String annual_salary,String adress,int vacancy_id) {
		   this.name = name;
		   this.mob_num = mob_num;
		   this.birth_date = birth_date;
		   this.email_id = email_id;
		   this.work_experience = work_experience;
		   this.current_location = current_location;
		   this.current_employer = current_employer;
		   this.current_designation = current_designation;
		   this.annual_salary = annual_salary;
		   this.adress = adress;
		   this.vacancy_id = vacancy_id;
	   }



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAdress() {
		return adress;
	}



	public void setAdress(String adress) {
		this.adress = adress;
	}



	public String getMob_num() {
		return mob_num;
	}



	public void setMob_num(String mob_num) {
		this.mob_num = mob_num;
	}



	public String getBirth_date() {
		return birth_date;
	}



	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}



	public String getEmail_id() {
		return email_id;
	}



	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}



	public String getWork_experience() {
		return work_experience;
	}



	public void setWork_experience(String work_experience) {
		this.work_experience = work_experience;
	}



	public String getCurrent_location() {
		return current_location;
	}



	public void setCurrent_location(String current_location) {
		this.current_location = current_location;
	}



	public String getCurrent_employer() {
		return current_employer;
	}



	public void setCurrent_employer(String current_employer) {
		this.current_employer = current_employer;
	}



	public String getCurrent_designation() {
		return current_designation;
	}



	public void setCurrent_designation(String current_designation) {
		this.current_designation = current_designation;
	}



	public String getAnnual_salary() {
		return annual_salary;
	}



	public void setAnnual_salary(String annual_salary) {
		this.annual_salary = annual_salary;
	}

	


	public int getVacancy_id() {
		return vacancy_id;
	}



	public void setVacancy_id(int vacancy_id) {
		this.vacancy_id = vacancy_id;
	}



	@Override
	    public String toString() {
			
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		VacancyFormBean vacancyFormBean = new VacancyFormBean();
		vacancyFormBean.setVacancy_id(vacancy_id);
		
		boolean result = allInsertDAO.resumedataInsert1(name,mob_num,birth_date,email_id,work_experience,current_location,current_employer,current_designation,adress,annual_salary,vacancyFormBean);
			
			return "ResumeUpload[name=" + name + ", mob_num=" + mob_num + ",birth_date=" + birth_date + ",email_id=" + email_id + ",work_experience=" + work_experience + ","
					+ "current_location=" + current_location + ",current_employer=" + current_employer + ",current_designation=" + current_designation + ",adress=" + adress + ",annual_salary=" + annual_salary 
					  + "]";
			
	    }

}
