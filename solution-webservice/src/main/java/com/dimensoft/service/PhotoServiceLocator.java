/**
 * PhotoServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dimensoft.service;

public class PhotoServiceLocator extends org.apache.axis.client.Service implements PhotoService {

    public PhotoServiceLocator() {
    }


    public PhotoServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PhotoServiceLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for PhotoServicePort
    private String PhotoServicePort_address = "http://10.35.128.109:8180/psb/PhotoService";

    public String getPhotoServicePortAddress() {
        return PhotoServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private String PhotoServicePortWSDDServiceName = "PhotoServicePort";

    public String getPhotoServicePortWSDDServiceName() {
        return PhotoServicePortWSDDServiceName;
    }

    public void setPhotoServicePortWSDDServiceName(String name) {
        PhotoServicePortWSDDServiceName = name;
    }

    public PhotoServicePortType getPhotoServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PhotoServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPhotoServicePort(endpoint);
    }

    public PhotoServicePortType getPhotoServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            PhotoServiceSoapBindingStub _stub = new PhotoServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getPhotoServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPhotoServicePortEndpointAddress(String address) {
        PhotoServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (PhotoServicePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                PhotoServiceSoapBindingStub _stub = new PhotoServiceSoapBindingStub(new java.net.URL(PhotoServicePort_address), this);
                _stub.setPortName(getPhotoServicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        String inputPortName = portName.getLocalPart();
        if ("PhotoServicePort".equals(inputPortName)) {
            return getPhotoServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.dimensoft.com/", "PhotoService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.dimensoft.com/", "PhotoServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {

if ("PhotoServicePort".equals(portName)) {
            setPhotoServicePortEndpointAddress(address);
        }
        else
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
