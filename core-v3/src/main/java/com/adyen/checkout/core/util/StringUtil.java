/*
 * Copyright (c) 2019 Adyen N.V.
 *
 * This file is open source and available under the MIT license. See the LICENSE file for more info.
 *
 * Created by caiof on 14/5/2019.
 */

package com.adyen.checkout.core.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.adyen.checkout.core.exeption.NoConstructorException;

public final class StringUtil {

    /**
     * Check if the string has any content, eg. is not null and not empty.
     *
     * @param string The string to be verified
     * @return If it has content or not.
     */
    public static boolean hasContent(@Nullable String string) {
        return string != null && !string.isEmpty();
    }

    /**
     * Removes empty spaces and any additional specified characters.
     *
     * @param value The string to be normalized.
     * @param additionalCharsToReplace Additional characters to be removed.
     * @return The original string normalized to remove specified characters.
     */
    @NonNull
    public static String normalize(@NonNull String value, @NonNull char... additionalCharsToReplace) {
        return value.replaceAll("[\\s" + new String(additionalCharsToReplace) + "]", "");
    }

    /**
     * Check if the string only contains number and the specified separator characters.
     *
     * @param value The string to be checked.
     * @param separators The optional accepted separators.
     * @return If the string is only numbers and separators.
     */
    public static boolean isDigitsAndSeparatorsOnly(@NonNull String value, @NonNull char... separators) {
        for (int position = 0; position < value.length(); position++) {
            final char c = value.charAt(position);

            if (!Character.isDigit(c)) {
                return false;
            }

            for (char separator : separators) {
                if (separator != c) {
                    return false;
                }
            }
        }

        return true;
    }

    private StringUtil() {
        throw new NoConstructorException();
    }
}
