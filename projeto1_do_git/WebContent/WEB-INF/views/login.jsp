<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<form action="login" method="post">
	Usuário: <input type='text' name='usuario'><br>
	Senha: <input type='text' name='senha'><br>
	<input type='submit' value='login'>
	
	<h3>${login}</h3>
</form>

<form action="cadastro" method="get">
	<input type='submit' value='cadastrar-se'>
</form>



</body>
</html>