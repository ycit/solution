package com.ycit.poi;

import com.ycit.utils.POIUtils;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by xlch on 2016/12/30.
 */
public class WordToHtml {

    @Test
    public void wordToHtml() throws Exception {
        String path = "D:\\about project\\perp-service\\5812-1.doc";
//        String path = "D:\\about project\\perp-service\\11.docx";
        File file = new File(path);
        String content;
        String paths = "D:\\about project\\perp-service\\";
        FileInputStream in = new FileInputStream(file);
        if (".docx".equals(path.substring(path.lastIndexOf(".", path.length())))) {
            XWPFDocument document = new XWPFDocument(in);
            content = POIUtils.docXToHtml(document,paths);
        } else if (".doc".equals(path.substring(path.lastIndexOf(".", path.length())))) {
            HWPFDocument document = new HWPFDocument(in);
            content = POIUtils.docToHtml(document,paths);
        } else {
            throw new RuntimeException("文件格式不正确");
        }
        System.out.println(content);
    }
}
