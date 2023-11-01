package ia.garam;
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Garam {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tablero tablero;
        long inicio;
        long fin;
        long tiempoTranscurrido;

        while (true) {
            // Menú de inicio
            System.out.println("Menu de seleccion de nivel:");
            System.out.println("1. Tutorial");
            System.out.println("2. Beginner");
            System.out.println("3. Easy");
            System.out.println("4. Medium");
            System.out.println("5. Confirmed");
            System.out.println("6. Advanced");
            System.out.println("7. Difficult");
            System.out.println("8. Very Difficult");
            System.out.println("9. Expert");
            System.out.println("10. Fiendish");
            System.out.println("11. Master");
            System.out.println("12. Custom (Ingreso por teclado)");
            System.out.println("0. Salir");

            int opcion = scanner.nextInt();

            if (opcion == 0) {
                break; // Salir del programa
            } else if (opcion >= 1 && opcion <= 12) {
                // Seleccionar el nivel del tablero
                tablero = seleccionarNivel(opcion);
                if (tablero != null) {
                    System.out.println("Estado Inicial del Nivel " + opcion + ":");
                    inicio = System.currentTimeMillis();
                    resolverTablero(tablero);
                    fin = System.currentTimeMillis();
                    tiempoTranscurrido = fin - inicio;
                    System.out.println("Tiempo de ejecucion: " + tiempoTranscurrido + " milisegundos");
                    try {
                        // Agrega un retraso de 1000 milisegundos (1 segundo)
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                       System.out.println("hubo un error, terminando programa");
                    }
                }
            } else {
                System.out.println("Opción no válida. Introduce un número del 1 al 12 o 0 para salir.");
            }
        }
    }

    public static Tablero seleccionarNivel(int opcion) {
        switch (opcion) {
            case 1:
                return new Tablero(6, '+', 1, -1, '+', '+', 6, -1, 1, 1, 2, 'x', 2, 4, -1,
                                        '+', 3, -1, 'x', 'x', -1, 2, 1, -1, 4, '-', -1, -1, -1, 
                                        '+', -1, 9, '+', '+', 9, -1, -1, 1, -1, '+', 7, -1, -1, 
                                        '+', -1, -1, 'x', 'x', -1, -1, 2, 2, -1, 'x', -1, -1, 'x', 1, '+', 5, 'x', 1, '-', 1);
            case 2:
                return new Tablero(-1, '-', 1, -1, 'x', '+', 6, 5, -1, 1, -1, '-', -1, 2,
                                         -1, '-', 1, -1, '+', 'x', -1, 5, 1, -1, 1, '+', -1, -1,
                                         -1, '-', -1, -1, 'x', 'x', -1, -1, -1, 3, -1, '-', 1, -1,
                                        -1, '-', -1, -1, 'x', 'x', -1, 9, 6, 1, 3, '+', 5, -1,
                                        '+', 2, '-', 1, '+', 3, '-', 1);
            case 3:
                return new Tablero(-1, '+', 2, -1, 'x', '+', 3, -1, -1, 1, -1, '-', -1, 0,
                                    -1, '-', 5, -1, 'x', 'x', -1, 8, 1, 1, -1, '+', -1, -1,
                                    -1, '-', -1, 3, 'x', 'x', 7, -1, -1, -1, -1, '-', 1, -1,
                                    9, '-', -1, -1, 'x', 'x', -1, -1, -1, 1, -1, '+', -1, -1,
                                    '+', 1, '+', 3, '+', 1, '-', 4);
            case 4:
                return new Tablero(-1, '+', 2, -1, '+', 'x', -1, -1, -1, 1, 4, '-', -1, -1,
                                 -1, '+', 4, -1, 'x', 'x', -1, -1, 3, 1, -1, '+', -1, -1,
                                 -1, '+', -1, -1, 'x', '+', 4, -1, 3, -1, -1, 'x', -1, 4,
                                  -1, '-', -1, -1, '+', '+', -1, -1, -1, -1, 5, '-', -1, -1,
                                  'x', 3, 'x', 3, '-', 3, '+', 3);
            case 5:
                return new Tablero(-1,'-',-1,-1,'+','x',-1,-1,-1,2,-1,'-',-1,-1,
                                3,'-',-1,-1,'+','x',-1,4,-1,-1,-1,'x',-1,-1,
                                6,'+',-1,-1,'+','x',-1,-1,-1,1,-1,'+',3,-1,
                                6,'-',-1,-1,'x','x',-1,-1,-1,2,-1,'+',-1,-1,
                                '-',-1,'-',4,'-',2,'-',1);
            case 6:
                return new Tablero(-1, '+', -1, -1, '+', '+', 6, -1, -1, -1, -1, 'x', -1, -1,
                                        -1, '-', 2, -1, 'x', 'x', -1, -1, 2, -1, -1, 'x', -1, -1,
                                        -1, '+', -1, -1, '+', 'x', -1, -1, -1, 1, -1, 'x', -1, -1,
                                        -1, '+', -1, -1, '+', '+', -1, -1, -1, -1, -1, '-', 2, -1,
                                        '+', 6, '-', 3, '-', 1, '-', 6);
            case 7:
                return new Tablero(-1,'+',4,-1,'x','x',-1,-1,-1,-1,-1,'+',-1,-1,
                                -1,'+',6,-1,'x','+',-1,-1,-1,-1,-1,'x',-1,-1,
                                -1,'x',-1,-1,'x','+',-1,-1,2,-1,-1,'-',3,-1,
                                -1,'+',-1,-1,'x','+',-1,-1,1,-1,-1,'-',3,-1,
                                'x',-1,'x',2,'-',6,'x',2);
            case 8:
                return new Tablero(-1,'+',-1,-1,'x','x',-1,-1,4,4,-1,'+',-1,-1,
                                    -1,'+',6,-1,'+','x',-1,6,-1,-1,-1,'x',-1,-1,
                                    -1,'-',-1,-1,'x','+',-1,-1,3,-1,-1,'x',3,-1,
                                    -1,'-',-1,-1,'x','x',-1,-1,2,-1,-1,'x',7,-1,
                                    '+',-1,'-',4,'+',1,'+',-1);
            case 9:
                return new Tablero(-1, '+', 5, -1, 'x', 'x', 5, -1, -1, -1, -1, '-', -1, -1,
                                        -1, '-', 2, -1, '+', 'x', -1, -1, -1, 2, -1, '-', -1, -1,
                                        -1, '+', -1, -1, '+', 'x', -1, -1, -1, 2, -1, '-', -1, -1,
                                        -1, '+', -1, -1, '+', 'x', -1, -1, -1, 2, -1, '-', -1, -1,
                                        '-', 1, 'x', 1, '+', 4, '+', 1);
            case 10:
                return new Tablero(-1, '+', 0, -1, '+', 'x', 8, -1, -1, -1, -1, '+', -1, -1,
                                 -1, '-', 1, -1, '+', 'x', -1, 7, -1, -1, -1, '+', -1, -1,
                                 -1, '-', -1, -1, 'x', 'x', -1, -1, -1, 4, -1, '+', 7, -1,
                                  -1, '-', -1, -1, 'x', '+', -1, 4, -1, -1, -1, '+', 0, -1,
                                  '+', 4, '-', 1, '-', 1, '-', 1);
            case 11:
                return new Tablero(-1, '+', 4, -1, '+', 'x', -1, -1, -1, -1, -1, '-', -1, -1,
                                        -1, '-', 1, -1, '+', 'x', -1, -1, -1, 4, -1, '-', -1, -1,
                                        -1, '+', -1, -1, '+', 'x', -1, -1, -1, -1, -1, '-', 5, -1,
                                        -1, '-', -1, -1, '+', 'x', -1, -1, -1, 2, -1, 'x', 8, -1,
                                        '+', 1, '-', 2, '-', 3, '+', 3);
            case 12:
                return new Tablero();
            default:
                return null; // En caso de opción no válida
        }
    }
    
    public static void resolverTablero(Tablero t){
        t.printTablero();
        System.out.println("");
        Resolver resolución = new Resolver(t);
        System.out.println("Estado Final:");
        t.printTablero();
    }
}
    

// Primero definimos cada Cuadrado del Garam
class Cuadrado {
    boolean fijo;
    int numero;

    public Cuadrado() {
        this.fijo = false;
        this.numero = -1;
    }

    public Cuadrado(int numero) {
        this.fijo = true;
        this.numero = numero;
    }

    public boolean getFijo() {
        return fijo;
    }

    public void setFijo(boolean a) {
        fijo = a;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int a) {
        numero = a;
    }
    
    public String toString() {
        if (numero != -1) {
            return Integer.toString(numero);
        } else {
            return "?";
        }
    }
}

// Tambien definimos cada Signo
class Signo {
    char signo;

    public Signo(char signo) {
        this.signo = signo;
    }
    
    public Signo(){
        this.signo = '_';
    }

    public char getSigno() {
        return signo;
    }

    public void setSigno(char a) {
        signo = a;
    }
    
    public String toString() {
        return String.valueOf(signo);
    }
}

// La clase Conjunto es la clase Padre de Filas y Columnas
class Conjunto {
    protected int heuristica;
    protected boolean resuelto;
    Conjunto vecino1;
    Conjunto vecino2;
    Conjunto vecino3;

    public int getHeuristica() {
        return heuristica;
    }
    
    public boolean getResuelto(){
        return resuelto;
    }
    
    public void setResuelto(boolean r){
        resuelto = r;
    }
    
    public Conjunto getVecino1(){
        return vecino1;
    }
    
    public Conjunto getVecino2(){
        return vecino2;
    }
    
    public Conjunto getVecino3(){
        return vecino3;
    }
    
    public void setVecino1(Conjunto v1){
        vecino1 = v1;
    }
    
    public void setVecino2(Conjunto v2){
        vecino2 = v2;
    }
    
    public void setVecino3(Conjunto v3){
        vecino3 = v3;
    }
    
    public boolean esVecino(Conjunto otro) {
        return this == otro.vecino1 || this == otro.vecino2 || this == otro.vecino3;
    }
    
    public Conjunto obtenerMejorVecino() {
        Conjunto mejorVecino = null;
        int mejorHeuristica = 0; // Inicializamos con un valor bajo

        if (vecino1 != null && vecino1.getHeuristica() > mejorHeuristica) {
            mejorVecino = vecino1;
            mejorHeuristica = vecino1.getHeuristica();
        }

        if (vecino2 != null && vecino2.getHeuristica() > mejorHeuristica) {
            mejorVecino = vecino2;
            mejorHeuristica = vecino2.getHeuristica();
        }

        if (vecino3 != null && vecino3.getHeuristica() > mejorHeuristica) {
            mejorVecino = vecino3;
            mejorHeuristica = vecino3.getHeuristica();
        }

        return mejorVecino;
    }
    
    
    public Cuadrado getCuadrado(int n){
        if(this instanceof Fila fila){
            return switch (n) {
                case 1 -> fila.c1;
                case 2 -> fila.c2;
                default -> fila.c3;
            };
        }
        else if(this instanceof Columna columna){
            return switch (n) {
                case 1 -> columna.c1;
                case 2 -> columna.c2;
                case 3 -> columna.c3;
                default -> columna.c4;
            };
        }
        return null;
    }
    
