package msh.wanandroid.wanandroidservice.message;

public class LocalLogger {

    private String method;
    private String url;
    private String responseBody;

    private String requestBody;


    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    @Override
    public String toString() {
        return "LocalLogger{" +
                "method='" + method + '\'' +
                ", url='" + url + '\'' +
                ", responseBody='" + responseBody + '\'' +
                ", requestBody='" + requestBody + '\'' +
                '}';
    }
}
