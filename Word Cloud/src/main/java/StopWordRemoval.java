
import java.io.*;
import java.util.*;

public class StopWordRemoval  {

    String[] stopWords = { "a", "about", "above", "across", "actually", "after", "again",
            "against", "all", "almost", "alone", "along", "already", "also",
            "although", "always", "among", "an", "and", "another", "any",
            "anybody", "anyone", "anything", "anywhere", "are", "area",
            "areas", "around", "as", "ask", "asked", "asking", "asks", "at",
            "away", "b", "back", "backed", "backing", "backs", "be", "became",
            "because", "become", "becomes", "been", "before", "began",
            "behind", "being", "beings", "best", "better", "between", "big",
            "both", "but", "by", "c", "came", "can", "cannot", "case", "cases",
            "certain", "certainly", "clear", "clearly", "come", "could", "d",
            "did", "differ", "different", "differently", "do", "don't", "does", "done",
            "down", "down", "downed", "downing", "downs", "during", "e",
            "each", "early", "either", "end", "ended", "ending", "ends",
            "enough", "even", "evenly", "ever", "every", "everybody",
            "everyone", "everything", "everywhere", "f", "face", "faces",
            "fact", "facts", "far", "felt", "few", "find", "finds", "first",
            "for", "four", "from", "full", "fully", "further", "furthered",
            "furthering", "furthers", "g", "gave", "general", "generally",
            "get", "gets", "give", "given", "gives", "go", "going", "good",
            "goods", "got", "great", "greater", "greatest", "group", "grouped",
            "grouping", "groups", "h", "had", "has", "have", "having", "he",
            "her", "here", "herself", "high", "high", "high", "higher",
            "highest", "him", "himself", "his", "how", "however", "i", "I", "I'm", "if",
            "important", "in", "interest", "interested", "interesting",
            "interests", "into", "is", "it", "its", "it's", "itself", "j", "just", "k",
            "keep", "keeps", "kind", "knew", "know", "known", "knows", "l",
            "large", "largely", "last", "later", "latest", "least", "less",
            "let", "lets", "like", "likely", "long", "longer", "longest", "m",
            "made", "make", "making", "man", "many", "may", "me", "member",
            "members", "men", "might", "more", "most", "mostly", "mr", "mrs",
            "much", "must", "my", "myself", "n", "necessary", "need", "needed",
            "needing", "needs", "never", "new", "new", "newer", "newest",
            "next", "no", "nobody", "non", "noone", "not", "nothing", "now",
            "nowhere", "number", "numbers", "o", "of", "off", "often", "old",
            "older", "oldest", "on", "once", "one", "only", "open", "opened",
            "opening", "opens", "or", "order", "ordered", "ordering", "orders",
            "other", "others", "our", "out", "over", "p", "part", "parted",
            "parting", "parts", "per", "perhaps", "place", "places", "point",
            "pointed", "pointing", "points", "possible", "present",
            "presented", "presenting", "presents", "problem", "problems",
            "put", "puts", "q", "quite", "r", "rather", "really", "right",
            "right", "room", "rooms", "s", "said", "same", "saw", "say",
            "says", "second", "seconds", "see", "seem", "seemed", "seeming",
            "seems", "sees", "several", "shall", "she", "should", "show",
            "showed", "showing", "shows", "side", "sides", "since", "small",
            "smaller", "smallest", "so", "some", "somebody", "someone",
            "something", "somewhere", "state", "states", "still", "still",
            "such", "sure", "t", "take", "taken", "than", "that", "the",
            "their", "they're", "them", "then", "there", "therefore", "these", "they",
            "thing", "things", "think", "thinks", "this", "those", "though",
            "thought", "thoughts", "three", "through", "thus", "to", "today",
            "together", "too", "took", "toward", "turn", "turned", "turning",
            "turns", "two", "u", "under", "until", "up", "upon", "us", "use",
            "used", "uses", "v", "very", "w", "want", "wanted", "wanting",
            "wants", "was", "way", "ways", "we", "well", "wells", "went",
            "were", "what", "when", "where", "whether", "which", "while",
            "who", "whole", "whose", "why", "will", "with", "within",
            "without", "work", "worked", "working", "works", "would", "x", "y",
            "year", "years", "yet", "you", "young", "younger", "youngest",
            "your", "yours", "z", "s", "re"};

    ArrayList<String> wordsList = new ArrayList<>();
    String str = "Cancer is a scary word. Almost everyone knows someone who got very sick or died from cancer. Most of the time, cancer affects " +
            "older people. Not many kids get cancer, but when they do, very often it can be treated and cured. Cancer is actually a group of many " +
            "related diseases that all have to do with cells. Cells are the very small units that make up all living things, including the human " +
            "body. There are billions of cells in each person's body. Cancer happens when cells that are not normal grow and spread very fast. " +
            "Normal body cells grow and divide and know to stop growing. Over time, they also die. Unlike these normal cells, cancer cells just " +
            "continue to grow and divide out of control and don't die when they're supposed to. Cancer cells usually group or clump together to " +
            "form tumors. A growing tumor becomes a lump of cancer cells that can destroy the normal cells around the tumor and " +
            "damage the body's healthy tissues. This can make someone very sick. Sometimes cancer cells break away from the original tumor and " +
            "travel to other areas of the body, where they keep growing and can go on to form new tumors. This is how cancer spreads. The spread of " +
            "a tumor to a new place in the body is called metastasis. You probably know a kid who had chickenpox — maybe even you. But you probably " +
            "don't know any kids who've had cancer. If you packed a large football stadium with kids, probably only one child in that stadium would " +
            "have cancer. Doctors aren't sure why some people get cancer and others don't. They do know that cancer is not contagious. You can't " +
            "catch it from someone else who has it — cancer isn't caused by germs, like colds or the flu are. So don't be afraid of other kids — or " +
            "anyone else — with cancer. You can talk to, play with, and hug someone with cancer. Kids can't get cancer from anything they do either. " +
            "Some kids think that a bump on the head causes brain cancer or that bad people get cancer. This isn't true! Kids don't do anything wrong " +
            "to get cancer. But some unhealthy habits, especially cigarette smoking or drinking too much alcohol every day, can make you a lot more " +
            "likely to get cancer when you become an adult.";

    public void removeStopWord() {
        System.out.println("Before trim:  " + str);
        String[] words = str.toLowerCase().split("[ '.,:;-]");
        Collections.addAll(wordsList, words);
        HashSet<String> wordWithStopWord = new HashSet<>(wordsList);
        HashSet<String> StopWordsSet = new HashSet<>(Arrays.asList(stopWords));
        wordWithStopWord.removeAll(StopWordsSet);
        System.out.println(wordWithStopWord);
        try (FileWriter file = new FileWriter("words.txt")) {
            file.write(String.valueOf(wordWithStopWord));
            file.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
