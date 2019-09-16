package com.needhotel.controle;

import com.needhotel.modelo.dao.implementacao.ImovelDaoImpl;
import com.needhotel.modelo.domain.Imovel;
import com.needhotel.modelo.domain.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/meus-imoveis")
public class ListarImoveisServlet extends HttpServlet {

    protected void doGet (HttpServletRequest req, HttpServletResponse resp){
        ImovelDaoImpl imovelDao = new ImovelDaoImpl();
        HttpSession session = req.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");

        List<Imovel> imoveis = imovelDao.buscaPorUsuario(usuario.getCpf());

        req.setAttribute("imoveis", imoveis);
        try {
            req.getRequestDispatcher("listarImoveis.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
