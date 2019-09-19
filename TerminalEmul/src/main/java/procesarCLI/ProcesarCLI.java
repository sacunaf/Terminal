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
    private String consolaSalida;

    private CommandLineParser parser = null;
    private CommandLine cmdLine = null;
    private Options options;

    public ProcesarCLI(String textoDesdeCLI) {
        System.out.println("Entrando a ProcesarCLI()");
        try {
            String[] argumento = textoDesdeCLI.split(" ");
            
            comandoNombre = argumento[0];
            comandoClass = Class.forName(comandoNombre);
            
            if (argumento.length > 1) {    // Si tiene paramatros llamo al constructor con parametro String
                comandoParametros = textoDesdeCLI.substring(comandoNombre.length() + 1);
                comandoObj = comandoClass.getDeclaredConstructor(String.class).newInstance(comandoParametros);
            } else {                       // No tiene paramatros llamo al constructor sin parametros
                comandoParametros = "";
                comandoObj = comandoClass.getDeclaredConstructor().newInstance();
            }

            anexarAConsolaSalida("** Comando instanciado:" + comandoObj);
            
        } catch (ClassNotFoundException ex) {
            anexarAConsolaSalida("Comando no encontrado ");
        } catch (Exception ex) {
            anexarAConsolaSalida("Error en " + ex);
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

    public String ejecutar() {
        String textoSalida = "";

        return getConsolaSalida();
    }

    /**
     * @return the consolaSalida
     */
    public String getConsolaSalida() {
        return consolaSalida;
    }

    /**
     * @param consolaSalida the consolaSalida to set
     */
    public void setConsolaSalida(String consolaSalida) {
        this.consolaSalida = consolaSalida;
    }

    public void anexarAConsolaSalida(String consolaSalida) {
        
        this.consolaSalida = this.consolaSalida + consolaSalida;
    }

}
