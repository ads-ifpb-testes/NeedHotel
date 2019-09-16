package com.needhotel.controle;

import com.needhotel.modelo.domain.Usuario;
import com.needhotel.modelo.dao.implementacao.UsuarioDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet( urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        doPost(req, resp);
    }

    protected void doPost (HttpServletRequest req, HttpServletResponse resp){

        UsuarioDaoImpl usuarioDaoImpl = new UsuarioDaoImpl();

        String email = req.getParameter("logEmail");
        String senha = req.getParameter("logSenha");

        try {
            Usuario user = usuarioDaoImpl.autenticacao(email, senha);
            System.out.println(user);
            if (user != null){
                HttpSession session = req.getSession();
                session.setAttribute("usuarioLogado", user);
                req.getRequestDispatcher("home.jsp").forward(req, resp);
            } else {
                req.setAttribute("statusAutenticacao", "Erro");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
