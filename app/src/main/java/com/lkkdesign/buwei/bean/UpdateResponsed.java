package com.lkkdesign.buwei.bean;

/**
 * @author $user$
 * @mail zhenghuan@lkkdesign.com
 * package: com.lkkdesign.buwei.bean
 * create at 2019/4/28$ 9:47$
 * description:
 */

/**
 * 升级接口的返回值
 * errCode	true	int	返回状态码：200表示有apk文件
 *errMsg	true	String	errCode是非0的情况下是字符串，否则是null
 *newVersion	true	String	版本号，从APK文件名称中获取（APP-1.2.1.apk，1.2.1代表版本号）
 *apkUrl	true	String	APK下载地址
 *targetSize	false	String	APK文件大小
 *Sign	true	String	APK文件检验完整性的md5
 * */
public class UpdateResponsed {
    private int errCode;
    private String errMsg;
    private String newVersion;
    private String apkUrl;
    private String targetSize;
    private String Sign;

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

    public String getNewVersion() {
        return newVersion;
    }

    public void setNewVersion(String newVersion) {
        this.newVersion = newVersion;
    }

    public String getApkUrl() {
        return apkUrl;
    }

    public void setApkUrl(String apkUrl) {
        this.apkUrl = apkUrl;
    }

    public String getTargetSize() {
        return targetSize;
    }

    public void setTargetSize(String targetSize) {
        this.targetSize = targetSize;
    }

    public String getSign() {
        return Sign;
    }

    public void setSign(String sign) {
        Sign = sign;
    }
}
