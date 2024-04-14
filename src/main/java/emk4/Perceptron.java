package emk4;
/**
 * @author Mikołaj Warda s28034
 */

import emk4.Exceptions.NotCompatibleVectorsException;
import java.util.*;

public class Perceptron {

    private double threshold;
    private double[] weightsVector;
    private final Map<String, Integer> decisions;
    protected double net;
    protected final String lang;
    private final double learnConst;

    public Perceptron(double threshold, double[] weights, Map<String, Integer> decisions, String lang, double learnConst) {
        this.threshold = threshold;
        this.weightsVector = weights;
        this.decisions = decisions;
        this.lang = lang;
        this.learnConst = learnConst;
    }

    public void train(double[] inputVector, String correctLang, String predictedLang){
        int correctDecision = decisions.containsKey(correctLang)
                ? decisions.get(correctLang) : decisions.get("other");
        int predictedDecision = decisions.containsKey(predictedLang)
                ? decisions.get(predictedLang) : decisions.get("other");

        learn(inputVector, correctDecision, predictedDecision);
    }

    protected void learn(double[] inputVector, int correctDecision, int predictedDecision) {
        threshold = updateThreshold(correctDecision, predictedDecision);
        weightsVector = updateWeights(inputVector, correctDecision, predictedDecision);
        calculateNet(inputVector);
        weightsVector = VectorNormalizer.normalize(weightsVector);
    }

    private double updateThreshold(int correctDecision, int predictedDecision){
        return threshold - (correctDecision - predictedDecision * learnConst);
    }

    private double[] updateWeights(double[] inputVector, int correctDecision, int predictedDecision) {
        double[] newWeights = new double[weightsVector.length];
        for(int i = 0; i < newWeights.length; i++){
            newWeights[i] = weightsVector[i] + (inputVector[i] * (correctDecision - predictedDecision) * learnConst);
        }
        return newWeights;
    }

    protected void calculateNet(double[] inputVector) {
        net = 0d;
        for(int i = 0; i < weightsVector.length; i++){
            net += weightsVector[i] * inputVector[i];
        }
    }

    @Override
    public String toString() {
        return "Perceptron " + lang + " {" +
                "net=" + net +
                ", weightsVector=" + Arrays.toString(weightsVector) +
                ", decisions=" + decisions +
                ", threshold=" + threshold +
                ", learnConst=" + learnConst +
                '}';
    }
}
