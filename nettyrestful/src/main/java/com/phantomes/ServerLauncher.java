package com.phantomes;

import com.phantomes.netty.RestServer;

public class ServerLauncher {
    public static void main(String[] args) {
        RestServer server=new RestServer();
        server.start();
    }
}
