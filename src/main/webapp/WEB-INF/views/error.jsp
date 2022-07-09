<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp" %>
<h1>Error</h1>
<%--<img src="/template/images/a9cf31bb-3936-400a-b71d-4cce10f436d9Capture2.PNG" alt="">--%>

<c:catch var ="catchException">
    ${message.message}
</c:catch>

<c:if test = "${catchException != null}">
    Bạn không có quyền truy cập trang web này
</c:if>