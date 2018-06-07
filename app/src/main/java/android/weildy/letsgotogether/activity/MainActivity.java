package android.weildy.letsgotogether.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.weildy.letsgotogether.BaseNavigationActivity;
import android.weildy.letsgotogether.R;
import android.weildy.letsgotogether.adapter.CustomListAdapter;
import android.weildy.letsgotogether.http.model.ListBean;
import android.widget.LinearLayout;

import java.util.List;

public class MainActivity extends BaseNavigationActivity implements View.OnClickListener {
     //MapView mapView;
    //private GoogleMap mGoogleMap;
    //private RecyclerView custom_recycler;
    private List<ListBean> customList;
    private CustomListAdapter customListAdapter;
    private LinearLayout ll_product,ll_sales,ll_order,ll_category;
    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_main;
    }

    @Override
    protected boolean useNavDrawer() {
        return true;
    }

    @Override
    protected int getMenuLayout() {
        return 0;
    }

    @Override
    protected int getHeaderLayout() {
        return 0;
    }

    @Override
    protected void initialization(Bundle savedInstanceState) {
       // custom_recycler=(RecyclerView)findViewById(R.id.custom_recycler);
        //customList=new ArrayList<>();
       /* for(int i=0;i<10;i++)
        {
            ListBean listBean=new ListBean();
            listBean.setNo(String.valueOf(i));
            listBean.setTitle("Item" + i);
            customList.add(listBean);
        }*/
       // customListAdapter=new CustomListAdapter(customList);
        ll_product=(LinearLayout)findViewById(R.id.ll_product);
        ll_sales=(LinearLayout)findViewById(R.id.ll_sales);
        ll_order=(LinearLayout)findViewById(R.id.ll_order);
        ll_category=(LinearLayout)findViewById(R.id.ll_category);
        ll_product.setOnClickListener(this);
        ll_order.setOnClickListener(this);
        ll_sales.setOnClickListener(this);
        ll_category.setOnClickListener(this);
        //custom_recycler.setLayoutManager(new LinearLayoutManager(this));
        //custom_recycler.setAdapter(customListAdapter);

    }

    @Override
    protected String toolBarTitle() {
        return "App Name";
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.ll_product:
                Intent intent=new Intent(this,ProductActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_order:
                Intent intent1=new Intent(this,OrderActivity.class);
                startActivity(intent1);
                break;
            case R.id.ll_sales:
                Intent intent2=new Intent(this,SalesActivity.class);
                startActivity(intent2);
                break;
            case R.id.ll_category:
                Intent intent3=new Intent(this,CategoryActivity.class);
                startActivity(intent3);
                break;
        }
    }


    /*@Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }*/

}
