package com.ycit.controller;

import com.google.common.base.Splitter;
import com.sun.corba.se.spi.orbutil.fsm.Input;
import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.ParserException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by xlch on 2016/12/27.
 */
@Controller
@RequestMapping("/api/file")
public class FileController {

    @RequestMapping("/home")
    public String home() {
        return "/file";
    }

    @RequestMapping(value = "/upload/htmlparser",method = RequestMethod.POST)
    public void upload(@RequestParam("file") MultipartFile file) {
        String type = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String newFilename = System.currentTimeMillis() + type;
        String path = "d:\\\\temp"+ "\\" + newFilename;
        File file1 = new File(path);
        try {
            file.transferTo(file1);
            Parser parser = new Parser(path);
            int times = 1;
            for (NodeIterator i = parser.elements (); i.hasMoreNodes(); ) {
                Node node = i.nextNode();
                System.out.println("==========begin==============");
                System.out.println(times);
                System.out.println("getText:         "+node.getEndPosition());
                System.out.println("getText:         "+node.getText());
                System.out.println("toHtml:       "+node.toHtml());
                System.out.println("toHtml(true):     "+node.toHtml(true));
                System.out.println("toHtml(false):       "+node.toHtml(false));
                System.out.println("toString:        "+node.toString());
                System.out.println("===========end=============");
                times++;
            }
        } catch (IOException |ParserException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/upload/jsoup")
    public void jsoup(@RequestParam("file") MultipartFile file) {
        String type = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String newFilename = System.currentTimeMillis() + type;
        String path = "d:\\\\temp"+ "\\" + newFilename;
        File file1 = new File(path);
        try {
            file.transferTo(file1);
            Document document = Jsoup.parse(file.getInputStream(),"utf-8","");
            String text = document.body().text();
            List<String> list = Splitter.on(" ").splitToList(text);
            for (String s:list) {
                System.out.println("========" + s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
