<%@include file="../../../includes/header.jsp" %>
<%@include file="../../../includes/navbar.jsp" %>
<%@include file="../../../includes/subnav_admin.jsp" %>

<div class="wrapper">

    <%-- SideBar HERE --%>
    <%@include file="../vehicle_sidebar.jsp" %>
    <div id="main-wrapper" class="col-sm-10 float-right">
        <div class="col-sm-12">

            <%-- Editing an existing make --%>
            <form:form modelAttribute="vehicleMakes" action="/admin/makes/update" method="POST"
                       cssClass="form-horizontal">
                <form:hidden path="vehicleMakeId"></form:hidden>
                <form:hidden path="version"></form:hidden>
                <div class="row">
                    <label class="col-sm-1 col-form-label">Make </label>
                    <div class="col-sm-8">
                        <form:input path="vehicleMakeName" type="text" cssClass="form-control col-sm-4" />
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
        </div>
    </div>
</div>

<%@include file="../../../includes/footer.jsp" %>