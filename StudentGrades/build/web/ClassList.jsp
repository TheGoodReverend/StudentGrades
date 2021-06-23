<%-- 
    Document   : ClassList
    Created on : Feb 15, 2021, 4:50:03 PM
    Author     : KBowen
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="business.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Class List</title>
    </head>
    <body>
        <h1>Class List</h1>
        
        <br>
        <table border ="1">
            <tr>
                <th>Student ID</th>
                <th>Last Name</th>
                <th>First Name</th>
                <th>Quiz 1</th>
                <th>Quiz 2</th>
                <th>Quiz 3</th>
                <th>Quiz 4</th>
                <th>Quiz 5</th>
                <th>Makeup Quiz</th>
                <th>Quiz Average</th>
                <th>Homework</th>
                <th>MidTerm</th>
                <th>Final</th>
                <th>Course Grade</th>
                <th>Letter Grade</th>
            </tr>
        
     <% ArrayList<Student> stulist = (ArrayList<Student>) request.getAttribute("stulist");
        if(stulist !=null){
     %>
        
      <%    
        for(int i = 0; i < stulist.size(); i++) //rows
        {   
            String[] grades = stulist.get(i).toString().split(",");
            //String placeholder = "";
      %>
            <tr>
            <td align="center"><%=grades[0] %></td>
            <td align="center"><%=grades[1] %></td>
            <td align="center"><%=grades[2] %></td>
            <td align="center"><%=grades[3] %>%</td>
            <td align="center"><%=grades[4] %>%</td>
            <td align="center"><%=grades[5] %>%</td>
            <td align="center"><%=grades[6] %>%</td>
            <td align="center"><%=grades[7] %>%</td>
            <td align="center"><%=grades[8] %>%</td>
            <td align="center"><%=grades[9] %>%</td>
            <td align="center"><%=grades[10] %>%</td>
            <td align="center"><%=grades[11] %>%</td>
            <td align="center"><%=grades[12] %>%</td>
            <td align="center"><%=grades[13] %>%</td>
            <td align="center"><%=grades[14] %></td>
            </tr>
      <%  
        }
      %>
        
        <%}
         
         %>
        <p>  </p>
        <%  %>
        <br>
        ${msg}
        
    </body>
</html>
