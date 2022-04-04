//MonkeyLearn minimal testing

package testmonkey;

import com.monkeylearn.MonkeyLearn;
import com.monkeylearn.MonkeyLearnResponse;
import com.monkeylearn.MonkeyLearnException;

import java.util.Arrays;

public class Main {
    public static void main( String[] args ) throws MonkeyLearnException {

        MonkeyLearn ml = new MonkeyLearn("b6baceaccce098dc5c45dab16cc93c61b46867aa");
        String modelId = "cl_mEcCuEcG";
        String[] text1 = {"There’s death all around us. Everywhere we look. 1.8 people kill themselves every second. We just don’t pay attention. Until we do."};
        String[] text2 = {"There is some kind of a sweet innocence in being human—in not having to be just happy or just sad—in the nature of being able to be both broken and whole, at the same time."};
        String[] text3 = {"I hate this comment!!!"};
        MonkeyLearnResponse res1 = ml.classifiers.classify(modelId, text1, true);
        System.out.println("The analysis result for the text: " + Arrays.toString(text1)); System.out.println( res1.arrayResult ); System.out.println();
        MonkeyLearnResponse res2 = ml.classifiers.classify(modelId, text2, true);
        System.out.println("The analysis result for the text: " + Arrays.toString(text2));System.out.println( res2.arrayResult ); System.out.println();
        MonkeyLearnResponse res3 = ml.classifiers.classify(modelId, text3, true);
        System.out.println("The analysis result for the text: " + Arrays.toString(text3));System.out.println( res3.arrayResult ); System.out.println();

    }

}
