/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcrawler;

/**
 *
 * @author tulioaoki
 */
public class AsyncThread implements Runnable {
    Callback c; 

    public AsyncThread(Callback c) {
        this.c = c;
    }
    
    public void run(String url) throws Exception {
        String s;
        //s = rd.getStringHtml(url);
        //this.c.callback(); // callback
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
