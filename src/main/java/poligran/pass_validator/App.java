// Import libraries
package poligran.pass_validator;
import java.util.Scanner;

/**
 * Main class
 */
public class App 
{
    public static void main( String[] args )
    {   
        // Define variables
        Scanner input = new Scanner(System.in);
        String pass = "";

        // Catch pass
        System.out.println( "--------------------------------------------" );
        System.out.println( "| Ingrese su clave                         |" );
        System.out.println( "--------------------------------------------" );
        pass = input.next();

        // Print
        System.out.println( "El score de su contraseña " + pass + " es de: " + passValidator(pass) + "/100" );
    }

    
    /**
     * Function to validate pass
     * @param pass
     * @return pass score
     */
    public static int passValidator(String pass) {
        // Define variables
        int score = 100;

        /* Conditional to calculate pass score */
        if (pass.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[\\^\\+\\-\\_\\*\\.\\!\\¡\\@\\#\\$\\%\\&\\(\\)\\[\\]])([A-Za-z0-9\\^\\+\\-\\_\\*\\.\\!\\¡\\@\\#\\$\\%\\&\\(\\)\\[\\]]){12,}$")) {
            score -= 0;
        }
        else if (pass.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[\\^\\+\\-\\_\\*\\.\\!\\¡\\@\\#\\$\\%\\&\\(\\)\\[\\]])([A-Za-z0-9\\^\\+\\-\\_\\*\\.\\!\\¡\\@\\#\\$\\%\\&\\(\\)\\[\\]]){8,}$")) {
            score -= 10;
        }
        else if (pass.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[\\+])(?=.*[0-9])([A-Za-z0-9]){12,}$")) {
            score -= 20;
        }
        else if (pass.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[\\+])(?=.*[0-9])([A-Za-z0-9]){8,}$")) {
            score -= 40;
        }
        else if (pass.matches("^(?=.*[A-Z])(?=.*[a-z])([A-Za-z]){8,}$")) {
            score -= 60;
        }
        else if (pass.matches("^(?=.*[A-Z])(?=.*[a-z])([A-Za-z]){6,}$")) {
            score -= 70;
        }
        else if (pass.matches("^([A-Za-z0-9]){6,}$")) {
            score -= 80;
        }
        else if (pass.length() < 6) {
            score -= 90;
        }
        else {
            score -= 100;
        }        

        // Return
        return score;
    }
}
