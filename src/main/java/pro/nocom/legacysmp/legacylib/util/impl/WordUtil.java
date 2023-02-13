package pro.nocom.legacysmp.legacylib.util.impl;

import pro.nocom.legacysmp.legacylib.util.Utility;

public final class WordUtil extends Utility {
    private static final char[] vowels = "aeiou".toCharArray();

    public static boolean startsWithVowel(final String word) {
        final char firstChar = word.charAt(0);

        for (int i = 0; i < vowels.length; i++) {
            final char character = vowels[i];

            if (firstChar == character) {
                return true;
            }
        }

        return false;
    }

    public static String getLowercaseIndefiniteArticle(final String word) {
        final boolean startsWithVowel = startsWithVowel(word);

        return startsWithVowel ? "an" : "a";
    }

    public static String getUprightIndefiniteArticle(final String word) {
        final boolean startsWithVowel = startsWithVowel(word);

        return startsWithVowel ? "An": "A";
    }
}
