package tools;

import java.util.Formatter;
import java.util.List;

public class Tool {

    private Tool(){}

    public static void format(List<Double> sentimentList){

        Formatter format = new Formatter();
        format.format("%.2f", sentimentList.get(0));
        sentimentList.set(0, Double.parseDouble(format.toString()));

        format = new Formatter();
        format.format("%.2f", sentimentList.get(1));
        sentimentList.set(1, Double.parseDouble(format.toString()));

        format = new Formatter();
        format.format("%.2f", sentimentList.get(2));
        sentimentList.set(2, Double.parseDouble(format.toString()));
    }
}