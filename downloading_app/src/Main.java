import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Scanner;

public class Main {
    private static final String dir = "source/";

    public static void main(String[] args) {
        new File(dir).mkdirs();

        Scanner scanner = new Scanner(System.in);
        while (true){
            String url = scanner.next();
            //https://mezzoforte.ru/s/the_beatles/help.mp3

            try {
                URL website = new URL(url);
                ReadableByteChannel rbc = Channels.newChannel(website.openStream());
                FileOutputStream fos = new FileOutputStream(dir+url.substring(url.lastIndexOf('/')+1));
                fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }


    }
}
