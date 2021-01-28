<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

<c:url value="../../static/js/employee.js" var="employee"></c:url>
<script src="${employee}"></script>

<script >
    $().ready(() => {
        buildTable();
        deleteModal();
    })
</script>
<div class="container">
    <h2>Employee List</h2>

    <button onclick="insertEmployee()" class="btn btn-secondary">Add New Employee</button>
    <table id = "employee-table" class="table table-striped table-hover">
        <thead>
            <th>ID</th>
            <th>Name</th>
            <th>Background</th>
            <th>Projects</th>
            <th>Edit</th>
            <th>Delete</th>
        </thead>
        <tbody>

        </tbody>
    </table>

    <div id="employeeModal" class="modal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Employee Details</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">

                    <form>
                        <fieldset>

                            <hidden id="employeeId"></hidden>
                            <hidden id="employeeVersion"></hidden>
                            <div class="form-group">
                                <label for="inputFirstName" class="col-sm-2 col-form-label">First Name</label>
                                    <input type="text" class="form-control-plaintext" id="inputFirstName"
                                           placeholder="First Name" />
                            </div>
                            <div class="form-group">
                                <label for="inputLastName">Last Name</label>
                                <input type="email" class="form-control" id="inputLastName"
                                       aria-describedby="emailHelp" placeholder="Last Name" />
                            </div>
                            <div class="form-group">
                                <label for="background">Background</label>
                                <textarea class="form-control" id="background" rows="3"
                                          placeholder="Background"></textarea>
                            </div>
                        </fieldset>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" onclick="saveEmployee()" class="btn btn-primary">Save changes</button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>


            </div>
        </div>
    </div>

    <div id="confirmDeleteModal" class="modal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Confirm Delete</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <p>Are you sure you want to delete?  This cannot be undone!</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger btn-ok" data-dismiss="modal"
                            id="confirmDelete">Delete Employee</button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
</div>



<%@include file="includes/footer.jsp" %>

