<%-- 
    Document   : listar.jsp
    Created on : Mar 18, 2022, 5:32:43 AM
    Author     : friend
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"
        import="java.util.*"
        import="modelo.Compania" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de Companias</title>
    </head>
    <body>
        <h1>Listagem de Companias</h1>
        <%
            
        int listando =0;
        // goncalves2007, pg 420
        ArrayList<Compania> registros = (ArrayList<Compania>) request.getAttribute("registros");
        int totalRegistros = (int) request.getAttribute("totalRegistros");
        int pagina = (int) request.getAttribute("pagina");
        int tamanhoPagina = (int) request.getAttribute("tamanhoPagina");
                 
        for (Compania i : registros) {
            listando++;
        %>

        <%= i.getId() %>, <%= i.getNome() %>, 
        <%= i.getSite() %>, <%= i.getFundacao() %> 
        
        | <a href="pessoa?op=d&q=<%= i.getId() %>">remover</a> | 
        <a href="pessoa?op=r&q=<%= i.getId() %>">exibir</a> | 
        <a href="pessoa?op=a&q=<%= i.getId() %>">atualizar</a> <br>
        <%
            }
        %>
<hr>
        Total de Registros: <%= totalRegistros%>
        Listando <%= listando%>
        <% if (pagina > 1) 
        {
            %>
            <a href="pessoa?op=p&p=<%= pagina-1 %>&t=<%= tamanhoPagina %>">Proxima Anterior</a>
            <%
        }
        %>
        Pagina atual <%= pagina%>
        <% if (totalRegistros > (pagina * tamanhoPagina)) 
        {
            %>
            <a href="pessoa?op=p&p=<%= pagina+1 %>&t=<%= tamanhoPagina %>">Proxima Pagina</a>
            <%
        }
        %>
        <hr>
        Fim da listagem

    </body>
</html>
