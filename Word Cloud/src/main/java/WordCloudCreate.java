import com.kennycason.kumo.CollisionMode;
import com.kennycason.kumo.WordCloud;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.bg.CircleBackground;
import com.kennycason.kumo.font.scale.SqrtFontScalar;
import com.kennycason.kumo.nlp.FrequencyAnalyzer;
import com.kennycason.kumo.palette.LinearGradientColorPalette;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class WordCloudCreate {

    public void createWordCloud() throws IOException {

        final FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
        frequencyAnalyzer.setWordFrequenciesToReturn(500);
        frequencyAnalyzer.setMinWordLength(4);
        final List<WordFrequency> wordFrequencies = frequencyAnalyzer.load("words.txt");
        final Dimension dimension = new Dimension(600, 600);
        final WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
        wordCloud.setPadding(2);
        wordCloud.setBackground(new CircleBackground(300));
        //colors followed by and steps between
        wordCloud.setColorPalette(new LinearGradientColorPalette(Color.RED, Color.BLUE, Color.GREEN, 30, 30));
        wordCloud.setFontScalar(new SqrtFontScalar(10, 30));
        wordCloud.build(wordFrequencies);
        wordCloud.writeToFile("C:\\Users\\Andra\\Desktop\\blackBackground.png");

        File in = new File("C:\\Users\\Andra\\Desktop\\blackBackground.png");
        BufferedImage source = ImageIO.read(in);
        int color = source.getRGB(0, 0);
        Image image = makeColorTransparent(source, new Color(color));
        BufferedImage transparent = imageToBufferedImage(image);
        File out1 = new File("C:\\Users\\Andra\\Desktop\\WordCloud.png");
        ImageIO.write(transparent, "png", out1);

    }

    private static BufferedImage imageToBufferedImage(Image image) {

        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = bufferedImage.createGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
        return bufferedImage;

    }

    public static Image makeColorTransparent(BufferedImage im, final Color color) {

        ImageFilter filter = new RGBImageFilter() {

            public final int markerRGB = color.getRGB() | 0xFF000000;

            public int filterRGB(int x, int y, int rgb) {
                if ((rgb | 0xFF000000) == markerRGB) {
                    return 0x00FFFFFF & rgb;
                } else {
                    return rgb;
                }
            }
        };

        ImageProducer ip = new FilteredImageSource(im.getSource(), filter);
        return Toolkit.getDefaultToolkit().createImage(ip);

    }


}