    public boolean solucionar() {
        if (this instanceof Fila fila) {
            return fila.solucionarFila();
        } else if (this instanceof Columna columna) {
            return columna.solucionarColumna();
        }
        return false; // Manejar otros casos o devolver un valor predeterminado
    }
    
    @Override
    public String toString() {
        if (this instanceof Fila) {
            Fila fila = (Fila) this;
            return "Fila: " + fila.c1 + fila.s + fila.c2 + "=" + fila.c3;
        } else if (this instanceof Columna) {
            Columna columna = (Columna) this;
            return "Columna: " + columna.c1 + columna.s + columna.c2 + columna.s + columna.c3 + columna.s + columna.c4;
        } else {
            return "Heurística: " + heuristica;
        }
    }
    
    public boolean calcularH() {
        if (this instanceof Fila fila) {
            fila.calcularHeuristica();
        } else if (this instanceof Columna columna) {
            columna.calcularHeuristica();
        }
        return false; // Manejar otros casos o devolver un valor predeterminado
    }
    
    public void calcularHeuristicas() {
        calcularH(); // Calcula la heurística para el conjunto actual

        if (vecino1 != null) {
            vecino1.calcularH(); // Calcula la heurística para el vecino 1
        }

        if (vecino2 != null) {
            vecino2.calcularH(); // Calcula la heurística para el vecino 2
        }

        if (vecino3 != null) {
            vecino3.calcularH(); // Calcula la heurística para el vecino 3
        }
    }
}

// Definimos cada Fila
class Fila extends Conjunto {
    Cuadrado c1;
    Signo s;
    Cuadrado c2;
    Cuadrado c3;
    
    public Fila(Cuadrado c1, Signo s, Cuadrado c2, Cuadrado c3){
        this.c1 = c1;
        this.s = s;
        this.c2 = c2;
        this.c3 = c3;
        calcularHeuristica();
    }
    
    public void calcularHeuristica() {
        int numC1 = c1.getNumero();
        int numC2 = c2.getNumero();
        int numC3 = c3.getNumero();
        char op = s.getSigno();

        if (numC1 != -1 && numC2 != -1 && numC3 != -1) {
            heuristica = 10;
        } else if ((numC2 != -1 && numC3 != -1) || (numC1 != -1 && numC3 != -1) || (numC1 != -1 && numC2 != -1))  {
            heuristica = 8;
        } else if ((numC1 != -1 || numC2 != -1 || numC3 != -1) && op == 'x') {
            heuristica = 6;
        } else if ((numC1 != -1 || numC2 != -1 || numC3 != -1)){
            heuristica = 4;
        } else {
            heuristica = 0;
        }
    }
    
    Operar operador = new Operar();
    
    public boolean solucionarFila(){
        if (c1.getNumero() != -1 && c2.getNumero() != -1 && c3.getNumero() != -1) {
            return operarFila();
        }
        else if (c1.getNumero() != -1 && c2.getNumero() != -1 && c3.getNumero() == -1){
            int r = operador.resolverFila(s, c1, c2, null);
            if(r > -1 && r < 10){
                c3.setNumero(r);
                calcularHeuristica();
                if(vecino1!=null){
                    vecino1.calcularH();
                }
                if(vecino2!=null){
                    vecino2.calcularH();
                }
                if(vecino3!=null){
                    vecino3.calcularH();
                }
                if(c1.getFijo() == c2.getFijo() == true){
                    c3.setFijo(true);
                }
                return true;
            }
            else
                return false;
        }
        else if (c1.getNumero() != -1 && c2.getNumero() == -1 && c3.getNumero() != -1){
            int r = operador.resolverFila(s, c1, null, c3);
            if(r > -1 && r < 10){
                c2.setNumero(r);
                calcularHeuristica();
                if(vecino1!=null){
                    vecino1.calcularH();
                }
                if(vecino2!=null){
                    vecino2.calcularH();
                }
                if(vecino3!=null){
                    vecino3.calcularH();
                }
                if(c1.getFijo() == c3.getFijo() == true){
                    c2.setFijo(true);
                }
                return true;
            }
            else
                return false;
        }
        else if (c1.getNumero() == -1 && c2.getNumero() != -1 && c3.getNumero() != -1){
            int r = operador.resolverFila(s, null, c2, c3);
            if(r > -1 && r < 10){
                c1.setNumero(r);
                calcularHeuristica();
                if (vecino1 != null) {
                    vecino1.calcularH();
                }
                if (vecino2 != null) {
                    vecino2.calcularH();
                }
                if (vecino3 != null) {
                    vecino3.calcularH();
                }
                if(c2.getFijo() == c3.getFijo() == true){
                    c1.setFijo(true);
                }
                return true;
            }
            else
                return false;
        }
        else{
            return false;
        }
    }
    
    public boolean operarFila() {
        if (c1.getNumero() != -1 && c2.getNumero() != -1 && c3.getNumero() != -1 && s != null) {
            return operador.operarFila(s, c1, c2, c3);
        }
        return false;
    }
    
    @Override
    public String toString(){
        return this.c1.toString() + this.s.toString() + this.c2.toString() + "=" + this.c3.toString();
    }
}

// También, definimos cada columna
class Columna extends Conjunto {
    Cuadrado c1;
    Signo s;
    Cuadrado c2;
    Cuadrado c3;
    Cuadrado c4;
    
    public Columna(Cuadrado c1, Signo s, Cuadrado c2, Cuadrado c3, Cuadrado c4){
        this.c1 = c1;
        this.s = s;
        this.c2 = c2;
        this.c3 = c3;
        this.c4 = c4;
        calcularHeuristica();
    }
    
    public void calcularHeuristica() {
        int numC1 = c1.getNumero();
        int numC2 = c2.getNumero();
        int numC3 = c3.getNumero();
        int numC4 = c4.getNumero();
        int op = s.getSigno();

        if (numC1 != -1 && numC2 != -1 && numC3 != -1 && numC4 != -1) {
            heuristica = 10;
        } else if ((numC1 != -1 && numC2 != -1) || (numC1 != -1 && numC3 != -1 && numC4 != -1) || (numC2 != -1 && numC3 != -1 && numC4 != -1)) {
            heuristica = 8;
        } else if (((numC1 != -1 && numC3 != -1) || (numC1 != -1 && numC4 != -1) || (numC2 != -1 && numC3 != -1) || (numC2 != -1 && numC4 != -1) || (numC3 != -1 && numC4 != -1)) && op == 'x') {
            heuristica = 7;
        } else if ((numC1 != -1 && numC3 != -1) || (numC1 != -1 && numC4 != -1) || (numC2 != -1 && numC3 != -1) || (numC2 != -1 && numC4 != -1) || (numC3 != -1 && numC4 != -1)){
            heuristica = 5;
        } else if (numC1 != -1 || numC2 != -1 || numC3 != -1 || numC4 != -1) {
            heuristica = 2;
        } else {
            heuristica = 0;
        }
    }
    
    Operar operador = new Operar();
    
        public boolean solucionarColumna(){
            if (c1.getNumero() != -1 && c2.getNumero() != -1 && c3.getNumero() != -1 && c4.getNumero() != -1){
                return operarColumna();
            }
            else if (c1.getNumero() != -1 && c2.getNumero() == -1 && c3.getNumero() != -1 && c4.getNumero() != -1){
                int r = operador.resolverColumna(s, c1, null, c3, c4);
                if(r != -1){
                    c2.setNumero(r);
                    calcularHeuristica();
                    if(vecino1!=null){
                        vecino1.calcularH();
                    }
                    if(vecino2!=null){
                        vecino2.calcularH();
                    }
                    if(vecino3!=null){
                        vecino3.calcularH();
                    }
                    if(c1.getFijo() == c3.getFijo() == c4.getFijo() == true)
                        c2.setFijo(true);
                    return true;
                }
                return false;
            }
            else if (c1.getNumero() == -1 && c2.getNumero() != -1 && c3.getNumero() != -1 && c4.getNumero() != -1){
                int r = operador.resolverColumna(s, null, c2, c3, c4);
                if(r != -1){
                    c1.setNumero(r);
                    calcularHeuristica();
                    if(vecino1!=null){
                        vecino1.calcularH();
                    }
                    if(vecino2!=null){
                        vecino2.calcularH();
                    }
                    if(vecino3!=null){
                        vecino3.calcularH();
                    }
                    if(c2.getFijo() == c3.getFijo() == c4.getFijo() == true)
                        c1.setFijo(true);
                    return true;
                }
                return false;
            }
            else if (c1.getNumero() != -1 && c2.getNumero() != -1 && c3.getNumero() == -1 && c4.getNumero() == -1){
                int r = operador.resolverColumna(s, c1, c2, null, null);
                if(r != -1){
                    c3.setNumero(r/10%10);
                    c4.setNumero(r%10);
                    calcularHeuristica();
                    if(vecino1!=null){
                        vecino1.calcularH();
                    }
                    if(vecino2!=null){
                        vecino2.calcularH();
                    }
                    if(vecino3!=null){
                        vecino3.calcularH();
                    }
                    if(c1.getFijo() == c2.getFijo()){
                        c3.setFijo(true);
                        c4.setFijo(true);
                    }
                    return true;
                }
                return false;
                
            }
            else if (c1.getNumero() != -1 && c2.getNumero() != -1 && c3.getNumero() == -1 && c4.getNumero() != -1){
                int r = operador.resolverColumna(s, c1, c2, null, c4);
                if(r != -1){
                    c3.setNumero(r);
                    calcularHeuristica();
                    if(vecino1!=null){
                        vecino1.calcularH();
                    }
                    if(vecino2!=null){
                        vecino2.calcularH();
                    }
                    if(vecino3!=null){
                        vecino3.calcularH();
                    }
                    if(c1.getFijo() == c2.getFijo()){
                        c3.setFijo(true);
                        c4.setFijo(true);
                    }
                    return true;
                }
                return false;
            }
            else if (c1.getNumero() != -1 && c2.getNumero() != -1 && c3.getNumero() != -1 && c4.getNumero() == -1){
                int r = operador.resolverColumna(s, c1, c2, c3, null);
                if(r != -1){
                    c4.setNumero(r);
                    calcularHeuristica();
                    if(vecino1!=null){
                        vecino1.calcularH();
                    }
                    if(vecino2!=null){
                        vecino2.calcularH();
                    }
                    if(vecino3!=null){
                        vecino3.calcularH();
                    }
                    if(c1.getFijo() == c2.getFijo()){
                        c3.setFijo(true);
                        c4.setFijo(true);
                    }
                    return true;
                }   
                return false;
            }
            else{
                return false;
            }
        }
        
    public boolean operarColumna() {
        if (c1.getNumero() != -1 && c2.getNumero() != -1 && c3.getNumero() != -1 && c4.getNumero() != -1 && s != null) {
            return operador.operarColumna(s, c1, c2, c3, c4);
        }
        return false;
    }
    
