package android.weildy.letsgotogether.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.weildy.letsgotogether.BaseNavigationActivity;
import android.weildy.letsgotogether.R;
import android.weildy.letsgotogether.adapter.CustomListAdapter;
import android.weildy.letsgotogether.http.model.ListBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseNavigationActivity {
     //MapView mapView;
    //private GoogleMap mGoogleMap;
    private RecyclerView custom_recycler;
    private List<ListBean> customList;
    private CustomListAdapter customListAdapter;
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
        custom_recycler=(RecyclerView)findViewById(R.id.custom_recycler);
        customList=new ArrayList<>();
        for(int i=0;i<10;i++)
        {
            ListBean listBean=new ListBean();
            listBean.setNo(String.valueOf(i));
            listBean.setTitle("Item" + i);
            customList.add(listBean);
        }

       /* mapView = (MapView) findViewById(R.id.mapview);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mGoogleMap = googleMap;
                mGoogleMap.setMyLocationEnabled(true);
            }
        });*/
        customListAdapter=new CustomListAdapter(customList);
        custom_recycler.setLayoutManager(new LinearLayoutManager(this));
        custom_recycler.setAdapter(customListAdapter);

    }

    @Override
    protected String toolBarTitle() {
        return "App Name";
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
