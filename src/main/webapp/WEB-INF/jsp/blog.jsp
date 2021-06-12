<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<main class="page blog-post">
    <section class="clean-block clean-post dark">
        <div class="container">
            <div class="block-content">
                <div class="post-body">
                    <h3>${blog.title}</h3>
                    <div class="post-info"><span>${fn:toUpperCase(blog.user.username)}</span><span>${blog.create_date}</span></div>
                    <p>${blog.content}</p>
                    <c:if test="${not empty blog.imageURL}">
                        <div class="col-lg-5"><img class="rounded img-fluid" src="${blog.imageURL}"></div>
                    </c:if>
                    <c:if test="${empty blog.imageURL}">
                        <div class="col-lg-5"><img class="rounded img-fluid" src="resources/img/scenery/image3.jpg"></div>
                    </c:if>
                    <hr>
                </div>
            </div>
        </div>
    </section>
</main>