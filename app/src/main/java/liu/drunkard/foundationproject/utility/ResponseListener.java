package liu.drunkard.foundationproject.utility;

/**
 * Created by laurenceliu on 2018/3/28.
 * This interface is for api response callback
 */

public interface ResponseListener<T> {
    void onComplete(T data);

    void onFailure(String message);
}
