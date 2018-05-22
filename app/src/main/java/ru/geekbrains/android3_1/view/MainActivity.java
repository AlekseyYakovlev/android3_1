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
import ru.geekbrains.android3_1.R;
import ru.geekbrains.android3_1.model.CounterModel;
import ru.geekbrains.android3_1.presenter.MainPresenter;

public class MainActivity extends MvpAppCompatActivity implements MainView {
    @BindView(R.id.btn_one)
    Button buttonOne;

    @BindView(R.id.btn_two)
    Button buttonTwo;

    @BindView(R.id.btn_three)
    Button buttonThree;

    @InjectPresenter
    MainPresenter presenter;

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

    @OnClick({R.id.btn_one, R.id.btn_two, R.id.btn_three})
    public void onButtonClick(Button button) {
        int buttonNum = -1;
        switch (button.getId()) {
            case R.id.btn_one:
                buttonNum = 0;
                Log.d("onButtonClick", "0");
                break;
            case R.id.btn_two:
                buttonNum = 1;
                Log.d("onButtonClick", "1");
                break;
            case R.id.btn_three:
                buttonNum = 2;

                break;
        }
        Log.d("onButtonClick", "Button " + buttonNum + " clicked");
        presenter.buttonClick(buttonNum);
    }


    @Override
    public void setButtonText(int index, String text) {
        buttonThree.setText(text);
        switch (index) {
            case 0:
                buttonOne.setText(text);
                Log.d("onButtonClick", "buttonOne setText " + text);
                break;
            case 1:
                buttonTwo.setText(text);
                Log.d("onButtonClick", "buttonTwo setText " + text);
                break;
            case 2:
                buttonThree.setText(text);
                Log.d("onButtonClick", "buttonThree setText " + text);
                break;
        }
    }
}
