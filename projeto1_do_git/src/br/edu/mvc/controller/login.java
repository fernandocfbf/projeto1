package br.edu.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.mvc.model.DAO;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
     


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/login.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		DAO dao = new DAO();
		
		Boolean login = dao.verificaLogin(usuario, senha);
		
		if(login == true) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("lista");
			dispatcher.forward(request, response);
		}
		else {
			request.setAttribute("login", "Atenção!! Usuário ou senha incorretos!");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/login.jsp");
			dispatcher.forward(request, response);
			
		}
	}


}
