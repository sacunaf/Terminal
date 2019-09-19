package procesarCLI;

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
    private String consolasalida;

    private CommandLineParser parser = null;
    private CommandLine cmdLine = null;
    private Options options;

    public ProcesarCLI(String textoDesdeCLI) {
        System.out.println("Entrando a ProcesarCLI()");
        try {
            String[] argumento = textoDesdeCLI.split(" ");            
            comandoNombre = argumento[0];
            if(argumento.length>1) 
                comandoParametros = textoDesdeCLI.substring(comandoNombre.length() + 1);
            
            comandoClass = Class.forName(comandoNombre);
            comandoObj = comandoClass.getDeclaredConstructor(String.class).newInstance(comandoParametros);
            //comandoObj = comandoClass.getDeclaredConstructor(new Class[]{String.class}).newInstance(argumento);

            System.out.println("** Comando instanciado:" + comandoObj);
        } catch (ClassNotFoundException ex) {
            System.err.println("Comando no encontrado -----> " + ex.getMessage());
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

    /**
     * @return the consolasalida
     */
    public String getConsolasalida() {
        return consolasalida;
    }

    /**
     * @param consolasalida the consolasalida to set
     */
    public void setConsolasalida(String consolasalida) {
        this.consolasalida = consolasalida;
    }

}
