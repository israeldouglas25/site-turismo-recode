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

<title>Paixão Nordestina / Promoções</title>
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
						<li class="nav-item"><a class="nav-link fonte"
							href="../../destino">Destinos</a></li>
						<li class="nav-item"><a class="nav-link fonte" href="#">Promoções</a></li>
						<li class="nav-item"><a class="nav-link fonte"
							href="../contato">Contato</a></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle fonte" href="#"
							id="navbarDropdownMenuLink" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"> Acesse aqui
						</a>
							<ul class="dropdown-menu"
								aria-labelledby="navbarDropdownMenuLink">
								<li><a class="dropdown-item" href="../usuarios/create.html">Cadastrar</a></li>
								<li><a class="dropdown-item" href="../login">Entrar</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>

	<main class="bg-main">
		<div>
			<img class="banner" src="../../assets/img/banner-2.jpg" alt="">
		</div>
		
		<div class="container">
			<!-- paragrafo -->
			<h1 class="fonte-especial">Pacotes e promoções de viagens</h1>
			<hr>
			<!-- cards de apresentação -->
			<div class="row row-cols-1 row-cols-md-3 g-4">
				<section class="col">
					<article class="card border-color">
						<img src="../../assets/img/card-alagoas.jpg" class="card-img-top"
							alt="Praia Maragogi">
						<div class="card-img-overlay fonte-card d-flex align-items-center">
							<h5 class="card-title fonte-text-shadow" id="card-1-nome">Alagoas</h5>
						</div>
						<div class="card-body">
							<div>
								<span class="span-promocoes">Promoção</span> <span id="card-1-valor"> a
									partir de R$ 200</span>
							</div>
							<a href="#" class="btn botao card-link w-100 mt-3">Ver
								ofertas</a>
						</div>
					</article>
				</section>
				<section class="col">
					<article class="card border-color">
						<img src="../../assets/img/card-bahia.jpg" class="card-img-top"
							alt="Elevador Lacerda">
						<div class="card-img-overlay fonte-card d-flex align-items-center">
							<h5 class="card-title fonte-text-shadow">Bahia</h5>
						</div>
						<div class="card-body">
							<div>
								<span class="span-promocoes">Promoção</span> <span> a
									partir de R$ 200</span>
							</div>
							<a href="#" class="btn botao card-link w-100 mt-3">Ver
								ofertas</a>
						</div>
					</article>
				</section>
				<section class="col">
					<article class="card border-color">
						<img src="../../assets/img/card-ceara.webp" class="card-img-top"
							alt="Praia de Jericoacoara">
						<div class="card-img-overlay fonte-card d-flex align-items-center">
							<h5 class="card-title fonte-text-shadow">Ceará</h5>
						</div>
						<div class="card-body">
							<div>
								<span class="span-promocoes">Promoção</span> <span> a
									partir de R$ 200</span>
							</div>
							<a href="#" class="btn botao card-link w-100 mt-3">Ver
								ofertas</a>
						</div>
					</article>
				</section>
				<section class="col">
					<article class="card border-color">
						<img src="../../assets/img/card-maranhão.jpg"
							class="card-img-top " alt="Lençoes maranheces">
						<div class="card-img-overlay fonte-card d-flex align-items-center">
							<h5 class="card-title fonte-text-shadow">Maranhão</h5>
						</div>
						<div class="card-body">
							<div>
								<span class="span-promocoes">Promoção</span> <span> a
									partir de R$ 200</span>
							</div>
							<a href="#" class="btn botao card-link w-100 mt-3">Ver
								ofertas</a>
						</div>
					</article>
				</section>
				<section class="col">
					<article class="card border-color">
						<img src="../../assets/img/card-paraiba1.webp"
							class="card-img-top " alt="Por do sol na praia do jacaré">
						<div class="card-img-overlay fonte-card d-flex align-items-center">
							<h5 class="card-title fonte-text-shadow">Paraiba</h5>
						</div>
						<div class="card-body">
							<div>
								<span class="span-promocoes">Promoção</span> <span> a
									partir de R$ 200</span>
							</div>
							<a href="#" class="btn botao card-link w-100 mt-3">Ver
								ofertas</a>
						</div>
					</article>
				</section>
				<section class="col">
					<article class="card border-color">
						<img src="../../assets/img/card-pernambuco.jpg"
							class="card-img-top " alt="Ilha de Fernando de Noronha">
						<div class="card-img-overlay fonte-card d-flex align-items-center">
							<h5 class="card-title fonte-text-shadow">Pernambuco</h5>
						</div>
						<div class="card-body">
							<div>
								<span class="span-promocoes">Promoção</span> <span> a
									partir de R$ 200</span>
							</div>
							<a href="#" class="btn botao card-link w-100 mt-3">Ver
								ofertas</a>
						</div>
					</article>
				</section>
				<section class="col">
					<article class="card border-color">
						<img src="../../assets/img/card-piaui.webp" class="card-img-top "
							alt="Serra da Capivara">
						<div class="card-img-overlay fonte-card d-flex align-items-center">
							<h5 class="card-title fonte-text-shadow">Piaui</h5>
						</div>
						<div class="card-body">
							<div>
								<span class="span-promocoes">Promoção</span> <span> a
									partir de R$ 200</span>
							</div>
							<a href="#" class="btn botao card-link w-100 mt-3">Ver
								ofertas</a>
						</div>
					</article>
				</section>
				<section class="col">
					<article class="card border-color">
						<img src="../../assets/img/card-rio-grande-norte.jpg"
							class="card-img-top " alt="Morro do careca">
						<div class="card-img-overlay fonte-card d-flex align-items-center">
							<h5 class="card-title fonte-text-shadow">Rio Grande do Norte</h5>
						</div>
						<div class="card-body">
							<div>
								<span class="span-promocoes">Promoção</span> <span> a
									partir de R$ 200</span>
							</div>
							<a href="#" class="btn botao card-link w-100 mt-3">Ver
								ofertas</a>
						</div>
					</article>
				</section>
				<section class="col">
					<article class="card border-color">
						<img src="../../assets/img/card-sergipe.jpg" class="card-img-top "
							alt="Xingó e Canindé de São Francisco">
						<div class="card-img-overlay fonte-card d-flex align-items-center">
							<h5 class="card-title fonte-text-shadow">Sergipe</h5>
						</div>
						<div class="card-body">
							<div>
								<span class="span-promocoes">Promoção</span> <span> a
									partir de R$ 200</span>
							</div>
							<a href="#" class="btn botao card-link w-100 mt-3">Ver
								ofertas</a>
						</div>
					</article>
				</section>
			</div>
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