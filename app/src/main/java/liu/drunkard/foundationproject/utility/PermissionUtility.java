package liu.drunkard.foundationproject.utility;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * Created by laurenceliu on 2018/4/4.
 */

public class PermissionUtility {

    // 取得定位的權限
    public static final int MY_PERMISSIONS_REQUEST_FINE_LOCATION = 101;
    // 取得相機的權限
    public static final int READ_EXTERNAL_STORAGE_REQUEST_CODE = 102;
    // 取得使用者帳戶的權限
    public static final int GET_USER_ACCOUNT_REQUEST_CODE = 103;

    // 確認位置權限是否有被開啟
    public static boolean checkLocationPermission(Activity activity) {
        String permission = "android.permission.ACCESS_FINE_LOCATION";
        int res = activity.checkCallingOrSelfPermission(permission);
        return (res == PackageManager.PERMISSION_GRANTED);
    }

    // 權限 -- 位置
    public static void locationPermission(Activity activity) {
        // 如果裝置版本是6.0（包含）以上
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // 取得授權狀態，參數是請求授權的名稱
            int hasPermission = activity.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION);

            // 如果未授權
            if (hasPermission != PackageManager.PERMISSION_GRANTED) {
                // 請求授權
                //     第一個參數是請求授權的名稱
                //     第二個參數是請求代碼
                activity.requestPermissions(
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_FINE_LOCATION);
                return;
            }
        }
    }

    // 權限 -- 記憶體儲存
    public static void externalStoragePermission(Activity activity) {
        if (ContextCompat.checkSelfPermission(activity,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    READ_EXTERNAL_STORAGE_REQUEST_CODE);
        }
    }

    // 權限 -- 使用者帳戶
    public static void getUserAccountPermission(Activity activity) {
        if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int hasWriteContactsPermission = activity.checkSelfPermission(Manifest.permission.GET_ACCOUNTS);
            if (hasWriteContactsPermission != PackageManager.PERMISSION_GRANTED) {
                activity.requestPermissions(new String[] {Manifest.permission.GET_ACCOUNTS},
                        GET_USER_ACCOUNT_REQUEST_CODE);
                return;
            }
        }
    }
}
