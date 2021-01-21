<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp" %>
<%@include file="../../includes/subnav_admin.jsp" %>

<div class="wrapper">

    <%-- SideBar HERE --%>
    <%@include file="vehicle_sidebar.jsp" %>
    <div id="main-wrapper" class="col-sm-10 float-right">
        <div class="col-sm-12">

            <%--LIST OF EXISTING ELEMENTS--%>
                <form:form modelAttribute="vehicleDetails" action="/admin/vehicles/update/" method="POST"
                           cssClass="form-horizontal">
                    <div class="row">
                        <label class="col-form-label col-sm-1">Make Name: </label>
                        <div class="col-sm-8">
                                <%-- Gathered the list of Vehicle Makes for dyncamically generated dropdown--%>
                            <form:select path="vehicleModel.vehicleMake.vehicleMakeName"
                                         cssClass="col-sm-1 form-control">
                                <form:options items="${vehicleMakes}"></form:options>
                            </form:select>
                        </div>
                    </div>
                    <div class="row">
                            <label class="col-form-label col-sm-1">Model Name: </label>
                        <div class="col-sm-8">
                                <%-- Gathered the list of Vehicle Models for dyncamically generated dropdown--%>
                                <form:select path="vehicleModel.vehicleModelName" cssClass="col-sm-1 form-control">
                                    <form:options items="${vehicleModels}"></form:options>
                                </form:select>
                        </div>
                    </div>
                    <form:hidden path="vehicleId"></form:hidden>
                    <form:hidden path="version"></form:hidden>
                    <div class="row">
                            <label class="col-sm-1 col-form-label">Color: </label>
                        <div class="col-sm-8">
                            <form:input path="color" type="text" cssClass="form-control col-sm-4" />
                        </div>
                    </div>
                    <div class="row">
                            <label class="col-sm-1 col-form-label">Purchase Price: </label>
                        <div class="col-sm-8">
                            <form:input path="purchasePrice" type="text" cssClass="form-control col-sm-4" />
                        </div>
                    </div>
                    <div class="row">
                            <label class="col-sm-1 col-form-label">Date Purchased: </label>
                        <div class="col-sm-8">
                            <form:input path="purchaseDate" type="text" cssClass="form-control col-sm-4" />
                        </div>
                    </div>
                    <div class="row">
                            <label class="col-sm-1 col-form-label">VIN #: </label>
                        <div class="col-sm-8">
                            <form:input path="vin" type="text" cssClass="form-control col-sm-4" />
                        </div>
                    </div>
                    <div class="row">
                            <label class="col-sm-1 col-form-label">License Plate #: </label>
                        <div class="col-sm-8">
                            <form:input path="licensePlate" type="text" cssClass="form-control col-sm-4" />
                        </div>
                    </div>
                    <div class="row">
                            <label class="col-sm-1 col-form-label">Purchased: </label>
                        <div class="col-sm-4">
                                <%-- Testing whether the isPurchase field true or not and selecting the appropriate answer. --%>
                            <form:select path="isPurchase" cssClass="form-control col-sm-1">
                                <c:choose>
                                    <c:when test="${isPurchase}">
                                        <form:option value="Yes" selected="true"></form:option>
                                        <form:option value="No"></form:option>
                                    </c:when>
                                    <c:otherwise>
                                        <form:option value="Yes"></form:option>
                                        <form:option value="No" selected="true"></form:option>
                                    </c:otherwise>
                                </c:choose>
                            </form:select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-1">
                            <button class="btn btn-primary col-form-1">
                                Submit
                            </button>
                        </div>
                    </div>
            </form:form>
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
</div>

<%@include file="../../includes/footer.jsp" %>