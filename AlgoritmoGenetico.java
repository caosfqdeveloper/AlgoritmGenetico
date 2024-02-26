//Alumno:Romero Hugo Andres

/*
    Implementar en el lenguaje de programación Java un algoritmo que permita realizar la simulación del algoritmo genético, 
    teniendo en cuenta lo siguiente:

        *Se debe utilizar una función random que genere números aleatorios entre 0 y 1, 
        y la dimensión de la cadena de caracteres debe ser de 20 dígitos.
        *Se debe controlar el número de iteraciones y cruces necesarios para llegar a la solución óptima.
        *El programa debe mostrar por pantalla cada una de cadenas de caracteres aptas encontradas que fueron necesarias 
        para llegar a la solución óptima (cadena óptima).
 */

 import java.util.Random;

 public class AlgoritmoGenetico {
 
     public static void main(String[] args) {
         Random rand = new Random();
         int iteraciones = 0;
         int iteracionesII = 0;
        
         
         

         // Bucle para controlar el número de iteraciones
    while (true) {
        String cadena = generarCadenaAleatoria(rand);
        String cadenaII = generarCadenaAleatoria(rand);
        String cadenaResultante = cruzarCadenas(cadena, cadenaII);
        int aptitud = evaluarAptitud(cadena);
      

        // Mostrar la cadena apta encontrada
        if (aptitud >= 22) {
          
            System.out.println("Resultado de aplicar H(x)=Σx*2= " + aptitud+"fueron necesarias"+iteraciones+"iteraciones"); // Mostrar el resultado de la suma
           
            
            
            iteraciones++; // Incrementar el contador de iteraciones para aptitud >= 22
            
            break;

            
        } else {
            System.out.println("La cadenaResultante debe ser descartada: " + cadenaResultante);
            iteraciones++; // Incrementar el contador de iteraciones para aptitud >= 22
        }

    }

    // Bucle para controlar el número de iteraciones para aptitud >= 40
    while (true) {
        String cadena = generarCadenaAleatoria(rand);
        String cadenaII = generarCadenaAleatoria(rand);
        String cadenaResultante = cruzarCadenas(cadena, cadenaII);
        int aptitudII = evaluarAptitudII(cadenaResultante);

        // Mostrar la cadena apta encontrada
        if (aptitudII >= 40) {
            System.out.println("Primer cadena de 20 caracteres para que H(x)=40: " + cadena);
            System.out.println("Segunda cadena de 20 caracteres para que H(x)=40 : " + cadenaII);
            System.out.println("cadenaResultante: " + cadenaResultante);
            System.out.println("Resultado de aplicar a la cadenaReultante H(x)=Σx*2= " + aptitudII + " ¡¡¡El resultado obtenido fue más apto!!!"); 
            iteracionesII++; // Incrementar el contador de iteraciones para aptitud >= 40
            
            break;
        } else {
            System.out.println("La cadenaResultante debe ser descartada: " + cadenaResultante);
            iteracionesII++; // Incrementar el contador de iteraciones para aptitud >= 40
        }
    }

    // Mostrar el número total de iteraciones necesarias
    System.out.println("Número de iteraciones necesarias para aptitud >= 22: " + iteraciones);
    System.out.println("Número de iteraciones necesarias para aptitud >= 40: " + iteracionesII);


     // Calcular el número de cruces aptos
     int numCruces = calcularNumeroCruces(iteraciones, iteracionesII);
     System.out.println("Número de cruces aptos: " + numCruces);
}


 
     // Método para generar una cadena aleatoria de 20 dígitos
     private static String generarCadenaAleatoria(Random rand) {
         StringBuilder cadena = new StringBuilder();
         for (int i = 0; i < 20; i++) {
             double randomValue = rand.nextDouble();
             int digito = (randomValue < 0.5) ? 0 : 1;
             cadena.append(digito);
         }
         return cadena.toString();
     }
 
     // Método para evaluar la aptitud de una cadena
     private static int evaluarAptitud(String cadena) {
         int suma = 0;
         for (int i = 0; i < cadena.length(); i++) {
             int digito = cadena.charAt(i) - '0'; // Convertir el carácter en un número restando el valor ASCII de '0'
             suma += digito * 2; // Multiplicar el número por 2 y sumarlo
         }
         return suma;
     }

  // Método para cruzar dos cadenas
private static String cruzarCadenas(String cadena, String cadenaII) {
    String cadenaResultante = "";
    
    for (int i = 0; i < cadena.length(); i++) {
        char digitoCadenaI = cadena.charAt(i);
        char digitoCadenaII = cadenaII.charAt(i);

        // Aplicar la regla del cruce
        if (digitoCadenaI == digitoCadenaII) {
            cadenaResultante += '1';
        } else {
            cadenaResultante += '0';
        }
    }
    return cadenaResultante;
}
  // Método para evaluar la aptitud de una cadena
  private static int evaluarAptitudII(String cadenaResultante) {
    int sumaII = 0;
    for (int i = 0; i < cadenaResultante.length(); i++) {
        int digito = cadenaResultante.charAt(i) - '0'; // Convertir el carácter en un número restando el valor ASCII de '0'
        sumaII += digito * 2; // Multiplicar el número por 2 y sumarlo
    }
    return sumaII;
}
 // Método para calcular el número de cruces
 private static int calcularNumeroCruces(int iteraciones, int iteracionesII) {
    return iteracionesII - iteraciones;
}

 }
 
 
    