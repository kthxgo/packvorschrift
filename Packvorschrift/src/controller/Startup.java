/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import webservice.ZHHPACKVORSCHRIFTMT01Service;

/**
 *
 * @author kthxgo
 */
public class Startup {
    
    public static void main(String[] args) {
        Authenticator.setDefault(new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("wsuser", "123456".toCharArray());
            }
        });
        
        ZHHPACKVORSCHRIFTMT01Service service = new ZHHPACKVORSCHRIFTMT01Service();
        ZHHPACKVORSCHRIFTMT01Service pack = service.getZHHPackvorschriftMT01();
    }
    
}
