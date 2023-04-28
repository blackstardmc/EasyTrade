package com.blackneko.easytrade;

public class ManualTradeUseCase {


    public static String ganancia(String pcompra,String pventa,String inversion){
        return String.valueOf((Float.parseFloat(pventa)/Float.parseFloat(pcompra)
                *Float.parseFloat(inversion))
                -Float.parseFloat(inversion));
    }
    public static String gananciaTotal(String pcompra,String pventa,String inversion){
        return String.valueOf((Float.parseFloat(pventa)/Float.parseFloat(pcompra)
                *Float.parseFloat(inversion)));
    }
    public static String perdida(String inversion,String stopLoss){
        return String.valueOf(Float.parseFloat(stopLoss)/100*Float.parseFloat(inversion));
    }
    public static String perdidaTotal(String inversion,String stopLoss){

        return String.valueOf(Float.parseFloat(inversion)-
                Float.parseFloat(perdida(inversion,stopLoss)));
    }
    public static String progresBarAction(String position,String pcompra){
        return String.valueOf((Float.parseFloat(position)/100*Float.parseFloat(pcompra))
                +Float.parseFloat(pcompra));
    }

}
