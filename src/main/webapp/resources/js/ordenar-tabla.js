/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 */

$(document).ready(() => {
    //funcion para indicar sobre que esta, reslatador
    $('th').each(function (columna) {
        $(this).hover(function () {
            $(this).addClass('resaltar');
        }, function () {
            $(this).removeClass('resaltar');
        });
        // ordenar la tabla por columnas, funciones anonimas
        $(this).click(function () {
            let registros = $('table').find('tbody > tr').get();
            // ordenar los registros
            registros.sort(function (a, b) {
                let valor1 = $(a).children('td').eq(columna).text().toUpperCase();
                let valor2 = $(b).children('td').eq(columna).text().toUpperCase();
                return (valor1 < valor2) ? -1 : (valor1 > valor2) ? 1 : 0;
            });
            $.each(registros, function (indice, elemento) {
                $('tbody').append(elemento);
            });
        });
    });
});
