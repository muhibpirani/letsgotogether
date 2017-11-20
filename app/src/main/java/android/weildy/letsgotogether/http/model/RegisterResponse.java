package android.weildy.letsgotogether.http.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterResponse {

@SerializedName("status")
@Expose
private Boolean status;
@SerializedName("messageregister")
@Expose
private Messageregister messageregister;

public Boolean getStatus() {
return status;
}

public void setStatus(Boolean status) {
this.status = status;
}

public Messageregister getMessageregister() {
return messageregister;
}

public void setMessageregister(Messageregister messageregister) {
this.messageregister = messageregister;
}

}