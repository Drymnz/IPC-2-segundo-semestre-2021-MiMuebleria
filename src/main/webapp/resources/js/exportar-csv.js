/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
class tablaCSVexportar{
    constructor(){
        this.table = table;
        //seleccioname todos las filas row
        this.rows = array.from(table.querySelectorAll("tr"));
        if (!includeHeader && this.rows[0].querySelectorAll("th").length){
            this.rows.shift();
        }
        console.log();
    }
    convertirToCSV(){
      const lines = [];
      const numCols = this._findlLongestRowLength();
      
        for (const row of this.rows) {
            let line = "";
            for (int i = 0; i < numCols ; i++) {
                if (row.children[i]) {
                    line+= tablaCSVexportar.parseCell(row.children[i]);
                }
                line += (i !== numCols - 1)? "," : "";
            }
            lines.push(line);
        }
        return lines.join("\n"); 
    }
    _findlLongestRowLength(){
      return this.rows.reduce((1,row) => row.childElementCount > 1 ?  row.childElementCount : 1, 0)  );  
    }
    static parseCell(tableCell){
        let parsedValue = tableCell.textContent;
        parsedValue = parsedValue.replace(/"/g,'""');
        parsedValue = /[",\n]/.test(parsedValue) ? '"${parsedValue}"' : parsedValue;
    }
}

*/