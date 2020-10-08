package cn.zsy.eg.algorithms;


import orestes.bloomfilter.BloomFilter;
import orestes.bloomfilter.FilterBuilder;

public class BloomfilterTest {

    public static void main(String[] args) {
        //Expect 10M URLs
        BloomFilter<String> bf = new FilterBuilder(10_000_000, 0.01).buildBloomFilter();
        System.out.println(bf.add("http://github.com"));
        //Know in an instant which ones you have or have not seen before
        System.out.println(bf.contains("http://twitter.com"));
        System.out.println(bf.contains("http://github.com"));
    }

}
