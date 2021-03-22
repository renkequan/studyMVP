package com.example.studyproject.ui.main.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.studyproject.R;
import com.example.studyproject.base.ui.BaseActivity;
import com.example.studyproject.ui.main.model.MainModelBean;
import com.example.studyproject.ui.main.presenter.IMainPresenter;
import com.example.studyproject.ui.main.presenter.MainPresenter;
import com.example.studyproject.ui.main.view.IMainView;

public class MainActivity extends BaseActivity implements IMainView {

    MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    @Override
    protected void initView() {
        mMainPresenter = new MainPresenter(this);
    }

    @Override
    public void run() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showDate(MainModelBean mainModelBean) {

    }
}