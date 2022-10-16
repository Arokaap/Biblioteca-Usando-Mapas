import modelo.Biblioteca
import recursos.Utilidades

fun main() {
    var repetir: Boolean = true

    do {
        when (Biblioteca.menuInicial()) {
            1.toByte() -> println("")
            2.toByte() -> println("")
            3.toByte() -> println("")
            4.toByte() -> println("")
            5.toByte() -> {
                Utilidades.limpiarPantalla()
                Utilidades.textoVerde("Gracias por visitarnos!")
                repetir = false
            }
        }

    } while (repetir)


}