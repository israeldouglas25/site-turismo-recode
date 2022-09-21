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

<title>Paixão Nordestina / Destino</title>
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
						<li class="nav-item"><a class="nav-link fonte" href="#">Destinos</a></li>
						<li class="nav-item"><a class="nav-link fonte"
							href="../promocoes">Promoções</a></li>
						<li class="nav-item"><a class="nav-link fonte"
							href="../contato">Contato</a></li>
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
			<img class="banner" src="../../assets/img/banner-1.jpg" alt="">
		</div>
		<div class="container">
			<!-- form Datas, número de viajantes -->
			<h1 class="fonte-especial">Qual o seu destino</h1>
			<hr>
			<div class="row g-2 my-3">
				<div class="col-md">
					<div class="form-floating mb-3">
						<input type="text" class="form-control" name="Label" id="Label"
							placeholder="..."> <label for="floatingLabel">Origem</label>
					</div>
				</div>
				<div class="col-md">
					<div class="form-floating mb-3">
						<input type="text" class="form-control" name="Label" id="Label"
							placeholder="..."> <label for="floatingLabel">Destino</label>
					</div>
				</div>
				<div class="col-md">
					<div class="form-floating mb-3">
						<input type="date" class="form-control" name="Label" id="Label"
							placeholder="..."> <label for="floatingLabel">Data
							de ida</label>
					</div>
				</div>
				<div class="col-md">
					<div class="form-floating mb-3">
						<input type="date" class="form-control" name="Label" id="Label"
							placeholder="..."> <label for="floatingLabel">Data
							de volta</label>
					</div>
				</div>
				<div class="col-md">
					<div class="form-floating mb-3">
						<input type="number" class="form-control" name="Label" id="Label"
							value="2" placeholder="..."> <label for="floatingLabel">Viajantes</label>
					</div>
				</div>
				<div class="col-md">
					<div class="form-floating mb-3">
						<input type="number" class="form-control" name="Label" id="Label"
							value="1" placeholder="..."> <label for="floatingLabel">Quartos</label>
					</div>
				</div>
				<div class="col-md p-1">
					<a href="./promocao.html" class="btn botao btn-lg">Buscar</a>
				</div>
			</div>

			<h2 class="fonte-especial pt-2">Dados dos viajantes</h2>
			<hr>
			<!--form Cadastro de dados dos passageiros -->
			<form class="row g-3">
				<div class="col-md-6">
					<label for="validationDefault01" class="form-label">Nome
						Completo</label> <input type="text" class="form-control"
						id="validationDefault01" required>
				</div>
				<div class="col-md-5">
					<label for="validationDefault02" class="form-label">E-mail</label>
					<input type="email" class="form-control" id="validationDefault02"
						required>
				</div>
				<div class="col-md-1">
					<label for="validationDefault02" class="form-label">Idade</label> <input
						type="number" class="form-control" id="validationDefault02"
						required>
				</div>
				<div class="col-md-8">
					<label for="validationDefault03" class="form-label">Logradouro</label>
					<input type="text" class="form-control" id="validationDefault03"
						required>
				</div>
				<div class="col-md-4">
					<label for="validationDefault03" class="form-label">Bairro</label>
					<input type="text" class="form-control" id="validationDefault03"
						required>
				</div>
				<div class="col-md-6">
					<label for="validationDefault03" class="form-label">Cidade</label>
					<input type="text" class="form-control" id="validationDefault03"
						required>
				</div>
				<div class="col-md-3">
					<label for="validationDefault04" class="form-label">Estado</label>
					<select class="form-select" id="validationDefault04" required>
						<option selected disabled value="">Selecione</option>
						<option>AL</option>
						<option>BA</option>
						<option>CE</option>
						<option>MA</option>
						<option>PB</option>
						<option>PE</option>
						<option>PI</option>
						<option>RN</option>
						<option>SE</option>
					</select>
				</div>
				<div class="col-md-3">
					<label for="validationDefault05" class="form-label">Telefone</label>
					<input type="text" class="form-control" id="validationDefault05"
						placeholder="(xx) x xxxx-xxxx" required>
				</div>
				<div class="col-12">
					<div class="form-check">
						<input class="form-check-input" type="checkbox" value=""
							id="invalidCheck2" required> <label
							class="form-check-label" for="invalidCheck2"> Concordar
							com os termos e condições </label>
					</div>
				</div>
				<div class="col-12">
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