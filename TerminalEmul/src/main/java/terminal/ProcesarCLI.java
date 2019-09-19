package terminal;

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

    ProcesarCLI(String lineaTextoIngresada) {
        try {
            parser = new BasicParser();
            cmdLine = parser.parse(options, lineaTextoIngresada.split(" "));
            
            // Si está la opcion de ayuda, la imprimimos y salimos.
            if (cmdLine.hasOption("h")){    // No hace falta preguntar por el parámetro "help". Ambos son sinónimos
                new HelpFormatter().printHelp(CliApp.class.getCanonicalName(), options );
                return;  
            }
        } catch (ParseException ex) {
            Logger.getLogger(ProcesarCLI.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }

    public String ejecutar() {
        String textoSalida = "";

        return textoSalida;
    }

}
