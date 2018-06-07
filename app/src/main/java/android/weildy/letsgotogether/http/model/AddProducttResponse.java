package android.weildy.letsgotogether.http.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddProducttResponse {

@SerializedName("status")
@Expose
private Boolean status;
@SerializedName("message")
@Expose
private MessageAddProduct message;

public Boolean getStatus() {
return status;
}

public void setStatus(Boolean status) {
this.status = status;
}

public MessageAddProduct getMessage() {
return message;
}

public void setMessage(MessageAddProduct message) {
this.message = message;
}

}