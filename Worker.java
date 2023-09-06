public class Worker {

    @FunctionalInterface
    public interface OnTaskErrorListener {
        void onError(String result);
    }

    private OnTaskErrorListener errorCallback;

    public Worker(OnTaskErrorListener errorCallback) {
        this.errorCallback = errorCallback;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            if (i == 33) {
                errorCallback.onError("Task " + i + " is error");
            } else {
                errorCallback.onError("Task " + i + " is done");
            }
        }
    }
}

