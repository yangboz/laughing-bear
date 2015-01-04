package info.smartkit.orc;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {

    public static void main(String[] args) throws TesseractException {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        //
        try {
            Tesseract tesseract = Tesseract.getInstance(); // JNA Interface Mapping
            String imageText = tesseract.doOCR(new File("/Users/yangboz/Documents/Git/laughing-bear/src/main/resources/api.php-2.png"));
            System.out.println("OCR Result = " + imageText);
        } catch (Exception e) {
            System.out.println("TessearctException while converting/uploading image: "+ e);
            throw new TesseractException();
        }
    }

}