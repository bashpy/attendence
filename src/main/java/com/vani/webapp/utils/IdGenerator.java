package com.vani.webapp.utils;

import java.util.UUID;

/**
 * Created by vani on 16/8/16.
 */
public class IdGenerator {
    public static String createId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-","");
    }
}
