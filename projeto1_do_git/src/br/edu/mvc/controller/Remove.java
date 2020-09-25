package br.edu.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.mvc.model.DAO;

@WebServlet("/remove")

public class Remove extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
			DAO dao = new DAO();
			dao.remove(Integer.valueOf(request.getParameter("id")));
			
			String usuario = request.getParameter("usuario_para_remover");
			System.out.println(usuario + "remove");
			
			request.setAttribute("usuario", usuario);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("lista");
			dispatcher.forward(request, response);
			
			
			dao.close();
			
		}
}