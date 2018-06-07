package android.weildy.letsgotogether.http;

import android.weildy.letsgotogether.http.model.AddCategoryResponse;
import android.weildy.letsgotogether.http.model.AddProducttResponse;
import android.weildy.letsgotogether.http.model.LoginResoponse;
import android.weildy.letsgotogether.http.model.ProductListResponse;
import android.weildy.letsgotogether.http.model.RegisterResponse;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

public interface FetchService {

    @FormUrlEncoded
    @POST("login.php")
    Observable<LoginResoponse> login(@Field("username") String username,
                                @Field("pwd")String password);

    @FormUrlEncoded
    @POST("reg.php")
    Observable<RegisterResponse> register(@Field("mo") String mobile,
                                        @Field("name") String name,
                                        @Field("city") String city,
                                        @Field("utyp") String utyp,
                                        @Field("pincode") String pincode,
                                        @Field("pwd") String password,
                                        @Field("pincode") String adby);

    @GET("proview.php")
    Observable<ProductListResponse> getProductList();

    @FormUrlEncoded
    @POST("proadd.php")
    Observable<AddProducttResponse> addProduct(@Field("proname")String proname,
                                               @Field("procat")String cat,
                                               @Field("proprice1")String proprice1,
                                               @Field("proprice2")String proprice2,
                                               @Field("proprice3")String proprice3,
                                               @Field("proprice4")String proprice4,
                                               @Field("proprice5")String proprice5);

    @FormUrlEncoded
    @POST("procatadd.php")
    Observable<AddCategoryResponse> addCategory(@Field("catname")String catname);
}
