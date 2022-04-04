public class main
{

    public static void main(String[] args) {

        String text = "There is some kind of a sweet innocence in being human—in not having to be just happy or just sad—in the nature of being able to be both broken and whole, at the same time.";
        //There’s death all around us. Everywhere we look. 1.8 people kill themselves every second. We just don’t pay attention. Until we do.
        //This is what it felt like to have a broken heart. It felt less like a cracking down the middle and more like she had swallowed it whole and it sat bruised and bleeding in the pit of her stomach
        //The sun kept on with its slipping away, and I thought how many small good things in the world might be resting on the shoulders of something terrible
        //As the light begins to intensify, so does my misery, and I wonder how it is possible to hurt so much when nothing is wrong.
        //There is some kind of a sweet innocence in being human—in not having to be just happy or just sad—in the nature of being able to be both broken and whole, at the same time.

        NLP.init();
        NLP.estimatingSentiment(text);

    }

}