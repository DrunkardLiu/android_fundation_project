package liu.drunkard.foundationproject;

import android.os.Bundle;
import android.support.annotation.Nullable;

import liu.drunkard.foundationproject.utility.Preference;

/**
 * Created by laurenceliu on 2018/4/4.
 */

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Init SharedPreference
        Preference.init(this);
    }

}
