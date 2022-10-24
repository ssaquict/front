<%-- 
    Document   : index
    Created on : Oct 17, 2022, 8:54:53 PM
    Author     : SistemasU
--%>
<%@page import = "apis.api_empleados" %>
<%@page import="javax.swing.table.DefaultTableModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>FORMULARIO</h1>
        
    <table class="table table-striped">
    <thead>
      <tr>
        <th>Nombres</th>
        <th>Apellidos</th>
        <th>Direccion</th>
        <th>Telefono</th>
        <th>Puesto</th>
        <th>DPI</th>
        <th>Fecha Nacimiento</th>
        <th>Fecha Registro</th>
      </tr>
    </thead>
    <tbody>
            <%
            api_empleados api_c = new api_empleados();
            //System.out.println(api_c.get());
            DefaultTableModel tabla = new DefaultTableModel();
            tabla = api_c.leer();
            for (int t=0;t<tabla.getRowCount();t++){
                out.println("<tr>");
                out.println("<td>" + tabla.getValueAt(t, 1) + "</td>");
                out.println("<td>" + tabla.getValueAt(t, 2) + "</td>");
                out.println("<td>" + tabla.getValueAt(t, 3) + "</td>");
                out.println("<td>" + tabla.getValueAt(t, 4) + "</td>");
                out.println("<td>" + tabla.getValueAt(t, 5) + "</td>");
                out.println("<td>" + tabla.getValueAt(t, 6) + "</td>");
                out.println("<td>" + tabla.getValueAt(t, 7) + "</td>");
                out.println("<td>" + tabla.getValueAt(t, 8) + "</td>");
                out.println("</tr>");
                }
            
        %>     
      
    </tbody>
  </table>
    </body>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</html> 
