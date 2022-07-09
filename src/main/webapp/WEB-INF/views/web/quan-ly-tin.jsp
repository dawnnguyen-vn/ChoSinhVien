<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp" %>

<div class="container white px-4 px-lg-4 mt-3 py-4">

    <ul class="nav nav-tabs canh-giua" id="myTab" role="tablist">
        <li class="nav-item" role="presentation">
            <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#home" type="button" role="tab" aria-controls="home" aria-selected="true">Đang hiển thị</button>
        </li>
        <li class="nav-item" role="presentation">
            <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile" type="button" role="tab" aria-controls="profile" aria-selected="false">Bị từ chối</button>
        </li>
        <li class="nav-item" role="presentation">
            <button class="nav-link" id="contact-tab" data-bs-toggle="tab" data-bs-target="#contact" type="button" role="tab" aria-controls="contact" aria-selected="false">Tin nháp</button>
        </li>
    </ul>
    <div class="tab-content " id="myTabContent">
        <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
            <c:forEach var="item" items="${products}">
            <div class="card my-3 ">
                <div class="row g-0">
                    <div class="col-md-2">
                        <img src="/template/images/${item.images.get(0).link}" class="img-fluid rounded-start" alt="...">
                    </div>
                    <div class="col-md-10">
                        <div class="card-body">
                            <h5 class="card-title">${item.name}</h5>
                            <p class="card-text">${item.description}</p>
                            <div class="row">
                                <div class="col-sm-6">
                                    <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
                                </div>
                                <div class="col-sm-6 canh-giua-end">
                                    <form action="<c:url value='/${item.id}/remove'/>" method="post">
                                        <button type="submit" class="btn btn-outline-danger me-3">Xóa</button>
                                    </form>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            </c:forEach>

        </div>
        <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">

        </div>
        <div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="contact-tab">

        </div>
    </div>
</div>
