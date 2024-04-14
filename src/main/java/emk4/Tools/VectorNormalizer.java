package emk4.Tools;

public class VectorNormalizer {
    public static double[] normalize(double[] vector){
        double[] normalizedVector = new double[vector.length];
        double vectorLength = calculateVectorLength(vector);
        for (int i = 0; i < vector.length; i++) {
            normalizedVector[i] = vector[i] / vectorLength;
        }
        return normalizedVector;
    }
    private static double calculateVectorLength(double[] vector){
        double vectorLength = 0d;
        for(double weight : vector){
            vectorLength += Math.pow(weight, 2);
        }
        return Math.sqrt(vectorLength);
    }
}
