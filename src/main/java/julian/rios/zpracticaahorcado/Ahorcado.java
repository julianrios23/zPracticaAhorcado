

package julian.rios.zpracticaahorcado;

import java.util.Scanner;


public class Ahorcado {
    private char[] palabra;
    private int encontradas;
    private int maxIntentos;
    private int intentosRestantes;
    
    // Constructor vacío
    public Ahorcado() {}
    
    // Constructor parametrizado
    public Ahorcado(String palabra, int maxIntentos) {
        this.palabra = palabra.toCharArray();
        this.encontradas = 0;
        this.maxIntentos = maxIntentos;
        this.intentosRestantes = maxIntentos;
    }
    
    public void crearJuego() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la palabra a buscar: ");
        String palabra = scanner.nextLine();
        this.palabra = palabra.toCharArray();
        this.encontradas = 0;
        System.out.print("Ingrese la cantidad máxima de intentos: ");
        this.maxIntentos = scanner.nextInt();
        this.intentosRestantes = maxIntentos;
    }
    
    public void longitud() {
        System.out.println("La longitud de la palabra es: " + palabra.length);
    }
    
    public boolean buscar(char letra) {
        boolean encontrada = false;
        for (int i = 0; i < palabra.length; i++) {
            if (palabra[i] == letra) {
                encontrada = true;
                encontradas++;
            }
        }
        if (encontrada) {
            System.out.println("La letra " + letra + " pertenece a la palabra.");
        } else {
            System.out.println("La letra " + letra + " no pertenece a la palabra.");
            intentosRestantes--;
        }
        return encontrada;
    }
    
    public boolean encontradas(char letra) {
        int faltantes = palabra.length - encontradas;
        System.out.println("Número de letras (encontradas, faltantes): (" + encontradas + "," + faltantes + ")");
        return palabraContains(letra);
    }
    
    public void intentos() {
        System.out.println("Número de oportunidades restantes: " + intentosRestantes);
    }
    
    private boolean palabraContains(char letra) {
        for (int i = 0; i < palabra.length; i++) {
            if (palabra[i] == letra) {
                return true;
            }
        }
        return false;
    }
    
    public void juego() {
        Scanner scanner = new Scanner(System.in);
        boolean gameOver = false;
        while (!gameOver) {
            System.out.print("Ingrese una letra: ");
            char letra = scanner.nextLine().charAt(0);
            buscar(letra);
            if (encontradas == palabra.length) {
                System.out.println("¡Felicidades! Has adivinado la palabra.");
                gameOver = true;
            } else if (intentosRestantes == 0) {
                System.out.println("Lo siento, te has quedado sin intentos. La palabra era " + new String(palabra));
                gameOver = true;
            } else {
                encontradas(letra);
                intentos();
            }
        }
    }

}
