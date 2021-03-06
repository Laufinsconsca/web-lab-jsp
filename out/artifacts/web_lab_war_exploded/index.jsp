<%@ page import="model.CutStringRequest" %>
<jsp:useBean id="stringRequest" class="model.CutStringRequest" scope="session"/>
<jsp:setProperty name="stringRequest" property="*" />
<%@ page contentType="text/html;charset=UTF-8" %>
<%--<jsp:include page="index.html"/>--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <title>Лабораторная работа №3</title>
    <link rel="stylesheet" href="css/indexStyle.css">
</head>

<body>
<div class="wrapper">
    <form class="form" action="index.jsp" id="indexForm" method="post">
        <div class="pageTitle title">Удаление начальных символов</div>
        <div class="secondaryTitle title">Удаление начальных символов (первый аргумент – строка, второй – количество
            символов, которые надо удалить,
            результат – уменьшенная строка)
        </div>
        <label>
            <input type="text" id="inputString" class="inputString formEntry" name="inputString"
                   placeholder="Введите строку"/>
        </label>
        <label>
            <input type="text" id="cutLength" class="cutLength formEntry" name="cutLength"
                   placeholder="Введите число"/>
        </label>
        <button class="submit formEntry" type="submit" onclick="checkInputData()">Подтвердить</button>
        <input type="hidden" id="hiddenField">
<%--        <%--%>
<%--            if (request.getParameter("hiddenField") == "true") {--%>
<%--        %>--%>
<%--        <jsp:forward page="result.html"/>--%>
<%--        <%--%>
<%--            }--%>
<%--        %>--%>
        <%if (stringRequest.isOkStatus()){%>
        <jsp:forward page="result.html"/>
        <%}
        %>
    </form>
</div>

<script>
    function checkInputData() {
        var input = document.getElementById("cutLength");
        var num = input.value;
        var inputText = document.getElementById("inputString");
        var textString = inputText.value;
        var isValid1 = false;
        var isValid2 = false;
        if (num === "") {
            input.setCustomValidity("Введите число");
        } else if (num < 0) {
            input.setCustomValidity("Число не должно быть отрицательным");
        } else if (num > textString.length) {
            input.setCustomValidity("Число не должно превышать длину строки");
        } else if (num.indexOf(".") !== -1) {
            input.setCustomValidity("Введите целое число");
        } else {
            input.setCustomValidity("");
            isValid1 = true;
        }
        if (textString === "") {
            inputText.setCustomValidity("Строка не должна быть пустой");
        } else {
            inputText.setCustomValidity("");
            isValid2 = true;
        }
        document.getElementById("hiddenField").value = isValid1 && isValid2;
    }
</script>
</body>

</html>