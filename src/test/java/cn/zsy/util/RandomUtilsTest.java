package cn.zsy.util;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class RandomUtilsTest {

    @Test
    public void testGenerateString() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println(RandomUtils.generateString(2));
        }
    }

    @Test
    public void testGenerateMixString() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println(RandomUtils.generateMixString(12));
        }
    }

    @Test
    public void testGenerateLowerString() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println(RandomUtils.generateLowerString(2));
        }
    }

    @Test
    public void testGenerateUpperString() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println(RandomUtils.generateUpperString(2));
        }
    }

    @Test
    public void testGenerateNumberString() throws Exception {
        for (int i = 0; i < 1000; i++) {
            System.out.println(RandomUtils.generateNumberString(1));
        }
    }

    @Test
    public void testGenerateRandom() throws Exception {
        for (int i = 0; i < 1000; i++) {
            System.out.println(RandomUtils.generateNumberInteger(9));
        }
    }
}