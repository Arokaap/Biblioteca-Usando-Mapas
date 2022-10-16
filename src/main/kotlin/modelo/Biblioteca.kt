package modelo

import recursos.Utilidades
import java.lang.StringBuilder

class Biblioteca(id: String, nombre: String) {

    private var id: String
    private var nombre: String
    private var biblioteca: MutableMap<String, String> = mutableMapOf()

    init {
        this.id = id
        this.nombre = nombre
    }

    fun aniadirLibro() {
        Utilidades.limpiarPantalla()
        val titulo = Utilidades.pedirString("Introduzca el titulo del libro:")
        Utilidades.limpiarPantalla()
        val autor = Utilidades.pedirString("Introduzca el autor del libro:")

        biblioteca[titulo.trim()] = autor.trim()
    }

    fun eliminarLibro() {
        Utilidades.limpiarPantalla()
        if (biblioteca.isNotEmpty()) {
            val libro = Utilidades.pedirString("Introduzca el título del libro a eliminar:")

            if (biblioteca.containsKey(libro)) {
                biblioteca.remove(libro)
                Utilidades.limpiarPantalla()
                Utilidades.textoVerde("El libro ha sido eliminado correctamente")
            } else {
                Utilidades.limpiarPantalla()
                Utilidades.textoError("El libro no existe en la biblioteca")
            }
        } else {
            Utilidades.limpiarPantalla()
            Utilidades.textoError("La biblioteca está vacia, te animamos a añadir un libro")
        }
    }

    fun modificarLibro() {
        Utilidades.limpiarPantalla()
        if (biblioteca.isNotEmpty()) {
            val libro = Utilidades.pedirString("Introduzca el título del libro a modificar:")

            for ((key) in biblioteca) {
                if (key.equals(libro.trim(), true)) {
                    Utilidades.limpiarPantalla()
                    val autor = Utilidades.pedirString("Introduzca el nuevo autor:")
                    biblioteca[key] = autor.trim()
                    Utilidades.textoVerde("El titulo del libro ha sido modificado correctamente")
                }
            }
            if (biblioteca.containsKey(libro)) {
                Utilidades.limpiarPantalla()
                Utilidades.textoVerde("El libro ha sido eliminado correctamente")
            } else {
                Utilidades.limpiarPantalla()
                Utilidades.textoError("El libro no existe en la biblioteca")
            }
        } else {
            Utilidades.limpiarPantalla()
            Utilidades.textoError("La biblioteca está vacia, te animamos a añadir un libro")
        }
    }

    fun mostrarLibros() {
        var espacios: Byte
        var sbLibros = StringBuilder("")

        if (biblioteca.isNotEmpty()) {
            Utilidades.limpiarPantalla()
            val sb = StringBuilder("\t\t\t\t\t\u001B[33;1mLISTADO MiBIBLIOTECA")
                .append("\n\t\t\t\t\t--------------------")
                .append("\n\t\t  TÍTULO\t\t\t\t\t\t\tAUTOR")
                .append("\n------------------------          ------------------------\u001B[0m")

            println(sb)

            for ((key, value) in biblioteca) {
                sbLibros.append(key)
                if (key.length < 33) {
                    espacios = (33 - (key.length)).toByte()

                    for (i in 1..espacios) {
                        sbLibros.append(" ")
                    }
                }
                sbLibros.append(" $value")

                Utilidades.textoVerde(sbLibros.toString())

                sbLibros = StringBuilder("")
            }
        } else {
            Utilidades.limpiarPantalla()
            Utilidades.textoError("La biblioteca está vacia, te animamos a añadir un libro")
        }

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