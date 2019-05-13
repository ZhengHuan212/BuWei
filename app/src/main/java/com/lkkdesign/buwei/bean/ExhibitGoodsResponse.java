package com.lkkdesign.buwei.bean;

/**
 * @author HuangYaoYu
 * @create 2018/7/26
 * @Describe 上货-响应
 */
public class ExhibitGoodsResponse {

    private int errCode;//	true	int	返回状态码：0表示没有错误，其他有错误
    private String errMsg;//	true	String	errCode是非0的情况下是字符串，否则是null
    private String sign;//	true	String	MD5签名

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
