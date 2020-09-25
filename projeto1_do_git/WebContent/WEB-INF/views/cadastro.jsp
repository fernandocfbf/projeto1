<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cadastrar</title>
</head>
<body>
<form action="cadastro" method="post">
	Usuário: <input type='text' name='usuario'><br>
	Senha: <input type='text' name='senha'><br>
	<input type='submit' value='cadastrar'>
	
	<h3>${login}</h3>
</form>

</body>
</html>