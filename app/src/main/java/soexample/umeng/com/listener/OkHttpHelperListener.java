package soexample.umeng.com.listener;

public interface OkHttpHelperListener {
    void succeed(String data);
    void failure(String error);
}
