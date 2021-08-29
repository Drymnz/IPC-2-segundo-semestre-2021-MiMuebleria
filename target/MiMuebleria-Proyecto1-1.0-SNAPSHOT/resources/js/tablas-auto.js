/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var data = document.getElementById("texto");
switch (data.innerHTML) {
    case "Listado de usuario":
        document.writeln("<th scope=\"col\">");
        document.writeln("nombre</th> ");
        document.writeln("<th scope=\"col\">");
        document.writeln("password</th> ");
        document.writeln("<th scope=\"col\">");
        document.writeln("tipo</th> ");
        break;
}