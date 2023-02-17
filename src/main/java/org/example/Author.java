package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    private String name;
    private int age;
    private String chara;
    private String filed;
    private List<Book> bookList;

    public static void main(String[] args) {
        Map<String,String> testMap = new HashMap<String,String>();
        testMap.get("a");
        testMap.get("bb");
        testMap.get("cccc");
    }


}
