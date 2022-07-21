package br.com.challange.domain.utils;

import java.util.Random;

public class UrlGenerator {
    public static String gerarId() {
        Random numRand = new Random();
        Integer idLength = UrlShortenerVariables.MAX_CHARACTERS_URL - numRand.nextInt(UrlShortenerVariables.MIN_CHARACTERS_URL);
        String id = "";
        Random randCharacter = new Random();

        for(int i = 0; i < idLength; i++){
            int characterValue = 0;
            while(!(Character.isDigit(characterValue) || Character.isAlphabetic(characterValue))){
                characterValue = randCharacter.nextInt(128);
            }
            id = id + (char)characterValue;
        }
        return id;
    }
}
