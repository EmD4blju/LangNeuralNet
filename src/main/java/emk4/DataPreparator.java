package emk4;

import java.util.*;

public class DataPreparator {

    public static String stringifyFileLines(List<String> fileLines){
        StringBuilder stringBuilder = new StringBuilder();
        for(String line : fileLines){
            stringBuilder.append(line);
        }
        return stringBuilder.toString();
    }

    public static double[] prepareData(String inputText){
        double[] data = new double['z' - 'a' + 1];

        for(int i = 0; i < inputText.length(); i++){
            char currentChar = inputText.charAt(i);
            if(Character.isUpperCase(currentChar)){
                currentChar = Character.toLowerCase(currentChar);
            }
            if(!(currentChar >= 'a' && currentChar <= 'z')){
                continue;
            }

            data[currentChar - 'a'] += 1;
        }

        for (int i = 0; i < data.length; i++) {
            data[i] = data[i] / data.length;
        }

        return data;
    }

    public static double initThreshold() {
        return Math.random();
    }

    public static double[] initWeights() {
        double[] weights = new double['z' - 'a' + 1];
        for (int i = 0; i < weights.length; i++) {
            weights[i] = Math.random();
        }
        return weights;
    }

    public static Map<String, Integer> initDecisions(String subDir) {
        Map<String, Integer> decisions = new LinkedHashMap<>();
        decisions.put(subDir, 1);
        decisions.put("other", 0);
        return decisions;
    }

    public static double initLearnConst() {
        return 0.25;
    }
}
