package com.codefromscratch.httpserver;

import com.codefromscratch.httpserver.config.Configuration;
import com.codefromscratch.httpserver.config.ConfigurationManager;
import com.codefromscratch.httpserver.core.ServerListenerThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class HttpServer {

    private final static Logger LOGGER = LoggerFactory.getLogger(HttpServer.class);

    public static void main(String[] args) {
        LOGGER.info("Server starting...");

        ConfigurationManager.getInstance().loadConfigurationFile("src/main/resources/http.json");
        Configuration conf= ConfigurationManager.getInstance().getCurrentConfiguration();

        LOGGER.info("Using port: "+conf.getPort());
        LOGGER.info("Using WebRoot: "+conf.getWebroot());

        try {
            ServerListenerThread serverListenerThread = new ServerListenerThread(conf.getPort(),conf.getWebroot());
            serverListenerThread.start();
        } catch (IOException e) {
            e.printStackTrace();
            //TODO: handle later
        }
    }
}
