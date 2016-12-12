package com.dimensoft.service;

import java.rmi.RemoteException;

import com.dimensoft.service.PhotoServicePortTypeProxy;

public class Demo {
	public static void main(String[] args) {
		PhotoServicePortTypeProxy port = new PhotoServicePortTypeProxy();
		try {
//			String[] res = port.queryPhot
			System.out.println(port.queryPhotoZpInfo("'341222198710189552'"));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
