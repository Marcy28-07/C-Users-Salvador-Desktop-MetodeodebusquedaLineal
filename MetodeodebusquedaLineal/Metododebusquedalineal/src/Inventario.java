import java.util.Scanner;

public class Inventario {
    private String[] productos;

    public Inventario(int cantidadProductos) {
        productos = new String[cantidadProductos];
    }

    public void registrarProductos(Scanner scanner) {
        System.out.println("Ingrese el nombre de cada producto:");
        for (int i = 0; i < productos.length; i++) {
            System.out.print("Producto " + (i + 1) + ": ");
            productos[i] = scanner.nextLine();
        }
    }

    public boolean compararIgnorandoMayusculas(String str1, String str2) {
        // Si ambos strings son null, consideramos que son iguales
        if (str1 == null && str2 == null) {
            return true;
        }
        // Si solo uno de los strings es null, consideramos que son diferentes
        if (str1 == null || str2 == null) {
            return false;
        }
        // Comparamos los strings ignorando las diferencias entre mayúsculas y minúsculas
        return str1.equalsIgnoreCase(str2);
    }

    public void buscarProducto(String productoBuscado) {
        boolean encontrado = false;
        for (String producto : productos) {
            if (compararIgnorandoMayusculas(producto, productoBuscado)) {
                System.out.println("Producto encontrado: " + producto);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("El producto '" + productoBuscado + "' no está disponible.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de productos que desea registrar en el inventario: ");
        int cantidadProductos = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada

        Inventario inventario = new Inventario(cantidadProductos);
        inventario.registrarProductos(scanner);

        System.out.print("Ingrese el nombre del producto que desea buscar: ");
        String productoBuscado = scanner.nextLine();

        inventario.buscarProducto(productoBuscado);

        scanner.close();
    }
}