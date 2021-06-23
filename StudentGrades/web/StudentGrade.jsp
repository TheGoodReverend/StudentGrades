<%-- 
    Document   : StudentGrade
    Created on : Feb 15, 2021, 2:36:55 PM
    Author     : KBowe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Grade</title>
    </head>
    <body>
        <h1>Results for : ${student.sid} ${student.lname} ${student.fname}</h1>
        <br>
        Q1 Score: ${student.q1} <br>
        Q2 Score: ${student.q2} <br>
        Q3 Score: ${student.q3} <br>
        Q4 Score: ${student.q4} <br>
        Q5 Score: ${student.q5} <br>
        QM Score: ${student.qm} <br>
        Quiz Average: ${student.quizAvg} <br>
        Hmwk Score: ${student.pr} <br>
        MidTerm Score: ${student.mt} <br>
        Final Exam: ${student.fe} <br> <br>
        Final Grade: ${student.finalGrade} <br>
        Letter Grade: ${student.letterGrade} <br>
        ${msg}
        <br>
        <a href="Students.jsp">Back to Student Input</a>
    </body>
</html>
