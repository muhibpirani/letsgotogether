package android.weildy.letsgotogether.http;

import android.weildy.letsgotogether.http.model.ListBean;
import android.weildy.letsgotogether.http.model.request.LoginRequest;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface FetchService {

    @POST("login")
    Observable<ListBean> login(@Body LoginRequest loginRequest);
}