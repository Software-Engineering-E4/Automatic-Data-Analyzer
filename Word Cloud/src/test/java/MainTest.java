import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void lemmaTest() throws IOException {
        String text = "birds, singer, sang, eats";
        WrongWordsRemoval instance = new WrongWordsRemoval();

        HashSet<String> expectedWords = new HashSet<>(Arrays.asList("bird", "singer", "sing", "eat"));

        HashSet<String> resultedWords = new HashSet<>(instance.lemmeWords(text));

        assertEquals(expectedWords, resultedWords, "Error! expectedWords and resultedWords don't match!");
    }

    @Test
    public void repeatTest() throws IOException {
        String text = "birds, birds, eats, eats";
        WrongWordsRemoval instance = new WrongWordsRemoval();

        HashSet<String> expectedWords = new HashSet<>(Arrays.asList("bird", "eat"));

        HashSet<String> resultedWords = new HashSet<>(instance.lemmeWords(text));

        assertEquals(expectedWords, resultedWords, "Error! expectedWords and resultedWords don't match!");
    }

    @Test
    public void stopWordRemoveTest() throws IOException {
        HashSet<String> text = new HashSet<>();
        text.add("disease"); text.add("they"); text.add("sick"); text.add("today");
        WrongWordsRemoval instance = new WrongWordsRemoval();

        HashSet<String> expectedWords = new HashSet<>(Arrays.asList("disease", "sick"));

        HashSet<String> resultedWords = new HashSet<>(instance.removeStopWords(text));

        assertEquals(expectedWords, resultedWords, "Error! expectedWords and resultedWords don't match!");
    }

    @Test
    public void dictionaryTest() throws IOException {
        HashSet<String> text = new HashSet<>();
        text.add("orang"); text.add("Ihave"); text.add("bird"); text.add("eat"); text.add("bluesky");
        WrongWordsRemoval instance = new WrongWordsRemoval();

        HashSet<String> expectedWords = new HashSet<>(Arrays.asList("bird", "eat"));

        HashSet<String> resultedWords = new HashSet<>(instance.compareToDictionary(text));

        assertEquals(expectedWords, resultedWords, "Error! expectedWords and resultedWords don't match!");
    }

}