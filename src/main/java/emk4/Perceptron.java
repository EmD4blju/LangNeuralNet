package emk4;
/**
 * @author Mikołaj Warda s28034
 */

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

    public void train(double[] inputVector, String correctLang){
        System.out.println("=-=-=-= TRAINING =-=-=-=" + correctLang + ", " + lang);
        for(int i = 0; i < inputVector.length; i++) {
            net = calculateNet(inputVector);
//            int correctDecision = decisions.get(lang.equals(correctLang) ? lang : "other");
//            int predictedDecision = net >= threshold ? 1 : 0;
//            System.out.println("correctDecision: " + correctDecision + ", predictedDecision: " + predictedDecision);
//            if(!(correctDecision == predictedDecision)){
//                learn(inputVector, correctDecision, predictedDecision);
//            }
        }
        System.out.println(this);
    }

    public void normalizeWeightVector(){
        double vectorLength = calculateWeightVectorLength();
        for (int i = 0; i < weightsVector.length; i++) {
            weightsVector[i] /= vectorLength;
        }
    }
    private double calculateWeightVectorLength(){
        double vectorLength = 0d;
        for(double weight : weightsVector){
            vectorLength += Math.pow(weight, 2);
        }
        return Math.sqrt(vectorLength);
    }
    protected void learn(double[] inputVector, int correctDecision, int predictedDecision) {
        threshold = threshold - (correctDecision - predictedDecision * learnConst);
        weightsVector = calculateNewWeights(inputVector, learnConst, correctDecision, predictedDecision);
        net = calculateNet(inputVector);
    }

    private double[] calculateNewWeights(double[] inputVector, double learnConst, int correctDecision, int predictedDecision) {
        double[] newWeights = new double[weightsVector.length];
        for(int i = 0; i < newWeights.length; i++){
            newWeights[i] = weightsVector[i] + (inputVector[i] * (correctDecision - predictedDecision) * learnConst);
        }
        return newWeights;
    }

    private double calculateNet(double[] inputVector) {
        double output = 0d;
        for(int i = 0; i < weightsVector.length; i++){
            output += weightsVector[i] * inputVector[i];
        }
        return output - threshold;
    }

    @Override
    public String toString() {
        return "Perceptron{" +
                "net=" + net +
                ", weightsVector=" + Arrays.toString(weightsVector) +
                ", decisions=" + decisions +
                ", threshold=" + threshold +
                ", lang='" + lang + '\'' +
                ", learnConst=" + learnConst +
                '}';
    }
}
