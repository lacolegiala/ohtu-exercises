package statistics;

import statistics.matcher.*;

import java.util.ArrayList;
import java.util.List;

public class QueryBuilder {
    private class InnerMatcher implements Matcher {
        private List<Matcher> matchers= new ArrayList<>();
        public InnerMatcher(List<Matcher> matchers) {
            this.matchers.addAll(matchers);
        }

        @Override
        public boolean matches(Player player) {
            for (Matcher matcher : matchers) {
                if (!matcher.matches(player)) {
                    return false;
                }
            }

            return true;
        }
    }

    private class OrMatcher implements Matcher {
        private List<Matcher> matchers = new ArrayList<>();
        public OrMatcher(Matcher matcher1, Matcher matcher2) {
            matchers.add(matcher1);
            matchers.add(matcher2);
        }

        @Override
        public boolean matches(Player player) {
            int numberOfNonMatchedMatchers = 0;
            for (Matcher matcher : matchers) {
                if (!matcher.matches(player)) {
                    numberOfNonMatchedMatchers++;
                    if (numberOfNonMatchedMatchers == matchers.size()) {
                        return false;
                    }
                }
            }

            return true;
        }
    }

    private List<Matcher> matchers;

    public QueryBuilder() {
        this.matchers = new ArrayList<>();
        this.matchers.add(new All());
    }

    public Matcher build() {
        Matcher innerMatcher = new InnerMatcher(matchers);
        matchers.clear();
        return innerMatcher;
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

    public QueryBuilder oneOf(Matcher matcher1, Matcher matcher2) {
        this.matchers.add(new OrMatcher(matcher1, matcher2));
        return this;
    }

}