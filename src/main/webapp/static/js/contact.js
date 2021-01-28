
function buildTable() {
    $.getJSON('/api/contacts/', {ajax: true}, (data => {
        $.each(data, ((i, contact) => {
            var fullName = contact.firstName + ' ' + contact.lastName;
            console.log(fullName)
            $('#contact-table').find('tbody')
                .append('<tr>' +
                    '<td>' + contact.id + '</td>' +
                    '<td><a href="/contact/' + contact.id + '">' + fullName + '</a></td>' +
                    '<td>' + '<button class="btn btn-primary" onclick="editContact(' + contact.id +
                    ')">Edit</button>' +
                    '</td>' +
                    '<td>' +
                    '<button class="btn btn-danger" data-toggle="modal" data-target="#confirmDeleteModal"' +
                    ' data-record-id="' + contact.id + '">Delete</button>' +
                    '</td>' +
                    '</tr>');
        }));
    }));
}

function insertContact() {
    $('#contactId').val("");
    $('#contactVersion').val("");
    $('#inputFirstName').val("");
    $('#inputLastName').val("");

    $('#contactModal').modal('show');
}

function saveContact() {
    const id = $('#contactId').val();
    const version = $('#contactVersion').val();
    const firstName = $('#inputFirstName').val();
    const lastName = $('#inputLastName').val();

    const contact = {
        id: id,
        version: version,
        firstName: firstName,
        lastName: lastName,
    }
    console.log(contact);

    $.ajax({
        headers: {
            Accept: 'application/json',
            'Content-Type': 'application/json'
        },
        type: "post",
        url: "/api/contacts/",
        data: JSON.stringify(contact),
        dataType: "json",
        success: () => {
            window.location.reload();
        }


    })
}

function editContact(id) {
    $.getJSON('/api/contacts/' + id, {ajax: true},
        (contact) => {
            $('#contactId').val(contact.id);
            $('#contactVersion').val(contact.version);
            $('#inputFirstName').val(contact.firstName);
            $('#inputLastName').val(contact.lastName);
            $('#contactModal').modal('show');
        })
}

function deleteModal() {
    $('#confirmDeleteModal').on('click', '.btn-ok', function(e) {
        let $modalDiv = $(e.delegateTarget);
        let id = $(this).data('recordId');
        $.ajax({
            type: "DELETE",
            url: "/api/contacts/" + id,
            async: true,
            dataType: "json",
            success: function () {
                window.location.reload();
            },
            error: function () {
                alert("Error Deleting Contact");
            }
        })
    });

    $('#confirmDeleteModal').on('show.bs.modal', function(e) {
        let data = $(e.relatedTarget).data();
        $('.btn-ok', this).data('recordId', data.recordId);
    })
}