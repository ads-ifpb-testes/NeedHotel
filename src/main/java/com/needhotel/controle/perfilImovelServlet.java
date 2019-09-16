package com.needhotel.controle;

import com.needhotel.modelo.dao.implementacao.ImovelDaoImpl;
import com.needhotel.modelo.dao.implementacao.UsuarioDaoImpl;
import com.needhotel.modelo.domain.Imovel;
import com.needhotel.modelo.domain.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/perfilImovel")
public class perfilImovelServlet extends HttpServlet {
    ImovelDaoImpl imovelDao = new ImovelDaoImpl();
    UsuarioDaoImpl usuarioDao = new UsuarioDaoImpl();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        try {
            String id = req.getParameter("id");
            Imovel imovel = imovelDao.buscarPorID(id);
            Usuario usuario = usuarioDao.buscarPorID(imovel.getProprietario());
            System.out.println(imovel.toString());
            req.setAttribute("imovel", imovel);
            req.setAttribute("usuario", usuario);
            req.getRequestDispatcher("perfilImovel.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
