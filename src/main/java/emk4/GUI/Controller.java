package emk4.GUI;

import emk4.Tools.DataPreparator;
import emk4.NeuralNet;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TextField result = new TextField();
    @FXML
    private TextArea userInput = new TextArea();
    @FXML
    private Button submitButton = new Button();
    @FXML
    private Button trainButton = new Button();
    private NeuralNet neuralNet;
    private File langDir;
    private final SimpleStringProperty resultProperty = new SimpleStringProperty();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        langDir = new File("src/main/resources/lang");
        neuralNet = new NeuralNet(langDir.getPath());
        userInput.setWrapText(true);
        result.setEditable(false);
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

    public void onTrain(ActionEvent actionEvent) {
        try {
            for(int i = 0; i < 300; i++) {
                for (File subDir : Objects.requireNonNull(langDir.listFiles())) {
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
    }
}
