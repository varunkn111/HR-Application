/*package com.th.hr.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.client.RestTemplate;

import com.th.hr.model.Department;

@WebServlet(
        name = "departmentServlet",
        urlPatterns = {"/dept"},
        loadOnStartup = 1
)
public class DepartmentServlet extends HttpServlet {
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
           
            {   
            String deptId = request.getParameter("deptId");
            if ("delete".equals(request.getParameter("action")))
         	{
         	System.out.println("in delete"+deptId);
    			deleteDepartment(request,response,deptId);
         	}
		if(deptId==null)
            listDepartments(request,response);
        else
            findDepartment(request, response, deptId);
                
        }
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
		 String deptId = request.getParameter("deptId");
		
	
		this.createDepartment(request, response);
     	
				
			
    }
	
    	
	
	
    	private void deleteDepartment(HttpServletRequest request, HttpServletResponse response, String deptId) throws IOException, ServletException {
    		System.out.println("in delete dept"+deptId);
    		RestTemplate rt = new RestTemplate();
			String uri ="http://localhost:8084/HrService/department/delete/"+deptId;
			System.out.println(uri);			
			Department department = rt.getForObject(uri, Department.class);
			List departmentList = listDepartments(request,response);
			HttpSession session = request.getSession();
			session.setAttribute("departmentList", departmentList);
			System.out.println("Session Id: "+session.getId());
			request.getRequestDispatcher("departmentlist.jsp").forward(request, response);
			
	    	
	    	
			String uri = "http://localhost:8084/HrService/department/"+deptId ;
			Map<String, String> params = new HashMap<String, String>();
		    params.put("id", "2");
		     
		    RestTemplate restTemplate = new RestTemplate();
		    restTemplate.delete ( uri,  params );
			//Department dept = rt.delete(uri, urlVariables);
			//Department dept = rt.getForObject(uri, Department.class);
		
	}
		private void createDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException {
    		Department dept = new Department();
    		RestTemplate rt = new RestTemplate();
			PrintWriter pw = response.getWriter();	
			
			dept.setDepartmentName(request.getParameter("departmentName"));
			dept.setManagerId(request.getParameter("managerId"));
			dept.setLocationId(Integer.parseInt(request.getParameter("locationId")));
			dept.setDepartmentDetail(request.getParameter("departmentDetail"));
			String uri = "http://localhost:8084/HrService/department/create";
			Department department = rt.postForObject(uri, dept, Department.class);
	}
		private void listDepartments(HttpServletRequest request, HttpServletResponse response) throws IOException {
    		String uri = "http://localhost:8084/HrService/department/list" ;
    		RestTemplate rt = new RestTemplate();
    		PrintWriter pw = response.getWriter();
    		//Department dept = rt.getForObject(uri, Department.class);
    		Department[] departments = rt.getForObject(uri, Department[].class);
    		
    			pw.println("<html> "
    					+ "<head>"
    					+ "<title>HR Department </title>"
    					+ "</head>"
    					+ "<body>"
    					+ "<table>"
    					+ "<tr>"
    					+ "<th>DepartmentID</th>"
    					+ "<th>Department Name</th>"
    					+ "<th>Manager ID</th>"
    					+ "<th>Location ID</th>"
    					
    					
    					);
    					for(Department dept:departments){
    					pw.println("<tr>"
    							+ "<th>"+dept.getDepartmentId()+"</th>"
    							+"<th>"+dept.getDepartmentName()+"</th>"
    									+"<th>"+dept.getManagerId()+"</th>"
    											+"<th>"+dept.getLocationId()+"</th>"
    													+"<th>"+dept.getDepartmentDetail()+"</th>"
    									+ "</tr>");
    		
    			
    					}
    				pw.println("</table>"
    						+ "</body>"
    						+ "</html>");	 
    		
		
		
	}
		private List listDepartments(HttpServletRequest request, HttpServletResponse response) {
			String uri = "http://localhost:8084/HrService/department/list" ;
			RestTemplate rt = new RestTemplate();
			
			
			//List<Department> departments = (List<Department>) rt.getForObject(uri,ArrayList.class);
			Department[] departments = rt.getForObject(uri, Department[].class);
			List list = Arrays.asList(departments);
			return list;
		}


		private void findDepartment(HttpServletRequest request, HttpServletResponse response, String deptId) throws IOException {
			RestTemplate rt = new RestTemplate();
			PrintWriter pw = response.getWriter();
			
	    	
	    	
			String uri = "http://localhost:8084/HrService/department/"+deptId ;
			Department dept = rt.getForObject(uri, Department.class);
			pw.println(dept.getDepartmentId()+" "+dept.getDepartmentName()+" "
					+dept.getManagerId()+" "+dept.getLocationId());
			


    	}

    }


*/