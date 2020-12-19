<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ include file="index.html" %>

<%if (request.getParameter("hiddenField") == "true") {%>
<jsp:forward page="result.html"/>
<%
    }
%>
