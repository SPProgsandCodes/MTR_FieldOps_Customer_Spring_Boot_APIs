package in.sptech.mtr.rest;

public class ApiError {
    private String error;

    public ApiError(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
