"use strict";
document.addEventListener("DOMContentLoaded", function () {
    const URL = "http://localhost:8080/TP3Integrador/api/";
    let msjError = document.querySelector(".errorMsj");
    msjError.setAttribute("display", "none");



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
        let contenedor = document.querySelector(".contenedor");
        contenedor.innerHTML = "<span>Espere por favor...</span>";
        try {
            let request = fetch(URL + "estudiantes", {
                "method": "POST",
                "headers": { "Content-Type": "application/json" },
                "body": JSON.stringify(estudiante)
            });
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
    });

    let btnListarEst= document.querySelector("#btnAlfabetico");
    let btnGenero= document.querySelector("#btnGenero");
    let btnLu= document.querySelector("#btnLu");
    btnListarEst.addEventListener('click',listarEstudiantes);
    btnGenero.addEventListener('click',listarEstudiantesGenero);
    btnLu.addEventListener('click',listarEstudiante);
    
    
    
    
    async function listarEstudiantes(){
        let container = document.querySelector("#tableEstudiantes");
        try {
            let request = fetch(URL+"estudiantes/alfabetico");
            let response = await request;
            if (response.ok){
                let estudiantes = await response.json();
                container.innerHTML = "";
                for (let elemento of estudiantes){
                        container.innerHTML += "<tr><td>"+
                         elemento.apellido+"</td>"+
                        "<td>"+ elemento.nombre+"</td>"+
                        "<td>"+ elemento.edad +"</td>"+
                        "<td>"+ elemento.genero +"</td>"+
                        "<td>"+ elemento.dni + "</td>"+
                        "<td>"+ elemento.residencia + "</td>"+
                        "<td>"+ elemento.nro_lu + "</td></tr>"
                }
            }
            else {
                container.innerHTML = "<h1>Falla de URL</h1>";
            }
        
        }
        catch (exc) {
            container.innerHTML = "<h1>Fallo conexion</h1>";
        }
    }

    async function listarEstudiantesGenero(){
        let container = document.querySelector("#tableEstudiantes");
        let genero = document.querySelector("#genero").value;
        try {
            let request = fetch(URL+"estudiantes/genero/"+genero+"");
            let response = await request;
            if (response.ok){
                let estudiantes = await response.json();
                container.innerHTML = "";
                for (let elemento of estudiantes){
                        container.innerHTML += "<tr><td>"+
                         elemento.apellido+"</td>"+
                        "<td>"+ elemento.nombre+"</td>"+
                        "<td>"+ elemento.edad +"</td>"+
                        "<td>"+ elemento.genero +"</td>"+
                        "<td>"+ elemento.dni + "</td>"+
                        "<td>"+ elemento.residencia + "</td>"+
                        "<td>"+ elemento.nro_lu + "</td></tr>"
                }
            }
            else {
                container.innerHTML = "<h1>Falla de URL</h1>";
            }
        
        }
        catch (exc) {
            container.innerHTML = "<h1>Fallo conexion</h1>";
        }
    }

    async function listarEstudiante(){
        let container = document.querySelector("#tableEstudiantes");
        let lu = document.querySelector("#nro_lu").value;
        try {
            let request = fetch(URL+"estudiantes/lu/"+lu+"");
            let response = await request;
            if (response.ok){
                let elemento = await response.json();
                container.innerHTML = "";
             
                    container.innerHTML += "<tr><td>"+
                     elemento.apellido+"</td>"+
                    "<td>"+ elemento.nombre+"</td>"+
                    "<td>"+ elemento.edad +"</td>"+
                    "<td>"+ elemento.genero +"</td>"+
                    "<td>"+ elemento.dni + "</td>"+
                    "<td>"+ elemento.residencia + "</td>"+
                    "<td>"+ elemento.nro_lu + "</td></tr>"
                
            }
            else {
                container.innerHTML = "<h1>Falla de URL</h1>";
            }
        
        }
        catch (exc) {
            container.innerHTML = "<h1>Fallo conexion</h1>";
        }
    }



});