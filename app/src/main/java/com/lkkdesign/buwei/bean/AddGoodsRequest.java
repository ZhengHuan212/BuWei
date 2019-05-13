package com.lkkdesign.buwei.bean;

/**
 * @author $user$
 * @mail zhenghuan@lkkdesign.com
 * package: com.lkkdesign.buwei.bean
 * create at 2019/4/28$ 15:45$
 * description:
 */

import java.util.List;

/**
 * machineId   true	  int	   请求的机器ID号
 * sign	       true	  String   MD5加密值
 * data	       true	  []	   商品数据集（数组）
 * gridNo	   true	  int	  机器格子编号
 * goodsNo	   true	  String  商品编号(格式化成四个字符，不足补零)
 * goodsNum	   true	  int	  商品数量
 */
public class AddGoodsRequest {
    private int machineId;
    private String sign;
    private List<Data> data;
    public class Data{
        private int gridNo;
        private String goodsNo;
        private int goodsNum;

        public int getGridNo() {
            return gridNo;
        }

        public void setGridNo(int gridNo) {
            this.gridNo = gridNo;
        }

        public String getGoodsNo() {
            return goodsNo;
        }

        public void setGoodsNo(String goodsNo) {
            this.goodsNo = goodsNo;
        }

        public int getGoodsNum() {
            return goodsNum;
        }

        public void setGoodsNum(int goodsNum) {
            this.goodsNum = goodsNum;
        }
    }

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

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}
