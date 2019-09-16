package com.needhotel.controle;

import com.needhotel.modelo.dao.implementacao.ImovelDaoImpl;
import com.needhotel.modelo.domain.Imovel;
import com.needhotel.modelo.domain.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/buscar")
public class BuscaServlet extends HttpServlet {
    ImovelDaoImpl imovelDao = new ImovelDaoImpl();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        String search = req.getParameter("search");
        System.out.println("palavra" + search);
        List<Imovel> imoveis = imovelDao.buscarPorNome(search);
        imoveis.addAll(imovelDao.buscarPorCidade(search));
        System.out.println(imoveis);
        try {
            if (imoveis.isEmpty()) {
                System.out.println("entrou");
                req.setAttribute("imoveis", imoveis);
                req.getRequestDispatcher("busca.jsp").forward(req, resp);
            }
            else{
                req.setAttribute("imoveis", imoveis);
                req.getRequestDispatcher("busca.jsp").forward(req, resp);
            }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
