package com.lkkdesign.buwei.constants;

import static android.os.Build.HOST;
import static android.provider.Telephony.TextBasedSmsColumns.PROTOCOL;

/**
 * @author $user$
 * @mail zhenghuan@lkkdesign.com
 * package: com.lkkdesign.buwei.constants
 * create at 2019/4/28$ 10:03$
 * description:
 */
public class ApiAddress {
    public static final String update="http://182.92.219.36:8080/api/update";
    public static final String DOMAIN = PROTOCOL + HOST;
    public static final String URL_exhibitGoods = DOMAIN + "/api/exhibitGoods";//11、上货
}
