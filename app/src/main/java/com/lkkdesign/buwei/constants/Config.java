package com.lkkdesign.buwei.constants;

import android.os.Environment;

/**
 * @author $user$
 * @mail zhenghuan@lkkdesign.com
 * package: com.lkkdesign.buwei.Constants
 * create at 2019/4/26$ 15:50$
 * description:
 */
public class Config {
    public static final String SDCARD_DIR = Environment.getExternalStorageDirectory().getAbsolutePath();
    public static final String DEFAULT_CACHE_DIR = SDCARD_DIR + "/PLDroidPlayer";
}
