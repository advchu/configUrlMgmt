package com.apple.url.configuration;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.apple.url.configuration.utility.ConstantUtility;
import com.apple.url.configuration.utility.PropertyFileLoad;
@WebServlet(value = "/location")
public class UrlConfiguration extends HttpServlet { 
	private static final long serialVersionUID = 1L; 
	   protected void doGet(HttpServletRequest request, HttpServletResponse response)  
	      throws ServletException, IOException{ 
		   try {
			   String locationId[]=request.getParameter("ls").split(";");
			   String actual_location=locationId[0].trim();
			   PropertyFileLoad prob=new PropertyFileLoad();
			   if(actual_location.equalsIgnoreCase(ConstantUtility.SCV)) {
			   response.sendRedirect(prob.propLoad().getProperty(ConstantUtility.PROP_SCV));
			   }else if(actual_location.equalsIgnoreCase(ConstantUtility.APPLE)) {
				response.sendRedirect(prob.propLoad().getProperty(ConstantUtility.PROP_APPLE));
			   }else if(actual_location.equalsIgnoreCase(ConstantUtility.AUSTIN)) {
				response.sendRedirect(prob.propLoad().getProperty(ConstantUtility.PROP_AUSTIN));
			   }else {
				   response.sendRedirect(prob.propLoad().getProperty(ConstantUtility.PROP_ERROR));
			   }
		   }
		   catch (Exception e) {
			   e.printStackTrace();
			   RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
		   }
	   }   	 
}
