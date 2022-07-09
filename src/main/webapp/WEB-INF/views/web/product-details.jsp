<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp" %>
<c:url var="luuTinAPI" value="/api/home/luu-tin"/>
<section >
    <div class="container white img-ad-top p-3">
        <img class="img-full-100" src="/template/web/assets/ad.jpg"  alt="">
    </div>

</section>
<section >
    <div class="container white">
        <div class="row ">
            <div class="col-md-8 p-3" >
                <div class="img-product-details display-container">
                    <c:forEach var="image" items="${product.images}">

                    <img class="mySlides3 img-full-100" src="/template/images/${image.link}" alt="">
                    </c:forEach>

                    <button class="image-button button-left" onclick="plusDivs(-1)">&#10094;</button>
                    <button class="image-button button-right" onclick="plusDivs(1)">&#10095;</button>

                    <div class="badge" style="width:100%">

                        <span class="image-badge" onclick="currentDiv(1)"></span>
                        <span class="image-badge" onclick="currentDiv(2)"></span>
                        <span class="image-badge" onclick="currentDiv(3)"></span>
                    </div>
                </div>
                <div style="margin-top: 1rem;">
                    <h4>${product.name}</h4>
                </div>
                <div style="margin-top: 1rem; display: flex; position: relative;">
                    <p class="fw-bold" style="color: red;">${product.price}đ</p>
                    <button style="right: 0; position: absolute;" type="button" class="btn btn-outline-danger">Lưu tin <i class="fa fa-heart-o" aria-hidden="true"></i></button>
                </div>
                <div style="margin-top: 1rem;">
                    <p>${product.description}</p>
                </div>
            </div>

            <div class="col-md-4" style="padding: 1rem;" >
                <div class="mb-5 new-details-shop">
                    <div class="row mb-3">
                        <div class="col-2">
                            <a href="">
                                <i class="fa fa-shopping-basket" style="font-size: 35px;" aria-hidden="true"></i>
                            </a>

                        </div>
                        <div class="col-6" style="display: flex; justify-content: left; align-items: center;">
                            <p class="fw-bold" >${product.user.name}</p>
                        </div>
                        <div  class="col-4"style="display: flex; justify-content: left; align-items: center;" >
                            <a href="<c:url value='/shop/${product.user.id}'/>" style="font-size: 11px;" class="btn btn-primary">Xem cửa hàng</a>
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
                        <button style="width: 100%;" class="mb-3 btn btn-success">${product.user.phone}</button>
                    </div>
                    <div>
                        <button style="width: 100%; margin-bottom: 1rem; border: 2px solid #111111" class="btn btn-light">Chat với người bán</button>
                    </div>
                </div>
                <div class="canh-giua" style=" width: 100%; height: auto;">
                    <img src="/template/web/assets/ad-vuong.jpg" alt="">
                </div>
            </div>
        </div>
    </div>
</section>

<section >
    <div class="container px-4 px-lg-5 mt-5 white pt-3">
        <h5 style="margin-bottom: 1rem;">Tin đăng tương tự</h5>
        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
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

    var slideIndex = 1;
    showDivs(slideIndex);

    function plusDivs(n) {
        showDivs(slideIndex += n);
    }

    function currentDiv(n) {
        showDivs(slideIndex = n);
    }

    function showDivs(n) {
        var i;
        var x = document.getElementsByClassName("mySlides3");
        var dots = document.getElementsByClassName("image-badge");
        if (n > x.length) {slideIndex = 1}
        if (n < 1) {slideIndex = x.length}
        for (i = 0; i < x.length; i++) {
            x[i].style.display = "none";
        }
        for (i = 0; i < dots.length; i++) {
            dots[i].className = dots[i].className.replace(" badge-white", "");
        }
        x[slideIndex-1].style.display = "block";
        dots[slideIndex-1].className += " badge-white";
    }


</script>

