package org.alex_hashtag.parser;

import org.alex_hashtag.tokens.TokenType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class Grammar
{
    HashMap<TokenType, ArrayList<TokenType>> validPaths = new HashMap<>(75);

    public Grammar()
    {
        this.validPaths.put(TokenType.SEMI_COLON, listFromTokens(TokenType.CURLY_BRACE_OPEN, TokenType.VOID, TokenType.UNSIGNED, TokenType.INT8, TokenType.INT16, TokenType.INT32, TokenType.INT64,
                TokenType.UINT8, TokenType.UINT16, TokenType.UINT32, TokenType.UINT16, TokenType.FLOAT32, TokenType.FLOAT64, TokenType.BOOLEAN, TokenType.CHARACTER, TokenType.RUNE, TokenType.STRING,
                TokenType.TUPLE, TokenType.PACKET, TokenType.POINTER, TokenType.SLICE, TokenType.LAMBDA, TokenType.IF, TokenType.LOOP, TokenType.DO, TokenType.WHILE, TokenType.FOR, TokenType.SWITCH,
                TokenType.EXIT, TokenType.RETURN, TokenType.FINAL, TokenType.CONST, TokenType.SYSCALL, TokenType.MANAGED, TokenType.TEMPORARY));

        this.validPaths.put(TokenType.BRACE_OPEN, listFromTokens(TokenType.BRACE_OPEN, TokenType.BRACE_CLOSED, TokenType.CURLY_BRACE_OPEN, TokenType.INTEGER_LITERAL, TokenType.FLOATING_POINT_LITERAL,
                TokenType.TRUE, TokenType.FALSE, TokenType.CHARACTER_LITERAL, TokenType.VAR, TokenType.UNSIGNED, TokenType.INT8, TokenType.INT16, TokenType.INT32, TokenType.INT64, TokenType.UINT8,
                TokenType.UINT16, TokenType.UINT32, TokenType.UINT64, TokenType.FLOAT32, TokenType.FLOAT64, TokenType.CHARACTER, TokenType.RUNE, TokenType.STRING, TokenType.TUPLE, TokenType.PACKET,
                TokenType.POINTER, TokenType.SLICE, TokenType.LAMBDA, TokenType.TYPEOF, TokenType.SIZEOF, TokenType.SWITCH, TokenType.FINAL, TokenType.IDENTIFIER, TokenType.TYPE_IDENTIFIER));
        this.validPaths.put(TokenType.BRACE_CLOSED, listFromTokens(TokenType.SEMI_COLON, TokenType.BRACE_CLOSED, TokenType.CURLY_BRACE_OPEN, TokenType.CURLY_BRACE_CLOSED, TokenType.DIAMOND_CLOSED, TokenType.PLUS, TokenType.MINUS,
                TokenType.DIVISION, TokenType.MODULUS, TokenType.COMMA, TokenType.DOT, TokenType.AND, TokenType.OR, TokenType.XOR, TokenType.LEFT_SHIT, TokenType.RIGHT_SHIFT, TokenType.UNSIGNED_RIGHT_SHIFT,
                TokenType.LOGICAL_OR, TokenType.LOGICAL_AND, TokenType.LOGICAL_EQUALS, TokenType.ARROW, TokenType.IF, TokenType.ELSE, TokenType.LOOP, TokenType.DO, TokenType.WHILE, TokenType.FOR,
                TokenType.SWITCH, TokenType.EXIT, TokenType.RETURN, TokenType.SYSCALL, TokenType.IDENTIFIER, TokenType.TYPE_IDENTIFIER, TokenType.VARIABLE_IDENTIFIER));
        this.validPaths.put(TokenType.CURLY_BRACE_OPEN, listFromTokens(TokenType.VOID, TokenType.VAR, TokenType.UNSIGNED, TokenType.INT8, TokenType.INT16, TokenType.INT32, TokenType.INT64,
                TokenType.UINT8, TokenType.UINT16, TokenType.UINT32, TokenType.UINT64, TokenType.FLOAT32, TokenType.FLOAT64, TokenType.CHARACTER, TokenType.RUNE, TokenType.STRING, TokenType.TUPLE,
                TokenType.PACKET, TokenType.POINTER, TokenType.SLICE, TokenType.LAMBDA, TokenType.IF, TokenType.LOOP, TokenType.WHILE, TokenType.FOR, TokenType.SWITCH, TokenType.CASE, TokenType.EXIT,
                TokenType.RETURN, TokenType.CLASS, TokenType.STRUCT, TokenType.ENUM, TokenType.RECORD, TokenType.TRAIT, TokenType.PUBLIC, TokenType.PRIVATE,
                TokenType.PROTECTED, TokenType.STATIC, TokenType.IMPLEMENT, TokenType.MANAGED, TokenType.TEMPORARY, TokenType.ERROR, TokenType.IDENTIFIER,
                TokenType.TYPE_IDENTIFIER, TokenType.VARIABLE_IDENTIFIER, TokenType.FUNCTION_IDENTIFIER) );

        this.validPaths.put(TokenType.VAR, listFromTokens(TokenType.VARIABLE_IDENTIFIER, TokenType.DIAMOND_CLOSED, TokenType.SQUARE_BRACE_OPEN) );
        this.validPaths.put(TokenType.VOID, listFromTokens(TokenType.VARIABLE_IDENTIFIER, TokenType.FUNCTION_IDENTIFIER, TokenType.DIAMOND_CLOSED, TokenType.SQUARE_BRACE_OPEN, TokenType.COMMA) );
        this.validPaths.put(TokenType.INT8, listFromTokens(TokenType.VARIABLE_IDENTIFIER, TokenType.FUNCTION_IDENTIFIER, TokenType.DIAMOND_CLOSED, TokenType.SQUARE_BRACE_OPEN, TokenType.COMMA) );
        this.validPaths.put(TokenType.INT16, listFromTokens(TokenType.VARIABLE_IDENTIFIER, TokenType.FUNCTION_IDENTIFIER, TokenType.DIAMOND_CLOSED, TokenType.SQUARE_BRACE_OPEN, TokenType.COMMA) );
        this.validPaths.put(TokenType.INT32, listFromTokens(TokenType.VARIABLE_IDENTIFIER, TokenType.FUNCTION_IDENTIFIER, TokenType.DIAMOND_CLOSED, TokenType.SQUARE_BRACE_OPEN, TokenType.COMMA) );
        this.validPaths.put(TokenType.INT64, listFromTokens(TokenType.VARIABLE_IDENTIFIER, TokenType.FUNCTION_IDENTIFIER, TokenType.DIAMOND_CLOSED, TokenType.SQUARE_BRACE_OPEN, TokenType.COMMA) );
        this.validPaths.put(TokenType.UINT8, listFromTokens(TokenType.VARIABLE_IDENTIFIER, TokenType.FUNCTION_IDENTIFIER, TokenType.DIAMOND_CLOSED, TokenType.SQUARE_BRACE_OPEN, TokenType.COMMA) );
        this.validPaths.put(TokenType.UINT16, listFromTokens(TokenType.VARIABLE_IDENTIFIER, TokenType.FUNCTION_IDENTIFIER, TokenType.DIAMOND_CLOSED, TokenType.SQUARE_BRACE_OPEN, TokenType.COMMA) );
        this.validPaths.put(TokenType.UINT32, listFromTokens(TokenType.VARIABLE_IDENTIFIER, TokenType.FUNCTION_IDENTIFIER, TokenType.DIAMOND_CLOSED, TokenType.SQUARE_BRACE_OPEN, TokenType.COMMA) );
        this.validPaths.put(TokenType.UINT64, listFromTokens(TokenType.VARIABLE_IDENTIFIER, TokenType.FUNCTION_IDENTIFIER, TokenType.DIAMOND_CLOSED, TokenType.SQUARE_BRACE_OPEN, TokenType.COMMA) );
        this.validPaths.put(TokenType.FLOAT32, listFromTokens(TokenType.VARIABLE_IDENTIFIER, TokenType.FUNCTION_IDENTIFIER, TokenType.DIAMOND_CLOSED, TokenType.SQUARE_BRACE_OPEN, TokenType.COMMA) );
        this.validPaths.put(TokenType.FLOAT64, listFromTokens(TokenType.VARIABLE_IDENTIFIER, TokenType.FUNCTION_IDENTIFIER, TokenType.DIAMOND_CLOSED, TokenType.SQUARE_BRACE_OPEN, TokenType.COMMA) );

        this.validPaths.put(TokenType.CHARACTER, listFromTokens(TokenType.VARIABLE_IDENTIFIER, TokenType.FUNCTION_IDENTIFIER, TokenType.DIAMOND_CLOSED, TokenType.SQUARE_BRACE_OPEN, TokenType.COMMA) );
        this.validPaths.put(TokenType.RUNE, listFromTokens(TokenType.VARIABLE_IDENTIFIER, TokenType.FUNCTION_IDENTIFIER, TokenType.DIAMOND_CLOSED, TokenType.SQUARE_BRACE_OPEN, TokenType.COMMA) );
        this.validPaths.put(TokenType.STRING, listFromTokens(TokenType.VARIABLE_IDENTIFIER, TokenType.FUNCTION_IDENTIFIER, TokenType.DIAMOND_CLOSED, TokenType.SQUARE_BRACE_OPEN, TokenType.COMMA) );

        this.validPaths.put(TokenType.TUPLE, listFromTokens(TokenType.VARIABLE_IDENTIFIER, TokenType.FUNCTION_IDENTIFIER, TokenType.DIAMOND_OPEN) );
        this.validPaths.put(TokenType.PACKET, listFromTokens(TokenType.VARIABLE_IDENTIFIER, TokenType.FUNCTION_IDENTIFIER, TokenType.DIAMOND_OPEN) );

        this.validPaths.put(TokenType.POINTER, listFromTokens(TokenType.DIAMOND_OPEN) );
        this.validPaths.put(TokenType.SLICE, listFromTokens(TokenType.DIAMOND_OPEN) );
        this.validPaths.put(TokenType.LAMBDA, listFromTokens(TokenType.DIAMOND_OPEN) );

        this.validPaths.put(TokenType.INTEGER_LITERAL, listFromTokens(TokenType.PLUS, TokenType.MINUS, TokenType.MULTIPLY, TokenType.DIVISION, TokenType.MODULUS, TokenType.COMMA, TokenType.SEMI_COLON) );
        this.validPaths.put(TokenType.FLOATING_POINT_LITERAL, listFromTokens(TokenType.PLUS, TokenType.MINUS, TokenType.MULTIPLY, TokenType.DIVISION, TokenType.MODULUS, TokenType.COMMA, TokenType.SEMI_COLON) );
        this.validPaths.put(TokenType.CHARACTER_LITERAL, listFromTokens(TokenType.PLUS, TokenType.MINUS, TokenType.MULTIPLY, TokenType.DIVISION, TokenType.MODULUS, TokenType.COMMA, TokenType.SEMI_COLON) );
        this.validPaths.put(TokenType.RUNE_LITERAL, listFromTokens(TokenType.PLUS, TokenType.MULTIPLY, TokenType.COMMA, TokenType.SEMI_COLON) );
        this.validPaths.put(TokenType.STRING_LITERAL, listFromTokens(TokenType.PLUS, TokenType.MULTIPLY, TokenType.COMMA, TokenType.SEMI_COLON) );

        this.validPaths.put(TokenType.PLUS, listFromTokens(TokenType.PLUS, TokenType.INTEGER_LITERAL, TokenType.FLOATING_POINT_LITERAL, TokenType.CHARACTER_LITERAL, TokenType.RUNE_LITERAL, TokenType.STRING_LITERAL, TokenType.EQUALS) );
        this.validPaths.put(TokenType.MINUS, listFromTokens(TokenType.MINUS, TokenType.INTEGER_LITERAL, TokenType.FLOATING_POINT_LITERAL, TokenType.CHARACTER_LITERAL, TokenType.RUNE_LITERAL, TokenType.EQUALS) );
        this.validPaths.put(TokenType.MULTIPLY, listFromTokens(TokenType.INTEGER_LITERAL, TokenType.FLOATING_POINT_LITERAL, TokenType.CHARACTER_LITERAL, TokenType.RUNE_LITERAL, TokenType.STRING_LITERAL, TokenType.EQUALS) );
        this.validPaths.put(TokenType.DIVISION, listFromTokens(TokenType.INTEGER_LITERAL, TokenType.FLOATING_POINT_LITERAL, TokenType.CHARACTER_LITERAL, TokenType.RUNE_LITERAL, TokenType.EQUALS) );
        this.validPaths.put(TokenType.MODULUS, listFromTokens(TokenType.INTEGER_LITERAL, TokenType.FLOATING_POINT_LITERAL, TokenType.CHARACTER_LITERAL, TokenType.RUNE_LITERAL, TokenType.EQUALS) );

        this.validPaths.put(TokenType.EQUALS, listFromTokens(TokenType.INTEGER_LITERAL, TokenType.FLOATING_POINT_LITERAL, TokenType.CHARACTER_LITERAL, TokenType.RUNE_LITERAL,
                TokenType.BRACE_OPEN, TokenType.CURLY_BRACE_OPEN, TokenType.SQUARE_BRACE_OPEN, TokenType.SWITCH, TokenType.TYPE_CAST, TokenType.IDENTIFIER,
                TokenType.TYPE_IDENTIFIER, TokenType.VARIABLE_IDENTIFIER, TokenType.FUNCTION_IDENTIFIER) );


        this.validPaths.put(TokenType.IF, listFromTokens(TokenType.BRACE_OPEN) );
        this.validPaths.put(TokenType.ELSE, listFromTokens(TokenType.IF, TokenType.CURLY_BRACE_OPEN, TokenType.LOOP, TokenType.WHILE, TokenType.FOR, TokenType.SWITCH, TokenType.EXIT,
                TokenType.RETURN, TokenType.TYPE_IDENTIFIER, TokenType.VARIABLE_IDENTIFIER, TokenType.FUNCTION_IDENTIFIER, TokenType.TYPE_CAST) );
        this.validPaths.put(TokenType.SWITCH, listFromTokens(TokenType.BRACE_OPEN));
        this.validPaths.put(TokenType.LOOP, listFromTokens(TokenType.CURLY_BRACE_OPEN));
        this.validPaths.put(TokenType.DO, listFromTokens(TokenType.CURLY_BRACE_OPEN));
        this.validPaths.put(TokenType.WHILE, listFromTokens(TokenType.BRACE_OPEN));
        this.validPaths.put(TokenType.FOR, listFromTokens(TokenType.BRACE_OPEN));
    }

    private ArrayList<TokenType> listFromTokens(TokenType... tokens)
    {
        return (ArrayList<TokenType>) Arrays.stream(tokens).toList();
    }
}
