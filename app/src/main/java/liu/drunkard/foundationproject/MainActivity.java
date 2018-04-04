package liu.drunkard.foundationproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import liu.drunkard.foundationproject.RecyclerViewSample.RecyclerViewActivity;

public class MainActivity extends BaseActivity {

    @BindView(R.id.recyclerViewSampleButton)
    Button mRecyclerViewSampleButton;
    @BindView(R.id.balaButton)
    Button mBalaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        // Home page dismiss back button
        setToolbar("主頁Title置中");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    @OnClick({R.id.recyclerViewSampleButton, R.id.balaButton})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.recyclerViewSampleButton:
                Intent intent = new Intent(getApplicationContext(), RecyclerViewActivity.class);
                startActivity(intent);
                break;
            case R.id.balaButton:
                break;
        }
    }
}
