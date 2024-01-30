package org.alex_hashtag.tokens;

import java.util.HashSet;
import java.util.Optional;
import java.util.regex.Pattern;


public class Token
{
    static HashSet<TokenType> tokensWithValues = new HashSet<>();

    TokenType type;
    Optional<String> information = Optional.empty();

    private Token(TokenType type, String information)
    {
        this.type = type;
        this.information = information.describeConstable();
    }

    private Token(TokenType type)
    {
        this.type = type;
    }

    public static Token tokenFromPattern(String pattern)
    {
        populateSet();
        for (TokenType type : TokenType.values())
        {

            if (Pattern.matches(type.getPattern(), pattern))
                if (tokensWithValues.contains(type)) return new Token(type, pattern);
                else return new Token(type);

        }
        return new Token(TokenType.INVALID_STATE, pattern);
    }

    private static void populateSet()
    {
        Token.tokensWithValues.add(TokenType.INTEGER_LITERAL);
        Token.tokensWithValues.add(TokenType.FLOATING_POINT_LITERAL);
        Token.tokensWithValues.add(TokenType.CHARACTER_LITERAL);
        Token.tokensWithValues.add(TokenType.STRING_LITERAL);

        Token.tokensWithValues.add(TokenType.IDENTIFIER);
    }

    public TokenType getType()
    {
        return type;
    }

    public Optional<String> getInformation()
    {
        return information;
    }
}
