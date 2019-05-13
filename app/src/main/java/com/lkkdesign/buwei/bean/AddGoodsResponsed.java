package com.lkkdesign.buwei.bean;

/**
 * @author $user$
 * @mail zhenghuan@lkkdesign.com
 * package: com.lkkdesign.buwei.bean
 * create at 2019/4/28$ 15:46$
 * description:
 */

/**
 * errCode	true	int	    返回状态码：200表示没有错误，其他有错误
 * errMsg	true	String	errCode是非200的情况下是字符串，否则是null
 * sign	    true	String	MD5签名
 */
public class AddGoodsResponsed {
    private int errCode;
    private String errMsg;
    private String sign;

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
