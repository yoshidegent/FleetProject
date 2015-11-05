package com.realdolmen.fleet.viewmodels.order;

import com.realdolmen.fleet.CarOption;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class OptionSelectionListModel implements Serializable {
    private List<CarOption> data = new ArrayList<>();
    private List<Long> selection = new ArrayList<>();

    public OptionSelectionListModel(Collection<CarOption> data) {
        this.data.addAll(data);
    }

    public List<CarOption> getData() {
        return data;
    }

    public void setData(List<CarOption> data) {
        this.data = data;
    }

    public List<Long> getSelection() {
        return selection;
    }

    public void setSelection(List<Long> selection) {
        this.selection = selection;
    }
}
