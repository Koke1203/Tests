function validaDatos() {
    var cedula = document.form_registro.txtCedula;
    var nombre = document.form_registro.txtNombre;
    var apellido = document.form_registro.txtApellido;
    var clave = document.form_registro.txtClave;
    var telefono = document.form_registro.txtTelefono;
    if (cedula.value == "") {
        Swal.fire({
            icon: 'warning',
            title: 'Oops...',
            text: 'Ingrese su Cédula',
        })
        return false;
    }

    if (nombre.value == "") {
        Swal.fire({
            icon: 'warning',
            title: 'Oops...',
            text: 'Ingrese su Nombre',
        })
        return false;
    }

    if (apellido.value == "") {
        Swal.fire({
            icon: 'warning',
            title: 'Oops...',
            text: 'Ingrese su Apellido',
        })
        return false;
    }

    if (clave.value == "") {
        Swal.fire({
            icon: 'warning',
            title: 'Oops...',
            text: 'Genere la clave',
        })
        return false;
    }

    if (telefono.value == "") {
        Swal.fire({
            icon: 'warning',
            title: 'Oops...',
            text: 'Ingrese su Telefono',
        })
        return false;
    }
}

function sololetras(e) {
    key = e.keyCode || e.which;
    teclado = String.fromCharCode(key).toLocaleLowerCase();
    letras = "abcdefghijklmnñopqrstuvwxyz";
    especiales = "37-38-46";
    teclado_especial = false;
    for (var i in especiales) {
        if (key == especiales[i]) {
            teclado_especial = true;
            break;
        }
    }
    if (letras.indexOf(teclado) == -1 && !teclado_especial) {
        return false;
    }
}

function solonumeros(e) {
    key = e.keyCode || e.which;
    teclado = String.fromCharCode(key);
    numeros = "0123456789";
    especiales = "8-37-38-46";
    teclado_especial = false;
    for (var i in especiales) {
        if (key == especiales[i]) {
            teclado_especial = true;
            break;
        }
    }
    if (numeros.indexOf(teclado) == -1 && !teclado_especial) {
        return false;
    }
}

function doSearch(){
    var tableReg = document.getElementById('datos');
    var searchText = document.getElementById('searchTerm').value.toLowerCase();
    var cellsOfRow = "";
    var found = false;
    var compareWith = "";

    // Recorremos todas las filas con contenido de la tabla
    for (var i = 1; i < tableReg.rows.length; i++)
    {
        cellsOfRow = tableReg.rows[i].getElementsByTagName('td');
        found = false;
        // Recorremos todas las celdas
        for (var j = 0; j < cellsOfRow.length && !found; j++)
        {
            compareWith = cellsOfRow[j].innerHTML.toLowerCase();
            // Buscamos el texto en el contenido de la celda
            if (searchText.length == 0 || (compareWith.indexOf(searchText) > -1))
            {
                found = true;
            }
        }
        if (found)
        {
            tableReg.rows[i].style.display = '';
        } else {
            // si no ha encontrado ninguna coincidencia, esconde la
            // fila de la tabla
            tableReg.rows[i].style.display = 'none';
        }
    }
}
    