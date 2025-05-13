import java.util.Scanner;
public class Problema5_EjecutorCliente {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int clientesCompletaron = 0;
        double totalDuracion = 0;

        System.out.print("Ingrese la cantidad de clientes a registrar: ");
        int n = sc.nextInt();
        sc.nextLine();

        int i = 1;
        do {
            System.out.println("\n--- Registro del cliente " + i + " ---");
            System.out.print("Nombre del cliente: ");
            String nombre = sc.nextLine();

            String tipoEjercicio = "";
            boolean tipoValido = false;
            while (!tipoValido) {
                System.out.println("Seleccione el tipo de ejercicio:");
                System.out.println("1. Cardio");
                System.out.println("2. Fuerza");
                System.out.println("3. Estiramiento");
                System.out.print("Opcion (1-3): ");
                int opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        tipoEjercicio = "Cardio";
                        tipoValido = true;
                        break;
                    case 2:
                        tipoEjercicio = "Fuerza";
                        tipoValido = true;
                        break;
                    case 3:
                        tipoEjercicio = "Estiramiento";
                        tipoValido = true;
                        break;
                    default:
                        System.out.println("Opcion invalida. Intente de nuevo.");
                }
            }

            System.out.print("Duracion del ejercicio (en minutos): ");
            double duracion = sc.nextDouble();
            sc.nextLine();

            System.out.print("Completo la rutina diaria? (true/false): ");
            boolean completo = sc.nextBoolean();
            sc.nextLine();

            Cliente cliente = new Cliente(nombre, tipoEjercicio, duracion, completo);
            totalDuracion += duracion;

            if (completo) {
                clientesCompletaron++;
                System.out.println(cliente.nombre + " completo su rutina.");
            } else {
                System.out.println(cliente.nombre + " no completo su rutina.");
            }

            System.out.println("Informacion del cliente:\n" + cliente.toString());
            i++;
        } while (i <= n);

        double promedioDuracion = (n > 0) ? totalDuracion / n : 0;

        System.out.println("\n--- Resumen del dia ---");
        System.out.println("Clientes que completaron su rutina: " + clientesCompletaron);
        System.out.printf("Promedio de tiempo invertido: %.2f minutos\n", promedioDuracion);
    }
}

class Cliente {
    public String nombre;
    public String tipoEjercicio;
    public double duracion;
    public boolean completo;

    public Cliente(String nombre, String tipoEjercicio, double duracion, boolean completo) {
        this.nombre = nombre;
        this.tipoEjercicio = tipoEjercicio;
        this.duracion = duracion;
        this.completo = completo;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
               "\nTipo de ejercicio: " + tipoEjercicio +
               "\nDuracion: " + duracion + " minutos" +
               "\nCompleto rutina: " + (completo ? "Si" : "No");
    }
}