package android.weildy.letsgotogether.http.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by muhib on 11/16/2017.
 */
public class MessageAddProduct {
    @SerializedName("pronm")
    @Expose
    private String pronm;

    public String getPronm() {
        return pronm;
    }

    public void setPronm(String pronm) {
        this.pronm = pronm;
    }
}
