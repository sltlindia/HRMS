package com.hrms.assetmanagement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.assetmanagement.bean.MachineDetailBean;
import com.hrms.assetmanagement.dao.AllInsertAssetDAO;
import com.hrms.pms.bean.EmployeeBean;

public class MachineDetailInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
			
			String machine_type = request.getParameter("machine_type");
			String party_name = request.getParameter("party_name");
			String machine_no = request.getParameter("machine_no");
			String project_no = request.getParameter("project_no");
			String sltl_sr_no = request.getParameter("sltl_sr_no");
			String pc_sr_no = request.getParameter("pc_sr_no");
			String place = request.getParameter("place");
			String system_type = request.getParameter("system_type");
			String supply = request.getParameter("supply");
			
			System.out.println("machine_type" + machine_type);
			System.out.println("party_name" + party_name);
			System.out.println("machine_no" + machine_no);
			System.out.println("project_no" + project_no);
			System.out.println("sltl_sr_no" + sltl_sr_no);
			System.out.println("pc_sr_no" + pc_sr_no);
			System.out.println("place" + place);
			System.out.println("system_type" + system_type);
			System.out.println("supply" + supply);
			
			
			AllInsertAssetDAO allInsertAssetDAO = new AllInsertAssetDAO();
			MachineDetailBean machineDetailBean = new MachineDetailBean(machine_type, party_name, machine_no, project_no, place, sltl_sr_no, pc_sr_no, system_type, supply);
			
			boolean result = allInsertAssetDAO.machineDetailInsert(machineDetailBean);
			
			int machine_detail_id = machineDetailBean.getMachine_detail_id();
			
			if(result == true){
				
				request.setAttribute("machine_detail_id", machine_detail_id);
				request.getRequestDispatcher("machineCheckPoints.jsp").forward(request, response);
				System.out.println("Inserted.....");
				
			}else{
			
			}
			
			
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	}	
	

}