    @Override
    public String toString(){
        return this.c1.toString() + this.s.toString() + this.c2.toString() + "=" + this.c3.toString() + this.c4.toString();
    }

}

// El sector corresponde a cada sección cuadrada dentro del Garam
class Sector{
    Fila f1;
    Fila f2;
    Columna c1;
    Columna c2;
    
    public Sector(Fila f1, Fila f2, Columna c1, Columna c2) {
        this.f1 = f1;
        this.f2 = f2;
        this.c1 = c1;
        this.c2 = c2;
    }
    
    public Fila getF1(){
        return f1;
    }
    public Fila getF2(){
        return f2;
    }
    public Columna getC1(){
        return c1;
    }
    public Columna getC2(){
        return c2;
    }

    public boolean comprobar(){

        // Realiza la operación de la fila 1.
        boolean resultadoFila1 = f1.operarFila();

        // Realiza la operación de la fila 6.
        boolean resultadoFila2 = f2.operarFila();

        // Realiza la operación de la columna 1.
        boolean resultadoColumna1 = c1.operarColumna();

        // Realiza la operación de la columna 5.
        boolean resultadoColumna2 = c2.operarColumna();

        // Comprueba si los resultados son correctos.
        return resultadoFila1 && resultadoFila2 && resultadoColumna1 && resultadoColumna2;
    }
    
    Operar operador = new Operar();
    
    public boolean solucionarFila1(){
        return f1.solucionarFila();
    }
    
    public boolean operarFila1() {
        return f1.operarFila();
    }
    
    public boolean solucionarFila2() {
        return f2.solucionarFila();
    }

    public boolean operarFila2() {
        return f2.operarFila();
    }
    
    public boolean solucionarColumna1(){
        return c1.solucionarColumna();
    }

    public boolean operarColumna1() {
        return c1.operarColumna();
    }
    
    public boolean solucionarColumna2() {
        return c2.solucionarColumna();
    }

    public boolean operarColumna2() {
        return c2.operarColumna();
    }
}

// Corresponde al tablero completo del juego
class Tablero{
    Cuadrado c1_1_1;
    Signo s1_2_1;
    Cuadrado c1_3_1;
    Cuadrado c1_5_1;
    Signo s2_1_1;
    Signo s2_5_1;
    Cuadrado c3_1_1;
    Cuadrado c3_5_1;
    Cuadrado c5_1_1;
    Cuadrado c5_5_1;
    Cuadrado c6_1_1;
    Signo s6_2_1;
    Cuadrado c6_3_1;
    Cuadrado c6_5_1; 
    
    Cuadrado c1_1_2 ;
    Signo s1_2_2 ;
    Cuadrado c1_3_2;
    Cuadrado c1_5_2;
    Signo s2_1_2 ;
    Signo s2_5_2 ;
    Cuadrado c3_1_2;
    Cuadrado c3_5_2;
    Cuadrado c5_1_2;
    Cuadrado c5_5_2;
    Cuadrado c6_1_2;
    Signo s6_2_2;
    Cuadrado c6_3_2;
    Cuadrado c6_5_2;
    
    Cuadrado c1_1_3;
    Signo s1_2_3;
    Cuadrado c1_3_3;
    Cuadrado c1_5_3;
    Signo s2_1_3;
    Signo s2_5_3;
    Cuadrado c3_1_3;
    Cuadrado c3_5_3;
    Cuadrado c5_1_3;
    Cuadrado c5_5_3;
    Cuadrado c6_1_3;
    Signo s6_2_3;
    Cuadrado c6_3_3;
    Cuadrado c6_5_3;
    
    Cuadrado c1_1_4;
    Signo s1_2_4;
    Cuadrado c1_3_4;
    Cuadrado c1_5_4;
    Signo s2_1_4;
    Signo s2_5_4;
    Cuadrado c3_1_4;
    Cuadrado c3_5_4;
    Cuadrado c5_1_4;
    Cuadrado c5_5_4;
    Cuadrado c6_1_4;
    Signo s6_2_4;
    Cuadrado c6_3_4;
    Cuadrado c6_5_4;
    Signo p1_2s; 
    Cuadrado p1_2c;
    Signo p1_3s;
    Cuadrado p1_3c;
    Signo p2_4s;
    Cuadrado p2_4c;
    Signo p3_4s;
    Cuadrado p3_4c;
    
    Sector sector1;
    Sector sector2;
    Sector sector3;
    Sector sector4;
    
    Fila puente1_2;
    Fila puente1_3;
    Fila puente2_4;
    Fila puente3_4;
    
