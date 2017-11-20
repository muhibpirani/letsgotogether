package android.weildy.letsgotogether.http.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductListResponse {

@SerializedName("status")
@Expose
private Boolean status;
@SerializedName("data")
@Expose
private List<List<String>> data = null;

public Boolean getStatus() {
return status;
}

public void setStatus(Boolean status) {
this.status = status;
}

public List<List<String>> getData() {
return data;
}

public void setData(List<List<String>> data) {
this.data = data;
}

}