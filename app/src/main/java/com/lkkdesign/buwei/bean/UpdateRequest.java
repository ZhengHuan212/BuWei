package com.lkkdesign.buwei.bean;

/**
 * @author $user$
 * @mail zhenghuan@lkkdesign.com
 * package: com.lkkdesign.buwei.bean
 * create at 2019/4/28$ 9:27$
 * description:
 */

/**
 * 升级接口的参数
 * machineId	true	int	请求的机器ID号
 *sign	true	String	MD5加密值
 */
public class UpdateRequest {
    private int machineId;
    private String sign;

    public int getMachineId() {
        return machineId;
    }

    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