    public Tablero(int c1_1_1, char s1_2_1, int c1_3_1, int c1_5_1, char s2_1_1, char s2_5_1,
                   int c3_1_1, int c3_5_1, int c5_1_1, int c5_5_1, int c6_1_1, char s6_2_1, int c6_3_1, int c6_5_1,
                   int c1_1_2, char s1_2_2, int c1_3_2, int c1_5_2, char s2_1_2, char s2_5_2,
                   int c3_1_2, int c3_5_2, int c5_1_2, int c5_5_2, int c6_1_2, char s6_2_2, int c6_3_2, int c6_5_2,
                   int c1_1_3, char s1_2_3, int c1_3_3, int c1_5_3, char s2_1_3, char s2_5_3,
                   int c3_1_3, int c3_5_3, int c5_1_3, int c5_5_3, int c6_1_3, char s6_2_3, int c6_3_3, int c6_5_3,
                   int c1_1_4, char s1_2_4, int c1_3_4, int c1_5_4, char s2_1_4, char s2_5_4,
                   int c3_1_4, int c3_5_4, int c5_1_4, int c5_5_4, int c6_1_4, char s6_2_4, int c6_3_4, int c6_5_4,
                   char p1_2s, int p1_2c, char p1_3s, int p1_3c, char p2_4s, int p2_4c, char p3_4s, int p3_4c){
        this.c1_1_1 = c1_1_1 < 0 ? new Cuadrado() : new Cuadrado(c1_1_1);
        this.s1_2_1 = new Signo(s1_2_1);
        this.c1_3_1 = c1_3_1 < 0 ? new Cuadrado() : new Cuadrado(c1_3_1);
        this.c1_5_1 = c1_5_1 < 0 ? new Cuadrado() : new Cuadrado(c1_5_1);
        this.s2_1_1 = new Signo(s2_1_1);
        this.s2_5_1 = new Signo(s2_5_1);
        this.c3_1_1 = c3_1_1 < 0 ? new Cuadrado() : new Cuadrado(c3_1_1);
        this.c3_5_1 = c3_5_1 < 0 ? new Cuadrado() : new Cuadrado(c3_5_1);
        this.c5_1_1 = c5_1_1 < 0 ? new Cuadrado() : new Cuadrado(c5_1_1);
        this.c5_5_1 = c5_5_1 < 0 ? new Cuadrado() : new Cuadrado(c5_5_1);
        this.c6_1_1 = c6_1_1 < 0 ? new Cuadrado() : new Cuadrado(c6_1_1);
        this.s6_2_1 = new Signo(s6_2_1);
        this.c6_3_1 = c6_3_1 < 0 ? new Cuadrado() : new Cuadrado(c6_3_1);
        this.c6_5_1 = c6_5_1 < 0 ? new Cuadrado() : new Cuadrado(c6_5_1);
        this.c1_1_2 = c1_1_2 < 0 ? new Cuadrado() : new Cuadrado(c1_1_2);
        this.s1_2_2 = new Signo(s1_2_2);
        this.c1_3_2 = c1_3_2 < 0 ? new Cuadrado() : new Cuadrado(c1_3_2);
        this.c1_5_2 = c1_5_2 < 0 ? new Cuadrado() : new Cuadrado(c1_5_2);
        this.s2_1_2 = new Signo(s2_1_2);
        this.s2_5_2 = new Signo(s2_5_2);
        this.c3_1_2 = c3_1_2 < 0 ? new Cuadrado() : new Cuadrado(c3_1_2);
        this.c3_5_2 = c3_5_2 < 0 ? new Cuadrado() : new Cuadrado(c3_5_2);
        this.c5_1_2 = c5_1_2 < 0 ? new Cuadrado() : new Cuadrado(c5_1_2);
        this.c5_5_2 = c5_5_2 < 0 ? new Cuadrado() : new Cuadrado(c5_5_2);
        this.c6_1_2 = c6_1_2 < 0 ? new Cuadrado() : new Cuadrado(c6_1_2);
        this.s6_2_2 = new Signo(s6_2_2);
        this.c6_3_2 = c6_3_2 < 0 ? new Cuadrado() : new Cuadrado(c6_3_2);
        this.c6_5_2 = c6_5_2 < 0 ? new Cuadrado() : new Cuadrado(c6_5_2);
        this.c1_1_3 = c1_1_3 < 0 ? new Cuadrado() : new Cuadrado(c1_1_3);
        this.s1_2_3 = new Signo(s1_2_3);
        this.c1_3_3 = c1_3_3 < 0 ? new Cuadrado() : new Cuadrado(c1_3_3);
        this.c1_5_3 = c1_5_3 < 0 ? new Cuadrado() : new Cuadrado(c1_5_3);
        this.s2_1_3 = new Signo(s2_1_3);
        this.s2_5_3 = new Signo(s2_5_3);
        this.c3_1_3 = c3_1_3 < 0 ? new Cuadrado() : new Cuadrado(c3_1_3);
        this.c3_5_3 = c3_5_3 < 0 ? new Cuadrado() : new Cuadrado(c3_5_3);
        this.c5_1_3 = c5_1_3 < 0 ? new Cuadrado() : new Cuadrado(c5_1_3);
        this.c5_5_3 = c5_5_3 < 0 ? new Cuadrado() : new Cuadrado(c5_5_3);
        this.c6_1_3 = c6_1_3 < 0 ? new Cuadrado() : new Cuadrado(c6_1_3);
        this.s6_2_3 = new Signo(s6_2_3);
        this.c6_3_3 = c6_3_3 < 0 ? new Cuadrado() : new Cuadrado(c6_3_3);
        this.c6_5_3 = c6_5_3 < 0 ? new Cuadrado() : new Cuadrado(c6_5_3);
        this.c1_1_4 = c1_1_4 < 0 ? new Cuadrado() : new Cuadrado(c1_1_4);
        this.s1_2_4 = new Signo(s1_2_4);
        this.c1_3_4 = c1_3_4 < 0 ? new Cuadrado() : new Cuadrado(c1_3_4);
        this.c1_5_4 = c1_5_4 < 0 ? new Cuadrado() : new Cuadrado(c1_5_4);
        this.s2_1_4 = new Signo(s2_1_4);
        this.s2_5_4 = new Signo(s2_5_4);
        this.c3_1_4 = c3_1_4 < 0 ? new Cuadrado() : new Cuadrado(c3_1_4);
        this.c3_5_4 = c3_5_4 < 0 ? new Cuadrado() : new Cuadrado(c3_5_4);
        this.c5_1_4 = c5_1_4 < 0 ? new Cuadrado() : new Cuadrado(c5_1_4);
        this.c5_5_4 = c5_5_4 < 0 ? new Cuadrado() : new Cuadrado(c5_5_4);
        this.c6_1_4 = c6_1_4 < 0 ? new Cuadrado() : new Cuadrado(c6_1_4);
        this.s6_2_4 = new Signo(s6_2_4);
        this.c6_3_4 = c6_3_4 < 0 ? new Cuadrado() : new Cuadrado(c6_3_4);
        this.c6_5_4 = c6_5_4 < 0 ? new Cuadrado() : new Cuadrado(c6_5_4); 
        
        this.p1_2s = new Signo(p1_2s);
        this.p1_2c = p1_2c < 0 ? new Cuadrado() : new Cuadrado(p1_2c);
        this.p1_3s = new Signo(p1_3s);
        this.p1_3c = p1_3c < 0 ? new Cuadrado() : new Cuadrado(p1_3c);

        this.p2_4s = new Signo(p2_4s);
        this.p2_4c = p2_4c < 0 ? new Cuadrado() : new Cuadrado(p2_4c);
        this.p3_4s = new Signo(p3_4s);
        this.p3_4c = p3_4c < 0 ? new Cuadrado() : new Cuadrado(p3_4c);

        Fila f1_1 = new Fila(this.c1_1_1, this.s1_2_1, this.c1_3_1, this.c1_5_1);
        Fila f2_1 = new Fila(this.c6_1_1, this.s6_2_1, this.c6_3_1, this.c6_5_1);
        Columna c1_1 = new Columna(this.c1_1_1, this.s2_1_1, this.c3_1_1, this.c5_1_1, this.c6_1_1);
        Columna c2_1 = new Columna(this.c1_5_1, this.s2_5_1, this.c3_5_1, this.c5_5_1, this.c6_5_1);
        
        this.sector1 = new Sector(f1_1, f2_1, c1_1, c2_1);
    
        Fila f1_2 = new Fila(this.c1_1_2, this.s1_2_2, this.c1_3_2, this.c1_5_2);
        Fila f2_2 = new Fila(this.c6_1_2, this.s6_2_2, this.c6_3_2, this.c6_5_2);
        Columna c1_2 = new Columna(this.c1_1_2, this.s2_1_2, this.c3_1_2, this.c5_1_2, this.c6_1_2);
        Columna c2_2 = new Columna(this.c1_5_2, this.s2_5_2, this.c3_5_2, this.c5_5_2, this.c6_5_2);

        //Sector 2 inicializado con todas sus variables

        this.sector2 = new Sector(f1_2, f2_2, c1_2, c2_2);


        //Sector 3 inicializado con todas sus variables

        Fila f1_3 = new Fila(this.c1_1_3, this.s1_2_3, this.c1_3_3, this.c1_5_3);
        Fila f2_3 = new Fila(this.c6_1_3, this.s6_2_3, this.c6_3_3, this.c6_5_3);
        Columna c1_3 = new Columna(this.c1_1_3, this.s2_1_3, this.c3_1_3, this.c5_1_3, this.c6_1_3);
        Columna c2_3 = new Columna(this.c1_5_3, this.s2_5_3, this.c3_5_3, this.c5_5_3, this.c6_5_3);

        this.sector3 = new Sector(f1_3, f2_3, c1_3, c2_3);


        //Sector 4 inicializado con todas sus variables

        Fila f1_4 = new Fila(this.c1_1_4, this.s1_2_4, this.c1_3_4, this.c1_5_4);
        Fila f2_4 = new Fila(this.c6_1_4, this.s6_2_4, this.c6_3_4, this.c6_5_4);
        Columna c1_4 = new Columna(this.c1_1_4, this.s2_1_4, this.c3_1_4, this.c5_1_4, this.c6_1_4);
        Columna c2_4 = new Columna(this.c1_5_4, this.s2_5_4, this.c3_5_4, this.c5_5_4, this.c6_5_4);


        this.sector4 = new Sector(f1_4, f2_4, c1_4, c2_4);


        this.puente1_2 = new Fila(this.c3_5_1, this.p1_2s, this.p1_2c, this.c3_1_2);
        this.puente1_3 = new Fila(this.c6_3_1, this.p1_3s, this.p1_3c, this.c1_3_3);
        this.puente2_4 = new Fila(this.c6_3_2, this.p2_4s, this.p2_4c, this.c1_3_4);
        this.puente3_4 = new Fila(this.c3_5_3, this.p3_4s, this.p3_4c, this.c3_1_4);
        
        f1_1.setVecino1(c1_1);
        f1_1.setVecino2(c2_1);
        c1_1.setVecino1(f1_1);
        c1_1.setVecino2(f2_1);
        f2_1.setVecino1(c1_1);
        f2_1.setVecino2(c2_1);
        f2_1.setVecino3(puente1_3);
        c2_1.setVecino1(f1_1);
        c2_1.setVecino2(f2_1);
        c2_1.setVecino3(puente1_2);
        
        f1_2.setVecino1(c1_2);
        f1_2.setVecino2(c2_2);
        c1_2.setVecino1(f1_2);
        c1_2.setVecino2(f2_2);
        c1_2.setVecino3(puente1_2);
        f2_2.setVecino1(c1_2);
        f2_2.setVecino2(c2_2);
        f2_2.setVecino3(puente2_4);
        c2_2.setVecino1(f1_2);
        c2_2.setVecino2(f2_2); 

        
        f1_3.setVecino1(c1_3);
        f1_3.setVecino2(c2_3);
        f1_3.setVecino3(puente1_3);
        c1_3.setVecino1(f1_3);
        c1_3.setVecino2(f2_3);
        f2_3.setVecino1(c1_3);
        f2_3.setVecino2(c2_3);
        c2_3.setVecino1(f1_3);
        c2_3.setVecino2(f2_3);
        c2_3.setVecino3(puente3_4);
        
        f1_4.setVecino1(c1_4);
        f1_4.setVecino2(c2_4);
        f1_4.setVecino3(puente2_4);
        c1_4.setVecino1(f1_4);
        c1_4.setVecino2(f2_4);
        c1_4.setVecino3(puente3_4);
        f2_4.setVecino1(c1_4);
        f2_4.setVecino2(c2_4);
        c2_4.setVecino1(f1_4);
        c2_4.setVecino2(f2_4);
        
        puente1_2.setVecino1(c2_1);
        puente1_2.setVecino2(c1_2);
        puente1_3.setVecino1(f2_1);
        puente1_3.setVecino2(f1_3);
        puente2_4.setVecino1(f2_2);
        puente2_4.setVecino2(f1_4);
        puente3_4.setVecino1(c2_3);
        puente3_4.setVecino2(c1_4);

    }
    
    public Tablero() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce los valores para inicializar el Tablero:");

        // Variables de las filas y columnas
        int c1_1_1, c1_3_1, c1_5_1, c1_1_2, c1_3_2, c1_5_2, c1_1_3, c1_3_3, c1_5_3, c1_1_4, c1_3_4, c1_5_4;
        char s1_2_1, s1_2_2, s1_2_3, s1_2_4;

        // Variables de las señales
        char s2_1_1, s2_5_1, s2_1_2, s2_5_2, s2_1_3, s2_5_3, s2_1_4, s2_5_4;

        // Variables de las filas y columnas
        int c3_1_1, c3_5_1, c3_1_2, c3_5_2, c3_1_3, c3_5_3, c3_1_4, c3_5_4;

        // Variables de las filas y columnas
        int c5_1_1, c5_5_1, c5_1_2, c5_5_2, c5_1_3, c5_5_3, c5_1_4, c5_5_4;

        // Variables de las filas y columnas
        int c6_1_1, c6_3_1, c6_5_1, c6_1_2, c6_3_2, c6_5_2, c6_1_3, c6_3_3, c6_5_3, c6_1_4, c6_3_4, c6_5_4;
        char s6_2_1, s6_2_2, s6_2_3, s6_2_4;

        // Variables de los puentes
        char p1_2s, p1_3s, p2_4s, p3_4s;
        int p1_2c, p1_3c, p2_4c, p3_4c;
        
        // Variables de tipo Cuadrado
        this.c1_1_1 = new Cuadrado();
        this.c1_3_1 = new Cuadrado();
        this.c1_5_1 = new Cuadrado();
        this.c3_1_1 = new Cuadrado();
        this.c3_5_1 = new Cuadrado();
        this.c5_1_1 = new Cuadrado();
        this.c5_5_1 = new Cuadrado();
        this.c6_1_1 = new Cuadrado();
        this.c6_3_1 = new Cuadrado();
        this.c6_5_1 = new Cuadrado();
        this.c1_1_2 = new Cuadrado();
        this.c1_3_2 = new Cuadrado();
        this.c1_5_2 = new Cuadrado();
        this.c3_1_2 = new Cuadrado();
        this.c3_5_2 = new Cuadrado();
        this.c5_1_2 = new Cuadrado();
        this.c5_5_2 = new Cuadrado();
        this.c6_1_2 = new Cuadrado();
        this.c6_3_2 = new Cuadrado();
        this.c6_5_2 = new Cuadrado();
        this.c1_1_3 = new Cuadrado();
        this.c1_3_3 = new Cuadrado();
        this.c1_5_3 = new Cuadrado();
        this.c3_1_3 = new Cuadrado();
        this.c3_5_3 = new Cuadrado();
        this.c5_1_3 = new Cuadrado();
        this.c5_5_3 = new Cuadrado();
        this.c6_1_3 = new Cuadrado();
        this.c6_3_3 = new Cuadrado();
        this.c6_5_3 = new Cuadrado();
        this.c1_1_4 = new Cuadrado();
        this.c1_3_4 = new Cuadrado();
        this.c1_5_4 = new Cuadrado();
        this.c3_1_4 = new Cuadrado();
        this.c3_5_4 = new Cuadrado();
        this.c5_1_4 = new Cuadrado();
        this.c5_5_4 = new Cuadrado();
        this.c6_1_4 = new Cuadrado();
        this.c6_3_4 = new Cuadrado();
        this.c6_5_4 = new Cuadrado();

        // Variables de tipo Signo
        this.s1_2_1 = new Signo();
        this.s2_1_1 = new Signo();
        this.s2_5_1 = new Signo();
        this.s6_2_1 = new Signo();
        this.s1_2_2 = new Signo();
        this.s2_1_2 = new Signo();
        this.s2_5_2 = new Signo();
        this.s6_2_2 = new Signo();
        this.s1_2_3 = new Signo();
        this.s2_1_3 = new Signo();
        this.s2_5_3 = new Signo();
        this.s6_2_3 = new Signo();
        this.s1_2_4 = new Signo();
        this.s2_1_4 = new Signo();
        this.s2_5_4 = new Signo();
        this.s6_2_4 = new Signo();
        
