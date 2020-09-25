package br.edu.mvc.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.mvc.model.DAO;

@WebServlet("/atualiza")
public class Atualiza extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException, IOException {
			
		RequestDispatcher dispacher = request.getRequestDispatcher("WEB-INF/views/atualiza.jsp");
		dispacher.forward(request, response);
		}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		try {
		DAO dao = new DAO();
		Tarefas tarefa = new Tarefas();
		tarefa.setId(Integer.valueOf(request.getParameter("id_alterado")));
		tarefa.setTarefa(request.getParameter("tarefa_alterada"));
		tarefa.setMateria(request.getParameter("materia_alterada"));
		
		
		String data = request.getParameter("data_alterada");
		Date data_;
		data_ = new SimpleDateFormat("yyyy-MM-dd").parse(data);
		Calendar dataData = Calendar.getInstance();
		dataData.setTime(data_);
		tarefa.setData_entrega(dataData);
		
		String usuario = request.getParameter("usuario_alterado");
		
		request.setAttribute("usuario", usuario);
		
		System.out.println(usuario + "atualiza");
		
		dao.altera(tarefa);
		
		RequestDispatcher dispacher = request.getRequestDispatcher("lista");
		dispacher.forward(request, response);
		
		dao.close();
		
		}catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		
		}
	}
}
