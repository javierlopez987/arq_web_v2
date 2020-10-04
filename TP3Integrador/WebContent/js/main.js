"use strict";
document.addEventListener("DOMContentLoaded", function() {
    const URL = "http://localhost:8080/TP3Integrador/api/";
    let msjError = document.querySelector("#errorMsj");
    console.log(msjError);
    msjError.setAttribute("display", "none");

    let btnReporte = document.querySelector("#btnReporte");
    btnReporte.addEventListener("click",cargarReporteCarrera);

    async function cargarReporteCarrera(){
        let request = URL + "carreras/reporte";
        let tabla = document.querySelector("#tableReport");
        try {
            tabla.innerHTML = "<span>Cargando...</span>";
            btnReporte.setAttribute("disabled", true);
            let response = await fetch(request);
            if (response.ok) {
                let dato = await response.json();
                tabla.innerHTML = "";
                for (let elemento of dato) {
                    tabla.innerHTML += "<tr>"
                    + "<td>"+ elemento.carrera+"</td>"
                    + "<td>"+ elemento.ciclo+"</td>"
                    + "<td>"+ elemento.inscriptos +"</td>"
                    + "<td>"+ elemento.egresados+"</td>"
                    + "</tr>";
                }
            } else {
                tabla.innerHTML = "";
            	msjError.setAttribute("display", "visible");
            	msjError.innerHTML = "Error - Por favor, contáctese con proveedor del servicio";
                console.log("URL error");
                console.log(response);
            }
        } catch (response) {
            tabla.innerHTML = "";
            msjError.setAttribute("display", "visible");
            msjError.innerHTML = "Error - Por favor, contáctese con proveedor del servicio";
            console.log("Connection error");
            console.log(response);
        }
    }

})