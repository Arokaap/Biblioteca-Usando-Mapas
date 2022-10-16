package modelo

import recursos.Utilidades
import java.lang.StringBuilder

class Biblioteca(biblioteca: MutableMap<String, String>) {

    private var biblioteca: MutableMap<String, String>

    init {
        this.biblioteca = biblioteca
    }

    companion object {
        fun menuInicial(): Byte {
            val sb = StringBuilder("\n\n\u001b[33;1m--------BIBLIOTECA---------")
                .append("\n1. Añadir libro")
                .append("\n2. Modificar libro")
                .append("\n3. Eliminar libro")
                .append("\n4. Mostrar libros")
                .append("\n5. Salir\u001b[0m")

            println(sb)

            return Utilidades.pedirByte("Introduzca una opción:")
        }
    }
}