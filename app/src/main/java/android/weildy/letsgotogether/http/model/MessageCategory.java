package android.weildy.letsgotogether.http.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by muhib on 11/16/2017.
 */
public class MessageCategory {
    @SerializedName("catnm")
    @Expose
    private String catnm;

    public String getCatnm() {
        return catnm;
    }

    public void setCatnm(String catnm) {
        this.catnm = catnm;
    }
}
