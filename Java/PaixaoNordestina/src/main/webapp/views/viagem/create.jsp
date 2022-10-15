<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.Viagem" import="model.Usuario"
	import="model.Destino" import="java.util.List"%>

<%
@SuppressWarnings("unchecked")
List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");

@SuppressWarnings("unchecked")
List<Destino> destinos = (List<Destino>) request.getAttribute("carros");
%>

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

<title>Paixão Nordestina / Viagem</title>
</head>
<body>
	<header>
		<!-- Incluindo o menu de navegação -->
		<nav class="navbar navbar-expand-lg bg-navbar">
			<div class="container-fluid">
				<figure>
					<a class="navbar-brand" href="./index.html"><img
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
							</ul></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>

	<main>
		<form action="./create-viagem" class="row g-3">
			<div class="col-md-6">
				<label for="origem" class="form-label">Origem</label> <input
					type="text" class="form-control" id="origem" name="origem" required>
			</div>
			<div class="col-md-6">
				<label for="destino" class="form-label">Destino</label> <select
					class="form-select" id="destino" name="destino" required>
					<option value="DEFAULT">Selecione</option>
					<%
					for (Destino d : destinos) {
					%>
					<option value="<%=d.getId()%>"><%=d.getDestino()%></option>
					<%
					}
					%>
				</select>
			</div>
			<div class="col-md-8">
				<label for="listaViajantes" class="form-label">Nome do
					Viajante</label> <select class="form-select" id="listaViajantes"
					name="listaViajantes">
					<option value="DEFAULT">Selecione</option>
					<%
					for (Usuario u : usuarios) {
					%>
					<option value="<%=u.getId()%>"><%=u.getNome()%></option>
					<%
					}
					%>
				</select>
			</div>
			<div class="col-md-4">
				<label for="dataIda" class="form-label">Data de ida</label> <input
					type="date" class="form-control" name="dataIda" id="dataIda">
			</div>
			<div class="col-md-4">
				<label for="dataVolta" class="form-label">Data de Volta</label> <input
					type="date" class="form-control" name="dataVolta" id="dataVolta"
					onChange="calculateDataDiff()">
			</div>
			<div class="col-12 mb-3 d-grid">
				<button class="btn botao" type="submit">Adicionar Viagem</button>
			</div>
		</form>
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