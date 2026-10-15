const entradaNombre = document.getElementById("nombre");
const entradaRaza = document.getElementById("nombre");
const entradaHabilidad = document.getElementById("nombre");
const entradaSalud = document.getElementById("nombre");

let boton = document.getElementById("btn");

let criatura = {
    nombre: entradaNombre,
    raza: entradaRaza,
    habilidad: entradaHabilidad,
    salud: entradaSalud
}

boton.addEventListener("click", () => {
    alert(`Tu criatura se llama ${criatura.nombre} de la raza ${criatura.raza}. Su habilidad es ${criatura.habilidad} y posee ${criatura.salud} puntos de salud`)
})

