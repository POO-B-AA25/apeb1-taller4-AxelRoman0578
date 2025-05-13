import java.util.Scanner;

public class Problema2_EjecutorEmpleado {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de empleados que desee ingresar: ");
        int n = sc.nextInt();
        sc.nextLine();
        int i = 1;
        do {
            System.out.println("Ingrese el nombre del Empleado: ");
            String nombre = sc.nextLine();

            System.out.println("Ingrese el Salario del Empleado: ");
            double salario = sc.nextDouble();

            System.out.println("Ingrese la edad del Empleado: ");
            int edad = sc.nextInt();

            System.out.println("Ingrese el porcentaje de aumento salarial: ");
            double porcentajeAumento = sc.nextDouble();
            sc.nextLine();

            Empleado empleado = new Empleado(nombre, salario, edad, porcentajeAumento);
            empleado.calcularAumeto();
            System.out.println("--- Informacion del Empleado " + i + " ---");
            empleado.mostrarInformacion();

            i++;
        } while (i <= n);
    }
}

class Empleado {
    public String nombre;
    public double salario;
    public int edad;
    public double aumento;

    public Empleado() {
    }

    public Empleado(String nombre, double salario, int edad, double aumento) {
        this.nombre = nombre;
        this.salario = salario;
        this.edad = edad;
        this.aumento = aumento;
    }

    public void calcularAumeto() {
        double salarioPromedio = 1000;
        if (this.salario < salarioPromedio) {
            this.salario = this.salario + (this.salario * (this.aumento / 100));
        }
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Edad: " + this.edad);
        System.out.println("Salario actualizado: $" + String.format("%.2f", this.salario));
    }
    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", salario=" + salario + ", edad=" + edad + ", aumento=" + aumento + '}';
    }
}