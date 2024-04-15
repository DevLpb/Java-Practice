import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("---Desafío 1---");
        String password = "ContraseñaCualquiera(?";
        String passIngresada;
        int intentos = 3;
        Scanner input = new Scanner(System.in);

        while (intentos > 0) {
            System.out.printf("Ingresa la contraseña. %d intentos restantes.", intentos);
            passIngresada = input.next();

            if (!passIngresada.equals(password)) {
                System.out.println("Contraseña incorrecta.");
                intentos -= 1;
                if (intentos == 0) {
                    System.out.println("No quedan más intentos.");
                }
            } else {
                System.out.println("Enhorabuena. Contraseña correcta.");
                break;
            }
        }

    }
}
