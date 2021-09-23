/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.util.Random;

/**
 *
 * @author alanm
 */
public class GeneradorIdPacs {

    private String fechaAsignado;
    private String fechaVenta;
    private long equipoDicom;
    private String curp;

    public String generarIdPacs() {
        //Es posible hacerlo de quince caracteres por la base de datos
        //Los primeros dos dígitos van a ser el año - 2000
        //El siguiente caracter es la letra correspondiente al mes
        //El siguiente caracter es el día de venta % 25
        //Hay que relacionar la sala del estudio, puede ser con el id del equipo dicom % 20 convertido a letra
        //El siguiente dpigito puede ser la hora de venta en letra
        //Los siguientes dos dígitos puede ser los minutos
        //Los siguientes tres dígitos es la suma de la curp
        //Sobran cuatro, que se vayan dos letras aleatorias y dos numeros aleatorios
        int primerosDosDigitos = obtenerUltimosDosDigitosDeAnio(fechaAsignado);
        char tercero = letraCorrespondiente(mesDeFecha(fechaAsignado));
        char cuarto = letraCorrespondiente(diaDeFecha(fechaAsignado) % 25);
        char quinto = letraCorrespondiente(equipoDicom % 10);
        char sexto = letraCorrespondiente(horaDeFecha(fechaVenta));
        String septimoOctavo = minutosDeFecha(fechaVenta);
        int novenoDecimoOnceavo = sumarCurp(curp);
        char doceavo = letraAleatoria();
        int treceavo = numeroAleatorio(0, 9);
        char catorceavo = letraAleatoria();
        int quinceavo = numeroAleatorio(0, 9);

       
        return ((primerosDosDigitos + "")
                + (tercero + "")
                + (cuarto + "" )
                + (quinto+ "" )
                + (sexto+ "" )
                + (septimoOctavo+ "")
                + (novenoDecimoOnceavo+ "")
                + (doceavo+ "")
                + (treceavo+ "")
                + (catorceavo+ "")
                + (quinceavo+ ""));
    }

    private int obtenerUltimosDosDigitosDeAnio(String fecha) {
        String anio = "";
        for (int i = 0; i < 4; i++) {
            anio += fecha.charAt(i);
        }
        System.out.println(Integer.parseInt(anio) % 1000);
        return Integer.parseInt(anio) % 1000;
    }

    private char letraCorrespondiente(long l) {
        if (l == 0) {
            return 'A';
        }
        if (l == 1) {
            return 'B';
        }
        if (l == 2) {
            return 'C';
        }
        if (l == 3) {
            return 'D';
        }
        if (l == 4) {
            return 'E';
        }
        if (l == 5) {
            return 'F';
        }
        if (l == 6) {
            return 'G';
        }
        if (l == 7) {
            return 'H';
        }
        if (l == 8) {
            return 'I';
        }
        if (l == 9) {
            return 'J';
        }
        if (l == 10) {
            return 'K';
        }
        if (l == 11) {
            return 'L';
        }
        if (l == 12) {
            return 'M';
        }
        if (l == 13) {
            return 'N';
        }
        if (l == 14) {
            return 'O';
        }
        if (l == 15) {
            return 'P';
        }
        if (l == 16) {
            return 'Q';
        }
        if (l == 17) {
            return 'R';
        }
        if (l == 18) {
            return 'S';
        }
        if (l == 19) {
            return 'T';
        }
        if (l == 20) {
            return 'U';
        }
        if (l == 21) {
            return 'V';
        }
        if (l == 22) {
            return 'W';
        }
        if (l == 23) {
            return 'X';
        }
        if (l == 24) {
            return 'Y';
        }
        if (l == 25) {
            return 'Z';
        }
        return '.';
    }

    private long mesDeFecha(String fecha) {
        String mes = "";
        for (int i = 5; i < 7; i++) {
            mes += fecha.charAt(i);
        }
        System.out.println("Mes = " + mes);
        return Long.parseLong(mes);
    }

    private long diaDeFecha(String fecha) {
        String dia = "";
        for (int i = 8; i < 10; i++) {
            dia += fecha.charAt(i);
        }
        System.out.println("Dia = " + dia);
        return Long.parseLong(dia);
    }

    private long horaDeFecha(String fecha) {
        String hora = "";
        for (int i = 11; i < 13; i++) {
            hora += fecha.charAt(i);
        }
        return Long.parseLong(hora);
    }

    private String minutosDeFecha(String fecha) {
        String minutos = "";
        for (int i = 14; i < 16; i++) {
            minutos += fecha.charAt(i);
        }
        return minutos;
    }

    private int sumarCurp(String curp) {
        char actual;
        int letra;
        int total = 0;
        for (int i = 0; i < curp.length(); i++) {
            actual = curp.charAt(i);
            if (actual >= 'A' && actual <= 'Z') {
                letra = letraAInt(actual);
                total += letra;
            } else {
                total += Integer.parseInt(actual + "");
            }
        }
        return total;
    }

    private char letraAleatoria() {
        return letraCorrespondiente(numeroAleatorio(0, 25));
    }

    private int numeroAleatorio(int inicio, int fin) {
        Random rand = new Random();
        return (inicio + rand.nextInt((fin - inicio) + 1));
    }

    public String getFechaAsignado() {
        return fechaAsignado;
    }

    public void setFechaAsignado(String fechaAsignado) {
        this.fechaAsignado = fechaAsignado;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public long getEquipoDicom() {
        return equipoDicom;
    }

    public void setEquipoDicom(long equipoDicom) {
        this.equipoDicom = equipoDicom;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    private int letraAInt(char actual) {
        switch (actual) {
            case 'A':
                return 1;
            case 'B':
                return 2;
            case 'C':
                return 3;
            case 'D':
                return 4;
            case 'E':
                return 5;
            case 'F':
                return 6;
            case 'G':
                return 7;
            case 'H':
                return 8;
            case 'I':
                return 9;
            case 'J':
                return 10;
            case 'K':
                return 11;
            case 'L':
                return 12;
            case 'M':
                return 13;
            case 'N':
                return 14;
            case 'O':
                return 15;
            case 'P':
                return 16;
            case 'Q':
                return 17;
            case 'R':
                return 18;
            case 'S':
                return 19;
            case 'T':
                return 20;
            case 'U':
                return 21;
            case 'V':
                return 22;
            case 'W':
                return 23;
            case 'X':
                return 24;
            case 'Y':
                return 25;
            case 'Z':
                return 26;
            default:
                return 30;
        }
    }

}
