package cn.wolfcode.sso.vo;

public class ClientInfoVo {
    private String clientUrl;
    private String jsessionid;

    public String getClientUrl() {
        return clientUrl;
    }

    public void setClientUrl(String clientUrl) {
        this.clientUrl = clientUrl;
    }

    public String getJsessionid() {
        return jsessionid;
    }

    public void setJsessionid(String jsessionid) {
        this.jsessionid = jsessionid;
    }

    @Override
    public String toString() {
        return "ClientInfoVo{" +
                "clientUrl='" + clientUrl + '\'' +
                ", jsessionid='" + jsessionid + '\'' +
                '}';
    }
}