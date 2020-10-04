"use strict";
document.addEventListener("DOMContentLoaded", function () {
    const URL = "http://localhost:8080/TP3Integrador/api/";
    let msjError = document.querySelector(".errorMsj");
    msjError.setAttribute("display", "none");

    // LISTA CARRERAS
    let btnCarreras = document.querySelector("#btnCarreras");
    btnCarreras.addEventListener("click",cargarReporteCarrera);

    async function cargarReporteCarrera(){
        let request = URL + "carreras";
        let lista = document.querySelector("#listaCarreras");
        lista.innerHTML = "<li>Cargando...</li>";
        try {
            btnCarreras.setAttribute("disabled", true);
            let response = await fetch(request);
            if (response.ok) {
                let dato = await response.json();
                lista.innerHTML = "";
                for (let elemento of dato) {
                    lista.innerHTML += `<li id=${elemento.id_carrera}>
                    <a href=${URL + 'carreras/' + elemento.id_carrera}>${elemento.titulo}</a></li>`;
                }
            } else {
                lista.innerHTML = "";
            	msjError.setAttribute("display", "visible");
            	msjError.innerHTML = "Error - Por favor, contáctese con proveedor del servicio";
                console.log("URL error");
                console.log(response);
            }
        } catch (response) {
            lista.innerHTML = "";
            msjError.setAttribute("display", "visible");
            msjError.innerHTML = "Error - Por favor, contáctese con proveedor del servicio";
            console.log("Connection error");
            console.log(response);
        }
    }

    let btnAltaEstudiante = document.querySelector(".btnAltaEstudiante");
    btnAltaEstudiante.addEventListener("click", async function (e) {
        e.preventDefault();
        let estudiante = {
            "nombre": document.querySelector(".nombre").value,
            "apellido": document.querySelector(".apellido").value,
            "edad": document.querySelector(".edad").value,
            "genero": document.querySelector(".genero").value,
            "dni": document.querySelector(".dni").value,
            "residencia": document.querySelector(".residencia").value,
            "nro_lu": document.querySelector(".nro_lu").value
        };
        console.log(estudiante);
        let contenedor = document.querySelector(".contenedor");
        contenedor.innerHTML = "<span>Espere por favor...</span>";
        try {
            let request = fetch(URL + "estudiantes", {
                "method": "POST",
                "headers": { "Content-Type": "application/json" },
                "body": JSON.stringify(estudiante)
            });
            console.log(request);
            let response = await request;
            if (response.ok) {
                let text = await response.status;
                console.log(text);
                contenedor.innerHTML = "";
                contenedor.innerHTML = "<span>Estudiante agregado con éxito</span>";
                contenedor.innerHTML += "<a href='estudiante.html'>Volver</a>";
            }
            else {
                contenedor.innerHTML = "";
                contenedor.innerHTML = "<span>Falla de URL</span>";
                contenedor.innerHTML += "<a href='estudiante.html'>Volver</a>";
            }
        }
        catch (exc) {
            console.log(exc);
            contenedor.innerHTML = "";
            contenedor.innerHTML = "<span>Falla de conexión</span>";
            contenedor.innerHTML += "<a href='estudiante.html'>Volver</a>";
        }
    })
})