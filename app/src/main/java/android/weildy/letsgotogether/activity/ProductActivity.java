package android.weildy.letsgotogether.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.weildy.letsgotogether.BaseActivity;
import android.weildy.letsgotogether.R;
import android.weildy.letsgotogether.Utils;
import android.weildy.letsgotogether.adapter.CustomListAdapter;
import android.weildy.letsgotogether.http.FetchServiceBase;
import android.weildy.letsgotogether.http.model.AddProducttResponse;
import android.weildy.letsgotogether.http.model.ProductListResponse;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by muhib on 11/15/2017.
 */
public class ProductActivity extends BaseActivity {
    private RecyclerView recycler_products;
    private List<List<String>> data;
    private CustomListAdapter customListAdapter;
    private ProgressDialog progressDialog;
    @Override
    public int getLayoutId() {
        return R.layout.activity_product;
    }

    @Override
    public void initialize() {
        progressDialog=new ProgressDialog(this);
        data=new ArrayList<>();
        recycler_products=(RecyclerView)findViewById(R.id.recycler_products);
        recycler_products.setLayoutManager(new LinearLayoutManager(this));
        customListAdapter=new CustomListAdapter(this,data);
        recycler_products.setAdapter(customListAdapter);


    }

    @Override
    protected void onResume() {
        super.onResume();
        callListApi();
    }

    private void callListApi() {
        progressDialog.setMessage("please wait");
        progressDialog.setCancelable(false);
        progressDialog.show();
        FetchServiceBase.getFetcherService().getProductList()
                .subscribeOn(rx.schedulers.Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ProductListResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        progressDialog.dismiss();
                        Utils.showToast(ProductActivity.this, "Some Error");
                    }

                    @Override
                    public void onNext(ProductListResponse productListResponse) {
                        progressDialog.dismiss();
                        if (productListResponse.getData() != null) {
                            data.addAll(productListResponse.getData());
                            customListAdapter.notifyDataSetChanged();
                        }

                    }
                });
    }

    @Override
    public String toolbarTitle() {
        return "Products";
    }

    @Override
    public boolean showBackButton() {
        return true;
    }

    @Override
    public void onToolBarAddClick() {
        showCustomDialog();
    }

    private void showCustomDialog() {
        LayoutInflater layoutInflater=LayoutInflater.from(this);
        final View dialogView=layoutInflater.inflate(R.layout.add_product, null);
        final AlertDialog alertDialog=new AlertDialog.Builder(this).create();
        final EditText edt_productname,edt_catname,edt_price1,edt_price2,edt_price3,edt_price4,edt_price5;
        alertDialog.setView(dialogView);
        edt_productname=(EditText)dialogView.findViewById(R.id.edt_productname);
        edt_catname=(EditText)dialogView.findViewById(R.id.edt_prodcat);
        edt_price1=(EditText)dialogView.findViewById(R.id.edt_price1);
        edt_price2=(EditText)dialogView.findViewById(R.id.edt_price2);
        edt_price3=(EditText)dialogView.findViewById(R.id.edt_price3);
        edt_price4=(EditText)dialogView.findViewById(R.id.edt_price4);
        edt_price5=(EditText)dialogView.findViewById(R.id.edt_price5);
        dialogView.findViewById(R.id.txt_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                addProductApiCall(edt_productname.getText().toString(),edt_catname.getText().toString()
                                    ,edt_price1.getText().toString(),edt_price2.getText().toString(),
                        edt_price3.getText().toString(),edt_price4.getText().toString(),edt_price5.getText().toString());
            }

        });
        dialogView.findViewById(R.id.txt_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        alertDialog.show();


    }

    private void addProductApiCall(String prodname, String catname, String price1, String price2, String price3, String price4, String price5) {
        FetchServiceBase.getFetcherService().addProduct(prodname,catname,price1,price2,price3,price4,price5)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AddProducttResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Utils.showToast(ProductActivity.this,"Some Error");
                    }

                    @Override
                    public void onNext(AddProducttResponse productListResponse) {
                        if(productListResponse.getStatus())
                            Utils.showToast(ProductActivity.this,"Product added");
                        else
                            Utils.showToast(ProductActivity.this,"Some error");

                    }
                });
    }


    protected boolean showAddButton() {
        return true;
    }
}
