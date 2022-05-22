//Kumo to generate an image file of a word cloud
//A word cloud is a visual representation of words
//Cloud creators are used to highlight popular words and phrases based on frequency and relevance
//They provide you with quick and simple visual insights that can lead to more in-depth analyses

import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, IOException {

        Database.createConnection();
        var reddit = new RedditPostsDAO();
        String text;
        text = reddit.getSelftext();
        Database.getConnection().commit();
        Database.closeConnection();

        System.out.println(text);

        WrongWordsRemoval wrongWordsRemove = new WrongWordsRemoval();
        wrongWordsRemove.removeWrongWords(text);

        System.out.println(wrongWordsRemove);

        WordCloudCreate wordCloud = new WordCloudCreate();
        wordCloud.createWordCloud();

    }

}