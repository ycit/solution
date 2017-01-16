package com.ycit.poi;

import com.ycit.utils.POIUtils;
import org.junit.Test;

/**
 * Created by xlch on 2017/1/11.
 */
public class DocContentTest {

    @Test
    public void docTest()throws Exception{
        String path = "D:\\about project\\perp-service\\5812-1.doc";
//        String path = "D:\\about project\\perp-service\\5812-1.docx";
        String content = POIUtils.getDocContent(path);
        System.out.println(content);
    }

}
