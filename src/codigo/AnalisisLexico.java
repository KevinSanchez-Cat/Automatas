/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.util.ArrayList;

/**
 *
 * @author aloso
 */
public class AnalisisLexico {

    public static boolean separa(String palabra, String cadena) {

        if (cadena.length() > 0) {
            String simbolo = cadena.substring(0, 1);
            if (simbolo.equals(" ") && palabra.length() > 0) {                      // " "
                return Tokens(palabra, cadena.substring(1, cadena.length()));
            }
            if (simbolo.equals(" ") && palabra.length() == 0) {
                return separa("", cadena.substring(1, cadena.length()));
            } else if (simbolo.equals("\t") && palabra.length() > 0) {               // t
                return Tokens(palabra, cadena.substring(1, cadena.length()));
            }
            if (simbolo.equals("\t") && palabra.length() == 0) {
                return separa("", cadena.substring(1, cadena.length()));
            } else if (simbolo.equals("\n") && palabra.length() > 0) {               // /n
                return Tokens(palabra, cadena.substring(1, cadena.length()));
            } else if (simbolo.equals("\n") && palabra.length() == 0) {
                return separa("", cadena.substring(1, cadena.length()));
            } else if (simbolo.equals(";") && palabra.length() > 0) {                // ;
                return Tokens(palabra, cadena);
            } else if (simbolo.equals(";") && palabra.length() == 0) {
                Main.cadena += ";\t\t2   ➡   Punto y coma\n";
                return separa("", cadena.substring(1, cadena.length()));
            } else if (simbolo.equals(",") && palabra.length() > 0) {                // ;
                return Tokens(palabra, cadena);
            } else if (simbolo.equals(",") && palabra.length() == 0) {
                Main.cadena += ",\t\t15   ➡   Coma\n";
                return separa("", cadena.substring(1, cadena.length()));
            } else if (simbolo.equals("+") && palabra.length() > 0) {               // +
                return Tokens(palabra, cadena);
            }
            if (simbolo.equals("+") && palabra.length() == 0) {
                Main.cadena += "+\t\t4   ➡   Operador aritmético\n";
                return separa("", cadena.substring(1, cadena.length()));
            } else if (simbolo.equals("-") && palabra.length() > 0) {               // -
                return Tokens(palabra, cadena);
            } else if (simbolo.equals("-") && palabra.length() == 0) {
                Main.cadena += "-\t\t4   ➡   Operador aritmético\n";
                return separa(palabra, cadena.substring(1, cadena.length()));
            } else if (simbolo.equals("/") && palabra.length() > 0) {                // /
                return Tokens(palabra, cadena);
            }
            if (simbolo.equals("/") && palabra.length() == 0) {
                Main.cadena += "/\t\t4   ➡   Operador aritmético\n";
                return separa("", cadena.substring(1, cadena.length()));
            } else if (simbolo.equals("*") && palabra.length() > 0) {                // *
                return Tokens(palabra, cadena);
            }
            if (simbolo.equals("*") && palabra.length() == 0) {
                Main.cadena += "*\t\t4   ➡   Operador aritmético\n";
                return separa("", cadena.substring(1, cadena.length()));
            } else if (simbolo.equals("^") && palabra.length() > 0) {                // ^
                return Tokens(palabra, cadena);
            }
            if (simbolo.equals("^") && palabra.length() == 0) {
                Main.cadena += "^\t\t4   ➡   Operador aritmético\n";
                return separa("", cadena.substring(1, cadena.length()));
            } else if (simbolo.equals("%") && palabra.length() > 0) {                // %
                return Tokens(palabra, cadena);
            }
            if (simbolo.equals("%") && palabra.length() == 0) {
                Main.cadena += "%\t\t4   ➡   Operador aritmético\n";
                return separa("", cadena.substring(1, cadena.length()));
            } else if (simbolo.equals("(") && palabra.length() > 0) {                // (
                return Tokens(palabra, cadena);
            } else if (simbolo.equals("(") && palabra.length() == 0) {
                Main.cadena += "(\t\t7   ➡   Paréntesis que abre\n";
                return separa("", cadena.substring(1, cadena.length()));
            } else if (simbolo.equals(")") && palabra.length() > 0) {                // )
                return Tokens(palabra, cadena);
            } else if (simbolo.equals(")") && palabra.length() == 0) {
                Main.cadena += ")\t\t8   ➡   Paréntesis  que cierra\n";
                return separa("", cadena.substring(1, cadena.length()));
            } else if (simbolo.equals("{") && palabra.length() > 0) {                // {
                return Tokens(palabra, cadena);
            } else if (simbolo.equals("{") && palabra.length() == 0) {
                Main.cadena += "{\t\t9   ➡   Llave que abre\n";
                return separa("", cadena.substring(1, cadena.length()));
            } else if (simbolo.equals("}") && palabra.length() > 0) {                // }
                return Tokens(palabra, cadena);
            } else if (simbolo.equals("}") && palabra.length() == 0) {
                Main.cadena += "}\t\t10   ➡   Llave que cierra\n";
                return separa("", cadena.substring(1, cadena.length()));
            } else if (simbolo.equals("=") && palabra.length() > 0) {               // =
                return Tokens(palabra, cadena);
            } else if (simbolo.equals("=")) {
                Main.cadena += "=";
                return S9(cadena.substring(1, cadena.length()));
            } else if (simbolo.equals("!") && palabra.length() > 0) {               // !
                return Tokens(palabra, cadena);
            } else if (simbolo.equals("!")) {
                Main.cadena += "!";
                return S10(cadena.substring(1, cadena.length()));
            } else if (simbolo.equals(">") && palabra.length() > 0) {                // >
                return Tokens(palabra, cadena);
            } else if (simbolo.equals(">")) {
                Main.cadena += ">";
                return S11(cadena.substring(1, cadena.length()));
            } else if (simbolo.equals("<") && palabra.length() > 0) {                // <
                return Tokens(palabra, cadena);
            } else if (simbolo.equals("<")) {
                Main.cadena += "<";
                return S11(cadena.substring(1, cadena.length()));
            } else if (simbolo.equals("\"")) {                                         // '
                Main.cadena += "\"";
                return S8(cadena.substring(1, cadena.length()));
            } else {
                return separa(palabra += simbolo, cadena.substring(1, cadena.length()));
            }
        } else {
            return false;
        }
    }

