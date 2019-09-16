/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcrawler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author tulioaoki
 */
public class Crawler {
    private CustomBuffer cb;
    String fileName;
    
    public Crawler(String fileName, CustomBuffer cb){
        this.cb = cb;
        this.fileName = fileName;
    }
    
    public void crawl() throws Exception{
        File arq = new File(this.fileName);
        FileReader fileR;
        BufferedReader bufferR;
        String readLine = "";
        
        if (arq.exists()) {
            fileR = new FileReader(arq);
            bufferR = new BufferedReader(fileR);
            while (readLine != null) {
                readLine = bufferR.readLine();
                if (readLine == null) {
                    break;
                }
                //discovery.PegarImagens(readLine);
                this.crawlImages(readLine);
            }
            bufferR.close();
            fileR.close();

        } else {
            arq.createNewFile();
        }
        
    }
    
    private void crawlImages(String url) throws Exception{
        RequestDealer rd = new RequestDealer();
        String l,img;
        l = rd.getStringHtml(url);
        Pattern pattern = Pattern.compile(
                "http(s?)://([\\w-]+\\.)+[\\w-]+(/[\\w- ./]*)+\\.(?:[gG][iI][fF]|[jJ][pP][gG]|[jJ][pP][eE][gG]|[pP][nN][gG]|[bB][mM][pP])"
        );
        Matcher matcher = pattern.matcher(l);
        
        while (matcher.find()) {
            this.cb.add(matcher.group());
        }
    }
   

}