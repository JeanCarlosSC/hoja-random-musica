import swingRAD.mainBar.MainBar
import swingRAD.setProperties
import javax.swing.*
import kotlin.random.Random

class Window: JFrame() {
    private val letra = listOf("A", "B", "C", "D", "E", "F", "G")
    private val estado = listOf("#", "b", " ")
    val panel = JPanel()

    init {
        val mainBar = MainBar(this,)
        mainBar.setTitle("Hoja random música")
        mainBar.setLogo(ImageIcon("resources/exampleLogo.png"))
        add(mainBar)

        panel.setProperties(320, 40, 660, 660)
        dibujar()
        add(panel)

        val boton = JButton()
        boton.setProperties(1050, 380, 100, 32, "Generar")
        boton.addActionListener { dibujar() }
        add(boton)

        setProperties()
    }

    fun generarTonalidad(): String {
        var tonalidad = ""
        val posicion1 = Random.nextInt(letra.size)
        tonalidad += letra[posicion1]

        val posicion2= Random.nextInt(estado.size)
        tonalidad += estado[posicion2]

        return tonalidad
    }

    fun dibujar() {
        panel.removeAll()

        for(i in 0 until 10) {
            for(j in 0 until 10) {
                val lText = JLabel()
                lText.setProperties(40 + 62*i, 40 + 62*j, 50, 28, generarTonalidad())
                panel.add(lText)
            }
        }

        repaint()
    }

}