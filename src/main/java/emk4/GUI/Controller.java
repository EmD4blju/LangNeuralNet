package emk4.GUI;

import emk4.Tools.DataPreparator;
import emk4.NeuralNet;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public TextField result = new TextField();
    @FXML
    public TextArea userInput = new TextArea();
    @FXML
    public Button submitButton = new Button();
    @FXML
    public Button testButton = new Button();
    public NeuralNet neuralNet;
    public SimpleStringProperty resultProperty = new SimpleStringProperty();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File dir = new File("src/main/resources/lang");
        neuralNet = new NeuralNet(dir.getPath());
        try {
            for(int i = 0; i < 30; i++) {
                for (File subDir : Objects.requireNonNull(dir.listFiles())) {
                    System.out.println("\t\t\t\t\t\t\t=-=-=-=-=-=-= DIRECTORY " + subDir.getName() + " =-=-=-=-=-=-=");
                    File[] files = subDir.listFiles();
                    for (File file : Objects.requireNonNull(files)) {
                        System.out.println("=-=-=-=-=-=-= FILE " + file.getName() + " =-=-=-=-=-=-=");
                        double[] preparedInputData = DataPreparator.prepareData(
                                DataPreparator.stringifyFileLines(Files.readAllLines(file.toPath()))
                        );
                        neuralNet.train(preparedInputData, subDir.getName());
                    }
                }
            }
        }catch (IOException exception){
            System.out.println(exception.getMessage());
        }
        userInput.setWrapText(true);
        result.textProperty().bind(resultProperty);
    }

    public void onSubmit(ActionEvent actionEvent) {
        System.out.println(actionEvent.getSource());
        String userInput = this.userInput.getText();
        String result = neuralNet.test(
                DataPreparator.prepareData(userInput)
        );
        resultProperty.set(ResourceBundle.getBundle("Extender").getString(result));
    }
}
