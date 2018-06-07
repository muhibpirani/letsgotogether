package android.weildy.letsgotogether.activity;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.weildy.letsgotogether.BaseActivity;
import android.weildy.letsgotogether.R;
import android.weildy.letsgotogether.Utils;
import android.weildy.letsgotogether.http.FetchServiceBase;
import android.weildy.letsgotogether.http.model.AddCategoryResponse;
import android.widget.EditText;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by muhib on 11/16/2017.
 */
public class CategoryActivity extends BaseActivity {
    @Override
    public int getLayoutId() {
        return R.layout.activity_category;
    }

    @Override
    public void initialize() {

    }

    @Override
    public String toolbarTitle() {
        return "Categories";
    }

    @Override
    public boolean showBackButton() {
        return true;
    }

    @Override
    public void onToolBarAddClick() {
        showCustomDialog();

    }

    @Override
    protected boolean showAddButton() {
        return true;
    }

    private void showCustomDialog() {
        LayoutInflater layoutInflater=LayoutInflater.from(this);
        final View dialogView=layoutInflater.inflate(R.layout.add_category, null);
        final AlertDialog alertDialog=new AlertDialog.Builder(this).create();
        final EditText edt_catname;
        alertDialog.setView(dialogView);
        edt_catname=(EditText)dialogView.findViewById(R.id.edt_categoryname);
        dialogView.findViewById(R.id.txt_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt_catname.getText().toString().isEmpty()||edt_catname.getText().toString().equals(""))
                    Utils.showToast(CategoryActivity.this,"Enter Category Name");
                else {
                    alertDialog.dismiss();
                    addCategory(edt_catname.getText().toString());
                }
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

    private void addCategory(String categorname) {
        FetchServiceBase.getFetcherService().addCategory(categorname)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AddCategoryResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Utils.showToast(CategoryActivity.this,"Some Error");

                    }

                    @Override
                    public void onNext(AddCategoryResponse addProducttResponse) {
                        if(addProducttResponse.getStatus())
                            Utils.showToast(CategoryActivity.this,"Category Added");
                        else
                            Utils.showToast(CategoryActivity.this,"Some Error");

                    }
                });

    }
}
