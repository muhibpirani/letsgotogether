package android.weildy.letsgotogether.http.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Messageregister {

@SerializedName("uid")
@Expose
private String uid;
@SerializedName("pwd")
@Expose
private String pwd;

public String getUid() {
return uid;
}

public void setUid(String uid) {
this.uid = uid;
}

public String getPwd() {
return pwd;
}

public void setPwd(String pwd) {
this.pwd = pwd;
}

}