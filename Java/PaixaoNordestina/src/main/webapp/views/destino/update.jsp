<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8"%>
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
<title>Paixão Nordertina / Viajante</title>
</head>
<body>
	<header>
		<!-- Incluindo o menu de navegação -->
		<nav class="navbar navbar-expand-lg bg-navbar">
			<div class="container-fluid">
				<figure>
					<a class="navbar-brand" href="./index.html"><img
						class="rounded-circle" src="./assets/img/Viagem1.png"
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
						<li class="nav-item"><a class="nav-link fonte"
							href="./views/destino">Destinos</a></li>
						<li class="nav-item"><a class="nav-link fonte"
							href="./views/promocoes">Promoções</a></li>
						<li class="nav-item"><a class="nav-link fonte"
							href="./views/contato">Contato</a></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle fonte" href="#"
							id="navbarDropdownMenuLink" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"> Acesse aqui
						</a>
							<ul class="dropdown-menu"
								aria-labelledby="navbarDropdownMenuLink">
								<li><a class="dropdown-item" href="./cadastrar.html">Cadastrar</a></li>
								<li><a class="dropdown-item" href="./login.html">Entrar</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>

	<main class="bg-main">
		<div class="container">
			<form action="./update-viajante" class="row g-3">
				<h2 class="text-center fonte-especial  mt-5">Atualizar</h2>
				<div class="form-group mb-3">
					<label for="id" class="form-label">Id</label><input type="text"
						id="id" name="id" class="form-control"
						value="<%=request.getAttribute("id")%>" readonly />
				</div>
				<div class="col-md-6">
					<label for="nome" class="form-label">Nome Completo</label> <input
						type="text" class="form-control" id="nome" name="nome"
						value="<%=request.getAttribute("nome")%>" />
				</div>
				<div class="col-md-6">
					<label for="email" class="form-label">E-mail</label> <input
						type="email" class="form-control" id="email" name="email"
						value="<%=request.getAttribute("email")%>">
				</div>
				<div class="col-md-2">
					<label for="idade" class="form-label">Idade</label> <input
						type="number" class="form-control" id="idade" name="idade"
						value="<%=request.getAttribute("idade")%>">
				</div>
				<div class="col-md-4">
					<label for="estado" class="form-label">Estado</label> <select
						class="form-select" id="estado" name="estado" required>
						<option selected disabled
							value="<%=request.getAttribute("estado")%>">Selecione</option>
						<option>ALAGOAS</option>
						<option>BAHIA</option>
						<option>CEARA</option>
						<option>MARANHAO</option>
						<option>PARAIBA</option>
						<option>PERNAMBUCO</option>
						<option>PIAUI</option>
						<option>RIO GRANDE DO NORTE</option>
						<option>SERGIPE</option>
					</select>
				</div>
				<div class="col-md-3">
					<label for="cpf" class="form-label">CPF</label> <input type="text"
						class="form-control" id="cpf" name="cpf"
						value="<%=request.getAttribute("cpf")%>">
				</div>
				<div class="col-md-3">
					<label for="telefone" class="form-label">Telefone</label> <input
						type="text" class="form-control" id="telefone" name="telefone"
						value="<%=request.getAttribute("telefone")%>">
				</div>
				<div class="col-6">
					<div class="form-check">
						<input class="form-check-input" type="checkbox" value=""
							id="invalidCheck2"> <label class="form-check-label"
							for="invalidCheck2"> Concordar com os termos e condições
						</label>
					</div>
				</div>
				<div class="col-6 mb-3 d-flex justify-content-end">
					<button class="btn botao" type="submit">Adicionar</button>
				</div>
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
						<img id="img-cartao" src="./assets/img/aceitamos-cartoes.png"
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
	<script src="./assets/js/script.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

</body>
</html>