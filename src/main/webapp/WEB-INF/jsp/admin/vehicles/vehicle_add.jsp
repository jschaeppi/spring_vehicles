<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp" %>
<%@include file="../../includes/subnav_admin.jsp" %>

<script>

/*    $().ready(function() {
        $("#successAlert").delay(8000).fadeOut(2000);
        $("#warningAlert").delay(8000).fadeOut(2000);
    });*/
</script>
<div class="wrapper">

    <%-- SideBar HERE --%>
    <%@include file="vehicle_sidebar.jsp" %>

    <div id="main-wrapper" class="col-md-10 float-right">
        <div class="col-sm-8">
            <form:form modelAttribute="vehicleVO" action="/admin/vehicles/add" method="POST"
                       cssClass="form-horizontal">
                <div class="row">
                    <label class="col-form-label col-sm-2">Make Name: </label>
                    <div class="col-sm-8">
                        <%-- Gathered the list of Vehicle Makes for dyncamically generated dropdown--%>
                        <form:select path="vehicleMake"
                                     cssClass="col-sm-2 form-control" required="true">
                            <form:options items="${vehicleMakes}"></form:options>
                        </form:select>
                    </div>
                </div>
                <%-- Gathered the list of Vehicle Models for dyncamically generated dropdown--%>
                <div class="row">
                    <label class="col-form-label col-sm-2">Model Name: </label>
                    <div class="col-sm-8">
                        <form:select path="vehicleModel" cssClass="col-sm-2 form-control" required="true">
                            <form:options items="${vehicleModels}"></form:options>
                        </form:select>
                    </div>
                </div>
                <div class="row">
                    <label class="col-sm-2 col-form-label">Color: </label>
                    <div class="col-sm-8">
                        <form:input path="color" type="text" cssClass="form-control col-sm-4"  required="true"/>
                    </div>
                </div>
                <div class="row">
                    <label class="col-sm-2 col-form-label">Purchase Price: </label>
                    <div class="col-sm-8">
                        <form:input path="purchasePrice" type="number" cssClass="form-control col-sm-4"
                                    required="true" />
                    </div>
                </div>
                <div class="row">
                    <label class="col-sm-2 col-form-label">Date Purchased: </label>
                    <div class="col-sm-8">
                        <form:input path="purchaseDate" type="number" cssClass="form-control col-sm-4"
                                    required="true" />
                    </div>
                </div>
                <div class="row">
                    <label class="col-sm-2 col-form-label">VIN #: </label>
                    <div class="col-sm-8">
                        <form:input path="vin" type="text" cssClass="form-control col-sm-4" required="true" />
                    </div>
                </div>
                <div class="row">
                    <label class="col-sm-2 col-form-label">License Plate #: </label>
                    <div class="col-sm-8">
                        <form:input path="licensePlate" type="text" cssClass="form-control col-sm-4" required="true" />
                    </div>
                </div>
                <div class="row">
                    <label class="col-sm-2 col-form-label">Purchased: </label>
                    <div class="col-sm-4">
                        <form:select path="isPurchase" cssClass="form-control col-sm-2" required="true">
                            <form:option value="Yes" selected="true"></form:option>
                            <form:option value="No"></form:option>
                        </form:select>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-2">
                        <button class="btn btn-primary col-form-1">
                            Submit
                        </button>
                    </div>
                </div>
            </form:form>
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