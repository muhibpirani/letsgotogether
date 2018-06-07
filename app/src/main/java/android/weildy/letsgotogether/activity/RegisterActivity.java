package android.weildy.letsgotogether.activity;

import android.app.ProgressDialog;
import android.view.View;
import android.weildy.letsgotogether.BaseActivity;
import android.weildy.letsgotogether.R;
import android.weildy.letsgotogether.Utils;
import android.weildy.letsgotogether.http.FetchServiceBase;
import android.weildy.letsgotogether.http.model.RegisterResponse;
import android.widget.EditText;
import android.widget.TextView;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {
    private TextView txt_register_register;
    private EditText edt_register_phone,edt_register_password,edt_register_name
            ,edt_register_pincode,edt_register_city,edt_register_addedby,edt_register_utype;
    private ProgressDialog progressDialog;

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void initialize() {
        txt_register_register=(TextView)findViewById(R.id.txt_register_register);
        edt_register_phone=(EditText)findViewById(R.id.edt_register_phone);
        edt_register_pincode=(EditText)findViewById(R.id.edt_register_pincode);
        edt_register_password=(EditText)findViewById(R.id.edt_register_password);
        edt_register_name=(EditText)findViewById(R.id.edt_register_name);
        edt_register_addedby=(EditText)findViewById(R.id.edt_register_addedby);
        edt_register_city=(EditText)findViewById(R.id.edt_register_city);
        edt_register_utype=(EditText)findViewById(R.id.edt_register_utype);
        progressDialog=new ProgressDialog(this);
        progressDialog.setCancelable(false);


        txt_register_register.setOnClickListener(this);

    }

    @Override
    public String toolbarTitle() {
        return "Register";
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

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.txt_register_register:
                if (edt_register_phone.getText().toString().length()==10)
                    if(edt_register_password.getText().toString().length()>=4)
                        if (!edt_register_name.getText().toString().isEmpty())
                            if(!edt_register_city.getText().toString().isEmpty())
                                if(!edt_register_pincode.getText().toString().isEmpty())
                                    if(!edt_register_addedby.getText().toString().isEmpty())
                                        if(!edt_register_utype.getText().toString().isEmpty())
                                            callRegister();
                                        else
                                            Utils.showToast(this,"Please enter user type");
                                    else
                                        Utils.showToast(this,"Please enter added by");
                                else
                                    Utils.showToast(this,"Please enter pincode");
                            else
                                Utils.showToast(this,"Please enter city name");
                        else
                            Utils.showToast(this,"Please enter name");
                    else
                        Utils.showToast(this,"Password must be aleast 4 charactres");
                else
                    Utils.showToast(this,"Please enter valid phone number");
                break;
        }
    }

    private void callRegister() {
        progressDialog.setMessage("Please Wait");
        progressDialog.show();
        FetchServiceBase.getFetcherService().register(edt_register_phone.getText().toString(),edt_register_name.getText().toString(),
                edt_register_city.getText().toString(),edt_register_utype.getText().toString(),edt_register_pincode.getText().toString(),edt_register_password.getText().toString()
                 ,edt_register_addedby.getText().toString())
                .subscribeOn(rx.schedulers.Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<RegisterResponse>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        progressDialog.dismiss();
                        Utils.showToast(RegisterActivity.this,"Some error");
                    }

                    @Override
                    public void onNext(RegisterResponse registerResponse) {
                        progressDialog.dismiss();
                        Utils.showToast(RegisterActivity.this,"User Registered");
                    }
                });
    }
}
