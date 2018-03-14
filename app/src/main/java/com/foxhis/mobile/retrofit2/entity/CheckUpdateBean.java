package com.foxhis.mobile.retrofit2.entity;

import java.util.List;

/**
 * Created by zyh on 2017/12/27.
 */

public class CheckUpdateBean {

    /**
     * code :
     * msg :
     * results : [{"hotelid":"FoxhisX","imageupdatetime":"2017-12-25 12:57:08","syndataupdatetime":"2017-12-25 17:40:48"}]
     * success : true
     * ts : 1514342708654
     */

    private String code;
    private String msg;
    private boolean success;
    private long ts;
    private List<ResultsBean> results;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public long getTs() {
        return ts;
    }

    public void setTs(long ts) {
        this.ts = ts;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * hotelid : FoxhisX
         * imageupdatetime : 2017-12-25 12:57:08
         * syndataupdatetime : 2017-12-25 17:40:48
         */

        private String hotelid;
        private String imageupdatetime;
        private String syndataupdatetime;

        public String getHotelid() {
            return hotelid;
        }

        public void setHotelid(String hotelid) {
            this.hotelid = hotelid;
        }

        public String getImageupdatetime() {
            return imageupdatetime;
        }

        public void setImageupdatetime(String imageupdatetime) {
            this.imageupdatetime = imageupdatetime;
        }

        public String getSyndataupdatetime() {
            return syndataupdatetime;
        }

        public void setSyndataupdatetime(String syndataupdatetime) {
            this.syndataupdatetime = syndataupdatetime;
        }
    }
}
