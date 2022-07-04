<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp" %>

<section>
    <div class="container white px-4 px-lg-4 mt-3 py-4">
        <c:forEach var="item" items="${bills}">
            <div class=" row gx-4 gx-lg-5 mb-4 justify-content-center">
                <div class="col-md-4">
                    <div class="p-3" style="background-color: #0097ff; color: #fff;" >
                        <div class="text-center" style="font-size: 20px;" > <b>Hóa đơn</b> </div>
                        <hr>

                        <c:forEach var="detail" items="${item.billDetails}">
                            <div class="d-flex mb-3" style="color: #fff;">
                                <div class="canh-giua">
                                    <span>${detail.servicePackDto.name}</span>
                                </div>
                                <div style="display: block; margin-left:  auto; margin-right: 0;">

                                    <span class="mx-2"><b>&times;${detail.quantity}</b> </span>
                                </div>
                            </div>
                        </c:forEach>

                        <hr>
                        <div style="font-size: 20px; color: #fff;">
                            Ngày giao dịch: ${item.timeDisplay()}
                        </div>
                        <div style="font-size: 20px; color: #fff;">
                            Tổng thanh toán:
                        </div>
                        <div style="font-size: 30px; color: #fff;" class ="mb-3">
                            <b>${item.amount}đ</b>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>

</section>