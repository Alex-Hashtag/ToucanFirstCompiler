package org.alex_hashtag;


import org.alex_hashtag.tokens.Token;
import org.alex_hashtag.tokens.TokenStream;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Pattern;

import static java.lang.System.*;


public class Main
{
    public static void main(String[] args) throws FileNotFoundException
    {
        //Scanner scanner = new Scanner(in);


        Optional<String> filename = Optional.empty();

        /*
        while (filename.isEmpty())
        {
            filename = registerFile(scanner);
        }
         */
        filename = "main.toucan".describeConstable();

        File file = new File(filename.get());
        Scanner fileReader = new Scanner(file);
        StringBuilder stringBuilder = new StringBuilder();
        while (fileReader.hasNextLine())
        {
            stringBuilder.append(fileReader.nextLine());
            stringBuilder.append('\n');
        }

        String program = stringBuilder.toString();

        TokenStream tokens = new TokenStream(program);

        tokens.printTokens();


    }

    private static @NotNull Optional<String> registerFile(Scanner scanner)
    {
        out.println("Please, say the name of a valid file you wish to compile: ");


        String input = scanner.nextLine();

        if (Pattern.matches(".*\\.toucan$", input))
            return input.describeConstable();
        else
            err.println("Invalid filename. The file must end with '.toucan'. Try again.");


        return Optional.empty();
    }
}

