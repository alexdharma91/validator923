package io.polybius.phonevalidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.polybius.phonevalidator.Constants.EMPTY_STR;
import static io.polybius.phonevalidator.Constants.BELGIUM_CODE;
import static io.polybius.phonevalidator.Constants.LITHUANIA_CODE;
import static io.polybius.phonevalidator.Constants.LATVIA_CODE;
import static io.polybius.phonevalidator.Constants.ESTONIA_CODE;

public class MobilePhoneNumberValidator {

    public ValidationResultDto validate(List<String> phoneNumbers) {
        ValidationResultDto result = new ValidationResultDto();
        result.invalidPhones = new ArrayList<>();
        result.validPhonesByCountry = new HashMap<>();

        for (int i = 0; i < phoneNumbers.size(); i++) {

            String phoneNumber = phoneNumbers.get(i);

            String country = null;

            phoneNumber = phoneNumber
                    .replaceAll("\\)", EMPTY_STR)
                    .replaceAll("\\(", EMPTY_STR)
                    .replaceAll(" ", EMPTY_STR)
                    .replaceAll("-", EMPTY_STR)
                    .replaceAll("\\+", EMPTY_STR);

            CountryEnum countryEnum = null;

            if (phoneNumber.startsWith(LITHUANIA_CODE)) {
                countryEnum = CountryEnum.LT;
            } else if (phoneNumber.startsWith(LATVIA_CODE)) {
                countryEnum = CountryEnum.LV;
            } else if (phoneNumber.startsWith(ESTONIA_CODE)) {
                countryEnum = CountryEnum.EE;
            } else if (phoneNumber.startsWith(BELGIUM_CODE)) {
                countryEnum = CountryEnum.BE;
            }

            boolean isValid = countryEnum != null
                    && checkPrefixAndLength(phoneNumber.substring(3), countryEnum.validPrefixes, countryEnum.length);

            if (isValid) {
                if (!result.validPhonesByCountry.containsKey(country)) {
                    result.validPhonesByCountry.put(country, new ArrayList<>());
                }

                result.validPhonesByCountry.get(country).add(phoneNumbers.get(0));
            } else {
                result.invalidPhones.add(phoneNumbers.get(i));
            }
        }

        return result;
    }

    private boolean checkPrefixAndLength(String phoneBody, List<String> validPrefixes, int length) {
        if (phoneBody.length() != length) {
            return false;
        }

        return validPrefixes.stream()
                .findAny()
                .filter(phoneBody::startsWith)
                .stream().findAny()
                .isPresent();
    }

}