        // Variables adicionales de tipo Cuadrado y Signo
        this.p1_2s = new Signo();
        this.p1_2c = new Cuadrado();
        this.p1_3s = new Signo();
        this.p1_3c = new Cuadrado();
        this.p2_4s = new Signo();
        this.p2_4c = new Cuadrado();
        this.p3_4s = new Signo();
        this.p3_4c = new Cuadrado();
        
        c1_1_1 = this.ingresarCuadrado(1, 1, 1);
        this.c1_1_1 = c1_1_1 < 0 ? new Cuadrado() : new Cuadrado(c1_1_1);
        printTablero();
        s1_2_1 = this.ingresarSigno(1, 2, 1);
        this.s1_2_1 = new Signo(s1_2_1);
        printTablero();
        c1_3_1 = this.ingresarCuadrado(1, 3, 1);
        this.c1_3_1 = c1_3_1 < 0 ? new Cuadrado() : new Cuadrado(c1_3_1);
        printTablero();
        c1_5_1 = this.ingresarCuadrado(1, 5, 1);
        this.c1_5_1 = c1_5_1 < 0 ? new Cuadrado() : new Cuadrado(c1_5_1);
        printTablero();
        s2_1_1 = this.ingresarSigno(2, 1, 1);
        this.s2_1_1 = new Signo(s2_1_1);
        printTablero();
        s2_5_1 = this.ingresarSigno(2, 5, 1);
        this.s2_5_1 = new Signo(s2_5_1);
        printTablero();
        c3_1_1 = this.ingresarCuadrado(3, 1, 1);
        this.c3_1_1 = c3_1_1 < 0 ? new Cuadrado() : new Cuadrado(c3_1_1);
        printTablero();
        c3_5_1 = this.ingresarCuadrado(3, 5, 1);
        this.c3_5_1 = c3_5_1 < 0 ? new Cuadrado() : new Cuadrado(c3_5_1);
        printTablero();
        c5_1_1 = this.ingresarCuadrado(5, 1, 1);
        this.c5_1_1 = c5_1_1 < 0 ? new Cuadrado() : new Cuadrado(c5_1_1);
        printTablero();
        c5_5_1 = this.ingresarCuadrado(5, 5, 1);
        this.c5_5_1 = c5_5_1 < 0 ? new Cuadrado() : new Cuadrado(c5_5_1);
        printTablero();
        c6_1_1 = this.ingresarCuadrado(6, 1, 1);
        this.c6_1_1 = this.c6_1_1 = c6_1_1 < 0 ? new Cuadrado() : new Cuadrado(c6_1_1);
        printTablero();
        s6_2_1 = this.ingresarSigno(6, 2, 1);
        this.s6_2_1 = new Signo(s6_2_1);
        printTablero();
        c6_3_1 = this.ingresarCuadrado(6, 3, 1);
        this.c6_3_1 = c6_3_1 < 0 ? new Cuadrado() : new Cuadrado(c6_3_1);
        printTablero();
        c6_5_1 = this.ingresarCuadrado(6, 5, 1);
        this.c6_5_1 = c6_5_1 < 0 ? new Cuadrado() : new Cuadrado(c6_5_1);
        printTablero();
        c1_1_2 = this.ingresarCuadrado(1, 1, 2);
        this.c1_1_2 = c1_1_2 < 0 ? new Cuadrado() : new Cuadrado(c1_1_2);
        printTablero();
        s1_2_2 = this.ingresarSigno(1, 2, 2);
        this.s1_2_2 = new Signo(s1_2_2);
        printTablero();
        c1_3_2 = this.ingresarCuadrado(1, 3, 2);
        this.c1_3_2 = c1_3_2 < 0 ? new Cuadrado() : new Cuadrado(c1_3_2);
        printTablero();
        c1_5_2 = this.ingresarCuadrado(1, 5, 2);
        this.c1_5_2 = c1_5_2 < 0 ? new Cuadrado() : new Cuadrado(c1_5_2);
        printTablero();
        s2_1_2 = this.ingresarSigno(2, 1, 2);
        this.s2_1_2 = new Signo(s2_1_2);
        printTablero();
        s2_5_2 = this.ingresarSigno(2, 5, 2);
        this.s2_5_2 = new Signo(s2_5_2);
        printTablero();
        c3_1_2 = this.ingresarCuadrado(3, 1, 2);
        this.c3_1_2 = c3_1_2 < 0 ? new Cuadrado() : new Cuadrado(c3_1_2);
        printTablero();
        c3_5_2 = this.ingresarCuadrado(3, 5, 2);
        this.c3_5_2 = c3_5_2 < 0 ? new Cuadrado() : new Cuadrado(c3_5_2);
        printTablero();
        c5_1_2 = this.ingresarCuadrado(5, 1, 2);
        this.c5_1_2 = c5_1_2 < 0 ? new Cuadrado() : new Cuadrado(c5_1_2);
        printTablero();
        c5_5_2 = this.ingresarCuadrado(5, 5, 2);
        this.c5_5_2 = c5_5_2 < 0 ? new Cuadrado() : new Cuadrado(c5_5_2);
        printTablero();
        c6_1_2 = this.ingresarCuadrado(6, 1, 2);
        this.c6_1_2 = this.c6_1_2 = c6_1_2 < 0 ? new Cuadrado() : new Cuadrado(c6_1_2);
        printTablero();
        s6_2_2 = this.ingresarSigno(6, 2, 2);
        this.s6_2_2 = new Signo(s6_2_2);
        printTablero();
        c6_3_2 = this.ingresarCuadrado(6, 3, 2);
        this.c6_3_2 = c6_3_2 < 0 ? new Cuadrado() : new Cuadrado(c6_3_2);
        printTablero();
        c6_5_2 = this.ingresarCuadrado(6, 5, 2);
        this.c6_5_2 = c6_5_2 < 0 ? new Cuadrado() : new Cuadrado(c6_5_2);
        printTablero();
        c1_1_3 = this.ingresarCuadrado(1, 1, 3);
        this.c1_1_3 = c1_1_3 < 0 ? new Cuadrado() : new Cuadrado(c1_1_3);
        printTablero();
        s1_2_3 = this.ingresarSigno(1, 2, 3);
        this.s1_2_3 = new Signo(s1_2_3);
        printTablero();
        c1_3_3 = this.ingresarCuadrado(1, 3, 3);
        this.c1_3_3 = c1_3_3 < 0 ? new Cuadrado() : new Cuadrado(c1_3_3);
        printTablero();
        c1_5_3 = this.ingresarCuadrado(1, 5, 3);
        this.c1_5_1 = c1_5_3 < 0 ? new Cuadrado() : new Cuadrado(c1_5_3);
        printTablero();
        s2_1_3 = this.ingresarSigno(2, 1, 3);
        this.s2_1_3 = new Signo(s2_1_3);
        printTablero();
        s2_5_3 = this.ingresarSigno(2, 5, 3);
        this.s2_5_3 = new Signo(s2_5_3);
        printTablero();
        c3_1_3 = this.ingresarCuadrado(3, 1, 3);
        this.c3_1_3 = c3_1_3 < 0 ? new Cuadrado() : new Cuadrado(c3_1_3);
        printTablero();
        c3_5_3 = this.ingresarCuadrado(3, 5, 3);
        this.c3_5_3 = c3_5_3 < 0 ? new Cuadrado() : new Cuadrado(c3_5_3);
        printTablero();
        c5_1_3 = this.ingresarCuadrado(5, 1, 3);
        this.c5_1_1 = c5_1_1 < 0 ? new Cuadrado() : new Cuadrado(c5_1_1);
        printTablero();
        c5_5_3 = this.ingresarCuadrado(5, 5, 3);
        this.c5_5_3 = c5_5_3 < 0 ? new Cuadrado() : new Cuadrado(c5_5_3);
        printTablero();
        c6_1_3 = this.ingresarCuadrado(6, 1, 3);
        this.c6_1_3 = this.c6_1_3 = c6_1_3 < 0 ? new Cuadrado() : new Cuadrado(c6_1_3);
        printTablero();
        s6_2_3 = this.ingresarSigno(6, 2, 3);
        this.s6_2_3 = new Signo(s6_2_3);
        printTablero();
        c6_3_3 = this.ingresarCuadrado(6, 3, 3);
        this.c6_3_3 = c6_3_3 < 0 ? new Cuadrado() : new Cuadrado(c6_3_3);
        printTablero();
        c6_5_3 = this.ingresarCuadrado(6, 5, 3);
        this.c6_5_3 = c6_5_3 < 0 ? new Cuadrado() : new Cuadrado(c6_5_3);
        printTablero();
        c1_1_4 = this.ingresarCuadrado(1, 1, 4);
        this.c1_1_4 = c1_1_4 < 0 ? new Cuadrado() : new Cuadrado(c1_1_4);
        printTablero();
        s1_2_4 = this.ingresarSigno(1, 2, 4);
        this.s1_2_4 = new Signo(s1_2_4);
        printTablero();
        c1_3_4 = this.ingresarCuadrado(1, 3, 4);
        this.c1_3_4 = c1_3_4 < 0 ? new Cuadrado() : new Cuadrado(c1_3_4);
        printTablero();
        c1_5_4 = this.ingresarCuadrado(1, 5, 4);
        this.c1_5_4 = c1_5_4 < 0 ? new Cuadrado() : new Cuadrado(c1_5_4);
        printTablero();
        s2_1_4 = this.ingresarSigno(2, 1, 4);
        this.s2_1_4 = new Signo(s2_1_4);
        printTablero();
        s2_5_4 = this.ingresarSigno(2, 5, 4);
        this.s2_5_4 = new Signo(s2_5_4);
        printTablero();
        c3_1_4 = this.ingresarCuadrado(3, 1, 4);
        this.c3_1_4 = c3_1_4 < 0 ? new Cuadrado() : new Cuadrado(c3_1_4);
        printTablero();
        c3_5_4 = this.ingresarCuadrado(3, 5, 4);
        this.c3_5_4 = c3_5_4 < 0 ? new Cuadrado() : new Cuadrado(c3_5_4);
        printTablero();
        c5_1_4 = this.ingresarCuadrado(5, 1, 4);
        this.c5_1_4 = c5_1_4 < 0 ? new Cuadrado() : new Cuadrado(c5_1_4);
        printTablero();
        c5_5_4 = this.ingresarCuadrado(5, 5, 4);
        this.c5_5_4 = c5_5_4 < 0 ? new Cuadrado() : new Cuadrado(c5_5_4);
        printTablero();
        c6_1_4 = this.ingresarCuadrado(6, 1, 4);
        this.c6_1_4 = this.c6_1_4 = c6_1_4 < 0 ? new Cuadrado() : new Cuadrado(c6_1_4);
        printTablero();
        s6_2_4 = this.ingresarSigno(6, 2, 4);
        this.s6_2_4 = new Signo(s6_2_4);
        printTablero();
        c6_3_4 = this.ingresarCuadrado(6, 3, 4);
        this.c6_3_4 = c6_3_4 < 0 ? new Cuadrado() : new Cuadrado(c6_3_4);
        printTablero();
        c6_5_4 = this.ingresarCuadrado(6, 5, 4);
        this.c6_5_4 = c6_5_4 < 0 ? new Cuadrado() : new Cuadrado(c6_5_4);
        printTablero();
        p1_2s = this.ingresarPuenteSigno(1, 2);
        this.p1_2s = new Signo(p1_2s);
        printTablero();
        p1_2c = this.ingresarPuenteCuadrado(1, 2);
        this.p1_2c = p1_2c < 0 ? new Cuadrado() : new Cuadrado(p1_2c);
        printTablero();
        p1_3s = this.ingresarPuenteSigno(1, 3);
        this.p1_3s = new Signo(p1_3s);
        printTablero();
        p1_3c = this.ingresarPuenteCuadrado(1, 3);
        this.p1_3c = p1_3c < 0 ? new Cuadrado() : new Cuadrado(p1_3c);
        printTablero();
        p2_4s = this.ingresarPuenteSigno(2, 4);
        this.p2_4s = new Signo(p2_4s);
        printTablero();
        p2_4c = this.ingresarPuenteCuadrado(2, 4);
        this.p2_4c = p2_4c < 0 ? new Cuadrado() : new Cuadrado(p2_4c);
        printTablero();
        p3_4s = this.ingresarPuenteSigno(3, 4);
        this.p3_4s = new Signo(p3_4s);
        printTablero();
        p3_4c = this.ingresarPuenteCuadrado(3, 4);
        this.p3_4c = p3_4c < 0 ? new Cuadrado() : new Cuadrado(p3_4c);
        printTablero();

