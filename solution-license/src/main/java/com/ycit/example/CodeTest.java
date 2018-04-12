package com.ycit.example;

import com.toptoken.keymgr.LicenseManager;
import net.java.truelicense.core.License;
import net.java.truelicense.core.LicenseConsumerContext;
import net.java.truelicense.core.LicenseConsumerManager;
import net.java.truelicense.core.LicenseManagementException;
import net.java.truelicense.core.io.Source;

import java.io.File;

/**
 * @author xlch
 * @Date 2018-04-12 14:00
 */
public class CodeTest {

    public static void main(String[] args) {
        String classPath = CodeTest.class.getClassLoader().getResource("").getPath();
        LicenseConsumerManager manager = LicenseManager.get();
        LicenseConsumerContext context = manager.context();
//        Source source = context.fileStore(new File(classPath + File.separator + "blps.lic"));
        Source source = context.fileStore(new File("D:\\workspace\\backstage-test\\blps_license\\blps.lic"));
        try {
            manager.install(source);
            License view = manager.view();
            String extra = view.getExtra().toString();
            System.out.println("========================");
            System.out.println(extra);
            System.out.println(view.getNotAfter());

            manager.verify();
            System.out.println("=============SUCCESS===========");
        } catch (LicenseManagementException e) {
            System.out.println("=============FAILTRUE===========");
            e.printStackTrace();
        }
    }

}
