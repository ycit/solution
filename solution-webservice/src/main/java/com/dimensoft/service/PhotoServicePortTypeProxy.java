package com.dimensoft.service;

public class PhotoServicePortTypeProxy implements PhotoServicePortType {
  private String _endpoint = null;
  private PhotoServicePortType photoServicePortType = null;

  public PhotoServicePortTypeProxy() {
    _initPhotoServicePortTypeProxy();
  }

  public PhotoServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initPhotoServicePortTypeProxy();
  }

  private void _initPhotoServicePortTypeProxy() {
    try {
      photoServicePortType = (new PhotoServiceLocator()).getPhotoServicePort();
      if (photoServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)photoServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)photoServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }

    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }

  public String getEndpoint() {
    return _endpoint;
  }

  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (photoServicePortType != null)
      ((javax.xml.rpc.Stub)photoServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);

  }

  public PhotoServicePortType getPhotoServicePortType() {
    if (photoServicePortType == null)
      _initPhotoServicePortTypeProxy();
    return photoServicePortType;
  }

  public String queryPhotoZpInfo(String arg0) throws java.rmi.RemoteException{
    if (photoServicePortType == null)
      _initPhotoServicePortTypeProxy();
    return photoServicePortType.queryPhotoZpInfo(arg0);
  }

  public String queryPhotoInfo(String arg0, String arg1) throws java.rmi.RemoteException{
    if (photoServicePortType == null)
      _initPhotoServicePortTypeProxy();
    return photoServicePortType.queryPhotoInfo(arg0, arg1);
  }


}
