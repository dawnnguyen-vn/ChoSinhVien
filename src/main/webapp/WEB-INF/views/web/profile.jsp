<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp" %>
<c:url var="editURL" value="/api/users/"/>
<section>
    <div class="container white mt-4 mb-4">
        <div class="row p-3">
            <div class="col-md-6" style="border-right: #e6e4e4 1px solid;">
                <div class="row">
                    <div class="col-3">
                        <div style="display: flex; justify-content: center; align-items: center">
                            <i  class="fa fa-user-circle-o" style="font-size: 60px;" aria-hidden="true"></i>
                        </div>
                    </div>
                    <div class="col-7">
                        <div class="row mb-1">
                            <div class="col-9">Tên: <b id="t-name">${user.name}</b></div>
                            <div class="col-3"><button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#m-name"><i class="fa fa-pencil" aria-hidden="true"></i></button></div>
                        </div>
                        <div class="row mb-1">
                            <div class="col-9">Số DT: <b id="t-phone">${user.phone}</b></div>
                            <div class="col-3"><button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#m-phone"><i class="fa fa-pencil" aria-hidden="true"></i></button></div>
                        </div>
                        <div class="row">
                            <div class="col-9">Dịa chỉ: <b id="t-address">${user.address}</b></div>
                            <div class="col-3"><button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#m-address"><i class="fa fa-pencil" aria-hidden="true"></i></button></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <p><i class="fa fa-star-o" aria-hidden="true"></i><b> Đánh giá: </b>chưa có đánh giá</p>
                <p><i class="fa fa-calendar" aria-hidden="true"></i><b> Ngày tham gia: </b>00/00/0000</p>
                <p><i class="fa fa-commenting-o" aria-hidden="true"></i><b> Phản hồi chat: </b>Chưa có thông tin</p>
            </div>
            <div class="col-md-2">
                <p>Số điểm hiện có: ${user.point} </p>
                <div class="d-flex">
                    <a href="<c:url value='/mua-diem'/>" class="btn btn-primary">
                        <i class="fa fa-money" aria-hidden="true"></i>
                        Mua điểm
                    </a>
                </div>
            </div>
        </div>
    </div>
<%--    model--%>

    <!-- Modal Name-->
    <div class="modal fade" id="m-name" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Tên mới</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input id="e-name" type="text" class="form-control">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="button" onclick="editName()" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal Phone-->
    <div class="modal fade" id="m-phone" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Số điện thoại mới</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input id="e-phone" type="text" class="form-control">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="button" onclick="editPhone()" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal Address-->
    <div class="modal fade" id="m-address" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Địa chỉ mới</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input id="e-address" type="text" class="form-control">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="button" onclick="editAddress()" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </div>
    </div>

<%--    model--%>





</section>

<section class="mb-4">
    <div class="container white p-3">
        <p><b>Tin đang đăng</b> - 0 tin</p>
        <hr>
        <div style="margin: 5rem 0;" class="canh-giua-flex-column">
            <div class="canh-giua text-center " style="width: 400px; height: 80px; background-color: #ffe9e9;">
                <span>Bạn chưa có tin đăng cá nhân nào đang bán, thử đăng bán ngay</span>
            </div>
            <a href="tin-dang.html" class="btn btn-primary mt-3">
                <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                Đăng tin
            </a>
        </div>
    </div>
</section>
<script>
    function editName() {
        const name = $('#e-name').val();
        $.ajax({
            url: '${editURL}'+${user.id} +"/name?name="+name,
            type: 'PUT',
            contentType: "application/json",
            success: function(result) {
                $('#t-name').text(name);
                $('#m-name').modal('hide');
            },
            error: function(request,msg,error) {
                console.log(error)
            }
        });

    }

    function editPhone() {
        const phone = $('#e-phone').val();
        $.ajax({
            url: '${editURL}'+${user.id} +"/phone?phone="+phone,
            type: 'PUT',
            contentType: "application/json",
            success: function(result) {
                $('#t-phone').text(phone);
                $('#m-phone').modal('hide');
            },
            error: function(request,msg,error) {
                console.log(error)
            }
        });
    }

    function editAddress() {
        const address = $('#e-address').val();
        $.ajax({
            url: '${editURL}'+${user.id} +"/address?address="+address,
            type: 'PUT',
            contentType: "application/json",
            success: function(result) {
                $('#t-address').text(address);
                $('#m-address').modal('hide');
            },
            error: function(request,msg,error) {
                console.log(error)
            }
        });
    }
</script>
