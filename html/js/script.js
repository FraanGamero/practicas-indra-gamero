document.addEventListener('DOMContentLoaded', () => {
     fetchData()
})

const images = [
  'img/ecoferia.jpg',
  'img/taller.jpg',
  'img/MovilidadVerde.jpg'
];

// Insertamos el template a la clase carousel-div
const template = document.getElementById('carousel-template');
const container = document.querySelector('.carousel-div'); 
const clone = template.content.cloneNode(true);
container.appendChild(clone);


const sliderList = document.querySelector('.slider .list');
const dotsContainer = document.querySelector('.slider .dots');

images.forEach((src, index) => {
  const item = document.createElement('div');
  item.className = 'item';

  const img = document.createElement('img');
  img.src = src;
  img.alt = `Imagen ${index + 1}`;

  item.appendChild(img);
  sliderList.appendChild(item);

  const dot = document.createElement('li');
  if (index === 0) dot.classList.add('active');
  dotsContainer.appendChild(dot);
});

const slider = document.querySelector('.slider .list');
const items = document.querySelectorAll('.slider .item');
const next = document.getElementById('next');
const prev = document.getElementById('prev');
const dots = document.querySelectorAll('.slider .dots li');

let lengthItems = items.length - 1;
let active = 0;

next.onclick = function () {
  active = active + 1 <= lengthItems ? active + 1 : 0;
  reloadSlider();
};

prev.onclick = function () {
  active = active - 1 >= 0 ? active - 1 : lengthItems;
  reloadSlider();
};

function reloadSlider() {
  slider.style.left = -items[active].offsetLeft + 'px';

  const lastActive = document.querySelector('.slider .dots li.active');
  if (lastActive) lastActive.classList.remove('active');
  dots[active].classList.add('active');
}

dots.forEach((dot, key) => {
  dot.addEventListener('click', () => {
    active = key;
    reloadSlider();
  });
});

window.onresize = reloadSlider;
