import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Separa los argumentos mediante comillas");
            return;
        }

        String input = args[0];
        boolean coincide = false;

        if (validarHolamundo(input)) {
            System.out.println("Existe un Hola mundo");
            coincide = true;
        }
        if (validarHolamundoMym(input)) {
            System.out.println("Existe un Hola mundo en mayusculas o minusculas.");
            coincide = true;
        }
        if (validarLenguaje(input)) {
            System.out.println("Contiene Lenguajes de programacion.");
            coincide = true;
        }
        if (validarCorreo(input)) {
            System.out.println("Existe un correo de unison");
            coincide = true;
        }
        if (validarArchivo(input)) {
            System.out.println("Contiene una extension de archivo.");
            coincide = true;
        }

        if (!coincide) {
            System.out.println("No Existe ninguna expresion");
        }
    }

    private static boolean validarHolamundo(String input) {
        String regex = "Hola mundo";
        return Pattern.compile(regex).matcher(input).find();
    }

    private static boolean validarHolamundoMym(String input) {
        String regex = "(?i)hola mundo";
        return Pattern.compile(regex).matcher(input).find();
    }

    private static boolean validarLenguaje(String input) {
        String regex = "\\b(Java|Python|Pascal|Go|Perl)\\b";
        return Pattern.compile(regex).matcher(input).find();
    }

    private static boolean validarCorreo(String input) {
        String regex = "@(?:unison.mx|uson.mx)";
        return Pattern.compile(regex).matcher(input).find();
    }

    private static boolean validarArchivo(String input) {
        String regex = "ISI\\d{4}-[12]\\.(txt|csv)";
        return Pattern.compile(regex).matcher(input).find();
    }
}