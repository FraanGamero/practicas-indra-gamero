// Esperamos a que el contenido del DOM esté completamente cargado antes de ejecutar la función fetchData()
document.addEventListener('DOMContentLoaded', () => {
  fetchData(); // Supone una función definida en otro lugar que carga o procesa datos
});

// Creamos un array con las imagenes que usemos en el carousel
const images = [
  'img/ecoferia.jpg',
  'img/taller.jpg',
  'img/MovilidadVerde.jpg'
];

// Clonamos el contenido del template HTML con id "carousel-template" y lo insertamos en el contenedor con clase "carousel-div"
const template = document.getElementById('carousel-template');
const container = document.querySelector('.carousel-div');
const clone = template.content.cloneNode(true);
container.appendChild(clone);


const sliderList = document.querySelector('.slider .list');
const dotsContainer = document.querySelector('.slider .dots');

// Por cada imagen, creamos un div con clase "item", insertamos la imagen dentro y añadimos el ítem al slider

images.forEach((src, index) => {
  const item = document.createElement('div');
  item.className = 'item';

  const img = document.createElement('img');
  img.src = src;
  img.alt = `Imagen ${index + 1}`;

  // Insertamos la imagen en el div .item
  item.appendChild(img);

  // Añadimos el item al contenedor del slider
  sliderList.appendChild(item);

  const dot = document.createElement('li');

  // Activamos el primer punto por defecto
  if (index === 0) dot.classList.add('active');
  // Añadimos el li al contenedor de dots
  dotsContainer.appendChild(dot);
});


const slider = document.querySelector('.slider .list');
const items = document.querySelectorAll('.slider .item');
const next = document.getElementById('next');
const prev = document.getElementById('prev');
const dots = document.querySelectorAll('.slider .dots li');

// Variable para almacenar el índice del último ítem
let lengthItems = items.length - 1;

// Índice actual del carrusel
let active = 0;

// Función asociada al botón "Siguiente"
next.onclick = function () {
  // Si no hemos llegado al final, incrementamos. Si sí, volvemos a 0
  if (active + 1 <= lengthItems) {
    active = active + 1;
  } else {
    active = 0;
  }

  reloadSlider(); // Actualizamos visualmente el slider
};

// Función asociada al botón "Anterior"
prev.onclick = function () {
  if (active + 1 <= lengthItems) {
    active = active + 1;
  } else {
    active = 0;
  }
  reloadSlider(); // Actualizamos visualmente el slider
};

// Función que actualiza la posición del slider y la clase 'active' del punto correspondiente
function reloadSlider() {
  slider.style.left = -items[active].offsetLeft + 'px'; // Desplaza el slider según la posición del ítem activo

  // Detectamos el dot previamente activo
  const lastActive = document.querySelector('.slider .dots li.active');

  // Le quitamos la clase activa
  if (lastActive) lastActive.classList.remove('active');
  // Activamos el nuevo dot correspondiente
  dots[active].classList.add('active');
}

// Añade eventos a cada punto de navegación para poder cambiar de imagen al hacer clic
dots.forEach((dot, key) => {
  dot.addEventListener('click', () => {
    // Cambiamos el índice activo al del dot clicado
    active = key;
    // Actualizamos el slider
    reloadSlider();
  });
});

// Recalculamos la posición del slider si el tamaño de la ventana cambia
window.onresize = reloadSlider;
