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

@WebServlet("/ordenar")
public class ordenar extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DAO dao = new DAO();
		
		String ordenar_por = request.getParameter("ordem");
		String usuario = request.getParameter("usuario_para_ordenar");
		
		System.out.println(usuario + ordenar_por);
		
		List<Tarefas> tarefas = dao.ordena(ordenar_por, usuario);
	
		
		request.setAttribute("tarefas", tarefas);
		request.setAttribute("usuario", usuario);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/lista.jsp");
		dispatcher.forward(request, response);
		
		dao.close();
		
		
	}

}
