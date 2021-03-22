package com.example.studyproject.ui.main.model;

import com.example.studyproject.ui.main.presenter.IMainPresenter;

public class MainModel {

    IMainPresenter mIMainPersenter;

    public MainModel(IMainPresenter presenter) {
        this.mIMainPersenter = presenter;
    }

    public void loadDate(){}
}
