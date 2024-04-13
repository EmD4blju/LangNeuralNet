package emk4;

import java.io.*;
import java.nio.file.Files;
import java.util.Objects;


public class Main {

    public static void main(String[] args) throws IOException {
        File dir = new File("src/main/resources/lang");
        NeuralNet neuralNet = new NeuralNet(dir.getPath());

        neuralNet.perceptrons.forEach(System.out::println);

//        for(File subDir : Objects.requireNonNull(dir.listFiles())){
//            File[] files = subDir.listFiles();
//            for(int i = 0; i < Objects.requireNonNull(files).length; i++){
//                String parsedData = DataPreparator.parseData(Files.readAllLines(files[i].toPath()));
//                double[] preparedInputData = DataPreparator.prepareData(parsedData);
//                neuralNet.train(preparedInputData, subDir.getName());
//            }
//        }

        for(int i = 0; i < 3; i++)
            neuralNet.train(DataPreparator.prepareData("Cześć co u Ciebie słychać"), "pl");



        neuralNet.perceptrons.forEach(System.out::println);
    }

}
