package android.weildy.letsgotogether.http.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

@SerializedName("name")
@Expose
private String name;
@SerializedName("city")
@Expose
private String city;

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getCity() {
return city;
}

public void setCity(String city) {
this.city = city;
}

}