        // Utiliza los valores ingresados para inicializar las instancias

        Fila f1_1 = new Fila(this.c1_1_1, this.s1_2_1, this.c1_3_1, this.c1_5_1);
        Fila f2_1 = new Fila(this.c6_1_1, this.s6_2_1, this.c6_3_1, this.c6_5_1);
        Columna c1_1 = new Columna(this.c1_1_1, this.s2_1_1, this.c3_1_1, this.c5_1_1, this.c6_1_1);
        Columna c2_1 = new Columna(this.c1_5_1, this.s2_5_1, this.c3_5_1, this.c5_5_1, this.c6_5_1);
        
        this.sector1 = new Sector(f1_1, f2_1, c1_1, c2_1);
    
        Fila f1_2 = new Fila(this.c1_1_2, this.s1_2_2, this.c1_3_2, this.c1_5_2);
        Fila f2_2 = new Fila(this.c6_1_2, this.s6_2_2, this.c6_3_2, this.c6_5_2);
        Columna c1_2 = new Columna(this.c1_1_2, this.s2_1_2, this.c3_1_2, this.c5_1_2, this.c6_1_2);
        Columna c2_2 = new Columna(this.c1_5_2, this.s2_5_2, this.c3_5_2, this.c5_5_2, this.c6_5_2);

        //Sector 2 inicializado con todas sus variables

        this.sector2 = new Sector(f1_2, f2_2, c1_2, c2_2);


        //Sector 3 inicializado con todas sus variables

        Fila f1_3 = new Fila(this.c1_1_3, this.s1_2_3, this.c1_3_3, this.c1_5_3);
        Fila f2_3 = new Fila(this.c6_1_3, this.s6_2_3, this.c6_3_3, this.c6_5_3);
        Columna c1_3 = new Columna(this.c1_1_3, this.s2_1_3, this.c3_1_3, this.c5_1_3, this.c6_1_3);
        Columna c2_3 = new Columna(this.c1_5_3, this.s2_5_3, this.c3_5_3, this.c5_5_3, this.c6_5_3);

        this.sector3 = new Sector(f1_3, f2_3, c1_3, c2_3);


        //Sector 4 inicializado con todas sus variables

        Fila f1_4 = new Fila(this.c1_1_4, this.s1_2_4, this.c1_3_4, this.c1_5_4);
        Fila f2_4 = new Fila(this.c6_1_4, this.s6_2_4, this.c6_3_4, this.c6_5_4);
        Columna c1_4 = new Columna(this.c1_1_4, this.s2_1_4, this.c3_1_4, this.c5_1_4, this.c6_1_4);
        Columna c2_4 = new Columna(this.c1_5_4, this.s2_5_4, this.c3_5_4, this.c5_5_4, this.c6_5_4);


        this.sector4 = new Sector(f1_4, f2_4, c1_4, c2_4);


        this.puente1_2 = new Fila(this.c3_5_1, this.p1_2s, this.p1_2c, this.c3_1_2);
        this.puente1_3 = new Fila(this.c6_3_1, this.p1_3s, this.p1_3c, this.c1_3_3);
        this.puente2_4 = new Fila(this.c6_3_2, this.p2_4s, this.p2_4c, this.c1_3_4);
        this.puente3_4 = new Fila(this.c3_5_3, this.p3_4s, this.p3_4c, this.c3_1_4);
        
        f1_1.setVecino1(c1_1);
        f1_1.setVecino2(c2_1);
        c1_1.setVecino1(f1_1);
        c1_1.setVecino2(f2_1);
        f2_1.setVecino1(c1_1);
        f2_1.setVecino2(c2_1);
        f2_1.setVecino3(puente1_3);
        c2_1.setVecino1(f1_1);
        c2_1.setVecino2(f2_1);
        c2_1.setVecino3(puente1_2);
        
        f1_2.setVecino1(c1_2);
        f1_2.setVecino2(c2_2);
        c1_2.setVecino1(f1_2);
        c1_2.setVecino2(f2_2);
        c1_2.setVecino3(puente1_2);
        f2_2.setVecino1(c1_2);
        f2_2.setVecino2(c2_2);
        f2_2.setVecino3(puente2_4);
        c2_2.setVecino1(f1_2);
        c2_2.setVecino2(f2_2); 

        
        f1_3.setVecino1(c1_3);
        f1_3.setVecino2(c2_3);
        f1_3.setVecino3(puente1_2);
        c1_3.setVecino1(f1_3);
        c1_3.setVecino2(f2_3);
        f2_3.setVecino1(c1_3);
        f2_3.setVecino2(c2_3);
        c2_3.setVecino1(f1_3);
        c2_3.setVecino2(f2_3);
        c2_3.setVecino3(puente3_4);
        
        f1_4.setVecino1(c1_4);
        f1_4.setVecino2(c2_4);
        f1_4.setVecino3(puente2_4);
        c1_4.setVecino1(f1_4);
        c1_4.setVecino2(f2_4);
        c1_4.setVecino3(puente3_4);
        f2_4.setVecino1(c1_4);
        f2_4.setVecino2(c2_4);
        c2_4.setVecino1(f1_4);
        c2_4.setVecino2(f2_4);
        
        puente1_2.setVecino1(c2_1);
        puente1_2.setVecino2(c1_2);
        puente1_3.setVecino1(f2_1);
        puente1_3.setVecino2(f1_3);
        puente2_4.setVecino1(f2_2);
        puente2_4.setVecino2(f1_4);
        puente3_4.setVecino1(c2_3);
        puente3_4.setVecino2(c1_4);

