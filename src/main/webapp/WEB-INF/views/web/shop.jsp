<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp" %>
<c:url var="luuTinAPI" value="/api/home/luu-tin"/>

<section>
    <div class="container white">
        <div class="row">

            <div class="col-md-4" style="padding: 1rem;" >
                <div class="mb-5 new-details-shop">
                    <div class="row mb-3">
                        <div class="col-2">
                            <i class="fa fa-shopping-basket" style="font-size: 35px;" aria-hidden="true"></i>

                        </div>
                        <div class="col-7" style="display: flex; justify-content: left; align-items: center;">
                            <p class="fw-bold" >${shop.name}</p>
                        </div>
                        <div  class="col-3"style="display: flex; justify-content: left; align-items: center;" >
                            <button style="font-size: 11px;" class="btn btn-primary">5<i class="fa fa-star" aria-hidden="true"></i></button>
                        </div>

                    </div>
                    <div class="row">
                        <div   class="col-4 text-center">
                            <p>Cửa hàng</p>
                            <i class="fa fa-shopping-basket" aria-hidden="true"></i>
                        </div>
                        <div class="col-4 text-center">
                            <p>Đánh giá</p>
                            <p>--</p>
                        </div>
                        <div class="col-4 text-center">
                            <p>Phản hồi chat</p>
                            <p style="font-size: 11px;">Thường xuyên</p>
                        </div>

                    </div>
                    <div>
                        <button style="width: 100%;" class="mb-3 btn btn-success">${shop.phone}</button>
                    </div>
                    <div>
                        <button style="width: 100%; margin-bottom: 1rem; border: 2px solid #111111" class="btn btn-light">Chat với người bán</button>
                    </div>
                </div>
            </div>
            <div class="col-md-8" style="padding: 1rem;" >
                <div class="row gx-4 gx-lg-5 row-cols-1 row-cols-md-2 row-cols-xl-3 justify-content-center">
                    <c:forEach var="item" items="${products}">
                        <c:if test="${item.id != product.id}">
                            <div class="col mb-5">
                                <a href="<c:url value='/tin-dang/${item.id}'/>">
                                    <div class="card h-100 product-card">
                                        <!-- Product image-->
                                        <img class="card-img-top" src="/template/images/${item.images.get(0).link}"
                                             alt="..."/>
                                        <!-- Product details-->
                                        <div class="card-body canh-giua-flex-column">
                                            <div class="text-center">
                                                <!-- Product name-->
                                                <p class="">${item.name} </p>
                                                <!-- Product price-->
                                                <p class="fw-bold" style="color: red;">${item.price}</p>
                                            </div>
                                            <input type="hidden" name="productId" value="${item.id}">
                                            <button id="btn-luu${item.id}" onclick="savePost(${item.id})" class="btn btn-outline-danger
                                  <c:forEach var="like" items="${item.likes}">
                                    <c:if test="${like.user.id.equals(myUser.id)}">
                                        heart-luu
                                    </c:if>
                                  </c:forEach>
                                        "><i class="fa fa-heart-o" aria-hidden="true"></i></button>
                                        </div>
                                    </div>
                                </a>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
            </div>
        </div>
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

