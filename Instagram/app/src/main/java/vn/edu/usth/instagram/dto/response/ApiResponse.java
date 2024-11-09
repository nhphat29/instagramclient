package vn.edu.usth.instagram.dto.response;


public class ApiResponse<T> {
    private int code;
    private T data;

    public int getCode() { return code; }
    public T getData() { return data; }
}
