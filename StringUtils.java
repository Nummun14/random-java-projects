public class StringUtils {
    public static String toCamelCase(String input) {
        String[] parts = input.split("_");
        StringBuilder camelCase = new StringBuilder();

        for (int i = 0; i < parts.length; i++) {
            String part = parts[i].toLowerCase();
                camelCase.append(Character.toUpperCase(part.charAt(0))).append(part.substring(1));
        }

        return camelCase.toString();
    }
}