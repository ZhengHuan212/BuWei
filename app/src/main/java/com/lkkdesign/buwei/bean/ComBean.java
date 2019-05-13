package com.lkkdesign.buwei.bean;

import java.text.SimpleDateFormat;

/**
 * @author $user$
 * @mail zhenghuan@lkkdesign.com
 * package: com.lkkdesign.buwei.bean
 * create at 2019/4/28$ 16:36$
 * description:
 */
public class ComBean {
    public byte[] bRec=null;
    public String sRecTime="";
    public String sComPort="";
    public ComBean(String sPort, byte[] buffer, int size){
        sComPort=sPort;
        bRec=new byte[size];
        for (int i = 0; i < size; i++)
        {
            bRec[i]=buffer[i];
        }
        SimpleDateFormat sDateFormat = new SimpleDateFormat("hh:mm:ss");
        sRecTime = sDateFormat.format(new java.util.Date());
    }
}
