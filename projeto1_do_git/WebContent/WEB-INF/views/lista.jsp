<%@ page language= "java" contentType= "text/html;charset=UTF-8" pageEncoding= "UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.*, br.edu.mvc.model.*" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset = "UTF-8">
	<title>lista tarefas</title>
	</head>
	<body>
	
		<h2>Olá, ${usuario}.</h2>
		<form action='cria' method='post'>
			Tarefa: <input type='text' name='tarefa_para_adicionar'><br>
			Materia: <input type='text' name='materia_para_adicionar'><br>
			Data de entrega: <input type='text' name='data_para_adicionar'><br> 
			<input type='hidden' name='usuario_para_adicionar' value="${usuario}"> 
			<input type='submit' value='Adicionar'><br>
		</form>
		
		<form action='buscar' method='get'>
			Buscar: <input type='text' name='busca'>
			<input type='hidden' name='usuario_para_buscar' value="${usuario}"> 
			<input type='submit' value='buscar'>
		</form>
		
		
		<p>Ordenar por:</p>
		
		
		<form action='ordenar' method='post'>
			<input type='hidden' name='ordem' value="materia">
			<input type='submit' value='Matéria'>
			<input type='hidden' name='usuario_para_ordenar' value="${usuario}">
		</form>
		
		<form action='ordenar' method='post'>
			<input type='hidden' name='ordem' value="data">
			<input type='submit' value='Data'>
			<input type='hidden' name='usuario_para_ordenar' value="${usuario}">
		</form>
		
		
		<table border='1'> 
		
		<tr>
			<td>TAREFA</td>
			<td>MATÉRIA</td>
			<td>DATA</td>
		</tr>
			<c:forEach var="tarefa" items="${tarefas}">
					<tr>
						
						<td>${tarefa.tarefa}</td>
						<td>${tarefa.materia}</td>
						<td>${tarefa.data_entrega.time}</td>
						<td>
							<form action='remove' method='post'>
								<input type="hidden" name='id' value= "${tarefa.id}">
								<input type='hidden' name='usuario_para_remover' value="${usuario}">
								<input type='submit' value='Deletar'>
							</form>
						</td>
						
						<td>
							<form action='atualiza' method='get'>
								<input type="hidden" name='tarefa_para_alterar' value="${tarefa.tarefa}">
								<input type="hidden" name='materia_para_alterar' value="${tarefa.materia}">
								<input type="hidden" name='data_para_alterar' value="${tarefa.data_entrega.time}">
								<input type="hidden" name='id_para_alterar' value="${tarefa.id}">
								<input type='hidden' name='usuario_para_alterar' value="${usuario}">
								<input type='submit' value='Alterar'>
							</form>
						</td>
					</tr>
			</c:forEach>
		</table>
		
		<footer>
		
			<form action="login" method="get">
				<input type='submit' value='Log Out'>
			</form>
		
		</footer>
	</body>
</html>