        // Cierra el scanner
        scanner.close();
    }
    
    public int ingresarCuadrado(int fila, int columna, int sector) {
        Scanner scanner = new Scanner(System.in);
        int valor = -1;  // Valor inicial por defecto

        do {
            System.out.printf("Ingresar cuadrado en fila%d, columna%d, sector%d (para cuadrado vacio ingresar -1): ", fila, columna, sector);
            String entrada = scanner.next();

            if (entrada.isEmpty()) {
                return -69;  // Si se ingresa vacío, vuelve a solicitar la entrada
            }

            try {
                valor = Integer.parseInt(entrada);

                if (valor >= -1 && valor <= 9) {
                    break;
                } else {
                    System.out.println("Entrada invalida. Debe ser un entero entre -1 y 9.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Debe ser un integer.");
            }
        } while (true);

        return valor;
    }
    public char ingresarSigno(int fila, int columna, int sector) {
        Scanner scanner = new Scanner(System.in);
        char signo = '_';  // Valor inicial por defecto

        do {
            System.out.printf("Ingresar signo en fila%d, columna%d, sector%d: ", fila, columna, sector);
            String entrada = scanner.next();

            if (entrada.isEmpty()) {
                return 'f';  // Si se ingresa vacío, vuelve a solicitar la entrada
            }

            if (entrada.length() == 1) {
                char caracter = entrada.charAt(0);
                if (caracter == '+' || caracter == '-' || caracter == 'x') {
                    signo = caracter;
                    break;
                }
            }

            System.out.println("Entrada invalida. Debe ser un +, -, o x.");
        } while (true);

        return signo;
    }
    
    public char ingresarPuenteSigno(int sector1, int sector2) {
        Scanner scanner = new Scanner(System.in);
        char signo = '_';  // Valor inicial por defecto

        do {
            System.out.printf("Ingresar signo en puente que conecta el sector %d con el sector %d: ", sector1, sector2);
            String entrada = scanner.next();

            if (entrada.length() == 1) {
                char caracter = entrada.charAt(0);
                if (caracter == '+' || caracter == '-' || caracter == 'x') {
                    signo = caracter;
                    break;
                }
            }

            System.out.println("Entrada invalida. Debe ser un +, -, o x.");
        } while (true);

        return signo;
    }

    public int ingresarPuenteCuadrado(int sector1, int sector2) {
        Scanner scanner = new Scanner(System.in);
        int valor = -1;  // Valor inicial por defecto

        do {
            System.out.printf("Ingresar cuadrado en puente que conecta el sector %d con el sector %d (para cuadrado vacio ingresar -1): ", sector1, sector2);
            String entrada = scanner.next();

            if (entrada.isEmpty()) {
                return -1;  // Si se ingresa vacío, mantén el valor por defecto y sal del método
            }

            try {
                valor = Integer.parseInt(entrada);

                if (valor >= -1 && valor <= 9) {
                    break;
                } else {
                    System.out.println("Entrada inválida. Debe ser un entero entre -1 y 9.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debe ser un entero entre -1 y 9.");
            }
        } while (true);

        return valor;
    }
    
    
    public void printTablero(){
        System.out.println(c1_1_1.toString()+s1_2_1.toString()+c1_3_1.toString()+'='+c1_5_1.toString()+"   "+c1_1_2.toString() + s1_2_2.toString() + c1_3_2.toString() + '=' + c1_5_2.toString());
        System.out.println(s2_1_1.toString()+"   "+s2_5_1.toString()+"   "+s2_1_2.toString() + "   " + s2_5_2.toString());
        System.out.println(c3_1_1.toString()+"   "+c3_5_1.toString()+p1_2s.toString()+p1_2c.toString()+'='+c3_1_2.toString() + "   " + c3_5_2.toString());
        System.out.println('='+"   "+'='+"   "+'=' + "   " +'=');
        System.out.println(c5_1_1.toString()+"   "+c5_5_1.toString()+"   "+c5_1_2.toString() + "   " + c5_5_2.toString());
        System.out.println(c6_1_1.toString()+s6_2_1.toString()+c6_3_1.toString()+'='+c6_5_1.toString()+"   "+c6_1_2.toString() + s6_2_2.toString() + c6_3_2.toString() + '=' + c6_5_2.toString());
        System.out.println("  "+p1_3s.toString()+"       "+p2_4s.toString());
        System.out.println("  "+p1_3c.toString()+"       "+p2_4c.toString());
        System.out.println("  "+'='+"       "+'=');
        System.out.println(c1_1_3.toString() + s1_2_3.toString() + c1_3_3.toString() + '=' + c1_5_3.toString()+"   "+c1_1_4.toString() + s1_2_4.toString() + c1_3_4.toString() + '=' + c1_5_4.toString());
        System.out.println(s2_1_3.toString() + "   " + s2_5_3.toString()+"   "+s2_1_4.toString() + "   " + s2_5_4.toString());
        System.out.println(c3_1_3.toString() + "   " + c3_5_3.toString()+p3_4s.toString()+p3_4c.toString()+'='+c3_1_4.toString() + "   " + c3_5_4.toString());
        System.out.println('=' + "   " +'='+"   "+'=' + "   " + '=');
        System.out.println(c5_1_3.toString() + "   " + c5_5_3.toString()+"   "+c5_1_4.toString() + "   " + c5_5_4.toString());
        System.out.println(c6_1_3.toString() + s6_2_3.toString() + c6_3_3.toString() + '=' + c6_5_3.toString()+ "   "+c6_1_4.toString() + s6_2_4.toString() + c6_3_4.toString() + '=' + c6_5_4.toString());
    }
    
    public Sector getSector(int n){
        return switch (n) {
            case 1 -> sector1;
            case 2 -> sector2;
            case 3 -> sector3;
            default -> sector4;
        };
    }
    
    public Fila getPuente(int n){
        return switch (n) {
            case 1 -> puente1_2;
            case 2 -> puente1_3;
            case 3 -> puente2_4;
            default -> puente3_4;
        };
    }
    
}


// Corresponde a las operaciones matemáticas que usaremos
class Operar {
    public boolean operarFila(Signo signo, Cuadrado cuadrado1, Cuadrado cuadrado3, Cuadrado cuadrado5) {
        char operador = signo.getSigno();
        if (cuadrado1.getNumero() != -1 && cuadrado3.getNumero() != -1 && cuadrado5.getNumero() != -1) {
            switch (operador) {
                case '+' -> {
                    return cuadrado1.getNumero() + cuadrado3.getNumero() == cuadrado5.getNumero();
                }
                case '-' -> {
                    return cuadrado1.getNumero() - cuadrado3.getNumero() == cuadrado5.getNumero();
                }
                case 'x' -> {
                    return cuadrado1.getNumero() * cuadrado3.getNumero() == cuadrado5.getNumero();
                }
                
                default -> {
                        return false;
                }
            }
        }
        return false;
    }

    public boolean operarColumna(Signo signo, Cuadrado cuadrado1, Cuadrado cuadrado3, Cuadrado cuadrado5, Cuadrado cuadrado6) {
        char operador = signo.getSigno();
            if (cuadrado1.getNumero() != -1 && cuadrado3.getNumero() != -1 && cuadrado5.getNumero() != -1 && cuadrado6.getNumero() != -1) {
            switch (operador) {
                case '+' -> {
                    return cuadrado1.getNumero() + cuadrado3.getNumero() == (cuadrado5.getNumero() * 10 + cuadrado6.getNumero());
                }
                case 'x' -> {
                    return cuadrado1.getNumero() * cuadrado3.getNumero() == (cuadrado5.getNumero() * 10 + cuadrado6.getNumero());
                }
                default -> {
                    return false;
                }
            }
        }
        return false;
    }
    
    public int resolverFila(Signo signo, Cuadrado cuadrado1, Cuadrado cuadrado3, Cuadrado cuadrado5) {
        char operador = signo.getSigno();
        switch (operador) {
            case '+' -> {
                if(cuadrado1 == null && cuadrado3 != null && cuadrado5 != null){
                    int r = cuadrado5.getNumero()-cuadrado3.getNumero();
                    return r < 0 ? -1 : r; 
                }
                else if(cuadrado3 == null && cuadrado1 != null && cuadrado5 !=null){
                    int r = cuadrado5.getNumero()-cuadrado1.getNumero();
                    return r < 0 ? -1 : r; 
                }
                else if(cuadrado5 == null && cuadrado1 != null && cuadrado3 != null){
                    int r = cuadrado1.getNumero()+cuadrado3.getNumero();
                    return r > 9 ? -1 : r; 
                }
                else{
                    return -1;
                }
            }
            case '-' -> {
                if(cuadrado1 == null && cuadrado3 != null && cuadrado5 != null){
                    int r = cuadrado5.getNumero()+cuadrado3.getNumero();
                    return r > 9 ? -1 : r;
                }
                else if(cuadrado3 == null && cuadrado1 != null && cuadrado5 !=null){
                    int r = cuadrado1.getNumero()-cuadrado5.getNumero();
                    return r < 0 ? -1 : r;
                }
                else if(cuadrado5 == null && cuadrado1 != null && cuadrado3 != null){
                    int r = cuadrado1.getNumero()-cuadrado3.getNumero();
                    return r < 0 ? -1 : r;
                }
                else{
                    return -1;
                }
            }
            case 'x' -> {
                if (cuadrado1 == null && cuadrado3 != null && cuadrado5 != null) {
                    int numerador = cuadrado5.getNumero();
                    int denominador = cuadrado3.getNumero();
                    if (numerador == 0){
                        return 0;
                    }
                    if (denominador != 0) {
                        int r = numerador / denominador;
                        return r == 0 ? -1 : r;
                    }
                } else if (cuadrado3 == null && cuadrado1 != null && cuadrado5 != null) {
                    int numerador = cuadrado5.getNumero();
                    int denominador = cuadrado1.getNumero();
                    if (numerador == 0){
                        return 0;
                    }
                    if (denominador != 0) {
                        int r = numerador / denominador;
                        return r == 0 ? -1 : r;
                    }
                } else if (cuadrado5 == null && cuadrado1 != null && cuadrado3 != null) {
                    int resultado = cuadrado1.getNumero() * cuadrado3.getNumero();
                    return resultado;
                }
                return -1;
            }
            default -> {
                    return -1; // Operador no válido.
            }
        }
    }

    public int resolverColumna(Signo signo, Cuadrado cuadrado1, Cuadrado cuadrado3, Cuadrado cuadrado5, Cuadrado cuadrado6) {
        char operador = signo.getSigno();
        switch (operador) {
            case '+' -> {
                if(cuadrado1 == null && cuadrado3 != null && cuadrado5 != null && cuadrado6 != null){
                    int r = cuadrado5.getNumero()*10+cuadrado6.getNumero()-cuadrado3.getNumero();
                    return r < 0 || r > 9 ? -1 : r;
                }
                else if(cuadrado3 == null && cuadrado1 != null && cuadrado5 !=null && cuadrado6 != null){
                    int r = cuadrado5.getNumero()*10+cuadrado6.getNumero()-cuadrado1.getNumero();
                    return r < 0 || r > 9 ? -1 : r;
                }
                else if((cuadrado5 == null || cuadrado6 == null) && cuadrado1 != null && cuadrado3 != null){
                    int r = cuadrado1.getNumero() + cuadrado3.getNumero();
                    if(r < 10 || r > 99){
                        return -1;
                    }
                    if (cuadrado5 == null && cuadrado6 !=null){
                        if(((r/10)*10 + cuadrado6.getNumero())==r)
                            return r/10;
                        else
                            return -1;
                    }
                    else if (cuadrado6 == null && cuadrado5 != null){
                        if((cuadrado5.getNumero()*10+r%10)==r)
                            return r%10;
                        else
                            return -1;
                    }
                    else if(cuadrado5 == null && cuadrado6 == null){
                        return r;
                    }
                    
                }
                else{
                    return -1;
                }
            }
           
            case 'x' -> {
                if (cuadrado1 == null && cuadrado3 != null && cuadrado5 != null && cuadrado6 != null) {
                    int numerador = cuadrado5.getNumero() * 10 + cuadrado6.getNumero();
                    int denominador = cuadrado3.getNumero();
                    if (denominador != 0 && numerador % denominador == 0) {
                        int resultado = numerador / denominador;
                        if (resultado >= 0 && resultado <= 9) {
                            return resultado;
                        }
                    }
                } else if (cuadrado3 == null && cuadrado1 != null && cuadrado5 != null && cuadrado6 != null) {
                    int numerador = cuadrado5.getNumero() * 10 + cuadrado6.getNumero();
                    int denominador = cuadrado1.getNumero();
                    if (denominador != 0 && numerador % denominador == 0) {
                        int resultado = numerador / denominador;
                        if (resultado >= 0 && resultado <= 9) {
                            return resultado;
                        }
                    }
                } else if (cuadrado1 != null && cuadrado3 != null && cuadrado5 == null && cuadrado6 != null) {
                    // Obtener los números de los cuadrados 1, 3 y 6
                    int numero1 = cuadrado1.getNumero();
                    int numero3 = cuadrado3.getNumero();
                    int numero6 = cuadrado6.getNumero();

                    // Realizar la operación de multiplicación
                    int resultado = numero1 * numero3;

                    // Verificar si el resultado es menor que 10
                    if (resultado < 10) {
                        return -1;
                    }

                    // Verificar si el dígito de las unidades del resultado coincide con el número en cuadrado6
                    int unidadesResultado = resultado % 10;
                    if (unidadesResultado == numero6) {
                        // Asignar el dígito de las decenas al cuadrado5
                        int decenasResultado = (resultado / 10) % 10;
                        return decenasResultado;
                    } else {
                        // El dígito de las unidades del resultado no coincide, devolver -1
                        return -1;
                    }
                } else if (cuadrado1 != null && cuadrado3 != null && cuadrado5 != null & cuadrado6 == null) {
                    // Obtener los números de los cuadrados 1, 3 y 5
                    int numero1 = cuadrado1.getNumero();
                    int numero3 = cuadrado3.getNumero();
                    int numero5 = cuadrado5.getNumero();

                    // Calcular el resultado combinando el dígito de las unidades y las decenas
                    int resultado = numero1 * numero3;

                    // Verificar si el resultado es menor que 10
                    if (resultado < 10) {
                        return -1;
                    }

                    int decenasResultado = (resultado / 10) % 10;

                    // Verificar si las decenas coinciden con el número en cuadrado5
                    if (decenasResultado == numero5) {
                        // Calcular el dígito de las unidades y retornarlo
                        int unidadesResultado = resultado % 10;
                        return unidadesResultado;
                    } else {
                        // Las decenas no coinciden, devolver -1
                        return -1;
                    }
                }else if (cuadrado5 == null && cuadrado6 == null && cuadrado1 != null && cuadrado3 != null) {
                    int resultado = cuadrado1.getNumero() * cuadrado3.getNumero();
                    if (resultado >= 10 && resultado <= 99) {
                        return resultado;
                    }
                }
                return -1;
            }

            default -> {
                    return -1; // Operador no válido.
            }
        }
    return -1;
    }
}

// Corresponde al método que contiene el algoritmo que resuelve este juego
class Resolver {
    
    public void ordenarPorHeuristica (List<Conjunto> conjunto){
        Collections.sort(conjunto, (conjunto1, conjunto2) -> Integer.compare(conjunto2.getHeuristica(), conjunto1.getHeuristica()));
    }
    
    public Resolver(Tablero t){
        Tablero tablero = t;
        Sector sector1 = tablero.getSector(1);
        Sector sector2 = tablero.getSector(2);
        Sector sector3 = tablero.getSector(3);
        Sector sector4 = tablero.getSector(4);
        Fila puente1_2 = tablero.getPuente(1);
        Fila puente1_3 = tablero.getPuente(2);
        Fila puente2_4 = tablero.getPuente(3);
        Fila puente3_4 = tablero.getPuente(4);
        
        // Crear un ArrayList de Conjunto
        List<Conjunto> conjuntos = new ArrayList<>();

        // Agregar filas y columnas a la lista de conjuntos
        conjuntos.add(sector1.getF1());
        conjuntos.add(sector1.getF2());
        conjuntos.add(sector2.getF1());
        conjuntos.add(sector2.getF2());
        conjuntos.add(sector3.getF1());
        conjuntos.add(sector3.getF2());
        conjuntos.add(sector4.getF1());
        conjuntos.add(sector4.getF2());
        conjuntos.add(sector1.getC1());
        conjuntos.add(sector1.getC2());
        conjuntos.add(sector2.getC1());
        conjuntos.add(sector2.getC2());
        conjuntos.add(sector3.getC1());
        conjuntos.add(sector3.getC2());
        conjuntos.add(sector4.getC1());
        conjuntos.add(sector4.getC2());
        conjuntos.add(puente1_2);
        conjuntos.add(puente1_3);
        conjuntos.add(puente2_4);
        conjuntos.add(puente3_4);
        
        List<Conjunto> ordenarConjuntos = new ArrayList<>(conjuntos);
        ordenarPorHeuristica(ordenarConjuntos);

        while (!ordenarConjuntos.isEmpty() && ordenarConjuntos.get(0).getHeuristica() > 7) {
            boolean solucionado = true;
            for (Conjunto conjunto : ordenarConjuntos) {
                // Aquí puedes trabajar con cada elemento "conjunto"
                // Por ejemplo, imprimir su heurística:

                // Llamar al método "solucionar" en cada conjunto:
                if(conjunto.getHeuristica()>7){
                    solucionado = conjunto.solucionar();
                }
                if(!solucionado){
                    ordenarConjuntos.clear();
                    System.out.println("Este Garam es imposible de resolver");
                    break;
                }

                if (conjunto.getHeuristica() < 7) {
                    // Filtrar los conjuntos con heurísticas menores a 8
                    ordenarConjuntos = ordenarConjuntos.stream()
                            .filter(c -> c.getHeuristica() < 9)
                            .collect(Collectors.toList());

                    // Vuelve a ordenar la lista con los conjuntos actualizados
                    ordenarPorHeuristica(ordenarConjuntos);
                    break;
                }
            }
        }
        List<Conjunto> conjuntosInicial = new ArrayList<>();
        Conjunto conjuntoInicial = ordenarConjuntos.get(0);
        conjuntosInicial.add(conjuntoInicial);
        if(solucionRecursiva(conjuntosInicial, tablero, ordenarConjuntos))
            System.out.println("Garam Resuelto!");
        else
            System.out.println("Lo siento, este algoritmo no pudo resolver este Garam");
    }
    
    public List<Conjunto> calcularVecinosExternos(List<Conjunto> listaDeConjuntos) {
        // Este método calcula los vecinos externos de un conjunto, el propósito de esto es obtener los vecinos para luego compararlos por heurística y seleccionar el mejor
        List<Conjunto> vecinosExternos = new ArrayList<>();

        for (Conjunto conjunto : listaDeConjuntos) {
            if (conjunto.getVecino1() != null && !listaDeConjuntos.contains(conjunto.getVecino1()) && conjunto.getVecino1().getHeuristica()!=10) {
                vecinosExternos.add(conjunto.getVecino1());
            }
            if (conjunto.getVecino2() != null && !listaDeConjuntos.contains(conjunto.getVecino2()) && conjunto.getVecino2().getHeuristica()!=10) {
                vecinosExternos.add(conjunto.getVecino2());
            }
            if (conjunto.getVecino3() != null && !listaDeConjuntos.contains(conjunto.getVecino3()) && conjunto.getVecino3().getHeuristica()!=10) {
                vecinosExternos.add(conjunto.getVecino3());
            }
        }

        return vecinosExternos;
    }
    
    public Conjunto nuevoCamino(List<Conjunto> total, List<Conjunto> actual) {
        // Crea una copia de total para mantenerlo intacto
        List<Conjunto> copiaTotal = new ArrayList<>(total);

        // Elimina los conjuntos en 'actual' de 'copiaTotal'
        copiaTotal.removeAll(actual);

        Conjunto mejorConjunto = null;
        int mejorHeuristica = 0; // Inicializamos con un valor bajo

        for (Conjunto conjunto : copiaTotal) {
            if (conjunto.getHeuristica() > mejorHeuristica) {
                mejorConjunto = conjunto;
                mejorHeuristica = conjunto.getHeuristica();
            }
        }

        return mejorConjunto;
    }

    
    public Conjunto encontrarMejorHeuristica(List<Conjunto> listaDeConjuntos) {
        // Este método toma una lista de vecinos y compara sus heurísticas, retorna el mayor
        Conjunto mejorConjunto = null;
        int mejorHeuristica = 0;

        for (Conjunto conjunto : listaDeConjuntos) {
            if (conjunto.getHeuristica() > mejorHeuristica) {
                mejorConjunto = conjunto;
                mejorHeuristica = conjunto.getHeuristica();
            }
        }

        return mejorConjunto;
    }

    public boolean solucionRecursiva(List<Conjunto> conjuntos, Tablero t, List<Conjunto> total) {
        // El algoritmo recursivo que calcula los garam, calcula caso por caso tomando en cuenta la heurística
        Conjunto conjunto = conjuntos.get(conjuntos.size() -1);
        if(conjuntos.size()==total.size() && conjunto.getHeuristica()==10){
            return true;
        }
        if (conjunto.getHeuristica() == 10){
            //En caso de heurística 10, si está seguir con el algoritmo, si no volver y pasar
            if(conjunto.solucionar()){
                List<Conjunto> vecinos = calcularVecinosExternos(conjuntos);
                Conjunto mejorVecino = encontrarMejorHeuristica(vecinos);
                if(mejorVecino != null && mejorVecino.getHeuristica() > 2)
                    conjuntos.add(mejorVecino);
                else if (mejorVecino != null && mejorVecino.getHeuristica() < 3){
                    Conjunto nuevo = nuevoCamino(total, conjuntos);
                    conjuntos.add(nuevo);
                }
                else   
                    return false;
                if(solucionRecursiva(conjuntos, t, total))
                    return true;
            }
            conjuntos.remove(conjuntos.size()-1);
            return false;
        }
        if (conjunto.getHeuristica() == 8) {
            int checkpoint = -1; // Inicializar el checkpoint a un valor no válido
            boolean checkpoint2 = false;
            for (int i = 1; i <= 4; i++) {
                if (conjunto.getCuadrado(i).getNumero() == -1) {
                    checkpoint = i;
                        if(i == 3 && conjunto.getCuadrado(4).getNumero() == -1){
                            checkpoint2 = true;
                        }
                    break;
                }
            }

            if (checkpoint != -1) {
                // Resuelve hasta que esté correcto para que corra recursividad
                while(!conjuntos.isEmpty()) {
                    conjunto.getCuadrado(checkpoint).setNumero(-1);
                    if(checkpoint2)
                        conjunto.getCuadrado(4).setNumero(-1);
                    if (conjunto.solucionar()) {
                        List<Conjunto> vecinos = calcularVecinosExternos(conjuntos);
                        Conjunto mejorVecino = encontrarMejorHeuristica(vecinos);
                        if(mejorVecino != null && mejorVecino.getHeuristica() > 2)
                            conjuntos.add(mejorVecino);
                        else if (mejorVecino != null && mejorVecino.getHeuristica() < 3){
                            Conjunto nuevo = nuevoCamino(total, conjuntos);
                            conjuntos.add(nuevo);
                        }
                        if(solucionRecursiva(conjuntos, t, total))
                            return true;
                        conjuntos.remove(conjuntos.size()-1);
                        //conjunto.getCuadrado(checkpoint).setNumero(-1);
                        //if(checkpoint2)
                            //conjunto.getCuadrado(4).setNumero(-1);
                    }
                    conjunto.getCuadrado(checkpoint).setNumero(-1);
                    conjunto.calcularHeuristicas();
                    return false;
                }
            }
            return false;
        } else {
            int checkpoint = -1;
            int checkpoint2 = -1;
            for (int i = 1; i <= 4; i++) {
                if (conjunto.getCuadrado(i).getNumero() == -1) {
                    if (checkpoint == -1) {
                        checkpoint = i;
                    } else {
                        checkpoint2 = i;
                        break;
                    }
                }
            }
        

            if (checkpoint != -1 && checkpoint2 != -1) {
                for (int i = 0; i <= 10; i++) {
                    if (i == 10) {
                        conjunto.getCuadrado(checkpoint2).setNumero(-1);                  
                        conjunto.getCuadrado(checkpoint).setNumero(-1);
                        conjunto.calcularHeuristicas();
                        return false;
                    }

                    conjunto.getCuadrado(checkpoint2).setNumero(-1);                  
                    conjunto.getCuadrado(checkpoint).setNumero(i);

                    if (conjunto.solucionar()) {
                        List<Conjunto> vecinos = calcularVecinosExternos(conjuntos);
                        Conjunto mejorVecino = encontrarMejorHeuristica(vecinos);
                        if(mejorVecino != null && mejorVecino.getHeuristica() > 2)
                            conjuntos.add(mejorVecino);
                        else if (mejorVecino != null && mejorVecino.getHeuristica() < 3){
                            Conjunto nuevo = nuevoCamino(total, conjuntos);
                            conjuntos.add(nuevo);
                        }
                        if (solucionRecursiva(conjuntos, t, total))
                            return true;
                        conjuntos.remove(conjuntos.size()-1);
                        //conjunto.getCuadrado(checkpoint).setNumero(-1);
                        //conjunto.getCuadrado(checkpoint2).setNumero(-1);
                    } else {
                        conjunto.getCuadrado(checkpoint).setNumero(-1);
                        conjunto.getCuadrado(checkpoint2).setNumero(-1);
                        conjunto.calcularHeuristicas();
                    }
                }
            }

            return false;  // Si no se encontró una solución, devolvemos false
        }
    }
}
   