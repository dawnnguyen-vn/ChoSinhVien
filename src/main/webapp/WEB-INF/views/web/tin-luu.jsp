<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp" %>

<section>
    <div class="container white px-4 px-lg-4 mt-3 py-4">
        <c:forEach var="item" items="${products}">
            <a href="<c:url value='/tin-dang/${item.id}'/>">
                <div class="card my-3 ">
                    <div class="row g-0">
                        <div class="col-md-2">
                            <img src="/template/images/${item.images.get(0).link}" class=" img-fluid rounded-start"
                                 alt="...">
                        </div>
                        <div class="col-md-10">
                            <div class="card-body">
                                <h5 class="card-title">${item.name}</h5>
                                <p class="card-text">${item.description}</p>
                            </div>
                        </div>
                    </div>

                </div>
            </a>

        </c:forEach>
    </div>
</section>


<script>
    function savePost(id) {
        event.stopPropagation();
        event.preventDefault();
        $.ajax({
            url: "${luuTinAPI}",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(id),
            success: function (data) {
                if (data !== '') {
                    window.location.replace("${login}");
                }
                $("#btn-luu" + id).toggleClass("heart-luu");
            },

            error: function (error) {
                alert("error");
            }
        });

    };
</script>

