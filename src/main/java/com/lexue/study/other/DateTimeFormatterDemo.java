package com.lexue.study.other;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeFormatterDemo {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final ThreadLocal<SimpleDateFormat> dataFormatThreadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    private static final ThreadLocal<String> name = new ThreadLocal<>();

    private static final ThreadLocal<Integer> age = new ThreadLocal<>();

    public static void main(String[] args) {
//        while (true) {
//            new Thread(()->{
//                String format = dateFormat.format(new Date());
//                try {
//                    Date parseDate = dateFormat.parse(format);
//                    String checkFormat = dateFormat.format(parseDate);
//                    if (format.equals(checkFormat)) {
//                        System.out.println("true");
//                    } else {
//                        System.out.println("false " + format + " " + checkFormat);
//                    }
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//            }).start();
//        }
//        while (true) {
//            new Thread(()->{
//                String format = dataFormatThreadLocal.get().format(new Date());
//                try {
//                    Date parseDate = dataFormatThreadLocal.get().parse(format);
//                    String checkFormat = dataFormatThreadLocal.get().format(parseDate);
//                    if (format.equals(checkFormat)) {
//                        System.out.println("true");
//                    } else {
//                        System.out.println("false " + format + " " + checkFormat);
//                    }
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//            }).start();
//        }
//        name.set("wangwentai");
//        age.set(23);
//        System.out.println(name.get());
//        System.out.println(age.get());
        System.out.printf("%x",BigDecimal.valueOf(Math.pow(2, 32) * 0.6180339887).intValue());
        System.out.printf("%d", 0x61c88647);

    }
}
