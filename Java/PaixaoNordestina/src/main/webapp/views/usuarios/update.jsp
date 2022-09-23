<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link rel="icon" href="./assets/img/Viagem1.png" type="image/png" />

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="./assets/css/style.css" />
<title>Paixão Nordertina / Cadastrar</title>
</head>
<body>
	<main class="bg-light">
		<div class="container">
			<section class="row caixa">
				<nav
					class="col-md-4 d-flex justify-content-center align-items-center bg-footer">
					<a class="navbar-brand" href="../../index.html"><img
						class="rounded-circle" src="../../assets/img/Viagem2.jpg"
						alt="Logomarca"></a>
				</nav> 
				<article class="col-md-8 caixa-conta">
					<div class="d-flex justify-content-center">
						<h1 class="fonte-titulo mt-5 mb-3">Atualizar</h1>
					</div>
					<!-- form -->
					<form action="../../update-cadastro"
						class="row mt-3 d-flexjustify-content-around">
						<div class="col-12 mb-2">
							<label for="idLogin" class="form-label">ID</label> <input
								type="text" class="form-control" id="idLogin" name="id"
								value="<%=request.getAttribute("id")%>">
						</div>
						<div class="col-12 mb-2">
							<label for="nomeLogin" class="form-label">Nome Completo</label> <input
								type="text" class="form-control" id="nomeLogin" name="nome"
								value="<%=request.getAttribute("nome")%>">
						</div>
						<div class="col-12 mb-2">
							<label for="emailLogin" class="form-label">E-mail</label> <input
								type="email" class="form-control" id="emailLogin" name="email"
								aria-describedby="emailHelpId"
								value="<%=request.getAttribute("email")%>">
						</div>
						<div class="col-md-6 mb-2">
							<label for="senhaLogin" class="form-label">Senha</label> <input
								type="password" class="form-control" id="senhaLogin"
								name="senha" value="<%=request.getAttribute("nome")%>">
						</div>
						<div class="col-md-6 mb-2">
							<label for="senhaLogin" class="form-label">Confirmar
								Senha</label> <input type="password" class="form-control"
								id="senhaLogin">
						</div>

						<div class="mt-4">
							<p class="text m-2">
								<span> ou acesse pela conta </span>
							</p>
						</div>
						<div class="col-md login-conta">
							<div class="facebook">
								<a class="login-facebook" href=""> <i class="bi bi-facebook"></i>
									ENTRAR COM FACEBOOK
								</a>
							</div>
						</div>
						<div class="col-md login-conta">
							<div class="google">
								<a class="login-google" href=""> <i class="bi bi-google"></i>
									ENTRAR COM GOOGLE
								</a>
							</div>
						</div>
						<div class="d-flex justify-content-center mb-3">
							<button type="submit" class="btn botao ">ENTRAR</button>
						</div>
						<div class="col-12 d-flex justify-content-center">
							<p>
								Ja tem conta? <a href="../login">Entre aqui</a>
							</p>
						</div>
					</form>
				</article>
			</section>
		</div>
	</main>
	<footer>
		<div class="d-flex justify-content-center p-4">
			<p>&copy; Paixão Nordestina 2022 - Todos os direitos reservados a
				pagina inicial</p>
		</div>
	</footer>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

	<script src="../../assets/js/script.js"></script>

</body>
</html>