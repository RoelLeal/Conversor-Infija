package conversor.conversornotacion;

import java.util.ArrayList; // ARREGLO DINAMICO
import java.util.Stack; //PREFIJA A POSTFIJA

public class ConversorNotacion {
    
    public static int tope = -1;
    public static Stack<Character> pila = new Stack<>();
    public static ArrayList<Character> arreglo = new ArrayList<>();
    
    public static void main(String[] args) {
        
        String expresion = "(6+4)*8(7+4)";
        
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
        if(!pila.isEmpty()) {
           arreglo.add(pila.pop());
        }
        for(int i = 0; i < arreglo.size(); i++) {
            System.out.print(arreglo.get(i));
        }
    }
    
    public static void vaciarPila() {
        while(!pila.isEmpty()) {
            char valor = pila.pop();
            if(valor == '(') {
                tope = -1;
                break;
            }else {
                arreglo.add(valor);
            }
        }
    }
}