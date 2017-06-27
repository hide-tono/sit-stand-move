/**
 * Created by maeda on 2017/06/26.
 */
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage


/**
 * GUI全体に関するクラス
 */
class MyApplication : Application() {
    /**
     * GUIをスタートさせる
     * @param primaryStage 土台となるコンテナ(トップレベルコンテナ)
     */
    override fun start(primaryStage: Stage) {
        //GUIのタイトルを設定
        primaryStage.title = "Sit.Stand.Move."
        primaryStage.isAlwaysOnTop = true
        primaryStage.height = 130.0
        primaryStage.width = 210.0

        //Scene(見えないコンテナ)にsample.fxmlの内容を当てはめる
        primaryStage.scene = Scene(FXMLLoader.load<Parent>(this.javaClass.getResource("sample.fxml")), 300.0, 275.0)

        //GUIを表示
        primaryStage.show()
    }
}