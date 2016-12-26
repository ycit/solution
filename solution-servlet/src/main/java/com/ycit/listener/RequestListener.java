package com.ycit.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * Created by xlch on 2016/12/22.
 */
public class RequestListener implements ServletRequestListener,ServletRequestAttributeListener {

    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("attributeAdded event  run ....");
    }

    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        System.out.println("attributeRemoved event  run ....");
    }

    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.println("attributeReplaced event  run ....");
    }

    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("requestDestroyed event  run ....");
    }

    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("requestInitialized event  run ....");
    }
}
