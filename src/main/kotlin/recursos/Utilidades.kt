package recursos

import java.lang.Exception

class Utilidades {
    companion object {

        fun pedirString(texto: String): String {
            println(texto)
            return readLine().toString()
        }

        fun pedirByte(texto: String): Byte {
            println(texto)
            var value: Byte? = null

            do {
                try {
                    value = readLine()?.toByte()
                } catch (ex: Exception) {
                    println("La opción introducida es incorrecta, vuelve a probar")
                }
            } while (value == null)

            return value
        }

        fun limpiarPantalla() {
            println("\n\n\n\n\n\n\n\n\n\n\n\n")
        }

        fun textoError(texto: String) {
            println("\u001B[31m${texto}\u001B[0m")
        }

        fun textoVerde(texto: String) {
            println("\u001B[32;1m${texto}\u001B[0m")
        }

        fun textoInformativo(texto: String) {
            println("\u001b[33;1m${texto}\u001b[0m")
        }
    }

}