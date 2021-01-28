<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

<c:url value="../../static/js/address.js" var="address"></c:url>
<script src="${address}"></script>
<c:set value="${id}" var="contactId"></c:set>
<script >
    $().ready(() => {
        buildTable(${contactId});
        deleteModal();
    })
</script>

<div class="container">
    <h2>Contact Addresses</h2>

    <button onclick="insertAddress()" class="btn btn-secondary">Add New Address</button>
    <table id = "address-table" class="table table-striped table-hover">
        <thead>
        <th>ID</th>
        <th>Name</th>
        <th>Address</th>
        <th>Address2</th>
        <th>City</th>
        <th>State</th>
        <th>Zip</th>
        <th>Work Type</th>
        <th>Edit</th>
        <th>Delete</th>
        </thead>
        <tbody>

        </tbody>
    </table>

    <div id="contactModal" class="modal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Contact Details</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">

                    <form>
                        <fieldset>

                            <input type="hidden" id="contactId" value="${contactId}">
                            <hidden id="contactVersion"></hidden>
                            <hidden id="firstName"></hidden>
                            <hidden id="lastName"></hidden>
                            <hidden id="addressId"></hidden>
                            <hidden id ="addressVersion"></hidden>
                            <div class="form-group">
                                <label for="addressTypes">Address Type</label>
                                <select id="addressTypes" class="form-control">
                                    <option value="Home" id="Home">Home</option>
                                    <option value="Work" id="Work">Work</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="street">Address</label>
                                <input class="form-control" type="text" id="street" placeholder="Address" />
                                <label for="street2">Address 2</label>
                                <input class="form-control" type="text" id="street2" placeholder="Apt/Unit #" />
                            </div>
                            <div class="form-group">
                                <label for="city">City</label>
                                <input class="form-control" type="text" id="city" placeholder="City" />
                                <label for="state">State</label>
                                <input class="form-control" type="text" id="state" placeholder="State" />
                                <label for="zip">Zip</label>
                                <input class="form-control" type="text" id="zip" placeholder="Zip" />
                            </div>
                        </fieldset>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" onclick="saveAddress()" class="btn btn-primary">Save changes</button>
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
                            id="confirmDelete">Delete Address</button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
</div>



<%@include file="includes/footer.jsp" %>

