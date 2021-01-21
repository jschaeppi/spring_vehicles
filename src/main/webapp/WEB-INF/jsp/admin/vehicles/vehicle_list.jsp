<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp" %>
<%@include file="../../includes/subnav_admin.jsp" %>

<div class="wrapper">

    <%-- SideBar HERE --%>
    <%@include file="vehicle_sidebar.jsp" %>
    <div id="main-wrapper" class="col-sm-10 float-right">
        <div class="row col-sm-12 row-cols-2">
            <div class="col input-group">
                <%-- Add Make form--%>
                <form:form modelAttribute="addMake" cssClass="form-horizontal form-inline" action="/admin/makes/add"
                           method="POST">
                        <label class="col-form-label-lg">New Make: </label>
                    <div>
                        <form:input path="vehicleMake" type="text" cssClass="form-control" required="true"/>
                    </div>
                    <div>
                        <form:button>Add Make</form:button>
                    </div>
                </form:form>
            </div>
            <div class="col input-group">
                <%-- Add models form--%>
                <form:form modelAttribute="addModel" cssClass="form-horizontal form-inline"
                           action="/admin/models/add"
                       method="POST">
                        <label class="col-form-label-lg">New Model: </label>
                        <form:input path="vehicleModelName" cssClass="form-control" required="true"/>
                        <form:select path="vehicleMakeName" cssClass="form-control">
                            <form:options items="${vehicleMakes}"
                                          cssClass="col-sm-3"
                                          required="true"></form:options>
                        </form:select>
                        <form:button cssClass="col-sm-2" >Add Model</form:button>
                </form:form>
            </div>
        </div>
        <div class="col-sm-12">
            <%--LIST OF EXISTING VEHICLES--%>

            <table class="table table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Vehicle Make</th>
                    <th>Vehicle Model</th>
                    <th>Vehicle License Plate</th>
                    <th>Vehicle Details</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="vehicleDetails" items="${allVehicles}">
                                <tr>
                                        <td>${vehicleDetails.vehicleId}</td>
                                        <td>${vehicleDetails.vehicleModel.vehicleMake.vehicleMakeName}</td>
                                        <td>${vehicleDetails.vehicleModel.vehicleModelName}</td>
                                        <td>${vehicleDetails.licensePlate}</td>
                                        <td><a href="/admin/vehicles/vehicle/${vehicleDetails.vehicleId}">View
                                            Details</a></td>
                                        <td><a href="/admin/vehicles/edit/${vehicleDetails.vehicleId}">Edit</a></td>
                                        <td><a href="/admin/vehicles/delete/${vehicleDetails.vehicleId}">Delete</a></td>
                                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@include file="../../includes/footer.jsp" %>