package android.weildy.letsgotogether.activity;

import android.weildy.letsgotogether.BaseActivity;
import android.weildy.letsgotogether.R;

public class NotificationActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_notification;
    }

    @Override
    public void initialize() {

    }

    @Override
    public String toolbarTitle() {
        return "Notifications";
    }

    @Override
    public boolean showBackButton() {
        return true;
    }
}
