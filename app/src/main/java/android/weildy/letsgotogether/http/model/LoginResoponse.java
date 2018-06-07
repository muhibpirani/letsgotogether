package android.weildy.letsgotogether.http.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResoponse {

@SerializedName("status")
@Expose
private Boolean status;
@SerializedName("utype")
@Expose
private String utype;
@SerializedName("message")
@Expose
private MessageServer message;

public Boolean getStatus() {
return status;
}

public void setStatus(Boolean status) {
this.status = status;
}

public String getUtype() {
return utype;
}

public void setUtype(String utype) {
this.utype = utype;
}

public MessageServer getMessage() {
return message;
}

public void setMessage(MessageServer message) {
this.message = message;
}

}