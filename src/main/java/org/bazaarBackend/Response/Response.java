package org.bazaarBackend.Response;

public class Response {
    private int statusCode;
    private String status;
    private Object data;

    public Response() {
        statusCode = 200;
    }
    public Response(Object data) {
        if (data != null) {
            status = "SUCCESS";
            statusCode = 200;
        }
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
