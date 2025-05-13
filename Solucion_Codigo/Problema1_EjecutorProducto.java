import java.util.Scanner;

public class Problema1_EjecutorProducto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el precio del producto: ");
        double precio = sc.nextDouble();

        System.out.print("Ingrese la cantidad de productos: ");
        int cantidad = sc.nextInt();
        
        Producto p1 = new Producto(precio, cantidad);

        p1.calcularDescuento(p1.precioProducto, p1.cantidadProducto);
        p1.calcularPrecioFinal();

        System.out.println("Descuento aplicado: " + p1.descuento + "%");
        System.out.println("Precio final: $" + p1.precioFinal);

    }
}

class Producto {
    public double precioProducto;
    public int cantidadProducto;
    public double descuento;
    public double precioFinal;

    public Producto() {}

    public Producto(double precioProducto, int cantidadProducto) {
        this.precioProducto = precioProducto;
        this.cantidadProducto = cantidadProducto;
    }

    public double calcularDescuento(double precioProducto, int cantidadProducto) {
        this.descuento = (precioProducto >= 1000 && cantidadProducto >= 10) ? 10 : 5;
        return this.descuento;
    }

    public double calcularPrecioFinal() {
        this.precioFinal = (this.cantidadProducto * this.precioProducto)
                - ((this.cantidadProducto * this.precioProducto) * (this.descuento / 100));
        return precioFinal;
    }

    @Override
    public String toString() {
        return "Producto{" + "precioProducto=" + precioProducto + ", cantidadProducto=" + cantidadProducto + ", descuento=" + descuento + ", precioFinal=" + precioFinal + '}';
    }
}