package com.ycit.utils;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.PicturesManager;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.usermodel.Picture;
import org.apache.poi.hwpf.usermodel.PictureType;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jsoup.Jsoup;
import org.springframework.util.CollectionUtils;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.List;

/**
 * Created by xlch on 2017/1/11.
 */
public class POIUtils {

    public static String docToHtml(HWPFDocument document, String path) throws Exception {
        WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument());
        wordToHtmlConverter.setPicturesManager(new PicturesManager() {
            @Override
            public String savePicture(byte[] content, PictureType pictureType, String suggestedName, float widthInches, float heightInches) {
                return suggestedName;
            }
        });
        wordToHtmlConverter.processDocument(document);
        List<Picture> pictures = document.getPicturesTable().getAllPictures();
        if (!CollectionUtils.isEmpty(pictures)) {
            for (Picture picture:pictures) {
                picture.writeImageContent(new FileOutputStream(path + picture.suggestFullFileName()));
            }
        }
        Document htmlDocument = wordToHtmlConverter.getDocument();
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        DOMSource domSource = new DOMSource(htmlDocument);
        StreamResult streamResult = new StreamResult(outStream);
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer serializer = tf.newTransformer();
        serializer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
        serializer.setOutputProperty(OutputKeys.INDENT, "yes");
        serializer.setOutputProperty(OutputKeys.METHOD, "html");
        serializer.transform(domSource, streamResult);
        outStream.close();
        return new String(outStream.toByteArray(), "utf-8");
    }

    /**
     * 处理表格会有点问题
     * @param document
     * @param path
     * @return
     * @throws IOException
     */
    public static String docXToHtml(XWPFDocument document, String path)throws IOException {
        XHTMLOptions options = XHTMLOptions.create();
        options.setIgnoreStylesIfUnused(false);
        options.setFragment(true);
        options.setExtractor(new FileImageExtractor(new File(path)));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        XHTMLConverter.getInstance().convert(document, out, options);
        String content = new String(out.toByteArray());
        org.jsoup.nodes.Document document1 = Jsoup.parse(content);
        return document1.html();
    }

    public static String getDocContent(String path) throws Exception {
        String docContent = "";
        File file = new File(path);
        FileInputStream in = new FileInputStream(file);
        if (".docx".equals(path.substring(path.lastIndexOf(".", path.length())))) {
            XWPFDocument document = new XWPFDocument(in);
            XWPFWordExtractor wordExtractor = new XWPFWordExtractor(document);
            docContent += wordExtractor.getText();
        } else if (".doc".equals(path.substring(path.lastIndexOf(".", path.length())))) {
            HWPFDocument document = new HWPFDocument(in);
            Range range = document.getRange();
            docContent += range.text();
        }else {
            throw new Exception("文件格式不正确");
        }
        return docContent;
    }
}
