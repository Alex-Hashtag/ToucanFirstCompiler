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

    VOID("void"),

    EXIT("exit"),

    INTEGER_LITERAL("^([+-]?[1-9]\\d*|0)$"),
    FLOATING_POINT_LITERAL("^([+-]?([1-9]\\d*|0)(\\.\\d+)?|\\.\\d+)$"),

    INVALID_STATE("-----------");


    private final String pattern;

    TokenType(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }


}
