package org.alex_hashtag.tokens;

public enum TokenType
{
    MAIN("main"),
    SEMI_COLON(";"),

    BRACE_OPEN("\\("),
    BRACE_CLOSED("\\)"),
    CURLY_BRACE_OPEN("\\{"),
    CURLY_BRACE_CLOSED("\\}"),
    SQUARE_BRACE_OPEN("\\["),
    SQUARE_BRACE_CLOSED("\\]"),
    DIAMOND_OPEN("\\<"),
    DIAMOND_CLOSED("\\>"),

    EQUALS("="),
    PLUS("\\+"),
    MINUS("\\-"),
    MULTIPLY("\\*"),
    DIVISION("\\/"),
    MODULUS("\\%"),


    VOID("void"),
    UNSIGNED("unsigned"),
    INT8("int8|byte"),
    INT16("int16|short"),
    INT32("int32|int"),
    INT64("int64|long"),
    FLOAT32("float32|float"),
    FLOAT64("float64|double"),
    CHARACTER("char"),

    EXIT("exit"),
    RETURN("return"),

    INTEGER_LITERAL("^([+-]?[1-9]\\d*|0)$"),
    FLOATING_POINT_LITERAL("^([+-]?([1-9]\\d*|0)(\\.\\d+)?|\\.\\d+)$"),
    CHARACTER_LITERAL("^'.'$"),
    STRING_LITERAL("^\".*\"$"),

    IDENTIFIER("^[a-zA-Z_][a-zA-Z0-9_]*$"),

    INVALID_STATE("-----------");


    private final String pattern;

    TokenType(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }


}
