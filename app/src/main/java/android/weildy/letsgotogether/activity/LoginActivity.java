package android.weildy.letsgotogether.activity;

import android.content.Intent;
import android.view.View;
import android.weildy.letsgotogether.BaseActivity;
import android.weildy.letsgotogether.R;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

public class LoginActivity extends BaseActivity implements View.OnClickListener,GoogleApiClient.OnConnectionFailedListener {
    private static final String TAG =LoginActivity.class.getSimpleName() ;
    private TextView txt_login,txt_register;
  //  private TextView txt_signin;
    //private GoogleApiClient mGoogleApiClient;
    //private static final int RC_SIGN_IN = 007;
    //private FirebaseAuth mAuth;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initialize() {
       /* txt_signin = (TextView) findViewById(R.id.txt_signin);
        txt_signin.setOnClickListener(this);*/
      /*  GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.firebasewebapi))
                .requestEmail()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();


        mAuth = FirebaseAuth.getInstance();*/
        txt_login=(TextView)findViewById(R.id.txt_login);
        txt_register=(TextView)findViewById(R.id.txt_register);
        txt_login.setOnClickListener(this);
        txt_register.setOnClickListener(this);



    }

    @Override
    public String toolbarTitle() {
        return "Login";
    }

    @Override
    public boolean showBackButton() {
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txt_login:
                Intent intent=new Intent(this,MainActivity.class);
                startActivity(intent);
                //signInWithGoogle();
                break;
            case R.id.txt_register:
                Intent intent1=new Intent(this,RegisterActivity.class);
                startActivity(intent1);
                break;
        }
    }

    /*private void signInWithGoogle() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);

    }*/

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        /*if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = result.getSignInAccount();
                firebaseAuthWithGoogle(account);
            } else {
                // Google Sign In failed, update UI appropriately
                // ...
            }
        }*/

    }

    /*private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }*/
}
