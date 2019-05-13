package com.lkkdesign.buwei.constants;

import android.os.Environment;

import com.google.gson.Gson;
import com.lkkdesign.buwei.bean.UpdateRequest;
import com.lkkdesign.buwei.util.CustomToast;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;

/**
 * @author $user$
 * @mail zhenghuan@lkkdesign.com
 * package: com.lkkdesign.buwei.constants
 * create at 2019/4/28$ 9:56$
 * description:
 */
public final class Constants {
    public static final int intMachineId = 10001;
    public static final String strKey = "192006250b4c09247ec02edce69f6a2d";
    public static Gson gson = new Gson();
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    public static UpdateRequest updateRequest = new UpdateRequest();
    public static OkHttpClient okHttpClient = new OkHttpClient();

    /**
     * 初始化本地路径
     */

    public static final String strDoorPort = "/dev/ttyS3";//扫码使用ttyS4

    public static final int intBaudRate_115200 = 115200;//波特率 115200
    public static final int intBaudRate_9600 = 9600;//波特率 9600
    public static final int intBaudRate_4800 = 4800;//波特率 4800
    public static final int intBaudRate_2400 = 2400;//波特率 2400

    //倒计时时间长度
    public static int intCountDwonTime = 120000;//默认120秒

    public static Map serialMapData = new HashMap();

    public static String md5(String string) {
        System.out.println("待加密：" + string);
        byte[] hash;
        try {
            hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Huh, MD5 should be supported?", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e);
        }

        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10)
                hex.append("0");
            hex.append(Integer.toHexString(b & 0xFF));
        }
        System.out.println("加密值：" + hex.toString().toUpperCase());
        return hex.toString().toUpperCase();
    }
    public static String convertNameToGoodsId(String strName) {
        String strGoodsID = "";
        switch (strName) {
            case "可乐可乐-经典-铝罐装-330mL":
                strGoodsID = "7";
                break;
            case "纯悦-饮用水-PET-550mL":
                strGoodsID = "8";
                break;
            case "芬达-橙味-铝罐装-330mL":
                strGoodsID = "9";
                break;
            case "雪碧-零卡-铝罐装-330ml":
                strGoodsID = "10";
                break;
            case "可口可乐-健怡-PET-500mL":
                strGoodsID = "11";
                break;
            case "可口可乐-零度-PET-500mL":
                strGoodsID = "12";
                break;
            case "美汁源-三重果粒橙-PET-420mL":
                strGoodsID = "13";
                break;
            case "水动乐-柠檬-PET-600mL":
                strGoodsID = "14";
                break;
            case "雪碧-纤维+-PET-500mL":
                strGoodsID = "16";
                break;
            case "怡泉+C-PET-330mL":
                strGoodsID = "17";
                break;
            case "唷茶-冰冽金桔-PET-480mL":
                strGoodsID = "18";
                break;
            default:
                break;
        }
        return strGoodsID;
    }

    public static final int machineId = 10007;//设备编号

}
