package common.edu.cn.servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class selectwords extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String file=request.getParameter("file");
		System.out.println(file);
		//FileReader fr=new FileReader(file);
		
		
		String word=request.getParameter("word");
		Integer number=Integer.valueOf(request.getParameter("number"));
		
		//System.out.println(word+number);
	}

}
