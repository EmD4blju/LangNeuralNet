package emk4;

import java.io.File;
import java.util.*;

public class NeuralNet {

    protected final List<Perceptron> perceptrons;

    public NeuralNet(String trainDataPath){
        perceptrons = new ArrayList<>();
        File dir = new File(trainDataPath);
        String[] subDirs = Objects.requireNonNull(dir.list());
        for (String subDir : subDirs) {
            perceptrons.add(new Perceptron(
                    DataPreparator.initThreshold(),
                    DataPreparator.initWeights(),
                    DataPreparator.initDecisions(subDir),
                    subDir,
                    DataPreparator.initLearnConst())
            );
        }
    }

    public void train(double[] inputVector, String correctLang){
        perceptrons.forEach(perceptron -> {
            perceptron.train(inputVector, correctLang);
//            perceptron.normalizeWeightVector();
        });

        Perceptron perceptron = Collections.max(perceptrons, Comparator.comparingDouble(p -> p.net));
        System.out.println("Activated: "+perceptron);

    }




}
