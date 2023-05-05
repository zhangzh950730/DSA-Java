package com.zzh.demo;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.util.*;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class SlowFastDemo {

    public static void main(String[] args) {
        List<ItemResp> itemRespList = new ArrayList<>();
        mockData(itemRespList);
        List<String> dateList = new ArrayList<>();
        List<Double> dataList = new ArrayList<>();
        itemRespList.sort(Comparator.comparing(ItemResp::getDataTime));
        for (int i = 0; i < itemRespList.size(); ) {
            Date iDataTime = itemRespList.get(i).getDataTime();
            double sum = 0.0;
            for (int j = i; j < itemRespList.size(); j++) {
                ItemResp resp = itemRespList.get(j);
                Date jDataTime = resp.getDataTime();
                sum += resp.getValue();
                if (!DateUtils.isSameDay(iDataTime, jDataTime)) {
                    i = j;
                    break;
                }
                if (j == itemRespList.size() - 1) {
                    i = j + 1;
                }
            }
            dateList.add(DateFormatUtils.format(iDataTime, "yyyy-MM-dd"));
            dataList.add(sum);
        }

        System.out.println("dateList = " + dateList);
        System.out.println("dataList = " + dataList);
    }

    private static void mockData(List<ItemResp> itemRespList) {
        Date now = new Date();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            itemRespList.add(new ItemResp(DateUtils.addDays(now, random.nextInt(10)), random.nextDouble()));
        }
    }
}

class ItemResp {
    private Date dataTime;
    private Double value;

    public ItemResp(Date dataTime, Double value) {
        this.dataTime = dataTime;
        this.value = value;
    }

    public Date getDataTime() {
        return dataTime;
    }

    public Double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "ItemResp{" +
                "dataTime=" + DateFormatUtils.format(dataTime, "yyyy-MM-dd") +
                '}';
    }
}
