package statistics.matcher;
import statistics.Player;

import java.lang.reflect.Method;

public class HasFewerThan implements Matcher {
    private int value;
    private String category;

    public HasFewerThan(int value, String category) {
        this.value = value;
        this.category = "get"+Character.toUpperCase(category.charAt(0))+category.substring(1, category.length());
    }

    @Override
    public boolean matches(Player player) {
        try {
            Method method = player.getClass().getMethod(category);
            int playersValue = (Integer)method.invoke(player);
            return playersValue < value;

        } catch (Exception exception) {
            System.out.println(exception);
            throw new IllegalStateException("Player does not have field " + category.substring(3, category.length()).toLowerCase());
        }
    }
}