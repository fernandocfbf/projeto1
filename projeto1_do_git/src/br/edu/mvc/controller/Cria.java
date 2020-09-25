package br.edu.mvc.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.mvc.model.DAO;

@WebServlet("/cria")
public class Cria extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
		throws ServletException, IOException {
		try {
		
			DAO dao = new DAO();
			Tarefas tarefa = new Tarefas();
			tarefa.setTarefa(request.getParameter("tarefa_para_adicionar"));
			tarefa.setMateria(request.getParameter("materia_para_adicionar"));
			
			
			String data = request.getParameter("data_para_adicionar");
			Date data_;
			data_ = new SimpleDateFormat("yyyy-MM-dd").parse(data);
			 
			Calendar dataData = Calendar.getInstance();
			dataData.setTime(data_);
			tarefa.setData_entrega(dataData);
			
			
			
			tarefa.setUsuario(request.getParameter("usuario_para_adicionar"));
		
			dao.adiciona(tarefa);
			
			System.out.println(tarefa.getUsuario() + " do cria post");
			
			request.setAttribute("usuario", tarefa.getUsuario());
			RequestDispatcher dispatcher = request.getRequestDispatcher("lista");
			dispatcher.forward(request, response);
			
			dao.close();
			
		}catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
	}
}
