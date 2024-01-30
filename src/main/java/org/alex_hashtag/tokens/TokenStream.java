package org.alex_hashtag.tokens;

import java.util.HashSet;
import java.util.LinkedList;


public class TokenStream
{
    LinkedList<Token> tokens;
    static HashSet<Character> escapeCharacters = new HashSet<>();

    public TokenStream(String file)
    {
        this.tokens = new LinkedList<>();
        populateSet();

        char[] info = file.toCharArray();

        StringBuilder lastTokenString = new StringBuilder();
        for (char c : info)
        {
            if (escapeCharacters.contains(c))
            {
                if (lastTokenString.isEmpty())
                {
                    if (c!=' ' && c!='\n') lastTokenString.append(c);
                    continue;
                }

                this.tokens.addLast(Token.tokenFromPattern(lastTokenString.toString()));
                if (c!=' ' && c!='\n')
                    this.tokens.addLast(Token.tokenFromPattern(String.valueOf(c)));
                lastTokenString.setLength(0);
                continue;
            }
            lastTokenString.append(c);
        }
    }

    private static void populateSet()
    {
        TokenStream.escapeCharacters.add(' ');
        TokenStream.escapeCharacters.add('\n');
        TokenStream.escapeCharacters.add('{');
        TokenStream.escapeCharacters.add('}');
        TokenStream.escapeCharacters.add('(');
        TokenStream.escapeCharacters.add(')');
        TokenStream.escapeCharacters.add('[');
        TokenStream.escapeCharacters.add(']');
        TokenStream.escapeCharacters.add('<');
        TokenStream.escapeCharacters.add('>');
        TokenStream.escapeCharacters.add(';');
        TokenStream.escapeCharacters.add('=');
        TokenStream.escapeCharacters.add('+');
        TokenStream.escapeCharacters.add('-');
        TokenStream.escapeCharacters.add('*');
        TokenStream.escapeCharacters.add('/');
        TokenStream.escapeCharacters.add('%');
    }

    public void printTokens()
    {
        for (Token token : this.tokens)
        {
            System.out.print("Type: " + token.getType());
            if (!token.getInformation().isEmpty())
                System.out.print(" Contains: " + token.getInformation().get());
            System.out.println();
        }
    }
}
