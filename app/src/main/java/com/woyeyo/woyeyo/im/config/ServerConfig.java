package com.woyeyo.woyeyo.im.config;

final class ServerConfig {

    public enum ServerEnv {
        TEST("t"),
        PRE_REL("p"),
        REL("r"),

        ;
        String tag;

        ServerEnv(String tag) {
            this.tag = tag;
        }
    }

    public static boolean testServer() {
        return ServerEnvs.SERVER == ServerEnv.TEST;
    }
}
