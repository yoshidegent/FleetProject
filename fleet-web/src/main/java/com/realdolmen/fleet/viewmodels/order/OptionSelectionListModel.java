package com.realdolmen.fleet.viewmodels.order;

import com.realdolmen.fleet.CarOption;

import java.io.Serializable;
import java.util.List;

public class OptionSelectionListModel implements Serializable {
    private List<CarOption> data;
    private List<CarOption> selection;

    public OptionSelectionListModel(List<CarOption> data) {
        this.data = data;
    }

    public List<CarOption> getData() {
        return data;
    }

    public void setData(List<CarOption> data) {
        this.data = data;
    }

    public List<CarOption> getSelection() {
        return selection;
    }

    public void setSelection(List<CarOption> selection) {
        this.selection = selection;
    }
}
