const boton = document.getElementById("btn-init");
let entrada = document.getElementById("primer_numero");
let miVariable = 5;

boton.addEventListener("click", () => {
    let valorInput = Number(entrada.value); 
    let laVariableSumada = miVariable + valorInput;

    if (laVariableSumada < 10){
        alert("Tu numero no alcanza");
         entrada.value = "";
    }else{
        alert("Tu numero es suficiente");
         entrada.value = "";
    }
});



