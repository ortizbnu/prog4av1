package controlador;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import dao.CompaniaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import modelo.Compania;

/**
 *
 * @author friend
 */
@WebServlet(urlPatterns = {"/pessoa"})
public class CompaniaControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // DAO para ser usado no servlet
    CompaniaDAO pdao = new CompaniaDAO();

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // ações get:
        // sem parâmetro: recuperar todos os elementos
        // com parâmetro r: recuperar elemento individual
        // com parâmetro d: excluir elemento
        // com parâmetro f: abrir formulário de inclusão
        String op = request.getParameter("op");

        //String retrieve = request.getParameter("r");
        //String delete = request.getParameter("d");
        //String form = request.getParameter("f");
        if (op == null) { // exibe todos
           //
            int totalRegistros = pdao.retornarNumeroTotalCompanias(); 
            request.setAttribute("totalRegistros", totalRegistros);    
            // obtém dados
            ArrayList<Compania> registros = pdao.retornarCompanias(100,1);
            // insere no request
            request.setAttribute("registros", registros);
            
            request.setAttribute("pagina", 1);
            
            request.setAttribute("tamanhoPagina", 100);
            // encaminha a resposta 
            getServletContext().getRequestDispatcher("/listar.jsp").forward(request, response);
        } else if (op.equals("r")) { // exibe alguém específico
            // obtém o parâmetro de quem vai ser recuperado
            int quem = Integer.parseInt(request.getParameter("q"));
            // localiza o registro
            Compania p = pdao.buscarCompania(quem);
            // insere o registro como atributo na requisição
            request.setAttribute("alguem", p);
            // encaminha a resposta para a página exibir
            getServletContext().getRequestDispatcher("/exibir.jsp")
                    .forward(request, response);
        } else if (op.equals("d")) {
            int quem = Integer.parseInt(request.getParameter("q"));
            if (pdao.removerCompania(quem)) {
                request.setAttribute("msg", "Compania removida com sucesso");
            } else {
                request.setAttribute("msg", "Ocorreu algum erro ao excluir a pessoa");
            }
            getServletContext().getRequestDispatcher("/mensagem.jsp")
                    .forward(request, response);
        } else if (op.equals("f")) {
            getServletContext().getRequestDispatcher("/form.jsp")
                    .forward(request, response);
        } else if (op.equals("a")) { // a = atualização/GET = parte 1: 
            // abrir o formulário de edição
            // obtém o parâmetro de quem vai ser alterado
            int quem = Integer.parseInt(request.getParameter("q"));
            // localiza o registro
            Compania p = pdao.buscarCompania(quem);
            // insere o registro como atributo na requisição
            request.setAttribute("alguem", p);
            // encaminha para a página de alteração
            getServletContext().getRequestDispatcher("/form_editar.jsp")
                    .forward(request, response);
        }else if (op.equals("p"))
        {
            int pagina =  Integer.parseInt(request.getParameter("p"));
            int tamanhoPagina =  Integer.parseInt(request.getParameter("t"));
            
            int totalRegistros = pdao.retornarNumeroTotalCompanias(); 
            
            request.setAttribute("totalRegistros", totalRegistros);    
            // obtém dados
            ArrayList<Compania> registros = pdao.retornarCompanias(tamanhoPagina,pagina);
            // insere no request
            request.setAttribute("registros", registros);
            
            request.setAttribute("pagina", pagina);
            
            request.setAttribute("tamanhoPagina", tamanhoPagina);


            // encaminha a resposta 
            getServletContext().getRequestDispatcher("/listar.jsp").forward(request, response);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // configuração para corrigir questões de acento
        request.setCharacterEncoding("utf8");

        String op = request.getParameter("op");

        String cpf = request.getParameter("cpf");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");

        if (op == null) { // incluir pessoa é a opção padrão

            Compania nova = new Compania(cpf, nome, email, telefone);
            if (pdao.incluirCompania(nova)) {
                request.setAttribute("msg", "Compania incluída com sucesso");
            } else {
                request.setAttribute("msg", "Ocorreu um erro ao incluir a pessoa :-(");
            }
            getServletContext().getRequestDispatcher("/mensagem.jsp").forward(request, response);
            
        } else if (op.equals("put")) { // atualização de dados da pessoa

            Compania atualizada = new Compania(cpf, nome, email, telefone);
            if (pdao.atualizarCompania(atualizada)) {
                request.setAttribute("msg", "Compania atualizada com sucesso");
            } else {
                request.setAttribute("msg", "Ocorreu um erro ao atualizar a pessoa :-(");
            }
            getServletContext().getRequestDispatcher("/mensagem.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
