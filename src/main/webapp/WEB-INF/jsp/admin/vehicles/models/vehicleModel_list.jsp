<%@include file="../../../includes/header.jsp" %>
<%@include file="../../../includes/navbar.jsp" %>
<%@include file="../../../includes/subnav_admin.jsp" %>

<div class="wrapper">

    <%-- SideBar HERE --%>
    <%@include file="../vehicle_sidebar.jsp" %>
    <div id="main-wrapper" class="col-sm-10 float-right">
        <div class="col-sm-12">

            <%--LIST OF EXISTING MODELS--%>

            <table class="table table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Vehicle Model</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="models" items="${vehicleModels}">
                    <tr>
                        <td>${models.vehicleModelId}</td>
                        <td>${models.vehicleModelName}</td>
                        <td><a href="/admin/models/edit/${models.vehicleModelId}">Edit</a></td>
                        <td><a href="/admin/models/delete/${models.vehicleModelId}">Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <c:out value="${successAlert}"></c:out>
        <div class="col-sm-4">
            <%--SUCCESS ALERT--%>
            <div class="${successAlert == null ? 'hidden' : successAlert}" id="successAlert">
                <div class="alert alert-dismissible alert-success">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>Well done!</strong> Your vehicle successfully updated!
                </div>
            </div>
            <%--ERROR ALERT--%>
            <div class="${errorAlert == null ? 'hidden' : errorAlert }" id="errorAlert">
                <div class="alert alert-dismissible alert-danger">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>Well done!</strong> Your vehicle updated failed!
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="../../../includes/footer.jsp" %>