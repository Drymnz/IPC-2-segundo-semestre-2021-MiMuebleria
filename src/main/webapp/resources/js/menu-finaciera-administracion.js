let menuToggle = document.querySelector('.toggle');
let menu = document.querySelector('.menu');
menuToggle.onclick = function () {
    menuToggle.classList.toggle('active');
    menu.classList.toggle('action');
}
let listado = document.querySelectorAll('.listado');
for (let i = 0; i < listado.length; i++) {
    listado[i].onclick = function () {
        let j = 0;
        while (j < listado.length) {
            listado[j++].className = 'listado';
        }
        listado[i].className = 'menu';
    }
}
