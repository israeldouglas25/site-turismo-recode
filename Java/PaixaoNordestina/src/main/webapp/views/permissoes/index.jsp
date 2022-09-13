<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.Permissoes" import="java.util.List"%>

<%
@SuppressWarnings("unchecked")
List<Permissoes> lista = (List<Permissoes>) request.getAttribute("permissoes");
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
<title>Paixão Nordertina / Permissões</title>
</head>
<body>
	<header>
		<!-- Incluindo o menu de navegação -->
		<nav class="navbar navbar-expand-lg">
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
							href="./destino.html">Destinos</a></li>
						<li class="nav-item"><a class="nav-link fonte"
							href="./promocao.html">Promoções</a></li>
						<li class="nav-item"><a class="nav-link fonte"
							href="./contato.html">Contato</a></li>
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

	<section class="container">
		<div class="p-4">
			<div class="d-flex justify-content-end">
				<a href="./views/permissoes/create.html"
					class="btn botao mb-2"> Criar Permissão </a>
			</div>
			<table class="table table-responsive table-hover">
				<thead class="table-light">
					<tr>
						<th scope="col">#</th>
						<th scope="col">Tipo</th>
						<th scope="col">Ações</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (Permissoes p : lista) {
					%>
					<tr>
						<td><%=p.getId()%></td>
						<td><%=p.getTipo()%></td>
						<td>
							<div class="d-flex">
								<a href="edit?id=<%=p.getId()%>" class="mx-1" title="Editar"></a>
								<i class="bi bi-file-earmark-text"></i> <a
									href="delet?id=<%=p.getId()%>" class="mx-1" title="Excluir"
									onclick="return confirm('Deseja excluir a permissão <%=p.getTipo()%>.')">
								</a> <i class="bi bi-trash"></i>
							</div>
						</td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
	</section>


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
						<a href="#"><i class="bi bi-instagram" id="instagram"></i></a>
						<a href="#"><i class="bi bi-facebook" id="facebook"></i></a>
						<a href="#"><i class="bi bi-twitter" id="twitter"></i></a>
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