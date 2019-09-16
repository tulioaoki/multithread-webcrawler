/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcrawler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author tulioaoki
 */
public class ImageDownloader implements Callback {
    String destino = "/tmp/crawler/";

    public ImageDownloader() {
        
    }

    @Override
    public void callback(String url) {
        new Thread() {
            @Override
            public void run(){
                try {
                    InputStream inputStream;
                    OutputStream outputStream;
                    URL imgUrl = new URL(url);
                    inputStream = imgUrl.openStream();
                    System.out.println("Salvando " + destino + imgUrl.getPath().substring(imgUrl.getPath().lastIndexOf('/') + 1));
                    outputStream = new FileOutputStream(destino+ imgUrl.getPath().substring(imgUrl.getPath().lastIndexOf('/') + 1));

                    byte[] buffer = new byte[2048];
                    int length;

                    while ((length = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, length);
                    }
                    inputStream.close();
                    outputStream.close();

                } catch (MalformedURLException e) {
                    System.out.println("MalformedURLException :- " + e.getMessage());

                }  catch (IOException e) {
                    System.out.println("IOException :- " + e.getMessage());

                }
            }
        }.start();
    }

}