    public static boolean Tokens(String palabra, String cadena) {
        if (palabra.equals("String")) {
            Main.cadena += "String\t\t1   ➡   Tipo de dato\n";
            return separa("", cadena);
        } else if (palabra.equals("int")) {
            Main.cadena += "int\t\t1   ➡   Tipo de dato\n";
            return separa("", cadena);
        } else if (palabra.equals("float")) {
            Main.cadena += "float\t\t1   ➡   Tipo de dato\n";
            return separa("", cadena);
        } else if (palabra.equals("if")) {
            Main.cadena += "if\t\t6   ➡   Palabra reservada if (Si)\n";
            return separa("", cadena);
        } else if (palabra.equals("else")) {
            Main.cadena += "else\t\t11   ➡   Palabra reservada else (Si no)\n";
            return separa("", cadena);
        } else if (palabra.equals("while")) {
            Main.cadena += "while\t\t12   ➡   Palabra reservada while (Mientras)\n";
            return separa("", cadena);
        } else if (palabra.equals("scanf")) {
            Main.cadena += "scanf\t\t13   ➡   Palabra reservada scanf (Lee)\n";
            return separa("", cadena);
        } else if (palabra.equals("printf")) {
            Main.cadena += "printf\t\t14   ➡   Palabra reservada printf (Escribe)\n";
            return separa("", cadena);
        } else if (palabra.equals("inicio")) {
            Main.cadena += "inicio\t\t16   ➡   Palabra reservada comenzar programa\n";
            return separa("", cadena);
        } else if (palabra.equals("false")) {
            Main.cadena += "false\t\t20   ➡   Palabra reservada false\n";
            return separa("", cadena);
        } else if (palabra.equals("true")) {
            Main.cadena += "true\t\t21   ➡   Palabra reservada true\n";
            return separa("", cadena);
        } else if (palabra.equals("void")) {
            Main.cadena += "void\t\t21   ➡   Palabra reservada para metodos \n";
            return separa("", cadena);
        } else if (palabra.equals("class")) {
            Main.cadena += "class\t\t16   ➡   Comienzo del programa\n";
            return separa("", cadena);
        } else if (palabra.equals("return")) {
            Main.cadena += "return\t\t19   ➡   Palabra reservada de retorno \n";
            return separa("", cadena);
        } else {
            Main.cadena += palabra;
            return S0(palabra, cadena);
        }
    }

    public static boolean S0(String palabra, String cadena) { // Estado inicial
        if (palabra.length() > 0) {
            String simbolo = palabra.substring(0, 1);
            if (Character.isLetter(simbolo.charAt(0))) {
                return S1(palabra.substring(1, palabra.length()), cadena);
            } else if (Character.isDigit(simbolo.charAt(0))) {
                return S2S3(palabra.substring(1, palabra.length()), cadena);
            } else if (simbolo.equals("'")) {
                return S6(palabra.substring(1, palabra.length()), cadena);
            } else {
                System.out.println(palabra);
                if (palabra.startsWith("#")) {
                    return S14(palabra.substring(1, palabra.length()), cadena);
                } else if (palabra.startsWith("_")) {
                    return S15(palabra.substring(1, palabra.length()), cadena);
                } else if (palabra.startsWith("&")) {
                    return S16(palabra.substring(1, palabra.length()), cadena);
                } else if (palabra.startsWith("|")) {
                    return S16(palabra.substring(1, palabra.length()), cadena);
                } else {
                    Main.cadena += "\t\t104   ➡   Carácter desconocido S0\n";
                    return separa("", cadena);
                }
            }
        } else {
            return separa("", cadena);
        }
    }

