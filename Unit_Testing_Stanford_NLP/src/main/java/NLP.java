import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations.SentimentAnnotatedTree;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;

public class NLP {

    static StanfordCoreNLP pipeline;

    public static void init()
    {
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, parse, sentiment");
        pipeline = new StanfordCoreNLP(props);
    }

    public static List<Double> estimatingSentiment(String text)
    {
        List<Double> sentimentList = new ArrayList<>();

        int sentimentInt;
        String sentimentName;
        Annotation annotation = pipeline.process(text);

        double length = 0;
        double lengthNegative = 0;
        double lengthPositive = 0;
        double lengthNeutral = 0;

        for(CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class))
        {
            Tree tree = sentence.get(SentimentAnnotatedTree.class);
            sentimentInt = RNNCoreAnnotations.getPredictedClass(tree);
            sentimentName = sentence.get(SentimentCoreAnnotations.SentimentClass.class);

            if( sentimentInt == 3 || sentimentInt == 4 ){
                lengthPositive += sentence.toString().length();
            }else if( sentimentInt == 2 ){
                lengthNeutral += sentence.toString().length();
            }else{
                lengthNegative += sentence.toString().length();
            }
            length += sentence.toString().length();

            //System.out.println(sentimentName + "\t" + sentimentInt + "\t" + sentence);
        }

        sentimentList.add(lengthNegative * 100 / length);
        sentimentList.add(lengthNeutral * 100 / length);
        sentimentList.add(lengthPositive * 100 / length);
        return sentimentList;
    }
}