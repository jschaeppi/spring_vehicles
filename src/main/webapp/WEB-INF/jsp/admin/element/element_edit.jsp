<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp" %>
<%@include file="../../includes/subnav_admin.jsp" %>
<script>

    $().ready(function() {
       //attach an onclick to the remove buttons
       $('.removeButton').click(function() {
          console.log(this.name);
          console.log($('#' + this.name).val());
          $('#' + this.name).val();
          $('#' + this.name).val('');
          $('#elementType').submit();
       });
       //log name button and contents of associated text box

       //clear the value / contents of the text box

       //submit the form
    });
</script>
<div class="wrapper mt-4">

    <%-- SideBar HERE --%>
    <%@include file="element_sidebar.jsp" %>
    <div id="main-wrapper" class="col-md-11 float-right">
        <div class="col-sm-8">

            <c:set var="idx" value="0" scope="page"></c:set>
            <form:form class="form-horizontal" modelAttribute="elementType" action="/admin/element/update" method="POST">
                <form:hidden path="id" />
                <form:hidden path="version" />

                <div class="row">
                        <label for="inputElementTypeName" class="col-sm-2 col-form-label">Element Type</label>
                        <div class="col-sm-6">
                            <form:input path="elementTypeName" type="text" id="inputElementTypeName" cssClass="form-control" />
                        </div>
                </div>

                <div class="row">
                    <div class="col-sm-8">
                        <hr>
                    </div>
                </div>

                <c:forEach items="${elementType.elementList}" var="element">
                    <form:hidden path="elementList[${idx}].id"/>
                    <form:hidden path="elementList[${idx}].version"/>
                    <div class="row">
                            <label for="inputElement" class="col-sm-1 col-form-label">Element</label>
                            <div class="col-sm-7 col-md-8">
                                <form:input path="elementList[${idx}].elementName" id="${idx}" cssClass="form-control" />
                            </div>
                            <div>
                                    <button name="${idx}" class="btn btn-secondary removeButton">Remove</button>
                            </div>
                    </div>
                    <c:set var="idx" value="${idx+1}" scope="page" />
                </c:forEach>

                <div class="row">
                        <label for="inputElement" class="col-sm-2 col-form-label">New Element</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="inputNewElement" id="inputNewElement"/>
                        </div>
                </div>

                <div class="row">
                    <button class="btn btn-primary">Update</button>
                </div>
            </form:form>
        </div>
        <div class="col-sm-4">
            <c:out value="${successAlert}"></c:out>
            <%--SUCCESS ALERT--%>
                <div class="${successAlert == null ? 'hidden' : successAlert}" id="successAlert">
                    <div class="alert alert-dismissible alert-success">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <strong>Well done!</strong> You successfully read <a href="#" class="alert-link">this important alert message</a>.
                    </div>
                </div>
                <%--WARNING ALERT--%>
                <div class="${warningAlert == null ? 'hidden' : warninglert }" id="warningAlert">
                    <div class="alert alert-dismissible alert-warning">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <strong>Well done!</strong> You successfully read <a href="#" class="alert-link">this important alert message</a>.
                    </div>
                </div>
                <%--ERROR ALERT--%>
                <div class="${errorAlert == null ? 'hidden' : errorAlert }" id="errorAlert">
                    <div class="alert alert-dismissible alert-danger">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <strong>Well done!</strong> You successfully read <a href="#" class="alert-link">this important alert message</a>.
                    </div>
                </div>
    </div>
</div>

<%@include file="../../includes/footer.jsp" %>