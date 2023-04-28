package com.blackneko.easytrade;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GridBotViewModel extends ViewModel {
    private MutableLiveData<String[]> gridBotArray;

    public GridBotViewModel() {
        gridBotArray = new MutableLiveData<String[]>();
    }
    public LiveData<String[]>getGridBotArray(){
        return gridBotArray;
    }
    public void setGridBotArray(String pcompra, String pventa, String inversion, String grids) {
        gridBotArray.setValue(new String[]{GridBotUseCase.usdtForGrid(inversion, grids),
                GridBotUseCase.porcentageForGrid(pcompra, pventa, grids),
                GridBotUseCase.gananciaForGrid(pcompra, pventa, inversion, grids)
                , GridBotUseCase.porcentageInversion(pcompra, pventa, inversion, grids)
                , GridBotUseCase.stopLossAconsejado(pcompra),
                GridBotUseCase.rangogrid(pcompra,pventa,grids)
        });

    }
}
