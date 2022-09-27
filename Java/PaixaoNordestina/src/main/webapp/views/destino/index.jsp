<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.Destino" import="java.util.List"
	import="java.text.SimpleDateFormat"%>

<%
@SuppressWarnings("unchecked")
List<Destino> viagem = (List<Destino>) request.getAttribute("destino");
%>

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
		<nav class="navbar navbar-expand-lg fixed-top">
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

	<main class="bg-main">
		<div>
			<img class="banner" src="./assets/img/banner-1.jpg" alt="">
		</div>
		<div class="container">
			<!-- form Datas, número de viajantes -->
			<h1 class="fonte-especial">Qual o seu destino</h1>
			<hr>
			
			<form action="./create-destino" class="row g-3">
				<div class="col-md-6">
					<label for="destino" class="form-label">Destino</label> <input
						type="text" class="form-control" id="destino" name="destino"
						required>
				</div>
				<div class="col-md-6">
					<label for="preco" class="form-label">Preco</label> <input
						type="number" class="form-control" id="preco" name="preco" required>
				</div>
				<div class="col-md mb-3 d-flex justify-content-end">
					<button class="btn botao" type="submit">Adicionar Destino</button>
				</div>
			</form>
			
			<h2 class="text-center fonte-especial">Lista de Destino</h2>
			<table class="table table-responsive table-hover">
				<thead class="table-light">
					<tr>
						<th scope="col" class="form-label">#</th>
						<th scope="col" class="form-label">DESTINO</th>
						<th scope="col" class="form-label">PREÇO</th>
						<th scope="col" class="form-label">AÇÕES</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (Destino vg : viagem) {
					%>
					<tr>
						<td><%=vg.getId()%></td>
						<td><%=vg.getDestino()%></td>
						<td><%=vg.getPreco()%></td>
						<td>
							<div class="d-flex">
								<a href="edit-destino?id=<%=vg.getId()%>" class="mx-1"
									title="Editar"> <i class="bi bi-file-earmark-text"></i>
								</a> <a href="delet-destino?id=<%=vg.getId()%>" class="mx-1"
									title="Excluir"
									onclick="return confirm('Deseja excluir a viagem para <%=vg.getDestino()%>.')">
									<i class="bi bi-trash"></i>
								</a>
							</div>
						</td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
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