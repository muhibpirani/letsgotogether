package android.weildy.letsgotogether.http.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddCategoryResponse {

@SerializedName("status")
@Expose
private Boolean status;
@SerializedName("message")
@Expose
private MessageCategory message;

public Boolean getStatus() {
return status;
}

public void setStatus(Boolean status) {
this.status = status;
}

public MessageCategory getMessage() {
return message;
}

public void setMessage(MessageCategory message) {
this.message = message;
}

}