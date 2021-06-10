<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<div class="container-wrapper">
    <div class="container product-padding">
        <div class="page-header">
            <h2>Gönderi Ekle</h2>
        </div>

        <form:form action="${pageContext.request.contextPath}/blog/addPost" method="post"
                   modelAttribute="blog" enctype="multipart/form-data">
            <form:hidden path="id" value="${blog.id}" />

            <div class="form-group">
                <label for="name">Title</label>
                <form:input path="title" id="name" class="form-Control" value="${blog.title}"/>
            </div>

            <div class="form-group">
                <label for="content">İçerik</label>
                <form:textarea path="content" id="content" class="form-Control" value="${blog.content}"/>
            </div>

            <br>

            <input type="submit" value="Submit" class="btn btn-primary">
            <a href="<c:url value="/profile" />" class="btn btn-primary">Cancel</a>
        </form:form>

    </div>
</div>
