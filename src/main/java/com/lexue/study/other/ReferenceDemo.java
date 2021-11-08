package com.lexue.study.other;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;


public class ReferenceDemo {

    private static List<User> users;

    public static void main(String[] args) {

        List<User> users = Lists.newArrayList(new User("曹雪", 18), new User("温泰", 24));
//        Map<Object, Object> userMap = Maps.newHashMap();
//        for (User user : users) {
//            userMap.put(user.getAge(), user);
//        }
//        for (int i = 0; i < users.size(); i++) {
//
//        }
//        addUser(new User("1", 1), Lists::newArrayList);
//        addUser(new User("2", 2), Lists::newArrayList);
//        System.out.println("users = " + users);



    }

//    public static String query(Object object) {
//        StringBuilder sql = new StringBuilder();
//        Class<?> c = object.getClass();
//        if (c.isAnnotationPresent(Table.class)) {
//            return null;
//        }
//        Table table = c.getAnnotation(Table.class);
//        sql.append("select * from ").append(table.value()).append(" where 1=1 ");
//        Field[] fields = c.getDeclaredFields();
//        for (Field field : fields) {
//            if (field.isAnnotationPresent(Column.class)) {
//                continue;
//            }
//            Column column = field.getAnnotation(Column.class);
//            column.value();
//        }
//    }


    @Data
    @AllArgsConstructor
    @Table("user")
    static class User {

        @Column("name")
        private String name;

        @Column("age")
        private Integer age;
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Table{
        String value();
    }

    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Column{
        String value();
    }

}
