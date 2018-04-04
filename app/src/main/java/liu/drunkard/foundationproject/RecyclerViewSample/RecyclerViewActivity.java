package liu.drunkard.foundationproject.RecyclerViewSample;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import liu.drunkard.foundationproject.BaseActivity;
import liu.drunkard.foundationproject.R;
import liu.drunkard.foundationproject.api.GitHubCallback;
import liu.drunkard.foundationproject.model.GitHubUser;
import liu.drunkard.foundationproject.utility.OnItemClickListener;
import liu.drunkard.foundationproject.utility.ResponseListener;
import liu.drunkard.foundationproject.utility.SetUpLayoutManager;

/**
 * Created by laurenceliu on 2018/4/4.
 */

public class RecyclerViewActivity extends BaseActivity {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private GitHubUserAdapter mGitHubUserAdapter;
    private List<GitHubUser> mGitHubUserList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        ButterKnife.bind(this);

        initView();
        processController();
    }

    private void initView() {
        setToolbar("喔喔喔喔喔抓抓");

        SetUpLayoutManager.verticalLinearLayout(this, mRecyclerView);
    }

    private void processController() {
        showProgress("讀取讀取讀取讀取讀取");
        new GitHubCallback().getUser(100, new ResponseListener() {
            @Override
            public void onComplete(Object data) {
                mGitHubUserList = (List<GitHubUser>) data;

                mGitHubUserAdapter = new GitHubUserAdapter(getApplicationContext(), mGitHubUserList);
                mRecyclerView.setAdapter(mGitHubUserAdapter);
                mGitHubUserAdapter.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        showToast("You already clicked on " + mGitHubUserList.get(position).login);
                    }
                });
                dismissProgress();
            }

            @Override
            public void onFailure(String message) {
                showToast(message);
                dismissProgress();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
