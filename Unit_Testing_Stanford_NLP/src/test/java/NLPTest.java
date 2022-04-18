import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NLPTest{

    @Test
    void positiveText1(){
        NLP.init();
        String selfText="I get to be five years cancer free";
        List<Double> sentimentList = NLP.estimatingSentiment(selfText);
        assertEquals(100,sentimentList.get(2));
    }
    @Test
    void positiveText2(){
        NLP.init();
        String selfText="I still have hope for the next treatments, as we all do.";
        List<Double> sentimentList = NLP.estimatingSentiment(selfText);
        assertEquals(100,sentimentList.get(2));
    }

    @Test
    void positiveText3(){
        NLP.init();
        String selfText="I am truly one lucky person.";
        List<Double> sentimentList = NLP.estimatingSentiment(selfText);
        assertEquals(100,sentimentList.get(2));
    }

    @Test
    void positiveText4(){
        NLP.init();
        String selfText="I smile when I’m with you and feel like the most special person in the world.";
        List<Double> sentimentList = NLP.estimatingSentiment(selfText);
        assertEquals(100,sentimentList.get(2));
    }

    @Test
    void positiveText5(){
        NLP.init();
        String selfText="I love knowing that we can make it through anything together. ";
        List<Double> sentimentList = NLP.estimatingSentiment(selfText);
        assertEquals(100,sentimentList.get(2));
    }
    @Test
    void positiveText6(){
        NLP.init();
        String selfText="I told him i will always be by his side and not to worry about anything";
        List<Double> sentimentList = NLP.estimatingSentiment(selfText);
        assertEquals(100,sentimentList.get(2));
    }

    @Test
    void negativeText1(){
        NLP.init();
        String selfText="My father was recently diagnosed with stage 4 lung cancer.";
        List<Double> sentimentList = NLP.estimatingSentiment(selfText);
        assertEquals(100,sentimentList.get(0));
    }

    @Test
    void negativeText2(){
        NLP.init();
        String selfText="The swelling in his head is so bad now that he can\\u2019t insert his hearing aid anymore, rendering him essentially deaf.";
        List<Double> sentimentList = NLP.estimatingSentiment(selfText);
        assertEquals(100,sentimentList.get(0));
    }

    @Test
    void negativeText3(){
        NLP.init();
        String selfText="I\\u2019ve been punched in the face by two apex predators and I think my nose is broken";
        List<Double> sentimentList = NLP.estimatingSentiment(selfText);
        assertEquals(100,sentimentList.get(0));
    }

    @Test
    void negativeText4(){
        NLP.init();
        String selfText="It sounds like his tumor is on the larger size.";
        List<Double> sentimentList = NLP.estimatingSentiment(selfText);
        assertEquals(100,sentimentList.get(0));
    }

    @Test
    void negativeText5(){
        NLP.init();
        String selfText=" I started chemotherapy last week I\\u2019m almost done with my first cycle and since yesterday my body feels like \n" +
                "        I was beaten up by 10 people.";
        List<Double> sentimentList = NLP.estimatingSentiment(selfText);
        assertEquals(100,sentimentList.get(0));
    }

    @Test
    void neutralText1(){
        NLP.init();
        String selfText="I never thought much about the end stage.";
        List<Double> sentimentList = NLP.estimatingSentiment(selfText);
        assertEquals(100,sentimentList.get(1));
    }

    @Test
    void neutralText2(){
        NLP.init();
        String selfText="The dr wanted to delay a week last time but Mom wanted to push on.";
        List<Double> sentimentList = NLP.estimatingSentiment(selfText);
        assertEquals(100,sentimentList.get(1));
    }

    @Test
    void neutralText3(){
        NLP.init();
        String selfText="We order a replacement credit and bank card.";
        List<Double> sentimentList = NLP.estimatingSentiment(selfText);
        assertEquals(100,sentimentList.get(1));
    }
    @Test
    void neutralText4(){
        NLP.init();
        String selfText="Those are only the interviews I've heard.";
        List<Double> sentimentList = NLP.estimatingSentiment(selfText);
        assertEquals(100,sentimentList.get(1));
    }

    @Test
    void neutralText5(){
        NLP.init();
        String selfText="I wake before him and fix my breakfast.";
        List<Double> sentimentList = NLP.estimatingSentiment(selfText);
        assertEquals(100,sentimentList.get(1));
    }


}