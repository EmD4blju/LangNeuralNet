package emk4;

import emk4.Tools.DataPreparator;

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
        perceptrons.forEach(perceptron -> perceptron.calculateNet(inputVector));
        Perceptron activatedPerceptron = Collections.max(
                perceptrons,
                Comparator.comparingDouble(perceptron -> perceptron.net)
        );
        System.out.println("ACTIVATED: " + activatedPerceptron);
        if(!activatedPerceptron.lang.equals(correctLang)){
            perceptrons.forEach(perceptron -> perceptron.train(inputVector, correctLang, activatedPerceptron.lang));
        }
    }

    public String test(double[] inputVector){
        perceptrons.forEach(perceptron -> perceptron.calculateNet(inputVector));
        Perceptron activatedPerceptron = Collections.max(
                perceptrons,
                Comparator.comparingDouble(perceptrons -> perceptrons.net)
        );
        System.out.println("ACTIVATED: " + activatedPerceptron);
        return activatedPerceptron.lang;
    }




}
