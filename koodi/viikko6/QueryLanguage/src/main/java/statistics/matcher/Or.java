package statistics.matcher;

import statistics.Player;

public class Or implements Matcher {

    private Matcher[] matchers;

    public Or(Matcher... matchers) {
        this.matchers = matchers;
    }

    @Override
    public boolean matches(Player player) {
        int numberOfNonMatchedMatchers = 0;
        for (Matcher matcher : matchers) {
            if (!matcher.matches(player)) {
                numberOfNonMatchedMatchers++;
                if (numberOfNonMatchedMatchers == matchers.length) {
                    return false;
                }
            }
        }

        return true;
    }
}
