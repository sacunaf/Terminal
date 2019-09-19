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
    
    private String comandoNombre;
    private String comandoParametros;
    private Class comandoClass;
    private Object comandoObj;
    
    private CommandLineParser parser = null;
    private CommandLine cmdLine = null;
    private Options options;

    
    ProcesarCLI(String textoDesdeCLI) {
        System.out.println("Entrando a ProcesarCLI()");
        try {
            String[] argumento = textoDesdeCLI.split(" ");
            comandoNombre = argumento[0];
            comandoParametros = textoDesdeCLI.substring(comandoNombre.length()+1);            
            comandoClass = Class.forName(comandoNombre);
            comandoObj = comandoClass.getDeclaredConstructor(String.class).newInstance(comandoParametros);
            System.out.println("Aqui:" + comandoObj);      
        } catch (Exception ex) {
            Logger.getLogger(ProcesarCLI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void testing() {
         
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
    }

     private static void removerElemento(String[] array, int index) {
        int i = index;
        for (; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[i] = null;
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
