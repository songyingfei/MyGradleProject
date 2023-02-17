package org.example;

import java.util.*;

//流的生成
public class StreamDemo {
    public static void main(String[] args) {
//
//        danliezuhe();
//        shuzu();
//        shuangliezuhe();

        List<Author> authorList = initAuthor();
//        mapDemo(authorList);
//        distinctDemo(authorList);
        sortDemo(authorList);
    }

    private static void sortDemo(List<Author> authorList) {
        authorList.stream().sorted(new Comparator<Author>() {
            @Override
            public int compare(Author o1, Author o2) {
                return o2.getAge()-o1.getAge();
            }
        }).forEach(s -> System.out.println(s));
    }

    private static void distinctDemo(List<Author> authorList) {
        authorList.stream().filter(s->s.getAge()>2).forEach(s -> System.out.println(s));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        authorList.stream().filter(s->s.getAge()>2).distinct().forEach(s -> System.out.println(s));
    }

    private static void mapDemo(List<Author> authorList) {
        authorList.stream().filter(s->s.getAge()>12).map( s -> s.getAge()).map(s->s+12).forEach(s->System.out.println(s));
    }

    public static List<Author> initAuthor(){
        List<Author> authors = new ArrayList<>();
        Author author = new Author();
        author.setName("门多");
        author.setAge(18);
        Author author1 = new Author();
        author1.setName("亚拉锁");
        author1.setAge(50);
        Author author2 = new Author();
        author2.setName("卡莉斯塔");
        author2.setAge(100);
        Author author3 = new Author();
        author3.setName("亿");
        author3.setAge(789);
        Author author4 = new Author();
        author4.setName("弗拉基米尔");
        author4.setAge(234);
        Author author5 = new Author("亿",789,null,null,null);
        authors.add(author);
        authors.add(author1);
        authors.add(author2);
        authors.add(author3);
        authors.add(author4);
        authors.add(author5);

        return authors;
    }

    /**
     * 单列集合生成流
     */
    private static void danliezuhe(){
        List<String> list = Arrays.asList("1","2","5","6","7");
//        list.stream().filter(new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return Integer.valueOf(s) > 2;
//            }
//        }).forEach(System.out::println);

        list.stream().filter(s -> Integer.valueOf(s)>2).forEach(System.out::println);
    }

    /**
     * 数组生成流
     */
    private static void shuzu(){
        String[] arr = {"1","2","3","100","500"};
        Arrays.stream(arr).filter(s -> Integer.valueOf(s)>=2).forEach(s->System.out.println("开始输出"+s));
    }
    /**
     * 双列组合生成流
     */
    private static void shuangliezuhe() {
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("张三",100);
        map.put("李四",50);
        map.put("王麻子",20);
        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
//        entrySet.stream().filter(new Predicate<Map.Entry<String, Integer>>() {
//            @Override
//            public boolean test(Map.Entry<String, Integer> entry) {
//                if(entry.getValue()>25){
//                    return true;
//                }
//                return false;
//            }
//        }).forEach( entry ->System.out.println(entry.getKey()+"=========="+entry.getValue()));
        entrySet.stream().filter(entry -> {
            if(entry.getValue()>25){
                return true;
            }
            return false;
        }).forEach(entry ->System.out.println(entry.getKey()+"=========="+entry.getValue()));
    }

}
