<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp" %>
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-light ">
    <div class="container px-4 px-lg-5">
        <a class="navbar-brand" href="<c:url value ='/'/>">
            <img src="/template/web/assets/csv-logo.png" alt="">
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">

            <form action="<c:url value="/search"/>" method="post" class="d-flex  form-inline my-2 my-lg-0">
                <input name="name" class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-primary active my-2 my-sm-0" type="submit">Search</button>
            </form>

            <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                <li class="nav-item me-1"><a class="nav-link" aria-current="page" href="<c:url value="/quan-ly-tin"/>"><i
                        class="fa fa-file-text" aria-hidden="true"></i> Quản lý tin</a></li>
                <li class="nav-item me-1"><a class="nav-link" href="#!"><i class="fa fa-commenting"
                                                                           aria-hidden="true"></i> Chat</a></li>
                <li class="nav-item me-1"><a class="nav-link" href="#!"><i class="fa fa-bell"
                                                                           aria-hidden="true"></i> Thông báo</a></li>
            </ul>

            <c:if test="${myUser != null}">
                <!-- sau khi dang nhap -->


                <li class="nav-item dropdown">

                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        <div class="canh-giua-start dang-nhap text-white">
                            <i class="fa fa-user-circle-o" style="font-size: 35px;" aria-hidden="true"></i>
                            <div style="color: #ffffff; white-space: nowrap; overflow: hidden; text-overflow: ellipsis; width: 100px;">${myUser.username}</div>
                        </div>
                    </a>

                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li>
                            <a class="dropdown-item canh-giua-start" href="<c:url value='/profile'/>">
                                <i class="fa fa-address-book me-1" style="color: royalblue; font-size: 30px;" aria-hidden="true"></i>
                                Trang cá nhân
                            </a>
                        </li>
                        <hr class="dropdown-divider"/>
                        <li>
                            <a class="dropdown-item canh-giua-start" href="<c:url value='/likes'/>">
                                <i class="fa fa-gratipay me-1" style="color: red; font-size: 30px;" aria-hidden="true"></i>
                                Tin đăng đã lưu
                            </a>
                        </li>

                        <li>
                            <a class="dropdown-item canh-giua-start" href="<c:url value='/history'/>"><i class="fa fa-list-alt me-1"
                                                                                  style="font-size: 30px;"
                                                                                  aria-hidden="true"></i>Lịch sử giao dịch</a>
                        </li>

                        <li><a class="dropdown-item canh-giua-start" href="#!"><i class="fa fa-users me-1"
                                                                                  style="color: royalblue; font-size: 25px;"
                                                                                  aria-hidden="true"></i>Bạn bè</a>
                        </li>
                        <hr class="dropdown-divider"/>
                        <li><a class="dropdown-item canh-giua-start" href="#!"><i class="fa fa-question-circle me-1"
                                                                                  style="font-size: 30px;"
                                                                                  aria-hidden="true"></i>Trợ giúp</a>
                        </li>

                        <li><a class="dropdown-item canh-giua-start" href="<c:url value='/logout'/>"><i class="fa fa-sign-out me-1"
                                                                                  style="font-size: 30px;"
                                                                                  aria-hidden="true"></i> Đăng xuất</a>
                        </li>
                    </ul>
                </li>

                <%--                <div class="me-3 mb-3 mt-3">--%>
                <%--                    <a href="profile.html">--%>
                <%--                        <div class="canh-giua-start dang-nhap text-white">--%>
                <%--                            <i class="fa fa-user-circle-o" style="font-size: 35px;" aria-hidden="true"></i>--%>
                <%--                            <div style="color: #ffffff; white-space: nowrap; overflow: hidden; text-overflow: ellipsis; width: 50px;">${myUser.name}</div>--%>
                <%--                        </div>--%>
                <%--                    </a>--%>
                <%--                </div>--%>
            </c:if>

            <c:if test="${myUser == null}">
                <!-- truoc khi dang nhap -->
                <div class="me-3 mb-3 mt-3">
                    <a href="<c:url value='/login'/> ">
                        <div class="canh-giua-start dang-nhap text-white">
                            <i class="fa fa-user-circle-o" style="font-size: 35px;" aria-hidden="true"></i>
                            <span class="mx-1">Đăng nhập</span>
                        </div>

                    </a>
                </div>
            </c:if>


            <div class="d-flex">
                <a href="<c:url value='/dang-tin'/>" class="btn btn-primary">
                    <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                    Đăng tin
                </a>
            </div>
        </div>
    </div>
</nav>