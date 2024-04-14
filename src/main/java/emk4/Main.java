/**
 * @author Mikołaj Warda s28034 | EmDablju
 */

package emk4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.*;



public class Main extends Application {

    public static void main(String[] args) throws IOException {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/app.fxml"));
        Parent root = fxmlLoader.load();
        stage.setTitle("LangNetClient");
        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image(
                "https://cdn2.iconfinder.com/data/icons/artificial-intelligence-6/64/ArtificialIntelligence12-256.png"
        ));
        stage.setResizable(false);
        stage.show();
    }
}
