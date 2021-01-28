
function buildTable() {
    $.getJSON('/api/employee/', {ajax: true}, (data => {
        $.each(data, ((i, single) => {
            var fullName = single.firstName + ' ' + single.lastName;
            console.log(fullName)
            $('#employee-table').find('tbody')
                .append('<tr>' +
                    '<td>' + single.id + '</td>' +
                    '<td>' + fullName + '</td>' +
                    '<td>' + single.background + '</td>' +
                    '<td>' + '<select class="form-control"><option>(SELECT PROJECT)</option></select>' + '</td>' +
                    '<td>' + '<button class="btn btn-primary" onclick="editEmployee(' + single.id +
                    ')">Edit</button>' +
                    '</td>' +
                    '<td>' +
                    '<button class="btn btn-danger" data-toggle="modal" data-target="#confirmDeleteModal"' +
                    ' data-record-id="' + single.id + '">Delete</button>' +
                    '</td>' +
                    '</tr>');
        }));
    }));
}

function insertEmployee() {
    $('#employeeId').val("");
    $('#employeeVersion').val("");
    $('#inputFirstName').val("");
    $('#inputLastName').val("");
    $('#background').val("");

    $('#employeeModal').modal('show');
}

function saveEmployee() {
    const id = $('#employeeId').val();
    const version = $('#employeeVersion').val();
    const firstName = $('#inputFirstName').val();
    const lastName = $('#inputLastName').val();
    const background = $('#background').val();

    const employee = {
        id: id,
        version: version,
        firstName: firstName,
        lastName: lastName,
        background: background,
        project: []

    }
    console.log(employee);

    $.ajax({
        headers: {
            Accept: 'application/json',
            'Content-Type': 'application/json'
        },
        type: "post",
        url: "/api/employee/",
        data: JSON.stringify(employee),
        dataType: "json",
        success: () => {
            window.location.reload();
        }


    })
}

function editEmployee(id) {
    $.getJSON('/api/employee/' + id, {ajax: true},
        (employee) => {
            $('#employeeId').val(employee.id);
            $('#employeeVersion').val(employee.version);
            $('#inputFirstName').val(employee.firstName);
            $('#inputLastName').val(employee.lastName);
            $('#background').val(employee.background);

            $('#employeeModal').modal('show');
        })
}

function deleteModal() {
    $('#confirmDeleteModal').on('click', '.btn-ok', function(e) {
        let $modalDiv = $(e.delegateTarget);
        let id = $(this).data('recordId');
            $.ajax({
                type: "DELETE",
                url: "/api/employee/" + id,
                async: true,
                dataType: "json",
                success: function () {
                    window.location.reload();
                },
                error: function () {
                    alert("Error Deleting Employee");
                }
            })
        });

        $('#confirmDeleteModal').on('show.bs.modal', function(e) {
            let data = $(e.relatedTarget).data();
            $('.btn-ok', this).data('recordId', data.recordId);
        })
}