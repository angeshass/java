package taskParsing;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class Parsing {
    public static List<Pattern> patternParse(String line) throws Exception {

        List<Pattern> users = new ArrayList<>();
        try (JsonReader jr = Json.createReader(new StringReader(line))) {
            JsonArray ja = jr.readArray();
            for (int i = 0; i < ja.size(); i++) {
                JsonObject jo = ja.getJsonObject(i);
                users.add(parseObject(jo));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return users;
    }

    private static Pattern parseObject(JsonObject jo) throws Exception {
        int id = jo.getInt("id");
        String name = jo.getString("name");
        String company = jo.getString("company");
        String username = jo.getString("username");
        String email = jo.getString("email");
        String address = jo.getString("address");
        String zip = jo.getString("zip");
        String state = jo.getString("state");
        String country = jo.getString("country");
        String phone = jo.getString("phone");
        String photo = jo.getString("photo");
        return new Pattern(id, name, company, username, email, address, zip, state, country, photo, phone);
    }

    public static void printParsed(List<Pattern> users) {
        int userIndex = 1;
        for (Pattern user : users) {
            System.out.println("User " + userIndex);
            user.printPattern();
            userIndex++;
        }
    }
}
