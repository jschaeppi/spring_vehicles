<%@include file="../../../includes/header.jsp" %>
<%@include file="../../../includes/navbar.jsp" %>
<%@include file="../../../includes/subnav_admin.jsp" %>

<div class="wrapper">

    <%-- SideBar HERE --%>
    <%@include file="../vehicle_sidebar.jsp" %>
    <div id="main-wrapper" class="col-sm-10 float-right">
        <div class="col-sm-12">

            <%--LIST OF EXISTING MAKES--%>

            <table class="table table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Vehicle Make</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="makes" items="${vehicleMakes}">
                    <tr>
                        <td>${makes.vehicleMakeId}</td>
                        <td>${makes.vehicleMakeName}</td>
                        <td><a href="/admin/makes/edit/${makes.vehicleMakeId}">Edit</a></td>
                        <td><a href="/admin/makes/delete/${makes.vehicleMakeId}">Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@include file="../../../includes/footer.jsp" %>