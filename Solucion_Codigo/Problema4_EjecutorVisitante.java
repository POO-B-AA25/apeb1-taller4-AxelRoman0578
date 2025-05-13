import java.util.Scanner;
public class Problema4_EjecutorVisitante {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de visitantes: ");
        int n = sc.nextInt();
        sc.nextLine();
        int i = 1;
        int aceptados = 0;
        boolean aprovadoDesaprovado;
        do {
            System.out.println("---- Datos del Visitante " + i + " ----");
            System.out.println("Ingrese su edad: ");
            int edad = sc.nextInt();
            System.out.println("Ingrese su estatura: ");
            double estatura = sc.nextDouble();
            
            Visitante vis = new Visitante(edad, estatura);
            if (vis.edad >= 16 && vis.altura >= 1.65){
                aprovadoDesaprovado = true;
                aceptados ++;
            } else {
                aprovadoDesaprovado = false;
            }
            System.out.println("\n--- Resumen " + i + "---");
            System.out.println("Edad: " + vis.edad);
            System.out.println("Estatura: " + vis.altura);
            if (aprovadoDesaprovado == true){
                System.out.println("Cumple los requisitos para subir al juego");
            } else {
                System.out.println("No cumple con los requisitos");
            }
            System.out.println(" ");
        i++;
        } while (i <=n);
        System.out.println("------------------------------");
        System.out.println("Visitantes aceptados: " + aceptados);
    }
}
class Visitante{
    int edad;
    double altura;

    public Visitante() {
    }

    public Visitante(int edad, double altura) {
        this.edad = edad;
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Visitante{" + "edad=" + edad + ", altura=" + altura + '}';
    }
}