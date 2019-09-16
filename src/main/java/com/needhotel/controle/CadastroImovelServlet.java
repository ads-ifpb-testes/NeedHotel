package com.needhotel.controle;

import com.needhotel.modelo.dao.implementacao.ImovelDaoImpl;
import com.needhotel.modelo.domain.Imovel;
import com.needhotel.modelo.domain.Usuario;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;

@WebServlet("/cadastrarImovel")
@MultipartConfig
public class CadastroImovelServlet extends HttpServlet {

    protected void doGet (HttpServletRequest req, HttpServletResponse resp){
        HttpSession session = req.getSession();
        if(req.getParameter("voltar").equals("2")){
            Imovel imovel = (Imovel)session.getAttribute("etapa1");
            req.setAttribute("dadosEtapa1", imovel);
            try {
                req.getRequestDispatcher("cadastroImovel.jsp?etapaForm=1").forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        doPost(req, resp);
    }

    protected void doPost (HttpServletRequest req, HttpServletResponse resp){
        ImovelDaoImpl imovelDao = new ImovelDaoImpl();
        try {
            HttpSession session = req.getSession();
            if (req.getParameter("etapaForm").equals("1")){

                Imovel imovel = etapa1(req);
                System.out.println(imovel);
                session.setAttribute("etapa1", imovel);
                req.getRequestDispatcher("cadastroImovel.jsp?etapaForm=2").forward(req, resp);

            } else if (req.getParameter("etapaForm").equals("2")){

                Imovel imovel = (Imovel)session.getAttribute("etapa1");
                imovel.setDescricao(req.getParameter("descricaoImovel"));
                String[] lista = req.getParameterValues("comidadesImovel");

                if (ServletFileUpload.isMultipartContent(req)){
                    //Atribui a String o diretorio padrão onde as fotos serão armazenadas
                    String uploadPath = getServletContext().getRealPath("") + File.separator + "imagem";
                    File uploadDir = new File(uploadPath);

                    //Verifica se já existe o diretorio criado
                    if (!uploadDir.exists())
                        uploadDir.mkdir();


                    for (Part part : req.getParts()) {

                        //Verifica se possui um tipo
                        if (part.getContentType() != null){
                            //Guarda o nome original e a extenção ao qual o arquivo pertence
                            String fileName = getFileName(part);
                            //Defini um novo ao arquivo
                            String nomeFoto = "imovel-" + ZonedDateTime.now().toInstant().getEpochSecond() + fileName.substring(fileName.indexOf('.'));
                            //Escreve o arquivo ao diretorio definido em "uploadPath"
                            part.write(uploadPath + File.separator + nomeFoto);

                            imovel.setFoto(nomeFoto);
                        }
                    }
                }

                //Salva o imovelno banco
                imovelDao.cadastrarImovel(imovel);

                //Salva as comodidades no banco
                for (String comodidade : lista){
                    imovelDao.cadastrarComodidades(comodidade, imovel.getId());
                }

                session.setAttribute("etapa", null);
                req.getRequestDispatcher("home.jsp").forward(req, resp);
            }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Imovel etapa1(HttpServletRequest req) {
        Imovel imovel = new Imovel();
        HttpSession session = req.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        imovel.setProprietario(usuario.getCpf());
        imovel.setBairro(req.getParameter("bairroImovel"));
        imovel.setCep(req.getParameter("cepImovel"));
        imovel.setCidade(req.getParameter("cidadeImovel"));
        imovel.setEstado(req.getParameter("estadoImovel"));
        imovel.setValor(Float.valueOf(req.getParameter("valorImovel")));
        imovel.setNome(req.getParameter("nomeImovel"));
        imovel.setRua(req.getParameter("ruaImovel"));
        imovel.setNumero(req.getParameter("numeroImovel"));
        imovel.setDisponibilidade(true);
        return imovel;
    }

    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename"))
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
        }
        return "Default";
    }
}

