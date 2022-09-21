<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link rel="icon" href="../../assets/img/Viagem1.png" type="image/png" />

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="../../assets/css/style.css" />

<title>Paixão Nordestina / Contato</title>
</head>
<body>
	<header>
		<!-- Incluindo o menu de navegação -->
		<nav class="navbar navbar-expand-lg fixed-top">
			<div class="container-fluid">
				<figure>
					<a class="navbar-brand" href="../../index.html"><img
						class="rounded-circle" src="../../assets/img/Viagem1.png"
						alt="Logomarca paixão nordestina"></a>
				</figure>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarNav"
					aria-controls="navbarNav" aria-expanded="false"
					aria-label="Toggle navigation">
					<span
						class="navbar-toggler-icon d-flex justify-content-center align-items-center"><i
						class="bi bi-list"></i></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link fonte" href="../destino">Destinos</a></li>
						<li class="nav-item"><a class="nav-link fonte"
							href="../promocoes">Promoções</a></li>
						<li class="nav-item"><a class="nav-link fonte"
							href="#">Contato</a></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle fonte" href="#"
							id="navbarDropdownMenuLink" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"> Acesse aqui
						</a>
							<ul class="dropdown-menu"
								aria-labelledby="navbarDropdownMenuLink">
								<li><a class="dropdown-item" href="./cadastrar.html">Cadastrar</a></li>
								<li><a class="dropdown-item" href="./login.html">Entrar</a></li>
								<li><a class="dropdown-item" href="../../permissoes">Permissão</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>

	<main class="bg-main">
		<div>
			<img class="banner" src="../../assets/img/banner.png" alt="">
		</div>
		<div class="container">
			<!-- form -->
			<form>
				<h1 class="fonte-especial">Contato</h1>
				<hr>
				<div class="row">
					<div class="col-md">
						<div class="mb-3">
							<label for="nomeContato" class="form-label">Nome</label> <input
								type="text" class="form-control" id="nomeContato"
								aria-describedby="helpIdNome" placeholder="Nome">
						</div>
					</div>
					<div class="col-md">
						<div class="mb-3">
							<label for="sobrenomeContato" class="form-label">Sobrenome</label>
							<input type="text" class="form-control" id="nomeContato"
								aria-describedby="helpIdSobrenome" placeholder="Sobrenome">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md">
						<div class="mb-3">
							<label for="emailContato" class="form-label">Email</label> <input
								type="email" class="form-control" id="emailContato"
								aria-describedby="emailHelpId" placeholder="exemplo@mail.com">
						</div>
					</div>
					<div class="col-md">
						<div class="mb-3">
							<label for="telefoneContato" class="form-label">Telefone</label>
							<input type="text" class="form-control" id="telefoneContato"
								aria-describedby="helpId" placeholder="(xx) xxxxx-xxxx">
						</div>
					</div>
				</div>
				<div class="mb-3">
					<label for="areaTextoContato" class="form-label">Mensagem</label>
					<textarea class="form-control" id="areaTextoContato" rows="10"
						placeholder="Deixe aqui sua mensagem que entraremos em contato."></textarea>
				</div>

				<div class="mb-3 form-check">
					<input type="checkbox" class="form-check-input" id="exampleCheck1">
					<label class="form-check-label" for="exampleCheck1">Aceitar
						os termos e condições</label>
				</div>
				<button type="submit" class="btn botao mb-3">Enviar</button>
			</form>
		</div>

	</main>

	<footer class="bg-footer">
		<div class="container-fluid">
			<section class="row pt-3">
				<article class="col-lg-6 col-sm-12">
					<p class="fonte-especial display-6 text-center">Aceitamos todos
						os cartões</p>
					<figure class="d-flex justify-content-center">
						<img id="img-cartao" src="../../assets/img/aceitamos-cartoes.png"
							alt="">
					</figure>
				</article>
				<article class="col-lg-6 col-sm-12">
					<p class="fonte-especial display-6 text-center">Visite nossas
						redes sociais</p>
					<ul class="d-flex justify-content-evenly pt-5">
						<a href="#"><i class="bi bi-instagram icon-footer"
							id="instagram"></i></a>
						<a href="#"><i class="bi bi-facebook icon-footer"
							id="facebook"></i></a>
						<a href="#"><i class="bi bi-twitter icon-footer" id="twitter"></i></a>
					</ul>
				</article>
			</section>
		</div>
	</footer>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

	<script src="../../assets/js/script.js"></script>

</body>
</html>