// Datos de los eventos
const eventos = {
  "eco-feria": {
    nombre: "Eco Feria",
    descripcion: "Este programa busca dotar a escuelas rurales con sistemas de energía solar para mejorar su autonomía energética, reducir costes a largo plazo y fomentar la conciencia ambiental entre estudiantes. La iniciativa también incluye talleres educativos sobre energías renovables dirigidos a alumnos y docentes.",
    fecha: "10 de Septiembre de 2025",
    ubicacion: "Escuelas rurales de la región",
    imagen: "img/ecoferia.jpg"
  },
  "movilidad-verde": {
    nombre: "Movilidad Verde",
    descripcion: "Iniciativa para incentivar el uso compartido de bicicletas y patinetes eléctricos como medio de transporte cotidiano. Se busca reducir la congestión vehicular y la contaminación ambiental, promoviendo además rutas seguras y accesibles para todos los usuarios.",
    fecha: "22 de Octubre de 2025",
    ubicacion: "Ciudad central",
    imagen: "img/MovilidadVerde.jpg"
  },
  "taller": {
    nombre: "Taller de Huertos",
    descripcion: "A través de talleres participativos, este proyecto impulsa la creación de huertos comunitarios en zonas con escaso acceso a productos frescos. Se enseña a vecinos técnicas de agricultura ecológica, compostaje y autoabastecimiento, fortaleciendo la cohesión social y la soberanía alimentaria. ",
    fecha: "5 de Noviembre de 2025",
    ubicacion: "Barrios periféricos",
    imagen: "img/taller.jpg"
  }
};

// Función para obtener parámetro de URL
function getQueryParam(param) {
  const urlParams = new URLSearchParams(window.location.search);
  return urlParams.get(param);
}

function mostrarEvento() {


  const evento = eventos[getQueryParam("event")];
  document.getElementById("event-name").textContent = evento.nombre;
  document.getElementById("event-description").textContent = evento.descripcion;
  document.getElementById("event-date").textContent =  "Fecha: " + evento.fecha;
  document.getElementById("event-location").textContent = "Ubicacion: " + evento.ubicacion;
  document.getElementById("event-image").src = evento.imagen;
  document.getElementById("event-image").alt = `${evento.nombre}`;
}

// Ejecutar la función al cargar la página
window.onload = mostrarEvento;
