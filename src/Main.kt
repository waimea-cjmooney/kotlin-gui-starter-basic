/**
 * ===============================================================
 * Kotlin GUI Basic Starter
 * ===============================================================
 *
 * This is a starter project for a simple Kotlin GUI application.
 * The Java Swing library is used, plus the FlatLAF look-and-feel
 * for a reasonably modern look.
 */

import com.formdev.flatlaf.FlatDarkLaf
import java.awt.*
import java.awt.event.*
import javax.swing.*


/**
 * Launch the application
 */
fun main() {
    FlatDarkLaf.setup()     // Flat, dark look-and-feel
    MainWindow()            // Create and show the UI
}


/**
 * Main UI window (view)
 * Defines the UI and responds to events
 * The app model should be passed as an argument
 */
class MainWindow : JFrame(), ActionListener, KeyListener {

    // Fields to hold the UI elements
    private lateinit var greetingLabel: JLabel
    private lateinit var nameBox: JTextField
    private lateinit var helloButton: JButton
    private lateinit var byeButton: JButton

    /**
     * Configure the UI and display it
     */
    init {
        configureWindow()               // Configure the window
        addControls()                   // Build the UI

        setLocationRelativeTo(null)     // Centre the window
        isVisible = true                // Make it visible
    }

    /**
     * Configure the main window
     */
    private fun configureWindow() {
        title = "Kotlin Swing GUI Demo"
        contentPane.preferredSize = Dimension(600, 500)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        isResizable = false
        layout = null

        pack()
    }

    /**
     * Populate the UI with UI controls
     */
    private fun addControls() {
        val defaultFont = Font(Font.SANS_SERIF, Font.PLAIN, 36)

        greetingLabel = JLabel("Hello, World!")
        greetingLabel.horizontalAlignment = SwingConstants.CENTER
        greetingLabel.bounds = Rectangle(50, 50, 500, 100)
        greetingLabel.font = defaultFont
        add(greetingLabel)

        nameBox = JTextField()
        nameBox.bounds = Rectangle(50, 150, 500, 100)
        nameBox.font = defaultFont
        nameBox.addActionListener(this)
        nameBox.addKeyListener(this)
        add(nameBox)

        helloButton = JButton("Hello!")
        helloButton.bounds = Rectangle(350,300,200,100)
        helloButton.foreground = Color.YELLOW
        helloButton.background = Color(0, 33, 66)
        helloButton.font = defaultFont
        helloButton.addActionListener(this)     // Handle any clicks
        add(helloButton)

        byeButton = JButton("Goodbye!")
        byeButton.bounds = Rectangle(50,300,200,100)
        byeButton.foreground = Color.YELLOW
        byeButton.background = Color(0, 33, 66)
        byeButton.font = defaultFont
        byeButton.addActionListener(this)     // Handle any clicks
        add(byeButton)
    }


    /**
     * Handle any UI events (e.g. button clicks)
     */
    override fun actionPerformed(e: ActionEvent?) {
        when (e?.source) {
            nameBox -> {
                println("Name text changed")
            }
            helloButton -> {
                println("Hello button pressed")
                greetingLabel.text = "Hello there, ${ if (nameBox.text != "") nameBox.text else "Stranger"}!"
            }
            byeButton -> {
                println("Hello button pressed")
                greetingLabel.text = "Goodbye ${ if (nameBox.text != "") nameBox.text else "Stranger"}!"
            }
        }
    }

    override fun keyTyped(e: KeyEvent?) {
        println("Key Typed: ${e?.keyChar}")
    }

    override fun keyPressed(e: KeyEvent?) {
        println("Key Pressed: ${e?.keyCode}")
        if (e?.keyCode in KeyEvent.VK_A .. KeyEvent.VK_Z) {
            println("Letter key!")
        } else {
            e?.consume()
        }
    }

    override fun keyReleased(e: KeyEvent?) {
        println("Key Released: ${e?.keyCode}")
    }

}

