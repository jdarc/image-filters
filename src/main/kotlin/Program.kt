import java.awt.BorderLayout
import java.awt.Color
import java.awt.Dimension
import java.awt.Toolkit
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent
import javax.imageio.ImageIO
import javax.swing.JFrame
import javax.swing.SwingUtilities
import javax.swing.WindowConstants

object Program {
    @JvmStatic
    fun main(args: Array<String>) {
        val screenSize = Toolkit.getDefaultToolkit().screenSize
        val image = ImageIO.read(Program::class.java.classLoader.getResource("robot.png"))
        SwingUtilities.invokeLater {
            val panel = ImagePanel(image)
            fun composeTitle() = "Filter Type: ${panel.filterName}"
            JFrame().apply {
                background = Color.BLACK
                defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
                minimumSize = Dimension(64, 92)
                size = Dimension(screenSize.height, screenSize.height * 95 / 100)
                layout = BorderLayout()
                contentPane.add(panel, BorderLayout.CENTER)
                setLocationRelativeTo(null)
                isResizable = true
                isVisible = true
                addKeyListener(object : KeyAdapter() {
                    override fun keyPressed(e: KeyEvent) {
                        super.keyPressed(e)
                        panel.next()
                        title = composeTitle()
                    }
                })
                requestFocus()
                title = composeTitle()
            }
        }
    }
}
