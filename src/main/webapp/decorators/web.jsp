<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <title>Trang chủ</title>
    <%--    font-awesome--%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <%--    bootstrap--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <%--    css--%>
    <link href="<c:url value='/template/web/css/styles.css'/>" rel="stylesheet"/>
    <link href="<c:url value='/template/web/css/web.css'/>" rel="stylesheet"/>
<%--    jquery--%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <style>
        .mySlides3 {display:none; width:100%}
        .display-container{position:relative}

        /*---Css Nút qua lại---*/
        .button-left{left:1%; font-size:20px}
        .button-right{right:1%; font-size:20px }
        .image-button{border:none;display:inline-block;padding:10px;height:50px;vertical-align:middle;overflow:hidden; color:#fff;background:#000;position:absolute;top:calc(50% - 25px); opacity:0.5;}
        .image-button:hover{color:#000;background:#ccc;}

        /*---Css Chấm tròn---*/
        .badge {text-align:center; margin-bottom:16px; font-size:20px;position:absolute;bottom:0;}
        .badge-white{color:#000!important;background-color:#fff!important}
        .image-badge {display:inline-block;border-radius:50%;height:14px;width:14px; border:1px solid #ccc;}
        .image-badge:hover{background:#fff;}

    </style>

</head>
<body class="grey">

<%@ include file="/common/web/header.jsp" %>

<dec:body/>

<%@ include file="/common/web/footer.jsp" %>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
<script src="<c:url value='/template/web/js/scripts.js'/>"></script>
<script src="<c:url value='/template/web/paging/jquery.twbsPagination.js'/>" type="text/javascript"></script>
</body>
</html>
