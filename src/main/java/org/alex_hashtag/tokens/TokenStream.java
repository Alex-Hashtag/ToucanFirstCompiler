package org.alex_hashtag.tokens;

import java.util.HashSet;
import java.util.LinkedList;


public class TokenStream
{
    static HashSet<Character> escapeCharacters = new HashSet<>();
    LinkedList<Token> tokens;

    public TokenStream(String file)
    {
        this.tokens = new LinkedList<>();
        populateSet();

        char[] info = file.toCharArray();

        StringBuilder lastTokenString = new StringBuilder();

        int row = 1;
        int column = 1;

        for (char c : info)
        {
            if (escapeCharacters.contains(c))
            {

                if (lastTokenString.isEmpty())
                {
                    if (c != ' ' && c != '\n' && c != '\t')
                    {
                        lastTokenString.append(c);
                        this.tokens.addLast(Token.tokenFromPattern(lastTokenString.toString(), row, column - lastTokenString.length()));
                        lastTokenString.setLength(0);
                    }
                    else if (c == '\t') column+=3;
                    else if (c == '\n')
                    {
                        row ++;
                        column = 0;
                    }
                    column++;
                    continue;
                }

                if (lastTokenString.charAt(0) == '\"' && lastTokenString.charAt(lastTokenString.length() - 1) != '\"')
                {
                    lastTokenString.append(c);
                    column++;

                    if (c == '\t') column+=3;
                    else if (c == '\n')
                    {
                        row ++;
                        column = 0;
                    }

                    continue;
                }

                this.tokens.addLast(Token.tokenFromPattern(lastTokenString.toString(), row, column - lastTokenString.length()));
                if (c != ' ' && c != '\n')
                    this.tokens.addLast(Token.tokenFromPattern(String.valueOf(c), row, column));
                if (c == '\t') column+=3;
                else if (c == '\n')
                {
                    row ++;
                    column = 0;
                }
                lastTokenString.setLength(0);
                column++;

                continue;
            }
            lastTokenString.append(c);
            column++;
        }

        this.tokens.addFirst(new Token(TokenType.START, 0, 0));
        this.tokens.addLast(new Token(TokenType.END, 0, 0));
        simplify();
    }

    private static void populateSet()
    {
        TokenStream.escapeCharacters.add(' ');
        TokenStream.escapeCharacters.add('\n');
        TokenStream.escapeCharacters.add('\t');
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
        TokenStream.escapeCharacters.add('.');
        TokenStream.escapeCharacters.add(',');
        TokenStream.escapeCharacters.add('&');
        TokenStream.escapeCharacters.add('|');
        TokenStream.escapeCharacters.add('^');
    }

    private void simplify()
    {
        int size = this.tokens.size() - 1;
        for (int i = 1; i < size; i++) //Type Cast
        {

            if (tokens.get(i).type.equals(TokenType.BRACE_OPEN) && TokenType.types.contains(tokens.get(i+1).type) && tokens.get(i+2).type.equals(TokenType.BRACE_CLOSED))
            {
                tokens.set(i, new Token(TokenType.TYPE_CAST, tokens.get(1).position.row(), tokens.get(1).position.column()));
                tokens.get(i).addType(tokens.get(i+1).type);
                tokens.remove(i+1);
                tokens.remove(i+1);
                size-=2;

                continue;
            }

            if (tokens.get(i).type.equals(TokenType.IDENTIFIER)) // Identifiers
            {
                if (tokens.get(i+1).type.equals(TokenType.BRACE_OPEN))
                {
                    tokens.set(i, new Token(TokenType.FUNCTION_IDENTIFIER, tokens.get(i).information.get(), tokens.get(i).position.row(), tokens.get(i).position.column()));
                    if (TokenType.types.contains(tokens.get(i - 1).type) && !tokens.get(i - 1).type.equals(TokenType.VAR))
                        tokens.get(i).addType(tokens.get(i - 1).type);
                }
                else if (TokenType.types.contains(tokens.get(i-1).type))
                {
                    tokens.set(i, new Token(TokenType.VARIABLE_IDENTIFIER, tokens.get(i).information.get(), tokens.get(i).position.row(), tokens.get(i).position.column()));
                    if (!tokens.get(i - 1).type.equals(TokenType.VAR))
                        tokens.get(i).addType(tokens.get(i - 1).type);
                }
                else if (tokens.get(i+1).type.equals(TokenType.IDENTIFIER))
                    tokens.set(i, new Token(TokenType.TYPE_IDENTIFIER, tokens.get(i).information.get(), tokens.get(i).position.row(), tokens.get(i).position.column()));

                continue;
            }

            if (tokens.get(i - 1).type.equals(TokenType.MINUS) && tokens.get(i).type.equals(TokenType.DIAMOND_CLOSED))
            {
                tokens.set(i - 1, new Token(TokenType.ARROW, tokens.get(i-1).position.row(), tokens.get(i-1).position.column()));
                tokens.remove(i);
                i--;
                continue;
            }

            if (tokens.get(i - 1).type.equals(TokenType.UNSIGNED))
            {
                switch (tokens.get(i).type)
                {
                    case INT8 -> tokens.set(i - 1, new Token(TokenType.UINT8, tokens.get(i).position.row(), tokens.get(i).position.column()));
                    case INT16 -> tokens.set(i - 1, new Token(TokenType.UINT16, tokens.get(i).position.row(), tokens.get(i).position.column()));
                    case INT32 -> tokens.set(i - 1, new Token(TokenType.UINT32, tokens.get(i).position.row(), tokens.get(i).position.column()));
                    case INT64 -> tokens.set(i - 1, new Token(TokenType.UINT64, tokens.get(i).position.row(), tokens.get(i).position.column()));
                    default ->
                    {
                        tokens.add(i, new Token(TokenType.INVALID_STATE, 0, 0));
                        size++;
                    }
                }
                tokens.remove(i);
                size--;
                i--;
            }
        }
    }

    public void printTokens()
    {
        for (Token token : this.tokens)
        {

            System.out.print("Type: " + token.type);
            if (!token.information.isEmpty())
                System.out.print(" Contains: " + token.information.get());
            if(!token.variableType.isEmpty())
                System.out.print(" Type: " + token.variableType.get());
            System.out.println();
            System.out.println("\t" + token.position);
        }
    }
}
