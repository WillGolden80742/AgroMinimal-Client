/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.bean;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author William
 */
public class TreatFiles {

    private String pathName;
    private String fileName;
    private byte[] fileBytes = null;


    //Não usado ainda private String fileName; public String getFileName() {
    public void setFileName(String fileName) {
        String[] pointArr = fileName.split("[.]");
        String withoutFormat = pointArr[pointArr.length - 1];
        String format = withoutFormat;

        withoutFormat = fileName.replace("." + withoutFormat, "");
        if (isNotSupportedAudio(format) || isVideo(format)) {
            withoutFormat = removeAccent(withoutFormat);
            withoutFormat = withoutFormat.replaceAll("[^A-Za-z0-9_-[.] ]", "");
        }
        this.fileName = withoutFormat;
    }

    private boolean isNotSupportedAudio (String format) {
        return format.toLowerCase().equals("ogg") || format.toLowerCase().equals("wav");
    }
    private boolean isVideo (String format) {
        return format.toLowerCase().equals("mp4");
    }    
    public static String removeAccent(String text) {
        String withAccent = "ÄÅÁÂÀÃäáâàãÉÊËÈéêëèÍÎÏÌíîïìÖÓÔÒÕöóôòõÜÚÛüúûùÇç";
        String withoutAccent = "AAAAAAaaaaaEEEEeeeeIIIIiiiiOOOOOoooooUUUuuuuCc";

        for (int i = 0; i < withAccent.length(); i++) {
            text = text.replaceAll(String.valueOf(withAccent.charAt(i)), String.valueOf(withoutAccent.charAt(i)));
        }
        return text;
    }



    // Pegar formato do arquivo a partir do seu endereço de máquina local
    public String getFileFormat() {
        String[] fomartFile = pathName.split("[.]");
        String format = fomartFile[fomartFile.length - 1];
        return format;
    }



    // Coletar bytes[] a partir de arquivo localizado na própria maquina
    public void setBytes(String pathName) throws IOException {
        this.pathName = pathName;
        this.fileBytes = java.nio.file.Files.readAllBytes(Paths.get(pathName));
    }

    public void setBytes(byte[] fileBytes) throws IOException {
        this.fileBytes = fileBytes;
    }

    public byte[] getBytes() {
        return fileBytes;
    }

    public static BufferedImage resizeImage(BufferedImage image) {
        return resizeImage(image, 50);
    }

    public static BufferedImage resizeImage(BufferedImage image, int h) {
        int oldH = image.getHeight();
        int newH = h;
        int oldW = image.getWidth();
        int newW = (oldW * newH) / oldH;
        BufferedImage new_img = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = new_img.createGraphics();
        g.drawImage(image, 0, 0, newW, newH, null);
        g.dispose();
        return new_img;
    }

    public static byte[] resizeImage(byte[] byteImage, int h, String format) {
        InputStream is = new ByteArrayInputStream(byteImage);
        BufferedImage bi;
        try {
            bi = ImageIO.read(is);
            bi = resizeImage(bi, h);
            byteImage = toByteArray(bi, "jpg");
        } catch (IOException ex) {
            Logger.getLogger(TreatFiles.class.getName()).log(Level.SEVERE, null, ex);
        }
        return byteImage;
    }

    public static byte[] toByteArray(BufferedImage bi, String format) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bi, format, baos);
        byte[] bytes = baos.toByteArray();
        return bytes;
    }
}
