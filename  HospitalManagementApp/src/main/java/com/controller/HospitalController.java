package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.HospitalInterfaceDAO;
import com.dao.HospitalInterfaceDAOImpl;
import com.dao.UserInterfaceDAO;
import com.dao.UserInterfaceDAOImp;
import com.model.Hospital;
import com.model.User;

/**
 * Servlet implementation class HospitalController
 */
public class HospitalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HospitalInterfaceDAO hifi = null;
	RequestDispatcher dispatcher = null;
     UserInterfaceDAO uifi=null;
     HttpSession session=null;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HospitalController() {
		hifi = new HospitalInterfaceDAOImpl();
		uifi=new UserInterfaceDAOImp();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(action);
      
		if (action == null) {
			action = "Login";
		}
		switch (action) {
		case "ADD":
			insertpatient(request, response);
			break;
		case "LIST":
			patientlist(request, response);
			break;
		case "EDIT":
			singlepatient(request, response);
			break;
		case "DELETE":
			deletepatient(request, response);
			break;
		case "LOGIN":
			userlogin(request,response);
			break;
		case "ADDUSER":
			insertuser(request,response);
			break;

		default:
			patientlist(request, response);

		}

	}

	private void insertuser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
      String name=request.getParameter("uname");
      String password=request.getParameter("upassword");
      User user=new User(name,password);
      if(uifi.insertUser(user)) {
    	  request.setAttribute("NOTIFICATION", "user added succesfully");
    	  dispatcher=request.getRequestDispatcher("/views/login_form.jsp");
    	  dispatcher.forward(request, response);
      }
      else {
    	  request.setAttribute("NOTIFICATION", "Somthing went wrong");
      }
      }
		

	private void userlogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String name=request.getParameter("uname");
	      String password=request.getParameter("upassword");
	      User user=new User(name,password);
	     if(uifi.loginUser(user)) {
	    	 request.setAttribute("NOTIFICATION", "login succesfully");
	    	 session=request.getSession();
	    	 session.setAttribute("session",name);  
	    	 dispatcher=request.getRequestDispatcher("/views/patient_form.jsp");
	    	dispatcher.forward(request, response);
	     }
	     else {
	    	  request.setAttribute("NOTIFICATION", "Something went wrong");
	    	  dispatcher=request.getRequestDispatcher("/views/login_form.jsp");
	    	  dispatcher.forward(request, response);
	     }	
	     
	}

	private void deletepatient(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		if (hifi.deletePatientById(Integer.parseInt(id))) {
			request.setAttribute("NOTIFICATION", "patient deleted succesfully");
		}
		patientlist(request, response);

	}

	private void singlepatient(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		Hospital hos = hifi.viewPatientById(Integer.parseInt(id));
		request.setAttribute("hospital", hos);
		dispatcher = request.getRequestDispatcher("/views/patient_form.jsp");
		dispatcher.forward(request, response);
	}

	private void insertpatient(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		Hospital hospital = new Hospital();
		hospital.setName(request.getParameter("name"));
		hospital.setEmail(request.getParameter("email"));
		hospital.setAddress(request.getParameter("address"));
		hospital.setContact(request.getParameter("contact"));
		System.out.println(id + "hello");
		if (id.isEmpty() || id == null) {
			if (hifi.insertPatient(hospital)) {
				request.setAttribute("NOTIFICATION", "patient added succesfully");
			}
		} else {
			hospital.setId(Integer.parseInt(id));
			if (hifi.updatePatient(hospital)) {
				request.setAttribute("NOTIFICATION", "patient updated succesfully");
			}
		}
		patientlist(request, response);

	}

	private void patientlist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                                                                    		// TODO Auto-generated method stub
		ArrayList<Hospital> al = hifi.viewAllPatient();
		request.setAttribute("list", al);
	    //.setAttribute("session","name");
		dispatcher = request.getRequestDispatcher("/views/patient_list.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
