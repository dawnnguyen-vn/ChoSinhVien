<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp" %>

<section class="m-5">
    <div class="container white p-5">
        <form:form action="/dang-tin" method="post" modelAttribute="product" enctype="multipart/form-data">
            <div class="row">

                <div class="col-md-4">
                    <form:input class="mb-3" type="file" id="files" name="image_file_arr[]" multiple="multiple" path="image"/>
                    <br>
                    <output id="list-select-img"></output>
                </div>
                <div class="col-md-8">
<%--                    <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">--%>
<%--                        <option selected>Đồ điện tử - Âm thanh</option>--%>
<%--                        <option value="1">One</option>--%>
<%--                        <option value="2">Two</option>--%>
<%--                        <option value="3">Three</option>--%>
<%--                    </select>--%>
                    <form:input class="form-control form-control-lg" type="text" aria-label=".form-control-lg example" path="category"/>

                    <h4 class="mt-4">Giá</h4>
                    <form:input type="number" class="form-control" required="true" autofocus="true" path="price"/>
                    <h4 class="mt-4">Tiêu đề</h4>
                    <form:input class="form-control form-control-lg" type="text"
                           aria-label=".form-control-lg example" path="name"/>
                    <h4 class="mt-4">Mô tả chi tiết</h4>
                    <div>
                        <form:textarea class="form-control" id="exampleFormControlTextarea1" rows="3" path="description"></form:textarea>
                    </div>
                    <select class="form-select form-select-lg mt-4 mb-3" aria-label=".form-select-lg example">
                        <option selected>Địa chỉ</option>
                        <option value="1">One</option>
                        <option value="2">Two</option>
                        <option value="3">Three</option>
                    </select>
                    <div class="row mt-5">
                        <div class="col-6">
                            <button type="button" class="btn btn-outline-primary width-100">XEM TRƯỚC</button>
                        </div>
                        <div class="col-6">
                            <button type="submit" class="btn btn-primary width-100">ĐĂNG TIN</button>
                        </div>
                    </div>
                </div>


            </div>
        </form:form>
    </div>
</section>

