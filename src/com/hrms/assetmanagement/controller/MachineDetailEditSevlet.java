

/*Name : Bhoomi Patel
Action : Servlet For machine_detail_tbl update */


package com.hrms.assetmanagement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.assetmanagement.bean.MachineCheckPointsBean;
import com.hrms.assetmanagement.bean.MachineDetailBean;
import com.hrms.assetmanagement.bean.MachineSystemReportBean;
import com.hrms.assetmanagement.dao.AllListAssetDAO;
import com.hrms.assetmanagement.dao.AllUpdateAssetDAO;
import com.hrms.pms.bean.EmployeeBean;

/**
 * Servlet implementation class EditSevlet
 */
public class MachineDetailEditSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Servlt Call success");
		
		
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null)
			{
				int machine_detail_id = Integer.parseInt(request.getParameter("machine_detail_id"));
			    String machine_type = request.getParameter("machine_type");
				String party_name = request.getParameter("party_name");
				String machine_no = request.getParameter("machine_no");
				String project_no = request.getParameter("project_no");
				String sltl_sr_no = request.getParameter("sltl_sr_no");
				String pc_sr_no = request.getParameter("pc_sr_no");
				String place = request.getParameter("place");
				String system_type = request.getParameter("system_type");
				String supply = request.getParameter("supply");
				
				int checked_by = Integer.parseInt(request.getParameter("checked_by"));
				String checked_by_date = request.getParameter("checked_by_date");
				int authorised_by = Integer.parseInt(request.getParameter("authorised_by"));
				String authoised_by_date = request.getParameter("authoised_by_date");
				int received_by = Integer.parseInt(request.getParameter("received_by"));
				String received_by_date = request.getParameter("received_by_date");
				int received_authorised_by = Integer.parseInt(request.getParameter("received_authorised_by"));
				String received_authorised_by_date = request.getParameter("received_authorised_by_date");
				
				MachineDetailBean machineDetailBean = new MachineDetailBean(machine_detail_id, machine_type, party_name, machine_no, project_no, place, sltl_sr_no, pc_sr_no, checked_by, checked_by_date, authorised_by, authoised_by_date, received_by, received_by_date, received_authorised_by, received_authorised_by_date, system_type, supply);
				AllUpdateAssetDAO allUpdateAssetDAO = new AllUpdateAssetDAO();
				boolean result = allUpdateAssetDAO.allMachinerDetailUpdate(machineDetailBean);
				System.out.println("updated...");
				
				request.setAttribute("machine_detail_id", machine_detail_id);
				
				AllListAssetDAO allListAssetDAO = new AllListAssetDAO();
				List<MachineCheckPointsBean> listOfMachineCheckPoints = allListAssetDAO.getListOfMachineCheckPoints(machine_detail_id);
				List<MachineSystemReportBean> listOfMachineSystemReport = allListAssetDAO.getListOfSystemReport(machine_detail_id);
				
				if(listOfMachineCheckPoints.size() == 0){
					request.getRequestDispatcher("machineCheckPoints.jsp").forward(request, response);	
				}else if(listOfMachineSystemReport.size() == 0){
					request.getRequestDispatcher("machineSystemReport.jsp").forward(request, response);
				}else{
				request.getRequestDispatcher("machineCheckPointsEdit.jsp").forward(request, response);
				}
				
				
			}else {
				request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		
	}

}
