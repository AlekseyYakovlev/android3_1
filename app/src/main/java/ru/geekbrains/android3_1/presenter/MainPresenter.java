package ru.geekbrains.android3_1.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import io.reactivex.Observable;
import ru.geekbrains.android3_1.model.CounterModel;
import ru.geekbrains.android3_1.view.MainView;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {
    private CounterModel model;

    public MainPresenter(CounterModel model) {
        this.model = model;
    }

    public Observable<String> buttonOneText;
    public Observable<String> buttonTwoText;
    public Observable<String> buttonThreeText;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        //buttonOneText = Observable.create(e -> e.onNext(someText));
        buttonOneText = Observable.just("0");
        buttonTwoText = Observable.just("0");
        buttonThreeText = Observable.just("0");
    }


    public void buttonClick(int id) {
        if (id >= 0 && id <= 2) {
            int value = model.calculate(id);

            switch (id) {
                case 0:
                    getViewState().setButtonOneText(value + "");
                    buttonOneText = Observable.just(value + "");
                    break;
                case 1:
                    getViewState().setButtonTwoText(value + "");
                    buttonTwoText = Observable.just(value + "");
                    break;
                case 2:
                    getViewState().setButtonThreeText(value + "");
                    buttonThreeText = Observable.just(value + "");
                    break;
            }
        }
    }
}
