package com.bharath.ws.soap.config;

import org.apache.wss4j.common.ext.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.util.HashMap;

public class UTPPasswordCallback implements CallbackHandler {
    /// todo in memory db

    HashMap<String, String> userPassword = new HashMap<>();

    public UTPPasswordCallback() {
        userPassword.put("Karim", "123");
        userPassword.put("kn", "123");
    }

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {

        /// todo : callbacks have the username from incoming requests

        for(Callback callback: callbacks){
            WSPasswordCallback wsPasswordCallback = (WSPasswordCallback) callback;
            String password = userPassword.get(wsPasswordCallback.getIdentifier());
            if (password!=null){
                wsPasswordCallback.setPassword(password);
                return;
            }
        }

    }
}
