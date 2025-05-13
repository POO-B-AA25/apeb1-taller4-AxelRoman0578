import java.util.Scanner;

public class Problema3_EjecutorEstudiante {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int aceptados = 0;
        int rechazados = 0;
        System.out.print("Ingrese la cantidad de estudiantes a registrar: ");
        int n = sc.nextInt();
        sc.nextLine();

        int i = 1;
        do {
            System.out.println("\n--- Registro del estudiante " + i + " ---");
            System.out.print("Nombre del estudiante: ");
            String nombre = sc.nextLine();

            System.out.print("Grado del estudiante: ");
            String grado = sc.nextLine();

            System.out.print("Tiene permiso vigente? (true/false): ");
            boolean permiso = sc.nextBoolean();
            sc.nextLine();

            Estudiante estudiante = new Estudiante(nombre, grado, permiso);

            System.out.print("El estudiante se presenta para subir al bus? (true/false): ");
            boolean presente = sc.nextBoolean();
            sc.nextLine();

            if (presente && estudiante.permisoVigente) {
                System.out.println(estudiante.nombre + " puede subir al autobus.");
                aceptados++;
            } else {
                System.out.println(estudiante.nombre + " no puede subir al autobus.");
                rechazados++;
            }

            System.out.println("Informacion del estudiante:\n" + estudiante.toString());

            i++;
        } while (i <= n);

        System.out.println("\n--- Resumen ---");
        System.out.println("Estudiantes aceptados: " + aceptados);
        System.out.println("Estudiantes rechazados: " + rechazados);
    }
}

class Estudiante {
    public String nombre;
    public String grado;
    public boolean permisoVigente;

    public Estudiante(String nombre, String grado, boolean permisoVigente) {
        this.nombre = nombre;
        this.grado = grado;
        this.permisoVigente = permisoVigente;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nGrado: " + grado + "\nPermiso vigente: " + (permisoVigente ? "Si" : "No");
    }
}