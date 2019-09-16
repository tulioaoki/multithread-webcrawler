package webcrawler;
import java.io.IOException;

/**
 *
 * @author tulioaoki
 */
public class WebCrawler {
         
    public static void main(String[] args) throws IOException, Exception {
        // TODO code application logic here
        ImageDownloader id = new ImageDownloader();
        CustomBuffer cb = new CustomBuffer(id);
        Crawler tj = new Crawler("/tmp/teste.txt", cb);
        tj.crawl();
        
        
    }
    
}
