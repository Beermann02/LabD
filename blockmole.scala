package blockmole
import java.awt.{Color => JColor}

object Color {
// Skapar olika färger som behövs i övriga moduler
    val black = new JColor( 0, 0, 0)
    val mole = new JColor( 51, 51, 0)
    val soil = new JColor(153, 102, 51)
    val tunnel = new JColor(204, 153, 102)
    val grass = new JColor( 25, 130, 35)
    }

object BlockWindow {
   import introprog.PixelWindow
// Har ett introprog.PixelWindow och ritar blockgrafik
    val windowSize = (30, 50) // (width, height) in number of blocks
    val blockSize = 10 // number of pixels per block
    val window = new PixelWindow(blockSize*windowSize._1,blockSize*windowSize._2)

    type Pos = (Int, Int)
    def block(pos: Pos)(color: JColor = JColor.gray): Unit = {
    val x = blockSize*windowSize._1
    val y = blockSize*windowSize._2
    window.fill(0, 0, x, y, color)
    }
    }

object Mole { // Representerar en blockmullvad som kan gräva
def dig(): Unit = println("Här ska det grävas!")
    }

object Main {
    def drawWorld(): Unit = 
        BlockWindow.window.line(100, 10, 200, 20)

    def main(args: Array[String]): Unit = {
    drawWorld()
    Mole.dig()
    BlockWindow.block(0, 0)(JColor.gray)
    }
}