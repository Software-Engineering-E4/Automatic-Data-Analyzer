import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.List;

public class LemmeExample {

    public static void main(String[] args) {

        StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();

        String text ="\"Hi sorry if this is badly typed grammar wise I\\u2019m trying (fake names and all that )\\n\\nMy boyfriend (m 22) Michael just got diagnosed with B cell non Hodgkin\\u2019s lymphoma in February roughly. And Michael runs hot naturally before he got sick. My question is do any of you know what is the best electric sleep pad for our queen sized bed. Anything you would recommend to help with sweats especially during super hot summers thanks in advance\"";

        CoreDocument coreDocument = new CoreDocument(text);

        stanfordCoreNLP.annotate(coreDocument);

        List<CoreLabel> coreLabelList = coreDocument.tokens();

        for(CoreLabel coreLabel : coreLabelList) {
            String lemma = coreLabel.lemma();
            System.out.println(coreLabel.originalText() + " = "+ lemma);
        }


    }
}