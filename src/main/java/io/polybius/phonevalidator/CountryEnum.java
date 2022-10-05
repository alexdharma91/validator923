package io.polybius.phonevalidator;

import java.util.List;

public enum CountryEnum {
    LT(8, List.of("6")),
    LV(8, List.of("2")),
    EE(7, List.of("5")),
    BE(7, List.of("456", "47", "48", "49"));

    public final int length;
    public final List<String> validPrefixes;

    CountryEnum(int length, List<String> validPrefixes) {
        this.length = length;
        this.validPrefixes = validPrefixes;
    }
}
