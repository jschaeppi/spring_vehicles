<%@include file="../../../includes/header.jsp" %>
<%@include file="../../../includes/navbar.jsp" %>
<%@include file="../../../includes/subnav_admin.jsp" %>

<div class="wrapper">

    <%-- SideBar HERE --%>
    <%@include file="../vehicle_sidebar.jsp" %>
    <div id="main-wrapper" class="col-sm-10 float-right">
        <div class="col-sm-6">

            <%-- Editing an existing model --%>
            <form:form modelAttribute="vehicleModels" action="/admin/models/update" method="POST"
                       cssClass="form-inline">
                    <label class="col-form-label col-sm-1">Model: </label>
                    <div>
                        <form:input path="vehicleModelName" cssClass="form-control col-sm-5 text-center"/>
                    </div>
                <div>
                        <button class="btn btn-primary">
                            Submit
                        </button>
                </div>
            </form:form>
        </div>
    </div>
</div>

<%@include file="../../../includes/footer.jsp" %>