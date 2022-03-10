package com.sofka.util;

/**
 * Class to manage response in the controller
 *
 * @version 1.0.0 2022/03/09
 * @author Ricardo Ortega - tattortega.28@gmail.com
 * @since 1.0.0
 */
public class Response {
    public Boolean error = false;
    public String message = "";
    public String status = "OK";
    public Object data;
}
