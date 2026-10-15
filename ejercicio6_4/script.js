const numero = document.getElementById("numero");
const boton = document.getElementById("btn");

var valor = new Number(numero);
var total = Number(valor * 35);


boton.addEventListener("click", () => {
   alert(total);  
})