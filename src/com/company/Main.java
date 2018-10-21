package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    /**
     * 打印内容
     * @param index 索引
     * @param object 对象
     */
    public static void print(int index, Object object){
        System.out.println(String.format("{%d}, %s",index,object));
        //
    }

    public static void demoOperation(){
        print(1,5  + 2);
        print(1,5 -  2);
        print(1,5  * 2);
        print(1,5  / 2);
        print(1,5  % 2);
        print(1,5  << 2);
        print(1,5  >> 2);
        print(1,5  | 2); // 0x101 0x10 --> 0x111 按位与
        print(1,5  ^ 2); // 按位异或
        print(1,5  == 2);
        print(1,5  != 2);
    }

    public static void demoString(){
        String str = "hello world ";
        print(1,str.indexOf("e"));
        print(2,str.charAt(3)); //str[3];
        print(3,str.codePointAt(1));
        print(4,str.compareToIgnoreCase("HELLO WORLD "));
        print(5,str.compareTo("hello uorld"));
        print(6,str.compareTo("hello xorld"));
        print(7,str.contains("hello"));
        print(8,str.concat("!!!"));
        print(9,str.toUpperCase());
        print(10,str.endsWith("world"));
        print(11,str.startsWith("hello"));
        print(12,str.replace('o','e'));
        print(13,str.replaceAll("o|l","a"));//支持正则表达式

        StringBuilder sb = new StringBuilder(); //StringBuilder是非线程安全的，如果要线程安全，应该用 Stringbuffer
        sb.append("x = ");
        sb.append(true);
        print(14,sb);
    }

    public static void demoList(){
        List<String> strList = new ArrayList<String>(10);
        for(int i =0;i<4;i++){
            strList.add(String.valueOf(i));
        }
        strList.remove(0);
        print(1,strList);

        List<String> strListB = new ArrayList<String>(10);
        for(int i =0;i<4;i++){
            strListB.add(String.valueOf(i*i));
        }
        print(2,strListB);

        strList.addAll(strListB);
        print(3,strList);

        //Collections 是一种统一对容器操作的类
        Collections.reverse(strList);
        print(4,strList);

        //排序
        Collections.sort(strList); //c语言中是qsort
        print(5,strList);

        Collections.sort(strList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        print(6,strList);

        //遍历
        for(String obj : strList){
            print(7,obj);
        }

        //数组
        int[] array = new int[]{1,2,3};
        print(8,array[1]);
    }

    public static void demoMapTable(){
        Map<String, String> map = new HashMap<String,String>(); //map是一个映射
        for(int i=0;i<4;i++){
            map.put(String.valueOf(i), String.valueOf(i*i));
        }
        print(1,map);

        //c语言中的迭代器是 map<int,int>::iterator it = map.begin(),在java中作一定的简化
        for(Map.Entry<String,String> entry : map.entrySet()){
            print(2,entry.getKey() + "|" + entry.getValue() );
        }

        print(3,map.containsKey("A"));
        print(4,map.get("3"));
        map.replace("3","27"); //把key为3的位置对应的值换成27
        print(5,map);

    }

    public static void demoSet(){
        Set<String> strSet = new HashSet<String>();
        for(int i = 0;i<3;i++){
            strSet.add(String.valueOf(i));
            strSet.add(String.valueOf(i));
            strSet.add(String.valueOf(i));
        }
        print(1,strSet);//集合默认是不会重复的，所以重复放进去，还是0,1,2；
        strSet.remove(String.valueOf(1));
        print(2,strSet);

        print(3,strSet.contains(String.valueOf(1)));
        print(4,strSet.isEmpty());
        print(5,strSet.size());

        strSet.addAll(Arrays.asList(new String[]{"A","B","C"}));
        print(6,strSet);

        for(String value: strSet){
            print(7,value);
        }
    }

    public static void demoException(){
        try {
            int k = 2;
//            k = k / 0;
            if (k== 2 ){
                throw new Exception("我故意的");
            }
        }catch (Exception e){
            print(2,e.getMessage());
        }finally { //finally 主要是用来清零，finally是一定会走的
            print(3,"finally");
        }
    }

    public static void demoOO(){
        Animal a = new Animal("Jim",10);
        a.say();
        Animal human1 = new Human("zk",25,"china");
        human1.say();
    }

    public  static void demoFunction(){
        Random random = new Random();
//        random.setSeed(1);
        print(1,random.nextInt()); // 产生随机数的方式是伪随机的，给定的seed，产生的随机数是固定的。nextInt(n)产生[0,n)的数
        print(2,random.nextFloat()); //默认是0~1之间的

        List<Integer> array = Arrays.asList(new Integer[]{1,2,3,4,5});
        Collections.shuffle(array);
        print(3,array);

        //时间
        Date date = new Date();
        print(4,date);
        print(5,date.getTime());

        //指定时间的格式
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        print(6,df.format(date));

        //生成随机的字符串
        print(7,UUID.randomUUID());

        //数学中的
        print(8,Math.log(10));
        print(8,Math.max(10,29));
        print(8,Math.ceil(10.4));//进位（直接进，不是5进）
        print(8,Math.floor(10.6));//去尾（直接舍，不是4舍）

    }

    public static void main(String[] args) {
	// write your code here
        System.out.println("this is for test" );
//        demoOperation();
//        demoString();
//        demoList();
//        demoMapTable();
//        demoSet();
//        demoException();
//        demoOO();
        demoFunction();

    }
}
