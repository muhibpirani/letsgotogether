package android.weildy.letsgotogether.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.weildy.letsgotogether.BaseActivity;
import android.weildy.letsgotogether.R;
import android.weildy.letsgotogether.adapter.CartListAdapter;
import android.weildy.letsgotogether.http.model.ListBean;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends BaseActivity {
    private RecyclerView cart_recycler;
    private CartListAdapter cartListAdapter;
    private List<ListBean> listBeans;

    @Override
    public int getLayoutId() {
        return R.layout.activity_cart;
    }

    @Override
    public void initialize() {
        cart_recycler=(RecyclerView)findViewById(R.id.cart_recycler);
        listBeans=new ArrayList<>();
        for(int i=0;i<10;i++)
        {
            ListBean listBean=new ListBean();
            listBean.setTitle("Cart Item"+i);
            listBean.setNo(String.valueOf(i));
            listBeans.add(listBean);
        }
        cartListAdapter=new CartListAdapter(listBeans,this);
        cart_recycler.setLayoutManager(new LinearLayoutManager(this));
        cart_recycler.setAdapter(cartListAdapter);


    }

    @Override
    public String toolbarTitle() {
        return "Cart";
    }

    @Override
    public boolean showBackButton() {
        return true;
    }
}
