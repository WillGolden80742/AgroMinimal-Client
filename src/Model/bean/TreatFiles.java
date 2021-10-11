/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.bean;

import View.Chat;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author William
 */
public class TreatFiles extends Arquivos {

    private String pathName;
    private String fileName;
    private byte[] fileBytes = null;

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

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

    public String getFileName() {
        return fileName;
    }

    // Gerar soma hash de arquivo 
    public String getHashedNameFile() {
        String hash = "";
        try {
            MessageDigest md;
            md = MessageDigest.getInstance("MD5");
            md.update(fileBytes);
            System.out.println();
            BigInteger hashInt = new BigInteger(1, md.digest());
            hash = hashInt.toString(16);
        } catch (NullPointerException | NoSuchAlgorithmException e) {

        }
        return hash;
    }

    // Pegar formato do arquivo a partir do seu endereço de máquina local
    public String getFileFormat() {
        String[] fomartFile = pathName.split("[.]");
        String format = fomartFile[fomartFile.length - 1];
        return format;
    }

    // Pegar formato do arquivo a partir do seu nome que foi transformado em hash
    public String getFileHashedFormat() {
        String[] fomartFile = getHashArquivo().split("[.]");
        String format = fomartFile[fomartFile.length - 1];
        return format;
    }

    // Salvar arquivo renomeado para o nome original
    public void saveRenomedFile() throws IOException {
        // Nome
        String name = getNomeArquivo();
        // Formato
        String format = getFileHashedFormat();
        //        
        String hash = getHashArquivo().split("[.]")[0];
        System.out.print(hash);
        // Arquivo
        byte[] file = getArquivo();

        new File("Files").mkdir();
        new File("Files/Received").mkdir();
        new File("Files/Received/" + format).mkdir();
        new File("Files/Received/" + format + "/" + hash + "/").mkdir();
        Path path = Paths.get("Files/Received/" + format + "/" + hash + "/" + name + "." + format);
        setPathName(path.toString());

        try {
            Files.write(path, file);
        } catch (IOException ex) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        }
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
