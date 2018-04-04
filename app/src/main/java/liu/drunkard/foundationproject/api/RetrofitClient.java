package liu.drunkard.foundationproject.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by laurenceliu on 2018/3/28.
 */

public class RetrofitClient {
    public static final String GITHUB_BASE_URL = "https://api.github.com/";

    public static GitHubMethods gitHubMethods() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitClient.GITHUB_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient())
                .build();

        GitHubMethods methods = retrofit.create(GitHubMethods.class);

        return methods;
    }

    // Set timeout
    private static OkHttpClient getClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(6000, TimeUnit.SECONDS)
                .writeTimeout(6000, TimeUnit.SECONDS)
                .readTimeout(6000, TimeUnit.SECONDS)
                .build();
        return client;
    }
}