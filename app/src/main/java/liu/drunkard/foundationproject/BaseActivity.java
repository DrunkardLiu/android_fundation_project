package liu.drunkard.foundationproject;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by laurenceliu on 2018/3/28.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected Toolbar mToolbar;

    protected ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {
        RelativeLayout layout = (RelativeLayout) getLayoutInflater().inflate(R.layout.activity_base, null);
        mToolbar = (Toolbar) layout.findViewById(R.id.toolbar);
        FrameLayout mainLayout = (FrameLayout) layout.findViewById(R.id.mainLayout);

        getLayoutInflater().inflate(layoutResID, mainLayout, true);
        super.setContentView(layout);
    }

    protected void setToolbar(String title) {
        TextView titleTextView = (TextView) findViewById(R.id.titleTextView);
        titleTextView.setText(title);

        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

//    protected void setToolbar(Toolbar toolbar, String title, int navigationIconId) {
//        toolbar.setNavigationIcon(navigationIconId);
//        toolbar.setTitle(title);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//    }

    protected void showProgress(String msg) {
        if (mProgressDialog != null)
            dismissProgress();

        mProgressDialog = ProgressDialog.show(this, "In put any progress hint", msg);
    }

    protected void dismissProgress() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }

    protected void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    protected void showAlert(String msg) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("In put any title string")
                .setMessage(msg)
                .setCancelable(false)
                .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).create().show();
    }

}
