package com.ycit.robin;

/**
 * 服务器信息
 *
 * @author uk
 * 2019/4/7 8:09
 */
public class Server {

    private String ip;
    private int weight;
    private boolean online;
    private int currentWeight;
    private int effectiveWeight;

    public Server(String ip, int weight) {
        this.ip = ip;
        this.weight = weight;
        this.currentWeight = weight;
    }

    public Server(String ip, int weight, int currentWeight) {
        this.ip = ip;
        this.weight = weight;
        this.currentWeight = currentWeight;
    }

    @Override
    public String toString() {
        return "Server{" +
                "ip='" + ip + '\'' +
                ", weight=" + weight +
                ", online=" + online +
                ", currentWeight=" + currentWeight +
                ", effectiveWeight=" + effectiveWeight +
                '}';
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public int getEffectiveWeight() {
        return effectiveWeight;
    }

    public void setEffectiveWeight(int effectiveWeight) {
        this.effectiveWeight = effectiveWeight;
    }
}
