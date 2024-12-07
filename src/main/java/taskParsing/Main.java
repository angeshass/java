package taskParsing;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import static taskParsing.Parsing.*;

public class Main {
    public static void main(String[] args) {
        try {
            URL u = new URL("https://fake-json-api.mock.beeceptor.com/users");
            HttpURLConnection huc = (HttpURLConnection) u.openConnection();
            huc.setRequestMethod("GET");
            //check success code
            int code = huc.getResponseCode();
            if (code >= 200 && code < 300) {
                //сохраняем всё
                InputStream is = huc.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String line;
                StringBuilder result = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    result.append(line);
                }
                List<Pattern> users = patternParse(result.toString());
                printParsed(users);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
