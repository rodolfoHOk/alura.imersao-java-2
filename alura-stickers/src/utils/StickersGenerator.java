package utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class StickersGenerator {

  public void create(InputStream inputStream, String fileName, String stickerText) throws IOException {

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
    var font = new Font("Comic Neue", Font.BOLD, 96);
    graphics.setFont(font);

    // escrever uma frase na nova imagem
    int messageWidth = graphics.getFontMetrics().stringWidth(stickerText);
    int xPosition = (width - messageWidth) / 2;
    int yPosition = newHeight - ((newHeight - height) / 2) + (font.getSize() / 2);
    graphics.setColor(Color.ORANGE);
    graphics.drawString(stickerText, xPosition, yPosition);

    FontRenderContext fontRenderContext = graphics.getFontRenderContext();
    AffineTransform transform = graphics.getTransform();
    transform.translate(xPosition, yPosition);
    graphics.setTransform(transform);
    var textLayout = new TextLayout(stickerText, font, fontRenderContext);
    Shape outline = textLayout.getOutline(null);
    var stroke = new BasicStroke(width * 0.005f);
    graphics.setStroke(stroke);
    graphics.setColor(Color.black);
    graphics.draw(outline);

    // escrever a nova imagem em um arquivo
    ImageIO.write(newImage, "png", new File("images/out/" + fileName + ".png"));

  }

  public void create(InputStream inputStream, String fileName, String stickerText, InputStream overlapIs) throws IOException {

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

    BufferedImage overlapImage = ImageIO.read(overlapIs);
    graphics.drawImage(overlapImage, 0, height - 100, null);

    // configurar a fonte
    var font = new Font("Comic Neue", Font.BOLD, 96);
    graphics.setFont(font);

    // escrever uma frase na nova imagem
    int messageWidth = graphics.getFontMetrics().stringWidth(stickerText);
    int xPosition = (width - messageWidth) / 2;
    int yPosition = newHeight - ((newHeight - height) / 2) + (font.getSize() / 2);
    graphics.setColor(Color.ORANGE);
    graphics.drawString(stickerText, xPosition, yPosition);

    FontRenderContext fontRenderContext = graphics.getFontRenderContext();
    AffineTransform transform = graphics.getTransform();
    transform.translate(xPosition, yPosition);
    graphics.setTransform(transform);
    var textLayout = new TextLayout(stickerText, font, fontRenderContext);
    Shape outline = textLayout.getOutline(null);
    var stroke = new BasicStroke(width * 0.005f);
    graphics.setStroke(stroke);
    graphics.setColor(Color.black);
    graphics.draw(outline);

    // escrever a nova imagem em um arquivo
    ImageIO.write(newImage, "png", new File("images/out/" + fileName + ".png"));

  }

}
