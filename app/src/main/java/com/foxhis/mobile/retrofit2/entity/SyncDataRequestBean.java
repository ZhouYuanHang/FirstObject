package com.foxhis.mobile.retrofit2.entity;

import java.util.List;

/**
 * Created by zyh on 2017/12/26.
 */

public class SyncDataRequestBean {

    /**
     * secret : SeBon02h2naRYFknyqE
     * appkey : YDT
     * method : xmsopen.order.xopsenddate
     * extras : {"token":"92DF11D1BCCB58F539D74E9DEA78448A"}
     * rqid : PK-1
     * ts : 1471498765184
     * hotelid : XR
     * ver : 1.0.0
     * sign : 07331FD2733412A9DD7CA6EC538FB1EB
     * loc : zh_CN
     * tenantid : 1
     * params : [{"hotelid":"FoxhisX","tenantid":"1"}]
     */

    private String secret = "SeBon02h2naRYFknyqE";
    private String appkey = "YDT";
    private String method = "xmsopen.order.xopsenddate";
    private ExtrasBean extras;
    private String rqid = "PK-1";
    private String ts = "1471498765184";
    private String hotelid = "XR";
    private String ver = "1.0.0";
    private String sign = "07331FD2733412A9DD7CA6EC538FB1EB";
    private String loc = "zh_CN";
    private int tenantid = 1;
    private List<ParamsBean> params;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public ExtrasBean getExtras() {
        return extras;
    }

    public void setExtras(ExtrasBean extras) {
        this.extras = extras;
    }

    public String getRqid() {
        return rqid;
    }

    public void setRqid(String rqid) {
        this.rqid = rqid;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getHotelid() {
        return hotelid;
    }

    public void setHotelid(String hotelid) {
        this.hotelid = hotelid;
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public int getTenantid() {
        return tenantid;
    }

    public void setTenantid(int tenantid) {
        this.tenantid = tenantid;
    }

    public List<ParamsBean> getParams() {
        return params;
    }

    public void setParams(List<ParamsBean> params) {
        this.params = params;
    }

    public static class ExtrasBean {
        /**
         * token : 92DF11D1BCCB58F539D74E9DEA78448A
         */

        private String token = "92DF11D1BCCB58F539D74E9DEA78448A";

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }

    public static class ParamsBean {
        /**
         * hotelid : FoxhisX
         * tenantid : 1
         */

        private String hotelid = "FoxhisX";
        private String tenantid = "1";

        public String getHotelid() {
            return hotelid;
        }

        public void setHotelid(String hotelid) {
            this.hotelid = hotelid;
        }

        public String getTenantid() {
            return tenantid;
        }

        public void setTenantid(String tenantid) {
            this.tenantid = tenantid;
        }
    }
}
