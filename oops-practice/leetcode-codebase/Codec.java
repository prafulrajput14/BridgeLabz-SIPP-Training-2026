import java.util.*;

public class Codec {
    private Map<Integer, String> map = new HashMap<>();
    private int counter = 0;

    public String encode(String longUrl) {
        counter++;
        String shortUrl = "http://tinyurl.com/" + counter;
        map.put(counter, longUrl);
        return shortUrl;
    }

    public String decode(String shortUrl) {
        int key = Integer.parseInt(shortUrl.replace("http://tinyurl.com/", ""));
        return map.get(key);
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        String encoded = codec.encode("https://leetcode.com/problems/design-tinyurl");
        System.out.println("Encoded: " + encoded);
        System.out.println("Decoded: " + codec.decode(encoded));
    }
}
