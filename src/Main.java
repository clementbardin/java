/*
Types entiers :
byte : -128 à 127 | 8 bits
short : -32 768 à 32 767 | 16 bits
int : -2 147 483 648 à -2 147 483 647 | 32 bits
long : -128 à 127 | 64 bits

Types décimaux :
float | 32 bits
double | 64 bits

Définir une constante :
final double pi = 3,14
 */

//Exercice 2:
//Import de la méthode Random de la classe util
import java.util.Random;

//On initialise la classe Main
public class Main {
    //On initialise la fonction main
    public static void main(String[] args) {
        Random random = new Random();
        int count = 0;

        while (true) {
            int num1 = random.nextInt(1001);  // Génère le premier nombre aléatoire
            int num2 = random.nextInt(1001);  // Génère le deuxième nombre aléatoire
            int num3 = random.nextInt(1001);  // Génère le troisième nombre aléatoire

            count++;  // Incrémente le compteur d'essais

            // Vérifie si les nombres sont dans la combinaison "pair, pair, impair"
            if (num1 % 2 == 0 && num2 % 2 == 0 && num3 % 2 != 0) {
                System.out.println("Combinaison trouvée après " + count + " essais.");
                System.out.println("Nombres générés : " + num1 + ", " + num2 + ", " + num3);
                break;  // Sort de la boucle while une fois que la combinaison est trouvée
            }
        }
    }
}
