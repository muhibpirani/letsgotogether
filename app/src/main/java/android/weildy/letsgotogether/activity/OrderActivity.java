package android.weildy.letsgotogether.activity;

import android.weildy.letsgotogether.BaseActivity;
import android.weildy.letsgotogether.R;

/**
 * Created by muhib on 11/15/2017.
 */
public class OrderActivity extends BaseActivity {
    @Override
    public int getLayoutId() {
        return R.layout.activity_order;
    }

    @Override
    public void initialize() {

    }

    @Override
    public String toolbarTitle() {
        return "Orders";
    }

    @Override
    public boolean showBackButton() {
        return true;
    }

    @Override
    public void onToolBarAddClick() {

    }

    @Override
    protected boolean showAddButton() {
        return false;
    }
}
