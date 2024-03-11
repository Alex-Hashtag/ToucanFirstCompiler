package org.alex_hashtag.tokens;

import java.util.HashSet;


public enum TokenType
{
    //MAIN("main"),
    SEMI_COLON(";"),

    BRACE_OPEN("\\("),
    BRACE_CLOSED("\\)"),
    CURLY_BRACE_OPEN("\\{"),
    CURLY_BRACE_CLOSED("\\}"),
    SQUARE_BRACE_OPEN("\\["),
    SQUARE_BRACE_CLOSED("\\]"),
    DIAMOND_OPEN("\\<"),
    DIAMOND_CLOSED("\\>"),

    INTEGER_LITERAL("^([+-]?[1-9]\\d*|0)$"),
    FLOATING_POINT_LITERAL("^([+-]?([1-9]\\d*|0)(\\.\\d+)?|\\.\\d+)$"),
    TRUE("true"),
    FALSE("false"),
    CHARACTER_LITERAL("^'[\\x20-\\x7E]'$"),
    RUNE_LITERAL("^'.'|'\\\\u[0-9a-fA-F]{4}'|'\\\\.'$"),
    STRING_LITERAL("^\"[\\s\\S]*\"$"),

    EQUALS("="),
    PLUS("\\+"),
    MINUS("\\-"),
    MULTIPLY("\\*"),
    DIVISION("\\/"),
    MODULUS("\\%"),
    COMMA("\\,"),
    DOT("\\."),
    AND("\\&"),
    OR("\\|"),
    XOR("\\^"),
    LEFT_SHIT("<<"),
    RIGHT_SHIFT(">>"),
    UNSIGNED_RIGHT_SHIFT(">>>"),
    LOGICAL_AND("\\&\\&|and"),
    LOGICAL_OR("\\|\\||or"),
    LOGICAL_EQUALS("=="),
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
    BOOLEAN("boolean"),
    CHARACTER("char"),
    RUNE("rune"),
    STRING("string"),
    TUPLE("tuple"),
    PACKET("packet"),
    POINTER("pointer"),
    SLICE("slice"),
    LAMBDA("lambda"),

    TYPEOF("typeof"),
    SIZEOF("sizeof"),

    IF("if"),
    ELSE("else"),

    LOOP("loop"),
    DO("do"),
    WHILE("while"),
    FOR("for"),

    SWITCH("switch"),
    CASE("case"),


    EXIT("exit"),
    RETURN("return"),

    MACRO("macro"),

    CLASS("class"),
    STRUCT("struct"),
    ENUM("enum"),
    RECORD("record"),
    TRAIT("trait"),

    @Deprecated
    COMPACTED("compacted"),
    PUBLIC("public"),
    PRIVATE("private"),
    PROTECTED("protected"),
    STATIC("static"),
    FINAL("final"),
    CONST("const"),

    IMPLEMENT("implement"),
    IMPLEMENTS("implements"),
    EXTENDS("extends"),


    SYSCALL("syscall"),
    MANAGED("managed"),
    TEMPORARY("temporary"),

    ERROR("error"),

    IDENTIFIER("^[a-zA-Z_][a-zA-Z0-9_]*$"),
    TYPE_IDENTIFIER("^[a-zA-Z_][a-zA-Z0-9_]*$"),
    VARIABLE_IDENTIFIER("^[a-zA-Z_][a-zA-Z0-9_]*$"),
    FUNCTION_IDENTIFIER("^[a-zA-Z_][a-zA-Z0-9_]*$"),
    TYPE_CAST("^[a-zA-Z_][a-zA-Z0-9_]*$"),

    INVALID_STATE("-----------"),
    START("-----------"),
    END("-----------");

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
        types.add(TokenType.RUNE);
        types.add(TokenType.STRING);
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
