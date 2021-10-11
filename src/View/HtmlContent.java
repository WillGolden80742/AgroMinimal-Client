package View;

import java.io.File;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author William
 */
public class HtmlContent {

    private final String fileIcon;
    private final String audioIcon;
    private final String imageIcon;
    private final String videoIcon;

    public HtmlContent() {
        this.audioIcon = "audioIcon.png";
        this.imageIcon = "imageIcon.png";
        this.videoIcon = "videoIcon.png";
        this.fileIcon = "filesIcon.png";
    }

    public String htmlMsg(String color, String floatMsg, int margin, int id, String message, String nomeArquivo, String nomeHashArquivo, String date) {
        String html = "<div style=\"width:100%;color:white;background-color:#color;margin:5px;padding:#topPadding 5px 5px 5px;border:1px solid #48545E;margin-#float:#marginpx;font-size:12px;right:0px;\" > #delete #anexo #message <p style=\"margin-top:-10px;\" align=\"right\"> #date </p> </div> ";
        String delete = "";
        String topPadding = "5";
        if (floatMsg.equals("left")) {
            delete = "<div align=\"right\" style=\"padding:0px 0px 3px 0px;\" > <a href=\"file:/" + id + "\" style=\"color:white;font-size:8px;text-decoration:none;\" > ••• </a></div>";
            topPadding = "0";
        }
        html = html.replace("#topPadding", topPadding);
        html = html.replace("#delete", delete);
        html = html.replace("#color", color);
        html = html.replace("#float", floatMsg);
        html = html.replace("#anexo", ((!nomeArquivo.equals("")) ? htmlAnexo(nomeArquivo, nomeHashArquivo) : ""));
        html = html.replace("#margin",""+margin);
        html = html.replace("#widthImg",""+((int)(260-(0.05*margin))));
        html = html.replace("#message", message);
        html = html.replace("#date", date);
        return html;
    }

    private boolean isImage(String format) {
        return format.toLowerCase().equals("png") || format.toLowerCase().equals("jpg") || format.toLowerCase().equals("jpge") || format.toLowerCase().equals("gif");
    }

    private boolean isAudio(String format) {
        return format.toLowerCase().equals("ogg") || format.toLowerCase().equals("wav") || format.toLowerCase().equals("mp3");
    }

    private boolean isVideo(String format) {
        return format.toLowerCase().equals("mp4") || format.toLowerCase().equals("mkv") || format.toLowerCase().equals("avi") || format.toLowerCase().equals("wmv") || format.toLowerCase().equals("flv") || format.toLowerCase().equals("mov");
    }

    private boolean isFile(String name, String format) {
        String fileFormat = format.split("[.]")[1];
        String hash = format.split("[.]")[0];
        boolean isFile = new File("Files/Received/" + fileFormat + "/" + hash + "/" + name).isFile();
        return isFile;
    }

    private String midiaAttachment(String html, String name, String format) {
        String icon = fileIcon;
        String path = new File("Images/").getAbsoluteFile().toURI().toString();
        boolean isAudio = isAudio(format);
        boolean isImage = isImage(format);
        boolean isVideo = isVideo(format);

        if (isAudio) {
            icon = audioIcon;
        } else if (isImage) {
            icon = imageIcon;          
        } else if (isVideo) {
            icon = videoIcon;
        }
        html = html.replace("#img", "<img src=\"" + path + icon + "\" height=\"16\" />");
        html = html.replace("#fileName", ((name.length() > 20) ? name.substring(0,19) + "..."+format : name));
        return html;
    }

    public String htmlAnexo(String nomeArquivo, String nomeHashArquivo) {
        String html = "<div style=\"background-color:#458f57;padding:10px 5px 10px 7px;border:1px solid white;\"> #img <a href=\"file:/#name/#hashName\" style=\"color:white;font-size:12px;text-decoration:none;\" > #fileName </a> </div>";
        String hashName = nomeHashArquivo;
        String hash = hashName.split("[.]")[0];
        String format = hashName.split("[.]")[1];
        String name = nomeArquivo + "." + format;
        String filePath = new File("Files/Received/" + format + "/" + hash + "/").getAbsoluteFile().toURI().toString();
        if (isFile(name, hashName) && isImage(format)) {
            html = "<div style=\"background-color:#458f57;\"><center> <a href=\"file:/#name/#hashName\" ><img src='" + filePath + "/" + name + "' width=\"#widthImg\" /></a></center></div>";
        } else {
            html = midiaAttachment(html, name, format);
        }
        html = html.replaceAll("#name", name);
        html = html.replaceAll("#hashName", hashName);
        return html;
    }

}
