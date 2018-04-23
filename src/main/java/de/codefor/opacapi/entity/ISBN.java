package de.codefor.opacapi.entity;

import de.codefor.opacapi.exception.InvalidISBN;

import java.util.stream.Stream;

public class ISBN {

    private String isbn;

    public ISBN(String isbn) {
        this.isbn = isbn.replaceAll("[^0-9]", "");
    }

    public ISBNType type() {
        switch (isbn.length()) {
            case 10:
                return ISBNType.ISBN_10;
            case 13:
                return ISBNType.ISBN_13;
            default:
                return ISBNType.INVALID;
        }

    }

    public boolean isValid() {

        int[] numbers = Stream.of(isbn.split("")).mapToInt(Integer::parseInt).toArray();

        switch (isbn.length()) {
            case 10:
                return (numbers[0] + 2 * numbers[1] + 3 * numbers[2] + 4 * numbers[3] + 5 * numbers[4] +
                        6 * numbers[5] + 7 * numbers[6] + 8 * numbers[7] + 9 * numbers[8]) % 11 == numbers[9];
            case 13:
                return (numbers[0] + numbers[2] + numbers[4] + numbers[6] + numbers[8] + numbers[10] + numbers[12] +
                        3 * (numbers[1] + numbers[3] + numbers[5] + numbers[7] + numbers[9] + numbers[11])) % 10
                        == 0;
            default:
                return false;
        }
    }


    public void checkValidity() {
        if (!isValid())
            throw new InvalidISBN();
    }

    public enum ISBNType {
        ISBN_10, ISBN_13, INVALID
    }

}