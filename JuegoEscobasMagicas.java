
import java.util.Scanner;
import java.util.Random;

public class EscobasMagicas {
	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		Random rn = new Random();
		int distancia1 = 0, distancia2 = 0, quien, con = 0, avanze1, avanze2, avanze1b = 0, avanze2b = 0;

		System.out.println("Elige quien empieza primer turno (Mago 1/Brujo 2)");
		quien = sn.nextInt();

		String quien1 = (quien == 1) ? "Mago" : "Brujo";
		String quien2 = (quien == 2) ? "Mago" : "Brujo";
		System.out.println("Empieza el " + quien1);

		do {
			con++;
			System.out.println("Ronda " + con);
			avanze1 = rn.nextInt(3) + 1;
			avanze2 = rn.nextInt(3) + 1;

			// Jugador1 if : Retrocede else : avanza
			if (avanze1 == avanze1b && avanze1b > 0) {
				System.out.println(quien1 + " repitió la tirada, retrocede " + avanze1 + " puntos.");
				distancia1 -= avanze1;
			} else {
				distancia1 += avanze1;
			}

			avanze1b = avanze1;

			if (distancia1 % 5 == 0 && distancia1 > 1) {
				System.out.println(quien1 + " Numero multiple de 5 bonificador 2 mas");
				distancia1 = distancia1 + 2;
			}
			if (distancia1 % 10 == 8 && distancia1 > 1) {
				System.out.println("Numero con final 8 el " + quien1 + " esta en nube magica retrocede 1 menos");
				distancia1 = distancia1 - 1;
			}
			if (distancia1 == distancia2 && distancia2 > 1) {
				System.out.println(quien1 + " estais en mismo sitio el otro retrocede 2");
				distancia1 = distancia1 - 2;
			}

			// Jugador 2 if : Retrocede else : avanza
			if (avanze2 == avanze2b && avanze2b > 0) {
				System.out.println(quien2 + " repitió la tirada, retrocede " + avanze2 + " puntos.");
				distancia2 -= avanze2;
			} else {
				distancia2 += avanze2;
			}

			avanze2b = avanze2;

			if (distancia2 % 5 == 0 && distancia2 > 1) {
				System.out.println(quien2 + " Numero multiple de 5 bonificador 2 mas");
				distancia2 = distancia2 + 2;
			}
			if (distancia2 % 10 == 8 && distancia2 > 1) {
				System.out.println("Numero con final 8 el " + quien2 + " esta en nube magica retrocede 1 menos");
				distancia2 = distancia2 - 1;
			}
			if (distancia2 == distancia1 && distancia1 > 1) {
				System.out.println(quien2 + " estais en mismo sitio el otro retrocede 2");
				distancia2 = distancia2 - 2;

			}

			System.out.println(quien1 + " alcanza corriente magica y avanza " + avanze1 + " punto.");
			System.out.println(quien2 + " alcanza corriente magica y avanza " + avanze2 + " punto.");
			System.out.println(quien1 + " esta en: " + distancia1);
			System.out.println(quien2 + " esta en: " + distancia2);

		} while (distancia1 < 50 && distancia2 < 50);

		if (distancia1 >= 50) {
			System.out.println(quien1 + " ha ganado!");
		} else {
			System.out.println(quien2 + " ha ganado!");
		}
	}
}
