/*package com.th.hr.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.client.RestTemplate;

import com.th.hr.resource.LoginResource;
import com.th.hr.model.Department;
import com.th.hr.model.Login;


@WebServlet(
        name = "LoginServlet",
        urlPatterns = {"/LoginServlet"},
        loadOnStartup = 1
)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   
		   RestTemplate restTemplate = new RestTemplate();
		   String uri = "http://localhost:8084/HrService/login";
		   String userId, password;
		   userId = request.getParameter("userId");
		   password = request.getParameter("password");
		   Login login = new Login();
		   login.setUserId(userId);
		   login.setPassword(password);		   
		   Login userLogin = restTemplate.postForObject(uri, login, Login.class);
		   
		   if(userLogin!=null){
				List departmentList = listDepartments(request,response);
				HttpSession session = request.getSession();
				session.setAttribute("departmentList", departmentList);
				System.out.println("Session Id: "+session.getId());
				//request.setAttribute("employeeList", employeeList);
				//request.getRequestDispatcher("employeeList.jsp").forward(request, response);
				response.sendRedirect("departmentlist.jsp");
				System.out.println("User Name: "+userLogin.getUserId());
				System.out.println("Password: "+userLogin.getPassword());
			   
			}else{
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			System.out.println(userLogin);
			
		   
		   //System.out.println(userLogin);
	}
	
	private List listDepartments(HttpServletRequest request, HttpServletResponse response) {
		String uri = "http://localhost:8084/HrService/department/list" ;
		RestTemplate rt = new RestTemplate();
		
		
		//List<Department> departments = (List<Department>) rt.getForObject(uri,ArrayList.class);
		Department[] departments = rt.getForObject(uri, Department[].class);
		List list = Arrays.asList(departments);
		return list;
	}

}*/