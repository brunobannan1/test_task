package org.nick.dao;

import org.nick.model.*;

import java.util.ArrayList;
import java.util.List;

@lombok.Data
public class FormsDataAsList {
    private List<Data> dataList = new ArrayList<>();
    private List<Rates> ratesList = new ArrayList<>();
    private List<Rate> rateList = new ArrayList<>();
    private List<Form> formList = new ArrayList<>();
    private int formsId;
    private boolean success;
    private String dateUpload;

    public FormsDataAsList retrieve(Forms forms) {
        List<Form> formList = forms.getForms();
        for (Form form : formList) {
            dataList.add(form.getData());
            ratesList.add(form.getRates());
        }

        for (Rates rates : ratesList) {
            for (int i = 0; i < rates.getRates().size(); i++) {
                rateList.add(rates.getRates().get(i));
            }
        }
        formsId = forms.getId();
        success = forms.getSuccess();
        dateUpload = forms.getUploadDate();
        return this;
    }

}
