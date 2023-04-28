package com.blackneko.easytrade;

public class GridBotUseCase {
    public static String usdtForGrid(String inversion,String grids){
        /*Seria solamente inv/grids
        usdtg
         */
        return String.valueOf(Float.parseFloat(inversion)/Float.parseFloat(grids));
    }
    public static String porcentageForGrid(String pcompra,String pventa,String grids){
        /*Se necesita precio min,max,inv,grids
        Seria algo asi
        min/max=%/100
        100min/max=%
        Luego
        %/grids
         */
        return String.valueOf((Float.parseFloat(pventa)*100/Float.parseFloat(pcompra)-100)/
                Float.parseFloat(grids));
    }
    public static String gananciaForGrid(String pcompra,String pventa,String inversion,String grids){
        /*
        gfg/usdt=pfg/100
        gfg=pfg*usdt/100
        */
        return String.valueOf(Float.parseFloat(porcentageForGrid(pcompra, pventa, grids))*Float.parseFloat(usdtForGrid(inversion, grids))/100);


    }
    public static String porcentageInversion(String pcompra,String pventa,String inversion,String grids){

             /*
             gfg/inversion=%/100
             gfg*100/inversion=%I
             */
             return String.valueOf(100*Float.parseFloat(gananciaForGrid(pcompra, pventa, inversion, grids))/Float.parseFloat(inversion));


    }
    public static String stopLossAconsejado(String pcompra){
        return String.valueOf(Float.parseFloat(pcompra)*0.9);

    }
public static String rangogrid(String pcompra,String pventa,String grids){
        return String.valueOf((Float.parseFloat(pventa)-Float.parseFloat(pcompra))/Float.parseFloat(grids));
}
    /*
    pcompra*0.9
    */

}
