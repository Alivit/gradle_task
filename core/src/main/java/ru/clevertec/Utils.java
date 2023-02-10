package ru.clevertec;


import java.util.stream.Stream;

public class Utils {
    static boolean isAllPositiveNumbers(String... str){
        if ( Stream.of(str).count() != 0 )
            return Stream.of(str).allMatch(StringUtils::isPositiveNumber);
        else return false;

    }
}
