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
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author tulioaoki
 */
public class CustomBuffer {
    BlockingQueue<String> queue;
    Object aux;
    String aux2;
    Callback c;
    String destino = "/tmp/crawler/";
    
    CustomBuffer(Callback c){
         this.queue = new LinkedBlockingQueue();
         this.c = c;
    }
    
    public void add(String str){
        this.queue.add(str);
        this.listenChange();
    }
    
    public String pop(){
        aux = queue.poll();
        if(aux != null){
            return (String) aux;
        }
        return null;
    }
    
    public void listenChange(){
        aux2 = (String) this.pop();
        if(aux != null){
            this.c.callback(aux2);
        }
    }
}
