/**
 * 
 */
// ============ FUNÇÃO NAVBAR ==============
const nav = document.querySelector('nav');

window.addEventListener('scroll', () => {
	if (window.scrollY >= 100) {
		nav.classList.add('active_nav');
	} else {
		nav.classList.remove('active_nav');
	}
});
// =========================================

//========== FUNÇÃO QUE RETORNA O VALOR DO DESTINO =============
function update() {
	var select = document.getElementById('destino');

	var option = select.options[select.selectedIndex].value;
	console.log(option)
	switch (option) {

		case '1':
			document.getElementById('preco').value = '100';
			break;
		case '2':
			document.getElementById('preco').value = 200;
			break;
		case '3':
			document.getElementById('preco').value = 300;
			break;
		case '4':
			document.getElementById('preco').value = 400;
			break;
		case '5':
			document.getElementById('preco').value = 500;
			break;
		case '6':
			document.getElementById('preco').value = 600;
			break;
		case '7':
			document.getElementById('preco').value = 700;
			break;
		case '8':
			document.getElementById('preco').value = 800;
			break;
		case '9':
			document.getElementById('preco').value = 900;
			break;
		default:
			console.log("erro")
	}
	console.log(document.getElementById('preco').value)
}
// ==========================================================

// ======= FUNÇÃO QUE CALCULA QUANTIDADE DE DATAS ===========
const inputIda = document.querySelector('#dataIda');
const inputVolta = document.querySelector('#dataVolta');
const totalDias = document.querySelector('#dias');

function calculateDataDiff() {

	let dataIda = inputIda.value;
	let dataVolta = inputVolta.value;

	dataIda = new Date(dataIda)
	dataVolta = new Date(dataVolta)

	let diffInTime = Math.abs(dataVolta - dataIda)
	let timeInOneDay = (1000 * 60 * 60 * 24) //milisegundos * segundos * minutos * horas por dia
	let diffInDays = Math.ceil(diffInTime / timeInOneDay)

	totalDias.value = diffInDays

	return totalDias
}

// ==== FUNÇÃO QUE MULTIPLICA P VALOR DE DIAS, VIAJANTES E PRECO ===

const precos = document.querySelector('#preco')
const dias = document.querySelector('#dias')
const viajantes = document.querySelector('#qtdViajantes')
const total = document.querySelector('#valorTotal')

function totalViagem() {
	let preco = precos.value
	let dia = dias.value
	let viajante = viajantes.value

	document.getElementById('valorTotal').value = preco * dia * viajante

}

//==================== FUNÇÃO TESTE DATA =======================

function criarViagem() {

	const preco = document.querySelector('#preco')
	cnosole.log(preco)
}

