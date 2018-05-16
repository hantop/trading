package com.jinhui;

import com.github.jsonzou.jmockdata.JMockData;
import com.github.jsonzou.jmockdata.MockConfig;
import com.jinhui.api.entity.dto.BindCard;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/2/7 0007.
 */
public class Date2Test {


    @Test
    public void test0() throws Exception {


        MockConfig mockConfig = new MockConfig()
                .byteRange((byte) 0, Byte.MAX_VALUE)
                .shortRange((short) 0, Short.MAX_VALUE)
//                .intRange(0, Integer.MAX_VALUE)
                .intRange(0,20)
                .floatRange(0.0f, Float.MAX_EXPONENT)
                .doubleRange(0.0, Double.MAX_VALUE)
                .longRange(0, Long.MAX_VALUE)
                .dateRange("2018-01-01", "2018-12-30")
                .sizeRange(2, 3)
                .stringSeed("a", "b", "c")
                .charSeed((char) 97, (char) 98);

//        BindCard basicBean = JMockData.mock(BindCard.class, mockConfig);
//        System.out.println(basicBean);
        Date mock = JMockData.mock(Date.class, mockConfig);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(mock));

    }
}
