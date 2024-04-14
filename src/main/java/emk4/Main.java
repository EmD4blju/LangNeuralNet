package emk4;

import java.io.*;
import java.nio.file.Files;
import java.util.Objects;


public class Main {

    public static void main(String[] args) throws IOException {
        File dir = new File("src/main/resources/lang");
        NeuralNet neuralNet = new NeuralNet(dir.getPath());

        for(File subDir : Objects.requireNonNull(dir.listFiles())){
            System.out.println("\t\t\t\t\t\t\t=-=-=-=-=-=-= DIRECTORY " + subDir.getName() + " =-=-=-=-=-=-=");
            File[] files = subDir.listFiles();
            for(File file : Objects.requireNonNull(files)){
                System.out.println("=-=-=-=-=-=-= FILE " + file.getName() + " =-=-=-=-=-=-=");
                double[] preparedInputData = DataPreparator.prepareData(
                        DataPreparator.stringifyFileLines(Files.readAllLines(file.toPath()))
                );
                neuralNet.train(preparedInputData, subDir.getName());
            }
        }

    }

}
