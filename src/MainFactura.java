import javax.swing.JOptionPane;
public class MainFactura {


        static int amountToPay = 0;
        static int platosCounter = 0;
        static int platoTipicoCounter = 0;
        static int platoALaCartaCounter = 0;
        static int platoInternacionalCounter = 0;

        public static void main(String[] args) {
            String nombreUsuario = JOptionPane.showInputDialog("Ingrese su nombre: ");

            int codMenuPpal;
            do {
                String menu = "MENÚ RESTAURANTE\n\n";
                menu += "1. Plato Típico\n";
                menu += "2. Plato a la carta\n";
                menu += "3. Plato internacional\n";
                menu += "4. Salir\n\n";
                menu += "Por favor seleccione una opción: ";

                codMenuPpal = getIntInput(menu, "Menú Principal");

                switch (codMenuPpal) {
                    case 1:
                        handlePlatoTipico();
                        break;
                    case 2:
                        handlePlatoALaCarta();
                        break;
                    case 3:
                        handlePlatoInternacional();
                        break;
                    case 4:
                        printFactura(nombreUsuario);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "No corresponde a un código válido", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                        break;
                }
            } while (codMenuPpal != 4);
        }

        private static void handlePlatoTipico() {
            int codMenuTipico;
            do {
                String menuTipico = "MENÚ TÍPICO\n\n";
                menuTipico += "1. Frijoles ($12,000)\n";
                menuTipico += "2. Sopa de Verduras ($8,000)\n";
                menuTipico += "3. Regresar\n\n";
                menuTipico += "Por favor seleccione una opción: ";

                codMenuTipico = getIntInput(menuTipico, "Menú Típico");

                switch (codMenuTipico) {
                    case 1:
                        amountToPay += 12000;
                        platosCounter++;
                        platoTipicoCounter++;
                        break;
                    case 2:
                        amountToPay += 8000;
                        platosCounter++;
                        platoTipicoCounter++;
                        break;
                    case 3:
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "No corresponde a un código válido", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                        break;
                }
                if (codMenuTipico != 3) {
                    codMenuTipico = getIntInput("Ingrese 1 si desea repetir el menú típico, de lo contrario regresará al menú principal", "Repetir Menú Típico");
                }
            } while (codMenuTipico == 1);
        }

        private static void handlePlatoALaCarta() {
            int codMenuCarta;
            do {
                String menuCarta = "MENÚ A LA CARTA\n\n";
                menuCarta += "1. Hamburguesa ($15,000)\n";
                menuCarta += "2. Nuggets ($10,000)\n";
                menuCarta += "3. Regresar\n\n";
                menuCarta += "Por favor seleccione una opción: ";

                codMenuCarta = getIntInput(menuCarta, "Menú a la Carta");

                switch (codMenuCarta) {
                    case 1:
                        amountToPay += 15000;
                        platosCounter++;
                        platoALaCartaCounter++;
                        break;
                    case 2:
                        amountToPay += 10000;
                        platosCounter++;
                        platoALaCartaCounter++;
                        break;
                    case 3:
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "No corresponde a un código válido", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                        break;
                }
                if (codMenuCarta != 3) {
                    codMenuCarta = getIntInput("Ingrese 1 si desea repetir el menú a la carta, de lo contrario regresará al menú principal", "Repetir Menú a la Carta");
                }
            } while (codMenuCarta == 1);
        }

        private static void handlePlatoInternacional() {
            int codMenuInternacional;
            do {
                String menuInternacional = "MENÚ INTERNACIONAL\n\n";
                menuInternacional += "1. Lasagna ($20,000)\n";
                menuInternacional += "2. Paella ($18,000)\n";
                menuInternacional += "3. Regresar\n\n";
                menuInternacional += "Por favor seleccione una opción: ";

                codMenuInternacional = getIntInput(menuInternacional, "Menú Internacional");

                switch (codMenuInternacional) {
                    case 1:
                        amountToPay += 20000;
                        platosCounter++;
                        platoInternacionalCounter++;
                        break;
                    case 2:
                        amountToPay += 18000;
                        platosCounter++;
                        platoInternacionalCounter++;
                        break;
                    case 3:
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "No corresponde a un código válido", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                        break;
                }
                if (codMenuInternacional != 3) {
                    codMenuInternacional = getIntInput("Ingrese 1 si desea repetir el menú internacional, de lo contrario regresará al menú principal", "Repetir Menú Internacional");
                }
            } while (codMenuInternacional == 1);
        }

        private static int getIntInput(String message, String title) {
            int input = -1;
            boolean valid = false;
            while (!valid) {
                try {
                    input = Integer.parseInt(JOptionPane.showInputDialog(null, message, title, JOptionPane.PLAIN_MESSAGE));
                    valid = true;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Entrada no válida. Por favor ingrese un número.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            return input;
        }

        private static void printFactura(String nombreUsuario) {
            JOptionPane.showMessageDialog(null, "Factura:\n" +
                    "Cliente: " + nombreUsuario + "\n" +
                    "Cantidad total de platos: " + platosCounter + "\n" +
                    "Platos típicos: " + platoTipicoCounter + "\n" +
                    "Platos a la carta: " + platoALaCartaCounter + "\n" +
                    "Platos internacionales: " + platoInternacionalCounter + "\n" +
                    "Monto total a pagar: $" + amountToPay);
        }
    }