    private static boolean S1(String palabra, String cadena) { // Estado para letras
        if (palabra.length() > 0) {
            String simbolo = palabra.substring(0, 1);
            if (Character.isLetter(simbolo.charAt(0))) {
                return S1(palabra.substring(1, palabra.length()), cadena);
            } else if (Character.isDigit(simbolo.charAt(0))) {
                return S1(palabra.substring(1, palabra.length()), cadena);
            } else {
                Main.cadena += "\t\t100   ➡   Variable no valida S1\n";
                return separa("", cadena);
            }
        } else {
            Main.cadena += "\t\t50   ➡   Variable\n";
            return separa("", cadena);
        }
    }

    private static boolean S2S3(String palabra, String cadena) { // Estado para numeros
        if (palabra.length() > 0) {
            String simbolo = palabra.substring(0, 1);
            if (Character.isDigit(simbolo.charAt(0))) {
                return S2S3(palabra.substring(1, palabra.length()), cadena);
            } else if (simbolo.equals(".")) {
                return S4(palabra.substring(1, palabra.length()), cadena);
            } else {
                Main.cadena += "\t\t101   ➡   Entero no valido S2S3\n";
                return separa("", cadena);
            }
        } else {
            Main.cadena += "\t\t51   ➡   Entero\n";
            return separa("", cadena);
        }
    }

    private static boolean S4(String palabra, String cadena) { // Estado para letras
        if (palabra.length() > 0) {
            String simbolo = palabra.substring(0, 1);
            if (Character.isDigit(simbolo.charAt(0))) {
                return S5(palabra.substring(1, palabra.length()), cadena);
            } else {
                Main.cadena += "\t\t102   ➡   Flotante no valido S4\n";
                return separa("", cadena);
            }
        } else {
            Main.cadena += "\t\t102   ➡   Flotante no valido S4\n";
            return separa("", cadena);
        }
    }

    private static boolean S5(String palabra, String cadena) { // Estado para letras
        if (palabra.length() > 0) {
            String simbolo = palabra.substring(0, 1);
            if (Character.isDigit(simbolo.charAt(0))) {
                return S5(palabra.substring(1, palabra.length()), cadena);
            } else {
                Main.cadena += "\t\t102   ➡   Flotante no valido S5\n";
                return separa("", cadena);
            }
        } else {
            Main.cadena += "\t\t52   ➡   Flotante\n";
            return separa("", cadena);
        }
    }

    private static boolean S6(String palabra, String cadena) { // Estado para '
        if (palabra.length() > 0) {
            String simbolo = palabra.substring(0, 1);
            if (Character.isLetter(simbolo.charAt(0))) {
                return S6(palabra.substring(1, palabra.length()), cadena);
            } else if (Character.isDigit(simbolo.charAt(0))) {
                return S6(palabra.substring(1, palabra.length()), cadena);
            } else if (simbolo.equals(" ") || simbolo.equals("\b")) {
                return S6(palabra.substring(1, palabra.length()), cadena);
            } else if (simbolo.equals("\t")) {
                return S6(palabra.substring(1, palabra.length()), cadena);
            } else if (simbolo.equals("'")) {
                return S7(palabra, cadena);
            } else {
                Main.cadena += "\t\t103   ➡   Mensaje o cadena no valida S6\n";
                return separa("", cadena);
            }
        } else {
            Main.cadena += "\t\t103   ➡   Mensaje o cadena no valida S6\n";
            return separa("", cadena);
        }
    }

    private static boolean S7(String palabra, String cadena) { // Estado para '
        if (palabra.length() > 0) {
            String simbolo = palabra.substring(0, 1);
            if (simbolo.equals("\"")) {
                Main.cadena += "\t\t53   ➡   Mensaje o cadena\n";
                return separa("", cadena);
            } else {
                Main.cadena += "\t\t103   ➡   Mensaje o cadena no valida S7\n";
                return separa("", cadena);
            }
        } else {
            Main.cadena += "\t\t103   ➡   Mensaje o cadena no valida S7\n";
            return separa("", cadena);
        }
    }

