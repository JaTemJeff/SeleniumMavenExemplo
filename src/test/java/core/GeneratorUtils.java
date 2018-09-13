package core;

import java.util.Random;

public class GeneratorUtils {

    public String numericoAleatorio(int tamanho) {
        String letras = "0123456789";

        Random random = new Random();

        String armazenaChaves = "";
        int index = -1;
        for (int i = 0; i < tamanho; i++) {
            index = random.nextInt(letras.length());
            armazenaChaves += letras.substring(index, index + 1);
        }
        return armazenaChaves;
    }

    public String stringAleatoria(int tamanho) {
        String letras = "abcdefghijklmnopqrstuvwxyz";

        Random random = new Random();

        String armazenaChaves = "";
        int index = -1;
        for (int i = 0; i < tamanho; i++) {
            index = random.nextInt(letras.length());
            armazenaChaves += letras.substring(index, index + 1);
        }
        return armazenaChaves;
    }
}
