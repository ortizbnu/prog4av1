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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Exibir Compania</h1>
        <%
            
        // goncalves2007, pg 420
        Compania i = (Compania) request.getAttribute("alguem");
                 
        %>

        ID: <%= i.getId() %> <br> 
        Nome: <%= i.getNome() %> <br>
        Site: <%= i.getSite() %> <br>
        Fundacao: <%= i.getFundacao() %> 
        
        <a href="pessoa?d=<%= i.getId() %>">remover</a><br>
        

       

    </body>
</html>
