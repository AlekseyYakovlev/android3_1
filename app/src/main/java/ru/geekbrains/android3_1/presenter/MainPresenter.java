package ru.geekbrains.android3_1.presenter;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import ru.geekbrains.android3_1.model.CounterModel;
import ru.geekbrains.android3_1.view.MainView;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView>
{
    private CounterModel model;

    public MainPresenter(CounterModel model)
    {
        this.model = model;
    }

    @Override
    protected void onFirstViewAttach()
    { 
        super.onFirstViewAttach();
    }

    public void buttonClick(int index)
    {
        int value = model.calculate(index);
        getViewState().setButtonText(index, value + "");
        Log.d("onButtonClick", "model.calculate index=" + index + " v=" + value);
    }
}
