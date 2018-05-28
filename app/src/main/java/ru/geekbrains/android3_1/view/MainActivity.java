package ru.geekbrains.android3_1.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import ru.geekbrains.android3_1.R;
import ru.geekbrains.android3_1.model.CounterModel;
import ru.geekbrains.android3_1.presenter.MainPresenter;
import timber.log.Timber;

public class MainActivity extends MvpAppCompatActivity implements MainView {
    @BindView(R.id.btn_one)
    Button buttonOne;

    @BindView(R.id.btn_two)
    Button buttonTwo;

    @BindView(R.id.btn_three)
    Button buttonThree;

    @InjectPresenter
    MainPresenter presenter;

    Observer<String> buttonOneTextSetter = new Observer<String>() {
        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(String s) {
            buttonOne.setText(s);
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    };
    Observer<String> buttonTwoTextSetter = new Observer<String>() {
        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(String s) {
            buttonTwo.setText(s);
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    };
    Observer<String> buttonThreeTextSetter = new Observer<String>() {
        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(String s) {
            buttonThree.setText(s);
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    };
    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    @ProvidePresenter
    public MainPresenter provideMainPresenter() {
        return new MainPresenter(new CounterModel());
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (presenter.buttonOneText == null) Log.d("rrrrrrrrr", "presentor is null");
        else {
            Log.d("rrrrrrrrr", "presentor is NOT null");

            presenter.buttonOneText.subscribe(buttonOneTextSetter);
            presenter.buttonTwoText.subscribe(buttonTwoTextSetter);
            presenter.buttonThreeText.subscribe(buttonThreeTextSetter);
        }
    }

    @OnClick({R.id.btn_one, R.id.btn_two, R.id.btn_three})
    public void onButtonClick(Button button) {
        int id = -1;
        switch (button.getId()) {
            case R.id.btn_one:
                id = 0;
                presenter.buttonOneText.subscribe(buttonOneTextSetter);
                break;
            case R.id.btn_two:
                id = 1;
                presenter.buttonTwoText.subscribe(buttonTwoTextSetter);
                break;
            case R.id.btn_three:
                id = 2;
                presenter.buttonThreeText.subscribe(buttonThreeTextSetter);
                break;
        }

        presenter.buttonClick(id);
    }


    @Override
    public void setButtonOneText(String text) {
        Log.d("rrrrrrrrr", "1 - " + text);
        Timber.d(text);
    }

    @Override
    public void setButtonTwoText(String text) {
        Log.d("rrrrrrrrr", "2 - " + text);
        Timber.d(text);
    }

    @Override
    public void setButtonThreeText(String text) {
        Log.d("rrrrrrrrr", "3 - " + text);
        Timber.d(text);
    }
}
