<%@ taglib prefix="d" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>
<html>
<head>
    <title>Dash Board</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" rel="stylesheet"
          type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link href="<c:url value='/template/admin/assets/css/sb-admin-2.min.css'/> " rel="stylesheet">
</head>
<body>
<!-- Page Wrapper -->
<div id="wrapper">

    <%@ include file="/common/admin/sidebar.jsp" %>
    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">
            <%@ include file="/common/admin/navbar.jsp" %>
            <!-- Begin Page Content -->
            <dec:body/>

            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->

        <%@ include file="/common/admin/footer.jsp" %>

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<script src="<c:url value='/template/admin/assets/js/sb-admin-2.min.js'/>"></script>
<script src="<c:url value='/template/admin/assets/vendor/chart.js/Chart.min.js'/>"></script>
<script src="<c:url value='/template/admin/assets/js/demo/chart-area-demo.js'/>"></script>
<script src="<c:url value="/template/admin/assets/js/demo/chart-pie-demo.js"/>"></script>
</body>
</html>
