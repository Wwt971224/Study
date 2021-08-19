package com.lexue.study.other;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DefenseDemo {

    @Getter
    @AllArgsConstructor
    private static final class SmsInfo {
        private final Long id;
        private final String url;
        private final Long maxSize;
        public SmsInfo(SmsInfo smsInfo) {
            this.id = smsInfo.getId();
            this.url = smsInfo.getUrl();
            this.maxSize = smsInfo.getMaxSize();
        }
    }

    public static class SmsRouter {
        private static volatile SmsRouter instance = new SmsRouter();
        private static Map<Integer, SmsInfo> smsInfoMap;
        public SmsRouter() {
            smsInfoMap = loadSmsInfoFromDb();
        }

        private Map<Integer, SmsInfo> loadSmsInfoFromDb() {
            Map<Integer, SmsInfo> map = new HashMap<>();
            map.put(1, new SmsInfo(1L, "1", 100L));
            map.put(2, new SmsInfo(2L, "2", 200L));
            map.put(3, new SmsInfo(3L, "3", 300L));
            return map;
        }
        public static SmsRouter getInstance() {
            return instance;
        }
        public static void setInstance(SmsRouter smsRouter) {
            instance = smsRouter;
        }
        public Map<Integer, SmsInfo> getSmsMap() {
            return Collections.unmodifiableMap(smsInfoMap);
        }
    }

    public static void main(String[] args) {
        Map<Integer, SmsInfo> smsMap = SmsRouter.getInstance().getSmsMap();
        System.out.println(smsMap);
        Map<Integer, SmsInfo> smsMap1 = SmsRouter.getInstance().getSmsMap();
        System.out.println(smsMap1);
    }


}
