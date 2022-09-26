<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
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

<title>Paixão Nordestina / Destino</title>
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
						<li class="nav-item"><a class="nav-link fonte" href="./destino">Destinos</a></li>
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
								<li><a class="dropdown-item"
									href="./views/usuarios/create.html">Cadastrar</a></li>
								<li><a class="dropdown-item" href="./views/login">Entrar</a></li>
								<li><a class="dropdown-item" href="./permissoes">Permissão</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>

	<main class="bg-main">
		<div class="container">
			<!-- form Datas, número de viajantes -->
			<h1 class="text-center fonte-especial p-3">Atualizar</h1>
			<hr>
			<form action="./update-destino" class="row g-3">
				<div class="form-group mb-3">
					<label for="id" class="form-label">Id</label><input type="text"
						id="id" name="id" class="form-control"
						value="<%=request.getAttribute("id")%>" readonly />
				</div>
				<div class="col-md-6">
					<label for="origem" class="form-label">Origem</label> <input
						type="text" class="form-control" id="origem" name="origem"
						value="<%=request.getAttribute("origem")%>">
				</div>
				<div class="col-md-6">
					<label for="destino" class="form-label">Destino</label> <select
						class="form-select" id="destino" name="destino"
						onChange="update()">
						<option selected disabled value="<%=request.getAttribute("destino")%>">Selecione</option>
						<option value="1">ALAGOAS</option>
						<option value="2">BAHIA</option>
						<option value="3">CEARA</option>
						<option value="4">MARANHAO</option>
						<option value="5">PARAIBA</option>
						<option value="6">PERNAMBUCO</option>
						<option value="7">PIAUI</option>
						<option value="8">RIO GRANDE DO NORTE</option>
						<option value="9">SERGIPE</option>
					</select>
				</div>
				<div class="col-md-8">
					<label for="listaViajantes" class="form-label">Nome do
						Viajante</label> <select class="form-select" id="listaViajantes"
						name="listaViajantes">
						<option selected disabled value="">Selecione</option>
					</select>
				</div>
				<div class="col-md-4">
					<label for="preco" class="form-label">Preco da viagem</label> <input
						type="text" class="form-control" id="preco" name="preco" value="<%=request.getAttribute("preco")%>" disabled>
				</div>
				<div class="col-md-4">
					<label for="dataIda" class="form-label">Data de ida</label> <input
						type="date" class="form-control" name="dataIda" id="dataIda" value="<%=request.getAttribute("dataIda")%>">
				</div>
				<div class="col-md-4">
					<label for="dataVolta" class="form-label">Data de Volta</label> <input
						type="date" class="form-control" name="dataVolta" id="dataVolta" value="<%=request.getAttribute("dataVolta")%>"
						onChange="calculateDataDiff()">
				</div>
				<div class="col-md-4">
					<label for="dias" class="form-label">Total de dias</label> <input
						type="text" class="form-control" id="dias" name="dias" value="<%=request.getAttribute("dias")%>" disabled>
				</div>
				<div class="col-4">
					<label for="qtdViajantes" class="form-label">Viajantes</label> <input
						type="number" class="form-control" name="qtdViajantes"
						id="qtdViajantes" value="<%=request.getAttribute("qtdViajantes")%>" onChange="totalViagem()">
				</div>
				<div class="col-4">
					<label for="qtdQuartos" class="form-label">Quartos</label> <input
						type="number" class="form-control" name="qtdQuartos"
						id="qtdQuartos" value="<%=request.getAttribute("qtdQuartos")%>">
				</div>
				<div class="col-4">
					<label for="valorTotal" class="form-label">Valor Total</label> <input
						type="number" class="form-control" name="valorTotal"
						id="valorTotal" value="<%=request.getAttribute("total")%>" disabled>
				</div>
				<div class="col-12 mb-3 d-grid">
					<button class="btn botao" type="submit">Atualizar Destino</button>
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

	<script src="./assets/js/script.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

</body>
</html>