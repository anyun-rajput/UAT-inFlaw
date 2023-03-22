import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.image.Image
import javafx.stage.Stage
import javafx.stage.StageStyle
import kotlinx.coroutines.runBlocking
import java.io.File


class UAT : Application() {

    companion object {
        const val version = "1.0"
        val dir = File(System.getProperty("user.home"), "UAT-inFlaw")
        val win = "win" in System.getProperty("os.name").toLowerCase()
        val linux = "linux" in System.getProperty("os.name").toLowerCase()

        @JvmStatic
        fun main(args: Array<String>) {
            launch(UAT::class.java)
        }
    }

    init {
        dir.mkdir()
    }

    @Throws(Exception::class)
    override fun start(stage: Stage) {
        stage.initStyle(StageStyle.UNDECORATED);
        stage.scene = Scene(FXMLLoader.load(javaClass.classLoader.getResource("Main.fxml")))
        stage.title = "UAT-inFlaw"
        stage.icons.add(Image("icon.png"))
        stage.show()

    }

    override fun stop() {
        runBlocking {
            try {
                Command.exec(mutableListOf("adb", "kill-server"))
            } catch (e: Exception) {
                // OK
            }
        }
    }

}
