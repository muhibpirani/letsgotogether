package android.weildy.letsgotogether.activity;

import android.weildy.letsgotogether.BaseActivity;
import android.weildy.letsgotogether.R;

public class RegisterActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void initialize() {

    }

    @Override
    public String toolbarTitle() {
        return "Register";
    }

    @Override
    public boolean showBackButton() {
        return false;
    }
}
