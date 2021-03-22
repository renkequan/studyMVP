package com.example.studyproject.ui.main.presenter;

import com.example.studyproject.ui.main.model.MainModel;
import com.example.studyproject.ui.main.view.IMainView;

public class MainPresenter implements IMainPresenter {

    private IMainView mIMainView;
    private MainModel mMainModel;

    public MainPresenter(IMainView view) {
        this.mIMainView = view;
        this.mMainModel = new MainModel(this);


    }

}
