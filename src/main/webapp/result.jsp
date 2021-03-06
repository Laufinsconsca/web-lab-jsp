<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="cutStringResponse" class="model.CutStringResponse" scope="session"/>
<html>
<%if (cutStringResponse == null) {%>
<meta http-equiv="refresh" content="5; URL=index.jsp"/>
<%
    }
%>
<head>
    <meta charset="UTF-8">
    <title>Лабораторная работа №3</title>
    <link rel="stylesheet" href="css/resultStyle.css">
</head>
<body>
<div class="wrapper">
    <form class="form" id="resultForm">
        <div class="title">Удаление начальных символов</div>
        <div class="name">Исходная строка:</div>
        <label>
            <input type="text" id="inputString" class="value" name="inputString" readonly/>
        </label>
        <div class="name">Количество обрезаемых символов:</div>
        <label>
            <input type="number" id="cutLength" class="value" name="cutLength" readonly/>
        </label>
        <div class="name">Полученная строка:</div>
        <label>
            <input type="text" id="outputString" class="value" name="outputString" readonly/>
        </label>
        <div class="resultButton"><a class="hrefColor" href="index.html">Возврат на исходную страницу</a></div>
        <div class="resultButton"><a class="hrefColor" href="result.xml" download>Скачать результат</a></div>
    </form>
</div>
</body>

<script type="text/javascript">
    document.getElementById('inputString').value = "<jsp:getProperty name="cutStringResponse" property="inputString"/>";
    document.getElementById('cutLength').value = "<jsp:getProperty name="cutStringResponse" property="cutLength"/>";
    document.getElementById('outputString').value = "<jsp:getProperty name="cutStringResponse" property="outputString"/>";
</script>


</html>
