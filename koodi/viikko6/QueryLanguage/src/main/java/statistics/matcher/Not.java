package statistics.matcher;
import statistics.Player;

public class Not implements Matcher {
    Matcher[] matcherClass;
    int value;
    int category;

    public Not(Matcher... matcherClass) {
//        this.matcherClass = matcherClass;
//        this.value = value;
//        this.category = category;
        this.matcherClass = matcherClass;
    }

    @Override
    public boolean matches(Player player) {
        for (Matcher matcher : matcherClass) {
            if (!matcher.matches(player)) {
                return true;
            }
        }

        return false;
    }
}