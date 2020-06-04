# Mobile phone number validator

Given a phone number validator that as an input parameter accepts list of phone numbers. 

The validator returns valid numbers grouped by countries and invalid as a separate list.

## Restrictions

No regular expressions or third party libraries are allowed except test libraries for assertions if standard junit 4.x in not enough.

## Current behaviour

Phone number may contain plus sign in the beginning, spaces, curly braces (if there is opening brace there should
 be closing), dashes, eg:
* 37061234567
* +37061234567
* +(370)61234567
* +370 612 34 567
* +370-612-34-567

Currently supported counties:
* Lithuania (LT ISO country code) (370)
* Latvia (LV ISO country code) (371)
* Estonia (EE ISO country code) (372)

### Lithuania

Mobile phone number starts with 6 and total has 8 digits excluding phone calling code, e.g. `3706XXXXXXX`.

### Latvia

Mobile phone number starts with 2 and total has 8 digits excluding phone calling code, e.g. `3712XXXXXXX`.

### Estonia

Mobile phone number starts with 5 and total has 7 or 8 digits excluding phone calling code, e.g. `3725XXXXXX` or `3725XXXXXXX`.

## To be done

Add support for Belgium (phone calling code is `32`). Mobile phone numbers have 9 digits and start with `456`, `47`, `48` or `49`.

For example `32456123456` and `+32456123456` is considered to be valid number.

Also feel free to change/fix existing code if you find that something needs to be changed.