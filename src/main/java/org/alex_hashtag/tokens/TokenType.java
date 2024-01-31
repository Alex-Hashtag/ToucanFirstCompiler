package org.alex_hashtag.tokens;

import java.util.HashSet;


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
    COMMA("\\,"),
    DOT("\\."),
    ARROW("->"),

    VOID("void"),
    VAR("var"),
    UNSIGNED("unsigned"),
    INT8("int8|byte"),
    INT16("int16|short"),
    INT32("int32|int"),
    INT64("int64|long"),
    UINT8("uint8"),
    UINT16("uint16"),
    UINT32("uint32"),
    UINT64("uint64"),
    FLOAT32("float32|float"),
    FLOAT64("float64|double"),
    CHARACTER("char"),
    STRING("string"),
    ARRAY("array"),
    TUPLE("tuple"),
    PACKET("packet"),
    POINTER("pointer"),
    SLICE("slice"),
    LAMBDA("lambda"),


    IF("if"),
    ELSE("else"),

    LOOP("loop"),
    WHILE("while"),
    FOR("for"),

    SWITCH("switch"),
    CASE("case"),


    EXIT("exit"),
    RETURN("return"),


    CLASS("class"),
    STRUCT("struct"),
    ENUM("enum"),
    RECORD("record"),
    TRAIT("trait"),

    COMPACTED("compacted"),
    PUBLIC("public"),
    PRIVATE("private"),
    PROTECTED("protected"),
    STATIC("static"),

    IMPLEMENT("implement"),
    IMPLEMENTS("implements"),
    EXTENDS("extends"),


    MANAGED("managed"),
    TEMPORARY("temporary"),

    ERROR("error"),

    INTEGER_LITERAL("^([+-]?[1-9]\\d*|0)$"),
    FLOATING_POINT_LITERAL("^([+-]?([1-9]\\d*|0)(\\.\\d+)?|\\.\\d+)$"),
    CHARACTER_LITERAL("^'.'$"),
    STRING_LITERAL("^\"[\\s\\S]*\"$"),

    IDENTIFIER("^[a-zA-Z_][a-zA-Z0-9_]*$"),
    TYPE_IDENTIFIER("^[a-zA-Z_][a-zA-Z0-9_]*$"),
    VARIABLE_IDENTIFIER("^[a-zA-Z_][a-zA-Z0-9_]*$"),
    FUNCTION_IDENTIFIER("^[a-zA-Z_][a-zA-Z0-9_]*$"),

    INVALID_STATE("-----------");

    static HashSet<TokenType> types = null;


    private final String pattern;

    TokenType(String pattern)
    {
        this.pattern = pattern;
    }

    static public void populateHashSet()
    {
        types = new HashSet<>();
        types.add(TokenType.VOID);
        types.add(TokenType.VAR);
        types.add(TokenType.INT8);
        types.add(TokenType.INT16);
        types.add(TokenType.INT32);
        types.add(TokenType.INT64);
        types.add(TokenType.UINT8);
        types.add(TokenType.UINT16);
        types.add(TokenType.UINT32);
        types.add(TokenType.UINT64);
        types.add(TokenType.FLOAT32);
        types.add(TokenType.FLOAT64);
        types.add(TokenType.CHARACTER);
        types.add(TokenType.STRING);
        types.add(TokenType.ARRAY);
        types.add(TokenType.TUPLE);
        types.add(TokenType.PACKET);
        types.add(TokenType.POINTER);
        types.add(TokenType.SLICE);
        types.add(TokenType.LAMBDA);
        types.add(TokenType.TYPE_IDENTIFIER);
    }

    public String getPattern()
    {
        return pattern;
    }


}
