package ru.geekbrains.android3_1.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import ru.geekbrains.android3_1.model.CounterModel;
import ru.geekbrains.android3_1.view.MainView;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {
    private CounterModel model;

    public MainPresenter(CounterModel model) {
        this.model = model;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

    public void buttonClick(int id) {
        if (id >= 0 && id <= 2) {
            int value = model.calculate(0);

            switch (id) {
                case 0:
                    getViewState().setButtonOneText(value + "");
                    break;
                case 1:
                    getViewState().setButtonTwoText(value + "");
                    break;
                case 2:
                    getViewState().setButtonThreeText(value + "");
                    break;
            }
        }
    }
}
