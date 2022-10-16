import modelo.Biblioteca
import recursos.Utilidades

fun main() {
    val bibliotecaHuelva = Biblioteca("001", "Francisco Garfias")
    var repetir = true

    do {
        when (Biblioteca.menuInicial()) {
            1.toByte() -> bibliotecaHuelva.aniadirLibro()
            2.toByte() -> bibliotecaHuelva.modificarLibro()
            3.toByte() -> bibliotecaHuelva.eliminarLibro()
            4.toByte() -> bibliotecaHuelva.mostrarLibros()
            5.toByte() -> {
                Utilidades.limpiarPantalla()
                Utilidades.textoVerde("Gracias por visitarnos!")
                repetir = false
            }

            else -> {
                Utilidades.limpiarPantalla()
                Utilidades.textoError("Opción incorrecta, introduzca un número válido")
            }
        }

    } while (repetir)


}