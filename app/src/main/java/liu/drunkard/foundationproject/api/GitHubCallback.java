package liu.drunkard.foundationproject.api;

import android.util.Log;

import java.util.List;

import liu.drunkard.foundationproject.model.GitHubUser;
import liu.drunkard.foundationproject.utility.ResponseListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by laurenceliu on 2018/4/4.
 */

public class GitHubCallback {

    public GitHubCallback() {
    }

    public void getUser(int since, final ResponseListener responseListener) {
        Call<List<GitHubUser>> userCall = RetrofitClient.gitHubMethods().getGitHubUser(since);
        userCall.enqueue(new Callback<List<GitHubUser>>() {
            @Override
            public void onResponse(Call<List<GitHubUser>> call, Response<List<GitHubUser>> response) {
                try {
                    if (response.code() == 200) {
                        List<GitHubUser> gitHubUserList = response.body();
                        responseListener.onComplete(gitHubUserList);
                    } else {
                        responseListener.onFailure(response.message());
                    }
                } catch (NullPointerException e) {
                    responseListener.onFailure(e.toString());
                }
            }

            @Override
            public void onFailure(Call<List<GitHubUser>> call, Throwable t) {
                responseListener.onFailure(t.toString());
            }
        });
    }
}
