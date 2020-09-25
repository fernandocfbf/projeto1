package br.edu.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.mvc.model.DAO;


@WebServlet("/buscar")

public class Buscar extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = new DAO();
		
		String usuario = request.getParameter("usuario_para_buscar");
		String busca = request.getParameter("busca");
		
		System.out.println(usuario);
		
		List<Tarefas> tarefas = dao.buscar(usuario, busca);
		
		request.setAttribute("tarefas", tarefas);
		request.setAttribute("usuario", usuario);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/lista.jsp");
		dispatcher.forward(request, response);

		dao.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
