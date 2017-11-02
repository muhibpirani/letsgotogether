package android.weildy.letsgotogether.http;

import android.weildy.letsgotogether.http.model.ListBean;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

public interface FetchService {

    @FormUrlEncoded
    @POST("login.php")
    Observable<ListBean> login(@Field("username") String username,
                                @Field("pwd")String password);
}