public class main
{

    public static void main(String[] args) {

        String text = "Hi everyone, my aunt (74F) just had her entire lung removed due to cancer. It has been traumatic/devastating, since she\u2019s no longer eligible for her long-dreamed lung transplant. She\u2019s doing poorly, and I\u2019m hoping some kind words will cheer her up. If you\u2019d like to send her a card, please message me for her address. Thanks!\u2764\ufe0f";
        NLP.init();
        NLP.estimatingSentiment(text);
    }
}
