<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Authorization page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<h1><%= "Пройди авторизацию " %>
</h1>
<br/>
<form action="/login" method="post">
    <form>
        <div class="mb-3">
            <label for="exampleInput" class="form-label">Имя пользователя</label>
            <input type="text" class="form-control" id="exampleInput" name="login" aria-describedby="orderIdHelp">
            <div id="orderIdHelp" class="form-text">Введите имя пользователя.</div>
        </div>
        <button type="submit" class="btn btn-primary">Войти</button>
    </form>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>