package com.links.Personal.Links.util;

public class CheckObjectUtil {

    /*
     * return true object is content value
     * return false object is null
     * */
    public static <T> Boolean checkObject(T object) {

        if (object == null) return false;
        if (object instanceof String) {
            String str = String.valueOf(object);
            return !str.isEmpty() && !str.trim().isBlank();
        }

        return true;
    }

}
