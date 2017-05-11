package icaro.aplicaciones.agentes.AgenteAplicacionCalendario.tareas;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseDate {// extends TareaSincrona {

    public static void main(String[] args) {
        ParseDate.ejecutar("", "5.23");
        ParseDate.ejecutar("", "5 y 23");
        ParseDate.ejecutar("", "23:23");
        ParseDate.ejecutar("", "5:23 am");
        ParseDate.ejecutar("", "5:23");
        ParseDate.ejecutar("", "22 horas");
        ParseDate.ejecutar("", "22 horas y 15 minutos");
        ParseDate.ejecutar("", "22 horas y 15 minutos am");
        ParseDate.ejecutar("", "12 horas y 15 minutos am");

    }

    // Nota: podemos asumir que las expresiones ya van a ser correctas, ya
    // que si no gate no las habría parseado bien
    // @Override
    public static void ejecutar(Object... params) {
        // TODO Auto-generated method stub

        // Supongamos que el parametro 1 es el string con la fecha
        String fecha = (String) params[1];
        System.out.println(fecha);
        String pattern1 = "(?<hora>[01]?[0-9]|2[0-3])(:|.)(?<minuto>[0-5][0-9])"; // valida
                                                                                  // formato
                                                                                  // 24
                                                                                  // horas
        String pattern2 = "(?<hora>1[012]|[1-9])(:|.)(?<minuto>[0-5][0-9])((\\s)?)+(?i)(?<frame>am|pm)"; // valida
        // formato 12 horas y recoge el timeframe
        String pattern3 = "(?<hora>[01]?[0-9]|2[0-3])(\\s)+(y)(\\s)+(?<minuto>[0-5][0-9])"; // formato
                                                                                            // 24
                                                                                            // horas
                                                                                            // del
                                                                                            // estilo
                                                                                            // "23
                                                                                            // y
                                                                                            // 32"
        String pattern4 = "(?<hora>1[012]|[1-9])(\\s)+(y)(\\s)+(?<minuto>[0-5][0-9])(\\s)?(?i)(?<frame>am|pm)"; // valida
                                                                                                                // formato
                                                                                                                // 12
                                                                                                                // horas
                                                                                                                // del
                                                                                                                // estilo
                                                                                                                // "2
                                                                                                                // y
                                                                                                                // 23
                                                                                                                // am"
        String pattern5 = "(?<hora>1[012]|[1-9])((\\s)?(horas|hora|hrs|h))((\\s)y)(\\s)?(?<minuto>[0-5][0-9])((\\s)?(minutos|mins|min|minuto))?(\\s)?(?<frame>am|pm)";// 12
        // horas
        // y
        // 23
        // minutos am
        String pattern6 = "(?<hora>[01]?[0-9]|2[0-3])((\\s)?(horas|hora|hrs|h))((\\s)y)(\\s)?(?<minuto>[0-5][0-9])((\\s)?(minutos|mins|min|minuto))?";// 22
        // horas
        // y
        // 14
        // minutos
        String pattern7 = "";
        String pattern8 = "";

        Pattern pat;
        Matcher fechaMatcher;

        // Pattern 1
        pat = Pattern.compile(pattern1);
        fechaMatcher = pat.matcher(fecha);
        if (fechaMatcher.matches()) {
            System.out.println("matches 1");
            System.out.println("hora: " + fechaMatcher.group("hora")
                    + ", minuto: " + fechaMatcher.group("minuto"));
        }

        // Pattern 2
        pat = Pattern.compile(pattern2);
        fechaMatcher = pat.matcher(fecha);
        if (fechaMatcher.matches()) {
            System.out.println("matches 2");
            System.out.println("hora: " + fechaMatcher.group("hora")
                    + ", minuto: " + fechaMatcher.group("minuto")
                    + ", timeframe: " + fechaMatcher.group("frame"));

        }

        // Pattern 3
        pat = Pattern.compile(pattern3);
        fechaMatcher = pat.matcher(fecha);
        if (fechaMatcher.matches()) {
            System.out.println("matches 3");
            System.out.println("hora: " + fechaMatcher.group("hora")
                    + ", minuto: " + fechaMatcher.group("minuto"));

        }

        // Pattern 4
        pat = Pattern.compile(pattern4);
        fechaMatcher = pat.matcher(fecha);
        if (fechaMatcher.matches()) {
            System.out.println("matches 4");
            System.out.println("hora: " + fechaMatcher.group("hora")
                    + ", minuto: " + fechaMatcher.group("minuto")
                    + ", timeframe: " + fechaMatcher.group("frame"));

        }

        // Pattern 5
        pat = Pattern.compile(pattern5);
        fechaMatcher = pat.matcher(fecha);
        if (fechaMatcher.matches()) {
            System.out.println("matches 5");
            System.out.println("hora: " + fechaMatcher.group("hora")
                    + ", minuto: " + fechaMatcher.group("minuto")
                    + ", timeframe: " + fechaMatcher.group("frame"));

        }

        // Pattern 6
        pat = Pattern.compile(pattern6);
        fechaMatcher = pat.matcher(fecha);
        if (fechaMatcher.matches()) {
            System.out.println("matches 6");
            System.out.println("hora: " + fechaMatcher.group("hora")
                    + ", minuto: " + fechaMatcher.group("minuto"));

        }

        // Pattern 7
        pat = Pattern.compile(pattern7);
        fechaMatcher = pat.matcher(fecha);
        if (fechaMatcher.matches()) {
            System.out.println("matches 7");
            System.out.println("hora: " + fechaMatcher.group("hora")
                    + ", minuto: " + fechaMatcher.group("minuto"));

        }

        // Pattern 8
        pat = Pattern.compile(pattern8);
        fechaMatcher = pat.matcher(fecha);
        if (fechaMatcher.matches()) {
            System.out.println("matches 8");
            System.out.println("hora: " + fechaMatcher.group("hora")
                    + ", minuto: " + fechaMatcher.group("minuto"));

        }

    }

}
