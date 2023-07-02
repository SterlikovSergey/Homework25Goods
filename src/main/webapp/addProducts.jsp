
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adding orders page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<h1><%= " Добавить товар " %>
</h1>
<br/>
<form action="/products" method="post">
        <div class="mb-3">
            <label for="exampleInput" class="form-label">Код товара</label>
            <input type="text" class="form-control" id="exampleInput" name="productId" aria-describedby="orderIdHelp">
            <div id="orderIdHelp" class="form-text">Введите код товара.</div>
        </div>
        <div class="mb-3">
            <label for="exampleInputName" class="form-label">Наименование товара</label>
            <input type="text" class="form-control" id="exampleInputName" name="productName" aria-describedby="orderNameHelp">
            <div id="orderNameHelp" class="form-text">Введите наименование товара.</div>
        </div>
    <div class="mb-3">
        <label for="exampleInputCategory" class="form-label">Категория товара</label>
        <input type="text" class="form-control" id="exampleInputCategory" name="category" aria-describedby="orderCategoryHelp">
        <div id="orderCategoryHelp" class="form-text">Введите категорию товара 1, 2, Null.</div>
    </div>
        <button type="submit" class="btn btn-primary">Сохранить</button>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>
