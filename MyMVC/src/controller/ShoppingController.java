package controller;

import service.AtmService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShoppingController {
    public void kind(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        System.out.println("查询商品种类");
    }
    public void good(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        System.out.println("查询商品信息方法");
    }
}
