package com.example.studyproject.ui.main.view;

import com.example.studyproject.ui.main.model.MainModelBean;

public interface IMainView {
    void showLoading();

    void hideLoading();

    void showDate(MainModelBean mainModelBean);
}
