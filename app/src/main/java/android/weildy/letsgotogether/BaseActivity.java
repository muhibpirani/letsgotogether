package android.weildy.letsgotogether;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by muhib on 9/30/2017.
 */
public abstract class BaseActivity extends AppCompatActivity {

    public abstract int getLayoutId();

    public abstract void initialize();

    public abstract String toolbarTitle();

    public abstract boolean showBackButton();

    private View activitybaseView;
    private LinearLayout mLinearLayout;
    private TextView txt_toolbar;
    private FrameLayout layout_container;
    private ImageView img_back;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initialize();
    }

    @Override
    public void setContentView(int layoutResID) {
        mLinearLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.activity_normal_base, null);
        txt_toolbar = (TextView) mLinearLayout.findViewById(R.id.txt_toolbar);
        img_back = (ImageView) mLinearLayout.findViewById(R.id.img_back);
        img_back.setVisibility(showBackButton() ? View.VISIBLE : View.GONE);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        txt_toolbar.setText(toolbarTitle());
        layout_container = (FrameLayout) mLinearLayout.findViewById(R.id.layout_container);
        activitybaseView = getLayoutInflater().inflate(layoutResID, null);
        layout_container.addView(activitybaseView);
        super.setContentView(mLinearLayout);
    }
}
