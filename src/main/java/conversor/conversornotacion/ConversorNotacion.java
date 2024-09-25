package conversor.conversornotacion;

import java.util.ArrayList; // ARREGLO DINAMICO
import java.util.Collections;
import java.util.Stack; //PREFIJA A POSTFIJA

public class ConversorNotacion {
    
    public static Stack<Character> pila = new Stack<>();
    public static Stack<Character> pilaPre = new Stack<>();

    public static ArrayList<Character> arreglo = new ArrayList<>();
    public static ArrayList<Character> arregloPre = new ArrayList<>();
    
    public static String expresion = "(6+4)*8(7+4)";
    //public static String expresion = "2+(3*4)";
    
    public static void main(String[] args) {
        
        for(int i = 0; i < expresion.length(); i++) {
            char valor = expresion.charAt(i);
            switch(valor) {
                case '+' -> {
                    pila.push('+');
                }
                case '-' -> {
                    pila.push('-');
                }
                case '/' -> {
                    pila.push('/');
                }
                case '*' -> {
                    pila.push('*');
                }
                case '(' -> {
                    pila.push('(');
                }
                case ')' -> {
                    vaciarPila();
                }
                default -> {
                    arreglo.add(valor);
                }
            }
        }
        while(!pila.isEmpty()) {
           arreglo.add(pila.pop());
        }
        System.out.println("PostFija: ");
        for(int i = 0; i < arreglo.size(); i++) {
            System.out.print(arreglo.get(i));
        }
        System.out.println("");
        prefijo();
    }
    
    public static void vaciarPila() {
        while(!pila.isEmpty()) {
            char valor = pila.pop();
            if(valor == '(') {
                break;
            }else {
                arreglo.add(valor);
            }
        }
    }
    
    public static void prefijo() {
        StringBuilder strb = new StringBuilder(expresion);
        strb.reverse().toString();
        
        for(int i = 0; i < expresion.length(); i++) {
            char valor = strb.charAt(i);
            switch(valor) {
                case '+' -> {
                    pilaPre.push('+');
                }
                case '-' -> {
                    pilaPre.push('-');
                }
                case '/' -> {
                    pilaPre.push('/');
                }
                case '*' -> {
                    pilaPre.push('*');
                }
                case '(' -> {
                    vaciarPilaPrefija();
                }
                case ')' -> {
                    pilaPre.push(')');
                }
                default -> {
                    arregloPre.add(valor);
                }
            }
        }
        while(!pilaPre.isEmpty()) {
           arregloPre.add(pilaPre.pop());
        }
        Collections.reverse(arregloPre);
        System.out.println("Prefija: ");
        for(int i = 0; i < arregloPre.size(); i++) {
            System.out.print(arregloPre.get(i));
        }
    }
    
    public static void vaciarPilaPrefija() {
        while(!pilaPre.isEmpty()) {
            char valor = pilaPre.pop();
            if(valor == ')') {
                break;
            }else {
                arregloPre.add(valor);
            }
        }
    }
}