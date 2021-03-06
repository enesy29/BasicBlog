<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<main class="page blog-post-list">
    <section class="clean-block clean-blog-list dark">
        <div class="container product-padding">
            <div class="block-heading">
                <h2 class="text-info">Blog Yazıları</h2>
                <p> İster düşünceleriniz , ister gündelik yaşantınız istersenizde bilgilendirici metinleri blogunuzda yazarak paylaşabilirsiniz ! </p>
                <br>
            </div>

            <c:forEach items="${blog}" var="blog">
                <div class="block-content">
                    <div class="clean-blog-post">
                        <div class="row">
                            <c:if test="${empty blog.imageURL}">
                                <div class="col-lg-5"><img class="rounded img-fluid" src="resources/img/image4.jpg"></div>
                            </c:if>
                            <c:if test="${not empty blog.imageURL}">
                                <div class="col-lg-5"><img class="rounded img-fluid" src="${blog.imageURL}"></div>
                            </c:if>

                            <div class="col-lg-7">
                                <h3>${blog.title}</h3>
                                <div class="info"><span class="text-muted">${blog.create_date} by&nbsp;<a href="#">${fn:toUpperCase(blog.user.username)}</a></span></div>
                                <p>${blog.description}</p>
                                <a href="<c:url value="/blog/${blog.id}" />" class="btn btn-outline-primary btn-sm">Yazıya Git</a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </section>
</main>