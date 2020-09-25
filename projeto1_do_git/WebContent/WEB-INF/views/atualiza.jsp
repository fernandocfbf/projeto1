<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Atualiza</title>
</head>
<body>

<form action='atualiza' method='post'>
	Tarefa: <input type="text" name="tarefa_alterada" value="${param.tarefa_para_alterar}">
	Materia: <input type="text" name="materia_alterada" value="${param.materia_para_alterar}">
	Data: <input type="text" name="data_alterada" value="${param.data_para_alterar}">
	<input type="hidden" name="usuario_alterado" value="${param.usuario_para_alterar}">
	<input type="hidden" name="id_alterado" value="${param.id_para_alterar}">
	
	<input type="submit" value="Alterar">
</form>

</body>
</html>