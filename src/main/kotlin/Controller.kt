/**
 * Created by maeda on 2017/06/26.
 */
import javafx.animation.Animation
import javafx.animation.KeyFrame
import javafx.animation.Timeline
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.util.Duration

/**
 * sample.fxmlで定義された部品に関するクラス(コントローラ)
 */
class Controller {
    //フィールドやメソッドの先頭に@FXMLアノテーションを付けることで、sample.fxmlとリンクする

    //lateinit(遅延初期化オプション)を付けることで、nullチェックを避ける
    @FXML lateinit var status: Label
    @FXML lateinit var time: Label
    @FXML lateinit var start: Button

    var started: Boolean = false
    val timer = Timeline(KeyFrame(Duration.millis(1000.0), EventHandler<ActionEvent> {
        val min = time.text.substring(0, 2).toInt()
        val sec =  time.text.substring(3, 5).toInt()
        if (min == 0 && sec == 0) {
            val window = start.scene.window
            window.x = 0.0
            window.y = 0.0
            window.width = 2160.0
            window.height = 1920.0
            if (status.text == "sit.") {
                changeToStand()
            } else if (status.text == "stand.") {
                changeToMove()
            } else {
                changeToSit()
            }
            startOnAction()
        } else if (sec == 0) {
            time.text = String.format("%02d:59", (min - 1))
        } else {
            time.text = String.format("%02d:%02d", min, (sec -1))
        }
    }))

    @FXML
    fun startOnAction() {
        if (timer.status != Animation.Status.RUNNING) {
            timer.cycleCount = Timeline.INDEFINITE
            timer.play()
            start.text = "stop"
            val window = start.scene.window
            window.height = 130.0
            window.width = 210.0
            window.x = 950.0
            window.y = 1750.0
        } else {
            timer.stop()
            start.text = "start"
        }
    }

    @FXML
    fun sitOnAction() {
        changeToSit()
    }

    @FXML
    fun standOnAction() {
        changeToStand()
    }

    @FXML
    fun moveOnAction() {
        changeToMove()
    }

    private fun changeToSit() {
        status.text = "sit."
        time.text = "20:00"
    }

    private fun changeToStand() {
        status.text = "stand."
        time.text = "08:00"
    }

    private fun changeToMove() {
        status.text = "move."
        time.text = "02:00"
    }
}