package Main;

/**
 * @author Moose (Antoine Moghaddar 8-1-2016.)
 *         Represents messaging system to the console
 */
public class Logger {

    // Console color code
    private static final String ANSI_DEFAULT = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";

    @SuppressWarnings("unused")
    public enum Type {
        DEFAULT(ANSI_BLUE),
        WARNING(ANSI_YELLOW),
        ERROR(ANSI_RED),
        NOTICE(ANSI_BLACK),
        CONSOLE(ANSI_PURPLE),
        CONFIRMATION(ANSI_GREEN),
        QUESTION(ANSI_CYAN),
        BOARD(ANSI_PURPLE),
        DEBUG(ANSI_GREEN);

        private String color;

        Type(String color) {
            this.color = color;
        }

        public String toString() {
            return String.format("%s[ %s ]%s", color, super.toString(), ANSI_DEFAULT);
        }
    }

    /**
     * Prints a message to the console appended with a newline
     *
     * @param o message being transmitted
     */
    @SuppressWarnings("unused")
    public static void println(Logger.Type type, Object o) {
        print(type, o + "\n");
    }

    /**
     * Prints a message, that is formatted, to the console
     *
     * @param o message being transmitted
     */
    @SuppressWarnings("unused")
    public static void printf(Logger.Type type, String lang, Object... o) {
        print(type, String.format(lang, o));
    }

    /**
     * Prints a message to the console
     *
     * @param o message being transmitted
     */
    public static void print(Logger.Type type, Object o) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(type);
        stringBuilder.append(" ");
        stringBuilder.append(o);

        System.out.print(stringBuilder);
    }
}