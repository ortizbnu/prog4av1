<%-- 
    Document   : form
    Created on : Mar 17, 2022, 3:09:25 PM
    Author     : friend
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"
        import="modelo.Compania" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Compania</title>
    </head>
    <body>
        <h1>Editar pessoa</h1>
        <%
        Compania i = (Compania) request.getAttribute("alguem");
        %>

        <form action="pessoa?op=put" method="post">
            ID: <input type="text" name="cpf" value="<%= i.getId() %>" readonly> <br>
            Nome: <input type="text" name="nome" value="<%= i.getNome() %>"> <br>
            Site: <input type="text" name="email" value="<%= i.getSite() %>"> <br>
            Fundacao: <input type="text" name="telefone" value="<%= i.getFundacao() %>"> <br>
            <input type="submit" value="Atualizar">
        </form>
    </body>
</html>
