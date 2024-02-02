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
        this.validPaths.put(TokenType.VAR, listFromTokens(TokenType.TYPE_IDENTIFIER, TokenType.DIAMOND_OPEN) );
        this.validPaths.put(TokenType.INT8, listFromTokens(TokenType.TYPE_IDENTIFIER, TokenType.FUNCTION_IDENTIFIER, TokenType.DIAMOND_CLOSED) );
        this.validPaths.put(TokenType.INT16, listFromTokens(TokenType.TYPE_IDENTIFIER, TokenType.FUNCTION_IDENTIFIER, TokenType.DIAMOND_CLOSED) );
        this.validPaths.put(TokenType.INT32, listFromTokens(TokenType.TYPE_IDENTIFIER, TokenType.FUNCTION_IDENTIFIER, TokenType.DIAMOND_CLOSED) );
        this.validPaths.put(TokenType.INT64, listFromTokens(TokenType.TYPE_IDENTIFIER, TokenType.FUNCTION_IDENTIFIER, TokenType.DIAMOND_CLOSED) );
        this.validPaths.put(TokenType.UINT8, listFromTokens(TokenType.TYPE_IDENTIFIER, TokenType.FUNCTION_IDENTIFIER, TokenType.DIAMOND_CLOSED) );
        this.validPaths.put(TokenType.UINT16, listFromTokens(TokenType.TYPE_IDENTIFIER, TokenType.FUNCTION_IDENTIFIER, TokenType.DIAMOND_CLOSED) );
        this.validPaths.put(TokenType.UINT32, listFromTokens(TokenType.TYPE_IDENTIFIER, TokenType.FUNCTION_IDENTIFIER, TokenType.DIAMOND_CLOSED) );
        this.validPaths.put(TokenType.UINT64, listFromTokens(TokenType.TYPE_IDENTIFIER, TokenType.FUNCTION_IDENTIFIER, TokenType.DIAMOND_CLOSED) );
    }

    private ArrayList<TokenType> listFromTokens(TokenType... tokens)
    {
        return (ArrayList<TokenType>) Arrays.stream(tokens).toList();
    }
}
