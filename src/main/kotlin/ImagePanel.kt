import com.mortennobel.imagescaling.ResampleFilters
import com.mortennobel.imagescaling.ResampleOp
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.image.BufferedImage
import javax.swing.JPanel

class ImagePanel(private val source: BufferedImage) : JPanel() {

    private var current = 0

    val filterName: String get() = FILTERS[current].name

    fun next() {
        current = ++current % FILTERS.size
        repaint()
    }

    override fun paintComponent(g: Graphics) = (g as Graphics2D).drawImage(createOp().filter(source, null), null, 0, 0)

    private fun createOp() = ResampleOp(width, height).apply { filter = FILTERS[current] }

    companion object {
        private val FILTERS = arrayOf(
            ResampleFilters.getBoxFilter(),
            ResampleFilters.getBSplineFilter(),
            ResampleFilters.getBellFilter(),
            ResampleFilters.getBiCubicFilter(),
            ResampleFilters.getBiCubicHighFreqResponse(),
            ResampleFilters.getLanczos3Filter(),
            ResampleFilters.getMitchellFilter(),
            ResampleFilters.getTriangleFilter()
        )
    }
}
