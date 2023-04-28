package com.blackneko.easytrade;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ManualTradeViewModel extends ViewModel {

    private MutableLiveData<String[]> manualTradeArray;
    private MutableLiveData<String> myProgresBar;


    public ManualTradeViewModel() {
        manualTradeArray = new MutableLiveData<String[]>();
        myProgresBar = new MutableLiveData<String>();
    }

    public LiveData<String[]> getManualTradeArray() {
        return manualTradeArray;
    }

    public void setMyProgressBar(String position, String pcompra) {
        myProgresBar.setValue(ManualTradeUseCase.progresBarAction(position, pcompra));
    }

    public LiveData<String> getMyProgressBar() {
        return myProgresBar;
    }


    public void obtener(String pcompra, String pventa, String inversion, String stopLoss) {

        manualTradeArray.setValue(new String[]{(ManualTradeUseCase.ganancia(pcompra, pventa, inversion)),
                (ManualTradeUseCase.gananciaTotal(pcompra, pventa, inversion)),
                (ManualTradeUseCase.perdida(inversion, stopLoss)),
                (ManualTradeUseCase.perdidaTotal(inversion, stopLoss))
        });


    }
}
//    public LiveData<String> getGananciaTotal() {
//      return gananciaTotal;
//  }
//  public LiveData<String> getGanancia() {
//      return ganancia;
//  }
//  public LiveData<String> getPerdida() {
//      return perdida;
//  }
//  public LiveData<String> getPerdidaTotal() {
//      return perdidaTotal;
//  }
/*String pcompra,String pventa,String inversion,String stopLoss
manualTradeList=new List<>();
        ganancia.setValue(ManualTradeUseCase.ganancia(pcompra,pventa,inversion));
        gananciaTotal.setValue(ManualTradeUseCase.gananciaTotal(pcompra,pventa,inversion));
        perdida.setValue(ManualTradeUseCase.perdida(inversion,stopLoss));
        perdidaTotal.setValue(ManualTradeUseCase.perdidaTotal(inversion,stopLoss));
  */