    private static boolean S8(String cadena) {
        if (cadena.length() > 0) {
            String simbolo = cadena.substring(0, 1);
            Main.cadena += simbolo;
            if (Character.isLetter(simbolo.charAt(0))) {
                return S8(cadena.substring(1, cadena.length()));
            } else if (Character.isDigit(simbolo.charAt(0))) {
                return S8(cadena.substring(1, cadena.length()));
            } else if (simbolo.equals(" ")) {
                return S8(cadena.substring(1, cadena.length()));
            } else if (simbolo.equals("\t")) {
                return S8(cadena.substring(1, cadena.length()));
            } else if (simbolo.equals("\"")) {
                Main.cadena += "\t\t53   ➡   Mensaje o cadena\n";
                return separa("", cadena.substring(1, cadena.length()));
            } else {
                return S8C(cadena.substring(1, cadena.length()));
            }
        } else {
            Main.cadena += "\t\t103   ➡   Mensaje o cadena no valida S8\n";
            return separa("", cadena);
        }
    }

    private static boolean S8C(String cadena) {
        String simbolo = cadena.substring(0, 1);
        Main.cadena += simbolo;
        if (simbolo.equals("\"")) {
            Main.cadena += "\t\t103   ➡   Mensaje o cadena no valida S8\n";
            return separa("", cadena.substring(1, cadena.length()));
        } else {
            return S8C(cadena.substring(1, cadena.length()));
        }
    }

    private static boolean S9(String cadena) { // Estado para '
        String simbolo = cadena.substring(0, 1);
        if (simbolo.equals("=")) {
            Main.cadena += "=";
            return S13(cadena.substring(1, cadena.length()));
        } else {
            Main.cadena += "\t\t53   ➡   Igual\n";
            return separa("", cadena);
        }
    }

    private static boolean S10(String cadena) { // Estado para '
        String simbolo = cadena.substring(0, 1);
        if (simbolo.equals(" ")) {
            Main.cadena += "\t\t18   ➡   Operador lógico\n";
            return separa("", cadena);
        }
        if (simbolo.equals("=")) {
            Main.cadena += "=";
            return S13(cadena.substring(1, cadena.length()));
        } else {
            Main.cadena += "\t\t104   ➡   Carácter desconocido S10\n";
            return separa("", cadena);
        }
    }

    private static boolean S11(String cadena) { // Estado para '
        String simbolo = cadena.substring(0, 1);
        if (simbolo.equals("=")) {
            Main.cadena += "=";
            return S13(cadena.substring(1, cadena.length()));
        } else {
            Main.cadena += "\t\t5   ➡   Operador relacional\n";
            return separa("", cadena);
        }
    }

    private static boolean S13(String cadena) {
        Main.cadena += "\t\t5   ➡   Operador relacional\n";
        return separa("", cadena);
    }

    private static boolean S14(String palabra, String cadena) { // Estado para letras
        if (palabra.length() > 0) {
            String simbolo = palabra.substring(0, 1);
            if (Character.isLetter(simbolo.charAt(0))) {
                return S14(palabra.substring(1, palabra.length()), cadena);
            } else if (Character.isDigit(simbolo.charAt(0))) {
                return S14(palabra.substring(1, palabra.length()), cadena);
            } else {
                Main.cadena += "\t\t104   ➡   Clase no valida S14\n";
                return separa("", cadena);
            }
        } else {
            Main.cadena += "\t\t55   ➡   Clase\n";
            return separa("", cadena);
        }
    }

    private static boolean S15(String palabra, String cadena) { // Estado para letras
        if (palabra.length() > 0) {
            String simbolo = palabra.substring(0, 1);
            if (Character.isLetter(simbolo.charAt(0))) {
                return S15(palabra.substring(1, palabra.length()), cadena);
            } else if (Character.isDigit(simbolo.charAt(0))) {
                return S15(palabra.substring(1, palabra.length()), cadena);
            } else {
                Main.cadena += "\t\t105   ➡   Metodo no valido S14\n";
                return separa("", cadena);
            }
        } else {
            Main.cadena += "\t\t55   ➡   Metodo\n";
            return separa("", cadena);
        }
    }

    private static boolean S16(String palabra, String cadena) { // Estado para letras
        if (palabra.length() > 0) {
            String simbolo = palabra.substring(0, 1);
            if (palabra.startsWith("&")) {
                Main.cadena += "\t\t18   ➡   Operador lógico\n";
                return separa("", cadena);
            } else if (palabra.startsWith("|")) {
                Main.cadena += "\t\t18   ➡   Operador lógico\n";
                return separa("", cadena);
            } else {
                Main.cadena += "\t\t104   ➡   Carácter desconocido S0\n";
                return separa("", cadena);
            }
        } else {
            Main.cadena += "\t\t104   ➡   Carácter desconocido S0\n";
            return separa("", cadena);
        }
    }
}
