const nav = document.querySelector('nav');

window.addEventListener('scroll', () => {
    if (window.scrollY >= 100) {
        nav.classList.add('active_nav');
    } else {
        nav.classList.remove('active_nav');
    }
});

const card1Nome = document.querySelector('#card-1-nome');

const mudarNome = () => {
    card1Nome.textContent = 'teste';
}

const card2Nome = document.querySelector('#card-2-nome');
const card3Nome = document.querySelector('#card-3-nome');
const card4Nome = document.querySelector('#card-4-nome');
const card5Nome = document.querySelector('#card-5-nome');
const card6Nome = document.querySelector('#card-6-nome');
const card7Nome = document.querySelector('#card-7-nome');
const card8Nome = document.querySelector('#card-8-nome');
const card9Nome = document.querySelector('#card-9-nome');


//card1Nome.textContent = 'israel';