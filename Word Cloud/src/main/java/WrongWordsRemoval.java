import com.vdurmont.emoji.EmojiParser;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class WrongWordsRemoval {

    ArrayList<String> wordsList = new ArrayList<>();

    public void removeWrongWords(String text) throws IOException {

        HashSet<String> words;
        words = lemmeWords(text);
        words = removeStopWords(words);
        words = compareToDictionary(words);

        try (FileWriter file = new FileWriter("words.txt")) {
            for(String word : words)
                file.write(word + " ");
            file.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public HashSet<String> lemmeWords(String text) throws IOException {

        text = EmojiParser.removeAllEmojis(text);
        text = text.replaceFirst( "\\[[^\\]]+\\]", "").trim();
        text = text.replaceFirst( "\\([^\\]]+\\)", "").trim();
        text = text.replaceAll("[\\u2060\\uD83D\\uFFFD\\uFE0F\\u203C\\u3010\\u3011\\u300A\\u166D\\u200C\\u202A\\u202C\\u2049\\u20E3\\u300B\\u300C\\u3030\\u065F\\u0099\\u0F3A\\u0F3B\\uF610\\uFFFC]", "");

        StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();
        CoreDocument coreDocument = new CoreDocument(text);
        stanfordCoreNLP.annotate(coreDocument);
        List<CoreLabel> coreLabelList = coreDocument.tokens();
        HashSet<String> words = new HashSet<>(wordsList);
        for(CoreLabel coreLabel : coreLabelList) {
            String lemma = coreLabel.lemma();
            words.add(lemma);
        }
        words = removeStopWords(words);
        return words;

    }

    public HashSet<String> removeStopWords(HashSet<String> words) throws IOException {

        String[] stopWords = fileToString();
        HashSet<String>StopWordsSet = new HashSet<>(Arrays.asList(stopWords));
        words.removeAll(StopWordsSet);
        return words;

    }

    public String[] fileToString() throws IOException {

        String separator = " ";
        String entireFile = Files.lines(Paths.get("stopWords.txt")).collect(Collectors.joining());
        return entireFile.split(separator);

    }

    public HashSet<String> compareToDictionary(HashSet<String> words) throws FileNotFoundException {

        String result = null;
        String compare = null;
        Scanner read = null;

        HashSet<String> newWords = new HashSet<>();

        for(String word : words)
        {
            read = new Scanner(new File("dictionary.txt"));
            result = "incorrect";
            while(read.hasNextLine())
            {
                compare = read.nextLine();
                if(compare.equalsIgnoreCase(word))
                {
                    result = "correct";
                    break;
                }

            }
            if(result.equals("correct"))
                newWords.add(word);
        }
        return newWords;
    }

}