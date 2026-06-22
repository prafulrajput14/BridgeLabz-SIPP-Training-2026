import java.util.*;

class AuthenticationManager {
    private int timeToLive;
    private Map<String, Integer> tokens;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        tokens = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        tokens.put(tokenId, currentTime + timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        if (tokens.containsKey(tokenId) && tokens.get(tokenId) > currentTime) {
            tokens.put(tokenId, currentTime + timeToLive);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for (int expiry : tokens.values()) {
            if (expiry > currentTime) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        AuthenticationManager am = new AuthenticationManager(5);
        am.generate("token1", 1);
        am.generate("token2", 2);
        System.out.println(am.countUnexpiredTokens(3));
        am.renew("token1", 3);
        System.out.println(am.countUnexpiredTokens(6));
        am.generate("token3", 7);
        System.out.println(am.countUnexpiredTokens(8));
    }
}
