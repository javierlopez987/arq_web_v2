"use strict";
document.addEventListener("DOMContentLoaded", function () {
    const URL = "http://localhost:8080/TP3Integrador/api/";
    let msjError = document.querySelector(".errorMsj");
    msjError.setAttribute("display", "none");

    let carreraId = null;
    let toDate = new Date();
    let year = parseInt(toDate.getFullYear());

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
                    lista.innerHTML += `<li>
                        <label>${elemento.titulo}</label>
                        <button class='matricular' id=${elemento.id_carrera}>Matricular alumno</button>
                    </li>`;
                }
                let btnMatricular = document.querySelectorAll(".matricular");
                btnMatricular.forEach(element => {
                    element.addEventListener("click", cargarAlumnosCarrera)
                });
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

    async function cargarAlumnosCarrera(e){
        carreraId = e.target.id;
        let request = URL + "estudiantes/carrera/" + e.target.id;
        let listaCarreras = document.querySelector("#listaCarreras");
        listaCarreras.innerHTML = "";
        let listaAlumnos = document.querySelector("#listaAlumnos");
        listaAlumnos.innerHTML = "<li>Cargando...</li>";
        try {
            btnCarreras.setAttribute("disabled", false);
            let response = await fetch(request);
            if (response.ok) {
                let dato = await response.json();
                listaAlumnos.innerHTML = "";
                listaAlumnos.innerHTML = "<h3>Matricular a:</h3>";
                for (let elemento of dato) {
                    listaAlumnos.innerHTML += `<div><button class='btnConfirmaMatricula' id=${elemento.id_estudiante}>${elemento.apellido}, ${elemento.nombre}</button></div>`;
                }
                let btnMatricular = document.querySelectorAll(".btnConfirmaMatricula");
                btnMatricular.forEach(element => {
                    element.addEventListener("click", matricular)
                });
            } else {
                listaAlumnos.innerHTML = "";
            	msjError.setAttribute("display", "visible");
            	msjError.innerHTML = "Error - Por favor, contáctese con proveedor del servicio";
                console.log("URL error");
                console.log(response);
            }
        } catch (exc) {
            console.log(exc);
            listaAlumnos.innerHTML = "";
            msjError.setAttribute("display", "visible");
            msjError.innerHTML = "Error - Por favor, contáctese con proveedor del servicio";
            console.log("Connection error");
        }
    }

    async function matricular(e) {
        //let estudiante = 
        e.preventDefault();
        let matricula = {
            "id_estudiante": e.target.id,
            "id_carrera": carreraId,
            "ingreso": 2020
        };
        let contenedor = document.querySelector(".contenedor");
        contenedor.innerHTML = "<span>Espere por favor...</span>";
        try {
            let request = fetch(URL + "matriculas", {
                "method": "POST",
                "headers": { "Content-Type": "application/json" },
                "body": JSON.stringify(matricula)
            });
            let response = await request;
            if (response.ok) {
                let text = await response;
                console.log(text);
                contenedor.innerHTML = "";
                contenedor.innerHTML = "<span>Estudiante matriculado con éxito</span>";
                contenedor.innerHTML += "<a href='index.html'>Volver al inicio</a>";
            }
            else {
                contenedor.innerHTML = "";
                contenedor.innerHTML = "<span>Falla de URL</span>";
                contenedor.innerHTML += "<a href='index.html'>Volver al inicio</a>";
            }
        }
        catch (exc) {
            console.log(exc);
            contenedor.innerHTML = "";
            contenedor.innerHTML = "<span>Falla de conexión</span>";
            contenedor.innerHTML += "<a href='index.html'>Volver al inicio</a>";
        }
    }

})