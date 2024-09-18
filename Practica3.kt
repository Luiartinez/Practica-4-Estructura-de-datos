data class Item(val precio: Double)

class Factura(val items: List<Item>) {
    fun calcularTotal(): Double {
        return items.sumOf { it.precio }
    }
}

class ReporteFactura {
    fun generar(factura: Factura): String {
        return "Reporte de la factura: Total = ${factura.calcularTotal()}"
    }
}

open class Empleado(val nombre: String, val horasTrabajadas: Int, val precioHora: Double) {
    open fun calcularSalario(): Double {
        return horasTrabajadas * precioHora
    }
}

class EmpleadoConBono(nombre: String, horasTrabajadas: Int, precioHora: Double, val bono: Double)
    : Empleado(nombre, horasTrabajadas, precioHora) {

    override fun calcularSalario(): Double {
        return super.calcularSalario() + bono
    }
}

fun main() {
    fun imprimirSalario(empleado: Empleado) {
        println("El salario de ${empleado.nombre} es de ${empleado.calcularSalario()}")
    }

    val empleado = Empleado("luis", 40, 12.0)
    val empleadoConBono = EmpleadoConBono("maria", 40, 12.0, 70.0)

    imprimirSalario(empleado)
    imprimirSalario(empleadoConBono)
}

interface Trabajador {
    fun trabajar()
}

interface Asistente {
    fun asistir()
}

interface Reportero {
    fun generarReporte()
}

class Programador : Trabajador {
    override fun trabajar() {
        println("El programador está programando")
    }
}

class Albañil : Trabajador {
    override fun trabajar() {
        println("Trabaja en construcción")
    }
}

interface Notificaciones {
    fun enviarNotificacion(mensaje: String)
}

class ServicioEmail : Notificaciones {
    override fun enviarNotificacion(mensaje: String) {
        println("Enviado email: $mensaje")
    }
}

class Notificacion(val servicio: Notificaciones) {
    fun enviarUnaNotificacion() {
        servicio.enviarNotificacion("Notificación importante")
    }
}
