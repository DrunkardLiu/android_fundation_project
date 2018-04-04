package liu.drunkard.foundationproject.api;

import java.util.List;

import liu.drunkard.foundationproject.model.GitHubUser;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by laurenceliu on 2018/3/28.
 */

public interface GitHubMethods {

    @GET("users")
    Call<List<GitHubUser>> getGitHubUser(
            @Query("since") int since
    );


    /* -----------------------------
    | Some 'GET' sample from Google |
    -------------------------------*/
    /*
    @GET("place/nearbysearch/json")
    Call<NearbySearch> getNearbySearch(
            @Query("location") String location,
            @Query("radius") String radius,
            @Query("types") String types,
            @Query("language") String language,
            @Query("key") String key
    );

    @GET("place/textsearch/json")
    Call<TextSearch> getTextSearch(
            @Query("query") String query,
            @Query("language") String language,
            @Query("key") String key
    );

    @GET("place/details/json")
    Call<Details> getDetails(
            @Query("placeid") String placeid,
            @Query("language") String language,
            @Query("key") String key
    );
    */

    /* ---------------------------------Cut------------------------------- */

    /* -----------------------------
    | Some 'POST' sample from KKBOX |
    -------------------------------*/
    /*
    @Multipart
    @POST("oauth2/device/code")
    Call<DeviceCodeResponse> getDeviceCode(
            @Part("client_id") RequestBody client_id,
            @Part("scope") RequestBody scope
    );

    @Multipart
    @POST("oauth2/token")
    Call<RefreshTokenResponse> getRefreshToken(
            @Header("authorization") String authorization,
            @Header("username") String username,
            @Header("password") String password,
            @Part("grant_type") RequestBody grant_type,
            @Part("refresh_token") RequestBody refresh_token
    );

    @POST("tickets")
    Call<TicketResponse> getTicket(
            @Header("Authorization") String authHeader,
            @Body RequestBody trackIdJson
    );
    */
}
