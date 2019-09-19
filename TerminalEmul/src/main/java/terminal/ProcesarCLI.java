package terminal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class ProcesarCLI {

    private String textoCLI;
    private CommandLineParser parser = null;
    private CommandLine cmdLine = null;
    private Options options;

    ProcesarCLI(String lineaTextoIngresada) throws InstantiationException {
        Object comando;
        System.out.println("Entrando a ProcesarCLI()");
        try {
            String[] argumento = lineaTextoIngresada.split(" ");
            String miClase = argumento[0];

            Class claseComando = Class.forName(miClase);

            Constructor[] constructor = claseComando.getDeclaredConstructors();
            constructor[1].newInstance(lineaTextoIngresada);
            comando = claseComando.getDeclaredConstructor().newInstance();
            System.out.println("Aqui:"+comando);
//        try {
//            parser = new BasicParser();
//            cmdLine = parser.parse(options, lineaTextoIngresada);
//           
//            // Si está la opcion de ayuda, la imprimimos y salimos.
//            if (cmdLine.hasOption("h")){    // No hace falta preguntar por el parámetro "help". Ambos son sinónimos
//                new HelpFormatter().printHelp(CliApp.class.getCanonicalName(), options );
//                return;  
//            }
//        } catch (ParseException ex) {
//            Logger.getLogger(ProcesarCLI.class.getName()).log(Level.SEVERE, null, ex);
//        }
        } catch (Exception ex) {
            Logger.getLogger(ProcesarCLI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

     public Object createObject(String className) {
        Object object = null;
        try {
            Class classDefinition = Class.forName(className);
            object = classDefinition.newInstance();
        } catch (InstantiationException e) {
            System.out.println(e);
        } catch (IllegalAccessException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        return object;
    }
    
    public String ejecutar() {
        String textoSalida = "";

        return textoSalida;
    }

}
