package com.ycit.robin;

import java.util.ArrayList;
import java.util.List;

/**
 * 加权轮询
 *
 * @author uk
 * 2019/4/7 8:08
 */
public class WeightedRoundRobin {

    private List<Server> servers;

    private int currentIndex;
    private int totalServer;
    private int currentWeight;
    private int maxWeight;
    private int gcdWeight;
    private int weightSum;

    public WeightedRoundRobin() {
        servers = new ArrayList<>();
        servers.add(new Server("192.168.1.1", 5));
        servers.add(new Server("192.168.1.2", 1));
        servers.add(new Server("192.168.1.3", 1));
        totalServer = servers.size();
//        currentIndex = servers.indexOf(maxCurrentWeight());
        currentIndex = -1;
        weightSum = weightSum();
    }

    private int weightSum() {
        if (servers != null && servers.size() > 0) {
            return servers.stream().mapToInt(Server::getWeight).sum();
        }
        return 0;
    }

    private Server maxCurrentWeight() {
        Server serverCurrentWeightMax = null;
        if (servers != null && servers.size() > 0) {
            int currentWeightMax = 0;
            for (Server server:servers) {
                if (server.getCurrentWeight() > currentWeightMax) {
                    serverCurrentWeightMax = server;
                    currentWeightMax = server.getCurrentWeight();
                }
            }
        }
        return serverCurrentWeightMax;
    }

    private Server roundRobin() {
        Server server = maxCurrentWeight();
        currentIndex = servers.indexOf(server);
        server.setCurrentWeight(server.getCurrentWeight() - weightSum);
        return server;
    }

    public static void main(String[] args) {

        final WeightedRoundRobin wr = new WeightedRoundRobin();
//        // 非并发情况
        for (int i = 0; i < 8; i++) {
            System.out.println(wr.roundRobin());
        }
//
//        System.out.println();
//        System.out.println("==========");
//        System.out.println();
//
//        final CyclicBarrier b = new CyclicBarrier(30);
//        // 并发情况
//        for (int i = 0; i < 30; i++) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        b.await();
//                        System.out.println(Thread.currentThread().getName() + " " + wr.round());
//                    } catch (InterruptedException | BrokenBarrierException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }, "thread" + i).start();
//        }
    }

}
