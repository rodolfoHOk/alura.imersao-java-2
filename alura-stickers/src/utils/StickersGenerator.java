package utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class StickersGenerator {

  public void create(InputStream inputStream, String fileName) throws IOException {

    // leitura da imagem
    BufferedImage originalImage = ImageIO.read(inputStream);

    // cria nova imagem em memória com transparência e com tamanho novo
    int width = originalImage.getWidth();
    int height = originalImage.getHeight();
    int newHeight = height + 200;
    BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

    // copiar a imagem original pra novo imagem (em memória)
    Graphics2D graphics = (Graphics2D) newImage.getGraphics();
    graphics.drawImage(originalImage, 0, 0, null);

    // configurar a fonte
    graphics.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 64));

    // escrever uma frase na nova imagem
    graphics.setColor(Color.YELLOW);
    graphics.drawString("TOPZERA", 64, newHeight - 125);
    graphics.setColor(Color.ORANGE);
    graphics.drawString("Imersão Java", 64, newHeight - 50);

    // escrever a nova imagem em um arquivo
    ImageIO.write(newImage, "png", new File("images/out/" + fileName + ".png"));

  }

}
