import javafx.application.Application

/**
 * Created by maeda on 2017/06/26.
 */

class Main {
    /**
     * メインメソッド
     */
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            // MyApplicationクラスを開始させる
            //(MyApplicationクラスはJavaのClassクラスとして渡す)
            Application.launch(MyApplication::class.java, *args)
        }
    }
}