package cl.tricotcorp.financial.totp.utils;

public abstract class Tools {

    public static String getSecretFromUri(String uri){

        String firts_secret = uri.split("secret=")[1];
        return firts_secret.split("&issuer")[0];
    }
}
