package org.alex_hashtag.tokens;

import java.util.HashSet;
import java.util.Optional;
import java.util.regex.Pattern;


public class Token
{
    static HashSet<TokenType> tokensWithValues = new HashSet<>();

    TokenType type;
    Position position;
    Optional<String> information = Optional.empty();

    public Token(TokenType type, String information, int row, int column)
    {
        this.type = type;
        this.position = new Position(row, column);
        this.information = information.describeConstable();
    }

    public Token(TokenType type, int row, int column)
    {
        this.type = type;
        this.position = new Position(row, column);
    }

    public static Token tokenFromPattern(String pattern, int row, int column)
    {
        populateSet();
        for (TokenType type : TokenType.values())
        {

            if (Pattern.matches(type.getPattern(), pattern))
                if (tokensWithValues.contains(type)) return new Token(type, pattern, row, column);
                else return new Token(type, row, column);

        }
        return new Token(TokenType.INVALID_STATE, pattern, row, column);
    }

    private static void populateSet()
    {
        Token.tokensWithValues.add(TokenType.INTEGER_LITERAL);
        Token.tokensWithValues.add(TokenType.FLOATING_POINT_LITERAL);
        Token.tokensWithValues.add(TokenType.CHARACTER_LITERAL);
        Token.tokensWithValues.add(TokenType.STRING_LITERAL);

        Token.tokensWithValues.add(TokenType.IDENTIFIER);
    }
}
