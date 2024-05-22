import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class App {

    static HashMap<Character, Character> dicCifrar = new HashMap<>();
    static HashMap<Character, Character> dicDescifrar = new HashMap<>();
    static String RUTA = "";
    static Scanner SC = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
       
        cargarDatos();

        boolean salir = false;
        while(!salir){

            int decision = SC.nextInt();

            switch (decision) {
                case 1:
                    cifrar();
                    break;
                case 2:
                    descifrar();
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    break;
            }
        }
    }

    public static void cifrar(){
        String palabra = SC.next().toUpperCase();

        char [] letras = palabra.toCharArray();
        String solucion = "";
        for(char letra : letras){

            if(dicCifrar.containsKey(letra)){
                char aux = dicCifrar.get(letra);
                solucion += aux;
            }
            else{
                solucion += letra;
            }

        }
        pasarFichero(palabra, solucion);
        System.out.println(solucion);

    }

    public static void descifrar(){
        String palabra = SC.next();

        char [] letras = palabra.toCharArray();
        String solucion = "";
        for(char letra : letras){

            if(dicCifrar.containsKey(letra)){
                char aux = dicDescifrar.get(letra);
                solucion += aux;
            }
            else{
                solucion += letra;
            }

        }
        pasarFichero(palabra, solucion);
        System.out.println(solucion);

    }

    public static void descifrar2(){
        String palabra = SC.next().toUpperCase();

        char [] letras = palabra.toCharArray();
        String solucion = "";
        for(char letra : letras){

           if(dicCifrar.values().contains(letra)){
                for(Entry<Character, Character> entry : dicCifrar.entrySet()){
                    if(entry.getValue().equals(letra)){
                        char aux = entry.getKey();
                        solucion += aux;
                    }
                }
            }
            else{
                solucion += letra;
            }
        }
        
        pasarFichero(palabra, solucion);
        System.out.println(solucion);

    }

    public static void cargarDatos(){
        try {
            
            File f = new File(RUTA);
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);

            String aux = bf.readLine();

            while (aux != null){
                Character a1 = aux.charAt(0);
                Character a2 = aux.charAt(2);

                String [] array = aux.split("#");
                a1 = array[0].charAt(0);
                a2 = array[1].charAt(0);

                dicCifrar.put(a1, a2);
                dicDescifrar.put(a2, a1);

                aux = bf.readLine();
            }

            bf.close();
            

        } catch (Exception e) {     
        }
    }

    public static void pasarFichero(String cifrado, String descifrado){

        try {
            File f = new File(""); 

            FileWriter fw = new FileWriter(f, true);
            BufferedWriter bw = new BufferedWriter(fw);

            String sol = "[CIFRADO]" + cifrado + " [DESCIFRADO]" + descifrado + "\n";

            bw.write(sol);

        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
