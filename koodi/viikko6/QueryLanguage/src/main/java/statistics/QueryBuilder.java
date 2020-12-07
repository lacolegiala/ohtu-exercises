package statistics;

import statistics.matcher.*;

import java.util.ArrayList;
import java.util.List;

public class QueryBuilder implements Matcher {
    private List<Matcher> matchers;

    public QueryBuilder() {
        this.matchers = new ArrayList<>();
        this.matchers.add(new All());
    }

    public Matcher build() {
        return this;
    }

    public QueryBuilder playsIn(String team) {
        this.matchers.add(new PlaysIn(team));
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        this.matchers.add(new HasAtLeast(value, category));
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        this.matchers.add(new HasFewerThan(value, category));
        return this;
    }

    @Override
    public boolean matches(Player p) {
        for (Matcher matcher : matchers) {
            if (!matcher.matches(p)) {
                return false;
            }
        }

        return true;
    }
}