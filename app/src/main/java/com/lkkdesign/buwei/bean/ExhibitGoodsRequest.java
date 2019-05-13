package com.lkkdesign.buwei.bean;

import java.util.List;

/**
 * @author HuangYaoYu
 * @create 2018/7/26
 * @Describe 上货，同步机器饮料数量到后台
 */
public class ExhibitGoodsRequest {

    private int machineId;//	true	int	请求的机器ID号
    private String sign;// sign

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    private List<dataBean> data;

    public int getMachineId() {
        return machineId;
    }

    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }

    public List<dataBean> getData() {
        return data;
    }

    public void setData(List<dataBean> data) {
        this.data = data;
    }

    public static class dataBean{
        private String goodsId;//
        private int cargoroad;//	true	int	货道编号
        private String beverageName;//	true	String	饮料名称
        private int beverageNum;//	true	int	饮料数量

        public String getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(String goodsId) {
            this.goodsId = goodsId;
        }

        public int getCargoroad() {
            return cargoroad;
        }

        public void setCargoroad(int cargoroad) {
            this.cargoroad = cargoroad;
        }

        public String getBeverageName() {
            return beverageName;
        }

        public void setBeverageName(String beverageName) {
            this.beverageName = beverageName;
        }

        public int getBeverageNum() {
            return beverageNum;
        }

        public void setBeverageNum(int beverageNum) {
            this.beverageNum = beverageNum;
        }
    }
}
