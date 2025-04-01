package com.gotze.blockBreakSounds.utils;

import org.bukkit.Sound;

public class TextUtils {

    public static String convertToSmallFont(String input) {
        StringBuilder newString = new StringBuilder();
        for (char c : input.toCharArray()) {
            switch (c) {
                // Numbers
                case '0': newString.append('₀'); break;
                case '1': newString.append('₁'); break;
                case '2': newString.append('₂'); break;
                case '3': newString.append('₃'); break;
                case '4': newString.append('₄'); break;
                case '5': newString.append('₅'); break;
                case '6': newString.append('₆'); break;
                case '7': newString.append('₇'); break;
                case '8': newString.append('₈'); break;
                case '9': newString.append('₉'); break;
                // Lower Case Alphabet
                case 'a': newString.append('ᴀ'); break;
                case 'b': newString.append('ʙ'); break;
                case 'c': newString.append('ᴄ'); break;
                case 'd': newString.append('ᴅ'); break;
                case 'e': newString.append('ᴇ'); break;
                case 'f': newString.append('ꜰ'); break;
                case 'g': newString.append('ɢ'); break;
                case 'h': newString.append('ʜ'); break;
                case 'i': newString.append('ɪ'); break;
                case 'j': newString.append('ᴊ'); break;
                case 'k': newString.append('ᴋ'); break;
                case 'l': newString.append('ʟ'); break;
                case 'm': newString.append('ᴍ'); break;
                case 'n': newString.append('ɴ'); break;
                case 'o': newString.append('ᴏ'); break;
                case 'p': newString.append('ᴘ'); break;
                case 'q': newString.append('ǫ'); break;
                case 'r': newString.append('ʀ'); break;
                case 's': newString.append('ѕ'); break;
                case 't': newString.append('ᴛ'); break;
                case 'u': newString.append('ᴜ'); break;
                case 'v': newString.append('ᴠ'); break;
                case 'w': newString.append('ᴡ'); break;
                case 'x': newString.append('x'); break;
                case 'y': newString.append('ʏ'); break;
                case 'z': newString.append('ᴢ'); break;
                // Upper Case Alphabet
                case 'A': newString.append('ᴀ'); break;
                case 'B': newString.append('ʙ'); break;
                case 'C': newString.append('ᴄ'); break;
                case 'D': newString.append('ᴅ'); break;
                case 'E': newString.append('ᴇ'); break;
                case 'F': newString.append('ꜰ'); break;
                case 'G': newString.append('ɢ'); break;
                case 'H': newString.append('ʜ'); break;
                case 'I': newString.append('ɪ'); break;
                case 'J': newString.append('ᴊ'); break;
                case 'K': newString.append('ᴋ'); break;
                case 'L': newString.append('ʟ'); break;
                case 'M': newString.append('ᴍ'); break;
                case 'N': newString.append('ɴ'); break;
                case 'O': newString.append('ᴏ'); break;
                case 'P': newString.append('ᴘ'); break;
                case 'Q': newString.append('Ǫ'); break;
                case 'R': newString.append('ʀ'); break;
                case 'S': newString.append('ѕ'); break;
                case 'T': newString.append('ᴛ'); break;
                case 'U': newString.append('ᴜ'); break;
                case 'V': newString.append('ᴠ'); break;
                case 'W': newString.append('ᴡ'); break;
                case 'X': newString.append('х'); break;
                case 'Y': newString.append('ʏ'); break;
                case 'Z': newString.append('ᴢ'); break;
                // Default
                default: newString.append(c); break;
            }
        }
        return newString.toString();
    }

    // Converts name of a Sound object into a formatted String
    // Input: ENTITY_PLAYER_LEVELUP (Sound) -> Output: "Entity Player Levelup" (String)

    public static String getFormattedSoundName(Sound sound) {
        // Step 1: Convert the Sound to a String
        String soundString = sound.toString();

        // Step 2: Replace underscores with spaces and convert to lowercase
        String withSpaces = soundString.replace("_", " ").toLowerCase();

        // Step 3: Capitalize each word and combine them into a single string
        StringBuilder capitalized = new StringBuilder();
        for (String word : withSpaces.split(" ")) {
            capitalized.append(Character.toUpperCase(word.charAt(0))) // First letter uppercase
                    .append(word.substring(1))              // Rest of the word
                    .append(" ");                                     // Add space between words
        }

        // Step 4: Trim trailing space and return the formatted result
        return capitalized.toString().trim();
    }
}