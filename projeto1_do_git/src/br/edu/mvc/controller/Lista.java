package br.edu.mvc.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import br.edu.mvc.model.DAO;

import javax.servlet.annotation.WebServlet;

@WebServlet("/lista")

public class Lista extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	
		throws ServletException, IOException {
			DAO dao = new DAO();
			
			String usuario = request.getParameter("usuario");
			String usuario_final = null;
			
			if (usuario == null) {
				usuario_final = (String) request.getAttribute("usuario");
			}else {
				usuario_final = usuario;
			}
			
			System.out.println(usuario_final);
			
			List<Tarefas> tarefas = dao.getLista(usuario_final);
			
			request.setAttribute("tarefas", tarefas);
			request.setAttribute("usuario", usuario_final);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/lista.jsp");
			dispatcher.forward(request, response);

			dao.close();
		}
	
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
		throws ServletException, IOException {
			
			doGet(request, response);
	}
	
}
