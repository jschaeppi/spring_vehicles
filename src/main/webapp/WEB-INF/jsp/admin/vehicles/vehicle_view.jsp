<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp" %>
<%@include file="../../includes/subnav_admin.jsp" %>

<div class="wrapper">

    <%-- SideBar HERE --%>
    <%@include file="vehicle_sidebar.jsp" %>
    <div id="main-wrapper" class="col-sm-10 float-right">
        <div class="col-sm-12">

            <%--Vehicle full details view--%>

            <table class="table table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Vehicle Make</th>
                    <th>Vehicle Model</th>
                    <th>Color</th>
                    <th>Purchase Price</th>
                    <th>Purchase Date</th>
                    <th>VIN</th>
                    <th>License Plate</th>
                    <th>Purchased</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>

                    <tr>
                        <td><c:out value="${vehicleDetails.vehicleId}"></c:out></td>
                        <td><c:out value="${vehicleDetails.vehicleModel.vehicleMake.vehicleMakeName}"></c:out></td>
                        <td><c:out value="${vehicleDetails.vehicleModel.vehicleModelName}"></c:out></td>
                        <td><c:out value="${vehicleDetails.color}"></c:out></td>
                        <td><c:out value="${vehicleDetails.purchasePrice}"></c:out></td>
                        <td><c:out value="${vehicleDetails.purchaseDate}"></c:out></td>
                        <td><c:out value="${vehicleDetails.vin}"></c:out></td>
                        <td><c:out value="${vehicleDetails.licensePlate}"></c:out></td>
                        <c:choose>
                            <c:when test="${vehicleDetails.isPurchase}">
                                <td>Yes</td>
                            </c:when>
                            <c:otherwise>
                                <td>No</td>
                            </c:otherwise>
                        </c:choose>
                        <td><a href="/admin/vehicles/edit/${vehicleDetails.vehicleId}">Edit</a></td>
                        <td><a href="/admin/vehicles/delete/${vehicleDetails.vehicleId}">Delete</a></td>
                    </tr>
                </tbody>
            </table>
        </div>
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

<%@include file="../../includes/footer.jsp" %>