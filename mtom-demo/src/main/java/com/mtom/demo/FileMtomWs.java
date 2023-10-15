package com.mtom.demo;

import javax.activation.DataHandler;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.io.IOException;

@WebService
public interface FileMtomWs {

    @WebMethod void uploadFile(@WebParam(name = "dataHandler") DataHandler dataHandler) throws IOException;
    DataHandler downloadFile();
}
